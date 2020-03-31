package com.loancash.loancash.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.loancash.loancash.entity.Bankacc;
import com.loancash.loancash.entity.Banks;
import com.loancash.loancash.entity.CreditHistory;
import com.loancash.loancash.entity.GeneratedCode;
import com.loancash.loancash.entity.Level;
import com.loancash.loancash.entity.NextAmount;
import com.loancash.loancash.entity.PhoneNumbers;
import com.loancash.loancash.entity.SelectedOption;
import com.loancash.loancash.entity.ServiceOptions;
import com.loancash.loancash.entity.Settings;
import com.loancash.loancash.entity.TransferRecipientEntity;
import com.loancash.loancash.model.CompleteTransferModel;
import com.loancash.loancash.model.FirstTimer;
import com.loancash.loancash.model.ReCaptchaResponse;
import com.loancash.loancash.model.SelectedLoan;
import com.loancash.loancash.model.SelectedPaymentTerm;
import com.loancash.loancash.model.TransferModel;
import com.loancash.loancash.model.TransferReceipientModel;
import com.loancash.loancash.repo.BankAccRepo;
import com.loancash.loancash.repo.BanksRepo;
import com.loancash.loancash.repo.CreditHistoryRepo;
import com.loancash.loancash.repo.GeneratedCodeRepo;
import com.loancash.loancash.repo.LevelRepo;
import com.loancash.loancash.repo.NextAmountRepo;
import com.loancash.loancash.repo.NumberRepo;
import com.loancash.loancash.repo.PhoneNumberRepo;
import com.loancash.loancash.repo.SelectAccRepo;
import com.loancash.loancash.repo.SettingsRepo;
import com.loancash.loancash.repo.ShowAllOptions;
import com.loancash.loancash.repo.TransferReceipientRepo;

import utility.SendSms;
import utility.TransferUtility;
import utility.UniqueRandomIdGenerator;

@Controller
@SessionAttributes({"phonenumbers", "selectedloanamount","loanterm", "interest", "bankcode","accountnumber", "currnecy", "transfermodelobject"})
public class ClientController {
	
	@Autowired
	ShowAllOptions alloptions;
	
	@Autowired
	NumberRepo numberrepo;
	
	@Autowired
	GeneratedCodeRepo generatedCodeRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CreditHistoryRepo credithistoryrepo;
	
	@Autowired
	private PhoneNumberRepo phonenumberrepo;
	
	@Autowired
	private LevelRepo levelrepo;
	
	@Autowired
	private SelectAccRepo selectaccrepo;
	
	@Autowired
	private SettingsRepo settingsrepo;
	
	@Autowired
	private NextAmountRepo nextamountrepo;
	
	@Autowired
	private BanksRepo banksrepo;
	
	@Autowired
	private BankAccRepo bankaccrepo;
	///////////////////////////this program seeting variable
		
	Settings settings;
	
	///////////////////////////this section is for saved transfer receipient entity
	TransferRecipientEntity savedtransferreceipiententity;
		
	//////////////////this is selected option variable that stores the selected option
	SelectedOption selectedoption;
	
	//////this line shows the status for the show
	int status_options = 0; 
	
	///////////////////////////////this gets the transfer receipient model
	TransferUtility transferutility;
	
	/////////////////////////////this stores the transfer receipient
	@Autowired
	TransferReceipientRepo transferreceipientrepo;

	@GetMapping(value= {"/", "home","index"})
	public ModelAndView index(@RequestParam(name="operation", required=false) String operation) {
		
		ModelAndView mv = new ModelAndView("index");
		PhoneNumbers phonenumbers = new PhoneNumbers();
		
		mv.addObject("phonenumbers", phonenumbers);
	
		return mv;
	}
	
	/////////////////////////////this is called by the index page when the person submits the form from the index page
	@GetMapping("/checkcaptcher")
	
	public String checkcaptcher(@Valid @ModelAttribute("phonenumbers") PhoneNumbers phonenumbers, BindingResult result, Model model) {
	
		if(result.hasErrors()) {
		
		model.addAttribute("UserClickedManageNumber", true);
		model.addAttribute("message", "ENTER YOUR PHONE NUMBER");
		model.addAttribute("messagestatus", "failed");
		System.out.println(result.getAllErrors());
		return "index";
		}
		
		model.addAttribute("phonenumbers", phonenumbers);
		return "checknumber";
	}

	
	////////////////////////this method receives a request from the captcher page and returns send the code for number confirmation and also opens the page for 
	/////////////////////code confirmation
	@PostMapping("/sendcode")
	public String checkcode(@Valid @ModelAttribute("phonenumbers") PhoneNumbers phonenumbers, 
			BindingResult result, Model model, @RequestParam(name="g-recaptcha-response") String captcherResponse) {
			
			String url = "https://www.google.com/recaptcha/api/siteverify";
			String params = "?secret=6LcdgbwUAAAAAMDndqvft6hIcxe4qKkESg35eSfE&response="+captcherResponse;
		
			ReCaptchaResponse recaptcherResponse = restTemplate.exchange(url+params, HttpMethod.POST, null, ReCaptchaResponse.class).getBody();
			
			if(result.hasErrors()) {
			
			model.addAttribute("UserClickedManageNumber", "true");
			model.addAttribute("message", "ENTER YOUR PHONE NUMBER");
			model.addAttribute("messagestatus", "failed");
			//System.out.println(result.getAllErrors());
			return "checknumber";
			}
			
			if(!recaptcherResponse.isSuccess())
			{
				
				model.addAttribute("captcherstatus", "failed");
				model.addAttribute("captcherMessage","The Captcher Response is Invalid");
				
				return "checknumber";
			}
		
		
		////////////////////get the number
		String phonenumber = phonenumbers.getPhonenumber();
		
		
		////////////////////////////generate unique code		
		UniqueRandomIdGenerator uniquerandomgenerator = new UniqueRandomIdGenerator();
		String unique_code = uniquerandomgenerator.getUniqueRandomId();
		
		/////////////get the date so that you can know when the time gets expired
		Date date= new Date();		 
		Long time = date.getTime();//////////this generates time and converts it to seconds
		
		//////////////then send code the user
		SendSms sendsms = new SendSms();		
		//int codestatus = sendsms.sendCode(phonenumber, unique_code);
		
		System.out.println("THE CODE IS: "+unique_code);
		int codestatus = 200;
		
		if(codestatus == 200) {
			
			GeneratedCode generatedcode = new GeneratedCode();
			generatedcode.setStatus("pending");
			generatedcode.setPhonenumner(phonenumber);
			generatedcode.setCode(unique_code);
			generatedcode.setTime(time);
			
			generatedCodeRepo.save(generatedcode);
		}
		
		//PhoneNumbers phoneNumber = numberrepo.findByPhoneNumber(phonenumber);
		
		if(phonenumber == null) {
			
			///////////////generate code
		}
		
		return "confirmcodeandnumber";
	}
	
	
	
	//////////////////////////////////////////////////////////////////////this method is called by the confirmcodeandnumber page for
	/////the person to choose the amount he want to borrow
	@PostMapping("/showoptions")
	public String showForms( @RequestParam("pincode") String pincode, @ModelAttribute("phonenumbers") PhoneNumbers phonenumber, Model model ) {
		
				
		Date date = new Date();
		selectedoption = new SelectedOption();
		
		Long lgdate = date.getTime();
		///////////////////this checks whether the phonenumber and pincode match and whether the code has expired
		GeneratedCode generatecode = generatedCodeRepo.findByCodeAndNumber(phonenumber.getPhonenumber(), pincode, lgdate);
		
							
		if(generatecode != null) {
			
			String status = generatecode.getStatus();
			
			///////////////////////////this retreives the time from the database when the code was generated and compares it with the  time the person wants to submit new
			///////make use of the code
			Long savedtime = generatecode.getTime();
			
			if(status.equals("expired"))
			{
				System.out.print(generatecode);
					model.addAttribute("errormessage", "One time code expired. It only last for 30min");
					model.addAttribute("errorstatus", true);
					
					//model.addAttribute("phonenumbers", pn);
					return "confirmcodeandnumber";
			
			}else if((lgdate - savedtime) > 1800000)
			{
			  ////////////////////////////////////////////////// the status in the database should be changed expired
					  generatecode.setStatus("expired");
				      generatedCodeRepo.save(generatecode);
				
					model.addAttribute("errormessage", "One time code expired. It only last for 30min");
					model.addAttribute("errorstatus", true);
															
					//model.addAttribute("phonenumbers", pn);
					return "confirmcodeandnumber";
			
			}else if(status.equals("used")) {
				model.addAttribute("errormessage", "One time code has been used");
				model.addAttribute("errorstatus", true);
				return "confirmcodeandnumber";
				
			}else if(status.equals("pending")) {
				
				
				//////////////////////////////////////////////////////check whether the person is a first timer
				PhoneNumbers myphonenumber = phonenumberrepo.findByPhoneNumber(phonenumber.getPhonenumber());
				
				Level level = levelrepo.findByLevel(myphonenumber);
				
				if(level == null) {
					
					List<ServiceOptions> options = alloptions.findByFirstTimeServiceOptions(true);
					//System.out.print("the options are: "+options.get(2).getAllOption());
					model.addAttribute("alloptions", options);
					model.addAttribute("myoption", selectedoption);
					
				
					//////////////////////////////////////////////////the status in the database should be changed expired
					generatecode.setStatus("used");
					generatedCodeRepo.save(generatecode);
					
					System.out.print("the finale value is "+phonenumber.getPhonenumber());
					
					PhoneNumbers savephonenumber = phonenumberrepo.save(phonenumber);
					
					
					
					model.addAttribute("phonenumbers", savephonenumber);
					
					System.out.println("THIS THE PART FOR THE FIRST TIMER");
					
					return "showoptions";
				}else if(level != null) {
															
					//////////////////////////if the level is not equal to null check whether the person is owing 
					CreditHistory credithistory = credithistoryrepo.findByBorrowStatus(phonenumber.getPhonenumber(), "owing");
					
					if(credithistory != null)
					{
						String amount_own = credithistory.getAmountToPay();
						List<ServiceOptions> options = alloptions.findByOwingServiceOptions(true);
						//System.out.print("the options are: "+options.get(2).getAllOption());
						model.addAttribute("alloptions", options);
						model.addAttribute("myoption", selectedoption);
						
						
						System.out.println("THIS THE PART OF FOR OWING");
						
						return "showoptions";
						
					}else if(credithistory == null) {
						
						///////////////////////////////////////this if the level is not equal to null and the person is not owing
						List<ServiceOptions> options = alloptions.findByNotOwingServiceOptions(true);
						//System.out.print("the options are: "+options.get(2).getAllOption());
						model.addAttribute("alloptions", options);
						model.addAttribute("myoption", selectedoption);
					
						
						System.out.println("THIS THE PART IF THE PERSON IS NOT OWING");
						
						return "showoptions";
					}
					
					
				}
				
				
				////////////////////////////////////////////////////////check whether the person is owing
				
				
				//////////
			}
		}else if(generatecode == null) {
			
			model.addAttribute("errormessage", "The code entered is wrong");
			model.addAttribute("errorstatus", true);
			return "confirmcodeandnumber";
			
		}
		System.out.println("THIS IS NOT SUPPOSED TO BE HERE");
		
		return "confirmcodeandnumber";
		
		
	}

	
	
	@PostMapping("/gettransactionoption")
	public String SelectedOption(@Valid @ModelAttribute("myoption") SelectedOption selectedoption,
			@ModelAttribute("phonenumbers") PhoneNumbers phonenumber, Model m) {
		
		 int choosenoption = selectedoption.getId();
		 String pn = phonenumber.getPhonenumber();
		 
		 FirstTimer firstTimer = new FirstTimer();
		 
		 SelectedLoan  selectedamount = new SelectedLoan();
		 
		 System.out.println("choosen option is "+choosenoption);
		 
		 //////////////////////create settings from settings object using settingsrepo
		 int id = 1;
		 Optional<Settings> opt = settingsrepo.findById(id);
		 settings = opt.get();
		 
		 
		 CreditHistory credithistory = null;
		 credithistory = credithistoryrepo.findByPhoneNumber(phonenumber);
		 
		 
		 if(choosenoption == 1) {
			
			 ///////////////////////////////////////////////////check if this is the first loan. credithistory will be null is that is the first loan
			 if(credithistory == null)
			 {
				
				 double doubleamount = Double.parseDouble(settings.getFirstloan_amount());
				 
				 //////////////////////set the firsttimer attribute to true
				 firstTimer.setFirttimer(true);
				 
				 List<Double> amount = new ArrayList();
				 
				 amount.add(doubleamount);
				 
				 m.addAttribute("loanamounts", amount);
				 m.addAttribute("first", firstTimer);
				 
				 
			 }
			 
			 if(credithistory != null) { ///ie if this is not his first loan request
				 
				 ////////////////////////////////////////////get the next loan amount
				 NextAmount amountobject = nextamountrepo.findByPhoneNumber(pn);
				 
				 /////////////////set the firsttimer attribute to false
				 firstTimer.setFirttimer(false);
				 
				 ////////////get the amount and convert from string to  number
				 double amount = Double.parseDouble(amountobject.getAmount());
								
                 ////////////////////////////////////////////////check whether the amount is greater than 2000
				if(amount >= 2000)
				{
					/////////////////get the percentage change of the ie 
					int percentagechange = Integer.parseInt(settings.getPercentage_change());
					
					double fraction_change = (percentagechange/100)*amount; 
					
					List<Double> loanamount = new ArrayList<Double>();
					
					int increment_step = 1;
					for(double a = amount; increment_step <= 5; a-=fraction_change )
					{
						
						loanamount.add(a);
						increment_step++;
					}
				}
				
				m.addAttribute("loanamounts", amount);
				m.addAttribute("first", firstTimer);
				
				 
			 }
			 m.addAttribute("selectedloanamount", selectedamount); 
		 }
		
		 return "chooseloan";
	}
	
	
	////////////////////this receives the selected amount selected by the user and also show the interest page
	@PostMapping("/getselectedamount")
	public String dueday(@ModelAttribute("selectedloanamount") SelectedLoan selectedloan, @ModelAttribute("first") FirstTimer firsttimer, 
			@ModelAttribute("phonenumber") PhoneNumbers phonenumber, Model m) {
		
				
		//////////////////////////////////////////////////this is the selected payment term
		SelectedPaymentTerm selectedpaymentterm = new SelectedPaymentTerm();
				
		int id = 1;
		///////////////////////////////////////////////////////////////////////settings object
		Optional<Settings> opt = settingsrepo.findById(id);
		Settings optsettings = opt.get();
		
		///////////////////////////////////////////////////////getting the payment dates from settings object
		int first_pay_date = optsettings.getFirst_pay_date();
		int second_pay_date = optsettings.getSecond_pay_date();
		
		//////////////////////////////////////////////////////gettings the interest rates from the settings object
		int firstinterest = optsettings.getFirstinterest();
		int secondtinterest = optsettings.getSecondinterest();
	    m.addAttribute("selectedloanamount", selectedloan);
		
		
	
		m.addAttribute("firstinterest", firstinterest);
		m.addAttribute("secondinterest", secondtinterest);
		m.addAttribute("paymentterm", selectedpaymentterm);

				
		if(firsttimer.isFirttimer() == true)
		{
			m.addAttribute("firstduedate", first_pay_date);	
		}else {
			
			m.addAttribute("firstduedate", first_pay_date);	
			m.addAttribute("secondduedate", second_pay_date);	
		}
		return "selectterm";
	}
	
	@PostMapping("/selectacc")
	public String selectacc(@Valid @ModelAttribute("paymentterm") SelectedPaymentTerm selectedpayment, BindingResult result,
			@ModelAttribute("phonenumbers") PhoneNumbers phonenumber, Model m  ) {
		
		    int selectedterm = selectedpayment.getPaymentterm();
		    String myphonenumber = phonenumber.getPhonenumber();
		    
		    List<Bankacc> bankacc = null;
		    
		    ///////////////////////////check if the person has an account number reigstered
		    bankacc = selectaccrepo.findByPhoneNumber(myphonenumber);
		    
		    ////////////////////////////////verify bankacc
		    System.out.print("the value of bank is: "+bankacc);
		    
		    List<Banks> banks = banksrepo.findAll();
		    
		    //////////////////////create bank account object
		    Bankacc mybankacc = new Bankacc();
		    
		    //////////////////////add the list of banks to the model
		    m.addAttribute("banks", banks);
		    m.addAttribute("loanterm", selectedterm);
		    m.addAttribute("mybankacc", mybankacc);
		  	  
		 
		    
		    if(bankacc.size() == 0) {
		    	
		    	return "addaccount";
		    	
		    }
				return "selectbank";
		
	}
	
	@PostMapping("/getaccoutdetails")
	public String saveAccountDetails(@Valid @ModelAttribute("mybankacc") Bankacc bankacc, BindingResult result, @ModelAttribute("phonenumbers") PhoneNumbers myphonenumber,
			@ModelAttribute("selectedloanamount") SelectedLoan amountselected, @ModelAttribute("loanterm") int selectedpayment, Model m ){
		
		System.out.print("the retreived bank name is: "+bankacc.getAccno() + "the loan amount is: "+amountselected.getSelectedamount());
		
		////////////////////////////////this is the object that wiil be sent to perform transfer
		CompleteTransferModel completetransfermodel = new CompleteTransferModel(); 
		
		String transferreceipientcode = null;
		
		Banks banks = null;
		if(result.hasErrors()) {
				
			
			m.addAttribute("errormessage", "Please fill all the fields correctly");
			m.addAttribute("errorstatus", true);
			return "addaccount";
		}
		
		try {
			
			////////////////////////////////////////////////////////////////create a transfer receipient
			 transferutility = new TransferUtility(); /////////////////////this creates transfer utility object
			 
			transferreceipientcode =  transferutility.getTransferReceipient("nuban",
					myphonenumber.getPhonenumber(), "creating transfer receipient",bankacc.getAccno() , bankacc.getBank(), "NGN");
			
			////////////////////////check whether it was created
			if( transferreceipientcode != null)
			{
				
				
				TransferRecipientEntity transferreceipiententity = new TransferRecipientEntity();
				
				transferreceipiententity.setCode(transferreceipientcode);
				
				savedtransferreceipiententity = transferreceipientrepo.save(transferreceipiententity);
								
			}else {
				
				m.addAttribute("errormessage", "Could not save your bank details Please check the details you entered");
				m.addAttribute("errorstatus", true);
				return "addaccount";
			}
			
			bankacc.setTransferreceipient(savedtransferreceipiententity);
			bankacc.setPhone(myphonenumber.getPhonenumber());
			
			bankaccrepo.save(bankacc);
			
			//////////////////get the bank name
			banks = banksrepo.findBybankcode(bankacc.getBank());
		}catch(Exception e) {
			
			e.printStackTrace();
			
			m.addAttribute("errormessage", "Please check your details");
			m.addAttribute("errorstatus", true);
			m.addAttribute("transferreceipienentity", savedtransferreceipiententity);
			return "addaccount";
		}
		
		///////////////////////////////////////////////////////get the interest rate from the settings
		int id = 1;
		Optional<Settings> opt = settingsrepo.findById(id);
		Settings optsettings = opt.get();
		int interest = 0;
		
		System.out.print("The selected pay term is: "+selectedpayment);
		
			if(selectedpayment == 1) {
			
			interest = optsettings.getFirstinterest();
			m.addAttribute("loanterm", optsettings.getFirst_pay_date()); 
		}else {
			
			interest = optsettings.getSecondinterest();
			m.addAttribute("loanterm", optsettings.getSecond_pay_date()); 
		}
		
		//////////////////////////////////////////////////
		String accnumber = bankacc.getAccno();
		String firstsubacc = accnumber.substring(0, 3);
		String secondsubacc = accnumber.substring(7, 10);
		
		String mergedacc = firstsubacc+"****"+secondsubacc;
		
		double amount_plus_interest = amountselected.getSelectedamount() + (interest/100.0) * amountselected.getSelectedamount();
		
		completetransfermodel.setAmountborrorwed(String.valueOf(amountselected.getSelectedamount()));
		
		System.out.print("THE AMOUNT BORROWED IS "+amountselected.getSelectedamount());
		
		completetransfermodel.setAmounttopay(String.valueOf(amount_plus_interest));
		completetransfermodel.setInterest(String.valueOf(interest));
		completetransfermodel.setPhonenumber(myphonenumber.getPhonenumber());
		completetransfermodel.setLoanterm(String.valueOf(optsettings.getSecond_pay_date()));
		completetransfermodel.setTransferreceipient(transferreceipientcode);
		
		m.addAttribute("bank", banks.getBankname());
		m.addAttribute("bankacc", mergedacc);
		m.addAttribute("bankcode", bankacc.getBank());
		m.addAttribute("accountnumber", bankacc.getAccno());
		m.addAttribute("currency", "NGN");
		m.addAttribute("amounttopay", amount_plus_interest);
		m.addAttribute("interest", interest);
		m.addAttribute("transfermodelobject", completetransfermodel);
		
		System.out.print("Amount plus interst: "+ amount_plus_interest);
						
		return "detailsconfirmation";
	}
	
	
	///////////////////////////////////////this method tranfers fund to the client
	@PostMapping("/transfer")
	public String transfer(
			@ModelAttribute("transfermodelobject") CompleteTransferModel completetransfermodel,
			BindingResult result, @ModelAttribute("phonenumbers") PhoneNumbers myphonenumber,
			Model m)
	{
		
		TransferUtility transferutility = new TransferUtility();
		
		/////////////////////////////////////////////////////////////////////////////////make payment
		String transferreceipient = completetransfermodel.getTransferreceipient();
						
		TransferModel transfermodel = transferutility.tranfer("balance", "transfer for loan",completetransfermodel.getAmountborrorwed(), transferreceipient);
				
		
		if(transfermodel.isStatus() || transfermodel.getData().getStatus() == "success") {
			
			if(transfermodel.getData().getAmount() > 0) {
				
				///////////////////////////////////update the credit table and return page completed
				CreditHistory credithistory = new CreditHistory();
				
				//////////////////////get the time of the saving
				Date date = new Date();
				
				Long time = date.getTime(); /////////////converting time seconds
				
				long duedate = (86400 *1000 * Long.parseLong(completetransfermodel.getLoanterm())) + time;
				
				credithistory.setAmount(completetransfermodel.getAmountborrorwed());
				credithistory.setRequsetDate(String.valueOf(time));
				credithistory.setAmountToPay(String.valueOf(completetransfermodel.getAmounttopay()));
				credithistory.setBorrowStatus("pending");
				credithistory.setDueDate(String.valueOf(duedate));
				credithistory.setIncrementDate("null");
				credithistory.setPaidDate("pending");
				credithistory.setTransfer_code(transfermodel.getData().getTransfer_code());
				credithistory.setInterest(String.valueOf(completetransfermodel.getInterest()));
				credithistory.setPhonenumber(myphonenumber);
				
				System.out.print("THE VALUE OF THE SAVED PHONE NUMBER IS: "+ myphonenumber);
				
				CreditHistory savedcreditrepo = credithistoryrepo.save(credithistory);
				
				m.addAttribute("messagestatus", true);
				m.addAttribute("message", "Your laon is being disbursed! you will receive a confirmation shortly. We look forward to serving you again");
				return "completeloan";
				
			}else {
				
				m.addAttribute("messagestatus", true);
				m.addAttribute("message", "error completing fund transfer try again later ");
				return "completeloan";
			}
		}

		m.addAttribute("messagestatus", true);
		m.addAttribute("message", "error disbursing fund please try again later");
		return "completeloan";
		
	}
}

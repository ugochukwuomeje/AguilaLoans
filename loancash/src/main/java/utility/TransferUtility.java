package utility;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.loancash.loancash.entity.Bankacc;
import com.loancash.loancash.model.ResolvedAccountResult;
import com.loancash.loancash.model.SelectedLoan;
import com.loancash.loancash.model.TransferModel;
import com.loancash.loancash.model.TransferReceipientCode;
import com.loancash.loancash.model.TransferReceipientModel;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import reactor.core.publisher.Mono;
import utility.TransferUtility;

public class TransferUtility {
	
	private static final String baseUrl = "https://api.paystack.co/transferrecipient";
	
	private static final String tranferbaseUrl = "https://api.paystack.co/transfer";
	
	private static String secretkey = "Bearer sk_live_edddf3d1c14bdb4a4e1f8e21be5a23fb4a0a6bdd";
	
	private final OkHttpClient httpClient = new OkHttpClient();
	
	
	///////////////////////////this methode retrieves the secret key
	public String getTransferReceipient(String type, String name,
			String description, String account_number, String bank_code,
			String currency
			) {
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		
		
		Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
		map.put("Authorization", secretkey);
		
		headers.setAll(map);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("type", type);
		params.put("name", name);
		params.put("description", description);
		params.put("account_number", account_number);
		params.put("bank_code", bank_code);
		params.put("currency", currency);
		
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<?> entity = new HttpEntity<>(params, headers);
		
		ResponseEntity<TransferReceipientModel> respEntity = null;

		respEntity = restTemplate.postForEntity(baseUrl, entity, TransferReceipientModel.class);

		TransferReceipientModel resp = respEntity.getBody();
		
		System.out.println("/n the value of transferreceipient code is: "+resp.getData().getRecipient_code());
		
		HttpStatus httpresponseEntity = respEntity.getStatusCode();
		
		if(httpresponseEntity != HttpStatus.CREATED) {
			
			return null;
		}
		
		return resp.getData().getRecipient_code() ;
	}
	
	//////////////////////////////////////////////this method get does the actual transfer
	public TransferModel tranfer(String source, String reason,
			String amount, String receipient) {
		
		TransferModel transfermodel = null;
		
		 /**RequestBody formBody = new FormBody.Builder()
	                .add("source", source)
	                .add("reason", reason)
	                .add("amount", amount)
	                .add("recipient", receipient)
	                .build();
		 
		 Request request = new Request.Builder()
	                .url("https://api.paystack.co/transfer")
	                .addHeader("User-Agent", "OkHttp Bot")
	                .addHeader("Content-Type", "application/json")
	                .addHeader("Authorization", "Bearer sk_live_edddf3d1c14bdb4a4e1f8e21be5a23fb4a0a6bdd")
	                .post(formBody)
	                .build();**/
		 
		 try{
	            ObjectMapper objectMapper = new ObjectMapper(); 
	            //ResponseBody responseBody = httpClient.newCall(request).execute().body(); 
	            
	            Gson gson = new Gson();
	            String transfermodeljson = "{\"status\":true\",\"message\":\"Tranasfer require OTP to continue\",\"data\":{\"id\":1,\"amount\":3000.0,\"createdAt\":\"june\",\"transfer_code\":\"TRF_1ptvuv321ahaa7q\",\"udatedAt\":\"may\",\"transfer_code\":\"TRF_1ptvuv321ahaa7q\"}}";
	            System.out.println(transfermodeljson);
	            transfermodel = gson.fromJson(transfermodeljson /*responseBody.string()*/, TransferModel.class);
	            
	            System.out.print("the retrieved message "+transfermodel.getMessage());

	            // Get response body
	            //System.out.println(responseBody.string());
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 
		 return transfermodel;
	}
}

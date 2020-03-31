package com.loancash.loancash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loancash.loancash.model.PaymentData;
import com.loancash.loancash.model.TransferModel;

@RestController
public class PaymentTest {

	;
	
	@PostMapping("/getpaymentDetail")
	public TransferModel paymentDetails() {
		System.out.println("payment created");
		
		TransferModel tr = new TransferModel();
		
		PaymentData paymentdata = new PaymentData();
		 
		 tr.setStatus(true);
		 tr.setMessage("Tranasfer require OTP to continue");
		 paymentdata.setId(1);
		 paymentdata.setAmount(3000);
		 paymentdata.setCreatedAt("june");
		 paymentdata.setTransfer_code("TRF_1ptvuv321ahaa7q");
		 paymentdata.setUdatedAt("may");
		 
		 tr.setData(paymentdata);
		 
		 return tr;
		
	}
}

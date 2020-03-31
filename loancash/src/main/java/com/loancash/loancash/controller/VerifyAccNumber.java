package com.loancash.loancash.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.loancash.loancash.model.ResolvedAccountResult;



@RestController
public class VerifyAccNumber {
	
	RestTemplate rst = new RestTemplate();
	
	

	@GetMapping("/resolvePhoneNumber/{accountnumber}/{bankcode}")
	public  String checkPhoneNumber( @PathVariable("bankcode") String bankcode, @PathVariable("accountnumber") String accountnumber)
	{
		
		String url = "https://api.paystack.co/bank/resolve?account_number="+accountnumber+"&bank_code="+bankcode;
		
		//System.out.println(url);
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer sk_live_10bc8d0af83bbb832783910a49958b16e3e2b2cb");

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		
		ResponseEntity<ResolvedAccountResult> respEntity = null;

		try {
			respEntity = restTemplate.exchange(url, HttpMethod.GET, entity, ResolvedAccountResult.class);

		}catch(Exception e) {
			
			return "error";
		}

		ResolvedAccountResult resp = respEntity.getBody();
		
		HttpStatus httpresponseEntity = respEntity.getStatusCode();
		
		if(httpresponseEntity != HttpStatus.OK) {
			
			return "error";
		}
		
		if(resp.isStatus())
		{
			
			return resp.getData().getAccount_name();
		}else {
			
			return "resp";
		}

		
	}
}

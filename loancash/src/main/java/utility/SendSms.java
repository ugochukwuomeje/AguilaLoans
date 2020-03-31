package utility;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Component;

@Component
public class SendSms {

	public int sendCode(String receipient, String message )
	{
		
		  String url = "https://api.smartsmssolutions.com/smsapi.php";
		 
		  int response = 0;
			
		  URL obj = null;
		try {
			obj = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  HttpsURLConnection con = null;
		try {
			con = (HttpsURLConnection) obj.openConnection();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  try {
			con.setRequestMethod("POST");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  con.setRequestProperty("USER-AGENT", "AGUILA CASH");
		  con.setRequestProperty("Accept-Language", "en-us,en;q=0.5");
		  
		  String urlParameters = "username=ugoizm1@gmail.com&password=aguila2019&sender=Aquilacash&recipient="+receipient+"&message="+message;
		
		  //sending post request
		  con.setDoOutput(true);
		  try {
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
		  
			
			///////////receiving the output
			response = con.getResponseCode();
			
			
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 System.out.print(response);		 
		return response;
	}
}

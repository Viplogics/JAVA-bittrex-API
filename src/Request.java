package bittrex;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Request {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

	 
	}

	public String apiSecretCall(String apiKey, String apiSecret, String url, String nonce) throws IOException {
		String urlParameters = "?apikey=" + apiKey+ "&nonce=" + nonce;
		URL obj = new URL(url+ urlParameters);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	
		// add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		String signedUrl = Hmac_sha512.encrypt(apiSecret, url + urlParameters);
		con.setRequestProperty("apisign", signedUrl);
		System.out.println("Calling :\t" + url + urlParameters + "...:");
		System.out.println("Sha512-encrypt of:\t" + url + urlParameters );
		System.out.println("Signed Url in Header:\t" + signedUrl);

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}
	
	public String apiPublicCall(String url) throws IOException {
	 
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	
		// add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		 
		 
		System.out.println("Calling :\t" + url + "...:");
	 
		 

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		 
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
	 
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}

}
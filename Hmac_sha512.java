package bittrex;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Hmac_sha512 {
	
	public static String toHexString(byte[] array) {
	    return DatatypeConverter.printHexBinary(array);
	}
	
	public static void main(String[] args) {
		// System.out.println("key1, " + "Message1:\n" + encrypt("key1",
		// "Message1"));
		// System.out.println("key1, " + "Message1:\n" + encrypt("key1",
		// "Message1"));
		System.out.println(
				"https://bittrex.com/api/v1.1/account/getbalances?apikey=5f1d69e1ad50438a8b9c491942948246&nonce=something, "
						+ "ed2bee6f7a654a05b9f718453634409a:\n"
						+ encrypt("ed2bee6f7a654a05b9f718453634409a","https://bittrex.com/api/v1.1/account/getbalances?apikey=5f1d69e1ad50438a8b9c491942948246&nonce=something"));
	}

	public static String encrypt(String key, String message) {
		Mac sha512_HMAC = null;
		String result = null;

		try {
			byte[] byteKey = key.getBytes("UTF-8");
			final String HMAC_SHA256 = "HmacSHA512";
			sha512_HMAC = Mac.getInstance(HMAC_SHA256);
			SecretKeySpec keySpec = new SecretKeySpec(byteKey, HMAC_SHA256);
			//SecretKeySpec keySpec = new SecretKeySpec(DatatypeConverter.parseHexBinary(byteKey), HMAC_SHA256);
				// SecretKeySpec( DatatypeConverter.parseHexBinary(PayboxConstants.KEY), "HmacSHA512" );
			sha512_HMAC.init(keySpec);
			byte[] mac_data = sha512_HMAC.doFinal(message.getBytes("UTF-8"));
			/*String s02x="";
			for (byte b : mac_data) {
				String s=String.format("%02x", b);
				s02x=s02x+s;
				System.out.print(s);
			}*/
			System.out.println("\n---------------");
			//result = bytesToHex(mac_data);
			result = toHexString(mac_data);
			// System.out.println(result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// System.out.println("Done");
		}
		return result;
	}

	public static String bytesToHex(byte[] bytes) {
		final char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			// System.out.format("%02x", v);
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];

		}
		return new String(hexChars);
	}
}
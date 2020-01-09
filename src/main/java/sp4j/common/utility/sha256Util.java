package sp4j.common.utility;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class sha256Util {
	public static String sha256Create(String password){
		
		  try{
		        MessageDigest digest = MessageDigest.getInstance("SHA-256");
		        byte[] hash = digest.digest(password.getBytes("UTF-8"));
		        StringBuffer hexString = new StringBuffer();

		        for (int i = 0; i < hash.length; i++) {
		            String hex = Integer.toHexString(0xff & hash[i]);
		            if(hex.length() == 1) hexString.append('0');
		            hexString.append(hex);
		        }

		        return hexString.toString();

		    } catch(Exception ex){
		        throw new RuntimeException(ex);
		    }
		 
	}
	
	public static String base64Encoding(String text){
		
		byte[] encodedBytes = Base64.encodeBase64(text.getBytes());

		return new String(encodedBytes);
		
	}
	
	public static String base64Decoding(String text){
		byte[] decodedBytes = Base64.decodeBase64(text);

		return new String(decodedBytes);
		
	}
}

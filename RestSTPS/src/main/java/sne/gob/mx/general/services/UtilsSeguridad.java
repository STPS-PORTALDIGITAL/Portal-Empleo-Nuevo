package sne.gob.mx.general.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.internet.MimeUtility;


public class UtilsSeguridad {

private final static String keyBuffer = "56af65d2";

public static void main(String[] args) {
	try {
		System.out.println("#--------------------------QA-----------------------------------");
		System.out.println("#serverIn=<ENCRYPTED>"+encripta("ryelxjd9sabtq1.rye.avon.com"));
		System.out.println("#userIn=<ENCRYPTED>"+encripta("ftpe1sa"));
		System.out.println("#passIn=<ENCRYPTED>"+encripta("Querical2"));
		System.out.println("#port=<ENCRYPTED>"+encripta("22"));
		System.out.println("#--------------------------PROD-----------------------------------");
		System.out.println("#serverIn=<ENCRYPTED>"+encripta("ryelxjd9sabtp1.rye.avon.com"));
		System.out.println("#userIn=<ENCRYPTED>"+encripta("ftpjdesa"));
		System.out.println("#passIn=<ENCRYPTED>"+encripta("Ch!cknWng5"));
		System.out.println("#port=<ENCRYPTED>"+encripta("22"));
		System.out.println("#-----------------------------------------------------------------");
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public static byte[] encode(byte[] b) throws Exception {
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	OutputStream b64os = MimeUtility.encode(baos, "base64");
	b64os.write(b);
	b64os.close();
	return baos.toByteArray();
}

public static byte[] decode(byte[] b) throws Exception {
	ByteArrayInputStream bais = new ByteArrayInputStream(b);
	InputStream b64is = MimeUtility.decode(bais, "base64");
	byte[] tmp = new byte[b.length];
	int n = b64is.read(tmp);
	byte[] res = new byte[n];
	System.arraycopy(tmp, 0, res, 0, n);
return res;

}

private static SecretKeySpec getKey() {
// keyBuffer = keyBuffer.substring(0, 8);
	SecretKeySpec key = new SecretKeySpec(keyBuffer.getBytes(), "DES");
return key;
}

	public  String desencripta(String s) throws Exception {
		String s1 = null;
			if (s.contains("<ENCRYPTED>")){
				s = s.replace("<ENCRYPTED>", "");
				Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
				cipher.init(2, getKey());
				byte abyte0[] = cipher.doFinal(decode(s.getBytes()));
				s1 = new String(abyte0);
			}else{
				s1 = s;
			}
	return s1;
	}

	public static String encripta(String s) throws Exception {
		byte abyte0[];
		SecureRandom securerandom = new SecureRandom();
		securerandom.nextBytes(keyBuffer.getBytes());
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(1, getKey());
		abyte0 = encode(cipher.doFinal(s.getBytes())); // antes
	return new String(abyte0);
	}
	
	public static String encripta1(String s)  {
	return s;
	}

}

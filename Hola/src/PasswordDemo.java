import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class PasswordDemo {

	public static void main(String[] args) {
		String password = "Passw0rd";
		Encoder encoder = Base64.getEncoder();

		String encoded = encoder.encodeToString(password.getBytes());
		System.out.println(password);
		System.out.println(encoded);
		
		Decoder decoder = Base64.getDecoder();
		String decoded  = new String(decoder.decode(encoded.getBytes()));
		System.out.println(decoded);

	}

}

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class CaesarCipherFile {
	/**
	 * Returns the character chifted by the given number of letters.
	 */
	public static char shiftLetter(char c, int n) {
		int u = c;
		
		if (! Character.isLetter(c))
			return c;
		
		u = u + n;
		if (Character.isUpperCase(c) && u > 'Z'
		  || Character.isLowerCase(c) && u > 'z') {
			u -= 26;
		}
		if (Character.isUpperCase(c) && u < 'A'
		  || Character.isLowerCase(c) && u < 'a') {
			  u += 26;
		}
		
		return (char)u;
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		String plaintext = ""; 
		String cipher = "";
		int shift;
		
		System.out.print("File to encrypt: ");
		String originFile = keyboard.next();
		File unencryptedFile = new File(originFile);
		System.out.print("Shift (0-26): ");
		shift = keyboard.nextInt();
		String destination = ("super-secret" + originFile);
		File cipherFile = new File(destination);

		if (unencryptedFile.exists() && unencryptedFile.length() > 0) {
			Scanner input = new Scanner(unencryptedFile);
				plaintext = input.nextLine();
			input.close();
			System.out.println ("Unencrypted message: " + plaintext);
		} else {
			System.out.println("There is no message to encrypt.");
		}
			
		

		
		for (int i = 0; i < plaintext.length(); i++) {
			cipher += shiftLetter(plaintext.charAt(i), shift);
		}
		PrintWriter out = new PrintWriter(cipherFile);
			out.println(cipher);
		out.close();
	}
}
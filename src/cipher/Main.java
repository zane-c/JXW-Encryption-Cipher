package cipher;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Cipher c = new Cipher();
		Scanner console = new Scanner(System.in);
		boolean running = true;
		String userInput = "";

		System.out.println("d/e?");
		while (running) {

			userInput = console.nextLine();
			switch (userInput) {

			case "d":
			case "D":
			case "Decrypt":
			case "decrypt":
				String dm = console.nextLine();
				System.out.println(c.decrypt(dm));
				break;

			case "e":
			case "E":
			case "encrypt":
			case "Encrypt":
				String em = console.nextLine();
				System.out.println(c.encrypt(em));
				break;

			case "q":
				running = false;
				break;

			default:
				break;

			}
		}
		console.close();
		System.out.println("Complete.");
	}
}

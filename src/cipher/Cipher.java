package cipher;

import java.util.*;

public class Cipher {

	private ArrayList<Character> zascii = new ArrayList<Character>();
	private String key = "kronos";

	public Cipher() {
		populateCipher();
	}

	public String decrypt(String output) {

		String message = "";

		for (int i = 0; i < (output.length() - 3); i = i + 4) {
			String tempStr = "" + output.charAt(i) + output.charAt(i + 1) + output.charAt(i + 2) + output.charAt(i + 3);

			message += zascii.get(fromJxw(tempStr));
		}
		message = reverseShift(message);
		return message;
	}


	public String encrypt(String input) {
		String output = "";

		input = shift(input);

		for (int i = 0; i < input.length(); i++) {
			output += (toJxw(zascii.indexOf(input.charAt(i))));
		}
		return output;
	}

	/*
	 * A non encrypted message is given. Output is encrypted via the Vigenere Cipher. Each character is shifter by the
	 * key index.
	 */
	private String shift(String message) {

		int counter = 0;
		String output = "";
		int index;

		for (int i = 0; i < message.length(); i++) {

			if (counter == key.length()) {
				counter = 0;
			}

			index = zascii.indexOf(message.charAt(i)) + zascii.indexOf(key.charAt(counter));

			if (index > 80) {
				index = index % 80;
			}

			counter++;
			output += zascii.get(index);
		}
		return output;
	}

	private String reverseShift(String encryptedMessage) {

		// encrypted message gets converted into non-encrypted message
		String output = "";
		int counter = 0;
		int index;

		for (int i = 0; i < encryptedMessage.length(); i++) {

			if (counter == key.length()) {
				counter = 0;
			}

			index = zascii.indexOf(encryptedMessage.charAt(i)) - zascii.indexOf(key.charAt(counter));

			if (index < 0) {
				index = index + 80;
			}
			counter++;
			output += zascii.get(index);
		}
		return output;
	}

	private void populateCipher() {
		/*
		 * invalid keys include: ~ and _ { or }
		 */
		zascii.add('!'); // 0
		zascii.add('?');
		zascii.add('.');
		zascii.add(',');
		zascii.add('(');
		zascii.add(')'); // 5
		zascii.add('/');
		zascii.add('-');
		zascii.add('*');
		zascii.add('\'');
		zascii.add('"'); // 10
		zascii.add('$');
		zascii.add('#');
		zascii.add(' ');
		zascii.add('\r');
		zascii.add('\n'); // 15

		zascii.add('a'); // 16
		zascii.add('b');
		zascii.add('c');
		zascii.add('d');
		zascii.add('e'); // 20
		zascii.add('f');
		zascii.add('g');
		zascii.add('h');
		zascii.add('i'); // 24
		zascii.add('j'); // 25
		zascii.add('k');
		zascii.add('l');
		zascii.add('m');
		zascii.add('n'); // 29
		zascii.add('o'); // 30
		zascii.add('p');
		zascii.add('q');
		zascii.add('r');
		zascii.add('s'); // 34
		zascii.add('t'); // 35
		zascii.add('u');
		zascii.add('v');
		zascii.add('w');
		zascii.add('x'); // 39
		zascii.add('y'); // 40
		zascii.add('z'); // 41

		zascii.add('A'); // 42
		zascii.add('B');
		zascii.add('C');
		zascii.add('D'); // 45
		zascii.add('E');
		zascii.add('F');
		zascii.add('G');
		zascii.add('H'); // 49
		zascii.add('I'); // 50
		zascii.add('J');
		zascii.add('K');
		zascii.add('L');
		zascii.add('M'); // 54
		zascii.add('N'); // 55
		zascii.add('O');
		zascii.add('P');
		zascii.add('Q');
		zascii.add('R'); // 59
		zascii.add('S'); // 60
		zascii.add('T');
		zascii.add('U');
		zascii.add('V');
		zascii.add('W'); // 64
		zascii.add('X'); // 65
		zascii.add('Y');
		zascii.add('Z'); // 67

		zascii.add('+'); // 68
		zascii.add('=');
		zascii.add('0');
		zascii.add('1');
		zascii.add('2');
		zascii.add('3'); // 73
		zascii.add('4'); // 74
		zascii.add('5');
		zascii.add('6');
		zascii.add('7');
		zascii.add('8');
		zascii.add('9');
		zascii.add('\\'); // 80 unreachable and unused
	}

	private String toJxw(int number) {

		String b3 = toBase3(number);
		String encoded = "";

		for (int i = 0; i < 4; i++) {
			switch (b3.charAt(i)) {

			case '0':
				encoded += "j";
				break;

			case '1':
				encoded += "x";
				break;

			case '2':
				encoded += "w";
				break;
			}
		}
		return encoded;
	}

	private String toBase3(int number) {

		int dig1 = number / 27;
		int dig2 = (number % 27) / 9;
		int dig3 = ((number % 27) % 9) / 3;
		int dig4 = (((number % 27) % 9) % 3);

		return Integer.toString(dig1) + Integer.toString(dig2) + Integer.toString(dig3) + Integer.toString(dig4);
	}

	private int fromJxw(String jxwx) {
		String output = "";

		for (int i = 0; i < 4; i++) {

			switch (jxwx.charAt(i)) {

			case 'j':
				output += "0";
				break;

			case 'x':
				output += "1";
				break;

			case 'w':
				output += "2";
				break;

			}
		}
		return fromBase3(output);
	}

	private int fromBase3(String base3number) {
		int output;

		output = 27 * Integer.parseInt("" + base3number.charAt(0)) + 9 * Integer.parseInt("" + base3number.charAt(1))
				+ 3 * Integer.parseInt("" + base3number.charAt(2)) + 1 * Integer.parseInt("" + base3number.charAt(3));

		return output;
	}
}

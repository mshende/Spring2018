
public class Palindrome {

    public static boolean isDoublePalindrome (char[] digits)
    {
	boolean result = true;
	if (digits.length % 2 != 0) {
	    result = false;
	}
	else {
	    int j = digits.length - 1;
	    for (int i=0; i<(digits.length/2); i++) {
		boolean eq = digits[i] == digits[j];
		result = result && eq;
		j = j-1;
	    }
	    for (int i=0; i<digits.length; i+=digits.length/2) {
		j = i + digits.length/2 - 1;
		for (int k=i; k<(digits.length/2); k++) {
		    boolean eq = digits[k] == digits[j];
		    result = result && eq;
		    j = j-1;
		}
	    }

	}
	return result;
    }

}

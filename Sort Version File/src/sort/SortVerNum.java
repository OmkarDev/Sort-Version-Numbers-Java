package sort;

public class SortVerNum {
	// COMPARING lexicographically
	public int compareToVersionNumber(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		// CHECKING IF BOTH ARE SAME
		if (a.equals(b)) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < a.length(); i++) {
			result += a.charAt(i) - b.charAt(i);
			// CHECKING IF THERE IS NUMBER BETN TWO THEN COMPARING THE NUMBER USED FOR
			// VERSION CONTROLLING
			if (Character.isDigit(a.charAt(i)) && Character.isDigit(b.charAt(i)) && (a.charAt(i) != b.charAt(i))) {
				String aIntString = getIntStringFromString(a, i);
				String bIntString = getIntStringFromString(b, i);
				// Checking if number is large in length if it is then comparing normally as
				// String
				if ((aIntString != bIntString)) {
					if (aIntString.length() >= 8 || bIntString.length() >= 8) {
						return compareToString(aIntString, bIntString);
					} else {
						// changing string to number and then comparing
						int aInt = Integer.parseInt(aIntString);
						int bInt = Integer.parseInt(bIntString);
						return Integer.compare(aInt, bInt);
					}
				}
			}
			// STOP COMPARING THE FIRST THING THAT IS DIFFERENT FROM OTHER
			if (Math.abs(result) > 0) {
				break;
			}
			// IF STRING A IS BIGGER IN LENGTH THAN BE AND VICE VERSA AND RETURNING THE
			// COMPARISION BY DIFFERENCE OF THE LENGTH
			if (a.length() > b.length()) {
				if (i == b.length() - 1) {
					return a.length() - b.length();
				}
			} else if (a.length() < b.length()) {
				if (i == a.length() - 1) {
					return a.length() - b.length();
				}
			}
		} // RETURNING THE RESULT
			// RESULT HERE IS THE COMPARISION NUMBER BY WHICH SORTING HAPPPENS
		return result;
	}

	public String getIntStringFromString(String a, int i) {
		String result = "";
		for (int ci = i; ci < a.length(); ci++) {
			if (Character.isDigit(a.charAt(ci))) {
				result += a.charAt(ci);
			} else {
				break;
			}
		}
		return result;
	}

	// ORIGINAL COMPARE TO STRING OF JAVA
	public int compareToString(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		if (a.equals(b)) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < a.length(); i++) {
			result += a.charAt(i) - b.charAt(i);
			if (Math.abs(result) > 0) {
				break;
			}
			if (a.length() > b.length()) {
				if (i == b.length() - 1) {
					return a.length() - b.length();
				}
			} else if (a.length() > b.length()) {
				if (i == a.length() - 1) {
					return a.length() - b.length();
				}
			}
		}
		return result;
	}
}

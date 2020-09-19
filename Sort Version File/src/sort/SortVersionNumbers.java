package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortVersionNumbers {

	ArrayList<String> list = new ArrayList<String>();

	public SortVersionNumbers() {
		list.add("Season 1");
		list.add("Season 11");
		list.add("Season 21");
		list.add("Season 2");
		list.add("Video 2.mp4");
		list.add("Video 21.mp4");
		list.add("Video 1.mp4");
		list.add("Video 11.mp4");
		list.add("Video 3.mp4");
		Collections.shuffle(list);
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
//				return compareToString(a,b);
				return compareToVersionNumber(a, b);
			}

		});
		for (String s : list) {
			System.out.println(s);
		}
	}

	public int getIntFromString(String a, int i) {
		String result = "";
		for (int ci = i; ci < a.length(); ci++) {
			if (Character.isDigit(a.charAt(ci))) {
				result += a.charAt(ci);
			} else {
				break;
			}
		}
		return Integer.parseInt(result);
	}

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
			if (Character.isDigit(a.charAt(i)) && Character.isDigit(b.charAt(i))) {
				int aInt = getIntFromString(a, i);
				int bInt = getIntFromString(b, i);
				if (aInt != bInt) {
					return Integer.compare(aInt, bInt);
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
		}
		// RETURNING THE RESULT
		// RESULT HERE IS THE COMPARISION NUMBER BY WHICH SORTING HAPPPENS
		return result;
	}

	public static void main(String[] args) {
		new SortVersionNumbers();
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

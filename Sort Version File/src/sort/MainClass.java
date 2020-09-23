package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainClass {

	ArrayList<String> list = new ArrayList<String>();
	SortVerNum sort;

	public MainClass() {
		sort = new SortVerNum();
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
				return sort.compareToVersionNumber(a, b);
			}

		});
		for (String s : list) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		new MainClass();
	}

}

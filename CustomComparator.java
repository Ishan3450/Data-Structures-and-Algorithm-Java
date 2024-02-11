import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {

	public static void main(String[] args) {
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String str12 = str1 + str2; // 3 and 30 -> 330
				String str21 = str2 + str1; // 303

				return str21.compareTo(str12); // for descending order

				/*
				 * Example of custom comparator:
				 * LeetCode 179 https://leetcode.com/problems/largest-number/description/
				 */
			}
		};

		// below 3 lines are just to remove warnings
		String[] arr = {};
		Arrays.sort(arr, comp);
		System.out.println(Arrays.toString(arr));

		// ? another example
		// Comparator<Pair> comparator = new Comparator<Pair>() {
		// public int compare(Pair p1, Pair p2){
		// return p1.finishingTime - p2.finishingTime;
		// }
		// };
	}
}
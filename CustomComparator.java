public class CustomComparator{

	public static void main(String[] args){
		Comparator<String> comp = new Comparator<String> () {
			@Override
			public int compare(String str1, String str2){
				String str1 = str1 + str2; // 3 and 30 -> 330
				String str2 = str2 + str1; // 303

				return str2.compareTo(str1); // for descending order 

				/* 
				 * Example of custom comparator: 
				 * LeetCode 179 https://leetcode.com/problems/largest-number/description/
				 */
			}
		};
	}
}
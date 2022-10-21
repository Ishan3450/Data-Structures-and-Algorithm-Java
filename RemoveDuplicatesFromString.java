public class RemoveDuplicatesFromString {
    public static String removeDuplicates(String str, boolean[] arr, int index, String ans){
        // base condition
        if(index == str.length()){
            return ans;
        }

        // function body
        char curr = str.charAt(index);

        /*
         * a - a = 0
         * b - a = 1
         * b - c = 2
         * .
         * .
         * z - a = 25
         */
        int idx = curr - 'a';
        if(!arr[idx]){
            arr[idx] = true;
            return removeDuplicates(str, arr, index+1, ans+curr);
        }

        return removeDuplicates(str, arr, index+1, ans);
    }
    public static void main(String[] args){
        boolean[] arr = new boolean[26];
        String str = "aabcccdde";
        System.out.println(removeDuplicates(str, arr, 0, ""));
    }
}

package LeetCodeContests;

public class Q392 {
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        int sTrack = 0, tTrack = 0;

        // step 1 we have to iterate till the end of the string t
        while(tTrack < t.length()){
            // step 2 check the curr characters with the characters of string s
            if(t.charAt(tTrack) == s.charAt(sTrack)){
                sTrack ++;

                if(sTrack == s.length()){ // if string s completed then
                    return true;
                }
            }

            tTrack ++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}

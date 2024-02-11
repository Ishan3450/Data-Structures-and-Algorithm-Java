/*
 * 526. Beautiful Arrangement https://leetcode.com/problems/beautiful-arrangement/description/
 * 
 * Approach:
 *  - we are gonna consider n empty places like for 3: _ _ _ (3 empty spaces)
 *  - then starting from 1 till n we will try to place the elements in the empty spaces
 *  - for 1 we can place it at the index 0, 1 and 2
 *  - first we will place it in the indx 0 => 1 _ _
 *  - as we placed 1 now its turn to place 2
 *  - now we will try to place 2 at the empty places
 *  - starting from idx 0
 *  - as 1 is at idx 0 we can't place 2 at idx 0, so we will try to place it on idx 1
 *  - we can place 2 at idx 1 => 1 2 _
 *  - then same process for three => 1 2 3
 *  - at the place time we will check the conditions given in the questions i.e either the (perm[i] is divisible by i) or (i is divisible by perm[i])
 *  - if possible then we will place it and if not then we will not place it
 * 
 * TC: O(N!) for 1st call n choices, 2nd n-1 choices, 3rd n-2 ...... 1 so N!
 * SC: O(N)
 */

package Backtracking;

public class BeautifulArrangements {
    public int countArrangement(int n) {
        // passing currElem as 1 because values lies from 1 <= currElem <= n
        int ans = helper(n, 1, new boolean[n]);
        return ans;
    }

    public int helper(int n, int currElem, boolean[] place) {
        // base condition
        if (currElem == n + 1) {
            return 1;
        }

        // function body
        int tempAns = 0;

        for (int i = 1; i <= n; i++) {
            // checking wheter the curr place has some value or not
            if (place[i - 1]) {
                continue;
            }
            // if not filled, then we are good to go

            // marking the curr place as filled
            place[i - 1] = true;

            /*
             * Checking the 2 conditions given in the question, if either is true we are
             * good to do further recursive call:
             * - currElem is divisible by i
             * - or i is divisible by currElem
             */
            if ((currElem % i == 0) || (i % currElem == 0)) {
                tempAns += helper(n, currElem + 1, place);
            }

            // backtracking, marking the i-1th place as empty
            place[i - 1] = false;
        }

        return tempAns;
    }
}

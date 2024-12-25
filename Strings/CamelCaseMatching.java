package Strings;

import java.util.ArrayList;
import java.util.List;

/*
 * Case 1: Both characters are upper-case
 *    Simply compare
 *
 * Case 1.2: Both charactersa re lower-case  ** Special Case
 *  Run a loop until either of the string gets completed or upper case character is found in either string
 *  - if both charcter matches then increment both string pointers
 *  - if characters mismatches then increment only the matching string pointer
 * 
 * Case 2: Pattern char is uppercase and Matching string char is lowercase
 *   Bring matching string idx until it gets out of bound or any upper case character found
 * 
 * Case 3: Both indices gets out of bound : True
 * 
 * Case 4: Pattern index in bound and matching string index is out of bound: False
 * 
 * Case 5: Pattern string completed and matching string is not completed
 *  Iterate whole matching string and add false if any upper case character found and true if not
 * 

 */
public class CamelCaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            String match = queries[i];

            int mi = 0;
            int pi = 0;

            boolean isAdded = false;

            while (mi < match.length() && pi < pattern.length()) {
                char mchar = match.charAt(mi);
                char pchar = pattern.charAt(pi);

                if (Character.isUpperCase(pchar) && Character.isLowerCase(mchar)) {
                    while (mi < match.length() && Character.isLowerCase(match.charAt(mi))) {
                        mi++;
                    }

                    if (mi >= match.length()) {
                        break;
                    }
                    mchar = match.charAt(mi);
                } else if (Character.isLowerCase(pchar) && Character.isLowerCase(mchar)) {
                    if (Character.compare(pchar, mchar) == 0) {
                        pi++;
                        mi++;
                    } else {
                        mi++;
                    }
                } else { // Both upper case
                    if (Character.compare(mchar, pchar) != 0) {
                        list.add(false);
                        isAdded = true;
                        break;
                    } else {
                        mi++;
                        pi++;
                    }

                }
            }

            if (isAdded) {
                continue;
            }

            if (mi >= match.length() && pi >= pattern.length()) {
                list.add(true);
            } else if (pi >= pattern.length() && mi < match.length()) {
                boolean isUpperCaseFound = false;

                while (mi < match.length()) {
                    if (Character.isUpperCase(match.charAt(mi))) {
                        isUpperCaseFound = true;
                        break;
                    }
                    mi++;
                }

                if (isUpperCaseFound) {
                    list.add(false);
                } else {
                    list.add(true);
                }

            } else {
                list.add(false);
            }
        }
        return list;
    }
}

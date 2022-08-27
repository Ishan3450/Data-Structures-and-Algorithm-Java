public class Patterns {
    public static void main(String[] args) {
        pattern1();
        System.out.println("------------------------");
        pattern2(5);
        System.out.println("------------------------");
        pattern3(5);
        System.out.println("------------------------");
        pattern4(5);
        System.out.println("------------------------");
        pattern5(5);
        System.out.println("------------------------");
        pattern6(5);
        System.out.println("------------------------");
        pattern7(5);
        System.out.println("------------------------");
        pattern8(9);
        System.out.println("------------------------");
        pattern9(9);
        System.out.println("------------------------");
        pattern10(5);
        System.out.println("------------------------");
        pattern11(5);
        System.out.println("------------------------");
        pattern12(5);
        System.out.println("------------------------");
        pattern17(5);
        System.out.println("------------------------");
        pattern21(5);
        System.out.println("------------------------");
        pattern22(5);

        System.out.println("------------------------");
        pattern26(6);

        System.out.println("------------------------");
        pattern28(5);

        System.out.println("------------------------");
        pattern30(5);
        System.out.println("------------------------");
        pattern31(4);

        System.out.println("------------------------");
        pattern35(4);
    }

    // *****
    // *****
    // *****
    // *****
    // *****
    static void pattern1() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // *
    // **
    // ***
    // ****
    // *****
    static void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // *****
    // ****
    // ***
    // **
    // *
    static void pattern3(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    // 1
    // 1 2
    // 1 2 3
    // 1 2 3 4
    // 1 2 3 4 5
    static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // *
    // **
    // ***
    // ****
    // *****
    // ****
    // ***
    // **
    // *
    static void pattern5(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    // *
    // **
    // ***
    // ****
    // *****
    static void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
            // loop for spaces
            for (int j = n; j >= i - 1; j--) {
                System.out.print("  "); // put
            }

            // main inner loop
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // *****
    // ****
    // ***
    // **
    // *
    static void pattern7(int n) {
        for (int i = n; i >= 1; i--) {
            // spaces
            for (int j = n; j > i; j--) {
                System.out.print("  ");
            }

            // main inner loop
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // * - 1
    // *** - 3
    // ***** - 5
    // ******* - 7
    // ********* - 9
    // * Odd sequence detected in the pattern
    static void pattern8(int n) {

        for (int i = 1; i <= n; i += 2) {
            // spaces
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // *********
    // *******
    // *****
    // ***
    // *
    // same as pattern 8 odd seq.
    static void pattern9(int n) {
        for (int i = n; i >= 1; i -= 2) {
            // spaces
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // *
    // * *
    // * * *
    // * * * *
    // * * * * *
    static void pattern10(int n) {
        for (int i = 1; i <= n; i++) {
            // loop for spaces
            for (int j = n; j >= i - 1; j--) {
                System.out.print(" ");
            }

            // main inner loop
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // * * * * *
    // * * * *
    // * * *
    // * *
    // *
    static void pattern11(int n) {
        for (int i = n; i >= 1; i--) {
            // spaces
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }

            // main inner loop
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // * * * * *
    // * * * *
    // * * *
    // * *
    // *
    // *
    // * *
    // * * *
    // * * * *
    // * * * * *
    static void pattern12(int n) {

        for (int i = n; i >= 1; i--) {
            // spaces
            for (int j = 5; j >= i; j--) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 1
    // 212
    // 32123
    // 4321234
    // 32123
    // 212
    // 1
    static void pattern17(int n) {
        for (int i = 1; i < n * 2; i++) {
            int noOfColsInRow = i > n ? n * 2 - i : i;

            // spaces
            int noOfSpaces = n - noOfColsInRow;
            for (int j = 5; j >= noOfColsInRow; j--) {
                System.out.print(" ");
            }

            for (int k = noOfColsInRow; k >= 1; k--) {
                System.out.print(k + "");
            }

            for (int l = 2; l <= noOfColsInRow; l++) {
                System.out.print(l + "");
            }
            System.out.println();

        }
    }

    // 1
    // 2 3
    // 4 5 6
    // 7 8 9 10
    // 11 12 13 14 15
    static void pattern21(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // if condition id only for formatting purpose
                if (count <= 10) {
                    System.out.print(count + "  ");
                } else {
                    System.out.print(count + " ");
                }
                count++;
            }
            System.out.println();
        }
    }

    // 1
    // 0 1
    // 1 0 1
    // 0 1 0 1
    // 1 0 1 0 1
    static void pattern22(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                if (j % 2 == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }

    // 1 1 1 1 1 1
    // 2 2 2 2 2
    // 3 3 3 3
    // 4 4 4
    // 5 5
    // 6
    static void pattern26(int n) {
        int tempTrack = 1;
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(tempTrack + " ");
            }
            tempTrack++;
            System.out.println();
        }
    }

    // *
    // * *
    // * * *
    // * * * *
    // * * * * *
    // * * * *
    // * * *
    // * *
    // *
    static void pattern28(int n) {
        for (int i = 1; i <= n * 2; i++) {
            int noOfColsInRow = i > n ? 2 * n - i : i;

            // spaces
            int noOfSpaces = n - noOfColsInRow;
            for (int j = 1; j <= noOfSpaces; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= noOfColsInRow; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 1
    // 2 1 2
    // 3 2 1 2 3
    // 4 3 2 1 2 3 4
    // 5 4 3 2 1 2 3 4 5
    static void pattern30(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = n; j >= i; j--) {
                System.out.print("  ");
            }

            // 1st half
            for (int k = i; k >= 1; k--) {
                System.out.print(k + " ");
            }

            // 2nd half
            for (int l = 2; l <= i; l++) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }

    // 4 4 4 4 4 4 4
    // 4 3 3 3 3 3 4
    // 4 3 2 2 2 3 4
    // 4 3 2 1 2 3 4
    // 4 3 2 2 2 3 4
    // 4 3 3 3 3 3 4
    // 4 4 4 4 4 4 4
    // Observations:
    // to place the element think the pattern is like a box
    // then take a element position and get the distance from up, down, left, right
    // and at last get the minimum element from the all directions
    static void pattern31(int n) {
        int originalN = n + 1;
        n = n * 2;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {

                int atEveryIndex = originalN - Math.min(Math.min(i, j), Math.min(n - i, n - j));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }

    // 1 1
    // 12 21
    // 123 321
    // 12344321
    static void pattern35(int n) {
        for (int i = 1; i <= n * 2; i++) {
            for (int k = 1; k <= i - n; k++) {
                System.out.print(k + " ");
            }

            // spaces
            for (int j = 1; j <= n * 2 - i; j++) {
                System.out.print("    ");
            }

            for (int k = i - n; k >= 1; k--) {
                System.out.print(k + " ");
            }
            System.out.println();

        }
    }
}

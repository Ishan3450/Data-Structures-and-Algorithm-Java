package Stack;

import java.util.*;

public class CarFleet2 {
    public double[] getCollisionTimes(int[][] cars) {
        double[] ans = new double[cars.length];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>(); // to store idx

        for (int i = cars.length - 1; i >= 0; i--) {
            int position = cars[i][0];
            int speed = cars[i][1];

            // removal of cars from stack whose speed is faster than curr car
            while (!st.isEmpty() && speed <= cars[st.peek()][1]) {
                st.pop();
            }

            // now the main part
            while (!st.isEmpty()) {
                double collisionTime = (cars[st.peek()][0] - cars[i][0]) / (double) (cars[i][1] - cars[st.peek()][1]);

                if (ans[st.peek()] == -1 || collisionTime <= ans[st.peek()]) {
                    ans[i] = collisionTime;
                    break;
                }
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}
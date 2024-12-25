package Stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {
    private class Car {
        int position, speed;

        Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] carr = new Car[speed.length];
        for (int i = 0; i < carr.length; i++) {
            carr[i] = new Car(position[i], speed[i]);
        }

        Comparator<Car> comp = new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return c2.position - c1.position;
            }
        };

        Arrays.sort(carr, comp);
        Stack<Double> st = new Stack<>();
        for (int i = 0; i < carr.length; i++) {
            double timeToReach = (double) (target - carr[i].position) / (double) carr[i].speed;

            if (st.isEmpty() || st.peek() < timeToReach) {
                st.push(timeToReach);
            }
        }
        return st.size();
    }
}

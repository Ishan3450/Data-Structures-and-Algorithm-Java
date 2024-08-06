package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RobotCollision {
    private class Robot {
        int position;
        int health;
        char direction;
        int index;

        Robot(int position, int health, char direction, int index) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Stack<Robot> st = new Stack<>();
        Robot[] robots = new Robot[healths.length];
        for (int i = 0; i < healths.length; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }
        Arrays.sort(robots, (a, b) -> a.position - b.position);

        for (int i = 0; i < robots.length; i++) {
            Robot currRobot = robots[i];
            if (st.isEmpty() || st.peek().direction == currRobot.direction
                    || (st.peek().direction == 'L' && currRobot.direction == 'R')) {
                st.push(currRobot);
            } else {
                while (!st.isEmpty() && (st.peek().direction == 'R' && currRobot.direction == 'L')
                        && st.peek().health < currRobot.health) {
                    currRobot.health--;
                    st.pop();
                }

                if (st.isEmpty() || st.peek().direction == currRobot.direction
                        || (st.peek().direction == 'L' && currRobot.direction == 'R')) {
                    st.push(currRobot);
                } else if (st.peek().health == currRobot.health) {
                    st.pop();
                } else if (st.peek().health > currRobot.health) {
                    st.peek().health--;
                }
            }
        }

        Collections.sort(st, (a, b) -> b.index - a.index); // sorting stack in descending order as it follows LIFO
                                                           // structure

        List<Integer> list = new ArrayList<>();
        while (!st.isEmpty()) {
            list.add(st.pop().health);
        }
        return list;
    }
}

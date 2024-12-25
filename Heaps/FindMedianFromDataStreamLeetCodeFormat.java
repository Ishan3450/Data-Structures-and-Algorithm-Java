package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStreamLeetCodeFormat {
    PriorityQueue<Integer> leftOfMedian = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightOfMedian = new PriorityQueue<>();

    public void addNum(int num) {
        if (leftOfMedian.size() + 1 == rightOfMedian.size()) {
            if (num > rightOfMedian.peek()) {
                leftOfMedian.add(rightOfMedian.remove());
                rightOfMedian.add(num);
            } else {
                leftOfMedian.add(num);
            }
        } else if (leftOfMedian.size() == rightOfMedian.size() + 1) {
            if (num < leftOfMedian.peek()) {
                rightOfMedian.add(leftOfMedian.remove());
                leftOfMedian.add(num);
            } else {
                rightOfMedian.add(num);
            }
        } else { // leftOfMedian.size() == rightOfMedian.size()

            // if size is same we will insert on basis of value of num by comparing it with
            // the leftOfMedian.peek() and rightOfMedian.peek()

            if (leftOfMedian.isEmpty() || num < leftOfMedian.peek()) {
                leftOfMedian.add(num);
            } else { // num >= leftOfMedian.peek()
                rightOfMedian.add(num);
            }
        }
    }

    public double findMedian() {
        if (leftOfMedian.size() == rightOfMedian.size()) {
            return (leftOfMedian.peek() + rightOfMedian.peek()) / 2d;
        } else if (leftOfMedian.size() == rightOfMedian.size() + 1) {
            return leftOfMedian.peek();
        } else { // rightOfMedian.size() == leftOfMedian.size()+1
            return rightOfMedian.peek();
        }
    }
}

/*
 * 
 * Psuedo code (developed while getting the approach) :
 * 
 * max is left and min is right
 * 
 * insert()
 * {
 *      if(max.size()+1 == min.size()){ // min has more elements then max
 *          if(num > min.top()) {
 *              max.add(min.remove())
 *              min.add(num)
 *          } else { // num <= min.top()
 *              max.add(num)
 *          }
 *      } else if(max.size() == min.size()+1) { // max has more elements then min
 *          if(num < max.top()){
 *              min.add(max.remove())
 *              max.add(num)
 *          } else { // num >= max.top()
 *              min.add(num)
 *          }
 *      } else { // max.size() == min.size()
 *          if(max.isEmpty() || num < max.top()){
 *              max.add(num);
 *          } else { // num >= max.top()
 *              min.add(num);
 *          }
 *      }
 * }
 * 
 * add()
 * {
 *      if(min.size() == max.size()){
 *           return (min.top() + max.top()) / 2;
 *      } else if(min.size() == max.size()+1){ // min has more elements than max
 *           return min.top();
 *      } else { // max.size() == min.size()+1 max has more elements then min
 *           return max.top();
 *      }
 * }
 */

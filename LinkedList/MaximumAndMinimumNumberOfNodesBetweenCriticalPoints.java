package LinkedList;

public class MaximumAndMinimumNumberOfNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(Node head) {
        if (head == null || head.next == null) {
            return new int[] { -1, -1 };
        }

        Node prev = head;
        Node curr = head.next;
        Node next = curr.next;

        // idx to keep track of nodes
        int idx = 2; // initially idx = 2 because we are starting from head.next not the head

        // distances between critical points
        int minDist = Integer.MAX_VALUE;
        int maxDist = Integer.MIN_VALUE;

        // critical pointes having value as index in the list
        int firstCP = -1;
        int lastCP = -1;

        while (next != null) {
            if (isCriticalPoint(prev, curr, next)) {
                System.out.println("Found critical point " + curr.data + " with idx: " + idx);
                if (firstCP == -1) {
                    firstCP = idx;
                }

                if (lastCP != -1) {
                    minDist = Math.min(minDist, idx - lastCP);
                }

                lastCP = idx;
            }

            // updating pointers and index
            idx++;
            prev = curr;
            curr = next;
            next = next.next;
        }

        if (firstCP == -1 || lastCP == -1 || firstCP == lastCP) {
            return new int[] { -1, -1 };
        }

        maxDist = lastCP - firstCP;

        return new int[] { minDist, maxDist };
    }

    public boolean isCriticalPoint(Node prev, Node curr, Node next) {
        if (curr.data > prev.data && curr.data > next.data) {
            return true;
        }

        if (curr.data < prev.data && curr.data < next.data) {
            return true;
        }

        return false;
    }
}

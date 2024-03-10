package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {
    private class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    double fractionalKnapsack(int W, Item arr[], int n) {
        Comparator<Item> sortByRatio = new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                double ratio1 = (double) i1.value / i1.weight; // important to convert int to double here
                double ratio2 = (double) i2.value / i2.weight; // important to convert int to double here

                if (ratio1 == ratio2)
                    return 0;
                return ratio1 > ratio2 ? -1 : 1; // descending order
            }
        };

        Arrays.sort(arr, sortByRatio);

        double valueInSack = 0.0;

        for (int i = 0; i < n; i++) {
            if (W == 0)
                break;

            if (arr[i].weight <= W) {
                W -= arr[i].weight;
                valueInSack += arr[i].value;
            } else {
                valueInSack += ((double) arr[i].value / arr[i].weight) * W; // important to convert int to double here
                break;
            }
        }
        return valueInSack;
    }
}

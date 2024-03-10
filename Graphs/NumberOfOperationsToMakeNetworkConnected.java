package Graphs;

public class NumberOfOperationsToMakeNetworkConnected {
    private int findParentWithPathCompression(int source, int[] parent){
        if(parent[source] == source){
            return source;
        }

        return parent[source] = findParentWithPathCompression(parent[source], parent);
    }

    private void unionSet(int parentOfSource, int parentOfDestination, int[] power, int[] parent){
        // here no need to call find parent method as we are passing parents of source and destination directly in the argouements
        // int parentOfSource = findParentWithPathCompression(source, parent);
        // int parentOfDestination = findParentWithPathCompression(destination, parent);

        if(power[parentOfDestination] > power[parentOfSource]){
            parent[parentOfSource] = parentOfDestination;
            power[parentOfDestination] ++;
        } else { //power[parentOfDestination] <= power[parentOfSource]
            parent[parentOfDestination] = parentOfSource;
            power[parentOfSource] ++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int[] power = new int[n];
        int[] parent = new int[n];
        for(int i = 0; i < n; i ++){
            parent[i] = i;
        }

        int extraEdges = 0;

        for(int[] connection: connections){
            int source = connection[0];
            int destination = connection[1];

            int parentOfSource = findParentWithPathCompression(source, parent);
            int parentOfDestination = findParentWithPathCompression(destination, parent);

            if(parentOfSource == parentOfDestination){
                // this is an extra edge
                extraEdges ++;
            } else { 
                // new edge found do union set on that
                unionSet(parentOfSource, parentOfDestination, power, parent);
            }
        }

        int totalComponents = 0;
        for(int i = 0 ; i < n ; i ++){
            /**
                How we can find a componenet or how to get total components in a network

                if parent[i] is i itself means the nodes is its parent itself so we can count it as a parent
             */

             if(parent[i] == i){
                totalComponents ++;
             }
        }

        int requiredEdges = totalComponents-1;
        
        if(extraEdges >= requiredEdges){
            return requiredEdges; // fullfill the criteria
        } 
        return -1;
    }
}

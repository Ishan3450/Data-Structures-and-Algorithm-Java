package Graphs;

public class UnionSetAndPathCompression {
    public int findParentWithPathCompression(int source, int[] parent){
        if(parent[source] == source){
            return source;
        }

        return parent[source] = findParentWithPathCompression(parent[source], parent);
    }

    public void unionSet(int parentOfSource, int parentOfDestination, int[] power, int[] parent){
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
}

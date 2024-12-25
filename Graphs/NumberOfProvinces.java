package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        Set<Integer> isVisited = new HashSet<>();

        // for(int i = 0 ; i < isConnected.length ; i ++){
        // if(!isVisited.contains(i)){
        // provinces ++;
        // bfs(isConnected, isVisited, i);
        // }
        // }

        for (int i = 0; i < isConnected.length; i++) {
            if (!isVisited.contains(i)) {
                provinces++;
                dfs(isConnected, isVisited, i);
            }
        }

        return provinces;
    }

    public void dfs(int[][] isConnected, Set<Integer> isVisited, int source) {
        isVisited.add(source);

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[source][i] == 1 && !isVisited.contains(i)) {
                dfs(isConnected, isVisited, i);
            }
        }
    }

    public void bfs(int[][] isConnected, Set<Integer> isVisited, int source) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        isVisited.add(source);

        while (!q.isEmpty()) {
            int peek = q.remove();

            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[peek][i] == 1 && !isVisited.contains(i)) {
                    q.add(i);
                    isVisited.add(i);
                }
            }
        }
    }
}

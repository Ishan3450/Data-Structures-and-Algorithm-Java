package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountsMerge {
    private int findParent(int source, int[] parent) {
        if (parent[source] == source) {
            return source;
        }

        return parent[source] = findParent(parent[source], parent);
    }

    private void unionSet(int source, int destination, int[] power, int[] parent) {
        int parentOfSource = findParent(source, parent);
        int parentOfDestination = findParent(destination, parent);

        if (power[parentOfDestination] > power[parentOfSource]) {
            parent[parentOfSource] = parentOfDestination;
            power[parentOfDestination]++;
        } else {
            parent[parentOfDestination] = parentOfSource;
            power[parentOfSource]++;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> mailToAccountsIndex = new HashMap<>();
        int[] power = new int[accounts.size()];
        int[] parent = new int[accounts.size()];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String mail = account.get(j);

                if (mailToAccountsIndex.containsKey(mail)) {
                    unionSet(i, mailToAccountsIndex.get(mail), power, parent);
                } else {
                    mailToAccountsIndex.put(mail, i);
                }
            }
        }

        // we will create below hash map with the help of parent array, this hashmap is
        // one step previous to get our final answer, we will be using this map to
        // create our final answer
        HashMap<Integer, TreeSet<String>> accountIndexToMergedMails = new HashMap<>();

        for (Map.Entry<String, Integer> pair : mailToAccountsIndex.entrySet()) {
            String mail = pair.getKey();
            int idx = pair.getValue();
            int p = findParent(idx, parent);

            accountIndexToMergedMails.putIfAbsent(p, new TreeSet<>());
            accountIndexToMergedMails.get(p).add(mail);
        }

        // final answer creation
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int key : accountIndexToMergedMails.keySet()) {
            String owner = accounts.get(key).get(0);
            List<String> temp = new ArrayList<>();
            temp.add(owner);
            temp.addAll(accountIndexToMergedMails.get(key));
            mergedAccounts.add(temp);
        }
        return mergedAccounts;
    }
}
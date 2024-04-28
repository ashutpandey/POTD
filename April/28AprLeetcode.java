// Leetcode problem link
// https://leetcode.com/problems/sum-of-distances-in-tree/

import java.util.*;
class Solution {
    long resultBaseNode = 0;
    int[] count;
    int N;

    int dfsBase(Map<Integer, List<Integer>> adj, int currNode, int prevNode, int currDepth) {
        int totalNode = 1;

        resultBaseNode += currDepth;

        for (int child : adj.get(currNode)) {
            if (child == prevNode)
                continue;

            totalNode += dfsBase(adj, child, currNode, currDepth + 1);
        }
        count[currNode] = totalNode;

        return totalNode;
    }

    void dfs(Map<Integer, List<Integer>> adj, int parentNode, int prevNode, int[] result) {
        for (int child : adj.get(parentNode)) {
            if (child == prevNode)
                continue;

            result[child] = result[parentNode] - count[child] + (N - count[child]);
            dfs(adj, child, parentNode, result);
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        N = n;
        count = new int[n];
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        resultBaseNode = 0;

        dfsBase(adj, 0, -1, 0);

        int[] result = new int[n];

        result[0] = (int) resultBaseNode;

        dfs(adj, 0, -1, result);

        return result;
    }

}
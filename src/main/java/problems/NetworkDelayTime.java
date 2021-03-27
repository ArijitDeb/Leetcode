package problems;

import java.util.*;

/**
 * https://leetcode.com/problems/network-delay-time/
 * 743. Network Delay Time
 * <p>
 * You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed
 * edges times[i] = (ui, vi, wi), where ui is the source node,
 * vi is the target node, and wi is the time it takes for a
 * signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k.
 * Return the time it takes for all the n nodes to receive
 * the signal. If it is impossible for all the n nodes to
 * receive the signal, return -1.
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Edge>[] edges = new List[n];
        for (int[] t : times) {
            Edge edge = new Edge(t);
            if (edges[edge.u] == null) {
                edges[edge.u] = new LinkedList<>();
            }
            edges[edge.u].add(edge);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[--k] = 0;
        boolean[] visited = new boolean[n];

        IndexMinPQ minHeap = new IndexMinPQ(n);
        minHeap.insert(k, 0);

        while (!minHeap.isEmpty()) {
            int[] minKeyVal = minHeap.delMin();
            int minNode = minKeyVal[0];
            int minDist = minKeyVal[1];

            visited[minNode] = true;
            if (dist[minNode] < minDist ||
                    edges[minNode] == null) {
                continue;
            }
            for (Edge e : edges[minNode]) {
                if (visited[e.v]) {
                    continue;
                }
                int newDist = dist[e.u] + e.w;
                if (newDist < dist[e.v]) {
                    dist[e.v] = newDist;
                    if(minHeap.contains(e.v)){
                        minHeap.decreaseKey(e.v, newDist);
                    }else{
                        minHeap.insert(e.v, newDist);
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                max = Math.max(max, dist[i]);
            }
        }
        return max;
    }
}

class Edge {

    int u, v;
    int w;

    Edge(int[] tuple) {
        this.u = tuple[0] - 1;
        this.v = tuple[1] - 1;
        this.w = tuple[2];
    }

    @Override public String toString() {
        return "Edge [u=" + u + ", v=" + v + ", w=" + w + "]";
    }

}

class IndexMinPQ {

    private int maxN;        // maximum number of elements on PQ
    private int n;           // number of elements on PQ
    private int[] pq;        // binary heap using 1-based indexing
    private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
    private int[] keys;      // keys[i] = priority of i

    public IndexMinPQ(int maxN) {
        if (maxN < 0)
            throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        keys = new int[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }
    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        return qp[i] != -1;
    }

    public void insert(int i, int key) {
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    public int[] delMin() {
        int min = pq[1];
        int minKey = keys[min];
        exch(1, n--);
        sink(1);
        qp[min] = -1;        // delete
        pq[n + 1] = -1;      // not needed
        return new int[]{min, minKey};
    }

    public void decreaseKey(int i, int key) {
        keys[i] = key;
        swim(qp[i]);
    }

    private boolean greater(int i, int j) {
        return Integer.compare(keys[pq[i]], keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1))
                j++;
            if (!greater(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }
}

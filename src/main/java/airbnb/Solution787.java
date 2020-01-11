package airbnb;

import java.util.*;

public class Solution787 {

    /**
     * 直觉和算法
     *
     * Dijkstra's 算法的思想是，按照cost从小到大的顺序扩展所有的飞行路线。当城市被添加到dst时，dst中对应的值即是到达该城市的最小花费。
     *
     * 在 Dijkstra 算法中，借助优先级队列持续搜索花费最低的下一个城市。
     *
     * 如果查找到某个城市，它原本的路线成本更低或者中转次数过多，则无需再搜索它。否则，如果搜索到目的城市，那么当前花费就是最低成本，因为每次最先搜索的就是最低成本航线。
     *
     * 否则，如果从 node 城市出发的航线花费更低，则将该节点加入到优先级队列用于搜索
     * @param n
     * @param flights
     * @param src
     * @      param dst
     * @param K
     * @return
     */
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        Map<Integer, Integer> best = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, src});

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int cost = info[0], k = info[1], place = info[2];
            if (k > K+1 || cost > best.getOrDefault(k*1000 + place, Integer.MAX_VALUE)) continue;
            if (place == dst) return cost;

            for (int nei = 0; nei < n; ++nei) {
                if (graph[place][nei] > 0) {
                    int newcost = cost + graph[place][nei];
                    if (newcost < best.getOrDefault((k+1)*1000 + nei, Integer.MAX_VALUE)) {
                        pq.offer(new int[]{newcost, k+1, nei});
                        best.put((k+1)*1000 + nei, newcost);
                    }
                }
            }
        }
        return -1;
    }

    public int findCheapestPriceWithGreedy(int n, int[][] flights, int src, int dst, int K) {
        int[][] dist = new int[2][n];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dist[0], INF);
        Arrays.fill(dist[1], INF);
        dist[0][src] = dist[1][src] = 0;

        for (int i = 0; i <= K; ++i)
            for (int[] edge: flights)
                dist[i&1][edge[1]] = Math.min(dist[i&1][edge[1]], dist[~i&1][edge[0]] + edge[2]);

        return dist[K&1][dst] < INF ? dist[K&1][dst] : -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int K = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, K));
    }
}

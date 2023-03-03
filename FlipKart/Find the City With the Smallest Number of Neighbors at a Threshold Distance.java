class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {

     public void dijkstra(int src, int[] dis, ArrayList<ArrayList<Pair>> adj) {

         PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)-> a.second - b.second);
         pq.add(new Pair(src, 0));
         dis[src] = 0;

         while(!pq.isEmpty()) {
             Pair curr = pq.poll();
             int frm = curr.first;
             int wt = curr.second;


             for(Pair ch : adj.get(frm)) {
                 int adjNode = ch.first;
                 int adjwght = ch.second;

                 if(dis[adjNode] > dis[frm] + adjwght) {
                     dis[adjNode] = dis[frm] + adjwght;
                     pq.add(new Pair(adjNode, dis[adjNode]));
                 }
             }
         }
     }

    void bellmanFord(int src, int[] dist, int[][] edges, int n) {

         for(int i = 0; i < n-1; i++) {
             for(int[] edge : edges) {
                 int u = edge[0];
                 int v = edge[1];
                 int wt = edge[2];

                 if(dist[v] > dist[u] + wt) {
                     dist[v] = dist[u] + wt;
                 }
                 //  as the edges are bidirectional we need to check for other direction as well
                 if(dist[u] > dist[v] + wt) {
                     dist[u] = dist[v] + wt;
                 }
             }
         }
     }

    void floyd(int n, int[][] dis, int[][] edges) {
        for(int v = 0; v < n; v++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][v] + dis[v][j]);
                }
            }
        }
    }

    

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dis = new int[n][n];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
           Arrays.fill(dis[i], (int) 1e6 + 7);
           adj.add(new ArrayList<>());
           dis[i][i] = 0;
        }

        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int wt = edge[2];

            adj.get(from).add(new Pair(to, wt));
            adj.get(to).add(new Pair(from, wt));
            dis[from][to] = wt;
            dis[to][from] = wt;
        }

        floyd(n, dis, edges);
        for(int i = 0; i < n; i++) {
            // dijkstra(i, dis[i], adj);
            // bellmanFord(i, dis[i], edges, n);
        }

        int minCity = -1;
        int minCount = n;

        for(int i = 0; i < n; i++) {
            int currCount = 0;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(dis[i][j] <= distanceThreshold) currCount++;
            }

            if(currCount <= minCount) {
                minCount = currCount;
                minCity = i;
            }
        }

        return minCity;
     }
}
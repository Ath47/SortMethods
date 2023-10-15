import java.util.*;

class ShortestPath {
	
	int minDist(int dist[], Boolean visited[]) {
		int min = Integer.MAX_VALUE, index = -1;

		for (int v = 0; v < dist.length; v++)
			if (!visited[v] && dist[v] <= min) {
				min = dist[v];
				index = v;
            }
		return index;
	}

	void dijkstra(int graph[][], int src, int V) {
		int dist[] = new int[V];
		Boolean visited[] = new Boolean[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		dist[src] = 0;
		for (int count = 0; count < V - 1; count++) {
			int u = minDist(dist, visited);
			visited[u] = true;
			for (int v = 0; v < V; v++)
				if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}
		printDistance(dist);
	}

    void printDistance(int dist[]) {
		System.out.println("Vertice \t Distance from Source");
		for (int i = 0; i < dist.length; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = scan.nextInt();

        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                System.out.println("Enter weight for vertice " + (i + "," + j));
                graph[i][j] = scan.nextInt();
                graph[j][i] = graph[i][j];
            }
        } 
        System.out.println("Graph: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }System.out.println();
        }
		ShortestPath sp = new ShortestPath();

		sp.dijkstra(graph, 0, n);
        scan.close();
	}
}

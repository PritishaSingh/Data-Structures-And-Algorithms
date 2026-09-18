class Solution {
    public boolean isBipartite(int[][] graph) {       
        int visited[]=new int[graph.length];
        Arrays.fill(visited,-1);
        for(int i=0; i<graph.length; i++){
             if (visited[i] == -1) {   // only unvisited nodes
                if (!bfs(graph, visited, i)) return false;
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph, int[] visited, int src){
        Queue<Integer> q=new LinkedList<>();
        q.offer(src);
        visited[src]=0;
        while(!q.isEmpty()){
            int node=q.remove();
            for(int neigh:graph[node]){
                if(visited[neigh]==-1){
                    visited[neigh]=1-visited[node];
                    q.offer(neigh);
                }else{
                   if( visited[neigh]!=(1-visited[node])){
                    return false;
                   }
                }
            }
        }
        return true;
    }
}
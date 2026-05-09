class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph
        for(int i = 0; i < prerequisites.length; i++){
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];

            adj.get(to).add(from);  // directed edge
            indegree[from]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Add nodes with indegree 0
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int count = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int neigh : adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }

        return count == numCourses;
    }
}
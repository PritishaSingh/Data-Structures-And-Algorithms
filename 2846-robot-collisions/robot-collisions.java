class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        
        // robot: {position, health, direction, original index}
        int[][] robots = new int[n][4];
        
        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i); // store char as int
            robots[i][3] = i;
        }
        
        // Sort by position
        Arrays.sort(robots, (a, b) -> a[0] - b[0]);
        
        Stack<Integer> stack = new Stack<>();
        boolean[] alive = new boolean[n];
        Arrays.fill(alive, true);
        
        for (int i = 0; i < n; i++) {
            if (robots[i][2] == 'R') {
                stack.push(i);
            } else {
                // moving left
                while (!stack.isEmpty() && alive[i]) {
                    int j = stack.peek();
                    
                    if (robots[j][1] < robots[i][1]) {
                        // stack robot dies
                        alive[j] = false;
                        stack.pop();
                        robots[i][1]--;
                    } else if (robots[j][1] > robots[i][1]) {
                        // current robot dies
                        alive[i] = false;
                        robots[j][1]--;
                    } else {
                        // both die
                        alive[i] = false;
                        alive[j] = false;
                        stack.pop();
                    }
                }
            }
        }
        
        // Collect survivors (original order)
        List<int[]> survivors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (alive[i]) {
                survivors.add(new int[]{robots[i][3], robots[i][1]});
            }
        }
        
        // Sort back to original index
        Collections.sort(survivors, (a, b) -> a[0] - b[0]);
        
        List<Integer> result = new ArrayList<>();
        for (int[] s : survivors) {
            result.add(s[1]);
        }
        
        return result;
    }
}
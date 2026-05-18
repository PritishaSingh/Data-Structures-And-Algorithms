class Solution {
    public int minJumps(int[] arr) {

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hm.get(arr[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hm.put(arr[i], list);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[arr.length];

        q.add(0);
        vis[0] = true;

        int step = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {
                int curr = q.poll();
                if (curr == arr.length - 1) {
                    return step;
                }
                int left = curr - 1;
                int right = curr + 1;
                if (left >= 0 && !vis[left]) {
                    vis[left] = true;
                    q.add(left);
                }
                if (right < arr.length && !vis[right]) {
                    vis[right] = true;
                    q.add(right);
                }
                for (int idx : hm.get(arr[curr])) {

                    if (!vis[idx]) {
                        vis[idx] = true;
                        q.add(idx);
                    }
                }
                hm.get(arr[curr]).clear();
            }

            step++;
        }

        return -1;
    }
}
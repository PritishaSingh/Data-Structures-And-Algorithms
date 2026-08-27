class Solution {
    public String simplifyPath(String path) {

        String[] parts = path.split("/+");
        Stack<String> s = new Stack<>();

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(part);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (String dir : s) {
            ans.append("/").append(dir);
        }

        return ans.length() == 0 ? "/" : ans.toString();
    }
}
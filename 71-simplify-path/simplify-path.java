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
        if(s.isEmpty()) return "/";

      String res="";
      while(!s.isEmpty()){
        res="/"+s.pop()+res;
        
      }
      return res;
    }
}
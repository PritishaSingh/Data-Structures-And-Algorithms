class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=0; i<arr.length; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
        }
        HashSet<Integer> h=new HashSet<>();
        for(Map.Entry<Integer, Integer>  e:hm.entrySet()){
            if(h.contains(e.getValue())) return false;
            h.add(e.getValue());
        }
        return true;
    }
}
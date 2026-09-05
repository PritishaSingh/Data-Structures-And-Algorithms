class Solution {

    class Pair implements Comparable <Pair>{
        String video;
        int freq;
        Pair(String video, int freq){
            this.video=video;
            this.freq=freq;
        }

        public int compareTo(Pair that){
            if(this.freq==that.freq){
                return this.video.compareTo(that.video);
            }
            return this.freq-that.freq;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
       Queue<Integer> q=new LinkedList<>();
       HashSet<Integer> hs =new HashSet<>(); 
    
       int currlevel=0;
       q.offer(id);
       hs.add(id);
       while(!q.isEmpty()){
        int size=q.size();
        for(int i=0; i<size; i++){
            int currId=q.remove();
            for(int y: friends[currId]){
            if(!hs.contains(y)){
                q.offer(y);
                hs.add(y);
            }
            }
        }
        currlevel++;
        if(currlevel==level){
            break;
        }
       }

       HashMap<String, Integer> freqmap=new HashMap<>();
       while(!q.isEmpty()){
        int currId=q.poll();
        for(String video: watchedVideos.get(currId)){
            freqmap.put(video, freqmap.getOrDefault(video,0)+1);
        }
       }

        List<Pair> videoList=new ArrayList<>();
        for(String video: freqmap.keySet()){
            videoList.add(new Pair(video, freqmap.get(video)));
        }
       
        Collections.sort(videoList);
        List<String> res=new ArrayList<>();
        for(Pair pair:videoList){
            res.add(pair.video);
        }
        
       
       return res;
    }
}
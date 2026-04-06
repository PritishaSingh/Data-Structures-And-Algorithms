class Solution {
    public boolean equationsPossible(String[] equations) {
       DisjointSet dsu=new DisjointSet(26);
       ArrayList<int[]> notEqualEdges=new ArrayList<>();
       for(String e:equations){
        int u=e.charAt(0)-'a';
        int v=e.charAt(3)-'a';

        if(e.charAt(1)=='='){
            dsu.unionBySize(u,v);
        }else{
            notEqualEdges.add(new int[]{u,v});
        }
       } 

       for(int edge[]: notEqualEdges){
        int u=edge[0];
        int v=edge[1];
        if(dsu.findRootParent(u)==dsu.findRootParent(v)){
            return false;
        }
       }
       return true;
    }
}

public class DisjointSet{
    int parent[];
    int size[];
    DisjointSet(int nodes){
        this.parent=new int[nodes];
        this.size=new int[nodes];
    for(int i=0; i<nodes; i++){
        this.parent[i]=i;
        this.size[i]=1;
    }
}

public int findRootParent(int node){
    if(parent[node]==node){
        return node;
    }

    parent[node]=findRootParent(parent[node]);
    return parent[node];
}

public boolean unionBySize(int node1, int node2){
    int rp1=findRootParent(node1);
    int rp2=findRootParent(node2);
    if(rp1==rp2){
        return false;
    }
    if(size[rp1]<size[rp2]){
        parent[rp1]=rp2;
        size[rp2]+=size[rp1];
    }else{
         parent[rp2]=rp1;
        size[rp1]+=size[rp2];
    }
    return true;
}


}
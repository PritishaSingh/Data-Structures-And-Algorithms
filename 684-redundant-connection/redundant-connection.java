class Solution {
    int totalnodes;
    public int[] findRedundantConnection(int[][] edges) {
        totalnodes=edges.length;
        int res[]=new int[2];
        DisjointSet dsu=new DisjointSet(totalnodes);
        for(int [] edge:edges){
            if(!dsu.unionBySize(edge[0]-1, edge[1]-1)){
                res=edge;
            }
        }
        return res;
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
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }

        int wires=0;
        DisjointSet dsu=new DisjointSet(n);
        for(int connection[]:connections){
            int u=connection[0];
            int v=connection[1];
            if(dsu.unionBySize(u,v)){
                wires++;
            }

        }
        return n-1-wires;
    }
}

class DisjointSet{
    int parent[];
    int size[];
    DisjointSet(int n){
        this.parent=new int[n];
        this.size=new int[n];
        for(int i=0; i<n; i++){
            this.parent[i]=i;
            this.size[i]=1;
        }
    }



public int findRootParent(int n){
    if(parent[n]==n){
        return n;
    }
    parent[n]=findRootParent(parent[n]);
    return parent[n];
}

public boolean unionBySize(int node1, int node2){
    int rp1=findRootParent(node1);
    int rp2=findRootParent(node2);
    if(rp1==rp2){
        return false;
    }
    if(size[rp1]<size[rp2]){
        parent[rp1]=rp2;
        size[rp1]+=size[rp2];
    }
    else{
        parent[rp2]=rp1;
        size[rp2]+=size[rp1];
    }
    return true;
}
}
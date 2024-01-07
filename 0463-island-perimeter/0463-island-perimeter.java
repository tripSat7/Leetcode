class Pair{
    int first, second;
    
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int vis[][] = new int[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = bfs(grid, i, j, vis);
                    return res;
                }
            }
        }
        
        return res;
    }
    
    public int bfs(int[][] grid, int r, int c, int[][] vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        vis[r][c] = 1;
        int per = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int[] arow={-1,0,0,1};
        int[] acol={0,-1,+1,0};
        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col=q.peek().second;
            
            q.remove();
            for (int i=0;i<arow.length;i++)
            {
                int row1=row+arow[i];
                int col1=col+acol[i];
                
                if(row1>=0 && row1<m && col1>=0 && col1<n && grid[row1][col1] == 1 && vis[row1][col1]==0)
                {
                    q.add(new Pair(row1,col1));
                    vis[row1][col1]=1;
                }
                
                if((row1 == -1 || row1 == m || col1 == -1 || col1 == n ) || (row1>=0 && row1<m && col1>=0 && col1<n && grid[row1][col1] == 0)){
                    per++;
                }
            }
        }
    
        return per;
    }
}
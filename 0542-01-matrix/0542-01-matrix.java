class Pair{
    int first, second, third;
    
    Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int vis[][] = new int[m][n];
        int dist[][] = new int[m][n];
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
        
        int arow[] = {-1,0,+1,0};
        int acol[] = {0,+1,0,-1};
        
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            
            dist[row][col] = steps;
            
            for(int i = 0; i< 4; i++){
                int nr = row + arow[i];
                int nc = col + acol[i];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == 0){
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr,nc,steps+1));
                }
            }
        }
        
        return dist;
    }
}
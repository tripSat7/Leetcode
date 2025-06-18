// Time Complexity: O(N * M), worst case the entire grid needs to be traversed
// Space Complexity: O(N)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc] == color){ 
            return image;
        }
        
        dfs(image, sr, sc, image[sr][sc], color);
        
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int curr, int color){
        
        if( sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length ||
            image[sr][sc] != curr){
                return;
        }
        
        image[sr][sc] = color;
        dfs(image, sr-1, sc, curr, color);
        dfs(image, sr+1, sc, curr, color);
        dfs(image, sr, sc+1, curr, color);
        dfs(image, sr, sc-1, curr, color);
        
    }
}
class Solution {
    public int maxDistance(String s, int k) {
        int E = 0, W = 0, N = 0, S = 0;
        int x = 0, y = 0;
        int Md = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == 'N') {
                y++;
                N++;
            } else if (ch == 'S') {
                y--;
                S++;
            } else if (ch == 'E') {
                x++;
                E++;
            } else if (ch == 'W') {
                x--;
                W++;
            }
            
            // rx: number of cancelling moves in horizontal direction
            int rx = Math.min(E, W);
            // ry: number of cancelling moves in vertical direction
            int ry = Math.min(N, S);
            
            // We can flip at most k moves, but only as many as the total cancellations (rx + ry)
            int j = Math.min(k, rx + ry);
            
            // Each flip adds 2 to the Manhattan distance.
            int candidate = Math.abs(x) + Math.abs(y) + 2 * j;
            
            // Update the maximum Manhattan distance found so far.
            Md = Math.max(Md, candidate);
        }
        
        return Md;
    }
}

class Solution {
    public double separateSquares(int[][] squares) {
        int ymax = 0;
        double totArea = 0;
        for(int i = 0; i < squares.length; i++){
            ymax = Math.max(squares[i][1] + squares[i][2], ymax);
            totArea = totArea + 1.0 * squares[i][2] * squares[i][2];
        }

        double left = 0, right = ymax, epsilon = 1e-6, res = 0;

        while(left <= right){
            double mid = left + (right - left)/2;

            if(helper(squares, mid, totArea)){
                left = mid + (1e-6);
            }
            else{
                res = mid;
                right = mid - (1e-6);
            }
        }
        
        return res;
    }

    public boolean helper(int[][] squares, double mid, double tot){
        double sum = 0;

        for(int i = 0; i < squares.length; i++){
            int y = squares[i][1];
            int l = squares[i][2];
            if(y + l <= mid) {
                sum += ((double) l) * ((double) l);
            } 
            else{
                if(y < mid) {
                    sum += ((double) l) * ((double) mid - (double) y);
                }
            }
        }

        return sum < tot/2; 
    }
}
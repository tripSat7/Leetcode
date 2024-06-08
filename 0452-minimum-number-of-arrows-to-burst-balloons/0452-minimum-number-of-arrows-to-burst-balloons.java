class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x, y) -> Integer.compare(x[1], y[1]) );
        int result = 1;
        int index = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[index][1]) {
                index = i;
                result++;
            }
        }  
        return result; 
    }
}
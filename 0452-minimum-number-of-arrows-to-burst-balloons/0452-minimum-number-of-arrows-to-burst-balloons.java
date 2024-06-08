class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->Integer.compare(a[1],b[1]));

        int count = 1, min = points[0][1];
        
        for(int i = 1 ; i < points.length ; i++){
            if(min >= points[i][0]){
                min = Math.min(points[i][1], min);
            }
            else{
                count++;
                min = points[i][1];
            }
        }
        
        return count;
    }
}
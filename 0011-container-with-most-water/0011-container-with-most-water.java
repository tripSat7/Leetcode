class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i=0, j=height.length-1;
        while(i<j){
            int len = j-i;
            int area = height[i]>height[j]?height[j]*len:height[i]*len;
            if(area>max){
                max = area;
            }
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        
        return max;
    }
}
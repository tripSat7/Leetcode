class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;
        for(int weight : weights){
            if(min < weight){
                min = weight;
            }
            max = max + weight;
        }
        System.out.println(min+"||"+max); 
        while(min<max){
            int mid = (max+min)/2;
             System.out.println(mid);        
            int cur = 0, d = 1;
            for(int weight:weights){
                if(cur + weight>mid){
                    d++;
                    cur = 0;
                }
                cur = cur + weight;
            }
            
            if(days<d){
                min = mid + 1;
            }else{
                max = mid;
            }
        }
        
        return max;
    }
}
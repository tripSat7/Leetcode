class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        //System.out.println(m*k + "::"+ bloomDay.length);
        if((long)m*k > (long)bloomDay.length){
            return -1;
        }
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for(int i : bloomDay){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        
        while(min <= max){
            int mid = (min+max)/2;   
            //System.out.println(mid+":"+checkPos(bloomDay, mid, m, k));
            if(checkPos(bloomDay, mid, m, k)){
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }
        
        return min;
    }
    
    public boolean checkPos(int[] arr, int x, int m, int k){
        int count = 0;
        int res = 0;
        
        for(int i : arr){
            if(i <= x){
                count++;
            }
            else{
                count = 0;
            }
            
            if(count == k){
                res++;
                count = 0;
            }
        }
        
        return res >= m; 
    }
}
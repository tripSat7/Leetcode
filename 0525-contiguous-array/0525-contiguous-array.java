class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        
        int [] count1 = new int[n];
        int [] count0 = new int[n];
        int zeros = 0; 
        int ones = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                zeros++;
            }else{
                ones++;
            }
            count1[i] = ones;
            count0[i] = zeros;
        }

        HashMap <Integer,Integer> map = new HashMap <>();
        map.put(0,-1);
        int res = 0;
        for(int i = 0; i < n; i++){
            int diff = count0[i] - count1[i];
            if(!map.containsKey(diff)){
               map.put(diff,i);
            }else{
                int len = i - map.get(diff);
                res = Math.max(res, len);
            } 
        }

        return res;
    }
}
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        
        int[] hash = new int[102];
        
        for(List<Integer> num: nums){
            hash[num.get(0)]++;
            hash[num.get(1) + 1]--;
        }
        
        int ans = 0;
        for(int i=1;i<hash.length;i++){
            hash[i] += hash[i-1];
            System.out.print(hash[i]);
            if(hash[i] > 0){
                ans++;
            }   
        }
        
        return ans;
    }
}
class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>(); 
        int count[] = new int[n+1];
        
        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
            if(count[arr[i]] == 2){
                res.add(arr[i]);
            }
        }
        
        return res;
    }
}
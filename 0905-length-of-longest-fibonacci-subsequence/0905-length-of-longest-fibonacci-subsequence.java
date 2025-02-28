class Solution {
    int ans=0;
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        } 
       
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                solve(arr[i], arr[j], map, 2);
            }
        }

        return ans > 2? ans: 0;
    }
    public void solve(int firstNum, int secondNum, HashMap<Integer, Integer> map,int count){
        ans = Math.max(count,ans);
        if(!map.containsKey(firstNum+secondNum)){
            ans = Math.max(count, ans);
            return;
        }
        solve(secondNum, firstNum + secondNum, map, count + 1);
    }

}
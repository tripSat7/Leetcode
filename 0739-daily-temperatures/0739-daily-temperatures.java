class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        Stack<Integer> dailyTemp = new Stack<>();
        int[]answer = new int[n];

        for(int i = 0; i<n; i++){
            while(!dailyTemp.isEmpty() && temperatures[i] > temperatures[dailyTemp.peek()]){
                int index = dailyTemp.pop();
                answer[index] = i - index;
            }
            dailyTemp.push(i);
        }
        return answer;
    }
}
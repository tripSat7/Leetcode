class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        Stack<Integer> dailyTemp = new Stack<>();
        int[]answer = new int[n];

        for(int i = 0; i<n; i++){
            // Check if the stack is not empty and the current temperature is higher.
            while(!dailyTemp.isEmpty() && temperatures[i] > temperatures[dailyTemp.peek()]){
                int index = dailyTemp.pop(); // Calculate the number of days to wait.
                answer[index] = i - index;
            }
            dailyTemp.push(i); // Push the current day's index onto the stack.
        }
        return answer;
    }
}
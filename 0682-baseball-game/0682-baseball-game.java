class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();
        
        int sum=0;
        
        for(String s : operations){
            if(s.equals("+")){
                int second = stk.pop();
                int first = stk.pop();
                int tempsum = first+second;
                stk.push(first);
                stk.push(second);
                stk.push(tempsum);
                sum += tempsum;
            }
            else if(s.equals("D")){
                int first = stk.pop();
                int mul = first*2;
                stk.push(first);
                stk.push(mul);
                sum += mul;
            }
            else if(s.equals("C")){
                int discard = stk.pop();
                sum -= discard;
            }
            else{
                int score = Integer.parseInt(s);
                stk.push(score);
                sum+=score;
            }
        }
        
        return sum;
    }
}
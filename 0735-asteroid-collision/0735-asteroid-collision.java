class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();

        for(int i =0 ; i<asteroids.length ; i++){
            if(stk.size()==0 || asteroids[i]>0){
                stk.push(asteroids[i]);
            }else{
                while(true){
                    int peek = stk.peek();
                    if(peek<0){
                        stk.push(asteroids[i]);
                        break;
                    }else if(peek == -asteroids[i]){
                        stk.pop();
                        break;
                    }else if(peek> - asteroids[i]){
                        break;
                    }
                    else{
                        stk.pop();
                        if(stk.size()==0){
                            stk.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }

        int ans [] = new int[stk.size()];
        for(int i= stk.size()-1 ; i>=0 ; i--){
            ans[i]= stk.pop();
        }

        return ans ;
    }
}
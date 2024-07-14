class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        Integer[] idxs = new Integer[positions.length];
        
        for (int i = 0; i < positions.length; i++){
            idxs[i] = i;
        } 
        
        Arrays.sort(idxs, (o1, o2) -> positions[o1] - positions[o2]);
        
        List<Integer> res = new ArrayList<>();
        
        int stack[] = new int[healths.length];
        int top = -1;
        
        for(Integer idx : idxs){
            if(directions.charAt(idx) == 'L'){
                healths[idx] = healths[idx] * -1;
            }
            
            if(top == -1)
                stack[++top] = idx;
            else {
                if(healths[idx] < 0) {
                    
                    if (healths[stack[top]] < 0) {
                        stack[++top] = idx;
                    } 
                    else{
                        while (top != -1 && healths[stack[top]] >= 0 && Math.abs(healths[idx]) > healths[stack[top]]) {
                            healths[stack[top]] = 0;
                            top--;
                            healths[idx]++;
                        }

                        if(top >= 0) {
                            if(healths[stack[top]] == Math.abs(healths[idx])) {
                                healths[stack[top]] = 0;
                                healths[idx] = 0;
                                top--;
                            } 
                            else if(healths[stack[top]] < 0) {
                                stack[++top] = idx;
                            }
                            else{
                                healths[idx] = 0;
                                healths[stack[top]]--;
                            }
                            
                        }
                        else{
                            stack[++top] = idx;
                        }
                    }
                } 
                else {
                    stack[++top] = idx;
                }
            }
        }
        
        int i = 0;
        for(int j = 0; j < positions.length; j++){
            if(healths[j] != 0){
                res.add(Math.abs(healths[j]));
            }
        }
        
        return res;
    }
}
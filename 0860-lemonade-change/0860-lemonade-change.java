class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int change[] = new int[3];
        
        for(int i : bills){
            if(i == 5){
                change[0]++;
            }
            else if(i == 10){
                change[1]++;
                if(change[0] == 0){
                    return false;
                }
                change[0]--;
            }
            else{
                change[2]++;
                if(change[1] >= 1 && change[0] >= 1){
                    change[1]--;
                    change[0]--;
                }
                else if(change[0] >= 3){
                    change[0] -= 3;
                }
                else{
                    return false;
                }
            }
        }
        
        return true;
    }
}
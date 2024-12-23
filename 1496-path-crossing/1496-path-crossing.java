class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<>();
        int x = 0, y = 0;
        set.add("0,0");
        for(char ch : path.toCharArray()){
            if(ch == 'N'){
                y++;
            }
            else if(ch == 'S'){
                y--;
            }
            else if(ch == 'W'){
                x--;
            }
            else{
                x++;
            }
            
            String s = x+","+y;
            if(!set.add(s)){
                return true;
            }
            // else{
            //     return true;
            // }
            //System.out.println(set);
        }
        return false;
    }
}
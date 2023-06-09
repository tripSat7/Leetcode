class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(String str:details){
            if(Integer.parseInt(str.substring(11,13))>60){
                //System.out.println((int)str.substring(11,13));
                count++;
            }
        }
        return count;
    }
}
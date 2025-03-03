class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();

        for(int i = 1; i < 10; i++){
            int num = i;
            for(int j = i+1; j < 10; j++){
                num = num * 10 + j;
                if(num > high){
                    break;
                }
                if(num >= low && num <= high){
                    res.add(num);
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        int n = fruits.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            int j = 0;
            while(j < n){
                if(baskets[j] >= fruits[i]){
                    baskets[j] = 0;
                    break;
                }
                j++;
            }

            if(j == n){
                res++;
            }
        }

        return res;
    }
}
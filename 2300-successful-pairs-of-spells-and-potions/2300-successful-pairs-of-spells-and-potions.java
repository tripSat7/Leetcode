class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int []res = new int[spells.length];
        Arrays.sort(potions);
        int c = 0;
        for(int i : spells){
            int j = 0, k = potions.length-1;
            if ((long) i * potions[k] < success) {
                res[c] = 0;
                c++;
                continue;
            }
            while(j <= k){
                int mid = j + (k-j)/2;
                if((long) i * potions[mid] >= success){
                    k = mid - 1;
                }else{
                    j = mid + 1;
                }
            }

            res[c] = potions.length - j;
            c++;
        }
        
        return res;
    }
}
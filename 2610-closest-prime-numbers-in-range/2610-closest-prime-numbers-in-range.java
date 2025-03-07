class Solution {
    public int[] closestPrimes(int left, int right) {

        boolean prime[] = new boolean[right + 1];
        for (int i = 2; i <= right; i++){
            prime[i] = true;
        }

        for( int i = 2; i * i <= right; i++){

            if(prime[i] == true){
                for( int j = i + i; j <= right; j+=i){
                    prime[j] = false;
                }
            }
        }
        System.out.println(left);
        List<Integer> arr = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (prime[i] == true)
            {
                // System.out.println(i);
                arr.add(i);
            }
        }
        // System.out.println(arr.get(0));
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;

        if(arr.size() < 2){
            return res;
        }

        int min = Integer.MAX_VALUE;
        for(int i = arr.size()-1; i > 0; i--){
            int diff = arr.get(i) - arr.get(i-1);
            if(diff <= min){
                min = diff;
                res[0] = arr.get(i-1);
                res[1] = arr.get(i);
            }
        }
             
        return res;
    }
}
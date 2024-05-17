class Solution {
    public int countPrimes(int n) {
        
        if(n <= 2){
            return 0;
        }
        boolean prime[] = new boolean[n+1];
        for(int i = 2; i <= n; i++){
            prime[i] = true;
        }
        
        for(int i = 2; i*i < n; i++){
            if(isPrime(i)){
                for (int j = i * i; j <= n; j += i)
					prime[j] = false;
            }
        }

        int res=0;
        for(int i = 2; i < n; i++){
            if(prime[i]){
                res++;
            }
        }
        
        return res;
    }
    
    public boolean isPrime(int n){
        if(n == 2 || n == 3){
            return true;
        }
        if(n%2 == 0 || n%3 == 0){
            return false;
        }
        
        for(int i = 5; i*i <= n; i+=6){
            if(n % i == 0 || n % (i+2) == 0){
                return false;
            }
        }
        
        return true;
    }
}
class Solution {
    public int divide(int dividend, int divisor) {
        
        if (dividend == divisor) {
            return 1;
        }

        boolean sign = true;

        if (dividend >= 0 && divisor < 0) {
            sign = false;
        }
        
        else if (dividend <= 0 && divisor > 0) {
            sign = false;
        }
    
        
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        divisor = Math.abs(divisor);

        long res= 0;
        // System.out.println(d);
        while(n >= d){
            
            int count = 0;
            while(n >= (d<<count + 1)){
                count++;
            }
            res += (1L<<count);
            n = n - (d<<count);
        }
        if (res == (1L << 31) && sign) {
            return Integer.MAX_VALUE;
        }
        
        if (res == (1L << 31) && !sign) {
            return Integer.MIN_VALUE;
        }
        return sign ? (int) res : (int) -res; 
    }
}


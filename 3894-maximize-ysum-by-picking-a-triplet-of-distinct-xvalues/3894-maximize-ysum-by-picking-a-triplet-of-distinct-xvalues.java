class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int a = 0, b = 0, c = 0;
        int ind1 = 0, ind2 = 0, ind3 = 0;

        for (int i = 0; i < x.length; i++) {
            if (x[i] == ind1) {
                a = Math.max(a, y[i]);
            } 
            else if (x[i] == ind2) {
                b = Math.max(b, y[i]);
            } 
            else if (x[i] == ind3) {
                c = Math.max(c, y[i]);
            } 
            else if (y[i] > a || y[i] > b || y[i] > c) {
                int mini = Math.min(a, Math.min(b, c));
                if (mini == a) {
                    a = y[i];
                    ind1 = x[i];
                }
                else if (mini == b) {
                    b = y[i];
                    ind2 = x[i];
                } 
                else {
                    c = y[i];
                    ind3 = x[i];
                }
            }
        }

        return (a == 0 || b == 0 || c == 0) ? -1 : (a + b + c);
    }
}

/* Time complexity : O(n)
space : O(1)
*/
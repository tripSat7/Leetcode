public class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int cnt = 0;

        int[] prefixN = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixN[i] = cnt;
            if (customers.charAt(i) == 'N') {
                cnt++;
            }
        }
        prefixN[n] = cnt;

        int[] suffixY = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixY[i] = suffixY[i + 1];
            if (customers.charAt(i) == 'Y') {
                suffixY[i]++;
            }
        }

        int res = n, minPenalty = n;
        for (int i = 0; i <= n; i++) {
            int penalty = prefixN[i] + suffixY[i];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                res = i;
            }
        }

        return res;
    }
}
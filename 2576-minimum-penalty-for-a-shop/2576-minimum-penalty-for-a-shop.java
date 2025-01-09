public class Solution {
    public int bestClosingTime(String customers) {
        int cntY = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') cntY++;
        }

        int minPenalty = cntY, res = 0, cntN = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                cntY--;
            } else {
                cntN++;
            }

            int penalty = cntN + cntY;
            if (penalty < minPenalty) {
                res = i + 1;
                minPenalty = penalty;
            }
        }

        return res;
    }
}
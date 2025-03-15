class Solution {
    public int totalNumbers(int[] digits) {
        int uniqueCount = 0;
        int[] digitFrequency = new int[10];

        // Count frequency of each digit
        for (int digit : digits) {
            digitFrequency[digit]++;
        }

        // Iterate over possible hundreds place digits (1-9, no leading zeros)
        for (int hundreds = 1; hundreds < 10; hundreds++) {
            if (digitFrequency[hundreds] > 0) {
                digitFrequency[hundreds]--;

                // Iterate over possible tens place digits (0-9)
                for (int tens = 0; tens < 10; tens++) {
                    if (digitFrequency[tens] > 0) {
                        digitFrequency[tens]--;

                        // Iterate over possible ones place digits (0, 2, 4, 6, 8)
                        for (int ones = 0; ones < 10; ones += 2) {
                            if (digitFrequency[ones] > 0) {
                                uniqueCount++;
                            }
                        }

                        digitFrequency[tens]++;
                    }
                }

                digitFrequency[hundreds]++;
            }
        }

        return uniqueCount;
    }
}
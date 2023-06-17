class Solution {
    public int sumOfMultiples(int n) {
        if (n < 3) {
			return 0;
		}
		int sum = 0;
		for (int numberForThree = 3, numberForFive = 5,
				numberForSeven = 7; numberForThree <= n; numberForThree += 3, numberForFive += 5, numberForSeven += 7) {
			if (numberForThree % 5 != 0 && numberForFive % 7 != 0) {
				sum += numberForThree;
			}
			if (numberForFive % 7 != 0 && numberForFive <= n) {
				sum += numberForFive;
			}
			if (numberForSeven <= n) {
				sum += numberForSeven;
			}
		}
		return sum;
    }
}
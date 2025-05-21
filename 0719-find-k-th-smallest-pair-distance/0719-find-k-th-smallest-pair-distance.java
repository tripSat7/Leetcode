class Solution {
    public int smallestDistancePair(int[] numbers, int k) {
        Arrays.sort(numbers);
        int min = 0;
        int max = numbers[numbers.length - 1] - numbers[0];
        
        while (min < max) {
            int mid = min + (max - min) / 2;
            int pairsCount = countPairs(numbers, mid);
            
            if(pairsCount < k) {
                min = mid + 1;
            } 
            else{
                max = mid;
            }
        }
        
        return min;
    }

    private int countPairs(int[] numbers, int targetDistance) {
        int count = 0;
        int left = 0;
        
        for (int right = 1; right < numbers.length; right++) {
            while (numbers[right] - numbers[left] > targetDistance) {
                left++;
            }
            count += right - left;
        }
        
        return count;
    }
}

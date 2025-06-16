// Time Complexity: O(log(min(n1,n2))),

class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;

        // Ensure binary search is done on the smaller array
        if (n1 > n2) return findMedianSortedArrays(b, a);

        int totalLen = n1 + n2;
        int leftSize = (totalLen + 1) / 2; //left of merged array

        int low = 0, high = n1;

        // Binary search on array 'a' (smaller array)
        while (low <= high) {
            int mid1 = (low + high) / 2;//mid of smaller array
            int mid2 = leftSize - mid1;//mid of larger array

            // Elements to the left and right of the partitions
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE; 
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE; 
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE; 
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE; 

            // Valid partition found
            if (l1 <= r2 && l2 <= r1) {
                if (totalLen % 2 == 1) {
                    return Math.max(l1, l2); // Odd total length
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }

            // Move partition to the left in 'a'
            else if (l1 > r2) {
                high = mid1 - 1;
            }

            // Move partition to the right in 'a'
            else {
                low = mid1 + 1;
            }
        }

        return 0; // Should never reach here
    }
}

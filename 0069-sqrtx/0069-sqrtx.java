class Solution {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;

        while(l <= r){
            int mid = (l + r) / 2;
            System.out.println(l+":"+r+":"+mid);
            if(x / mid == mid){
                return mid;
            } else if(mid > x / mid){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }
}
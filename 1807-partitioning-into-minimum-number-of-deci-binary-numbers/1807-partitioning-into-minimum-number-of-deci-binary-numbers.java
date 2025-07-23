class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) - '0' == 9){
                return 9;
            } 
            max = Math.max(max, (n.charAt(i) - '0'));
        }
        return max;
    }
}

/*
82734
11111 = 71623
11111 = 60512
11111 = 49401 
11111 = 38920
11111 = 27179
11111 = 16068
11111 = 4957
1111  = 3846
1111  = 2735
1111  = 1624
1111  = 513
111   = 402
111   = 291
111   = 180
111   = 69
69    = 58
58    = 47
47    = 35
*/
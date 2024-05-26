class Solution {
    public int myAtoi(String s) {
        
        char ch[] = s.trim().toCharArray();
        Integer sign = 1;
        int i = 0;
        Integer res = 0;
        
        if(ch.length > 0 && ((ch[0] >= 'A' && ch[0] <= 'Z') || (ch[0] >= 'a' && ch[0] <= 'z') || ch[0] =='.')){
            return 0;
        }
        else if(ch.length > 0 &&(ch[0] == '-' || ch[0] == '+')){
            if(ch[0] == '-'){
                sign = sign * -1;
            }
            i++;
        }
        
        
        while (i < ch.length && ch[i] >= '0' && ch[i] <= '9') {
			// check if we will go over the max
			if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && ch[i] - '0' > 7)) {
				if (sign == -1) {
					return Integer.MIN_VALUE;
				}
				return Integer.MAX_VALUE;
			}
			
			// update res
			res = res * 10 + ( ch[i++] - '0');
		}
		return sign * res;
    }
}
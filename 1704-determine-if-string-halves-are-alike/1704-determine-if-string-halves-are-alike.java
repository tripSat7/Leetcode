class Solution {
    public boolean halvesAreAlike(String s) {
        char ch[] = s.toCharArray();
        int lc=0,rc=0,left=(ch.length/2)-1,right=left+1;
        System.out.println(right);
        List<Character> vowels = new ArrayList<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        while(left>=0){
            if(vowels.contains(ch[left])){
                lc++;
            }
            if(vowels.contains(ch[right])){
                rc++;
            }
            left--;right++;
        }
        return lc==rc;
    }
}
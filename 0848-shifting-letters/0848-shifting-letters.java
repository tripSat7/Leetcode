class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char arr[] = s.toCharArray();
        long shift=0;
        for (int i = s.length()-1; i >=0 ; i--){
            arr[i] =  (char)((s.charAt(i) - 'a' + (shift+shifts[i]) % 26) % 26 + 'a');
            shift+=shifts[i];
        }
        return new String(arr ,0,arr.length);
    }
}
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char arr[] = s.toCharArray();
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
        
        for(int i = 0;i<shifts.length;i++){
           arr[i] = (char) ((arr[i] - 'a' + shifts[i]) % 26 + 'a');
        }
        return new String(arr ,0,arr.length);
    }
}
class Solution {
    public String reversePrefix(String word, char ch) {
        char []arr = word.toCharArray();
        int i,counter=0;
        for(i = 0; i<arr.length; i++){
            if(arr[i]==ch){
                counter=1;
                break;
            }
        }
        
        if(counter==1){
            for(int l=0; l<=i/2; l++){
                char temp = arr[l];
                arr[l] = arr[i-l];
                arr[i-l] = temp;
            }
        }
        
        return new String(arr);
    }
}
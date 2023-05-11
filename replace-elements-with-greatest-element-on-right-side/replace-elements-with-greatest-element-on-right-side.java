class Solution {
    public int[] replaceElements(int[] arr) {
        
        for(int i=0;i<arr.length;i++){
            int max=0;
            for(int j=arr.length-1;j>i;j--){
                if(arr[j]>max){
                    max=arr[j];
                }
            }
            arr[i]=max;
        }
        arr[arr.length-1]=-1;
        return arr;
    }
}
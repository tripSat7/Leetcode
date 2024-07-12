class Solution {
    public int nextGreaterElement(int n) {
       char[] arr = String.valueOf(n).toCharArray();
        
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]){
            i--;
        }
            
        if (i == -1){
            return -1;
        }
        
        int j = arr.length - 1;
        while (arr[j] <= arr[i])
        {
            j--;
        }
        
        swap(arr, i, j);
        
        Arrays.sort(arr, i + 1, arr.length);
        
        long ans = Long.parseLong(new String(arr));
        
        if (ans > Integer.MAX_VALUE)
            return -1;
        else
            return (int)ans;
    }
    
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
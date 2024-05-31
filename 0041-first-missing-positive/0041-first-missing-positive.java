class Solution {
    public int firstMissingPositive(int[] arr) {
     
        int ptr = 0;
        int size = arr.length;
        for(int j = 0; j < size; j++){
            if(arr[j] <= 0){
                arr[j] = -1;
            }
            if(arr[j] == 1){
                ptr = 1;
                arr[j] = -1;
            }
        }
        
        if(ptr == 0){
            return 1;
        }
        int i = 0;
        while(i < size){
            int idx = arr[i] - 1;
            
            if(idx < 0 || idx >= size){
                i++;
                continue;
            }
            if(arr[idx] == 0){
                i++;
            }
            else{
                int temp = arr[idx];
                arr[idx] = 0;
                 if (idx > i) { 
                    arr[i] = temp; 
                } 
                else { 
                    i++; 
                }
            }
        }
        
        
        for(i = 1 ; i  < size ; i++){
            if(arr[i] != 0){
                return i+1;
            }
        }
        
        return size+1;
    }
}
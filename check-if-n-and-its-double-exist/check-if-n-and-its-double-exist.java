class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer> map= new  HashMap<Integer,Integer>();
        
        for(int i=0;i<arr.length;i++){
            if((map.containsKey(arr[i]/2)&&arr[i]%2==0)||map.containsKey(arr[i]*2)){
                System.out.println(arr[i]);
                return true;
            }
            map.put(arr[i],i);
        }
        
        return false;
    }
}
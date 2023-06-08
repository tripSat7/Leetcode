class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        quickSort(names,heights,0,names.length-1);
        return names; 
    }
    
    public static void quickSort(String[] names, int[] heights, int l, int h){
        
        if(h>l){
            int p = partition(names,heights,l,h);
            quickSort(names,heights,l,p-1);
            quickSort(names,heights,p+1,h);
        }
    }
    
    public static int partition(String[] names,int[] heights,int l, int h){
        int piv=l;
        int i=piv;
        for(int j=l+1;j<=h;j++){
            if(heights[j]>=heights[piv]){
                i++;
                swap(names, heights, i, j);
            }
        }
        swap(names, heights, piv, i);
        return i;
    }
    
    public static void swap(String[] names,int[] heights, int i, int j){
        int temp = heights[i];
        heights[i] = heights[j];
        heights[j]= temp;
        String temp1 = names[i];
        names[i]=names[j];
        names[j] = temp1;
    }
}
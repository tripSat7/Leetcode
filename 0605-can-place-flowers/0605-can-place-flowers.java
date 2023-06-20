class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length==1){
            if(flowerbed[0]==0 || (flowerbed[0]==1 && n==0)){
                return true;
            }else{
                return false;
            }
        }
        
        if(flowerbed.length==2){
            if((flowerbed[0]==0&&flowerbed[1]==0 && n<=1) || (n==0 &&(flowerbed[0]==1 || flowerbed[1]==1))){
                return true;
            }else{
                return false;
            }
        }
        int i=0, j=i+2, count=0, len=flowerbed.length;
        while(j<len){
            if(flowerbed[i]==0 && flowerbed[j]==1 && flowerbed[i+1]==0){
                if(i==0 || flowerbed[i-1]==0){
                    flowerbed[i]=1;
                    i++; j++; count++;
                }
            }
            else if(flowerbed[i]==1 && flowerbed[j]==0 && flowerbed[i+1]==0){
                if(j==len-1 || flowerbed[j+1]==0){
                    flowerbed[j]=1;
                    i++; j++; count++;
                }
            }
            else if(flowerbed[i]==0 && flowerbed[j]==0 && flowerbed[i+1]==0){
                if((i==0 && j==len-1) || flowerbed[j+1]==0){
                    flowerbed[i]= flowerbed[j]= 1;
                    i++; j++; count+=2;
                }else{
                    flowerbed[i+1] = 1;
                    i++; j++; count++;
                }
            }
            i++; j++;
        }
        
        return count>=n;
    }
        
}
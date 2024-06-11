class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0){
            return new int[0][0];
        }
        
        LinkedList<int[]> res = new LinkedList<>();
        int i = 0, j = 0;
        int m = firstList.length, n = secondList.length;
        while(i < m && j < n){
            if(firstList[i][1] < secondList[j][1]){
                int end = firstList[i][1];
                int start = Math.max(firstList[i][0],secondList[j][0]);
                if(start <= end){
                    res.add(new int[]{start,end});
                }
                i++;
            }
            else{
                int end = secondList[j][1];
                int start = Math.max(firstList[i][0],secondList[j][0]);
                if(start <= end){
                    res.add(new int[]{start,end});
                }
                j++;
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}
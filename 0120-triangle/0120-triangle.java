class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int prev[] = new int[triangle.size()];
        prev[0] = triangle.get(0).get(0);

        for(int i = 1; i < triangle.size(); i++){
            int temp[] = new int[triangle.size()];

            for(int j = 0; j < triangle.get(i).size(); j++){
                if(j == 0){
                    temp[j] = triangle.get(i).get(j) + prev[0];
                }
                else if(j == triangle.get(i).size() - 1){
                    temp[j] = triangle.get(i).get(j) + prev[j-1];   
                }
                else{
                    temp[j] = triangle.get(i).get(j) + Math.min(prev[j], prev[j-1]);
                }
            }
            prev = temp;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < triangle.size(); i++)
        {
            min = Math.min(min, prev[i]);
        }
        return min;
    }
}

// 2
// 5, 6
// 11, 10, 13
// 15, 11, 17, 16

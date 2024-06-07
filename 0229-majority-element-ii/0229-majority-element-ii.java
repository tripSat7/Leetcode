class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int ca1 = 0;
        int ca2 = 0;
        int count1 = 0;
        int count2 = 0;
        
         for (int num : nums) {
            if (num == ca1) {
                count1++;
            } else if (num == ca2) {
                count2++;
            } else if (count1 == 0) {
                ca1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                ca2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for(int num: nums){
            if(num == ca1){
                count1++;
            }
            else if(num == ca2){
                count2++;
            }
        }
        
        if(count1 > nums.length/3){
            list.add(ca1);
        }
        if(count2 > nums.length/3){
            list.add(ca2);
        }
        
        return list;
    }
}
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int l = 0, r = people.length-1;
        
        while(r>l){
            if(people[l]+people[r]<=limit){
                l++;
            }
            count++;
            r--;
        }
        
        if(l==r){
            count++;
        }
        
        
        return count;
    }
}
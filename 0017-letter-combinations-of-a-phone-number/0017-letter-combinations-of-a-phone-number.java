class Solution {
    List<String> res = new ArrayList<>();
    String[][] nums = {{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},
    {"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return res;
        }
        res = new ArrayList<>();
        char[] ch = digits.toCharArray();
        int a[] = new int[ch.length];
        for(int i = 0; i < ch.length; i++){
            a[i] = ch[i]-'0';
        }
        
        for(int i = 0; i < nums[a[0]].length; i++){
            powerSet(a, 1, res, nums[a[0]][i]);
        }
        
        return res;
    }
    
    void powerSet(int a[], int n, List<String> res, String curr){
        
        if(n == a.length){
            if(curr.length() == a.length){
                res.add(curr);
            }
            return;
        }
        
        powerSet(a, n+1, res, curr+(nums[a[n]][0]));
        powerSet(a, n+1, res, curr+(nums[a[n]][1]));
        powerSet(a, n+1, res, curr+(nums[a[n]][2]));
        if(a[n] == 7 || a[n] == 9){
            powerSet(a, n+1, res, curr+(nums[a[n]][3]));
        }
    }
}
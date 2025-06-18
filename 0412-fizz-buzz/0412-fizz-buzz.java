// TC : O(n)
// SC : O(1)

class Solution {
    public List<String> fizzBuzz(int n) {

        // ans list
        List<String> res = new ArrayList<String>();

        // Hash map to store all fizzbuzz mappings.
        HashMap<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");

        for (int num = 1; num <= n; num++) {

            String numAnsStr = "";

            for (Integer key : map.keySet()) {
                // If the num is divisible by key,
                // then add the corresponding string mapping to current numAnsStr
                if (num % key == 0) {
                    numAnsStr += map.get(key);
                }
            }

            if (numAnsStr.equals("")) {
                // Not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }

            // Append the current answer str to the ans list
            res.add(numAnsStr);
        }

        return res;
    }
}
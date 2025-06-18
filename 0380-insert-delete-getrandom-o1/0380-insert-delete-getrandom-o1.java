// TC : O(1)
// SC : O(n)
// explanation - check editorial

public class RandomizedSet {
    private Map<Integer, Integer> numMap; // value -> its index in 'nums' list
    private List<Integer> nums;           // list of values for O(1) random access
    private Random rand;

    public RandomizedSet() {
        numMap = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        // If already present, no insertion
        if (numMap.containsKey(val)) {
            return false;
        }
        // Append to list and record its index
        numMap.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        // If not present, can't remove
        if (!numMap.containsKey(val)) {
            return false;
        }

        // Get index of element to remove
        int idx = numMap.get(val);
        // Move last element into 'idx' to fill the gap
        int last = nums.get(nums.size() - 1); 
        nums.set(idx, last);
        numMap.put(last, idx);    // Update moved element's index
        // Remove last element
        nums.remove(nums.size() - 1);
        numMap.remove(val); // Remove mapping for deleted value
        
        return true;
    }

    public int getRandom() {
        // Pick a random index in [0, nums.size())
        return nums.get(rand.nextInt(nums.size()));
    }
}

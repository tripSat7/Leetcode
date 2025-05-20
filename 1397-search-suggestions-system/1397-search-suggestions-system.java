public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        int m = searchWord.length();
        Arrays.sort(products);

        StringBuilder prefix = new StringBuilder();
        int start = 0;

        for (int i = 0; i < m; i++) {
            prefix.append(searchWord.charAt(i));
            start = binarySearch(products, prefix.toString(), start);

            List<String> cur = new ArrayList<>();
            for (int j = start; j < Math.min(start + 3, products.length); j++) {
                if (products[j].startsWith(prefix.toString())) {
                    cur.add(products[j]);
                } 
                else{
                    break;
                }
            }

            res.add(cur);
        }

        return res;
    }

    private int binarySearch(String[] products, String target, int start) {
        int l = start, r = products.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (products[mid].compareTo(target) >= 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
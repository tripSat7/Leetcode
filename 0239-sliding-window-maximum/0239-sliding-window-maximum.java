class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        
        if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] res = new int[n-k+1];
		int j = 0;
		
		Deque<Integer> q = new ArrayDeque<>();
		for(int i = 0; i < a.length; i++) {
			// remove numbers out of range k
            
			if(!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
            
			// remove smaller numbers in k range as they are useless
			while(!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
            
			q.offer(i);
            
            // System.out.println(q);
			if(i >= k - 1) {
				res[j++] = a[q.peek()];
			}
		}
		return res;
    }
}
class Solution {
    public int matchPlayersAndTrainers(int[] p, int[] t) {
        Arrays.sort(p);
        Arrays.sort(t);
        int i = 0, j = 0, c = 0;
        while(i < p.length && j < t.length)
        {
            if(p[i] <= t[j])
            {
                i++;
                j++;
                c++;
            }
            else
            {
                j++;
            }
        }
        return c;
    }
}
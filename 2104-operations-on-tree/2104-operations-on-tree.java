public class LockingTree {
    private int[] parent;
    private List<Integer>[] child;
    private int[] locked;

    public LockingTree(int[] parent) {
        this.parent = parent;
        int n = parent.length;
        child = new ArrayList[n];
        locked = new int[n];

        for (int i = 0; i < n; i++) {
            child[i] = new ArrayList<>();
        }
        for (int node = 1; node < n; node++) {
            child[parent[node]].add(node);
        }
    }

    public boolean lock(int num, int user) {
        if (locked[num] != 0) {
            return false;
        }
        locked[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (locked[num] != user) {
            return false;
        }
        locked[num] = 0;
        return true;
    }

    public boolean upgrade(int num, int user) {
        int node = num;
        while (node != -1) {
            if (locked[node] != 0) {
                return false;
            }
            node = parent[node];
        }

        int lockedCount = dfs(num);
        if (lockedCount > 0) {
            locked[num] = user;
            return true;
        }
        return false;
    }

    private int dfs(int node) {
        int lockedCount = 0;
        if (locked[node] != 0) {
            lockedCount++;
            locked[node] = 0;
        }
        for (int nei : child[node]) {
            lockedCount += dfs(nei);
        }
        return lockedCount;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int []vis = new int[rooms.size()];
        dfs(0, rooms, vis);
        
        for(int i = 0; i < rooms.size(); i++){
            if(vis[i] == 0){
                return false;
            }
        }
        
        return true;
    }
    
    public void dfs(int room, List<List<Integer>> rooms, int[] vis){
        if(vis[room] == 1){
            return;
        }
        vis[room] = 1;
        
        for(int i : rooms.get(room)){
            dfs(i, rooms, vis);
        }
    }
}
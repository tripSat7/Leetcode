class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        List<Job> jobs = new ArrayList<Job>();
        
        for(int i = 0; i < profit.length; i++){
            Job j= new Job(startTime[i], endTime[i], profit[i]);
            jobs.add(j);
        }
        
        Collections.sort(jobs, new SortbyFinishTime());
        
        System.out.println(jobs);

        int []pre = new int[profit.length];
        pre[0] = -1;
        for(int i = 1; i < profit.length; i++){
            pre[i] = -1;
            for(int j = i; j >= 0; j--){
                if(jobs.get(j).end <= jobs.get(i).start){
                    pre[i] = j;
                    break;
                }
            }
            System.out.println(pre[i]);
        }
        
        int max[] = new int[profit.length + 1];
        max[0] = 0;
        for(int i = 1; i < max.length; i++){
            max[i] = Math.max(jobs.get(i-1).profit + max[pre[i-1]+1], max[i-1]);
        }
        
        return max[profit.length];
    }
    
    class Job{
        int start, end, profit;
        
        Job(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
        
        public String toString(){
            return "start : "+start+" end : "+end+" Profit : "+profit+"\n";
        }
        
    }
    
    class SortbyFinishTime implements Comparator<Job> {

        public int compare(Job a, Job b)
        {
            return a.end - b.end;
        }
    }
}
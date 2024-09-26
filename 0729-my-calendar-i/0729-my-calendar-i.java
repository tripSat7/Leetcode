class MyCalendar {

    TreeMap<Integer,Integer> calendar = new TreeMap<>();
    
    public MyCalendar(){
        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    public boolean book(int start, int end){
        Map.Entry<Integer,Integer> pair = calendar.higherEntry(start);
        if (end <= pair.getValue()){
            calendar.put(end, start);
        } 
        return end <= pair.getValue();
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
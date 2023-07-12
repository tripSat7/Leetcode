class ListNode{
    ListNode prev, next;
    String val;
    
    ListNode(String val){
        this.val = val;
        prev = null;
        next = null;
    }
}

class BrowserHistory {

    ListNode head, trav;
    public BrowserHistory(String homepage) {
        head = new ListNode(homepage);
        trav = head;
    }
    
    public void visit(String url) {
        ListNode newUrl = new ListNode(url);
        trav.next = newUrl;
        newUrl.prev = trav;
        trav = trav.next;
    }
    
    public String back(int steps) {
        while(steps!=0 && trav.prev!=null){
            trav = trav.prev;
            steps--;
        }
        
        return trav.val;
    }
    
    public String forward(int steps) {
        while(steps!=0 && trav.next!=null){
            trav = trav.next;
            steps--;
        }
        
        return trav.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
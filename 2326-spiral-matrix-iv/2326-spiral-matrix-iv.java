/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int res[][] = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                res[i][j] = -1;
            }
        }
        
        ListNode temp = head;
        int i=0, j=0, r=0, c=-1;
        
        while(temp!=null){
            while(j<n && res[i][j]==-1 &&temp!=null){
                res[i][j] = temp.val;
                System.out.println("i:"+i+" j:"+j);
                temp=temp.next;
                j++;
            }
            n--;
            j--;
            i++;
            while(i<m && res[i][j]==-1 &&temp!=null){
                
                res[i][j] = temp.val;
                System.out.println("i:"+i+" j:"+j);
                temp = temp.next;
                i++;
            }
            m--;
            i--;
            j--;
            while(j>c && res[i][j]==-1 &&temp!=null){
        
                res[i][j] = temp.val;
                System.out.println("i:"+i+" j:"+j);
                temp = temp .next;
                j--;
            }
            j++;
            i--;
            c++;
            while(i>r && res[i][j]==-1 &&temp!=null){
                
                res[i][j] = temp.val;
                System.out.println("i:"+i+" j:"+j);
                temp = temp.next;
                i--;
            }
            i++;
            j++;
            r++;
        }
        
        return res;
    }
}
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<Integer,ListNode>();
        ListNode dummy = new ListNode(0),p;
        dummy.next = head;
        p = dummy;
        int sum = 0;
        while(p!=null){
            sum+=p.val;
            map.put(sum,p);
            p = p.next;
        }
        sum = 0;
        p = dummy;
        while(p!=null){
            sum+=p.val;
            if(map.containsKey(sum)){
                ListNode tmp = map.get(sum);
                if(tmp!=p){
                    p.next = tmp.next;
                }
            }
            p = p.next;
        }
        return dummy.next;
    }
}
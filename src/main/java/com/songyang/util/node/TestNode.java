package com.songyang.util.node;

/**
 * @author Yang Song
 * @date 2022/7/21 18:18
 */
public class TestNode {
    public static void main(String[] args) {
        ListNode head = ListNodeUtils.createListNode(new int[]{1,1,1,4,1,1});
        ListNode dump = new ListNode(-1,head);
        ListNode rs = dump;
        while (dump.next != null){
            if(dump.next.val == 1){
                dump.next = dump.next.next;
            }else {
                dump = dump.next;
            }
        }
        ListNodeUtils.print(rs.next);
    }
}

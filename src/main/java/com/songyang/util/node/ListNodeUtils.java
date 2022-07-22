package com.songyang.util.node;

import java.util.Arrays;

/**
 * @author Yang Song
 * @date 2022/7/21 16:52
 */
public class ListNodeUtils {
    private final static String START_WITH = "[";
    private final static String END_WITH = "]";
    public static ListNode createListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }
    public static ListNode createListNode(String nodes){
        if(nodes == null || nodes.length() == 0){
            return null;
        }
        if(!nodes.startsWith(START_WITH) || !nodes.endsWith(END_WITH)){
            return null;
        }
        nodes = nodes.substring(1, nodes.length() - 1);
        String[] arr = nodes.split(",");
        int[] nums = Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
        return createListNode(nums);
    }
    public static void print(ListNode head){
        if(head == null){
            System.out.println("-null-");
        }
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}

package cn.algerfan.leetcode203;

/**
 * @author algerfan
 * @date 2019/10/26 20:30
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            /*ListNode delNode = head;
            head = head.next;
            delNode.next = null;*/
            head = head.next;
        }
        if(head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if(prev.next.val == val) {
                /*ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;*/
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode listNode1 = new Solution().removeElements(listNode, 6);
        System.out.println(listNode1);
    }

}

package cn.algerfan.code05recursion.leetcode203;

/**
 * @author algerfan
 * @date 2019/10/26 20:30
 */
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        /*ListNode listNode = removeElements(head.next, val);
        if(head.val == val) {
            return listNode;
        } else {
            head.next = listNode;
            return head;
        }*/
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode listNode1 = new Solution3().removeElements(listNode, 6);
        System.out.println(listNode1);
    }

}

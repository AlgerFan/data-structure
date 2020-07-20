package cn.algerfan.leetcode203;

/**
 * 203. 移除链表元素
 删除链表中等于给定值 val 的所有节点。

 示例:
 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5

 * @author algerfan
 * @date 2019/10/26 20:30
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * 链表结点的构造函数
     * 使用arr作为参数，创建一个链表，当前的listNode为链表头结点
     * @param arr
     */
    public ListNode(int[] arr) {
        if(arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            stringBuilder.append(cur.val).append("-->");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

}

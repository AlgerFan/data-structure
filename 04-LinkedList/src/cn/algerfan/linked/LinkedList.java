package cn.algerfan.linked;

/**
 * @author algerfan
 * @date 2019/10/25 14:42
 */
public class LinkedList<T> {

    private class Node {
        public T t;
        public Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public Node(T t) {
            this(t, null);
        }

        public Node() {
            this(null, null);
        }
        @Override
        public String toString() {
            return t.toString();
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index（0-based）位置添加新的元素
     * 在链表中不是一个常用的操作，作为练习
     */
    public void add(int index, T t) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        /*Node node = new Node();
        node.next = prev.next;
        prev.next = node;*/
        prev.next = new Node(t, prev.next);
        size++;
    }

    /**
     * 在链表头添加新的元素
     */
    public void addFirst(T t) {
        add(0, t);
    }

    /**
     * 在链表末尾添加一个元素
     */
    public void addLast(T t) {
        add(size, t);
    }

    /**
     * 获得在链表的index（0-based）位置的元素
     * 在链表中不是一个常用的操作，作为练习
     */
    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.t;
    }

    /**
     * 获得链表的第一个元素
     */
    public T getFirst(){
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     */
    public T getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表的第index（0-based）个位置的元素
     * 在链表中不是一个常用的操作，作为练习
     * @param index
     * @param t
     */
    public void set(int index, T t){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed.");
        }
        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i ++) {
            cur = cur.next;
        }
        cur.t = t;
    }

    public boolean contains(T t) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if(cur.equals(t)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除的第index（0-based）个位置的元素，返回删除的元素
     * 在链表中不是一个常用的操作，作为练习
     * @param index
     */
    public T remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed.");
        }
        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.t;
    }

    /**
     * 删除链表的第一个元素
     */
    public T removeFirst(){
        return remove(0);
    }

    /**
     * 删除链表的最后一个元素
     */
    public T removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            stringBuilder.append(cur).append("->");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

}

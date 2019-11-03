package cn.algerfan;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author algerfan
 * @date 2019/11/1 21:18
 */
public class Bst<T extends Comparable<T>> {

    private class Node {
        public T t;
        public Node left, right;

        public Node(T t) {
            this.t = t;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public Bst() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素t
     */
    public void  add(T t) {
        root = add(root, t);
    }

    /**
     * 向以node为根的二分搜索树中插入元素t，递归
     * @param node
     */
    private Node add(Node node, T t) {
        if(node == null) {
            size++;
            return new Node(t);
        }
        if(t.compareTo(node.t) < 0) {
            node.left = add(node.left, t);
        } else if(t.compareTo(node.t) > 0) {
            node.right = add(node.right, t);
        }
        return node;
    }

    // 笨方法，以上是优化后的方法
    /*public void  add(T t) {
        if(root == null) {
            root = new Node(t);
            size++;
        } else {
            add(root, t);
        }
    }

    private void add(Node node, T t) {
        if(t.equals(node.t)) {
            return;
        } else if(t.compareTo(node.t) < 0 && node.left == null) {
            node.left = new Node(t);
            size++;
        } else if(t.compareTo(node.t) > 0 && node.right == null) {
            node.right = new Node(t);
            size++;
        }
        if(t.compareTo(node.t) < 0) {
            add(node.left, t);
        } else {
            add(node.right, t);
        }
    }*/

    /**
     * 查找二叉搜索树中是否包含元素t
     * @param t
     */
    public boolean contains(T t) {
        return contains(root, t);
    }

    /**
     * 查找以node为根的二叉搜索树中是否包含元素t，递归
     * @param node
     * @param t
     */
    private boolean contains(Node node, T t) {
        if(node == null) {
            return false;
        }
        if(t.compareTo(node.t) == 0) {
            return true;
        } else if(t.compareTo(node.t) < 0) {
            return contains(node.left, t);
        } else {
            return contains(node.right, t);
        }
    }

    /**
     * 二叉搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根节点的
     * @param node
     */
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.t);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的前序非递归遍历
     */
    public void preOrderNr() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node cur = stack.pop();
            System.out.println(cur.t);
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二叉搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根节点的
     * @param node
     */
    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.t);
        inOrder(node.right);
    }

    /**
     * 二叉搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根节点的
     * @param node
     */
    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.t);
    }

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.t);
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 查找二分搜索树的最小元素
     */
    public T minimum() {
        if(size == 0) {
            throw new IllegalArgumentException("Bst is empty");
        }
        return minimum(root).t;
    }

    /**
     * 查找以node为根节点的二分搜索树的最小元素
     */
    private Node minimum(Node node) {
        if(node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 查找二分搜索树的最大元素
     */
    public T maximum() {
        if(size == 0) {
            throw new IllegalArgumentException("Bst is empty");
        }
        return maximum(root).t;
    }

    /**
     * 查找以node为根节点的二分搜索树的最大元素
     */
    private Node maximum(Node node) {
        if(node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小的节点，并返回删除的节点
     */
    public T removeMin() {
        T ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     *  删除以node为根的二分搜索树的最小节点
     *  返回删除节点后新的二分搜索树的根
     * @param node
     */
    private Node removeMin(Node node) {
        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大的节点，并返回删除的节点
     */
    public T removeMax() {
        T ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     *  删除以node为根的二分搜索树的最大节点
     *  返回删除节点后新的二分搜索树的根
     * @param node
     */
    private Node removeMax(Node node) {
        if(node.right == null) {
            Node rightNode = node.left;
            node.left = null;
            size--;
            return rightNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        generateBstString(root, 0, stringBuilder);
        return stringBuilder.toString();
    }

    private void generateBstString(Node node, int depth, StringBuilder stringBuilder) {
        if(node == null) {
            stringBuilder.append(generateDepthString(depth)).append("NULL\n");
            return;
        }
        stringBuilder.append(generateDepthString(depth)).append(node.t).append("\n");
        generateBstString(node.left, depth + 1, stringBuilder);
        generateBstString(node.right, depth + 1, stringBuilder);
    }

    private String generateDepthString(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }

}

package cn.algerfan.stack;

/**
 * @author algerfan
 * @date 2019/10/24 20:49
 */
public interface Stack<T> {

    /**
     * 获得大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈
     * @param t
     */
    void push(T t);

    /**
     * 出栈
     * @return
     */
    T pop();

    /**
     * 查看栈顶元素
     * @return
     */
    T peek();

}

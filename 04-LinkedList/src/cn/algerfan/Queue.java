package cn.algerfan;

/**
 * @author algerfan
 * @date 2019/10/24 22:03
 */
public interface Queue<T> {

    /**
     * 获取队列大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     * @param t
     */
    void enqueue(T t);

    /**
     * 出队
     * @return
     */
    T dequeue();

    /**
     * 获取队首元素
     * @return
     */
    T getFront();

}

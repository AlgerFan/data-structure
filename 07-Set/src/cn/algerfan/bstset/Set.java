package cn.algerfan.bstset;

/**
 * @author algerfan
 * @date 2019/11/3 19:19
 */
public interface Set<T> {

    /**
     * 添加
     * @param t
     */
    void add(T t);

    /**
     * 删除
     * @param t
     */
    void remove(T t);

    /**
     * 包含
     * @param t
     * @return
     */
    boolean contains(T t);

    /**
     * 获取大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

}

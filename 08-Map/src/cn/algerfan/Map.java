package cn.algerfan;

/**
 * @author algerfan
 * @date 2019/11/4 20:52
 */
public interface Map<K, V> {

    /**
     * 添加元素
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 删除元素
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 是否包含
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 查询元素
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 修改元素
     * @param key
     * @param value
     */
    void set(K key, V value);

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

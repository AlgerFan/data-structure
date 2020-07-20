package cn.algerfan;

/**
 * @author algerfan
 * @time 2019/8/25 21: 24
 */
public class Array<T> {

    /**
     * 数组
     */
    private T[] data;
    /**
     * 元素的个数
     */
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参的构造函数，容量默认为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组的大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素前添加一个元素
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 向所有元素后添加一个元素
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 在index处添加一个元素
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败, index不符合规则");
        }
        if(size == data.length) {
            resize(data.length * 2);
        }
        for (int i = size-1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        T[] newData = (T[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 获取index索引位置的元素
     */
    public T get(int index) {
        if(index < 0 || index >= size) {
                throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public T getLast() {
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     * @return
     */
    public T getFirst() {
        return get(0);
    }

    /**
     * 修改index索引位置的元素
     * @param index
     * @param e
     */
    void set(int index, T e){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     */
    public boolean contains(T e) {
        for (T datum : data) {
            if (datum == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e的索引，如果不存在元素e，则返回-1
     */
    public int find(T e) {
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除index位置的元素，并返回index索引的值
     * @param index
     */
    public T remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        T ret = data[index];
        /*for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }*/
        if (size - index + 1 >= 0) {
            System.arraycopy(data, index + 1, data, index, size - index + 1);
        }
        size--;
        data[size] = null;
        if(size == data.length/4 && data.length/2 != 0) {
            resize(data.length/2);
        }
        return ret;
    }

    /**
     * 删除第一个位置的元素，并返回index索引的值
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个位置的元素，并返回index索引的值
     */
    public T removeLast() {
        return remove(size -1);
    }

    /**
     * 删除数组中为e的元素
     * @param e
     */
    public void removeElement(T e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        stringBuffer.append("[");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(data[i]);
            if(i != size-1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

}

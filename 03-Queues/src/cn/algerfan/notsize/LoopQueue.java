package cn.algerfan.notsize;

/**
 * 在这一版本的实现中，完全不使用size，只使用front和tail来完成LoopQueue的所有逻辑
 * @author algerfan
 * @date 2019/11/03 17:26
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;

    @SuppressWarnings("unchecked")
    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    @Override
    public int getSize(){
        /*
        注意此时getSize的逻辑
        如果tail >= front，非常简单，队列中的元素个数就是tail - front
        如果tail < front，说明我们的循环队列"循环"起来了，此时，队列中的元素个数为：
        tail - front + data.length
         */
        return tail >= front ? tail - front : tail - front + data.length;
    }

    @Override
    public void enqueue(E e){
        if((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue(){
        if(isEmpty()) {
            throw new IllegalArgumentException("empty is queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if(getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront(){
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        int sz = getSize();
        for(int i = 0 ; i < sz ; i ++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = sz;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}

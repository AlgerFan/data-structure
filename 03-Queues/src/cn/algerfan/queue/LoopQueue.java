package cn.algerfan.queue;

/**
 * @author algerfan
 * @date 2019/10/24 22:34
 */
public class LoopQueue<T> implements Queue {

    private T[] data;
    private int front, tail;
    private int size;

    @SuppressWarnings("unchecked")
    public LoopQueue(int capacity) {
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void enqueue(Object t) {
        if((tail + 1) % data.length == front) {
            resize(getCapacity()*2);
        }
        data[tail] = (T) t;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        T ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size == getCapacity()/4 && getCapacity()/2 != 0) {
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public T getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Queue: size=%d, capacity=%d\n", size, getCapacity()));
        stringBuilder.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            stringBuilder.append(data[i]);
            if((i + 1) % data.length != tail) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}

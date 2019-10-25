package cn.algerfan.queues;

import cn.algerfan.arrays.Array;

/**
 * @author algerfan
 * @date 2019/10/24 22:10
 */
public class ArrayQueue<T> implements Queue<T> {

    private Array<T> array;

    public ArrayQueue() {
        array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(T t) {
        array.addLast(t);
    }

    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: ");
        stringBuilder.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if(i != array.getSize() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
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

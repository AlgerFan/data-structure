package cn.algerfan.linkedqueue;

import cn.algerfan.Queue;

import java.util.Random;

/**
 * @author algerfan
 * @date 2019/10/24 22:15
 */
public class Main {

    /**
     * 测试使用queue运行opCount个enqueue和dequeue操作需要的时间，单位：秒
     * @param queue
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        //测试链表队列
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double testQueue3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue: "+ testQueue3 +"s");
    }

}

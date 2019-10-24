package cn.algerfan.arrays;

/**
 * @author algerfan
 * @time 2019/8/25 21: 16
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }

        System.out.println(array);
        array.add(2, 100);
        System.out.println(array);
        array.addLast(-1);
        System.out.println(array);

        array.remove(2);
        array.removeElement(4);
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
    }
}

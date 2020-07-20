package cn.algerfan;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author algerfan
 * @date 2019/11/1 22:52
 */
public class Main2 {

    public static void main(String[] args) {
        Bst<Integer> bst = new Bst<>();
        Random random = new Random();
        int n = 1000;
        //依次删除最小的节点
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!bst.isEmpty()) {
            arrayList.add(bst.removeMin());
        }
        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if(arrayList.get(i) > arrayList.get(i + 1)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Delete completed.");

        //依次删除最大的节点
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        arrayList = new ArrayList<>();
        while (!bst.isEmpty()) {
            arrayList.add(bst.removeMax());
        }
        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if(arrayList.get(i) < arrayList.get(i + 1)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Delete completed.");
    }

}

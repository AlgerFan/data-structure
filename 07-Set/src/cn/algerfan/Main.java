package cn.algerfan;

import cn.algerfan.bstset.BstSet;
import cn.algerfan.bstset.FileOperation;
import cn.algerfan.bstset.Set;
import cn.algerfan.linkedset.LinkedListSet;

import java.util.ArrayList;

/**
 * @author algerfan
 * @date 2019/11/4 09:09
 */
public class Main {

    private static double testSet(Set<String> set, String filename){
        long startTime = System.nanoTime();
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "/media/algerfan/工作/javaCode/dataStructure/07-Set/pride-and-prejudice.txt";

        BstSet<String> bstSet = new BstSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BstSet: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("LinkedListSet: " + time2 + " s");
    }
}


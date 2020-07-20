package cn.algerfan.bstset;

import java.util.ArrayList;

/**
 * @author algerfan
 * @date 2019/11/3 19:31
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("/media/algerfan/工作/javaCode/dataStructure/07-Set/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());
            BstSet<String> set1 = new BstSet<>();
            for (String word : words1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();

        System.out.println("A Tale of Two Cities");
        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("/media/algerfan/工作/javaCode/dataStructure/07-Set/a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());
            BstSet<String> set2 = new BstSet<>();
            for(String word: words2) {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}

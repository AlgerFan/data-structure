package cn.algerfan.linkedset;

import cn.algerfan.bstset.FileOperation;
import cn.algerfan.bstset.Set;

import java.util.ArrayList;

/**
 * @author algerfan
 * @date 2019/11/3 19:19
 */
public class LinkedListSet<T> implements Set<T> {

    private LinkedList<T> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(T t) {
        if(! linkedList.contains(t)) {
            linkedList.addFirst(t);
        }
    }

    @Override
    public void remove(T t) {
        linkedList.removeElement(t);
    }

    @Override
    public boolean contains(T t) {
        return linkedList.contains(t);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("/media/algerfan/工作/javaCode/dataStructure/07-Set/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());
            LinkedListSet<String> set1 = new LinkedListSet<>();
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
            LinkedListSet<String> set2 = new LinkedListSet<>();
            for(String word: words2) {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }
    }

}

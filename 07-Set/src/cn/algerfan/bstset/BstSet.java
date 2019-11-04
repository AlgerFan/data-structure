package cn.algerfan.bstset;

/**
 * @author algerfan
 * @date 2019/11/3 19:19
 */
public class BstSet<T extends Comparable<T>> implements Set<T> {

    private Bst<T> bst;

    public BstSet() {
        bst = new Bst<>();
    }

    @Override
    public void add(T t) {
        bst.add(t);
    }

    @Override
    public void remove(T t) {
        bst.remove(t);
    }

    @Override
    public boolean contains(T t) {
        return bst.contains(t);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}

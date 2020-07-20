package cn.algerfan;

/**
 * @author algerfan
 * @date 2019/11/1 22:52
 */
public class Main {

    public static void main(String[] args) {
        Bst<Integer> bst = new Bst<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        /////////////////////
        //           5           //
        //       /      \        //
        //     3         6      //
        //    |  \          \    //
        //   2   4         8   //
        ////////////////////
        bst.preOrder();
        System.out.println();

        bst.preOrderNr();
        System.out.println();

        bst.inOrder();
        System.out.println();

        bst.postOrder();
        System.out.println();
        System.out.println(bst);

        bst.levelOrder();
        System.out.println();
    }

}

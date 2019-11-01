package cn.algerfan;

/**
 * @author algerfan
 * @date 2019/10/28 8:41
 */
public class Sum {

    public static int sum(int[] arr, int n) {
        if(n == arr.length) {
            return 0;
        }
        return arr[n] + sum(arr, n + 1);
    }

    public static void main(String[] args) {
        int[] ints = {1, 5, 7, 4, 6};
        System.out.println(sum(ints, 0));
    }

}

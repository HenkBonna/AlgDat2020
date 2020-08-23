package algdat;

public class Main {

    // Forelesning 1
    int max(int[] a) {
        int max_value = a[0];               // 1 + n + (n-1)
        for (int i=1; i<a.length; ++i) {    // 3
            if (a[i] > max_value) {         // 2 * (n-1)
                max_value = a[i];           // 2 * X
            }
        }
        return max_value;
    }

    public static void main(String[] args) {

        // Forelesning 1
        /*
        [1,2]  [2,1]
          1      0      ->      1/2 : avg = 0.5
        [1,2,3]  [1,3,2]  [2,1,3]  [2,3,1]  [3,1,2]  [3,2,1]
           2        1       1        1         0        0        ->     5/6 = 1/2 + 1/3 : avg = 0.8333

        [1,2,3,4]   [1,2,4,3]   [1,3,2,4]   [1,3,4,2]   [1,4,2,3]   [1,4,3,2]
            3           2           2           2           1           1
        [2,1,3,4]   [2,1,4,3]   [2,3,1,4]   [2,3,4,1]   [2,4,1,3]   [2,4,3,1]
            2           1           2           2           1           1
        [3,1,2,4]   [3,1,4,2]   [3,2,1,4]   [3,2,4,1]   [3,4,1,2]   [3,4,2,1]
            1           1           1           1           1           1
        [4,1,2,3]   [4,1,3,2]   [4,2,1,3]   [4,2,3,1]   [4,3,1,2]   [4,3,2,1]
            0           0           0           0           0           0       ->     26/24  = 1/2 + 1/3 + 1/4  :  avg = 1.08333

        Harmonisk tall: n tall : Sum(i=2 to n) = Hn ; et veldig lite tall
        n1 = 1 millioner ->
        n2 = 2 millioner ->

         */

    }
}

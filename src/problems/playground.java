package problems;

import java.util.ArrayList;
import java.util.List;

public class playground {
    public static void main(String[] args) {
//        List<Integer> tmp = new ArrayList<>(8);
//        System.out.println(tmp.size());
//        tmp.add(10);
//        System.out.println(tmp.size());
        Character c = '1';
//        System.out.println(c > null);
        char[] chars = new char[10];
        System.out.println();

        int[][] grid = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        System.out.println("grid.length: " + grid.length);
        System.out.println("grid[0].length: " + grid[0].length);
        System.out.println("grid[0][3]: " + grid[0][3]);
    }
}

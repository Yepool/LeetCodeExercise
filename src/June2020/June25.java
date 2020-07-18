package June2020;

import java.util.Arrays;

public class June25 {

    public static void main(String[] args) {

//        int[] nums = {3,2,1,0,4};
//        System.out.print(canJump(nums));

        int[][] grid1 = {{1,3,1}, {1,5,1}, {4,2,1}};
        int[][] grid2 = {{1,3}, {1,5}};
        System.out.print(minPathSum2(grid1));
    }

    public static int minPathSum2(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) {
                    ans[i][j] = grid[i][j];
                } else if(i==0) {
                    ans[i][j] = grid[i][j] + ans[i][j-1];
                } else if(j==0) {
                    ans[i][j] = grid[i][j] + ans[i-1][j];
                } else {
                    ans[i][j] = grid[i][j] + Math.min(ans[i-1][j], ans[i][j-1]);
                }
                System.out.println(Arrays.deepToString(ans));
            }
        }

        return ans[m-1][n-1];
    }

    public static int minPathSum(int[][] grid) {

        int i = 0;
        int j = 0;
        int m = grid.length;
        int n = grid[0].length;

        return minPathSumCore(grid, i, j, m, n);
    }

    public static int minPathSumCore(int[][] grid, int i, int j, int m, int n) {

        if(i == m-1 && j == n-1) {
            return grid[i][j];
        }
        if(i == m-1) {
            return grid[i][j] + minPathSumCore(grid, i, j+1, m, n);
        }
        if(j == n-1) {
            return grid[i][j] + minPathSumCore(grid, i+1, j, m, n);
        }
        return grid[i][j] + (minPathSumCore(grid, i+1, j, m, n) < minPathSumCore(grid, i, j+1, m, n)
                ? minPathSumCore(grid, i+1, j, m, n) : minPathSumCore(grid, i, j+1, m, n));
    }



    public static boolean canJump(int[] nums) {

        int[] arr = new int[nums.length];
        int k = nums.length-1;

        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] < (k - i)) {
                continue;
            } else {
                arr[i] = 1;
                k = i;
            }
        }

        return arr[0] == 1 ? true : false;
    }


}

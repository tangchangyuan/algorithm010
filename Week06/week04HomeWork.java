public class week06HomeWork {

    /**
     * * 64. 最小路径和
     *      * 思路:
     *      *              0,1,2  -->j
     *      *
     *      *       i->0   2,4,3
     *      *          1   4,5,6
     *      *          2   1,3,4
     *      *
     *      *
     *      *          dp方程 :
     *      *           要判断几个边界
     *      *              1.当i=j=0    不做任何处理
     *      *              2.当i=0      grid[i][j] = grid[i][j - 1] + grid[i][j];  (左边的最小值)
     *      *              3.当j=0      grid[i][j] = grid[i - 1][j] + grid[i][j];  (上边的最小值)
     *      *              4.i,j!=0     grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]; (左上的最小值)
     *      *
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 最大正方形
     *
     * 思路:  1.                      i
     *                               0      1 2 3 4 5  -->j
     *
     *              1 0 1 0 0        1      1 0 1 0 0
     *              1 0 1 1 1        2      1 0 1 1 1
     *              1 1 1 1 1        3      1 1 1 2 2
     *              1 0 0 1 0        4      1 0 0 1 0
     *
     *              dp方程:
     *              如果matrix[i][j] == 1  (最大边长为 dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1 )
     *              如果matrix[i][j] != 1   什么也不做
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

}

package javacode.dfs;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * 链接：https://leetcode.cn/problems/number-of-islands
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islandNums = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                /**
                 * 只判断陆地，0 是海洋，2是走过的路，只有 1 有效
                 */
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islandNums++;
                }
            }
        }
        return islandNums;
    }

    private void dfs(char[][] grid, int i, int j){
        /**
         * 退出条件1：超出范围
         */
        if (i < 0 || j < 0 || i == grid.length || j == grid[i].length) {
            return;
        }
        /**
         * 退出条件2：不是陆地
         */
        if (grid[i][j] != '1'){
            return;
        }
        /**
         * 遍历过的格子标记一下，防止重复遍历，和4格循环
         */
        grid[i][j] = 2;
        dfs(grid, i+1, j);
        dfs(grid,  i,j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }


    public static void main(String[] args) {
        NumberOfIslands noi = new NumberOfIslands();
        char[] chars = new char[]{};
        char[][] grid = new char[][]{};
    }
}

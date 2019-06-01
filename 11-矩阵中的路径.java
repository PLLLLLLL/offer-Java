/**
 * Author: penglei
 * Date: 2019-06-01 
 **/

    /**
     * 【题目描述】
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 
     * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
     * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     
     
     * 利用回溯法解决
     */

public class Solution {
    /**
     * @param matrix 输入矩阵
     * @param rows   矩阵行数
     * @param cols   矩阵列数
     * @param str    要搜索的字符串
     * @return 是否找到 true是，false否
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix==null || matrix.length<=0 || rows<0 || cols<0 || str == null || str.length<0) {
            return false;
        }
        // 变量初始化
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        int[] pathLength = {0};
        // 以每一个点为起始进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, str, visited, i, j, pathLength)) {
                    return true;
                }
            }
        }

        return false;
    }
    
     /**
     * 回溯搜索算法
     *
     * @param matrix     输入矩阵
     * @param rows       矩阵行数
     * @param cols       矩阵列数
     * @param str        要搜索的字符串
     * @param visited    访问标记数组
     * @param row        当前处理的行号
     * @param col        当前处理的列号
     * @param pathLength 已经处理的str中字符个数
     * @return 是否找到 true是，false否
     */
     private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited,
                                       int row, int col, int[] pathLength) {
        if (pathLength[0] == str.length) {
            return true;
        }

        boolean hasPath = false;

        // 判断位置是否合法
        // matrix[row * cols + col]就是矩阵中当前查找的字符的正下方的字符
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength[0]]
                && !visited[row * cols + col]) {

            visited[row * cols + col] = true;
            pathLength[0]++;

            // 按左上右下进行回溯
            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLength);

            if (!hasPath) {
                pathLength[0]--;
                visited[row * cols + col] = false;
            }

        }

        return hasPath;
    }


}

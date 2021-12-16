//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 467 👎 0


package leetcode.editor.cn;

import com.sun.javafx.scene.traversal.Direction;

import java.util.ArrayDeque;

public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] words;

        public boolean exist(char[][] board, String word) {
            this.words = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    //注意不能写成下一行：当dfs返回false时此函数不能直接返回 应继续算下一个点
                    //return (dfs(i, j, 0, board));
                    if (dfs(i, j, 0, board))
                        return true;
                }
            }
            return false;
        }

        boolean dfs(int i, int j, int length, char[][] board) {
            //只有当每个字符都匹配上才会到下一层 所以不会出现层数超过字符串长度的情况
            //if (length > words.length - 1) return false;
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
            if (board[i][j] != words[length]) return false;
            if (length == words.length - 1) return true;
            board[i][j] = '\0';
            boolean result = dfs(i + 1, j, length + 1, board) || dfs(i - 1, j, length + 1, board)
                    || dfs(i, j + 1, length + 1, board) || dfs(i, j - 1, length + 1, board);
            board[i][j] = words[length];
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
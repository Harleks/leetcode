//给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。 
//
// 输入为三个整数：day、month 和 year，分别表示日、月、年。 
//
// 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", 
//"Friday", "Saturday"}。 
//
// 
//
// 示例 1： 
//
// 输入：day = 31, month = 8, year = 2019
//输出："Saturday"
// 
//
// 示例 2： 
//
// 输入：day = 18, month = 7, year = 1999
//输出："Sunday"
// 
//
// 示例 3： 
//
// 输入：day = 15, month = 8, year = 1993
//输出："Sunday"
// 
//
// 
//
// 提示： 
//
// 
// 给出的日期一定是在 1971 到 2100 年之间的有效日期。 
// 
// Related Topics 数学 👍 38 👎 0


package leetcode.editor.cn;

public class DayOfTheWeek {
    public static void main(String[] args) {
        Solution solution = new DayOfTheWeek().new Solution();
        String out = solution.dayOfTheWeek(12,12,2021);
        System.out.println(out);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String dayOfTheWeek(int day, int month, int year) {
            int[] m = new int[]{
                    31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
            };
            String[] weekname = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            int i, j;
            int sum = 0;
            for (i = 1971; i < year; i++) {
                if (isRun(i))
                    sum += 366;
                else sum += 365;
            }
            if (isRun(year)) m[1] += 1;
            for (j = 0; j < month - 1; j++)
                sum += m[j];
            sum += day;
            return weekname[(sum + 4) % 7];
        }
        //判断闰年
        public boolean isRun(int year) {
            return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 440 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        int[] nums = new int[]{9, 6, 1, 6, 3, 8, 7};
        System.out.println(Arrays.toString(solution.sortArray(nums)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        void quickSort(int[] nums, int left, int right) {
            if (left >= right)
                return;
            int pivot = nums[left];
            int low = left;
            int high = right;
            while (low < high) {
                while (nums[high] >= pivot && low < high) {
                    high--;
                }
                if(low<high)
                swap(nums, low, high);
                while (nums[low] <= pivot && low < high) {
                    low++;
                }
                if(low<high)
                swap(nums, low, high);
            }
            quickSort(nums, left,  low- 1);
            quickSort(nums, low + 1, right);
        }

        void swap(int[] nums, int a, int b) {
            nums[a] ^= nums[b];
            nums[b] ^= nums[a];
            nums[a] ^= nums[b];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
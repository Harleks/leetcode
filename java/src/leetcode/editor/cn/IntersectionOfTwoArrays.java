//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 464 👎 0

  
  package leetcode.editor.cn;

import java.util.HashSet;

public class IntersectionOfTwoArrays{
      public static void main(String[] args) {
           Solution solution = new IntersectionOfTwoArrays().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hashSet.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(hashSet.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        int[] resultArray = new int[result.size()];
        int i =0;
        for(int x:result){
            resultArray[i++]=x;
        }
        return resultArray;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
package leetcode.editor.cn.doc;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * @version 1.0
 * @classname test
 * @description
 * @auther harlek
 * @create 2021-12-15-17:17
 */
public class test {
    @Test
    public void test() {
        int a=3,b=4;
        int c=1000,d=2000;
        int[] nums = new int[]{3,4};
        swap1(nums,0,1);
        swap2(a,b);
        try {
            swap3(c,d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(a+","+b);
        System.out.println(nums[0]+","+nums[1]);
        System.out.println(c+","+d);

    }

    void swap1(int[] nums, int a, int b) {
        nums[a] ^= nums[b];
        nums[b] ^= nums[a];
        nums[a] ^= nums[b];
    }

    void swap2(int a, int b) {
        a ^= b;
        b ^= a;
        a ^= b;
    }
    void swap3(Integer a, Integer b) throws Exception {
        Field field = a.getClass().getDeclaredField("value");
        field.setAccessible(true);
        Object temp = field.get(a);
        field.set(a, field.get(b));
        field.set(b, temp);
    }
}

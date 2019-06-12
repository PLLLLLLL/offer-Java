/**
 * Author: penglei
 * Date: 2019-06-12
 **/

    /**
     * 【题目描述】
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。（注意！！！！）
     */

// 若只是奇数在前，偶数在后，不要求顺序，以下代码成功
public class Solution {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return ;
        }
        // 从左向右记录偶数的位置
        int start = 0;
        // 从右向左记录奇数的位置
        int end = array.length - 1;
        // 开始调整奇数和偶数的位置
        while (start < end) {
            // 找偶数
            while (start < end && array[start] % 2 != 0) {
                start++;
            }
            // 找奇数
            while (start < end && array[end] % 2 == 0) {
                end--;
            }
            // 找到后就将奇数和偶数交换位置
            if (start < end) {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }
    }
}

// 若不仅是奇数在前，偶数在后，并保证奇数和奇数，偶数和偶数之间的相对位置不变，以下代码成功
public class Solution {
    public void reOrderArray(int [] array) {
        int count = 0; //记录已经摆好位置的奇数的个数
        int len = array.length-1;
        for (int i = 0; i <= len; i++) {
            if (array[i]%2==1) {
                int j = i;
                // 交换奇数偶数前后位置
                while(j>count) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    j--;
                }
                count++;
            }
        }
    }
}

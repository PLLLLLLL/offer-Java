/**
 * Author: penglei
 * Date: 2019-05-30 
 **/

    /**
     * 【题目描述】
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     
     
     * 以下是面试官期待的使用算法，比直接用if else判断的那种算法运算效率高
     */

public class Solution {
    public int Fibonacci(int n) {
        // 当输入非正整数的时候返回0
        if (n <= 0) {
            return 0;
        }
        
        // 输入1或者2的时候返回1
        if (n == 1 || n == 2) {
            return 1;
        }
        
        // 记录前两个（第n-2个）的Fibonacci数的值
        int prePre = 1;
        // 记录前两个（第n-1个）的Fibonacci数的值
        int pre = 1;
        // 记录前两个（第n个）的Fibonacci数的值
        int current = 2;

        // 求解第n个的Fibonacci数的值
        for (int i = 3; i <= n ; i++) {
            // 求第i个的Fibonacci数的值
            current = prePre + pre;
            // 更新记录的结果，prePre原先记录第i-2个Fibonacci数的值
            // 现在记录第i-1个Fibonacci数的值
            prePre = pre;
            // 更新记录的结果，pre原先记录第i-1个Fibonacci数的值
            // 现在记录第i个Fibonacci数的值
            pre = current;
        }
        // 返回所求的结果
        return current;
    }
}

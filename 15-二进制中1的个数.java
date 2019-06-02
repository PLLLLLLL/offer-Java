/**
 * Author: penglei
 * Date: 2019-06-02 
 **/

    /**
     * 【题目描述】
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * 例如把9表示成二进制是1001 ，有2位是1. 因此如果输入9，该出2。
     
     * 考察位运算
     */

// ======第一种方法，常规解法======
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag!=0) {
            if ((n & flag)!=0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}

// ======第二种方法，给面试官带来惊喜的解法，效率更高======
public class Solution {
    public int NumberOf1(int n) {
         // 记录数字中1的位数
        int count = 0;

        // 数字的二进制表示中有多少个1就进行多少次操作
        while (n != 0) {
            ++count;
            // 从最右边的1开始，每一次操作都使n的最右的一个1变成了0，
            // 即使是符号位也会进行操作。
            n = (n - 1) & n;
        }

        // 返回求得的结果
        return count;
    }
}

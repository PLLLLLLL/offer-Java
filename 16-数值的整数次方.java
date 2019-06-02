/**
 * Author: penglei
 * Date: 2019-06-02
 **/

    /**
     * 【题目描述】
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

     * 考虑多种情况，注意代码完整性
     */

// ======常规运算======
public class Solution {
    public double Power(double base, int exponent) {
        double result = 0.0;
        if (base == 0 && exponent == 0)
        	return -1;
        if (exponent<0) {
            result = PowerWithUnsignedExponent(base,-exponent);
            result = 1.0/result;
        } else {
            result = PowerWithUnsignedExponent(base,exponent);
        }
        return result;
    }
    
    public double PowerWithUnsignedExponent(double base, int exponent) {
        // 注意 double 
        double result = 1.0;
        for (int i=1;i<=exponent;i++){
            // 连乘
            result = base*result;
        }
        return result;
    }
}

// ======效率更高的位运算======
public class Solution {
    public double Power(double base, int exponent) {
        double result = 0.0;
        if (base == 0 && exponent == 0)
        	return -1;
        if (exponent<0) {
            result = PowerWithUnsignedExponent(base,-exponent);
            result = 1.0/result;
        } else {
            result = PowerWithUnsignedExponent(base,exponent);
        }
        return result;
    }
    
    public double PowerWithUnsignedExponent(double base, int exponent) {
        // 如果指数为0，返回1
        if (exponent == 0) {
            return 1;
        }
        // 指数为1，返回底数
        if (exponent == 1) {
            return base;
        }
        // 递归求一半的值
        double result = PowerWithUnsignedExponent(base, exponent >> 1);
        // 求最终的值，如果是奇数就还要剩以一次底数
        result *= result;
        if (exponent % 2 != 0) {
            result *= base;
        }
        // 返回结果
        return result;
    }
}

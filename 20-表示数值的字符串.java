/**
 * Author: penglei
 * Date: 2019-06-12
 **/

    /**
     * 【题目描述】
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     */

public class Solution {
    private int index = 0; // 定义在小类之外，否则其他类找不到
    public boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        
        boolean numeric = scanInteger(str);
        // 出现'.'，接下来是小数部分
        if (index < str.length && str[index] == '.') {
            index++;
            // 小数前面和后面都可以有数字，也可以前面没数字或者后面没数字
            numeric = scanUnsignedInteger(str) || numeric;
        }
        
        // 出现'e'或者'E'，接下里是指数部分
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            // e前面和后面不能没有数字
            numeric = numeric && scanInteger(str);
        }
        return numeric && index == str.length;
    }
    
    public boolean scanInteger(char[] str) {
        if (index < str.length && (str[index]=='+'||str[index]=='-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }
    
    public boolean scanUnsignedInteger(char[] str) {
        int temp = index;
        while (index < str.length && (str[index]>='0'&& str[index]<='9')) {
            index++;
        }
        return temp<index;
    }
}

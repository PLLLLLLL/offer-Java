/**
 * Author: penglei
 * Date: 2019-06-01 
 **/

    /**
     * 【题目描述】
     * 给你一根长度为n的绳子，请把绳子剪成m段，记每段绳子长度为k[0],k[1]...k[m-1],求k[0]k[1]...k[m-1]的最大值。
     * 已知绳子长度n为整数，m>1(至少要剪一刀，不能不剪)，k[0],k[1]...k[m-1]均要求为整数。
     * 例如，绳子长度为8时，把它剪成3-3-2，得到最大乘积18
     
     
     * 第一种用动态规划的方法暴力解决
     * 第二种用贪婪算法解决
     */

// ======动态规划======
public class Solution {
    public static int maxProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        //存储长度从 0-len 的最大结果
        int[] products = new int[length + 1];  // 将最优解存储在数组中
        // 数组中第i个元素表示把长度为i的绳子剪成若干段之后的乘积的最大值
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= length; i++) {  //i表示长度
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                //由于长度i存在（1，i-1）和（i-1，1）的重复，所以只需要考虑前一种
                int product = products[j] * products[i - j];
                if (product > max) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length]
        return max;
    }
}

// ======贪婪算法=======
public class Solution {
    public static int maxProductWithGreedy(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        //啥也不管,先尽可能减去长度为3的段
        int timesOfThree=length/3;
        //判断还剩下多少，再进行处理
        if(length-timesOfThree*3==1) {
            timesOfThree -= 1;
        }
        int timesOfTwo = (len-timesOfThree*3)/2;
        
        return (int) (Math.pow(3, timesOfThree))*(Math.pow(2, timesOfTwo));
    }
}

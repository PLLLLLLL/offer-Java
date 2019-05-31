/**
 * Author: penglei
 * Date: 2019-05-31 
 **/

    /**
     * 【题目描述】
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     
     
     * 
     */

import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length-1;
        if (left>right || array == null) {
            return -1;
        }
        
        int mid = 0;
        while (left < right) {
            // 取中间点
            mid = (left+right)/2;
            //特殊情况处理
            if (array[mid]==array[left] && array[mid]==array[right]) {
                return array[right];
            }
            //左右相邻时，输出右边的值即最小值。
            if (right-left==1) {
                return array[right];
            }
            //左边递增序列，右边递增序列判断。
            if (array[mid]>=array[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[right];
    
    }
}

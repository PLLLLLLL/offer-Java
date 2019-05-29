/**
 * Author: penglei
 * Date: 2019-05-28
 **/

    /**
     * 【题目描述】
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
     
     * 规律：题目中明确指出n个数字，其取值范围在0到n-1之间，所以可以认为
     * 如果都不相等，则数组下标总能找到和其一致的数字
     * 如果存在重复的，则某些数组下标应有一个以上的数字与之相一致
     * 所以我们通过找与下标一致的数字，如果当前下标中放得数字与下标不一致，则看该数字对应的下标中的数字是否和当前下标中的数字是否一致

     * 若一致，则输出，并找下一个重复数字
     * 若不一致，则交换两个下标对应的数字，并重复此过程
     * 这样，数字都落在与其一致的下标中，只有重复的数字，会落在其他与其不一致的（重复次数-1）下标中
     */
     
public class Solution {
    public static void duplicateInt3(int[] array) {
        if (array == null) {
            return;
        }
        // 存在重复数字，起码有两个以上的数字才可以
        int len = array.length;
        if (len < 2) {
            return;
        }
        
        // 数字中的数字范围在0到len-1之间，否则就认为是个错误的数组，不考虑重复数字问题
        for (int i = 0; i < len; i++) {
            if (array[i] < 0 || array[i] > len - 1) {
                return;
            }
        }
        
        // 比如 {2, 3, 1, 0, 2, 5, 3}
        // array[0] = 2，不一致，array[2] = 1， 不相等，则交换，得到 {1, 3, 2, 0, 2, 5, 3}
        // array[0] = 1，不一致，array[1] = 3， 不相等，则交换，得到 {3, 1, 2, 0, 2, 5, 3}
        // array[0] = 3，不一致，array[3] = 0， 不相等，则交换，得到 {0, 1, 2, 3, 2, 5, 3}
        // array[0] = 0，一致，现在下标0中存放了预期一致的数字，结束下标0的操作
        // array[1] = 1，一致，现在下标1中存放了预期一致的数字，结束下标1的操作
        // array[2] = 2，一致，现在下标2中存放了预期一致的数字，结束下标2的操作
        // array[3] = 3，一致，现在下标3中存放了预期一致的数字，结束下标3的操作
        // array[4] = 2，不一致，array[2] = 2，相等输出结果，无需交换，结束下标4的操作，此时 {0, 1, 2, 3, 2, 5, 3}
        // array[5] = 5，一致，现在下标5中存放了预期一致的数字，结束下标5的操作
        // array[6] = 3，不一致，array[3] = 3，相等输出结果，无需交换，结束下标4的操作，此时 {0, 1, 2, 3, 2, 5, 3}
        
        for (int i = 0; i < len; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]]) {
                    System.out.print(array[i] + " ");
                    break;
                } else {
                    int temp = array[i];
                    array[i] = array[temp];
                    array[temp] = temp;
                }
            }
        }
        return;
    }
}


或者：


public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length<=0)
			return false;
		
        int tempVal = 0;
		
        for (int i=0;i<numbers.length;i++) {
			while (numbers[i]!=i) {
				if (numbers[i]==numbers[numbers[i]]) {
					//System.out.println(numbers[i]);
					duplication[0] = numbers[i];
					return true;
				}
				tempVal = numbers[i];
				numbers[i] = numbers[tempVal];
				numbers[tempVal] = tempVal;
			}
		}
		return false;
    }
}

/**
 * Author: penglei
 * Date: 2019-05-28 
 **/

    /**
     * 【题目描述】
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     
     * 末尾指针进行替换
     */

public class Solution {
    public String replaceSpace(StringBuffer str) {
    	// 判断输入是否合法
    	if (str.equals(null) || str.length()<=0) {
			return "";
		}
    	
    	// 统计字符数组中的空白字符数
	String string = new String();
	string = str.toString();
	int count = 0;
	int originLen = str.length();
	// StringBuffer判断字符用法
	for (int i=0;i<originLen;i++) {
		if (str.charAt(i)==' ') {
			count++;
		}
	} 	
		
	// 扩充StringBuffer长度,计算转换后的字符长度是多少
	int newchLen = str.length() + count*2;
	// StringBuffer扩展长度用法
	str.setLength(newchLen);
	// 长度为 newchLen, 索引最大调用为 newchLen - 1
	newchLen = newchLen - 1;
	for (int j=originLen-1; j>=0; j--) {
		if (str.charAt(j) == ' ') {
			// setCharAt 设置
			str.setCharAt(newchLen--, '0');
			str.setCharAt(newchLen--, '2');
			str.setCharAt(newchLen--, '%');				
		} else {
			str.setCharAt(newchLen--, str.charAt(j));			
		}
	}
		
	return str.toString();
    }
}

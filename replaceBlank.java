public class Solution {
    public String replaceSpace(StringBuffer str) {
    	// �ж������Ƿ�Ϸ�
    	if (str.equals(null) || str.length()<=0) {
			return "";
		}
    	
    	// ͳ���ַ������еĿհ��ַ���
		String string = new String();
		string = str.toString();
		int count = 0;
		int originLen = str.length();
		// StringBuffer�ж��ַ��÷�
		for (int i=0;i<originLen;i++) {
			if (str.charAt(i)==' ') {
				count++;
			}
		} 	
		
		// ����StringBuffer����,����ת������ַ������Ƕ���
		int newchLen = str.length() + count*2;
		// StringBuffer��չ�����÷�
		str.setLength(newchLen);
		// ����Ϊ newchLen, ����������Ϊ newchLen - 1
		newchLen = newchLen - 1;
		for (int j=originLen-1; j>=0; j--) {
			if (str.charAt(j) == ' ') {
				// setCharAt ����
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
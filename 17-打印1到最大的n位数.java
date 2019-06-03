/**
 * Author: penglei
 * Date: 2019-06-03
 **/

    /**
     * 【题目描述】
     * 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
     
     * 考虑多种情况，注意代码完整性
     */


public class PrintMaxOfNDigits { 
    // 这个方法是用来实现对数加1操作
    public boolean Increment(int[] number) {
        boolean isOverflow = false; // 判断是否溢出
        int nTakeOver=0; // 判断是否进位
        for(int i=number.length-1;i>=0;i--) {
            int nSum = number[i]+nTakeOver;
            if(i==number.length-1)
                nSum++;
            if(nSum>=10) {
                if(i==0)
                    isOverflow=true;
                } else{
                    nTakeOver=1;
                    nSum=nSum-10;
                    number[i]=nSum;
                }
            } else{
                number[i]=nSum;
                break;
            }
        }
        return isOverflow;
    }
    
    public void PrintNumber(int[] number) {
    // 该方法是负责打印一个正类，千万不要尝试将数组变成一个整数
        boolean isBeginning=true;
        for(int i=0;i<number.length;i++){
            if(isBeginning&&number[i]!=0)
                isBeginning=false;
            if(!isBeginning){
                System.out.print(number[i]);
            }
        }
    }
    
    public void Test(int n){
    //打印从1到最大的n位整数
        if(n<=0)
            System.out.println("输入出错，请重新输入！");
        int[] number = new int[n];

        while(!Increment(number)){
            PrintNumber(number);
            //System.out.println();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new PrintMaxOfNDigits().Test(1);
    }
}


//第二中方法实现，全排序实现
public void PrintMaxOfNdigits(int[] number,int length,int index){
    if(index == length-1){
        PrintNumber(number);
        return;
    }
    for(int i=0;i<10;i++) {
        number[index+1]=i;
        PrintMaxOfNdigits(number, length, index+1);
    }
}

public void Test1(int n){
    if(n<=0)
        return;
    int[] number = new int[n];
    for(int i=0;i<10;i++){
        number[0]=i;
        PrintMaxOfNdigits(number, n, 0);
    }
}

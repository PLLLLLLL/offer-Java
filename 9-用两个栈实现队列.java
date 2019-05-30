/**
 * Author: penglei
 * Date: 2019-05-30
 **/

    /**
     * 【题目描述】
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     
     * 规律：理解队列是先进先出，栈是先进后出
     */

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>(); // 不妨设stack1为插入栈，只用于插入数据
    Stack<Integer> stack2 = new Stack<Integer>(); // 不妨设stack2为弹出栈，只用于弹出数据
    
    // 添加操作，成在队列尾部插入结点
    public void push(int node) {
        stack1.push(node);
    }
    
    // 删除操作，在队列头部删除结点
    public int pop() {
        if (stack1.size()<=0 && stack2.size()<=0) {
            throw new RuntimeException("Queue is empty!");
        }
        
        // 先判断弹出栈是否为空，不为空直接弹出
        if (stack2.size()!=0) {
            return stack2.pop();
        } else {
            // 如果为空就将插入栈的所有数据弹出栈，并且将弹出的数据压入弹出栈中
            while (stack1.size()>0) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}

/**
 * Author: penglei
 * Date: 2019-05-28
 **/

    /**
     * 【题目描述】
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     
     * 先遍历链表，将值存入栈中（栈先进后出）
     * 再将栈中的值读取存入链表中，返回链表值
     */

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 建立一个栈,把链表存进去，先进后出
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
         
        // 建立一个链表，从栈里把元素一个一个取出来
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
         
        return list;
    }
}

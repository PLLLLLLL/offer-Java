/**
 * Author: penglei
 * Date: 2019-06-03
 **/

    /**
     * 【题目描述】
     * 给定单向链表的头指针和一个结点指针，定义一个函数在O（1）时间删除该结点。链表结点与函数的定义如下：
     * struct ListNode{
           int m_nValue;
	       ListNode* m_pNext;
       }
       void DeleteNode(ListNode ** pListHead, ListNode* pToBeDeleted);
     */

 /**
     * 第一思路：时间复杂度为O（n）的方法
     * 从链表的头结点开始，顺序遍历查找要删除的结点，并在链表中删除该结点。时间复杂度为O（n）。
     * 其实这和数组没有什么区别了，没有充分利用链表的特点。
     */

public class ListNode {
	//属性定义成公开的方便调用和使用
	public int data;
	//公有属性
	public ListNode next;
	
}
//O(n)时间复杂度删除pDelNode结点
public void deleteNode1(ListNode pHead, ListNode pDelNode){
	if(pHead==null || pDelNode==null){
		return;
	}
	if(pHead == pDelNode){ //删除的是头结点
		ListNode pNext = pDelNode.next;
		pDelNode.data = pNext.data;
		pDelNode.next = pNext.next;
		return;		
	}
	//利用O(n)的时间复杂度删除结点
	for (ListNode pNode = pHead; pNode.next!=null; pNode = pNode.next) {
		if(pNode.next  == pDelNode){
			pNode.next = pNode.next.next;
			break;
		}
	}
}

 /**
     * 第二思路：在O（1）的时间复杂度删除结点
     * 因为从某个链表的结点可以知道链表的下一个结点，故可以把下一结点的内容复制到需要删除的结点上覆盖原有的内容，
     * 再把下一个结点删除，就相当于把当前需要删除的结点删除。
     * 这是分为三种情况：删除的结点不在链表尾部；链表只有一个结点，删除头结点；链表中有多个结点，删除尾部结点。
     */

//O(1)时间删除链表的结点
public void deleteNode(ListNode pHead, ListNode pDelNode) {
	if(pHead==null || pDelNode==null) {
		return;
	}
	if(pDelNode.next!=null) { //要删除的结点不是尾部结点
		ListNode pNext = pDelNode.next;
		pDelNode.data = pNext.data;
		pDelNode.next = pNext.next;
	} else if(pHead == pDelNode) { //链表只有一个结点，删除头结点
		pHead = null;
		pDelNode = null;
	} else { //链表中有多个结点，删除尾结点
		ListNode pNode = pHead;
		while(pNode.next != pDelNode) {
			pNode = pNode.next;
		}
		pNode.next = null;
	}
}

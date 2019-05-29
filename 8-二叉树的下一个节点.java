/**
 * Author: penglei
 * Date: 2019-05-29
 **/

    /**
     * 【题目描述】
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     
     * 分情况讨论，是否存在右节点
     */


/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;
    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 如果 pNode为空，返回 null
		if (pNode == null) {
			  return null;
		}
		    
        // 如果 pNode存在右子树，找右子树最左的节点
		if (pNode.right != null) {
			  // 不存在左节点
			  pNode = pNode.right;
			  // 存在左节点，找最左的节点
			  while (pNode.left != null) {
				    // 遍历寻找
				    pNode = pNode.left;
			  }
			  return pNode;
		    
        // 如果 pNode不存在右子树，节点父节点的左子节点等于 pNode
		} else if (pNode.next != null && pNode.right == null && pNode.next.left == pNode) {
			    return pNode.next;
		// 如果 pNode不存在右子树，节点父节点的右子节点等于 pNode
		} else if (pNode.next != null && pNode.right == null && pNode.next.right == pNode) {
			  //  是否存在父节点有左子节点
			    while (pNode.next != null && pNode.next.left != pNode) {
					    // 遍历寻找
					    pNode = pNode.next;
				} 	
			    return pNode.next;
		} else {
			    return pNode.next;
		}		
    }
}

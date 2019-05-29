/**
 * Author: penglei
 * Date: 2019-05-29 
 **/

    /**
     * 【题目描述】
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
   /**
     * @param preArr 前序遍历
     * @param inArr  中序遍历
     * @return 树的根结点
     */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] preArr,int [] inArr) {
        // 输入的合法性判断，两个数组都不能为空
        if (preArr == null || inArr == null) {
			return null;
		}
		
        TreeNode root = reConstruct(preArr, 0, preArr.length-1, inArr, 0, inArr.length-1);
 
		return root;
	}
	
    /**
     * @param preArr 前序遍历
     * @param preS   前序遍历的开始位置
     * @param preE   前序遍历的结束位置
     * @param inArr  中序遍历
     * @param inS    中序遍历的开始位置
     * @param inE    中序遍历的结束位置
     * @return 树的根结点
     */
	public TreeNode reConstruct(int[] preArr, int preS, int preE, int[] inArr, int inS, int inE) {
		    // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (preS>preE || inS>inE) {
            return null;
		    }
        // 取前序遍历的第一个数字preArr[preS]，就是当前的根结点
		    TreeNode root = new TreeNode(preArr[preS]);
		    for (int i=inS; i<=inE; i++) {
			      if (inArr[i]==preArr[preS]) {
				        // 记录 len，用于递归时确定 前序遍历序列的截取长度
				        int len = i - inS;
				        
				        // 递归构建当前根结点的左子树，左子树的元素个数：len 个
                // 左子树对应的前序遍历的位置在[preS+1, preS+len]
                // 左子树对应的中序遍历的位置在[inS, i-1]
				        root.left = reConstruct(preArr, preS+1, preS+len, inArr, inS, i-1);
                // 递归构建当前根结点的右子树，右子树的元素个数：inE-i 个
                // 右子树对应的前序遍历的位置在[preS+len+1, preE]
                // 右子树对应的中序遍历的位置在[i+1, inE]
				        root.right = reConstruct(preArr, preS+len+1, preE, inArr, i+1, inE);
			      }			
	    	}
		    System.out.print(root.val+" ");
		    return root;
    }
}

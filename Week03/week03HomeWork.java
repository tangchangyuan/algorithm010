public class week03HomeWork {

    /********************************105. 从前序与中序遍历序列构造二叉树*************************************************/


    /**
     * 从前序与中序遍历序列构造二叉树
     * 思路:
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     * 1.前序遍历的顺序 是 root->left->right 所以确定 3 是根节点.
     * 2.确定左子树和右子树的边界 中序遍历  left->root->right 所以中序遍历 3 的左边是左子树的节点,右边是右子树的节点
     *
     *******************************************************
     * 故:
     *              3
     *          9       20,15,7
     *
     *
     ********************************************************
     *              3
     *          9        20
     *               15       7
     ********************************************************
     * 3.递归
     *
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * 递归函数
     * @param preorder
     * @param p_start
     * @param p_end
     * @param inorder
     * @param i_start
     * @param i_end
     * @return
     */
    private TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];  //找到根节点的值
        TreeNode root = new TreeNode(root_val);  //赋值给根节点

        //在中序遍历中找到根节点的位置  start
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }
        //在中序遍历中找到根节点的位置  i_root_index  end


        int leftNum = i_root_index - i_start;  //确定左节点的个数
        //递归的构造左子树
        // 前序遍历:  p_start+1 左节点开始的边界  p_start + leftNum + 1 左节点结束边界
        // 中序遍历:  i_start 左节点开始的边界  i_root_index 左节点结束边界
        root.left = buildTree(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        //递归的构造右子树
        // 前序遍历:  p_start + leftNum + 1 右节点开始的边界  p_end 左节点结束边界
        // 中序遍历:  i_root_index + 1 右节点开始的边界  i_end 右节点结束边界
        root.right = buildTree(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**********************************50. Pow(x, n)***********************************************/
    /**
     * 思路: 1.暴力解法,通过for循环暴力实现 时间复杂度 O(n)
     * @param x
     * @param n
     * @return
     */
   /* public double myPow(double x, int n) {
        //处理N为负数的情况
        if(n < 0) {
            x = 1/x; //取x的倒数
            n = -n;
        }
        double res = 1;
        for (long i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }*/

    /**
     * 思路: 2.使用分治
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        long N = n;
        return  myPow(x,N);
    }

    private static double myPow(double x, long N) {
        if(N == 0)  return 1.0;
        if(N < 0) {
            x = 1/x;
            N = -N;
        }
        double res = myPow(x,N/2);

        if(N % 2 == 1) {
            return res * res * x;
        } else {
            return res * res;
        }
    }


    /**********************************236. 二叉树的最近公共祖先***********************************************/

    /**
     * 思路:1.递归向左子树和右子树查询节点信息。
     *     2.递归终止条件: 如果root==null || root== p || root==q，则返回当前节点。
     *     3.如果左右子树查到节点都不为空，那么p和q分别在左右子树中,所以当前节点即为最近公共祖先。
     *     4.如果左右子树有一个不为空，则返回非空节点。
     * @param TreeNode
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止条件: 如果root==null || root== p || root==q，则返回当前节点。
        if(root == null || root == p || root == q){
            return root;
        }
        // 递归向左子树和右子树查询节点信息。
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左右子树查到节点都不为空，那么p和q分别在左右子树中，所以当前节点即为最近公共祖先。
        if(left != null && right != null){
            return root;
        }

        // 如果左右子树有一个不为空，则返回非空节点。
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;

    }


}

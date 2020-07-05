学习笔记
广度优先和深度优先搜索

```java
广度优先:
public void levelTraverse(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        LinkedList<TreeNode> queue = new LinkedList<>();  
        queue.offer(root);  
        while (!queue.isEmpty()) {  
            TreeNode node = queue.poll();  
            System.out.print(node.val+"  ");  
            if (node.left != null) {  
                queue.offer(node.left);  
            }  
            if (node.right != null) {  
                queue.offer(node.right);  
            }  
        }  
    }  
深度优先:
public void depthOrderTraverse(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        LinkedList<TreeNode> stack = new LinkedList<>();  
        stack.push(root);  
        while (!stack.isEmpty()) {  
            TreeNode node = stack.pop();  
            System.out.print(node.val+"  ");  
            if (node.right != null) {  
                stack.push(node.right);  
            }  
            if (node.left != null) {  
                stack.push(node.left);  
            }  
        }  
    }  
        
    
```

贪心算法:
```text
总是做出在当前看来是最好的选择,但是全局不一定是最优的
作为辅助算法

```

二分查找 
```java
# Python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
		    
```
使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方:

```text
1.无序的地方右侧的节点一定小于 arr[0]
2.无序的地方右侧的节点一定大于 arr[0]
3.找到数组的中间元素 mid。
4.如果mid > arr[0]，我们需要在 mid 右边搜索。
5.如果mid < arr[0]，我们需要在 mid 左边搜索。
```


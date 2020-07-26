学习笔记
### Tire 字典树

优点:最大限度的减少无畏的字符串比较,查询效率比哈希值高

基本性质:

```mark
1.结点本身不存在完整单词
2.从根节点到某一个结点,路径上经过的字符串连接起来,为该结点对应的字符串;
3.每个结点的所有子节点路径代表的字符都不相同;
```



- ### [Tire 树代码模板](https://shimo.im/docs/DP53Y6rOwN8MTCQH)

  ```java
  //Java
  class Trie {
      private boolean isEnd;
      private Trie[] next;
      /** Initialize your data structure here. */
      public Trie() {
          isEnd = false;
          next = new Trie[26];
      }
      
      /** Inserts a word into the trie. */
      public void insert(String word) {
          if (word == null || word.length() == 0) return;
          Trie curr = this;
          char[] words = word.toCharArray();
          for (int i = 0;i < words.length;i++) {
              int n = words[i] - 'a';
              if (curr.next[n] == null) curr.next[n] = new Trie();
              curr = curr.next[n];
          }
          curr.isEnd = true;
      }
      
      /** Returns if the word is in the trie. */
      public boolean search(String word) {
          Trie node = searchPrefix(word);
          return node != null && node.isEnd;
      }
      
      /** Returns if there is any word in the trie that starts with the given prefix. */
      public boolean startsWith(String prefix) {
          Trie node = searchPrefix(prefix);
          return node != null;
      }
  
      private Trie searchPrefix(String word) {
          Trie node = this;
          char[] words = word.toCharArray();
          for (int i = 0;i < words.length;i++) {
              node = node.next[words[i] - 'a'];
              if (node == null) return null;
          }
          return node;
      }
  }
  ```

  

### 并查集

```java
// Java 代码模板
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```



### avl

```mark
平衡因子:左子树减去右子树的高度  {-1,0,1}
旋转:左旋
		右旋
		左右旋
		右左旋
总结:
1.平衡的二叉搜索树
2.每个节点存 balance factor = {-1,0,1}
3.四种旋转操作
不足:结点需要存额外的信息,且调动次数频繁		  
		 
```

### 红黑树 (近似平衡二叉树)

```markdown
红黑树是一种近似平衡的二叉搜索树(Binary SearchTree) ,它能够确保任何一个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树:
●每个结点要么是红色，要么是黑色
●根结点是黑色
●每个叶结点(NI结点，空结点)是黑色的。
●不能有相邻接的两个红色结点
●从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。
```



对比

```mark
AVLtrees provide taster lookups than Red Black Trees because they are more strictly
balanced.


Red Black Trees provide faster insertion and removal operations than AVLtrees as
fewer rotations are done due to relatively relaxed balancing.

AVL trees store balance factors or heights with each node, thus requires storage for
an intec
eger per node whereas Red Black Tree requires only 1 bit of infomation pernode.


Red Black Trees are usedin most of the language libraries
like map, multimap, multisetin C++ whereas AVL trees are used in databases where
faster retrievals are required.

```

















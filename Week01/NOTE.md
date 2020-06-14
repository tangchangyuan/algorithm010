**第一周学习笔记**

**数组:**
```text
1.连续开辟内存空间
2.带索引 从0开始 随机访问
3.修改,删除 时间复杂度 为 O(n)
```

**链表：**
```text
1.真正的动态数据结构 最简单的动态数据结构
2.更深入的理解引用
3.更深入理解递归 ，天生具有递归性质
4.辅助组成其他数据结构
数据存储在节点（node）中


优点：真正的动态，不需要处理固定容量的问题。 在内存不是连续的。
缺点：丧失了随机访问的能力，（不能用索引直接访问数据）

class Node {
    E e;   
    Node next;  //是存储的当前节点的下一个节点
    }
```
**跳表：**
```text
1.一维-->二维
2.查找和添加的时间复杂度都是O(logn)
```

**需要熟练的代码1:**
```text
//遍历左右边界且左右遍历不能重复,实现i,j对数组的遍历,同时保证i,j不重复
 for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {

            }
        }
  ```      
   
**需要熟练的代码2:**
```text     
//双指针左右边界
int i = 0;
int j = arr.length - 1;
for (i, j; i < j) {
    int minHeight = arr[j] < arr[i] ? arr[j] : arr[i];
    j--;
    i++;
    int width = j - i + 1;
    max = Math.max(max, width * minHeight);
}
```

**解法问题:**

```text
1.列出最基础的情况(像以前数学题代入特殊值).
2.找最近,重复的子问题,也是递归,回溯,分治的解题方式. 
```

**栈(Stack):**
```text
1.先入后出的一个容器
2.添加删除元素的时间复杂度都是O(1),查询操作是O(n)
3.无序的



```
[Java 的 Stack 源码](链接网址 "http://developer.classpath.org/doc/java/util/Stack-source.html")



**队列(Queue):**
```text
1.先入先出的一个容器
2.添加删除元素的时间复杂度都是O(1),查询操作是O(n)
3.无序的
4.在java中是一个接口



         throws exception       Returns special value   
Insert   add(e)                 offer(e)
Remove   remove()               poll()
Examine  element()              peek()

```
[Java 的 Queue 源码](链接网址 "http://fuseyism.com/classpath/doc/java/util/Queue-source.html")

**双端队列(Deque):**
```text
1.是栈和队列的结合体
2.两端都可以 Push Pop
3.插入和删除都是O(1),查询是O(n)
4.java 中如果要使用stack这种数据结构的话,推荐使用 Deque
5.peek 显示栈顶的元素 pop弹出栈顶的元素 push 向栈里面添加元素 ...

```

**如何动手自己去查源码:**

```text
1.google : stack java 1.8 
2. ...

```

**优先队列(Priority Queue)**

```text
1.插入操作: O(1)
2.取出操作:O(logn) 按照元素的优先级取出
3.底层具体实现的数据结构较为复杂和多样:heap(堆也是多种数据结构实现的) 、BST
4.添加的时候必须实现 Comparator 的比较接口 (定于优先级)

```
[Java 的 PriorityQueue 文档](链接网址 "http://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html")

**queue 源代码分析:**

```text
1.继承了Collection接口(List、Set也继承了)
2.FIFO
3.通常用在生产者消费者模式中。(Rabbit MQ)
4.
```
|  方法类型   | 方法名称  | 方法名称| 区别  |
|  ----  | ----| ----| ----  |
| Insert  | add| offer| 两个方法都表示向Queue中添加某个元素，不同之处在于添加失败的情况，add只会返回true，如果添加失败，会抛出异常。offer在添加失败的时候会返回false。所以对那些有固定长度的Queue，优先使用offer方法。 |
| Remove  | remove| poll| 如果Queue是空的情况下，remove会抛出异常，而poll会返回null。|
| Examine  | element| peek| 获取Queue头部的元素，但不从Queue中删除。两者的区别还是在于Queue为空的情况下，element会抛出异常，而peek返回null。 |

[一文弄懂java中的Queue家族](链接网址 "https://blog.csdn.net/superfjj/article/details/105927079")



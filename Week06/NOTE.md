### 递归代码模板

```java
public void recur(int level, int param) {
  //terminator  递归终止条件
  if(level > MAX_LEVEL) {
    // process result
    return;
  }
  
  //process current logic  处理当前层的逻辑
  process(level,param);
  
  //drill down  下探到下一层
  recur(level+1,newParam);
  
 //restore current status 恢复当前层状态
}
```

### 分治代码模板

![image-20200719100134501](/Users/tcy/Library/Application Support/typora-user-images/image-20200719100134501.png)

```pyth
# Python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 

  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```

### 递归的方法

```mark
1.人肉递归低效,很累
2.找到最近最简方法,将其拆解为可重复解决的问题
3.数学归纳法思维
```

### 动态规划(DP)是什么

```mark
分治+最优子结构

和分治的区别: 不需要保存每一步的状态  每一步都是最优的状态 不用把次优的状态保存

1.动态规划和递归或者分治没有根本上的区别 (关键看有无最优子结构) 没有的就是分治(把所有的子问题合并)
2.共性: 找到重复子问题
3.差异性: 最优子结构,中途可以淘汰次优解

ps: 淘汰了次优解=降低时间复杂度 
		不淘汰=傻递归 (斐波拉契傻递归)
```

![image-20200719101025400](/Users/tcy/Library/Application Support/typora-user-images/image-20200719101025400.png)



### fib傻递归最简代码

```java
int fib(int n) {
  return n <= 1 ? n : fib(n-1) + fib(n-2);
}
```

### 缓存后的fib O(2^n)->O(n)

![image-20200719104045553](/Users/tcy/Library/Application Support/typora-user-images/image-20200719104045553.png)

### 自底向上

![image-20200719104258767](/Users/tcy/Library/Application Support/typora-user-images/image-20200719104258767.png)


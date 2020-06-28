学习笔记

**递归(Recursion)**

```text
1.不要人肉进行递归(脑袋很容易瓦特)
2.找到最近最简重复子问题
    比如数组求和: 1.sum(arr[0...n-1]) = arr[0] + sum(arr[1...n-1]);
                2.sum(arr[1...n-1]) = arr[1] + sum(arr[2...n-1]);
                            ... // 子问题不短缩小.
                3.sum(arr[n-1...n-1]) = arr[n-1] + sum([]) //sum[] 空数组求和相当于是递归终止条件,return到上一个问题,直到第一个问题            
                 
3.数学归纳法的思想 

```

**回溯**

```java
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


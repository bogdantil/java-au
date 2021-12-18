# Design
+ [Min Stack](#min-stack)
+ [Implement Stack using Queues](#implement-stack-using-queues)
+ [Implement Queue using Stacks](#implement-queue-using-stacks)

## Min Stack

https://leetcode.com/problems/min-stack/

<details><summary>Test Cases</summary><blockquote>

``` java
package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void top() {
        var testminstack = minStackList(List.of(1, 4, 7));
        var n = 7;
        assertEquals(testminstack.top(), n);
    }
    @Test
    void Pop() {
        var testList = new ArrayList<Integer>();
        testList.addAll(List.of(1, 2, 3, 4, 5));
        var actualStack = minStackList(testList);
        Collections.reverse(testList);
        for (var expectedVal: testList) {
            actualStack.pop();
        }
    }
    @Test
    void getMin() {
        var testminstack = minStackList(List.of(1, 4, 7));
        var n = 1;
        assertEquals(testminstack.getMin(), n);
    }



    private MinStack minStackList(List<Integer> lst){
        var stack = new MinStack();
        for (var val: lst) {
            stack.push(val);
        }
        return stack;
    }

}
```

</blockquote></details>

```java
class MinStack {
    ArrayList<Integer> minimumElement;
    ArrayList<Integer> stackArray;
    public MinStack() {
        stackArray = new ArrayList<Integer>();
        minimumElement = new ArrayList<Integer>();
        minimumElement.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stackArray.add(val);
        if(val<=minimumElement.get(minimumElement.size()-1)){
            minimumElement.add(val);
        }
    }

    public void pop() {
        int elementBeingRemoved = stackArray.get(stackArray.size()-1);

        if(elementBeingRemoved == minimumElement.get(minimumElement.size()-1)) {
            minimumElement.remove(minimumElement.size()-1);
        }

        stackArray.remove(stackArray.size()-1);
    }

    public int top() {
        return stackArray.get(stackArray.size()-1);
    }

    public int getMin() {
        return minimumElement.get(minimumElement.size()-1);
    }
}
```
## Implement Stack using Queues

https://leetcode.com/problems/implement-stack-using-queues/

<details><summary>Test Cases</summary><blockquote>

``` java
package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void top() {
        var testminstack = minStackList(List.of(1, 4, 7));
        var n = 7;
        assertEquals(testminstack.top(), n);
    }
    @Test
    void pop() {
        var testminstack = minStackList(List.of(1, 4, 7));
        var n = 7;
        assertEquals(testminstack.pop(), n);
    }

    @Test
    void push() {
        var testminstack = minStackList(List.of(1, 4, 7));
        var expected = minStackList(List.of(1, 4, 7, 8));
        testminstack.push(8);
        assertEquals(testminstack, expected);
    }
    @Test
    void empty() {
        var testminstack = minStackList(List.of(1, 4, 7));
        boolean n = false;
        assertEquals(testminstack.empty(), n);
    }

    private MyStack minStackList(List<Integer> lst){
        var stack = new MyStack();
        for (var val: lst) {
            stack.push(val);
        }
        return stack;
    }

}
```

</blockquote></details>

```java
class MyStack {
    Queue q1 = null;
    Queue q2 = null;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyStack)) return false;
        MyStack myStack = (MyStack) o;
        return Objects.equals(q1, myStack.q1) && Objects.equals(q2, myStack.q2);
    }


    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    public int pop() {
        return (Integer)q1.poll();
    }

    public int top() {
        return (Integer)q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
```
## Implement Queue using Stacks

https://leetcode.com/problems/implement-queue-using-stacks/

<details><summary>Test Cases</summary><blockquote>

``` java
package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void pop() {
        var testminstack = minStackList(List.of(1, 4, 7));
        var n = 1;
        assertEquals(testminstack.pop(), n);
    }

    @Test
    void push() {
        var testminstack = minStackList(List.of(1, 4, 7));
        var expected = minStackList(List.of(1, 4, 7, 8));
        testminstack.push(8);
        assertEquals(testminstack, expected);
    }
    @Test
    void empty() {
        var testminstack = minStackList(List.of(1, 4, 7));
        boolean n = false;
        assertEquals(testminstack.empty(), n);
    }

    private MyQueue minStackList(List<Integer> lst){
        var stack = new MyQueue();
        for (var val: lst) {
            stack.push(val);
        }
        return stack;
    }

}
```

</blockquote></details>

```java
class MyQueue {

    private Stack<Integer> s = new Stack();
    private Stack<Integer> t = new Stack();

    public MyQueue()
    {

    }

    public void push(int x)
    {
        while(!s.isEmpty())t.push(s.pop());
        s.push(x);
        while(!t.isEmpty())s.push(t.pop());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyQueue)) return false;
        MyQueue myQueue = (MyQueue) o;
        return Objects.equals(s, myQueue.s) && Objects.equals(t, myQueue.t);
    }


    public int pop()
    {
        return s.pop();
    }

    public int peek()
    {
        return s.peek();
    }

    public boolean empty()
    {
        return s.isEmpty();
    }
}

```


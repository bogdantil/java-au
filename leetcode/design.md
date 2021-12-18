# Design
+ [Min Stack](#min-stack)

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

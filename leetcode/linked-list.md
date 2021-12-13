# Linked list

+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Reverse Linked List](#reverse-linked-list)

## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void middleNode() {
        var testLinkedList = generateLinkedList(List.of(1,228,322,1488));
        var expected = generateLinkedList(List.of(322,1488));
        var actual = new Solution().middleNode(testLinkedList);
        assertEquals(expected,actual);
    }

    private ListNode generateLinkedList(List<Integer> lst){
        var head = new ListNode();
        var cur = head;
        for(int val: lst){
            ListNode next = new ListNode();
            next.val = val;
            cur.next = next;
            cur = cur.next;
        }
        return head.next;
    }
}
```

``` java
import java.util.Objects;

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      @Override
      public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
      }

      @Override
      public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
      }

}
```

</blockquote></details>

```java
 public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

}
```
## Reverse Linked List

https://leetcode.com/problems/reverse-linked-list/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void reverseList() {
        ListNode expected = generateLinkedList(List.of(5, 4, 3, 2, 1));
        var listToTest = generateLinkedList(List.of(1, 2, 3, 4, 5));
        var actual = new Solution().reverseList(listToTest);
        assertEquals(expected, actual);
    }
    private ListNode generateLinkedList(List<Integer> lst){
        var head = new ListNode();
        var cur = head;
        for(int val: lst){
            ListNode next = new ListNode();
            next.val = val;
            cur.next = next;
            cur = cur.next;
        }
        return head.next;
    }

}
```

``` java
import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode)) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

```

</blockquote></details>

```java
public class Solution {
    public ListNode reverseList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }
}
```

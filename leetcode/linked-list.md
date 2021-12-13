# Linked list

+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Reverse Linked List](#reverse-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Sort List](#sort-list)
+ 

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
## Palindrome Linked List 

https://leetcode.com/problems/palindrome-linked-list/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void isPalindrome() {
        var expected = true;
        var listToTest = generateLinkedList(List.of(1, 2, 3, 4, 3, 2, 1));
        var actual = new Solution().isPalindrome(listToTest);
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
    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();


        ListNode currentNode = head;
        while (currentNode != null) {
            arr.add(currentNode.val);
            currentNode = currentNode.next;
        }
        int i = 0;
        int j = arr.size() - 1;
        while (i < j) {
            if (!arr.get(i).equals(arr.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
```
## Sort List

https://leetcode.com/problems/middle-of-the-linked-list/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void merge() {
        ListNode expected = generateLinkedList(List.of(1, 2, 3, 4, 5, 6, 7 ,8));
        var listToTest1 = generateLinkedList(List.of(1, 3, 5, 7));
        var listToTest2 = generateLinkedList(List.of(2, 4, 6, 8));
        var actual = new Solution().merge(listToTest1, listToTest2);
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

}

```

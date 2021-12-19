# Stream

+ [Top K Frequent Words](#top-k-frequent-words)

## Top K Frequent Words

https://leetcode.com/problems/top-k-frequent-words/

<details><summary>Test Cases</summary><blockquote>

``` java
package com.company;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;


    @Test
    void testTopKFrequent() {
        solution = new Solution();
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        List<String> expected = List.of("i","love");
        assertEquals(expected, solution.topKFrequent(words, 2));
    }
}
```

</blockquote></details>

```java
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        return Stream.of(words)
                .sorted()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(enumerate -> enumerate.getKey())
                .limit(k)
                .collect(Collectors.toList());
    }
}
```
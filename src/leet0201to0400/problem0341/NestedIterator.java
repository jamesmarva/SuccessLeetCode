package leet0201to0400.problem0341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author James
 * @date 2019-11-12 15:33
 **/
public class NestedIterator implements Iterator<Integer> {


    List<Integer> list;
    private int cursor = 0;
    private int size = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = dfs(nestedList);
        size = list.size();
    }

    @Override
    public Integer next() {
        Integer ans = list.get(cursor);
        cursor++;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return size != cursor;
    }

    public List<Integer> dfs(List<NestedInteger> nestedInteger) {
        List<Integer> list = new LinkedList<>();
        for (NestedInteger item : nestedInteger) {
            if (item.isInteger()) {
                list.add(item.getInteger());
            } else {
                list.addAll(dfs(item.getList()));
            }
        }
        return list;
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
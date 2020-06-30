package sward;

import java.util.ArrayDeque;
import java.util.Deque;
public class Problem_009 {


    private Deque<Integer> in = null;
    private Deque<Integer> out = null;

    public Problem_009() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }
    
    public void appendTail(int value) { 
        in.offerLast(value);
    }
    
    public int deleteHead() {
        if (out.isEmpty()) {
            if (in.isEmpty()) {
                return -1;
            }
            while (in.size() > 0) {
                out.offerLast(in.pollLast());
            }
        }
        return out.pollLast();
    }
    
}
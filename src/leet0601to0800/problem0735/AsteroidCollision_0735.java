package leet0601to0800.problem0735;

import java.util.Stack;

/**
 * @author James
 * @date 2019-12-01 15:41
 **/
public class AsteroidCollision_0735 {


    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, len = asteroids.length; i < len; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
                continue;
            }
//            else if (stack.peek() < 0) {
//                stack.push(asteroids[i]);
//            } else if (Math.abs(asteroids[i]) == stack.peek()) {
//                stack.pop();
//            } else if (Math.abs(asteroids[i]) > stack.peek()) {
//                while (stack.size() > 0 && Math.abs(asteroids[i]) > stack.peek() && stack.peek() > 0) {
//                    stack.pop();
//                }
//                if (stack.isEmpty() || stack.peek() < 0) {
//                    stack.push(asteroids[i]);
//                }
//            } else if (stack.peek() == Math.abs(asteroids[i])) {
//
//            }
            int temp = asteroids[i];
            while (true) {
                if (stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (Math.abs(temp) == stack.peek()) {
                    stack.pop();
                    break;
                } else if (Math.abs(temp) > stack.peek()) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(temp);
                        break;
                    }
                } else if (Math.abs(temp) < stack.peek()){
                    break;
                }
            }
        }
        int[] ans = new int[stack.size()];
        for (int i =  stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }


}

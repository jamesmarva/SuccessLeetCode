package leet1201to1400.problem1361;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Brilliant James
 * @date 2020-03-22 10:33
 **/
public class ValidateBinaryTreeNodes_1361 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, Integer> childAndFather = new HashMap<>();
        int len = leftChild.length;
        for (int i = 0; i < len; i++) {
            if (leftChild[i] == -1) {
                continue;
            }
            if (childAndFather.get(leftChild[i]) == null) {
                childAndFather.put(leftChild[i], i);
            } else {
                return false;
            }
        }
        for (int i = 0; i < len; i++) {
            if (rightChild[i] == -1) {
                continue;
            }            if (childAndFather.get(rightChild[i]) == null) {
                childAndFather.put(rightChild[i], i);
            } else {
                return false;
            }
        }
        int count = 0;
        // 作为父亲，只有一个父节点没有父节点，其他的父亲节点只有一个一个父亲节点
        for (int i = 0; i < n; i++) {
            Integer val = childAndFather.get(i);
            if (val == null && count == 0) {
                count++;
            } else if (val == null) {
                return false;
            }
        }
        return count == 1;
    }


    /**
     * 1 判断是否有环
     * @param n
     * @param leftChild
     * @param rightChild
     * @return
     */
    public boolean validateBinaryTreeNodes_01(int n, int[] leftChild, int[] rightChild) {
        int[] map = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0;i < n; i++) {
            if (leftChild[i] != -1) {
                map[leftChild[i]] ++;
            }
            if (rightChild[i] != -1) {
                map[rightChild[i]]++;
            }
        }
        for (int i = 0;i < n; i++) {
            if (map[i] == 0) {
                queue.offer(i);
                break;
            }
        }
        while (queue.size() > 0) {
            int count = queue.size();
            while (count > 0) {
                Integer temp = queue.poll();
                if (visited.contains(temp)) {
                    return false;
                } else {
                    visited.add(temp);
                }
                if (leftChild[temp] != -1) {
                    queue.offer(leftChild[temp]);
                }
                if (rightChild[temp] != -1) {
                    queue.offer(rightChild[temp]);
                }
                count--;
            }
        }
        for (int i = 0; i < n; i++){
            if (!visited.contains(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 4
     * [1,-1,3,-1]
     * [2,-1,-1,-1]
     * @param args
     */
    public static void main(String[] args) {
        int n = 4;
        int[] arr1 = {1,-1,3,-1};
        int[] arr2 = {2,-1,-1,-1};
        ValidateBinaryTreeNodes_1361 v = new ValidateBinaryTreeNodes_1361();
        System.out.println(v.validateBinaryTreeNodes_01(n, arr1, arr2));
    }
}


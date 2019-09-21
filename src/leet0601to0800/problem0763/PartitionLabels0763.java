package leet0601to0800.problem0763;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @program: SuccessLeetCode
 * @description: https://leetcode-cn.com/problems/partition-labels/
 * @author: James
 * @create: 2019-09-15 13:54
 **/
public class PartitionLabels0763 {

    /**
     * 就是需要一个东西来记录每个字母出现的最后一个字段
     * @param S
     * @return
     */
    public List<Integer> partitionLabelsSolution(String S) {
        int[] letterLastOriginal = new int[26];
        char[] letterArray = S.toCharArray();
        List<Integer> returnList = new LinkedList<>();
        int lengthLetterArray = letterArray.length;
        for (int i = 0; i < lengthLetterArray; i++) {
            int letterIndexIn26 = (int) letterArray[i] - 97;
            letterLastOriginal[letterIndexIn26] = i;
        }

        for (int item : letterLastOriginal){
            System.out.println(item + ", ");
        }
        Set<Character> charSet = new HashSet<>();
        int leftBorder = 0;
        int firstCharInt = (int) letterArray[0] - 97;
        int rightBorder = letterLastOriginal[firstCharInt];
        for (int i = 0; i < lengthLetterArray; i++) {
            if (charSet.contains(letterArray[i])) {
                if (i == rightBorder) {
                    returnList.add(rightBorder - leftBorder + 1);
                    leftBorder = i + 1;
                }
            } else if (charSet.size() == 0) {
                if (i == rightBorder) {
                    returnList.add(rightBorder - leftBorder + 1);
                    leftBorder = i + 1;
                }
                charSet.add(letterArray[i]);
            } else {
                int letterIndexIn26 = (int) letterArray[i] - 97;
                if (rightBorder < letterLastOriginal[letterIndexIn26]) {
                    if (letterLastOriginal[letterIndexIn26] == rightBorder + 1 && i + 1 == lengthLetterArray) {
                        returnList.add(1);
                    }
                    rightBorder = letterLastOriginal[letterIndexIn26];
                }
                charSet.add(letterArray[i]);
            }
        }
        return returnList;
    }


    public List<Integer> newPartitionLabelsSolution(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        int[] letterLastOriginal = new int[26];
        char[] letterArray = S.toCharArray();
        List<Integer> returnList = new LinkedList<>();
        int lengthLetterArray = letterArray.length;
        for (int i = 0; i < lengthLetterArray; i++) {
            letterLastOriginal[(int) letterArray[i] - 97] = i;
        }
        Set<Character> charSet = new HashSet<>();
        int leftBorder = 0;
        int firstCharInt = (int) letterArray[0] - 97;
        int rightBorder = letterLastOriginal[firstCharInt];
        for (int i = 0; i < lengthLetterArray; i++) {
            if (charSet.contains(letterArray[i])) {
                if (i == rightBorder) {
                    returnList.add(rightBorder - leftBorder + 1);
                    leftBorder = i + 1;
                    if (i != lengthLetterArray - 1) {
                        rightBorder = rightBorder = letterLastOriginal[(int) letterArray[i + 1] - 97];
                    }
                    charSet.clear();
                }
            } else if (charSet.size() == 0) {
                if (i == rightBorder) {
                    returnList.add(rightBorder - leftBorder + 1);
                    leftBorder = i + 1;
                    if (i != lengthLetterArray - 1) {
                        rightBorder = rightBorder = letterLastOriginal[(int) letterArray[i + 1] - 97];
                    }
                } else {
                    charSet.add(letterArray[i]);
                }
            } else {
                if (rightBorder < letterLastOriginal[(int) letterArray[i] - 97]) {
                    rightBorder = letterLastOriginal[(int) letterArray[i] - 97];
                }
                charSet.add(letterArray[i]);
            }
        }
        return returnList;
    }


    public static void main(String[] args) {
//        System.out.println((int) 'z');
        PartitionLabels0763 partitionLabels = new PartitionLabels0763();
        System.out.println(partitionLabels.partitionLabelsSolution("vhaagbqkaq"));
//        index = cache[S.charAt(i) - 'a'];
//        for (int j = i + 1; j < index && j < len; j++) {
//            if (cache[S.charAt(j) - 'a'] > index) {
//                index = cache[S.charAt(j) - 'a'];
//            }
//        }
//        res.add(index - i + 1);
//        i = index + 1;
    }
}

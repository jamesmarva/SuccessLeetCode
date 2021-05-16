package gold;

import java.util.ArrayList;

/**
 *
 *  稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 * 示例2:
 *
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author 王涵威
 * @date 21.5.16 21:00
 */
public class Pro_10_05 {

    public int findStr(String[] words, String s) {
        int l = 0;
        int r = words.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (words[m] == "") {
                String tmp = "";
                int le = m;
                while (le >= l && words[le] == "") {
                    le--;
                }
                int ri = m;
                while (ri < r && words[ri] == "") {
                    ri++;
                }
                if (le < l && ri > r) {
                    return -1;
                } else if (le < l) {
                    m = ri;
                } else if (ri > r) {
                    m = le;
                } else if (le >= l && ri <= r){
                    if (s.compareTo(words[le]) > 0 && s.compareTo(words[ri]) > 0) {
                        m = le;
                    } else if (s.compareTo(words[le]) < 0 && )
                }
            }
        }

    }

    public int findString(String[] words, String s) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0, l = words.length; i < l; i ++) {
            if ("".equals(words[i])) {
                continue;
            }
            Pair p = new Pair(i, words[i]);
            list.add(p);
        }

        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (s.compareTo(list.get(mid).val) > 0) {
                l = mid + 1;
            } else if (s.compareTo(list.get(mid).val) < 0) {
                r = mid - 1;
            } else {
                return list.get(mid).idx;
            }
        }
        return -1;
    }

    static class Pair {
        int idx;
        String val;

        Pair(int idx, String val) {
            this.idx = idx;
            this.val = val;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        char c ='…';
//        System.out.println((int) c);
//        System.out.println((int) '`');
//        System.out.println();
//        System.out.println((char) 256);

        // for (int i = 0; i < 256; i++) {
        //     System.out.print("i: " + i + " ");
        //     System.out.println((char) i);
        // }
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        Pro_10_05 p = new Pro_10_05();
        System.out.println(p.binarySearch(a, 5));
    }

    int binarySearch(int[] arr, int tar) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] > tar) {
                r = mid - 1;
            } else if (arr[mid] < tar) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    
}

package mine;

import java.util.*;
/**
 * 求 前 100 个 “拉马努金数字”
拉马努金数字：
一个关于印度数学奇才拉马努金的故事：“哈代有次在伦敦坐出租车去看望拉马努金，下车时注意到车牌号是1729，他或许琢磨了一下这个数字，因为当他走进拉马努金住院的病房时，他都还没打个招呼，脱口而出的是他对这个数字的失望，他说这是一个无聊乏味的数字，并希望这不是什么坏兆头。‘哈代，你错了，’拉马努金说：‘这是一个非常有趣的数字。它是能用两种不同方式表示为两个正立方数之和的最小的数。’”
1^3  + 12^3 = 9^3 +10^3 = 1729

第一个 “拉马努金数字”
1^3  + 12^3 = 1729
9^3 +10^3 = 1729

第二个 “拉马努金数字”
9^3 + 15^3 = 4104
2^3 + 16^3 = 4104

也可以求前100 的拉马努金数字具体的情况，比如 1, 12, 9, 10 这样

前一百的 拉马努金数字
[1729, 4104, 13832, 20683, 32832, 39312, 40033, 46683, 64232, 65728, 110656, 110808, 134379, 149389, 165464, 171288, 195841, 216027, 216125, 262656, 314496, 320264, 327763, 373464, 402597, 439101, 443889, 513000, 513856, 515375, 525824, 558441, 593047, 684019, 704977, 805688, 842751, 885248, 886464, 920673, 955016, 984067, 994688, 1009736, 1016496, 1061424, 1073375, 1075032, 1080891, 1092728, 1195112, 1260441, 1323712, 1331064, 1370304, 1407672, 1533357, 1566728, 1609272, 1728216, 1729000, 1734264, 1774656, 1845649, 2048391, 2101248, 2301299, 2418271, 2515968, 2562112, 2585375, 2622104, 2691451, 2864288, 2987712, 2991816, 3220776, 3242197, 3375001, 3375008, 3511872, 3512808, 3551112, 3587409, 3628233, 3798613, 3813992, 4033503, 4104000, 4110848, 4123000, 4174281, 4206592, 4342914, 4467528, 4505949, 4511808, 4607064, 4624776, 4673088]

可以变成前n个 拉马努金数字
 */
public class RamanujanNum {

    private final static long  MAX_NUM = 1000;

    public static void main(String[] args) {
        System.out.println("asdfasdfasdfasdf");
    }

    public static ArrayList<Long> getRamanujanNum02(int n) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((o1, o2) -> {
            return (int) (o1.getSum() - o2.getSum());
        });
        for (int i = 1; i <= MAX_NUM; i++) {
            minHeap.offer(new Pair(i, i + 1));
        }
        ArrayList<Long> ans = new ArrayList<>(n);
        Set<Long> set = new HashSet<>();
        while (minHeap.size() > 0) {
            Pair temp = minHeap.poll();
            if (!set.add(temp.getSum())) {
                ans.add(temp.getSum());
                if (ans.size() == n) {
                    return ans;
                }
            }
            if (temp.b < MAX_NUM) {
                minHeap.offer(new Pair(temp.a, temp.b + 1));
            }
        }
        return ans;
    }
    private static class Pair {
        long sum;
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
            this.sum = ((long) Math.pow(a, 3)) + ((long) Math.pow(b, 3));
        }
        public long getSum() {
            return this.sum;
        }
    } 
}

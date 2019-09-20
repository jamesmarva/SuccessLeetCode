package leet601to800.problem0695;

import java.util.*;

/**
 * @program: myleetcode
 * @description: https://leetcode-cn.com/problems/max-area-of-island/
 * 695. Max Area of Island
 * 695. 岛屿的最大面积
 * @author: James
 * @create: 2019-05-19 17:55
 **/
public class MaxAreaOfIsland695 {

	Map<String, String> fatherMap = new HashMap<>();
	Map<String, Integer> rankMap = new HashMap<>();
	public int maxAreaOfIsland(int[][] grid) {
		int lenY = grid.length;
		int res = 0;
		if (lenY == 0){
			return res;
		}
		int lenX = grid[0].length;
		HashSet<String> set = new LinkedHashSet<>();
		for (int i = 0; i < lenY; ++i) {
			for (int j = 0; j < lenX; ++j) {
				if (grid[i][j] == 1) {
					String temp  = i + "#" + j;
					fatherMap.put(temp, temp);
					set.add(temp);
					rankMap.put(temp , 1);
				}
			}
		}

		for (String item : set) {
			String tempFather = fatherMap.get(item);
			String[] tempArr = tempFather.split("#");
			int y = Integer.parseInt(tempArr[0]);
			int x = Integer.parseInt(tempArr[1]);
			if (y > 0) {
				String tempPoint = (y - 1) + "#" + x;
				if (set.contains(tempPoint)) {
					union(tempPoint, tempFather);
				}
			}
			if (x > 0) {
				String tempPoint = y + "#" + (x - 1);
				if (set.contains(tempPoint)) {
					union(tempPoint, tempFather);
				}
			}
		}
		for (String item : rankMap.keySet()) {
			if (res < rankMap.get(item)) {
				res = rankMap.get(item);
			}
		}
		return res;
	}

	public String findHead(String node) {
		Stack<String> path = new Stack<>();
		while (!node.equals(fatherMap.get(node))) {
			path.push(node);
			node = fatherMap.get(node);
		}
		while (!path.isEmpty()) {
			fatherMap.put(path.pop(), node);
		}
		return node;
	}

	public void union(String node1, String node2) {
		String father1 = findHead(node1);
		String father2 = findHead(node2);
		if  (!father1.equals(father2)) {
			String big = father1;
			if (rankMap.get(father1) < rankMap.get(father2)) {
				big = father2;
			}

			String small = father2;
			if (big.equals(father2)) {
				small = father1;
			}
			fatherMap.put(small, big);
			rankMap.put(big, rankMap.get(big) + rankMap.get(small));
			rankMap.remove(small);
		}
	}
}

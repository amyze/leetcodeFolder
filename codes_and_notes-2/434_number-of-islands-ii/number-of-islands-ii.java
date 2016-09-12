/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/number-of-islands-ii
@Language: Java
@Datetime: 16-09-05 04:52
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    class UnionFind {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		public UnionFind(int length) {
			for (int i = 0; i < length; i++) {
				map.put(i,i);
			}
		}
		public int find(int target) {
			int parent = map.get(target);
			while (parent != map.get(parent)) {
				parent = map.get(parent);
			}
			return parent;
		}

		public void union(int x, int y) {
			int findX = find(x);
			int findY = find(y);
			if (findX != findY) {
				map.put(findX, findY);
			}
		}
	}
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> rst = new ArrayList<Integer>();
    	if (operators == null || operators.length == 0) {
    		return rst;
    	}
    	int count = 0;
    	int[] island = new int[m*n];
    	UnionFind uf = new UnionFind(m*n);
    	int[] xs = {-1, 1,  0, 0};
    	int[] ys = {0,  0, -1, 1};
    	for (int i = 0; i < operators.length; i++) {
    		int x = operators[i].x;
    		int y = operators[i].y;
    		int pos = x * m + y;
    		count++;
    		if (island[pos] != 1) {
    			island[pos] = 1;
	    		for (int j = 0; j < 4; j++) {
	    			int nx = x + xs[j];
	    			int ny = y + ys[j];
	    			int newPos = nx * m + ny;
	    			if (nx >= 0 && nx < n && ny >= 0 && ny < m && island[newPos] == 1) {//when new position is land
	    				int findA = uf.find(pos);
	    				int findB = uf.find(newPos);
	    				if (findA != findB) {
	    					count--;
	    					uf.union(pos, newPos);
	    				}
	    			}
	    		}
    		}
    		rst.add(count);
    	}

    	return rst;
    }
}
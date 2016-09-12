/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/find-the-weak-connected-component-in-the-directed-graph
@Language: Java
@Datetime: 16-09-03 20:45
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        // corner case
        if (nodes == null || nodes.size() == 0) {
    		return rst;
    	}
        HashSet<Integer> set = new HashSet<>();
        
        // add all nodes to hashset
        for (DirectedGraphNode node: nodes){
            // 因为是有向图，所以应该加顶点，否则会miss掉source的点
            set.add(node.label);
            for(DirectedGraphNode nei: node.neighbors){
                set.add(nei.label);
            }
        }
        // create uf with hashset
        UnionFind uf= new UnionFind(set);
        // for each edge, use union
        for (DirectedGraphNode node: nodes){
            for(DirectedGraphNode nei: node.neighbors){
                uf.union(node.label, nei.label);
            }
        }
        return generateRst(rst,uf, set);
    }
    public List<List<Integer>> generateRst (List<List<Integer>> rst, UnionFind uf, HashSet<Integer> set) {
       	
    	HashMap<Integer, List<Integer>> listMap = new HashMap<Integer, List<Integer>>();
    	for (int num : set) {
    		int rootParent = uf.compressed_find(num);
    		if (!listMap.containsKey(rootParent)) {
    			listMap.put(rootParent, new ArrayList<Integer>());
    		} 
    		//Add num into its correct set (meaning its root ancestor)
    		listMap.get(rootParent).add(num);
    	}

    	for (List<Integer> list: listMap.values()) {
    		Collections.sort(list);
    		rst.add(list);
    	}
    	return rst;
    }
    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        // constructor
        UnionFind(HashSet<Integer> hashSet){
            for(Integer now : hashSet) {
                father.put(now, now);
            }
        }
        // find
        int compressed_find(int x){
            int parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            int next = -1;
            
            while(x!=father.get(x)) {
                next = father.get(x);
                father.put(x, parent) ;
                x=next;
            }
            return parent;
                
        }
        // union
        void union(int x, int y){
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if(fa_x != fa_y)
                father.put(fa_x, fa_y);
        }
    }
}

//https://github.com/shawnfan/LintCode/blob/master/Java/Find%20the%20Weak%20Connected%20Component%20in%20the%20Directed%20Graph.java
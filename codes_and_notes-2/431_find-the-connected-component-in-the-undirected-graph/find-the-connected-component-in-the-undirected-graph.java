/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/find-the-connected-component-in-the-undirected-graph
@Language: Java
@Datetime: 16-09-03 18:59
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        for(UndirectedGraphNode node : nodes){
            if(!visited.contains(node)){
                dfs(node, visited, path);
                Collections.sort(path);
                result.add(new ArrayList<Integer>(path));
                path.clear();
            }
        }
        return result;

    }
    public void dfs(UndirectedGraphNode node, Set<UndirectedGraphNode> visited, List<Integer> path){
        visited.add(node);
        path.add(node.label);
        for(UndirectedGraphNode n : node.neighbors){
            if(!visited.contains(n)){
                dfs(n, visited, path);
            }
        }
    }
}
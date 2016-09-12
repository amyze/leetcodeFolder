/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Java
@Datetime: 16-06-22 01:25
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
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
       ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
       HashMap<DirectedGraphNode,Integer> map = new HashMap<>();
       // store neighbors in map
       for(DirectedGraphNode node:graph){
           for(DirectedGraphNode each: node.neighbors){
                if (map.containsKey(each)){
                    map.put(each, map.get(each)+1);
                }else{
                    map.put(each,1);
                }
           }
       }
       Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
       // find first node whose indegree is 0
       for (DirectedGraphNode num: graph) {
           if(!map.containsKey(num)){
               queue.offer(num);
               result.add(num);
           }
       }
       // bfs the graph
       while(!queue.isEmpty()) {
           DirectedGraphNode last = queue.poll();
           for(DirectedGraphNode nei: last.neighbors){
               map.put(nei, map.get(nei)-1);
               if (map.get(nei)== 0 ) {
                 queue.offer(nei);
                 result.add(nei); 
               }
           }
       }
       return result;
    }
}
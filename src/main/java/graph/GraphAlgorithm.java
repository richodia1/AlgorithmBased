package graph;

import java.util.*;

public class GraphAlgorithm {
    static class Node{
        int val = 0;
        List<Node> neighbours;
        Node(int val){
            this.val = val;
            this.neighbours = new ArrayList<>();
        }
        void addEdge(Node to){
            neighbours.add(to);
        }
    }
    public static void bfs(Node startNode){  // breadth first search approach
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(startNode);
        visited.add(startNode.val);
        while (!queue.isEmpty()){
            Node currentNode = queue.remove();
            System.out.println(currentNode.val);
             for(Node n : currentNode.neighbours){
                 if(!visited.contains(n.val)){
                     queue.add(n);
                     visited.add(n.val);
                 }
             }
        }
    }
    public static void dfs(Node startNode){ // depth first search approach
        Stack<Node> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(startNode);
        while (!stack.isEmpty()){
            Node currentNode = stack.pop();
            if(!visited.contains(currentNode.val)){
                System.out.println(currentNode.val);
                visited.add(currentNode.val);
            }
            for(Node n : currentNode.neighbours){
                if(!visited.contains(n.val)){
                    stack.push(n);
                }
            }
        }
    }
public static void dfsRecursive(Node startNode,Set<Integer> visited){
        System.out.println(startNode.val);
        visited.add(startNode.val);
        for(Node n : startNode.neighbours){
            if(!visited.contains(n.val)){
                dfsRecursive(n,visited);
            }
        }
}
public static void main(String[] args){
        // construct the graph
    Node n0 = new Node(0);
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    n0.addEdge(n1);
    n1.addEdge(n0);
    n1.addEdge(n3);
    n1.addEdge(n2);
    n2.addEdge(n1);
    n2.addEdge(n4);
    n3.addEdge(n1);
    n3.addEdge(n4);
    n3.addEdge(n5);
    n4.addEdge(n2);
    n4.addEdge(n3);
    n5.addEdge(n3);
    System.out.println("Bfs approach..............");
    bfs(n0);
    System.out.println("Dfs approach..............");
    dfs(n0);
    System.out.println("dfs recursive approach..............");
    dfsRecursive(n0,new HashSet<Integer>());
}
}

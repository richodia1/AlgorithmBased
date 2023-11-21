package Google;

import java.util.*;
/*
Given a number of tasks, determine if they can all be scheduled
Problem statement: There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can
have some prerequisite tasks which need to be completed before it can be
scheduled. Given the number of tasks and a list of prerequisite pairs, find out
if it is possible to schedule all the tasks.
 */
public class TaskScheduler {

    public static boolean canFinish(int numTasks, int[][] prerequisites) {
        // Build the adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            graph.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
        }

        // Array to keep track of the visited nodes
        int[] visited = new int[numTasks];

        // Check for a cycle in each node
        for (int i = 0; i < numTasks; i++) {
            if (visited[i] == 0 && hasCycle(graph, visited, i)) {
                return false; // Cycle detected, not possible to schedule tasks
            }
        }

        return true; // No cycle detected, possible to schedule tasks
    }

    private static boolean hasCycle(Map<Integer, List<Integer>> graph, int[] visited, int node) {
        if (visited[node] == 1) {
            return true; // Cycle detected
        }

        if (visited[node] == 2) {
            return false; // Node has been processed
        }

        visited[node] = 1; // Mark the node as being visited

        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (hasCycle(graph, visited, neighbor)) {
                    return true; // Cycle detected in the neighbor
                }
            }
        }

        visited[node] = 2; // Mark the node as processed
        return false;
    }

    public static void main(String[] args) {
        int numTasks = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};

        boolean result = canFinish(numTasks, prerequisites);
        System.out.println("Can all tasks be scheduled? " + result);
    }
}


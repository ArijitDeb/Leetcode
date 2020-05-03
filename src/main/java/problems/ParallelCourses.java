package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/parallel-courses/submissions/
 * https://algs4.cs.princeton.edu/42digraph/TopologicalX.java.html
 *
 * 1136. Parallel Courses
 * <p>Hard
 *
 * There are N courses, labelled from 1 to N.
 *
 * We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: course X has to be studied before course Y.
 *
 * In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.
 *
 * Return the minimum number of semesters needed to study all courses.  If there is no way to study all the courses, return -1.
 */
public class ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n + 1];

        List<Integer>[] adj = new List[n + 1];
        for (int i = 1; i <= n; ++i) {
            adj[i] = new LinkedList<>();
        }

        for (int[] relation : relations) {
            int u = relation[0];
            int v = relation[1];

            adj[u].add(v);
            indegree[v]++;
        }

        int count = 0, result = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        if (queue.isEmpty()) {
            return -1;
        }
        queue.add(-1);

        while (queue.size() > 1) {
            int top = queue.remove();

            if (top == -1) {
                result++;
                queue.add(-1);
                continue;
            } else {
                count++;
            }

            for (int adjN : adj[top]) {
                if (--indegree[adjN] == 0) {
                    queue.add(adjN);
                }
            }
        }
        if (count != n) {
            return -1;
        }

        return result + 1;
    }
}

package Google;

public class Questions {
    public static void main(String[] args) {
        int h = 3;
        int w = 5;
        String[] queries = {"v 1 2", "x 2 2", "v 1 2", "> 2 1", "x 2 3", "> 2 1", "< 2 0"};

        int[][] result = solution(h, w, queries);

        for (int[] ans : result) {
            System.out.println(ans[0] + " " + ans[1]);
        }
    }

    static int[][] solution(int h, int w, String[] queries) {
        int[][] result = new int[queries.length - 1][2];
        boolean[] blackCells = new boolean[h * w];

        for (int i = 0; i < queries.length; i++) {
            String[] parts = queries[i].split(" ");
            char direction = parts[0].charAt(0);
            int a = Integer.parseInt(parts[1]);
            int b = Integer.parseInt(parts[2]);

            if (direction == 'x') {
                blackCells[a * w + b] = true; // Mark the cell as black
            } else {
                int[] queryResult = processQuery(blackCells, h, w, direction, a, b);
                result[i - 1] = queryResult;
            }
        }

        return result;
    }

    static int[] processQuery(boolean[] blackCells, int h, int w, char direction, int a, int b) {
        int[] result = {-1, -1};

        while (true) {
            if (direction == 'v') {
                if (a + 1 < h) {
                    a++;
                } else {
                    break;
                }
            } else if (direction == '^') {
                if (a - 1 >= 0) {
                    a--;
                } else {
                    break;
                }
            } else if (direction == '>') {
                if (b + 1 < w) {
                    b++;
                } else {
                    break;
                }
            } else if (direction == '<') {
                if (b - 1 >= 0) {
                    b--;
                } else {
                    break;
                }
            }

            if (blackCells[a * w + b]) {
                result[0] = a;
                result[1] = b;
                break;
            }
        }

        return result;
    }
}

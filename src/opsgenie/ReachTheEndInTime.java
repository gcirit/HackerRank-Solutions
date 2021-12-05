package opsgenie;

import java.util.*;

public class ReachTheEndInTime {
    public static String reachTheEnd(String[] grid, int maxTime){
        /*
        give a number for all the cells in the grid starting from 0 for (0,0)
        when you want ot reach any cell by number implement division algorithm wrt colCount as divisor
        e.g. 11 = 2 (4)+ 3 means (2,3) for 4 columns grid. there is no need to use an additional class for pairs.
        so the target cell that must be reached is (cRow-1)(cCol-1)
        */
        int nodeNumber = 0;
        Map<Integer, List> graph = new HashMap<>();
        int cRow = grid.length;
        int cCol = grid[0].length();

        //construct the connected cells (contains '.'), a graph with adjacency list
        for (int i = 0; i < cRow; i++) {
            for (int j = 0; j < cCol; j++) {
                if (grid[i].charAt(j)=='.'){
                    List<Integer> siblings = new ArrayList<>();
                    if(j<cCol-1 && grid[i].charAt(j+1)=='.')
                        siblings.add(nodeNumber+1);
                    if(i<cRow-1 && grid[i+1].charAt(j)=='.')
                        siblings.add(nodeNumber+cCol);
                    graph.put(nodeNumber,siblings);
                }
                nodeNumber++;
            }
        }

        int reachTime = 0;
        int targetCellNo = cCol*cRow-1;

        //implement the dfs algorithm
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        boolean [][]visited = new boolean[cRow][cCol];

        while (!stack.isEmpty()){
            Integer currentNode = stack.pop();
            System.out.println("currentNode: " + currentNode);
            if(currentNode == targetCellNo && reachTime <= maxTime){
                return "Yes";
            }

            reachTime++;
            int rowCurrent = currentNode/cCol;
            int colCurrent = currentNode%cCol;
            if (!visited[rowCurrent][colCurrent]){
                visited[rowCurrent][colCurrent]=true;
                graph.get(currentNode).forEach(item -> stack.push((Integer) item));
            }
        }

        return "No";
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String arr[] = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        int time = sc.nextInt();

        System.out.println(reachTheEnd(arr, time));
    }
}

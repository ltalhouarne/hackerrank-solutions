import java.util.Scanner;

public class ConnectedCellInAGrid {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];

        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        int maxCount = 0;

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                maxCount = Math.max(maxCount, countNeighbor(grid, r, c));
            }
        }

        System.out.println(maxCount);
    }

    public static int countNeighbor(int[][] grid, int r, int c) {
        int count = 0;
        if(r < 0 || c >= grid[0].length || r >= grid.length || c < 0) return count;
        if(grid[r][c] == 1) {
            grid[r][c]--;
            count++;
        } else {
            return 0;
        }

        count += countNeighbor(grid, r - 1, c - 1);
        count += countNeighbor(grid, r - 1, c);
        count += countNeighbor(grid, r - 1, c + 1);
        count += countNeighbor(grid, r, c - 1);
        count += countNeighbor(grid, r, c + 1);
        count += countNeighbor(grid, r + 1, c - 1);
        count += countNeighbor(grid, r + 1, c);
        count += countNeighbor(grid, r + 1, c + 1);

        return count;
    }
}

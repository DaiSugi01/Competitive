package LeetCode.BFSDFS;

public class FloodFill_733 {

    final int[] dy = new int[]{0, 1, 0, -1};
    final int[] dx = new int[]{1, 0, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(sr, sc, image[sr][sc], color, image);
        return image;
    }

    private void dfs(int y, int x, int color, int newColor, int[][] image) {
        if (image[y][x] != color || image[y][x] == newColor)
            return;

        image[y][x] = newColor;
        for (int i = 0; i < dx.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (shouldFill(ny, nx, image)) {
                dfs(ny, nx, color, newColor, image);
            }
        }
    }

    private boolean shouldFill(int y, int x, int[][] image) {
        return y >= 0 && y < image.length &&
                x >= 0 && x < image[0].length;
    }
}

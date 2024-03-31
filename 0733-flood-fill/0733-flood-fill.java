class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int givenColor = image[sr][sc];
        floodFill(image, sr, sc, color, givenColor);
        return image;
    }

    public void floodFill(int[][] image, int r, int c, int color, int givenColor)
    {
        if(r<0||r>=image.length||c<0||c>=image[r].length)
        {
            return;
        }
        if(image[r][c]!=givenColor || image[r][c]==color)
        {
            return;
        }
        image[r][c] = color;
        floodFill(image, r+1, c , color, givenColor);
        floodFill(image, r-1, c , color, givenColor);
        floodFill(image, r, c+1, color, givenColor);
        floodFill(image, r, c-1, color, givenColor);
    }
}
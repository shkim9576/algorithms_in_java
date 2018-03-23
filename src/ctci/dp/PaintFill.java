package ctci.dp;

public class PaintFill {

    public static void main(String[] args) {
        Color[][] screen = {{Color.BLUE, Color.BLUE, Color.GREEN, Color.RED},
                            {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
                            {Color.RED, Color.BLUE, Color.GREEN, Color.BLUE},
                            {Color.BLUE, Color.GREEN, Color.BLUE, Color.BLUE},
                            {Color.BLUE, Color.GREEN, Color.RED, Color.RED},
                            {Color.BLUE, Color.BLUE, Color.GREEN, Color.BLUE}};

        PaintFill ob = new PaintFill();
        ob.paint(screen, 1, 2, Color.BLUE);
        for (int r = 0; r < screen.length; r++) {
            for (int c = 0; c < screen[0].length; c++) System.out.print(screen[r][c] + " ");
            System.out.println();
        }
    }

    enum Color {
        RED, GREEN, BLUE
    }

    boolean paint(Color[][] screen, int r, int c, Color newColor) {
        return paint(screen, r, c, screen[r][c], newColor);
    }

    boolean paint(Color[][] screen, int r, int c, Color oldColor, Color newColor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) return false;
        if (screen[r][c] == newColor) return false;

        if (screen[r][c] == oldColor) {
            screen[r][c] = newColor;
            paint(screen, r - 1, c, oldColor, newColor);
            paint(screen, r + 1, c, oldColor, newColor);
            paint(screen, r, c + 1, oldColor, newColor);
            paint(screen, r, c - 1, oldColor, newColor);
        }
        return true;
    }

}

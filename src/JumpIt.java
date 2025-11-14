public class JumpIt {
    public static void main(String[] args) {
        int[] board = {0, 3, 80, 6, 57, 10};
        System.out.println("The MINIMUM cost is " + minCost(board));
    }
    public static int minCost(int[] board) {
        return minCost(board, 0);
    }

    private static int minCost(int[] board, int index) {
        if (index == board.length - 1) {
            return board[index];
        }
        if (index == board.length - 2) {
            return board[index] + board[index + 1];
        }
        return board[index] + Math.min(minCost(board, index + 1), minCost(board, index + 2));
    }
}
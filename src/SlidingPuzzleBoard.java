import java.util.Scanner;

//Here is the realization of our slide puzzle GameBoard,this class defines members such like int[] board,int length,
//which is vital in a game.
public class SlidingPuzzleBoard extends GameBoard {
    private int[] targetBoard;

    public int getBoardLength() {
        return length;
    }
    public int[] getTargetBoard() {
        return targetBoard;
    }
    public int[] getBoard() {
        return board;
    }

    private static int indexOfZero(int[] a) {
        for (int i = 0; i < a.length; i++) if (a[i] == 0) return i;
        throw new IllegalStateException("No zero found");
    }
    private static void scrambleByRandomMoves(int[] a, int n, int steps, java.util.Random rng) {
        int zero = indexOfZero(a), prevZero = -1;
        for (int s = 0; s < steps; s++) {
            int[] nbrs = zeroNeighborIndices(zero, n);
            if (nbrs.length > 1 && prevZero != -1) {
                int finalPrevZero = prevZero;
                nbrs = java.util.Arrays.stream(nbrs).filter(p -> p != finalPrevZero).toArray();
            }
            int pick = nbrs[rng.nextInt(nbrs.length)];
            int t = a[pick]; a[pick] = a[zero]; a[zero] = t;
            prevZero = zero;
            zero = pick;
        }
    }
    private static int[] zeroNeighborIndices(int z, int n) {
        int r = z / n, c = z % n, k = 0;
        int[] tmp = new int[4];
        if (r > 0)     tmp[k++] = (r - 1) * n + c;
        if (r < n - 1) tmp[k++] = (r + 1) * n + c;
        if (c > 0)     tmp[k++] = r * n + (c - 1);
        if (c < n - 1) tmp[k++] = r * n + (c + 1);
        return java.util.Arrays.copyOf(tmp, k);
    }
    private static String repeat(String s, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static int getBoardSize() {
        Scanner scanner = new Scanner(System.in);
        int size = -1;

        while (true) {
            System.out.print("Enter chessboard size (>= 2): ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size >= 2) {
                    break;  // valid input
                } else {
                    System.out.println("Invalid: Size must be >= 2.");
                }
            } else {
                System.out.println("Invalid: Please enter an integer.");
                scanner.next(); // clear the invalid token
            }
        }

        return size;
    }
    public void createBoard(int n, int steps) {
        this.board = new int[n*n];
        this.targetBoard = new int[n*n];
        for (int i = 0; i < n*n - 1; i++) targetBoard[i] = i + 1;
        targetBoard[n*n - 1] = 0;

        board = java.util.Arrays.copyOf(targetBoard, targetBoard.length);
        scrambleByRandomMoves(board, n, steps, new java.util.Random());
        GamePrompt.printSplitLine();
        System.out.println(GamePrompt.GREEN+"SUCCESS! "+GamePrompt.RESET+
                "CURRENT CREATED BOARD SIZE IS: " + n +"x"+n
        );

    }
    public void printBoard(SlidingPuzzleBoard puzzleBoard) {
        int[] board = puzzleBoard.getBoard();
        int length = puzzleBoard.getBoardLength();
        int width = (String.valueOf(length).length()) * 2;

        for (int i = 0; i < length; i++) {
            System.out.print(repeat("+---",length)+"+\n");
            for (int j = 0; j < length; j++) {
                System.out.print("|");
                int val = board[(i * length) + j];
                if (val == 0) {
                    System.out.printf("%" + width + "s ", " ");
                } else if(String.valueOf(val).length() == 2) {
                    System.out.printf("%" + width + "d ", val);
                }
                else{
                    System.out.printf("%" + width + "d ", val);
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print(repeat("+---",length)+"+\n");
    }
    public void swapBoardElements(int i,int j) {
        int temp = board[i];
        board[i] = board[j];
        board[j] = temp;
    }

    public SlidingPuzzleBoard(int n, int steps) {
        createBoard(n,steps);
        this.length = (int) Math.sqrt(board.length);
    }

}

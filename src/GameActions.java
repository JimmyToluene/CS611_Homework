import java.util.ArrayList;
import java.util.List;

class GameActions {
    //This is a data structure for storing all movableCells. Which means for any given chess board,it will exist a list for
    //their movable cells. We use an ArrayList data type for easily reuse and enqueue and dequeue
    private static final List<Integer> movableCells = new ArrayList<>();
    private static String repeat(String s, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
    //This is a private static method for other static public method to access, It will check for any given element position in chess board
    //Whether their up,down,left and right neighborhood elements are able to make valid movements
    private static void checkNeighborhood(SlidingPuzzleBoard puzzleBoard, int i, int j) {
        int length = puzzleBoard.getBoardLength();
        int[] board = puzzleBoard.getBoard();

        //Check if Move left, any(i,j-1) exists
        if (j - 1 >= 0 && j - 1 < length) {
            movableCells.add(board[i * length + (j - 1)]);
            //If condition is true, we enqueue this element to ArrayList named movableCells
        }
        //Check if Move right, any(i,j+1) exists
        if (j + 1 >= 0 && j + 1 < length) {
            movableCells.add(board[i * length + (j + 1)]);
        }
        //Check if Move up, any(i-1,j) exists
        if (i - 1 >= 0 && i - 1 < length) {
            movableCells.add(board[(i - 1) * length + j]);
        }
        //Check if Move down, any(i+1,j) exists
        if (i + 1 >= 0 && i + 1 < length) {
            movableCells.add(board[(i + 1) * length + j]);
        }
    }
    //For any valid input(The input value is the element itself instead of index of chessBoard array, we need to convert
    //this input element to their related index.
    private static int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // return index
            }
        }
        return -1; // not found
    }

    //Here is one core function in this Class, it performs valid movement in chessBoard array.
    private static void moveChess(SlidingPuzzleBoard puzzleBoard, List<Integer> movableCells, int i, int j) {
        final int length = puzzleBoard.getBoardLength();
        //We use method in GameInput, find our expected input and identify some possible inputs for given specific valid movement ArrayList
        int choice = GameInput.getInput(movableCells);

        // --- perform the move ---
        int[] board = puzzleBoard.getBoard();
        int designatedIndex = GameActions.findIndex(board, choice); //
        puzzleBoard.swapBoardElements(designatedIndex, i * length + j);
        movableCells.clear();
    }
    public static void playSlidePuzzle(SlidingPuzzleBoard slidingPuzzleBoard) {
        int[] targetBoard = slidingPuzzleBoard.getBoard();
        int length = (int) Math.sqrt(targetBoard.length);
        System.out.println(repeat("-----------------------------------------",length));
        slidingPuzzleBoard.printBoard(slidingPuzzleBoard);
        System.out.println(repeat("-----------------------------------------",length));

        outer:
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int val = targetBoard[(i * length) + j];
                if (val == 0) {
                    checkNeighborhood(slidingPuzzleBoard, i, j);
                    System.out.println("Player, which tile do you want to slide to the empty space?");
                    moveChess(slidingPuzzleBoard, movableCells, i, j);
                    break outer;
                }
            }
        }
    }

}

import java.util.Arrays;

public class Test {
    public static void test_source_target_chessboard(SlidingPuzzleBoard slidingPuzzleBoard) {
        int length = slidingPuzzleBoard.getBoardLength();
        int width = (String.valueOf(length).length()) * 2;
        System.out.println("-----------------------------------------".repeat(length));
        System.out.println("HERE IS THE TEST CASE FOR TARGET LIST AND SOURCE LIST");
        System.out.println("-----------------------------------------".repeat(length));
        System.out.println("Current chessboard:"+Arrays.toString(slidingPuzzleBoard.getBoard()));
        System.out.println("Target chessboard:"+ Arrays.toString(slidingPuzzleBoard.getTargetBoard()));
    }
}

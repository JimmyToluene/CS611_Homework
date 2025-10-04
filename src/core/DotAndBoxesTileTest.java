package core;
import io.ConsoleIO;
import io.GameIO;
import org.junit.jupiter.api.Test;

public class DotAndBoxesTileTest {
    public void printBoard(DotsAndBoxesTile box, GameIO io){
        int row = box.getRow();
        int column = box.getColumn();
        io.println("Game size is "+row+"x"+column);
        String[][] rowEdge = box.getHorizontalEdges();
        String[][] colEdge = box.getVerticalEdges();
        for(int i=0;i<row;i++){
            //int row_count;
            int j;
            for(j=0;j<column;j++){
                if(j<column-2){
                    System.out.print("* "+rowEdge[i][j]+" ");
                }
                else if(j==(column-2)){
                    System.out.print("* " + rowEdge[i][j] + " *");
                }
                else{break;}
            }
            io.println("");

            for(j=0;j<column;j++) {
                if (i < row-1) {
                    System.out.print(colEdge[i][j] + "   ");
                } else {
                }
            }
            io.println("");
        }
    }
    @org.junit.Test
    @Test
    public void test(){
        DotsAndBoxesTile testdotbox = new DotsAndBoxesTile(3,3);
        GameIO io = new ConsoleIO();
        this.printBoard(testdotbox,new ConsoleIO());
    }
}

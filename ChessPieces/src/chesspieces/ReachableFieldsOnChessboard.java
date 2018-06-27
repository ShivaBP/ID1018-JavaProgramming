package chesspieces;

/**
 *
 * @author shivabp
 */
public class ReachableFieldsOnChessboard {

    public static void main(String[] args) throws NotValidFieldException, InterruptedException {
        Chessboard chessBoard = new Chessboard();
        System.out.println(chessBoard + "\n");
        Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
        pieces[0] = chessBoard.new Pawn('w', 'P');
        pieces[1] = chessBoard.new Rook('b', 'R');
        pieces[2] = chessBoard.new Queen('w', 'Q');
        pieces[3] = chessBoard.new Bishop('w', 'B');
        pieces[4] = chessBoard.new King('b', 'K');
        pieces[5] = chessBoard.new Knight('w', 'N');

        for (int i = 0; i < pieces.length; i++) {
            int randomColumn = (int) (Math.random() * 8);
            char randomRow = (char) (randomColumn + 97);
            pieces[i].moveTo(randomRow, (byte) randomColumn);
            System.out.println(chessBoard + "\n");

            pieces[i].markReachableFields();
            System.out.println(chessBoard + "\n");
            Thread.sleep(10000);

            pieces[i].unmarkReachableFields();
            System.out.println(chessBoard + "\n");
            pieces[i].moveOut();
        }
    }
}

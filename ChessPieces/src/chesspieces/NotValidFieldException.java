package chesspieces;
/**
 *
 * @author shivabp
 */
public class NotValidFieldException extends Exception {
   public NotValidFieldException(String string){
       System.out.println("EXCEPTION: The chosen field is not on the board.");
   }
}

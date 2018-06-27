package chesspieces;

/**
 *
 * @author shivabp
 */
public class Chessboard {

    public static class Field {

        private char row;
        private byte column;
        private Chesspiece piece = null;
        private boolean marked = false;

        public Field(char row, byte column) {
            this.row = row;
            this.column = column;
        }

        public void put(Chesspiece piece) {
            this.piece = piece;
        }

        public Chesspiece take() {
            Chesspiece PieceToTake = this.piece;
            this.piece = null;
            return PieceToTake;
        }

        public void mark() {
            marked = true;
        }

        public void unmark() {
            marked = false;
        }

        public String toString() {
            String s = (marked) ? "xx" : "--";
            return (piece == null) ? s : piece.toString();
        }
    }
    public static final int NUMBER_OF_COLUMNS = 8;
    public static final int NUMBER_OF_ROWS = 8;
    public static final int FIRST_ROW = 'a';
    public static final int FIRST_COLUMN = 1;
    private Field[][] fields;

    public Chessboard() {
        fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        char row = 0;
        byte column = 0;
        for (int r = 0; r < NUMBER_OF_ROWS; r++) {
            row = (char) (FIRST_ROW + r);
            column = FIRST_COLUMN;
            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                fields[r][c] = new Field(row, column);
                column++;
            }
        }
    }

    public String toString() {
        String result = "   1   2   3   4   5   6   7   8 ";
        char row = 0;
        for (int r = 0; r < NUMBER_OF_ROWS; r++) {
            row = (char) (FIRST_ROW + r);
            result += "\n" + row;
            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                result += "  " + fields[r][c].toString();
            }
        }
        return result;
    }

    public boolean isValidField(char row, byte column) {
        if (row >= FIRST_ROW && row < NUMBER_OF_ROWS + FIRST_ROW) {
            if (column >= FIRST_COLUMN && column <= NUMBER_OF_COLUMNS) {
                return true;
            }
        }
        return false;
    }

    public abstract class Chesspiece {

        private char color; // w - white, b - black
        private char name; // K - King, Q - Queen, P Pawn , R - Rook, B - Bishop, N - Knight,
        protected char row = 0;
        protected byte column = -1;

        protected Chesspiece(char color, char name) {
            this.color = color;
            this.name = name;
        }

        public String toString() {
            return "" + color + name;
        }

        public boolean isOnBoard() {
            return Chessboard.this.isValidField(row, column);
        }

        public void moveTo(char row, byte column) throws NotValidFieldException {
            if (!Chessboard.this.isValidField(row, column)) {
                throw new NotValidFieldException("bad field: " + row + column);
            }
            this.row = row;
            this.column = column;
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;
            Chessboard.this.fields[r][c].put(this);
        }

        public void moveOut() {
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;
            Chessboard.this.fields[r][c].piece = null;
            row = 0;
            column = -1;
        }

        public abstract void markReachableFields();

        public abstract void unmarkReachableFields();
    }

    public class Pawn extends Chesspiece {

        public Pawn(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].mark();
            }
        }

        public void unmarkReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].unmark();

            }
        }
    }

    public class Rook extends Chesspiece {

        public Rook(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {
            int ro = row - FIRST_ROW;
            int col = column - FIRST_COLUMN;
            for (int r = 0; r < NUMBER_OF_ROWS; r++) {
                if (Chessboard.this.isValidField((char) (r + FIRST_ROW), column)) {
                    Chessboard.this.fields[r][col].mark();
                }
            }
            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                if (Chessboard.this.isValidField(row, (byte) (c + FIRST_COLUMN))) {
                    Chessboard.this.fields[ro][c].mark();
                }
            }
        }

        public void unmarkReachableFields() {
            int ro = row - FIRST_ROW;
            int col = column - FIRST_COLUMN;
            for (int r = 0; r < NUMBER_OF_ROWS; r++) {
                if (Chessboard.this.isValidField((char) (r + FIRST_ROW), column)) {
                    Chessboard.this.fields[r][col].unmark();
                }
            }
            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                if (Chessboard.this.isValidField(row, (byte) (c + FIRST_COLUMN))) {
                    Chessboard.this.fields[ro][c].unmark();
                }
            }
        }
    }

    public class Knight extends Chesspiece {

        public Knight(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {
            int ro = row - FIRST_ROW;
            int col = column - FIRST_COLUMN;
            if (Chessboard.this.isValidField((char) (row + 2), (byte) (column + 1))) {
                Chessboard.this.fields[ro + 2][col + 1].mark();
            }
            if (Chessboard.this.isValidField((char) (row + 2), (byte) (column - 1))) {
                Chessboard.this.fields[ro + 2][col - 1].mark();
            }
            if (Chessboard.this.isValidField((char) (row + 1), (byte) (column + 2))) {
                Chessboard.this.fields[ro + 1][col + 2].mark();
            }
            if (Chessboard.this.isValidField((char) (row - 1), (byte) (column + 2))) {
                Chessboard.this.fields[ro - 1][col + 2].mark();
            }
            if (Chessboard.this.isValidField((char) (row - 2), (byte) (column + 1))) {
                Chessboard.this.fields[ro - 2][col + 1].mark();
            }
            if (Chessboard.this.isValidField((char) (row - 2), (byte) (column - 1))) {
                Chessboard.this.fields[ro - 2][col - 1].mark();
            }
            if (Chessboard.this.isValidField((char) (row + 1), (byte) (column - 2))) {
                Chessboard.this.fields[ro + 1][col - 2].mark();
            }
            if (Chessboard.this.isValidField((char) (row - 1), (byte) (column - 2))) {
                Chessboard.this.fields[ro - 1][col - 2].mark();
            }
        }

        public void unmarkReachableFields() {
            int ro = row - FIRST_ROW;
            int col = column - FIRST_COLUMN;
            if (Chessboard.this.isValidField((char) (row + 2), (byte) (column + 1))) {
                Chessboard.this.fields[ro + 2][col + 1].unmark();
            }
            if (Chessboard.this.isValidField((char) (row + 2), (byte) (column - 1))) {
                Chessboard.this.fields[ro + 2][col - 1].unmark();
            }
            if (Chessboard.this.isValidField((char) (row + 1), (byte) (column + 2))) {
                Chessboard.this.fields[ro + 1][col + 2].unmark();
            }
            if (Chessboard.this.isValidField((char) (row - 1), (byte) (column + 2))) {
                Chessboard.this.fields[ro - 1][col + 2].unmark();
            }
            if (Chessboard.this.isValidField((char) (row - 2), (byte) (column + 1))) {
                Chessboard.this.fields[ro - 2][col + 1].unmark();
            }
            if (Chessboard.this.isValidField((char) (row - 2), (byte) (column - 1))) {
                Chessboard.this.fields[ro - 2][col - 1].unmark();
            }
            if (Chessboard.this.isValidField((char) (row + 1), (byte) (column - 2))) {
                Chessboard.this.fields[ro + 1][col - 2].unmark();
            }
            if (Chessboard.this.isValidField((char) (row - 1), (byte) (column - 2))) {
                Chessboard.this.fields[ro - 1][col - 2].unmark();
            }
        }
    }

    public class Bishop extends Chesspiece {

        public Bishop(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {
            int ro = row - FIRST_ROW;
            int col = column - FIRST_COLUMN;
            int i = 0;
            int j = 0;
            while (Chessboard.this.isValidField((char) (row + j), (byte) (column - i))) {
                Chessboard.this.fields[ro + j][col - i].mark();
                i++;
                j++;
            }
            i = j = 0;
            while (Chessboard.this.isValidField((char) (row + j), (byte) (column + i))) {
                Chessboard.this.fields[ro + j][col + i].mark();
                i++;
                j++;
            }
            i = j = 0;

            while (Chessboard.this.isValidField((char) (row - j), (byte) (column - i))) {
                Chessboard.this.fields[ro - j][col - i].mark();
                i++;
                j++;
            }
            i = j = 0;
            while (Chessboard.this.isValidField((char) (row - j), (byte) (column + i))) {
                Chessboard.this.fields[ro - j][col + i].mark();
                i++;
                j++;
            }
            i = j = 0;
        }

        public void unmarkReachableFields() {
            int ro = row - FIRST_ROW;
            int col = column - FIRST_COLUMN;
            int i = 0;
            int j = 0;
            while (Chessboard.this.isValidField((char) (row + j), (byte) (column - i))) {
                Chessboard.this.fields[ro + j][col - i].unmark();
                i++;
                j++;
            }
            i = j = 0;
            while (Chessboard.this.isValidField((char) (row + j), (byte) (column + i))) {
                Chessboard.this.fields[ro + j][col + i].unmark();
                i++;
                j++;
            }
            i = j = 0;

            while (Chessboard.this.isValidField((char) (row - j), (byte) (column - i))) {
                Chessboard.this.fields[ro - j][col - i].unmark();
                i++;
                j++;
            }
            i = j = 0;
            while (Chessboard.this.isValidField((char) (row - j), (byte) (column + i))) {
                Chessboard.this.fields[ro - j][col + i].unmark();
                i++;
                j++;
            }
            i = j = 0;
        }
    }

    public class Queen extends Chesspiece {

        public Queen(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {
            int ro = row - FIRST_ROW;
            int col = column - FIRST_COLUMN;
            int i = 0;
            int j = 0;
            for (int r = 0; r < NUMBER_OF_ROWS; r++) {
                if (Chessboard.this.isValidField((char) (r + FIRST_ROW), column)) {
                    Chessboard.this.fields[r][col].mark();
                }
            }
            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                if (Chessboard.this.isValidField(row, (byte) (c + FIRST_COLUMN))) {
                    Chessboard.this.fields[ro][c].mark();
                }
            }
            while (Chessboard.this.isValidField((char) (row + j), (byte) (column - i))) {
                Chessboard.this.fields[ro + j][col - i].mark();
                i++;
                j++;
            }
            i = j = 0;
            while (Chessboard.this.isValidField((char) (row + j), (byte) (column + i))) {
                Chessboard.this.fields[ro + j][col + i].mark();
                i++;
                j++;
            }
            i = j = 0;

            while (Chessboard.this.isValidField((char) (row - j), (byte) (column - i))) {
                Chessboard.this.fields[ro - j][col - i].mark();
                i++;
                j++;
            }
            i = j = 0;
            while (Chessboard.this.isValidField((char) (row - j), (byte) (column + i))) {
                Chessboard.this.fields[ro - j][col + i].mark();
                i++;
                j++;
            }
            i = j = 0;
        }

        public void unmarkReachableFields() {
            int ro = row - FIRST_ROW;
            int col = column - FIRST_COLUMN;
            int i = 0;
            int j = 0;
            for (int r = 0; r < NUMBER_OF_ROWS; r++) {
                if (Chessboard.this.isValidField((char) (r + FIRST_ROW), column)) {
                    Chessboard.this.fields[r][col].unmark();
                }
            }
            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                if (Chessboard.this.isValidField(row, (byte) (c + FIRST_COLUMN))) {
                    Chessboard.this.fields[ro][c].unmark();
                }
            }
            while (Chessboard.this.isValidField((char) (row + j), (byte) (column - i))) {
                Chessboard.this.fields[ro + j][col - i].unmark();
                i++;
                j++;
            }
            i = j = 0;
            while (Chessboard.this.isValidField((char) (row + j), (byte) (column + i))) {
                Chessboard.this.fields[ro + j][col + i].unmark();
                i++;
                j++;
            }
            i = j = 0;

            while (Chessboard.this.isValidField((char) (row - j), (byte) (column - i))) {
                Chessboard.this.fields[ro - j][col - i].unmark();
                i++;
                j++;
            }
            i = j = 0;
            while (Chessboard.this.isValidField((char) (row - j), (byte) (column + i))) {
                Chessboard.this.fields[ro - j][col + i].unmark();
                i++;
                j++;
            }
            i = j = 0;

        }
    }

    public class King extends Chesspiece {

        public King(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {
            int ro = row - FIRST_ROW;
            int col = column - FIRST_COLUMN;
            if (Chessboard.this.isValidField((char) (row + 1), (byte) (column + 1))) {
                Chessboard.this.fields[ro + 1][col + 1].mark();
            }
            if (Chessboard.this.isValidField((char) (row + 1), (byte) (column))) {
                Chessboard.this.fields[ro + 1][col].mark();
            }
            if (Chessboard.this.isValidField((char) (row + 1), (byte) (column - 1))) {
                Chessboard.this.fields[ro + 1][col - 1].mark();
            }
            if (Chessboard.this.isValidField((char) (row), (byte) (column + 1))) {
                Chessboard.this.fields[ro][col + 1].mark();
            }
            if (Chessboard.this.isValidField((char) (row), (byte) (column - 1))) {
                Chessboard.this.fields[ro][col - 1].mark();
            }
            if (Chessboard.this.isValidField((char) (row - 1), (byte) (column + 1))) {
                Chessboard.this.fields[ro - 1][col + 1].mark();
            }
            if (Chessboard.this.isValidField((char) (row - 1), (byte) (column - 1))) {
                Chessboard.this.fields[ro - 1][col - 1].mark();
            }
            if (Chessboard.this.isValidField((char) (row - 1), (byte) (column))) {
                Chessboard.this.fields[ro - 1][col].mark();
            }
        }

        public void unmarkReachableFields() {
            int ro = row - FIRST_ROW;
            int col = column - FIRST_COLUMN;
            if (Chessboard.this.isValidField((char) (row + 1), (byte) (column + 1))) {
                Chessboard.this.fields[ro + 1][col + 1].unmark();
            }
            if (Chessboard.this.isValidField((char) (row + 1), (byte) (column))) {
                Chessboard.this.fields[ro + 1][col].unmark();
            }
            if (Chessboard.this.isValidField((char) (row + 1), (byte) (column - 1))) {
                Chessboard.this.fields[ro + 1][col - 1].unmark();
            }
            if (Chessboard.this.isValidField((char) (row), (byte) (column + 1))) {
                Chessboard.this.fields[ro][col + 1].unmark();
            }
            if (Chessboard.this.isValidField((char) (row), (byte) (column - 1))) {
                Chessboard.this.fields[ro][col - 1].unmark();
            }
            if (Chessboard.this.isValidField((char) (row - 1), (byte) (column + 1))) {
                Chessboard.this.fields[ro - 1][col + 1].unmark();
            }
            if (Chessboard.this.isValidField((char) (row - 1), (byte) (column - 1))) {
                Chessboard.this.fields[ro - 1][col - 1].unmark();
            }
            if (Chessboard.this.isValidField((char) (row - 1), (byte) (column))) {
                Chessboard.this.fields[ro - 1][col].unmark();
            }
        }
    }

}

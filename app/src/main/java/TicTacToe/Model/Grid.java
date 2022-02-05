package TicTacToe.Model;

public class Grid {
    public static final int GRID_SIZE = 3;
    private CellState[][] cells; // inverser inputs i et j des methodes

    public static final int[][] magicSquare = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};

    public Grid() {
        this.cells = new CellState[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.cells[i][j] = CellState.EMPTY;
            }
        }
    }

    public void place(int j, int i, CellState state) 
    throws IllegalArgumentException {
        if (state == CellState.EMPTY) {
            throw new IllegalArgumentException("cannot place empty cell");
        }
        if (i < 0 ||i >= GRID_SIZE || j < 0 ||j >= GRID_SIZE) {
            throw new IllegalArgumentException("invalid coordinates");
        }
        if (this.cells[i][j] == CellState.EMPTY) {
            this.cells[i][j] = state;
        } else {
            throw new IllegalArgumentException("cell not empty");
        }
    }

    public CellState hasWon() {
        
        int[][] emptyMagicSquare = new int[GRID_SIZE][GRID_SIZE];

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (this.cells[i][j] == CellState.X) {
                    emptyMagicSquare[i][j] = magicSquare[i][j];
                } else if (this.cells[i][j] == CellState.O) {
                    emptyMagicSquare[i][j] = -magicSquare[i][j];
                } else {
                    emptyMagicSquare[i][j] = 0;
                }
            }
        }

        // check diagonals
        int tmp;
        
        tmp = emptyMagicSquare[0][0] + emptyMagicSquare[1][1] + emptyMagicSquare[2][2];
        if (tmp == 15) {
            return CellState.X;
        } else if (tmp == -15) {
            return CellState.O;
        }

        tmp = emptyMagicSquare[2][0] + emptyMagicSquare[1][1] + emptyMagicSquare[0][2];
        if (tmp == 15) {
            return CellState.X;
        } else if (tmp == -15) {
            return CellState.O;
        }

        // check rows
        for (int i = 0; i < GRID_SIZE; i++) {
            tmp = 0;
            for (int j = 0; j < GRID_SIZE; j++) {
                tmp += emptyMagicSquare[i][j];
            }
            if (tmp == 15) {
                return CellState.X;
            } else if (tmp == -15) {
                return CellState.O;
            }
        }

        // check for columns
        for (int i = 0; i < GRID_SIZE; i++) {
            tmp = 0;
            for (int j = 0; j < GRID_SIZE; j++) {
                tmp += emptyMagicSquare[j][i];
            }
            if (tmp == 15) {
                return CellState.X;
            } else if (tmp == -15) {
                return CellState.O;
            }
        }

        return CellState.EMPTY;
    }

    public boolean isFull() {
        boolean temp = true;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (this.cells[i][j] == CellState.EMPTY) {
                    temp = false;
                }
            }
        }
        return temp;
    }

    public void clearGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.cells[i][j] = CellState.EMPTY;
            }
        }
    }

    public boolean isCellEmpty(int j, int i) {
        return this.cells[i][j] == CellState.EMPTY;
    }
    
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                switch (this.cells[i][j]) {
                    case X:
                        str += " X ";
                        break;
                    case O:
                        str += " O ";
                        break;
                    default:
                        str += " _ ";
                        break;
                }
            }
            str += "\n";
        }
        return str;
    }
       
}

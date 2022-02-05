package TicTacToe.Model;

/**
 * Model class that represents the game's grid
 */
public class Grid {
    /**
     * Size of the square grid
     */
    public static final int GRID_SIZE = 3;
    private CellState[][] cells; // inverser inputs i et j des methodes

    /**
     * The sums of each row, column or diagonal is equal to 15
     */
    public static final int[][] magicSquare = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};

    /**
     * Creates an empty grid, all cells are initialized with 'EMPTY'
     */
    public Grid() {
        this.cells = new CellState[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.cells[i][j] = CellState.EMPTY;
            }
        }
    }

    /**
     * Places a mark on the grid
     * @param j i coordinate (swapped)
     * @param i j coordinate (swapped)
     * @param state state to be placed on the grid
     * @throws IllegalArgumentException when the cell is not empty, the state
     * to be placed is empty or the coordinates are incorrect
     */
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

    /**
     * Tells wether or not there is a winner
     * @return The winner if the game is won or the empty state if there is no winner yet
     */
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

    /**
     * Returns wether the grid is full or not
     * @return true if the grid is full, else false
     */
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

    /**
     * Clears the grid of all Xs or Os and resets it to Empty states
     */
    public void clearGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.cells[i][j] = CellState.EMPTY;
            }
        }
    }

    /**
     * Returns wether the cell at the given coordinates is empty or not
     * @param j i coordinate (swapped)
     * @param i j coordinate (swapped)
     * @return true if the cell is empty, else false
     */
    @Deprecated
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

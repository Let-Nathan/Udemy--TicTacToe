import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

            System.out.println("\nLet's play tic tac toe");

            //Task 1: Create an array with three rows of '_' characters.
            char[][] board = {
                    {'_', '_', '_'},
                    {'_', '_', '_'},
                    {'_', '_', '_'},
            };

            //Task 2: Call the function printBoard();
            printBoard(board);
/*
                Task 3: Loop through turns.

                  if (X) turn {
                     Task 4: call askUser().
                     Task 5: populate the board using askUser's return value.
                  } else {
                      Task 4: call askUser().
                      Task 5: populate the board using askUser's return value. Then, print it.

                  }
*/
            for (int i = 0; i < 9; i++) {
                if (i % 2 == 0 )  {
                    System.out.println("Turn to X");
                    int[] user = askUser(board);
                    if (board[user[0] - 1 ][user[1] - 1] != 'O' && board[user[0] - 1 ][user[1] - 1] != 'X') {
                        board[user[0] - 1][user[1] - 1] = 'X';
                        printBoard(board);
                    } else {
                        System.out.println("Spot " + board[user[0] - 1][user[1] - 1] + " is already taken, choose an other one !");
                        i--;
                    }
                }
                if (i % 2 != 0 ) {
                    System.out.println("Turn to O");
                    int[] user = askUser(board);
                    if (board[user[0] - 1 ][user[1] - 1] != 'O' && board[user[0] - 1 ][user[1] - 1] != 'X') {
                        board[user[0] - 1][user[1] - 1] = 'O';
                        printBoard(board);
                    } else {
                        System.out.println("Spot " + board[user[0] - 1][user[1] - 1] + " is already taken, choose an other one !");
                        i--;
                    }
                }


                int count = checkWin(board);

                switch (count) {
                    case 3 -> {
                        System.out.println("Player X wins");
                        i = 9;
                    }
                    case -3 -> {
                        System.out.println("Player O wins");
                        i = 9;
                    }
                }
            }
            scan.close();
        }


    /** Task 2 - Write a function that prints the board.
     * Function name - printBoard()
     * @param board (char[][])
     * 
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     *      • separate each row by two lines. 
     *      • each row precedes a tab of space
     *      • each character in the grid has one space from the other character
     */
    public static void printBoard( char[][] board) {
        System.out.print("\n");
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                System.out.print("\t" + board[i][j] + " ");
            }
            System.out.println("\n\n");
        }
    }

   /** Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */
   public static int[] askUser(char[][] board) {
       System.out.println("Choose a row and column number");
       int[] spot = new int[2];
       spot[0] = scan.nextInt();
       spot[1] = scan.nextInt();
        while(spot[0] > 3 || spot[0] < 0 || spot[1] > 3 || spot[1] < 0) {
           System.out.println("Row and Column can't be greater than 3 \n input a valid number between 0 & 3");
           spot[0] = scan.nextInt();
           spot[1] = scan.nextInt();
       }
       return spot;
   }
    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */
    public static int checkWin (char[][] board) {
        int count = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'X') {
                    count++;
                } else if (board[i][j] == 'O') {
                    count--;
                }
                if(board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X') {
                    count++;
                } else if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O') {
                    count = -3;
                }
            }

            if(count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }
        }
        return count;
    }

}

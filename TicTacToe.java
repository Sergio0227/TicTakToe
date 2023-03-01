import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("\nLet's play tic tac toe");

    char[][] board = {
        { '_', '_', '_' },
        { '_', '_', '_' },
        { '_', '_', '_' } };

    printBoard(board);

    for (int i = 0; i < 9; i++) {
      if (i % 2 == 0) {
        System.out.println("Turn: X");
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'X';

      } else {
        System.out.println("Turn: O");
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'O';

      }
      printBoard(board);
      int count = checkWin(board);
      if (count == 3) {
        System.out.println("X Won");
        System.exit(0);
      } else if (count == -3) {
        System.out.println("O Won");
        System.exit(0);
      }
    }
    System.out.println("Draw");

    scan.close();
  }

  /**
   * Function name - printBoard()
   * 
   * @param board (char[][])
   * 
   */

  public static void printBoard(char[][] board) {
    System.out.print("\n");
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] + "   ");
      }
      System.out.print("\n\n");
    }
  }

  /**
   * Function name – askUser
   * 
   * @param board (char[][] board)
   * @return spot (int[])
   * 
   * 
   */

  public static int[] askUser(char[][] board) {

    System.out.print("Pick a row: ");
    int row = scan.nextInt();
    System.out.print("Pick a column: ");
    int elemet = scan.nextInt();
    while (board[row][elemet] == 'X' || board[row][elemet] == 'O') {
      System.out.print("Spot taken, select a free spot");
      System.out.print("Pick a row: ");
      row = scan.nextInt();
      System.out.print("Pick a column: ");
      elemet = scan.nextInt();
    }
    return new int[] { row, elemet };
  }

  /**
   * Function name - checkWin
   * 
   * @param board (char[][])
   * @return count (int)
   * 
   *       
   */

  public static int checkWin(char[][] board) {
    int count = 0;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'X') {
          count++;
        } else if (board[i][j] == 'O') {
          count--;
        }
      }
      if (count == 3 || count == -3)
        return count;
      else
        count = 0;

    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {

        if (board[j][i] == 'X') {
          count++; // count each X as +1
        } else if (board[j][i] == 'O') {
          count--; // count each O as -1.
        }
      }
      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0;
      }
    }

    for (int i = 0; i < 3; i++) {
      if (board[i][i] == 'X') {
        count++; // count each X as +1
      } else if (board[i][i] == 'O') {
        count--; // count each O as -1.
      }
    }

    if (count == 3 || count == -3) {
      return count;
    } else {
      count = 0;
    }

    for (int i = 0; i < 3; i++) {
      if (board[i][2 - i] == 'X') {
        count++; // count each X as +1
      } else if (board[i][2 - i] == 'O') {
        count--; // count each O as -1.
      }
    }

    return count;
  }
}

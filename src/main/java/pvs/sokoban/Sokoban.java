package pvs.sokoban;

import pvs.assignment02.Pair;

public class Sokoban {
  private final static int NORTH = 0;
  private final static int EAST = 1;
  private final static int SOUTH = 2;
  private final static int WEST = 3;

  public static void main(String... args) {
    char [][] sokoban = new char [7][];
    sokoban[0] = "#######".toCharArray();
    sokoban[1] = "#.....#".toCharArray();
    sokoban[2] = "#..$..#".toCharArray();
    sokoban[3] = "#.$@$.#".toCharArray();
    sokoban[4] = "#..$..#".toCharArray();
    sokoban[5] = "#.....#".toCharArray();
    sokoban[6] = "#######".toCharArray();

    System.out.println(sokobanToString(sokoban));
    System.out.println(findPlayer(sokoban));
    moveNorth(sokoban);
    System.out.println(findPlayer(sokoban));
    System.out.println(sokobanToString(sokoban));
    moveNorth(sokoban);
    System.out.println(sokobanToString(sokoban));
    moveEast(sokoban);
    System.out.println(sokobanToString(sokoban));
  }

  protected static Pair<Integer, Integer> findPlayer(char[][] pitch) {
    Pair<Integer, Integer> position;
    for (int i = 0; i < pitch.length; ++i) {
      for (int j = 0; j < pitch[0].length; ++j) {
        if (pitch[i][j] == '@') {
          position = new Pair<>(i, j);
          return position;
        }
      }
    }
    throw new IllegalStateException("No position found.");
  }

  public static boolean moveNorth(char[][] pitch) {
    return move(pitch, NORTH);
  }

  public static boolean moveEast(char[][] pitch) {
    return move(pitch, EAST);
  }

  public static boolean moveSouth(char[][] pitch) {
    return move(pitch, SOUTH);
  }

  public static boolean moveWest(char[][] pitch) {
    return move(pitch,WEST);
  }

  private static boolean move(char[][] pitch, int direction) {
    Pair<Integer, Integer> position = findPlayer(pitch);
    int pos_x = position.getFirst();
    int pos_y = position.getSecond();

    switch (direction) {
      case WEST:
        if (pitch[pos_x][pos_y - 1] == '$' && pitch[pos_x][pos_y - 2] == '.') {
          pitch[pos_x][pos_y] = '.';
          pitch[pos_x][pos_y - 1] = '@';
          pitch[pos_x][pos_y - 2] = '$';
          return true;
        } else if (pitch[pos_x][pos_y - 1] == '.') {
          pitch[pos_x][pos_y] = '.';
          pitch[pos_x][pos_y - 1] = '@';
          return true;
        }
        break;
      case SOUTH:
        if (pitch[pos_x + 1][pos_y] == '$' && pitch[pos_x + 2][pos_y] == '.') {
          pitch[pos_x][pos_y] = '.';
          pitch[pos_x + 1][pos_y] = '@';
          pitch[pos_x + 2][pos_y] = '$';
          return true;
        } else if (pitch[pos_x + 1][pos_y] == '.') {
          pitch[pos_x][pos_y] = '.';
          pitch[pos_x + 1][pos_y] = '@';
          return true;
        }
        break;
      case EAST:
        if (pitch[pos_x][pos_y + 1] == '$' && pitch[pos_x][pos_y + 2] == '.') {
          pitch[pos_x][pos_y] = '.';
          pitch[pos_x][pos_y + 1] = '@';
          pitch[pos_x][pos_y + 2] = '$';
          return true;
        } else if (pitch[pos_x][pos_y + 1] == '.') {
          pitch[pos_x][pos_y] = '.';
          pitch[pos_x][pos_y + 1] = '@';
          return true;
        }
        break;
      case NORTH:
        if (pitch[pos_x - 1][pos_y] == '$' && pitch[pos_x - 2][pos_y] == '.') {
          pitch[pos_x][pos_y] = '.';
          pitch[pos_x - 1][pos_y] = '@';
          pitch[pos_x - 2][pos_y] = '$';
          return true;
        } else if (pitch[pos_x - 1][pos_y] == '.') {
          pitch[pos_x][pos_y] = '.';
          pitch[pos_x - 1][pos_y] = '@';
          return true;
        }
        break;
      default:
          break;
    }
    return false;
  }

  public static String sokobanToString(char[][] pitch) {
    String result = "";
    for (int i = 0; i < pitch.length; ++i) {
      result += new String(pitch[i]);
      result += "\n";
    }
    return result;
  }
}

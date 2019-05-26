package pvs.assignment04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Exercise 1. Reading inputs by different tools.
 *
 * @author Christian
 */
public class InputReader {
  private static long timeToReadByScanner;
  private static long timeToReadByBufferedReader;

  public static void main(String[] args) {
    readByScanner();
    readByBufferedReader();
    System.out.println("Scanner took " + timeToReadByScanner + " milliseconds to read the input.");
    System.out.println("BufferedReader took " + timeToReadByBufferedReader + " milliseconds to read the input.");
  }

  private static void readByScanner() {
    long time1 = System.currentTimeMillis();
    long result = 0;
    try (Scanner scanner = new Scanner(new FileInputStream("resources/bigInput.txt"))) {
      while (scanner.hasNext()) {
        result += scanner.nextInt();
      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    System.out.println(result);
    timeToReadByScanner = System.currentTimeMillis() - time1;
  }

  private static void readByBufferedReader() {
    long time1 = System.currentTimeMillis();
    long result = 0;
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/bigInput.txt"))) {
      String nextLine;
      while ((nextLine = bufferedReader.readLine()) != null) {
        result += Integer.parseInt(nextLine);
      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    System.out.println(result);
    timeToReadByBufferedReader = System.currentTimeMillis() - time1;
  }
}

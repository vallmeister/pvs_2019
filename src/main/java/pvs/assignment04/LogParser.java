package pvs.assignment04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercise 3. Using regex to read warnings from a log.
 *
 * @author Christian
 */
public class LogParser {
  public static void main(String[] args) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/build.log"))) {
      int lineNumber = 1;
      Pattern warningPattern = Pattern.compile("^Warning [\\d]* of [\\d]*:");
      Pattern filePattern = Pattern.compile("[/[a-zA-Z_-]*]*\\.[a-z]*");
      String nextLine;
      while ((nextLine = bufferedReader.readLine()) != null) {
        Matcher warningMatcher = warningPattern.matcher(nextLine);
        if (warningMatcher.matches()) {
          System.out.print(lineNumber + ": " + nextLine + " ");

          PATH: while ((nextLine = bufferedReader.readLine()) != null) {
            String[] nextLineSplitters = nextLine.split("\\s");

            for (int i = 0; i < nextLineSplitters.length; ++i) {
              Matcher fileMatcher = filePattern.matcher(nextLineSplitters[i]);
              warningMatcher = warningPattern.matcher(nextLine);
              if (fileMatcher.matches()) {
                System.out.println(nextLineSplitters[i] + " " + nextLineSplitters[i + 2].replace(",", ""));
                break PATH;
              } else if (warningMatcher.matches()) {
                break PATH;
              }
            }
            lineNumber++;
          }
          lineNumber++;
        }
        lineNumber++;
      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}

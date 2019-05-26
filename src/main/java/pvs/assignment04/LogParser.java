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
      Pattern warningPattern = Pattern.compile("Warning [\\d]* of [\\d]*:");
      //Pattern filePattern = Pattern.compile("[.]* /[a-zA-Z]+[\.]*");
      String nextLine;
      while ((nextLine = bufferedReader.readLine()) != null) {
        Matcher matcher = warningPattern.matcher(nextLine);
        if (matcher.matches()) {
          System.out.println(lineNumber + ": " + nextLine);
        }
        lineNumber++;
      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}

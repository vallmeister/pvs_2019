package pvs.assignment03;

import pvs.assignment02.Pair;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Assignment 3 exercise 2.
 *
 * @author Christian
 */
public class GradeOverview {
  private HashMap<String, Pair<Double, Integer>> gradeOverview;

  public GradeOverview() {
    gradeOverview = new HashMap<>();
  }

  public Pair<Double, Integer> addTestResult(String lectureName, Pair<Double, Integer> gradeAndECTS) {
    if (lectureName == null || gradeAndECTS == null) {
      throw new IllegalArgumentException("At least one parameter is null.");
    }
   gradeOverview.put(lectureName, gradeAndECTS);
   return gradeAndECTS;
  }

  public int currentECTS() {
    int lp = 0;
    for (Pair<Double, Integer> pair : gradeOverview.values()) {
      lp += pair.getSecond();
    }
    return lp;
  }

  public Optional<Pair<Double, Integer>> getExamResults(String lectureName) {
    return Optional.ofNullable(gradeOverview.get(lectureName));
  }

  public double totalGradeAverage() {
    int totalLP = currentECTS();
    double result = 0;
    for (Pair<Double, Integer> pair : gradeOverview.values()) {
      double temp = pair.getFirst() * pair.getSecond();
      result += temp;
    }
    result /= totalLP;
    return result;
  }

  public int currentStreamECTS() {
    Stream<Pair<Double, Integer>> pairStream = gradeOverview.values().stream();
    return pairStream.map(Pair::getSecond).mapToInt(Integer::intValue).sum();
  }
}

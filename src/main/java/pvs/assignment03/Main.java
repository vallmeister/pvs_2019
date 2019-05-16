package pvs.assignment03;

import pvs.assignment02.Pair;

/**
 * Main class to test the implementation.
 *
 * @author Christian
 */
public class Main {
  public static void main(String[] args) {
    GradeOverview gradeOverview = new GradeOverview();
    gradeOverview.addTestResult("PvS", new Pair<>(1.3d, 8));
    gradeOverview.addTestResult("Pvd", new Pair<>(1.7d, 5));
    gradeOverview.addTestResult("Pvh", new Pair<>(1.0d, 7));
    System.out.println(gradeOverview.currentStreamECTS());
  }
}

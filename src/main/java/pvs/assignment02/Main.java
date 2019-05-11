package pvs.assignment02;

import java.time.LocalDate;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Pair<Integer, Float> pair1 = new Pair<>(95, 2.5f);
    Pair<Integer, Float> pair2 = new Pair<>(85, 41.5f);
    Pair<Integer, Float> pair3 = new Pair<>(53, 111.5f);
    Pair<Integer, Float> pair4 = new Pair<>(52, 451.5f);
    Pair<Integer, Float> pair5 = new Pair<>(4, 31.5f);
    Pair<Integer, Float> pair6 = new Pair<>(6, 15.5f);
    Pair<Integer, Float> pair7 = new Pair<>(7, 17.5f);

    List<Pair<Integer, Float>> pairs = new ArrayList<>();
    pairs.add(pair1);
    pairs.add(pair2);
    pairs.add(pair3);
    pairs.add(pair4);
    pairs.add(pair5);
    pairs.add(pair6);
    pairs.add(pair7);

    System.out.println(Arrays.toString(pairs.toArray()));
    Collections.sort(pairs);
    System.out.println(Arrays.toString(pairs.toArray()));

    HashSet<Pair<Integer, Float>> pairHashSet = new HashSet<>();
    for (int i = 0; i < pairs.size(); ++i) {
      Pair<Integer, Float> pair = pairs.get(i);
      if (pairHashSet.contains(pair)) {
        System.out.println(pair.toString());
      } else {
        pairHashSet.add(pair);
      }
    }

    // Aufgabe 3 LocalDate
    System.out.println(LocalDate.now());

    LocalDate fourWeeksAgo = LocalDate.now().minusWeeks(4L);
    LocalDate oneMonthAgo = LocalDate.now().minusMonths(1L);
    System.out.println("Die Daten sind gleich: " + fourWeeksAgo.equals(oneMonthAgo));
    System.out.println("Vor 4 Wochen: " + fourWeeksAgo.getDayOfWeek().toString());
    System.out.println("Vor einem Monat: " + oneMonthAgo.getDayOfWeek().toString());
  }
}

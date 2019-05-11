package pvs.assignment02;

import java.util.Objects;

public class Pair<F, S> implements Comparable<Pair<F, S>> {
  private F first;
  private S second;

  public Pair(F fst, S scnd) {
    this.first = fst;
    this.second = scnd;
  }

  public F getFirst() {
    return first;
  }

  public S getSecond() {
    return second;
  }

  @Override
  public String toString() {
    return "first=" + first +
            ", second=" + second +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return Objects.equals(first, pair.first) &&
            Objects.equals(second, pair.second);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second);
  }

  @Override
  @SuppressWarnings("unchecked")
  public int compareTo(@SuppressWarnings("NullableProblems") Pair other) {
    F this_first = this.first;
    F other_first = (F) other.getFirst();
    S this_second = this.second;
    S other_second = (S) other.getSecond();
    if (this_first.hashCode() > other_first.hashCode()) {
      return 1;
    } else if (this_first.hashCode() < other_first.hashCode()) {
      return -1;
    } else
      if (this_second.hashCode() > other_second.hashCode()) {
        return 1;
      } else if (this_second.hashCode() < other_second.hashCode()) {
        return -1;
      } else {
        return 0;
      }
  }
}

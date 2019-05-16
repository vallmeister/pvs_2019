package pvs.assignment02;

import java.util.Objects;

/**
 * Class for tupel.
 * @param <F> First element of the tupel.
 * @param <S> Second element.
 */
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
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
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
    F thisFirst = this.first;
    F otherFirst = (F) other.getFirst();
    S thisSecond = this.second;
    S otherSecond = (S) other.getSecond();
    if (thisFirst.hashCode() > otherFirst.hashCode()) {
      return 1;
    } else if (thisFirst.hashCode() < otherFirst.hashCode()) {
      return -1;
    } else
      if (thisSecond.hashCode() > otherSecond.hashCode()) {
        return 1;
      } else if (thisSecond.hashCode() < otherSecond.hashCode()) {
        return -1;
      } else {
        return 0;
      }
  }
}

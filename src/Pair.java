import java.util.Objects;

class Pair<K, V> {
    private final K poczatkowy;
    private final V koncowy;

    public Pair(K poczatkowy, V koncowy) {
        this.poczatkowy = poczatkowy;
        this.koncowy = koncowy;
    }

    public K getPoczatkowy() {
        return poczatkowy;
    }

    public V getKoncowy() {
        return koncowy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(poczatkowy, pair.poczatkowy) && Objects.equals(koncowy, pair.koncowy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(poczatkowy, koncowy);
    }
}
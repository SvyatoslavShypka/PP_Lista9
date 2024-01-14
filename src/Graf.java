import java.util.*;

public class Graf<W, S> implements IGraf<W, S> {
    private final Set<W> wierzcholki;
    private final Map<W, List<W>> listaSasiedztwa;
    private final Map<Pair<W, W>, S> krawedzie;

    public Graf(Set<W> wierzcholki, Map<Pair<W, W>, S> krawedzie) {
        this.wierzcholki = wierzcholki;
        this.krawedzie = krawedzie;

        // Inicjalizacja listy sąsiedztwa
        listaSasiedztwa = new HashMap<>();
        for (W w : wierzcholki) {
            listaSasiedztwa.put(w, new ArrayList<>());
        }

        // Dodanie krawędzi do listy sąsiedztwa
        for (Map.Entry<Pair<W, W>, S> entry : krawedzie.entrySet()) {
            W w1 = entry.getKey().getFirst();
            W w2 = entry.getKey().getSecond();
            listaSasiedztwa.get(w1).add(w2);
        }
    }

    @Override
    public List<W> wierzcholki() {
        return new ArrayList<>(wierzcholki);
    }

    @Override
    public S krawedz(W w1, W w2) {
        return krawedzie.getOrDefault(new Pair<>(w1, w2), null);
    }

    @Override
    public List<W> krawedzie(W w) {
        return new ArrayList<>(listaSasiedztwa.getOrDefault(w, Collections.emptyList()));
    }

    // Prosta klasa reprezentująca parę (do użycia jako klucz w mapie)
    private static class Pair<K, V> {
        private final K first;
        private final V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }

    // Przykładowe użycie
    public static void main(String[] args) {
        Set<String> wierzcholki = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        Map<Pair<String, String>, String> krawedzie = new HashMap<>();
        krawedzie.put(new Pair<>("A", "B"), "Edge1");
        krawedzie.put(new Pair<>("B", "C"), "Edge2");
        krawedzie.put(new Pair<>("C", "D"), "Edge3");

        Graf<String, String> graf = new Graf<>(wierzcholki, krawedzie);

        // Testowanie operacji na grafie
        System.out.println("Wierzchołki: " + graf.wierzcholki());
        System.out.println("Krawędź A-B: " + graf.krawedz("A", "B"));
        System.out.println("Wierzchołki połączone z A: " + graf.krawedzie("A"));
    }
}

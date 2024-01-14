import java.util.*;

public class Graf<W, S> implements IGraf<W, S> {
    //Używamy SET bo wierzchołki nie mogą powtarzać się
    private final Set<W> wierzcholki;
    //Używamy MAP z key: Para<początkowy wierzchołek, końcowy wierzchołek>
    private final Map<Pair<W, W>, S> krawedzie;

    public Graf(Set<W> wierzcholki, Map<Pair<W, W>, S> krawedzie) {
        this.wierzcholki = wierzcholki;
        this.krawedzie = krawedzie;
    }

    @Override
    public List<W> wierzcholki() {
        List<W> result = new ArrayList<>(wierzcholki);
        return result;
    }

    @Override
    public S krawedz(W w1, W w2) {
        S result = krawedzie.getOrDefault(new Pair<>(w1, w2), null);
        return result;
    }

    @Override
    public List<W> krawedzie(W w) {
        List<W> sasiedzi = new ArrayList<>();
        for (Map.Entry<Pair<W, W>, S> entry : krawedzie.entrySet()) {
            if (entry.getKey().getPoczatkowy().equals(w)) {
                sasiedzi.add(entry.getKey().getKoncowy());
            }
        }
        return sasiedzi;
    }



    public static void main(String[] args) {
        Set<String> wierzcholki = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        Map<Pair<String, String>, String> krawedzie = new HashMap<>();
        krawedzie.put(new Pair<>("A", "B"), "Edge1");
        krawedzie.put(new Pair<>("B", "C"), "Edge2");
        krawedzie.put(new Pair<>("C", "D"), "Edge3");
        krawedzie.put(new Pair<>("A", "D"), "Edge4");

        Graf<String, String> graf = new Graf<>(wierzcholki, krawedzie);

        System.out.println("Wierzchołki: " + graf.wierzcholki());
        System.out.println("Krawędź A-B: " + graf.krawedz("A", "B"));
        System.out.println("Wierzchołki połączone z A: " + graf.krawedzie("A"));
    }
}

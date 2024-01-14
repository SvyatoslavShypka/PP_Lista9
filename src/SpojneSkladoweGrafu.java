import java.util.*;

public class SpojneSkladoweGrafu {

    public static <W, S> List<List<W>> getSpojneSkadowe(IGraf<W, S> graf) {
        List<List<W>> spojneSkladowe = new ArrayList<>();
        Set<W> odwiedzoneWierzcholki = new HashSet<>();

        for (W wierzcholek : graf.wierzcholki()) {
            if (!odwiedzoneWierzcholki.contains(wierzcholek)) {
                List<W> spojnaSkladowa = bfs(graf, wierzcholek, odwiedzoneWierzcholki);
                spojneSkladowe.add(spojnaSkladowa);
            }
        }
        return spojneSkladowe;
    }

    // przeszukiwanie wszerz
    private static <W, S> List<W> bfs(IGraf<W, S> graf, W poczatkowyWierzcholek, Set<W> odwiedzoneWierzcholki) {
        List<W> spojnaSkladowa = new ArrayList<>();
        Queue<W> queue = new LinkedList<>();

        queue.add(poczatkowyWierzcholek);
        odwiedzoneWierzcholki.add(poczatkowyWierzcholek);

        while (!queue.isEmpty()) {
            W current = queue.poll();
            spojnaSkladowa.add(current);

            for (W sasiadujacyWierzcholek : graf.krawedzie(current)) {
                if (!odwiedzoneWierzcholki.contains(sasiadujacyWierzcholek)) {
                    queue.add(sasiadujacyWierzcholek);
                    odwiedzoneWierzcholki.add(sasiadujacyWierzcholek);
                }
            }
        }
        return spojnaSkladowa;
    }

    public static void main(String[] args) {
        Set<String> wierzcholki = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        Map<Pair<String, String>, String> krawedzie = new HashMap<>();
        krawedzie.put(new Pair<>("A", "B"), "Edge1");
        krawedzie.put(new Pair<>("B", "C"), "Edge2");
        krawedzie.put(new Pair<>("C", "A"), "Edge3");
        krawedzie.put(new Pair<>("D", "E"), "Edge4");
        krawedzie.put(new Pair<>("E", "F"), "Edge5");

        Graf<String, String> graf = new Graf<>(wierzcholki, krawedzie);

        List<List<String>> spojneSkladowe = getSpojneSkadowe(graf);

        System.out.println("Spojne składowe grafu:");
        for (List<String> skladowaX : spojneSkladowe) {
            System.out.println(skladowaX);
        }
    }
}

import java.util.*;

public class SpojneSkladoweGrafu {
//    Graf jest spójny, gdy istnieje droga w grafie pomiędzy każdą parą wierzchołków.
//    Wierzchołki nazywamy sąsiednie, jeśli istnieje krawędź (skierowana lub nieskierowana) pomiędzy nimi.
    public static <W, S> List<List<W>> getSpojneSkladowe(IGraf<W, S> graf) {
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

    public static <W> void printSpojneSkladowe(List<List<W>> spojneSkladowe) {
        System.out.print("Spojne składowe grafu: ");
        for (List<W> skladowaX : spojneSkladowe) {
            System.out.print(skladowaX + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test1
        System.out.println("\n ---Test1");
        Set<String> wierzcholki1 = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        Map<Edge<String, String>, String> krawedzie1 = new HashMap<>();
        krawedzie1.put(new Edge<>("A", "B"), "Edge1");
        krawedzie1.put(new Edge<>("B", "C"), "Edge2");
        krawedzie1.put(new Edge<>("C", "A"), "Edge3");
        krawedzie1.put(new Edge<>("D", "E"), "Edge4");
        krawedzie1.put(new Edge<>("E", "F"), "Edge5");
        Graf<String, String> graf1 = new Graf<>(wierzcholki1, krawedzie1);
        printSpojneSkladowe(getSpojneSkladowe(graf1));

        // Test2
        System.out.println("\n ---Test2");
        Set<String> wierzcholki2 = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        Map<Edge<String, String>, String> krawedzie2 = new HashMap<>();
        krawedzie2.put(new Edge<>("A", "B"), "Edge1");
        krawedzie2.put(new Edge<>("C", "D"), "Edge3");
        krawedzie2.put(new Edge<>("E", "F"), "Edge5");
        Graf<String, String> graf2 = new Graf<>(wierzcholki2, krawedzie2);
        printSpojneSkladowe(getSpojneSkladowe(graf2));

        // Test3
        System.out.println("\n ---Test3");
        Set<String> wierzcholki3 = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        Map<Edge<String, String>, String> krawedzie3 = new HashMap<>();
        krawedzie3.put(new Edge<>("A", "B"), "Edge1");
        krawedzie3.put(new Edge<>("B", "C"), "Edge2");
        krawedzie3.put(new Edge<>("C", "D"), "Edge3");
        krawedzie3.put(new Edge<>("D", "A"), "Edge4");
        krawedzie3.put(new Edge<>("E", "F"), "Edge5");
        Graf<String, String> graf3 = new Graf<>(wierzcholki3, krawedzie3);
        printSpojneSkladowe(getSpojneSkladowe(graf3));

        // Test4
        System.out.println("\n ---Test4");
        Set<String> wierzcholki4 = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        Map<Edge<String, String>, String> krawedzie4 = new HashMap<>();
        krawedzie4.put(new Edge<>("A", "B"), "Edge1");
        krawedzie4.put(new Edge<>("B", "C"), "Edge2");
        krawedzie4.put(new Edge<>("C", "D"), "Edge3");
        krawedzie4.put(new Edge<>("D", "E"), "Edge4");
        krawedzie4.put(new Edge<>("F", "B"), "Edge5");
        Graf<String, String> graf4 = new Graf<>(wierzcholki4, krawedzie4);
        printSpojneSkladowe(getSpojneSkladowe(graf4));

        // Test5
        System.out.println("\n ---Test5");
        Set<String> wierzcholki5 = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        Map<Edge<String, String>, String> krawedzie5 = new HashMap<>();
        Graf<String, String> graf5 = new Graf<>(wierzcholki5, krawedzie5);
        printSpojneSkladowe(getSpojneSkladowe(graf5));


    }
}

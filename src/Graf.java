import java.util.*;

public class Graf<W, S> implements IGraf<W, S> {
    //Używamy SET bo wierzchołki nie mogą powtarzać się
    private final Set<W> wierzcholki;
    //Używamy MAP z key: Para<początkowy wierzchołek, końcowy wierzchołek>
    private final Map<Edge<W, W>, S> krawedzie;

    public Graf(Set<W> wierzcholki, Map<Edge<W, W>, S> krawedzie) {
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
        S result = krawedzie.getOrDefault(new Edge<>(w1, w2), null);
        return result;
    }

    @Override
    public List<W> krawedzie(W w) {
        List<W> sasiedzi = new ArrayList<>();
        for (Map.Entry<Edge<W, W>, S> entry : krawedzie.entrySet()) {
            if (entry.getKey().getPoczatkowy().equals(w)) {
                sasiedzi.add(entry.getKey().getKoncowy());
            }
            if (entry.getKey().getKoncowy().equals(w)) {
                sasiedzi.add(entry.getKey().getPoczatkowy());
            }
        }
        return sasiedzi;
    }

    public static void main(String[] args) {
        //Test1 W-Integer, S - String
        System.out.println("\n ---Test1");
        Set<Integer> wierzcholki1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Map<Edge<Integer, Integer>, String> krawedzie1 = new HashMap<>();
        krawedzie1.put(new Edge<>(1, 2), "Edge1");
        krawedzie1.put(new Edge<>(2, 3), "Edge2");
        krawedzie1.put(new Edge<>(3, 4), "Edge3");
        krawedzie1.put(new Edge<>(1, 4), "Edge4");
        Graf<Integer, String> graf1 = new Graf<>(wierzcholki1, krawedzie1);
        System.out.println("Wierzchołki: " + graf1.wierzcholki());
        System.out.println("Krawędź A-B: " + graf1.krawedz(1, 2));
        System.out.println("Wierzchołki połączone z A: " + graf1.krawedzie(1));
        var spojneSkladowe1 = SpojneSkladoweGrafu.getSpojneSkladowe(graf1);
        SpojneSkladoweGrafu.printSpojneSkladowe(spojneSkladowe1);

        //Test2 W-Character, S - Integer
        System.out.println("\n ---Test2");
        Set<Character> wierzcholki2 = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd'));
        Map<Edge<Character, Character>, Integer> krawedzie2 = new HashMap<>();
        krawedzie2.put(new Edge<>('a', 'b'), 1);
        krawedzie2.put(new Edge<>('b', 'c'), 2);
        krawedzie2.put(new Edge<>('c', 'd'), 3);
        krawedzie2.put(new Edge<>('a', 'd'), 4);
        Graf<Character, Integer> graf2 = new Graf<>(wierzcholki2, krawedzie2);
        System.out.println("Wierzchołki: " + graf2.wierzcholki());
        System.out.println("Krawędź 'a'-'a': " + graf2.krawedz('a', 'b'));
        System.out.println("Wierzchołki połączone z 'a': " + graf2.krawedzie('a'));
        var spojneSkladowe2 = SpojneSkladoweGrafu.getSpojneSkladowe(graf2);
        SpojneSkladoweGrafu.printSpojneSkladowe(spojneSkladowe2);

        //Test3 W-String, S - String
        System.out.println("\n ---Test3");
        Set<String> wierzcholki3 = new HashSet<>(Arrays.asList("StringA", "StringB", "StringC", "StringD"));
        Map<Edge<String, String>, String> krawedzie3 = new HashMap<>();
        krawedzie3.put(new Edge<>("StringA", "StringB"), "Edge1");
        krawedzie3.put(new Edge<>("StringB", "StringC"), "Edge2");
        krawedzie3.put(new Edge<>("StringC", "StringD"), "Edge3");
        krawedzie3.put(new Edge<>("StringA", "StringD"), "Edge4");
        Graf<String, String> graf3 = new Graf<>(wierzcholki3, krawedzie3);
        System.out.println("Wierzchołki: " + graf3.wierzcholki());
        System.out.println("Krawędź StringA-StringB: " + graf3.krawedz("StringA", "StringB"));
        System.out.println("Wierzchołki połączone z StringA: " + graf3.krawedzie("StringA"));
        var spojneSkladowe3 = SpojneSkladoweGrafu.getSpojneSkladowe(graf3);
        SpojneSkladoweGrafu.printSpojneSkladowe(spojneSkladowe3);

        //Test4 W-City, S - String
        System.out.println("\n ---Test4");
        City city1 = new City("Warszawa");
        City city2 = new City("Wroclaw");
        City city3 = new City("Poznan");
        City city4 = new City("Krakow");
        Set<City> wierzcholki4 = new HashSet<>(Arrays.asList(city1, city2, city3, city4));
        Edge<City, City> droga1 = new Edge<>(city1, city2);
        Edge<City, City> droga2 = new Edge<>(city2, city3);
        Edge<City, City> droga3 = new Edge<>(city3, city4);
        Edge<City, City> droga4 = new Edge<>(city1, city4);
        Map<Edge<City, City>, String> krawedzie4 = new HashMap<>();
        krawedzie4.put(droga1, droga1.getDroga());
        krawedzie4.put(droga2, droga2.getDroga());
        krawedzie4.put(droga3, droga3.getDroga());
        krawedzie4.put(droga4, droga4.getDroga());
        Graf<City, String> graf4 = new Graf<>(wierzcholki4, krawedzie4);
        System.out.println("Wierzchołki: " + graf4.wierzcholki());
        System.out.println("Krawędź city1-city2: " + graf4.krawedz(city1, city2));
        System.out.println("Wierzchołki połączone z city1: " + graf4.krawedzie(city1));
        var spojneSkladowe4 = SpojneSkladoweGrafu.getSpojneSkladowe(graf4);
        SpojneSkladoweGrafu.printSpojneSkladowe(spojneSkladowe4);
    }
}

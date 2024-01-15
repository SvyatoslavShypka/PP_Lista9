import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GrafTests {
    private Graf<String, String> graf;

    @Test
    void wierzcholki() {
        List<String> expected = Arrays.asList("A", "B", "C", "D");
        List<String> actual = graf.wierzcholki();

        assertEquals(expected, actual);
    }

    @Test
    void krawedzIstniejaca() {
        String expected = "Edge1";
        var actual = graf.krawedz("A", "B");

        assertEquals(expected, actual);
    }

    @Test
    void krawedzNieistniejaca() {
        var actual = graf.krawedz("A", "C");

        assertNull(actual);
    }

    @Test
    void krawedzie() {
        List<String> expected = Arrays.asList("B", "D");
        var actual = graf.krawedzie("A");

        assertEquals(expected, actual);
    }

    @Test
    void krawedzieNieistniejacyWierzcholek() {
        List<String> expected = new ArrayList<>();
        var actual = graf.krawedzie("F");

        assertEquals(expected, actual);
    }

    @BeforeEach
    public void createTestGraph() {
        this.graf = new Graf<>(createWierzcholki(),createTestEdges());
    }

    private Set<String> createWierzcholki() {
        Set<String> wierzcholki = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        return wierzcholki;
    }

    private Map<Pair<String, String>, String> createTestEdges() {
        Map<Pair<String, String>, String> krawedzie = new HashMap<>();
        krawedzie.put(new Pair<>("A", "B"), "Edge1");
        krawedzie.put(new Pair<>("B", "C"), "Edge2");
        krawedzie.put(new Pair<>("C", "D"), "Edge3");
        krawedzie.put(new Pair<>("A", "D"), "Edge4");
        return krawedzie;
    }

/*
    private class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }
    }
*/

}
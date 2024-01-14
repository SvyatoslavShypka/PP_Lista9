import java.util.List;

public interface IGraf<W, S> {
    List<W> wierzcholki(); //zwraca wszystkie wierzchołki grafu
    S krawedz(W w1, W w2); //pobiera etykietę krawędzi pomiędzy wierzchołkami
    //wartość NULL oznacza brak krawędzi
    List<W> krawedzie(W w); //zwraca wierzchołki, do których istnieje krawędź z w
}

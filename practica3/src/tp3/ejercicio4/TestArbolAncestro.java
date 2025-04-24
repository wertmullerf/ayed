package tp3.ejercicio4;
import tp3.ejercicio1_3.GeneralTree;
public class TestArbolAncestro {
    public static void main(String[] args) {
        GeneralTree<String> d = new GeneralTree<>("D");
        GeneralTree<String> e = new GeneralTree<>("E");

        GeneralTree<String> b = new GeneralTree<>("B");
        b.addChild(d);
        b.addChild(e);

        GeneralTree<String> c = new GeneralTree<>("C");

        GeneralTree<String> a = new GeneralTree<>("A");
        a.addChild(b);
        a.addChild(c);

        GeneralTree<String> vacio = new GeneralTree<>(null);
        System.out.println("A es ancestro de E: " + a.esAncestro("A", "E")); // true
        System.out.println("B es ancestro de D: " + a.esAncestro("B", "D")); // true
        System.out.println("B es ancestro de C: " + a.esAncestro("B", "C")); // false
        System.out.println("C es ancestro de E: " + a.esAncestro("C", "E")); // false
        System.out.println("C es ancestro de E: " + vacio.esAncestro("CT", "E")); // false --> probando cuando es null o vacio

    }
}

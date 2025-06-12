package tp5.ejercicio2;

import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

import java.util.List;

import tp5.ejercicio1.Edge;
public class TestRecorridos {
	public static void main(String[] args) {
        // Crear el grafo
        AdjListGraph<String> grafo = new AdjListGraph<>();

        // Crear vértices
        Vertex<String> a = grafo.createVertex("A");
        Vertex<String> b = grafo.createVertex("B");
        Vertex<String> c = grafo.createVertex("C");
        Vertex<String> d = grafo.createVertex("D");

        // Conectar vértices
        grafo.connect(a, b, 5);
        grafo.connect(a, c, 3);
        grafo.connect(b, d, 2);
        grafo.connect(c, d, 7);
        grafo.connect(d, a, 4); // Para probar vuelta o conexión en otra dirección
        
        Recorridos<String> r = new Recorridos<>();
        List<String> resultado = r.dfs(grafo);
        System.out.println(resultado);
	}
}

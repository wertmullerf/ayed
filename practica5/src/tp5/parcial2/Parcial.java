package tp5.parcial2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;
import tp5.parcial1.Ciudad;

public class Parcial {

	public List<String> estadios(Graph<String> mapaEstadios, String estadioOrigen, int cantKm){
		//busca la entrada
		
		List<String> camino = new LinkedList<>();
		if(mapaEstadios != null && !mapaEstadios.isEmpty()) {
			Vertex<String> origen = mapaEstadios.search(estadioOrigen);
			if(origen != null) {
				List<String> caminoAux = new LinkedList<>();
				boolean[] marcas = new boolean[mapaEstadios.getSize()];
				resolver(mapaEstadios, origen, cantKm, marcas, camino, caminoAux);
			}
		}

		return camino;
	}
	
	private void resolver(Graph<String> mapa, Vertex<String> actual, int cantKm, boolean[] marcas, List<String> camino, List<String> caminoAux) {
	    caminoAux.add(actual.getData());
	    marcas[actual.getPosition()] = true;

	    // ✅ Actualizo la mejor solución si corresponde
	    if (caminoAux.size() > camino.size()) {
	    	camino.clear();
	    	camino.addAll(caminoAux);
	    }
	    
	    // ✅ Recorro los vecinos
	    for (Edge<String> e : mapa.getEdges(actual)) {
	        Vertex<String> vecino = e.getTarget();
	        int km = e.getWeight();
	        
	        if ((!marcas[vecino.getPosition()]) && (km <= cantKm)) {
	            resolver(mapa, vecino, (cantKm - km), marcas, camino, caminoAux);
	        }
	    }

	    // ✅ Backtracking
	    caminoAux.remove(caminoAux.size() - 1);
	    marcas[actual.getPosition()] = false;

	}
	
	public static void main(String[] args) {
	    Graph<String> mapaEstadios = new AdjListGraph<>();
	    
	    // Creamos los vértices
	    mapaEstadios.createVertex("A");
	    mapaEstadios.createVertex("B");
	    mapaEstadios.createVertex("C");
	    mapaEstadios.createVertex("D");
	    
	    // Conectamos los estadios con sus distancias
	    Vertex<String> a = mapaEstadios.search("A");
	    Vertex<String> b = mapaEstadios.search("B");
	    Vertex<String> c = mapaEstadios.search("C");
	    Vertex<String> d = mapaEstadios.search("D");
	    
	    mapaEstadios.connect(a, b, 10);
	    mapaEstadios.connect(b, a, 10);
	    mapaEstadios.connect(a, c, 10);
	    mapaEstadios.connect(c, a, 10);
	    mapaEstadios.connect(b, c, 20);
	    mapaEstadios.connect(c, b, 20);
	    mapaEstadios.connect(d, c, 30);
	    mapaEstadios.connect(c, d, 30);
	    // Ejecutamos el algoritmo
	    Parcial instancia = new Parcial();
	    List<String> resultado = instancia.estadios(mapaEstadios, "D", 40);
	    
	    // Imprimimos el resultado
	    System.out.println(resultado);
	}
}

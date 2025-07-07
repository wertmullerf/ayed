package tp5.parcial3;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {

	public List<CaminoConDistancia> resolver(Graph<String> sitios, String origen, String destino, String evitarPasarPor){
		List<CaminoConDistancia> resultado = new LinkedList<CaminoConDistancia>();
		if(sitios  != null && !sitios.isEmpty()) {
			Vertex<String> origenVertex = sitios.search(origen);
			Vertex<String> destinoVertex = sitios.search(destino);
			
			if(origenVertex != null && destinoVertex != null) {
	            boolean[] marcas = new boolean[sitios.getSize()];
	            List<String> caminoActual = new LinkedList<>();

	            buscarCaminos(sitios, origenVertex, destinoVertex, marcas, evitarPasarPor, caminoActual, resultado, 0);
	           
			}
		}
		
		return resultado;
		
	}
	
	
	private void buscarCaminos(Graph<String> sitios, Vertex<String> actual, Vertex<String> destino, boolean[] marcas, String evitar, 
								List<String> caminoActual, List<CaminoConDistancia> resultado, int cantCalles) {
		
		caminoActual.add(actual.getData());
		marcas[actual.getPosition()] = true;
		
		if(actual.getData().equals(destino.getData())) {
			resultado.add(new CaminoConDistancia(caminoActual, cantCalles));
		}else {
	        for (Edge<String> e : sitios.getEdges(actual)) {
	            Vertex<String> vecino = e.getTarget();
	            String nombreVecino = vecino.getData();
	            int peso = e.getWeight();
	            
	            if (!marcas[vecino.getPosition()] && !nombreVecino.equals(evitar)) {
	                buscarCaminos(sitios, vecino, destino,marcas, evitar,  caminoActual, resultado, (cantCalles + peso));
	            }
	        }
		}
	    caminoActual.remove(caminoActual.size() - 1);
	    marcas[actual.getPosition()] = false;
	}
	
	// Método auxiliar para conectar doblemente (NO dirigido)
	public static void conectar(Graph<String> grafo, Vertex<String> v1, Vertex<String> v2, int peso) {
	    grafo.connect(v1, v2, peso);
	    grafo.connect(v2, v1, peso);
	}
	public static void main(String[] args) {
	    Graph<String> grafo = new AdjListGraph<>();

	    // Creamos los vértices
	    grafo.createVertex("Estadio Unico");
	    grafo.createVertex("Coliseo Podesta");
	    grafo.createVertex("Palacio Campodonico");
	    grafo.createVertex("Catedral La Plata");
	    grafo.createVertex("Rectorado UNLP");
	    grafo.createVertex("Museo UNLP");
	    grafo.createVertex("Legislatura");
	    grafo.createVertex("MACLA");

	    // Buscamos los vértices
	    Vertex<String> estadio = grafo.search("Estadio Unico");
	    Vertex<String> coliseo = grafo.search("Coliseo Podesta");
	    Vertex<String> palacio = grafo.search("Palacio Campodonico");
	    Vertex<String> catedral = grafo.search("Catedral La Plata");
	    Vertex<String> rectorado = grafo.search("Rectorado UNLP");
	    Vertex<String> museo = grafo.search("Museo UNLP");
	    Vertex<String> legislatura = grafo.search("Legislatura");
	    Vertex<String> macla = grafo.search("MACLA");

	    // Conectamos las aristas (doble conexión por ser NO dirigido)
	    conectar(grafo, estadio, legislatura, 20);
	    conectar(grafo, estadio, coliseo, 25);
	    conectar(grafo, estadio, macla, 35);
	    conectar(grafo, estadio, catedral, 40);
	    conectar(grafo, legislatura, coliseo, 25);
	    conectar(grafo, coliseo, palacio, 10);
	    conectar(grafo, palacio, rectorado, 30);
	    conectar(grafo, palacio, museo, 15);
	    conectar(grafo, rectorado, catedral, 5);
	    conectar(grafo, macla, catedral, 8);
	    
	    Parcial p = new Parcial();
	    List<CaminoConDistancia> resultado = p.resolver(grafo, estadio.getData() ,rectorado.getData(), catedral.getData());
	    for(CaminoConDistancia r: resultado) {
	    	System.out.println(r.getCamino() + " DISTANCIA: " + r.getDistancia());
	    }
	    
	}


}

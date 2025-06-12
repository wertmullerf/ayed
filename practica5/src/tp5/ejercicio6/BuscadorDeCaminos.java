package tp5.ejercicio6;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class BuscadorDeCaminos {
	
	
	Graph<String> bosque;
	public BuscadorDeCaminos(Graph<String> bosque) {
		this.bosque = bosque;
	}
	public List<List<String>> recorridosMasSeguro(){
		List<List<String>> camino = new LinkedList<>();
		if(bosque != null && !bosque.isEmpty()) {
			List<String> caminoAux = new LinkedList<>();
			Vertex<String> origen = bosque.search("Casa Caperucita");
			Vertex<String> destino = bosque.search("Casa Abuelita");
			
			buscarCamino(origen,destino,camino,caminoAux,new boolean[bosque.getSize()],5);

		}
		return camino;
	}
	
	private void buscarCamino(Vertex<String> actual,Vertex<String> destino, 
			 					List<List<String>> camino,List<String> caminoAux, 
			 					boolean[] marcas,int limite ) {
		
		marcas[actual.getPosition()] =true;
		caminoAux.add(actual.getData());
		
		if(actual == destino) {
			camino.add(new LinkedList<>(caminoAux));
		}else {
            List<Edge<String>> adyacentes = bosque.getEdges(actual);
            for(Edge<String> a: adyacentes) {
                Vertex<String> siguiente = a.getTarget();
                if(!marcas[siguiente.getPosition()] && a.getWeight() < limite) 
                    buscarCamino(siguiente, destino, camino,caminoAux,marcas,limite);
            }
		}
		
		caminoAux.remove(caminoAux.size()-1);
		marcas[actual.getPosition()] =false;
	}
	
	
	public static void main(String[]args) {
		AdjListGraph<String> bosque = new AdjListGraph<>();

		// Crear vértices
		Vertex<String> caperucita = bosque.createVertex("Casa Caperucita");
		Vertex<String> claro1 = bosque.createVertex("Claro 1");
		Vertex<String> claro2 = bosque.createVertex("Claro 2");
		Vertex<String> claro3 = bosque.createVertex("Claro 3");
		Vertex<String> claro4 = bosque.createVertex("Claro 4");
		Vertex<String> claro5 = bosque.createVertex("Claro 5");
		Vertex<String> abuelita = bosque.createVertex("Casa Abuelita");

		// Conectar (aristas con peso = cantidad de árboles frutales)
		bosque.connect(caperucita, claro1, 3);
		bosque.connect(claro1, caperucita, 3);

		bosque.connect(caperucita, claro2, 4);
		bosque.connect(claro2, caperucita, 4);

		bosque.connect(caperucita, claro3, 4);
		bosque.connect(claro3, caperucita, 4);

		bosque.connect(claro1, claro2, 4);
		bosque.connect(claro2, claro1, 4);

		bosque.connect(claro1, claro5, 3);
		bosque.connect(claro5, claro1, 3);

		bosque.connect(claro2, claro4, 10);
		bosque.connect(claro4, claro2, 10);

		bosque.connect(claro2, claro5, 11);
		bosque.connect(claro5, claro2, 11);

		bosque.connect(claro3, claro5, 15);
		bosque.connect(claro5, claro3, 15);

		bosque.connect(claro5, abuelita, 4);
		bosque.connect(abuelita, claro5, 4);

		bosque.connect(claro4, abuelita, 9);
		bosque.connect(abuelita, claro4, 9);

		BuscadorDeCaminos dfs = new BuscadorDeCaminos(bosque);
		
		List<List<String>> resultado = dfs.recorridosMasSeguro();
		System.out.println(resultado);
	}
}

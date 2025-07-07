package tp5.parcial1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {
	
	public List<String> resolver(Graph<Ciudad> mapa, String ciudad, int cantDiasVacas ){
		
		//busca la entrada
		List<Vertex<Ciudad>> l = mapa.getVertices();
		Iterator<Vertex<Ciudad>> it = l.iterator();
		
		Vertex<Ciudad> aux, entrada = null;
		while(it.hasNext() && entrada == null) {
			aux = it.next();
			if(aux.getData().getNombre().equals(ciudad)) {
				entrada = aux;
			}
		}
		List<String> camino = new LinkedList<>();
		if(entrada != null) {

			boolean[] marcas = new boolean[l.size()];
			List<String> caminoAux = new LinkedList<>();
			resolver(mapa, entrada, cantDiasVacas, marcas, camino, caminoAux);
		}
		return camino;
	}
	
	private void resolver(Graph<Ciudad> mapa, Vertex<Ciudad> entrada, int dias, boolean[] marcas, List<String> camino, List<String> caminoAux ) {
		marcas[entrada.getPosition()] = true;
		caminoAux.add(entrada.getData().getNombre());
		dias = dias - entrada.getData().getCantidadDeDias();
		if(dias < entrada.getData().getCantidadDeDias()) {
			if(caminoAux.size() > camino.size()) {
				camino.clear();
				camino.addAll(caminoAux);
			}
		}else {
			
			List<Edge<Ciudad>> vecinos = mapa.getEdges(entrada);
			
			for(Edge<Ciudad> edge: vecinos ) {
				Vertex<Ciudad> vecino = edge.getTarget();
				int tiempoVecino = vecino.getData().getCantidadDeDias();
				
				if((tiempoVecino <= dias)&&(!marcas[vecino.getPosition()])) {
					resolver(mapa, vecino, (dias - tiempoVecino), marcas,camino, caminoAux);
				}
				
			}
		}
		caminoAux.remove(caminoAux.size() - 1);
		marcas[entrada.getPosition()] = false;
	}
	
	
	public static void main(String[]args) {
		Graph<Ciudad> mapa = new AdjListGraph<>();

		Vertex<Ciudad> mdq = mapa.createVertex(new Ciudad("Mar del Plata", 7));
		Vertex<Ciudad> azul = mapa.createVertex(new Ciudad("Mar Azul", 3));
		Vertex<Ciudad> gaviotas = mapa.createVertex(new Ciudad("Las Gaviotas", 1));
		Vertex<Ciudad> querandi = mapa.createVertex(new Ciudad("Querandi", 1));
		Vertex<Ciudad> pina = mapa.createVertex(new Ciudad("Pina", 4));
		Vertex<Ciudad> madariaga = mapa.createVertex(new Ciudad("Madariaga", 1));
		Vertex<Ciudad> dolores = mapa.createVertex(new Ciudad("Dolores", 1));
		Vertex<Ciudad> pila = mapa.createVertex(new Ciudad("Pila", 1));
		Vertex<Ciudad> chasco = mapa.createVertex(new Ciudad("Chascomus", 1));
		Vertex<Ciudad> laPlata = mapa.createVertex(new Ciudad("La Plata", 5));
		Vertex<Ciudad> hudson = mapa.createVertex(new Ciudad("Hudson", 1));

		// Ahora conectamos (asumimos grafo no dirigido)
		mapa.connect(mdq, azul);
		mapa.connect(azul, mdq);

		mapa.connect(azul, gaviotas);
		mapa.connect(gaviotas, azul);

		mapa.connect(azul, querandi);
		mapa.connect(querandi, azul);

		mapa.connect(azul, pina);
		mapa.connect(pina, azul);

		mapa.connect(pina, madariaga);
		mapa.connect(madariaga, pina);
 
		mapa.connect(madariaga, dolores);
		mapa.connect(dolores, madariaga);

		mapa.connect(dolores, pila);
		mapa.connect(pila, dolores);

		mapa.connect(dolores, chasco);
		mapa.connect(chasco, dolores);

		mapa.connect(chasco, laPlata);
		mapa.connect(laPlata, chasco);

		mapa.connect(laPlata, hudson);
		mapa.connect(hudson, laPlata);

		Parcial p = new Parcial();
		List<String> camino = p.resolver(mapa, "Querandi", 4);
		System.out.println(camino);
	}
}

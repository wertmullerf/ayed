package tp5.ejercicio4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;
import tp5.ejercicio3.CaminoWrapper;

public class Bicisenda {
	public List<String>paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
		List<String> camino = null;
	    if (lugares != null && !lugares.isEmpty()) {
	    	camino = new LinkedList<>();
	        Vertex origen = lugares.search("Ayuntamiento");
	        Vertex destinoV = lugares.search(destino);
	        if (origen != null && destinoV!= null) {
	        	buscarCamino(lugares,origen, destinoV, camino, new boolean[lugares.getSize()],0, maxTiempo, lugaresRestringidos);
	        }
	    }
	    return camino;
	}
	
	private boolean buscarCamino(Graph<String> lugares, Vertex<String> actual,Vertex<String> destino,
					List<String> camino, boolean[] marcas, int tiempoAcumulado, int maxTiempo, List<String> prohibidos) {
		
		boolean encontre = false;
		marcas[actual.getPosition()] = true;
		camino.add(actual.getData());
		if(actual == destino) {
			return true;
		}else {
			List<Edge<String>> adyacentes = lugares.getEdges(actual); //adyacentes
			
			Iterator<Edge<String>> it = adyacentes.iterator();
			while(it.hasNext() && !encontre) {
				Edge<String> v = it.next();
				int nuevoTiempo = tiempoAcumulado + v.getWeight();
			
				if(!marcas[v.getTarget().getPosition()] && nuevoTiempo <= maxTiempo && !prohibidos.contains(v.getTarget().getData())) {		
					encontre = buscarCamino(lugares,v.getTarget(), destino,camino,marcas,nuevoTiempo,maxTiempo,prohibidos );
				}
			}
		}
		if(!encontre) {
			//si  no encontre --> backtracking
			camino.remove(camino.size()-1);
			
		}
		marcas[actual.getPosition()] = false;
		return encontre;
	}
	
	
	public static void main(String[]args) {
		AdjListGraph<String> grafo = new AdjListGraph<>();

		// Crear vértices
		Vertex<String> ayuntamiento = grafo.createVertex("Ayuntamiento");
		Vertex<String> elTigre = grafo.createVertex("ElTigre");
		Vertex<String> museoMunch = grafo.createVertex("MuseoMunch");
		Vertex<String> parqueBotanico = grafo.createVertex("ParqueBotanico");
		Vertex<String> galeriaNacional = grafo.createVertex("GaleriaNacional");
		Vertex<String> parqueVigeland = grafo.createVertex("ParqueVigeland");
		Vertex<String> folkMuseum = grafo.createVertex("FolkMuseum");
		Vertex<String> museoFram = grafo.createVertex("MuseoFram");
		Vertex<String> museoBarcoPolar = grafo.createVertex("MuseoDelBarcoPolar");
		Vertex<String> museoVikingo = grafo.createVertex("MuseoVikingo");
		Vertex<String> akkerBrigge = grafo.createVertex("AkkerBrigge");
		Vertex<String> palacioReal = grafo.createVertex("PalacioReal");
		Vertex<String> laOpera = grafo.createVertex("LaOpera");
		Vertex<String> fortalezaAkershus = grafo.createVertex("FortalezaAkershus");
		Vertex<String> holmenkollen = grafo.createVertex("Holmenkollen");

		// Crear conexiones (grafo NO dirigido, así que conectamos en ambas direcciones)
		grafo.connect(ayuntamiento, parqueBotanico, 10);
		grafo.connect(parqueBotanico, ayuntamiento, 10);

		grafo.connect(parqueBotanico, museoMunch, 1);
		grafo.connect(museoMunch, parqueBotanico, 1);

		grafo.connect(ayuntamiento, elTigre, 15);
		grafo.connect(elTigre, ayuntamiento, 15);

		grafo.connect(elTigre, museoMunch, 15);
		grafo.connect(museoMunch, elTigre, 15);

		grafo.connect(elTigre, laOpera, 5);
		grafo.connect(laOpera, elTigre, 5);

		grafo.connect(laOpera, fortalezaAkershus, 10);
		grafo.connect(fortalezaAkershus, laOpera, 10);

		grafo.connect(ayuntamiento, palacioReal, 5);
		grafo.connect(palacioReal, ayuntamiento, 5);

		//grafo.connect(palacioReal, galeriaNacional, 5);
		//grafo.connect(galeriaNacional, palacioReal, 5);

		grafo.connect(ayuntamiento, akkerBrigge, 20);
		grafo.connect(akkerBrigge, ayuntamiento, 20);

		grafo.connect(akkerBrigge, museoVikingo, 30);
		grafo.connect(museoVikingo, akkerBrigge, 30);

		grafo.connect(palacioReal, folkMuseum, 5);
		grafo.connect(folkMuseum, palacioReal, 5);

		grafo.connect(galeriaNacional, parqueVigeland, 10);
		grafo.connect(parqueVigeland, galeriaNacional, 10);

		grafo.connect(parqueVigeland, folkMuseum, 20);
		grafo.connect(folkMuseum, parqueVigeland, 20);

		grafo.connect(folkMuseum, museoFram, 5);
		grafo.connect(museoFram, folkMuseum, 5);

		grafo.connect(museoFram, museoBarcoPolar, 5);
		grafo.connect(museoBarcoPolar, museoFram, 5);

		grafo.connect(museoBarcoPolar, museoVikingo, 5);
		grafo.connect(museoVikingo, museoBarcoPolar, 5);

		grafo.connect(parqueVigeland, holmenkollen, 30);
		grafo.connect(holmenkollen, parqueVigeland, 30);

		
		grafo.connect(akkerBrigge, folkMuseum,30);
		grafo.connect(folkMuseum, akkerBrigge,30);
		
		grafo.connect(parqueBotanico, galeriaNacional, 15);
		grafo.connect(galeriaNacional, parqueBotanico, 15);
		
		Bicisenda b = new Bicisenda();
		List<String> prohibidos = new LinkedList<>();
		prohibidos.add("AkkerBrigge");
		prohibidos.add("PalacioReal");
		
		List<String> resultado = b.paseoEnBici(grafo, "MuseoVikingo", 120, prohibidos);
		System.out.println(resultado);
	}
}

package tp5.ejercicio3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Mapa {
	Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	//======================INCISO 1======================
	
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		List<String> camino = new LinkedList<String>();
        Vertex<String> origen = this.mapaCiudades.search(ciudad1);
        Vertex<String> destino = this.mapaCiudades.search(ciudad2);

        if (origen == null || destino == null) return camino;

        boolean[] visitado = new boolean[this.mapaCiudades.getSize()];

        boolean encontrado = devolverCamino(origen, destino, visitado, camino);

        if (encontrado) return camino;
        return new LinkedList<>(); // si no se encontró camino
	}
	
	private boolean devolverCamino(Vertex<String> actual, Vertex<String> destino, boolean[] visitado, List<String> camino) {
		visitado[actual.getPosition()] = true; //lo marco como verdadero
		camino.add(actual.getData());
		
		
		if(actual == destino) {
			return true;
		}
		
		
		List<Edge<String>> adyacentes = mapaCiudades.getEdges(actual); //adyacentes
		
		Iterator<Edge<String>> it = adyacentes.iterator();
		boolean encontre = false;
		while(it.hasNext() && !encontre) {
			Vertex<String> vecino = it.next().getTarget();
			if(!visitado[vecino.getPosition()]) {		
				
				encontre = devolverCamino(vecino, destino,visitado,camino);
			}
		}
		if(!encontre) {			
			camino.remove(camino.size() - 1);
		}
		return encontre;
	}
	
	//======================INCISO 2======================
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino = new LinkedList<String>();
        Vertex<String> origen = this.mapaCiudades.search(ciudad1);
        Vertex<String> destino = this.mapaCiudades.search(ciudad2);

        if (origen == null || destino == null) return camino;

        boolean[] visitado = new boolean[this.mapaCiudades.getSize()];

        boolean encontrado = devolverCaminoExceptuando(origen, destino, visitado, camino, ciudades);

        if (encontrado) return camino;
        return new LinkedList<>(); // si no se encontró camino
	}
	
	
	
	private boolean devolverCaminoExceptuando(Vertex<String> actual, Vertex<String> destino, boolean[] visitado, List<String> camino, List<String> prohibidos) {
		if(prohibidos.contains(actual.getData())) return false;
		
		visitado[actual.getPosition()] = true; //lo marco como verdadero
		camino.add(actual.getData());
		
		
		if(actual == destino) {
			return true;
		}
		
		
		List<Edge<String>> adyacentes = mapaCiudades.getEdges(actual); //adyacentes
		
		Iterator<Edge<String>> it = adyacentes.iterator();
		boolean encontre = false;
		while(it.hasNext() && !encontre) {
			Vertex<String> vecino = it.next().getTarget();
			if(!visitado[vecino.getPosition()] && !prohibidos.contains(vecino.getData())) {		
				
				encontre = devolverCaminoExceptuando(vecino, destino,visitado,camino,prohibidos);
			}
		}
		if(!encontre) {			
			camino.remove(camino.size() - 1);
		}
		return encontre;
	}
	
	
	//======================INCISO 3======================
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> camino = new LinkedList<String>();
        Vertex<String> origen = this.mapaCiudades.search(ciudad1);
        Vertex<String> destino = this.mapaCiudades.search(ciudad2);

        if (origen == null || destino == null) return camino;

        boolean[] visitado = new boolean[this.mapaCiudades.getSize()];

        caminoMasCorto(origen, destino, visitado, camino, new LinkedList<>(), new Maximo());

        return camino;
	}
	
	private void caminoMasCorto(Vertex<String> actual, Vertex<String> destino, boolean[] visitado, List<String> camino,List<String> lista, Maximo max) {
		visitado[actual.getPosition()] = true; 
		lista.add(actual.getData());
		
		
		if(actual == destino) {
			if(lista.size() < max.getMax()) {
				camino.clear();
				camino.addAll(lista);
				max.setMax(lista.size());
			}
		}else {
			List<Edge<String>> adyacentes = mapaCiudades.getEdges(actual); //adyacentes
			
			Iterator<Edge<String>> it = adyacentes.iterator();
			while(it.hasNext()) {
				Vertex<String> vecino = it.next().getTarget();
				if(!visitado[vecino.getPosition()]) {		
					caminoMasCorto(vecino, destino,visitado,camino,lista,max);
				}
			}
		
		}
		
		lista.remove(lista.size()-1);
		visitado[actual.getPosition()] = false; // CLAVE PARA EL BACKTRACKING
		
	}
	
	//======================INCISO 4======================
    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = null;
        if(!this.mapaCiudades.isEmpty()) {
        	camino = new LinkedList<>();
            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);
            if(origen != null && destino != null) {
            	caminoSinCargarCombustible(origen, destino, camino, new boolean[this.mapaCiudades.getSize()], tanqueAuto);
            }
        }
        return camino;
    }
	
	
	private boolean caminoSinCargarCombustible(Vertex<String> actual, Vertex<String> destino, List<String> camino, boolean[] marcas, int tanque ) {
		boolean encontre = false;
		marcas[actual.getPosition()] = true;
		camino.add(actual.getData());
		if(actual == destino) {
			return true;
		}else {
			List<Edge<String>> adyacentes = mapaCiudades.getEdges(actual); //adyacentes
			
			Iterator<Edge<String>> it = adyacentes.iterator();
			while(it.hasNext() && !encontre) {
				Edge<String> v = it.next();
				if(!marcas[v.getTarget().getPosition()] && tanque - v.getWeight() >= 0 ) {		
					encontre = caminoSinCargarCombustible(v.getTarget(), destino,camino,marcas,(tanque - v.getWeight()) );
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
	
	//======================INCISO 5======================
	public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
	    CaminoWrapper camino = null;
	    if (!this.mapaCiudades.isEmpty()) {
	        camino = new CaminoWrapper(tanqueAuto, Integer.MAX_VALUE);
	        
	        CaminoWrapper caminoAux = new CaminoWrapper(tanqueAuto);
	        Vertex origen = this.mapaCiudades.search(ciudad1);
	        Vertex destino = this.mapaCiudades.search(ciudad2);
	        if (origen != null && destino != null) {
	            caminoConMenorCargaDeCombustible(origen, destino, camino, caminoAux, new boolean[this.mapaCiudades.getSize()], tanqueAuto);
	        }
	    }

	    if (camino == null || camino.getCantTanquesCargados() == Integer.MAX_VALUE) {
	        return new LinkedList<>();
	    }
	    return camino.getCamino();
	}

	
	private void caminoConMenorCargaDeCombustible(Vertex<String> actual, Vertex<String> destino, CaminoWrapper camino, CaminoWrapper caminoAux, boolean[] marcas, int tanqueAuto) {
	    marcas[actual.getPosition()] = true;
        boolean aumenteTanque = false;
	    caminoAux.agregarCiudad(actual.getData());
	    System.out.println(caminoAux.getCamino());
	    if (actual == destino) {
	    	System.out.println("Camino Aux = " + caminoAux.getCantTanquesCargados());
	    	System.out.println("Camino= " + camino.getCantTanquesCargados());
	        if (caminoAux.getCantTanquesCargados() < camino.getCantTanquesCargados()) {
	            camino.copiarDesde(caminoAux);
	            caminoAux.setCantTanquesCargados(0);
	            System.out.println();
	        }
	    } else {
	        List<Edge<String>> adyacentes = mapaCiudades.getEdges(actual);
	        Iterator<Edge<String>> it = adyacentes.iterator();
	        while (it.hasNext()) {
	            Edge<String> v = it.next();
	            
	            if (!marcas[v.getTarget().getPosition()]) {
	                int tanqueAntes = caminoAux.getTanque();
	                int tanquesAntes = caminoAux.getCantTanquesCargados();
	                if (caminoAux.getTanque() - v.getWeight() <= 0) {
	                    caminoAux.incrementarTanquesUsados();
	                    caminoAux.recargarTanque(tanqueAuto);
	                }
	                caminoAux.decrementarTanque(v.getWeight());
	                caminoConMenorCargaDeCombustible(v.getTarget(), destino, camino, caminoAux, marcas, tanqueAuto);
	          
	                // Restaurar estado
	                caminoAux.recargarTanque(tanqueAntes);
	                caminoAux.setCantTanquesCargados(tanquesAntes);
	            }
	        }
	    }

	    caminoAux.getCamino().remove(caminoAux.getCamino().size() - 1);

	    marcas[actual.getPosition()] = false;
	}

	//======================MAIN======================
	public static void main(String[] args) {
		AdjListGraph<String> grafo = new AdjListGraph<>();

		Vertex<String> buenosAires = grafo.createVertex("BuenosAires");
		Vertex<String> rosario = grafo.createVertex("Rosario");
		Vertex<String> cordoba = grafo.createVertex("Cordoba");
		Vertex<String> marDelPlata = grafo.createVertex("MarDelPlata");
		Vertex<String> salta = grafo.createVertex("Salta");

		// Conexiones (sin pesos o con peso 1)
		grafo.connect(buenosAires, rosario,100);
		grafo.connect(buenosAires, marDelPlata,200);
		
		grafo.connect(rosario, cordoba,100);
		grafo.connect(cordoba, salta,0);
		
		grafo.connect(marDelPlata, salta,200);

		Mapa mapa = new Mapa(grafo);
//		
//		List<String> camino = mapa.devolverCamino("BuenosAires", "Salta");
//		System.out.println(camino);
//		
//		List<String> forbidden = new LinkedList<String>();
//		forbidden.add("BuenosAires");
//		List<String> camino2 = mapa.devolverCaminoExceptuando("BuenosAires", "Salta",forbidden);
//		System.out.println(camino2);
//		
//		List<String> camino3 = mapa.caminoMasCorto("BuenosAires", "Salta");
//		System.out.println(camino3);
//		
//		
//		List<String> camino4 = mapa.caminoSinCargarCombustible("BuenosAires", "Salta",200);
//		System.out.println(camino4);
		
		List<String> camino5 = mapa.caminoConMenorCargaDeCombustible("BuenosAires", "Salta", 200);
		System.out.println(camino5);
	}
}

package tp5.ejercicio5;

import java.util.List;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class BancoItau {
	
	//El método recibirá un Grafo<Persona>, un empleado y un grado de separación/distancia y debe retornar una
	//lista de hasta 40 jubilados que no hayan percibido la jubilación del mes y se encuentre a una distancia menor a
	//recibido como parámetro.
	
	public List<Jubilado> buscarJubilados(Graph<Persona> grafo, Empleado empleado, int grado){
		List<Jubilado> jubilados = new LinkedList<>();
		
		if(grafo != null && !grafo.isEmpty()) {
			Vertex<Persona> empV = buscarEmpleado(grafo, empleado.getNombre());
			if(empV != null) {
				Queue<Vertex<Persona>> cola = new LinkedList<>();
                boolean[] marcas = new boolean[grafo.getSize()];
                marcas[empV.getPosition()] = true;
                cola.offer(empV);
                cola.offer(null);
                while(!cola.isEmpty() && grado > 0 && jubilados.size() <= 40) {
                	Vertex<Persona>v = cola.poll();
                	if(v!= null) {
                        List<Edge<Persona>> adys = grafo.getEdges(v);
                        Iterator <Edge<Persona>> it = adys.iterator();
                        while(it.hasNext() && jubilados.size() <= 40) {
                            Vertex<Persona> vertDestino = it.next().getTarget();
                            int posDestino = vertDestino.getPosition();
                            if(!marcas[posDestino]) {
                            	marcas[posDestino]= true; //marco como visitado;
                            	cola.offer(vertDestino);
                            	if(vertDestino.getData() instanceof Jubilado) {
                            		Jubilado jubilado = (Jubilado) vertDestino.getData();
                            		if(!jubilado.cobroEsteMes()) {
                            			jubilados.add(jubilado);
     
                            		}
                            	}
                            }
                        }
                	}else if (!cola.isEmpty()) {
                		grado--;
                		cola.offer(null);
                	}
                }

			}
		}
		return jubilados;
	}

	private Vertex<Persona> buscarEmpleado(Graph<Persona> grafo, String nombre){
        List<Vertex<Persona>> vertices = grafo.getVertices();
        Iterator<Vertex<Persona>> it = vertices.iterator();
        Vertex<Persona> per = null;
        boolean sigo = true;
        while ((it.hasNext()) && (sigo)) {
            Vertex<Persona> aux = it.next();
            if(aux.getData().getNombre().equals(nombre)) {
                per = aux;
                sigo = false;
            }
        }
        return per;
	}
	
	
	public static void main(String[] args) {
		AdjListGraph<Persona> grafo = new AdjListGraph<>();

		// Crear personas
		Empleado e1 = new Empleado("Juan", "Calle 1");

		Jubilado j1 = new Jubilado("Ana", "Calle 2", false);  // NO cobró
		Jubilado j2 = new Jubilado("Luis", "Calle 3", true);   // Cobró
		Jubilado j3 = new Jubilado("Marta", "Calle 4", false); // NO cobró
		Jubilado j4 = new Jubilado("Carlos", "Calle 5", false);// NO cobró
		Jubilado j5 = new Jubilado("Rosa", "Calle 6", false);  // NO cobró

		// Crear vértices
		Vertex<Persona> vE1 = grafo.createVertex(e1);

		Vertex<Persona> vJ1 = grafo.createVertex(j1);
		Vertex<Persona> vJ2 = grafo.createVertex(j2);
		Vertex<Persona> vJ3 = grafo.createVertex(j3);
		Vertex<Persona> vJ4 = grafo.createVertex(j4);
		Vertex<Persona> vJ5 = grafo.createVertex(j5);

		// Conectar personas (relaciones)
		grafo.connect(vE1, vJ1); // Empleado → Jubilado 1
		grafo.connect(vE1, vJ2); // Empleado → Jubilado 2
		grafo.connect(vJ1, vJ3); // Jubilado 1 → Jubilado 3
		grafo.connect(vJ3, vJ4); // Jubilado 3 → Jubilado 4
		grafo.connect(vJ4, vJ5); // Jubilado 4 → Jubilado 5
		
		
		BancoItau b = new BancoItau();
		
		List<Jubilado> resultado = b.buscarJubilados(null, e1, 3);
		for(Jubilado jub: resultado) System.out.println(jub.getNombre());

	}
}

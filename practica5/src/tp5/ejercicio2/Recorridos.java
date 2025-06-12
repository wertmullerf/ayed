package tp5.ejercicio2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;import tp5.ejercicio1.Vertex;

public class Recorridos<T> {
	
	public List<T> dfs(Graph<T> grafo) {
		boolean[] marca = new boolean[grafo.getSize()];
		List<T> lista = new LinkedList<>();
		for (int i = 0; i < grafo.getSize(); i++) {
			if (!marca[i]) {
				dfs(i, grafo, marca, lista);
			}
		}
		return lista;
	}
	private void dfs(int i, Graph<T> grafo, boolean[] marca, List<T> lista) {
		marca[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		lista.add(v.getData()); // --> guardo la data
		List<Edge<T>> adyacentes = grafo.getEdges(v); //adyacentes
		for (Edge<T> e: adyacentes){
			int j = e.getTarget().getPosition();
			if (!marca[j]) {
				dfs(j, grafo, marca,lista);
			}
		}
	}
	
	
	public List<T> bfs(Graph<T> grafo) {
		boolean[] marca = new boolean[grafo.getSize()];
		List<T> lista = new LinkedList<>();
		for (int i = 0; i < grafo.getSize(); i++) {
			if (!marca[i]) {
				this.bfs(i, grafo, marca,lista);
			}
		}
		return lista;
	}
	
	private void bfs(int i, Graph<T> grafo, boolean[] marca,List<T> lista) {
		Queue<Vertex<T>> q = new LinkedList<Vertex<T>>();
		q.offer(grafo.getVertex(i));
		marca[i] = true;
		while (!q.isEmpty()) {
			Vertex<T> w = q.poll();
			lista.add(w.getData());
			// para todos los vecinos de w:
			List<Edge<T>> adyacentes = grafo.getEdges(w);
			for (Edge<T> e: adyacentes) {
				int j = e.getTarget().getPosition();
				if (!marca[j]) {
					marca[j] = true;
					//Vertex<T> v = e.getTarget();
					q.offer(e.getTarget());
				}
			}
		}
	}
}

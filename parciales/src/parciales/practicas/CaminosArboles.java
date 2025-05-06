package parciales.practicas;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import arbolesGenerales.GeneralTree;

public class CaminosArboles {

	
	public static List<Integer> primerCaminoTodosNegativos(GeneralTree<Integer> arbol){
		List<Integer> resultado = new LinkedList<Integer>();
		if(arbol != null && !arbol.isEmpty()) {
			buscarCaminoNegativo(arbol, resultado);
		}
		
		return resultado;
	}
	
	private static boolean buscarCaminoNegativo(GeneralTree<Integer> arbol, List<Integer> camino ) {
		boolean encontre = false;
		if(arbol.getData() < 0) {
			camino.add(arbol.getData());
			if(arbol.isLeaf()) {
				encontre = true; // es negativo y ya llegamos a la hoja;
			}else {
				Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
				while(!encontre && it.hasNext()) {
					encontre = buscarCaminoNegativo(it.next(), camino);
				}
				if(!encontre) {
					camino.remove(camino.size()-1);
				}
			}
		}
		
		return encontre;
	}




//========================================================================================================
	public static List<Integer> primerCaminoTodosNegativosOptimizado(GeneralTree<Integer> arbol){
		List<Integer> resultado = new LinkedList<Integer>();
		if(arbol != null && !arbol.isEmpty() && arbol.getData()< 0) {
			buscarCaminoNegativo(arbol, resultado);
		}
		
		return resultado;
	}
	
	private static boolean buscarCaminoNegativoOptimizado(GeneralTree<Integer> arbol, List<Integer> camino ) {
		boolean encontre = false;
		
		camino.add(arbol.getData());
		if(arbol.isLeaf()) {
			encontre = true; // es negativo y ya llegamos a la hoja;
		}else {
			Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
			while(!encontre && it.hasNext()) {
				GeneralTree<Integer> child = it.next();
				if(child.getData() < 0) {					
					encontre = buscarCaminoNegativoOptimizado(child, camino);
				}
			}
			if(!encontre) {
				camino.remove(camino.size()-1);
			}
		}
		
		
		return encontre;
	}

	
	
	
	//==============================EJEMPLO III==============================================================
	public static List<List<Integer>> todosLosCaminosConValoresEntre(GeneralTree<Integer> arbol, int min, int max){
		List<List<Integer>> resultado = new LinkedList<List<Integer>>();
		if(arbol != null && !arbol.isEmpty() && (arbol.getData() >= min && arbol.getData() <= max)) {
			buscarCaminoNegativo(arbol, resultado,new LinkedList<>(),min,max);
		}
		
		return resultado;
	}
	
	private static void buscarCaminoNegativo(GeneralTree<Integer> arbol, List<List<Integer>> caminoFinal, 
												List<Integer> caminoActual, int min, int max) {
;
		caminoActual.add(arbol.getData());
		if(arbol.isLeaf()) {
			caminoFinal.add(new LinkedList<Integer>(caminoActual));
		}else {
			for(GeneralTree<Integer> child: arbol.getChildren()) {
				if(child.getData() >= min && child.getData() <= max) {
					buscarCaminoNegativo(child, caminoFinal, caminoActual, min, max);
				}
			}
		}
		caminoActual.remove(caminoActual.size() -1);
	}
	
	//==============================EJEMPLO IV==============================================================
	public static List<Integer> buscarCaminoSumaMinima(GeneralTree<Integer> arbol){
		List<Integer> camino = new LinkedList<>();
		if(arbol != null && !arbol.isEmpty()) {
			calcularMinimo(arbol, camino, new LinkedList<>(), 0, Integer.MAX_VALUE);
		}
		return camino;
	}
	
	private static int calcularMinimo(GeneralTree<Integer> arbol, List<Integer> camino, List<Integer> listaAux, int sumaActual, int sumaMinima) {
		sumaActual+= arbol.getData();
		listaAux.add(arbol.getData());
		if(arbol.isLeaf()) {
			if(sumaActual < sumaMinima) {
				camino.clear();
				camino.addAll(listaAux);
				sumaMinima = sumaActual;
			}
		}else {
			for(GeneralTree<Integer> child: arbol.getChildren()) {
				sumaMinima= calcularMinimo(child, camino, listaAux, sumaActual, sumaMinima);				
			}
		}
		listaAux.remove(listaAux.size()-1);
		return sumaMinima;
	}
}

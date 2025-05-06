package parciales.parcial8;

import java.util.LinkedList;
import java.util.List;

import arbolesGenerales.GeneralTree;

public class Parcial8 {
	public List<String> resolver(int menor, int mayor, GeneralTree<Integer> arbol){
		List<String> cumplen = new LinkedList<String>();
		if(arbol != null && !arbol.isEmpty()) {
			buscarEntreRango(arbol,cumplen,menor,mayor,-1);
		}
		return cumplen;
	}
	
	private void buscarEntreRango(GeneralTree<Integer> arbol,List<String> cumplen, int menor, int mayor, int nivelActual) {
		nivelActual++;
		for(GeneralTree<Integer> child: arbol.getChildren()) {
			buscarEntreRango(child, cumplen, menor, mayor, nivelActual);
		}
		
		if(arbol.getData() == menor || arbol.getData() == mayor) {
			cumplen.add(arbol.getData() + " nivel " + nivelActual);
		}
	}
	
	public static void main(String[] args) {
	
		GeneralTree<Integer> A = new GeneralTree<>(1);
        GeneralTree<Integer> B = new GeneralTree<>(2);
        GeneralTree<Integer> C = new GeneralTree<>(3);
        GeneralTree<Integer> D = new GeneralTree<>(4);
        GeneralTree<Integer> E = new GeneralTree<>(5);
        GeneralTree<Integer> F = new GeneralTree<>(6);
        GeneralTree<Integer> G = new GeneralTree<>(7);
        GeneralTree<Integer> H = new GeneralTree<>(8);
        GeneralTree<Integer> I = new GeneralTree<>(9);

        // Armar jerarquía
        B.addChild(E);

        F.addChild(H);
        F.addChild(I);

        C.addChild(F);
        C.addChild(G);

        A.addChild(B);
        A.addChild(C);
        A.addChild(D);

	  
        Parcial8 p = new Parcial8();
        List<String> res= p.resolver(1, 9, A);
        System.out.println(res);
       
	}
}

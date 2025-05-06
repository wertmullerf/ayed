package parciales.parcial7;

import java.util.LinkedList;
import java.util.List;

import arbolesGenerales.GeneralTree;

public class Parcial7 {

	public List<List<Character>> caminosPares(GeneralTree<Character>arbol){
		List<List<Character>> resultado = new LinkedList<List<Character>>();
		if(arbol !=null && !arbol.isEmpty()) {
			List<Character> caminoActual = new LinkedList<>();
			buscarCaminos(arbol,resultado,caminoActual, 0);
		}
		return resultado;
	}
	
	private void buscarCaminos(GeneralTree<Character>arbol,List<List<Character>> caminos, 
								List<Character> actual, int acc) {
		
		acc++;
		actual.add(arbol.getData());
		if(arbol.isLeaf()) {
			if(acc % 2==0) {
				caminos.add(new LinkedList<Character>(actual));
			}
		}else {
			for(GeneralTree<Character>child: arbol.getChildren()) {
				buscarCaminos(child, caminos, actual, acc);
			}
		}
		actual.remove(actual.size()-1);
	}
	
	
	public static void main(String[] args) {
        GeneralTree<Character> A = new GeneralTree<>('A');
        GeneralTree<Character> B = new GeneralTree<>('B');
        GeneralTree<Character> C = new GeneralTree<>('C');
        GeneralTree<Character> D = new GeneralTree<>('D');
        GeneralTree<Character> E = new GeneralTree<>('E');
        GeneralTree<Character> F = new GeneralTree<>('F');
        GeneralTree<Character> G = new GeneralTree<>('G');
        GeneralTree<Character> H = new GeneralTree<>('H');
        GeneralTree<Character> I = new GeneralTree<>('I');

        // Armar jerarquía
        B.addChild(E);

        F.addChild(H);
        F.addChild(I);

        C.addChild(F);
        C.addChild(G);

        A.addChild(B);
        A.addChild(C);
        A.addChild(D);

        Parcial7 test = new Parcial7();
        List<List<Character>> caminos = test.caminosPares(A);
        System.out.print(caminos);
		
	}
}

package parciales.parcial3;

import java.util.Iterator;

import arbolesGenerales.GeneralTree;

public class Parcial3 {

	public static GeneralTree<String> tesoroAccesibleMasCercano(GeneralTree<String> camaras){
		GeneralTree<String> resultado = new GeneralTree<String>();
		if(camaras != null && !camaras.isEmpty()) {
			resultado =buscarTesoro(camaras);
		}
		return resultado;
	}
	
	private static GeneralTree<String> buscarTesoro(GeneralTree<String> nodo) {
        System.out.println("Visitando: " + nodo.getData()); // Debug

	    if (nodo.getData().equals("Bloqueo")) return null;
	    if (nodo.getData().equals("Tesoro")) return nodo;

	    Iterator<GeneralTree<String>> it = nodo.getChildren().iterator();
	    GeneralTree<String> resultado = null;

	    while (resultado == null && it.hasNext()) {
	        resultado = buscarTesoro(it.next());
	    }

	    return resultado;
	}
	
    public static void main(String[] args) {
        GeneralTree<String> entrada = new GeneralTree<>("Entrada");

        GeneralTree<String> camaraA = new GeneralTree<>("Camara A");
        GeneralTree<String> camaraA1 = new GeneralTree<>("Camara A1");
        GeneralTree<String> tesoro1 = new GeneralTree<>("Tesoro");
        camaraA1.addChild(tesoro1);
        camaraA.addChild(camaraA1);

        GeneralTree<String> bloqueo = new GeneralTree<>("Bloqueo");

        GeneralTree<String> pasajeX = new GeneralTree<>("Pasaje X");
        GeneralTree<String> tesoro2 = new GeneralTree<>("Tesoro");
        GeneralTree<String> camaraC = new GeneralTree<>("C");
        GeneralTree<String> b1 = new GeneralTree<>("B1");
        GeneralTree<String> tesoro3 = new GeneralTree<>("Tesoro");
        b1.addChild(tesoro3);
        camaraC.addChild(b1);
        pasajeX.addChild(tesoro2);
        pasajeX.addChild(camaraC);

        entrada.addChild(camaraA);
        entrada.addChild(bloqueo);
        entrada.addChild(pasajeX);

        GeneralTree<String> resultado = tesoroAccesibleMasCercano(entrada);

        if (resultado != null) {
            System.out.println("Tesoro encontrado: " + resultado.getData());
        } else {
            System.out.println("No se encontró un tesoro accesible.");
        }
    }
}

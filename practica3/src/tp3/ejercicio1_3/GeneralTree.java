package tp3.ejercicio1_3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GeneralTree<T>{

    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

    public GeneralTree() {

    }
    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this(data);
        this.children = children;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }

    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null)
            this.children = children;
    }

    public boolean esAncestro(T a, T b){
        boolean resultado = false;
        if(this != null && !this.isEmpty()) {
            if (this.getData().equals(a)) {
                resultado = this.contiene(b);
            } else {
                Iterator<GeneralTree<T>> it = this.children.iterator();
                while (!resultado && it.hasNext()) {
                    GeneralTree<T> child = it.next();
                    if (child.esAncestro(a, b)) {
                        resultado = true;
                    }
                }
            }
        }


        return resultado;
    }

    private boolean contiene(T dato){
        boolean encontrado = false;
        if(this.getData().equals(dato)){
            encontrado = true;
        }else{
            Iterator<GeneralTree<T>> it = children.iterator();
            while(!encontrado && it.hasNext()){
                if (it.next().contiene(dato)) {
                    encontrado = true;
                }
            }
        }
        return encontrado;
    }

    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren())
            children.remove(child);
    }

    public int altura() {
        if(this.isEmpty()) return -1;
        if(this.isLeaf()) return 0;

        int maxAltura = 0;

        if(this.hasChildren()){
            for (GeneralTree<T> hijo : this.getChildren()) {
                int alturaHijo = hijo.altura(); // llamada recursiva
                if (alturaHijo > maxAltura)
                    maxAltura = alturaHijo;
            }
        }

        return maxAltura + 1;
    }

    public int nivel(T dato) {
        // Caso base: si el nodo actual tiene el dato buscado
        if (this.getData().equals(dato)) {
            return 0;
        }

        // Si no lo tiene, recorro los hijos
        if(this.hasChildren()) {
            for (GeneralTree<T> child : this.getChildren()) {
                int nivelEnHijo = child.nivel(dato);  // llamada recursiva
                if (nivelEnHijo != -1) {
                    // 📌 Si lo encontré en el hijo, tengo que sumar 1 por el nivel actual
                    return nivelEnHijo + 1;
                }
            }
        }

        // Si ningún hijo lo tiene
        return -1;
    }
    public int ancho(){
        int max = -1;
        Queue<GeneralTree<T>> cola = new LinkedList<>(); // no tengo la clase Queue
        GeneralTree<T> arbolAux;
        cola.offer(this);
        cola.offer(null);
        int acc = 0;
        while(!cola.isEmpty()){

            arbolAux = cola.poll();
            if(arbolAux != null){

                if(arbolAux.hasChildren()){
                    for (GeneralTree<T> child: arbolAux.getChildren()){
                        acc++;
                        cola.offer(child);

                    }
                }
            }else {
                if(!cola.isEmpty()){
                    if(acc > max) max = acc;
                    cola.offer(null);
                    acc =0;
                }

            }
        }
        return max;
    }

}
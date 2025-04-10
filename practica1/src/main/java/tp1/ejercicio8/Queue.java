package tp1.ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    protected List<T> data;
    public Queue(){
        data = new ArrayList<T>();
    }

    public void enqueue(T dato){
        data.add(dato);
    }

    public T dequeue(){
        return data.remove(0);
    }

    public T head(){
        return data.get(0);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public int size(){
        return data.size();
    }

    @Override
    public String toString() {
        String aux = "";
        if (!data.isEmpty()){
            for (T dato: data){
                aux+= dato + " ";
            }
        }
        return aux;
    }
}

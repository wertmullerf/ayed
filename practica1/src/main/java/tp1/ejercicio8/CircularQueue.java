package tp1.ejercicio8;

public class CircularQueue<T> extends Queue<T> {
    public T shift(){
        T primero = dequeue(); //quito la primera pos
        enqueue(primero); //lo inserto ult
        return primero; // devuelvo la primera pos
    }
}

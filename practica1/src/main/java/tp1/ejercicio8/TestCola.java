package tp1.ejercicio8;

public class TestCola {
    public static void main(String[] args) {
        DoubleEndedQueue<Integer> cola = new DoubleEndedQueue<>();
        cola.enqueue(10);            // agrega al final
        cola.enqueueFirst(5);        // agrega al inicio
        cola.enqueue(20);
        String aux = cola.toString();
        System.out.println(aux);    // debería mostrar: 5 -> 10 -> 20 (según tu toString)
    }
}

package tp1.ejercicio5;

public class Auxiliar {
    private int valorMin,valorMax;
    private double promedio;

    public Auxiliar(int valorMin, int valorMax, double promedio) {
        this.valorMin = valorMin;
        this.valorMax = valorMax;
        this.promedio = promedio;
    }

    public Auxiliar(){}
    public int getValorMin() {
        return valorMin;
    }

    public void setValorMin(int valorMin) {
        this.valorMin = valorMin;
    }

    public int getValorMax() {
        return valorMax;
    }

    public void setValorMax(int valorMax) {
        this.valorMax = valorMax;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
}

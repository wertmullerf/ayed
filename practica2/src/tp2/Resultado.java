package tp2;

public class Resultado {
    public int suma;
    public int diferencia;
    public Resultado(int suma, int diferencia){
        this.suma = suma;
        this.diferencia = diferencia;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(int diferencia) {
        this.diferencia = diferencia;
    }
}

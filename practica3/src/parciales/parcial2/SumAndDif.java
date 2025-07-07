package parciales.parcial2;

public class SumAndDif {
    private int suma;
    private int dif;

    public SumAndDif(int suma, int dif) {
        this.dif = dif;
        this.suma = suma;
    }


    @Override
    public String toString() {
        return suma + " / " +dif;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getDif() {
        return dif;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }
}

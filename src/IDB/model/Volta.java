package IDB.model;

public class Volta {
    private int numeroVolta;
    private float tempo;
    private int pits;

    public Volta(int numeroVolta, float tempo) {
        this.numeroVolta = numeroVolta;
        this.tempo = tempo;
        this.pits = 0;
    }
    
    public int getNumeroVolta() {
        return numeroVolta;
    }

    public void setNumeroVolta(int numeroVolta) {
        this.numeroVolta = numeroVolta;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }
    
    public void pitStop(){
        pits++;
    }
    
    public int getPitsTotais(){
        return pits;
    }
}

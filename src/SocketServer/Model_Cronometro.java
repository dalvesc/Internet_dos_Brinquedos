package SocketServer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class Model_Cronometro {
    
    private int segundo;
    private int minuto;
    private Timer tempo;
    private int contador;

    public Model_Cronometro() {
        this.segundo = 0;
        this.minuto = 0;
        this.contador = 0;
    }

    /**
     * Método que faz a contagem dos segundos e minutos do jogo, atualizando
     * instantâneamente os seus valores.
     */
    public void contarTempo() {
        tempo = new Timer();
        tempo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                contador++;
                setSegundo(contador % 60);
                setMinuto(contador / 60);
            }

        }, 1000, 1000);
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public Timer getTempo() {
        return tempo;
    }

    public void setTempo(Timer tempo) {
        this.tempo = tempo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}

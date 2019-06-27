package SocketServer;

import IDB.exception.SemCorrida;
import IDB.model.Carro;
import IDB.model.Piloto;
import IDB.model.Volta;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class Model_Piloto implements Comparable {
    
    private String urlImagem; //foto do piloto.
    private final String nome; //nome do piloto.
    private Carro carro; //carro que o piloto usará na corrida atual.
    private String equipe; //nome da equipe atual do piloto.
    private final String usuario; //nome de usuário do piloto.
    private final String senha; //senha do piloto.
    private LinkedList<Volta> voltas; //lista com informações de cada volta completa do piloto na corrida atual.
    private double tempoCorrida; //tempo total de corrida do piloto na corrida atual.

    /**
     * Construtor.
     *
     * @param nome
     * @param usuario
     * @param senha
     * @param urlImagem
     */
    public Model_Piloto(String nome, String usuario, String senha, String urlImagem) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.urlImagem = urlImagem;
        voltas = new LinkedList();
    }

    /**
     * Método que adiciona uma nova volta.
     *
     * @param volta
     */
    public void novaVolta(Volta volta) {
        volta.setNumeroVolta(voltas.size() + 1);
        voltas.add(volta);
    }

    /**
     * Método que inicia a lista de voltas para cada nova partida.
     */
    public void iniciarVoltas() {
        voltas = new LinkedList();
    }

    /**
     * Método que retorna o numero de voltas que o piloto correu.
     *
     * @return int
     */
    public int getNumVoltas() {
        return voltas.size();
    }

    /**
     * Método que retorna o tempo da ultima volta.
     *
     * @return double
     * @throws IDB.exception.SemCorrida
     */
    public double getTempoVolta() throws SemCorrida {
        if (voltas.isEmpty()) {
            throw new SemCorrida();
        }
        return voltas.getLast().getTempo();
    }

    /**
     * Método que retorna o tempo da volta mais rápida do piloto.
     *
     * @return double
     * @throws IDB.exception.SemCorrida
     */
    public double getVoltaRapida() throws SemCorrida {
        if (voltas.isEmpty()) {
            throw new SemCorrida();
        }
        Volta rapida = new Volta(0), aux;
        Iterator itr = voltas.iterator();
        while (itr.hasNext()) {
            aux = (Volta) itr.next();
            if (aux.getTempo() < rapida.getTempo()) {
                rapida = aux;
            }
        }
        return rapida.getTempo();
    }

    /**
     * Método que retorna a quantidade de pits do piloto.
     *
     * @return int
     */
    public int getPits() {
        int pits = 0;
        Iterator itr = voltas.iterator();
        Volta aux;
        while (itr.hasNext()) {
            aux = (Volta) itr.next();
            pits = pits + aux.getPits();
        }
        return pits;
    }

    /**
     * Método que adiciona 1 pit quando o carro parar.
     */
    public void setPits() {
        voltas.getLast().pitStop();
    }

    /**
     * Método que atualiza o tempo da corrida.
     */
    public void setTempoCorrida() throws SemCorrida {
        this.tempoCorrida = tempoCorrida + getTempoVolta();
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getNome() {
        return nome;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public LinkedList<Volta> getVoltas() {
        return voltas;
    }

    public void setVoltas(LinkedList<Volta> voltas) {
        this.voltas = voltas;
    }

    public double getTempoCorrida() {
        return tempoCorrida;
    }

    /**
     * Método compareTo para o número total de voltas.
     *
     * @param pilotoAux
     * @return int
     */
    @Override
    public int compareTo(Object pilotoAux) {
        Piloto piloto = (Piloto) pilotoAux;
        if (this.getNumVoltas() < piloto.getNumVoltas()) {
            return -1;
        }
        if (this.getNumVoltas() > piloto.getNumVoltas()) {
            return 1;
        }
        return 0;
    }

    /**
     * Método toString com nome, equipe e tempoCorrida.
     *
     * @return String
     */
    @Override
    public String toString() {
        return nome + "|" + equipe + "|" + tempoCorrida + "|" + getNumVoltas();
    }
}

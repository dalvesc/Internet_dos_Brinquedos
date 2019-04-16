 package IDB.model;

import java.util.Iterator;
import java.util.LinkedList;

 /**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class Piloto {
    private String urlImagem;
    private String nome;
    private Carro carro;
    private String equipe;
    private String usuario;
    private String senha;
    private LinkedList<Volta> voltas;
    
    public Piloto(String nome, String usuario, String senha, String urlImagem) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.urlImagem = urlImagem;
    }
    
    /**
     * Método que adiciona uma nova volta.
     * @param volta 
     */
    public void novaVolta(Volta volta) {
        voltas.add(volta);
    }

    /**
     * Método que retorna o numero de voltas que o piloto correu.
     * @return int
     */
    public int getNumVoltas() {
        return voltas.size();
    }

    /**
     * Método que retorna o tempo da ultima volta.
     * @return float
     */
    public float getTempoVolta() {
        return voltas.getLast().getTempo();
    }

    /**
     * Método que retorna o tempo da volta mais rapida do piloto.
     * @return float
     */
    public float getVoltaRapida() {
        Volta rapida = new Volta(0, 0), aux;
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
     * @return int
     */
    public int getPits(){
        int pits = 0;
        Iterator itr = voltas.iterator();
        Volta aux;
        while(itr.hasNext()){
            aux = (Volta)itr.next();
            pits = pits + aux.getPitsTotais();
        }
        return pits;
    }
    
    /**
     * Método que adiciona 1 pit quando o carro parar.
     */
    public void setPits(){
        voltas.getLast().pitStop();
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
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
}

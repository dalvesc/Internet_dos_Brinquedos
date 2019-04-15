package IDB.model;

import java.util.Iterator;
import java.util.LinkedList;

public class Piloto {

    private String urlImagem;
    private final String nome;
    private Carro carro;
    private String equipe;
    private final String usuario;
    private final String senha;
    private LinkedList<Volta> voltas;

    public Piloto(String nome, String usuario, String senha, String urlImagem) {
        this.urlImagem = urlImagem;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    //adiciona uma nova volta
    public void novaVolta(Volta volta) {
        voltas.add(volta);
    }

    //retorna o numero de voltas que o piloto correu 
    public int getNumVoltas() {
        return voltas.size();
    }

    //retorna o tempo da ultima volta
    public float getTempoVolta() {
        return voltas.getLast().getTempo();
    }

    //retorna o tempo da volta mais rapida do piloto
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
    
    //retorna a quantidade de pits do piloto
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
    
    //adiciona 1 pit quando o carro parar
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

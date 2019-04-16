/*
 * 
 */
package IDB.controller;

import IDB.model.Carro;
import IDB.model.Piloto;
import IDB.model.Volta;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class ControllerCorrida {
    private LinkedList <Piloto> pilotos;
    private LinkedList <Carro> carros;
    
    /**
     * Inicia lista de pilotos vazia.
     * Inicia lista de carros com todos o que estão disponíveis.
     */
    public ControllerCorrida(){
        pilotos = new LinkedList();
        carros = new LinkedList();
        Carro carroAux;

        carroAux = new Carro("Azul Escuro", "Mercedes");
        carros.add(carroAux);
        carroAux = new Carro("Vermelho", "Ferrari");
        carros.add(carroAux);
        carroAux = new Carro("Azul", "Red Bull");
        carros.add(carroAux);
        carroAux = new Carro("Preto", "Haas");
        carros.add(carroAux);
    }

    public LinkedList<Piloto> getPilotos() {
        return pilotos;
    }
    
    public LinkedList<Carro> getCarros() {
        return carros;
    }
    
    /**
     * Método que recebe o piloto escolhido para jogar na partida atual.
     * @param piloto
     * @return boolean
     */
    public boolean pilotoEscolhido(Piloto piloto){
        if(pilotos.size() <4){
            pilotos.add(piloto);
            return true;
        } return false;
    }
    
    /**
     * Método que retorna o iterator de todos as equipes.
     * @return Iterator
     */
    public Iterator listarEquipes(){
        Iterator iterator = carros.iterator();
        
        return iterator;
    }
    
    /**
     * Método que verifica se o carro escolhido pelo piloto está disponível e o veicula ao jogador.
     * @param piloto
     * @param carro
     * @return boolean
     */
    public boolean escolherEquipe(Piloto piloto, Carro carro){
        if(carros.contains(carro)){
            piloto.setCarro(carro);
            carros.remove(carro);
            return true;
        } return false;
    }
    
    /**
     * Método que adiciona mais uma volta do piloto na corrida e o tempo dessa volta.
     * @param codCarro
     * @param tempoVolta 
     */
    public void addVolta(String codCarro, float tempoVolta){
        Iterator iterator = pilotos.iterator();
        
        while(iterator.hasNext()){
            Piloto piloto = (Piloto)iterator.next();
            if(piloto.getCarro().getNumero().compareTo(codCarro) == 0){
                Volta volta = new Volta(tempoVolta);
                piloto.novaVolta(volta);
            }
        }
    }
    
    /**
     * Método que adiciona um Pits à um piloto.
     * @param codCarro 
     */
    public void addPits(String codCarro){
        Iterator iterator = pilotos.iterator();
        
        while(iterator.hasNext()){
            Piloto piloto = (Piloto)iterator.next();
            if(piloto.getCarro().getNumero().compareTo(codCarro) == 0){
                piloto.setPits();
            }
        }
    }
    
    /**
     * Método que retorna o tempo da volta mais rapida do piloto desejado.
     * @param piloto
     * @return float
     */
    public float retornarVoltaMaisRapida(Piloto piloto){
        return piloto.getVoltaRapida();
    }
}

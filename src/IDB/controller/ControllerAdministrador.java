/*
 * Está classe fará configurações da corrida atual.
 */
package IDB.controller;

import IDB.exception.CorridaCheia;
import IDB.model.Piloto;
import java.util.Iterator;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class ControllerAdministrador {

    private ControllerCadastro pitolosCadastrados;
    private ControllerCorrida corrida;

    /**
     * Construtor.
     */
    public ControllerAdministrador() {

    }

    public ControllerCadastro getPitolosCadastrados() {
        return pitolosCadastrados;
    }

    public ControllerCorrida getCorrida() {
        return corrida;
    }

    /**
     * Método para dar inicio as configurações da corrida.
     */
    public void iniciarConfCorrida() {
        corrida = new ControllerCorrida();
    }

    /**
     * Método que retorna o iterator de todos os pilotos cadastrados.
     *
     * @return Iterator
     */
    public Iterator listarPilotos() {
        Iterator iterator = pitolosCadastrados.getPiloto().iterator();

        return iterator;
    }

    /**
     * Método que recebe como parâmetro um piloto escolhido pelo ADM para jogar
     * na partida atual.
     *
     * @param piloto
     * @return boolean
     * @throws IDB.exception.CorridaCheia
     */
    public boolean escolherPiloto(Piloto piloto) throws CorridaCheia {
        return corrida.pilotoEscolhido(piloto);
    }
}

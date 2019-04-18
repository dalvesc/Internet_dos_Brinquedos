package IDB.exception;

import IDB.model.Carro;

/**
 * Caso o user já tenha sido cadastrado
 *
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class CarroSelecionado extends Exception {

    public CarroSelecionado(Carro carro) {
        super("O Carro da equipe ''" + carro.getEquipe() + "'' já está em uso!");
    }
}

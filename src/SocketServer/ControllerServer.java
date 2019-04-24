/*
 * Classe que será responsável por fazer a escrita e leitura dos dados dos usuários.
 */
package SocketServer;

import IDB.controller.ControllerCadastro;
import IDB.model.Administrador;
import IDB.model.Piloto;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class ControllerServer {

    private ControllerCadastro dadosUsuarios;

    public void atualizarCadastroPiloto(Piloto piloto) {
        dadosUsuarios.getPiloto().add(piloto);
    }

    public void atualizarCadastroADM(Administrador adm) {
        dadosUsuarios.getAdm().add(adm);
    }

    public void atualizarCadastro(Object usuario) {

    }
}

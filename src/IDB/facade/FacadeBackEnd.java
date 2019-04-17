/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDB.facade;

import IDB.controller.*;
import IDB.exception.*;
import IDB.model.*;
import java.io.IOException;
import java.util.LinkedList;

public class FacadeBackEnd {

    private ControllerCadastro crlcad;
    private ControllerCorrida crlcor;

    public FacadeBackEnd() throws CadastroInvalido, IOException, LoginInvalido{
        crlcad = new ControllerCadastro();
    }

    public Object cadastrarADM(String nome, String user, String senha) throws CadastroInvalido, IOException {
        return crlcad.cadastrarADM(nome, user, senha);
    }

    public Object cadastrarPiloto(String nome, String user, String senha, String urlImagem) throws CadastroInvalido, IOException{
        return crlcad.cadastrarPiloto(nome, user, senha, urlImagem);
    }

    public Object login(String user, String senha, String classe) throws LoginInvalido {
        return crlcad.login(user, senha, classe);
    }
    
    public LinkedList<Piloto> getPilotos() throws SemPilotos{
        return crlcor.posicaoSessaoCorrida();
    }
}

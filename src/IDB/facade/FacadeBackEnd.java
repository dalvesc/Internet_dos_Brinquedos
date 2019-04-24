package IDB.facade;

import IDB.controller.*;
import IDB.exception.*;
import IDB.model.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class FacadeBackEnd {

    private ControllerCadastro crlcad;
    private ControllerCorrida crlcor;

    public FacadeBackEnd() throws CadastroInvalido, IOException, LoginInvalido {
        crlcad = new ControllerCadastro();
        crlcor = new ControllerCorrida();
    }

    public Object cadastrarADM(String nome, String user, String senha) throws CadastroInvalido {
        return crlcad.cadastrarADM(nome, user, senha);
    }

    public Object cadastrarPiloto(String nome, String user, String senha, String urlImagem) throws CadastroInvalido {
        return crlcad.cadastrarPiloto(nome, user, senha, urlImagem);
    }

    public Object login(String user, String senha, String classe) throws LoginInvalido {
        return crlcad.login(user, senha, classe);
    }

    public boolean verificaUsuarioCadastrado(String user) {
        return crlcad.verificaUsuarioCadastrado(user);
    }

    public Piloto getPilotoLogado() {
        return crlcad.getPilotoLogado();
    }

    public Piloto getPil() {
        return crlcad.getPil();
    }

    public Iterator listarEquipes() {
        return crlcor.listarEquipes();
    }

    public LinkedList<Piloto> getPilotos() throws SemPilotos {
        return crlcor.posicaoSessaoCorrida();
    }

    public boolean escolherEquipe(Piloto piloto, Carro carro) throws CarroSelecionado {
        return crlcor.escolherEquipe(piloto, carro);
    }

    public boolean pilotoEscolhido(Piloto piloto) throws CorridaCheia {
        return crlcor.pilotoEscolhido(piloto);
    }

    public void escolherConfClassif(float tempo, int voltas) {
        crlcor.escolherConfClassif(tempo, voltas);
    }

    public void escolherConfCorrida(int voltas) {
        crlcor.escolherConfCorrida(voltas);
    }

    public boolean pilotoCheio() {
        return crlcor.pilotoCheio();
    }
}

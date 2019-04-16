package IDB.facade;

import IDB.controller.*;

public class FacadeBackEnd {
    
    private ControllerCadastro crl;
    
    public FacadeBackEnd(){
        crl = new ControllerCadastro();
    }
    
    public Object cadastrarADM(String nome, String user, String senha){
        return crl.cadastrarADM(nome, user, senha);
    }
    
    public Object cadastrarPiloto(String nome, String user, String senha, String urlImagem){
        return crl.cadastrarPiloto(nome, user, senha, urlImagem);
    }
    
    public Object login(String user, String senha, String classe){
        return crl.login(user, senha, classe);
    }
}

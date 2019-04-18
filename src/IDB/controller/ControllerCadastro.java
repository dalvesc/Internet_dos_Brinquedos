/*
 * Está classe dará início ao cadastro/login do ADM ou Piloto.
 */
package IDB.controller;

import IDB.exception.*;
import IDB.model.Piloto;
import IDB.model.Administrador;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class ControllerCadastro {
    private LinkedList <Piloto> piloto; //lista de todos os pilotos cadastrados.
    private LinkedList <Administrador> adm; //lista de todos os adm cadastrados.
    
    /**
     * Construtor que inicializa as listas piloto e adm.
     */
    public ControllerCadastro(){
        piloto = new LinkedList();
        adm = new LinkedList();
    }

    public LinkedList<Piloto> getPiloto() {
        return piloto;
    }

    public LinkedList<Administrador> getAdm() {
        return adm;
    }
    
    /**
     * Método que faz o cadastro do ADM e verifica se há usuário cadastro com
     * o mesmo user.
     * @param nome
     * @param user
     * @param senha
     * @return boolean
     * @throws IDB.exception.CadastroInvalido
     * @throws java.io.IOException
     */
    public Object cadastrarADM(String nome, String user, String senha) throws CadastroInvalido, IOException{
        if(!verificaUsuarioExistente(adm, user, "adm")){
            Administrador ADMAux = new Administrador(nome, user, senha);
            adm.add(ADMAux);
            return ADMAux;
        } return null;
    }
    
    /**
     * Método que faz o cadastro do ADM e verifica se há usuário cadastro com
     * o mesmo user.
     * @param nome
     * @param user
     * @param senha
     * @param urlImagem
     * @return boolean
     * @throws IDB.exception.CadastroInvalido
     * @throws java.io.IOException
     */
    public Object cadastrarPiloto(String nome, String user, String senha, String urlImagem) throws CadastroInvalido, IOException{
        if(!verificaUsuarioExistente(piloto, user, "piloto")){
            Piloto pitoloAux = new Piloto(nome, user, senha, urlImagem);
            piloto.add(pitoloAux);
            return pitoloAux;
        } return null;
    }

    /**
     * Método que verifica se há um ADM ou Piloto já cadastrado com os mesmos dados
     * @param usuario
     * @param user
     * @param classe
     * @return boolean
     */
    public boolean verificaUsuarioExistente(LinkedList usuario, String user, String classe){
        Iterator iterator = usuario.iterator();
        
        if(classe.equalsIgnoreCase("Piloto")){
            Piloto objetoUsuario = (Piloto)iterator.next();
            while(iterator.hasNext()) {
                if(objetoUsuario.getUsuario().equalsIgnoreCase(user)){
                    return true;
                }   
            }
        } else{
            Administrador objetoUsuario = (Administrador)iterator.next();
            while(iterator.hasNext()) {
                if(objetoUsuario.getUsuario().equalsIgnoreCase(user)){
                    return true;
                }   
            }
        } return false;
    }
    
    /**
     * Método que faz o login do usuário. Ele faz uso de outro método para verificar se este usuário já possui
     * cadastro no sistema.
     * @param user
     * @param senha
     * @param classe
     * @return Object
     * @throws IDB.exception.LoginInvalido
     */
    public Object login(String user, String senha, String classe) throws LoginInvalido {
        Object usuario = verificaUsuarioCadastrado(adm, user, senha, classe);
        if(usuario != null){
            return usuario;
        } return null;
    }
    
    /**
     * Método que verifica se um usuário já possui cadastro no sistema.
     * @param usuario
     * @param user
     * @param senha
     * @param classe
     * @return Object
     */
    public Object verificaUsuarioCadastrado(LinkedList usuario, String user, String senha, String classe){
        Iterator iterator = usuario.iterator();
        
        if(classe.equalsIgnoreCase("Piloto")){
            Piloto objetoUsuario = (Piloto)iterator.next();
            while(iterator.hasNext()) {
                if(user.equals(objetoUsuario.getUsuario()) && senha.equals(objetoUsuario.getSenha())){
                    return objetoUsuario;
                }   
            }
        } else{
            Administrador objetoUsuario = (Administrador)iterator.next();
            while(iterator.hasNext()) {
                if(user.equals(objetoUsuario.getUsuario()) && senha.equals(objetoUsuario.getSenha())){
                    return objetoUsuario;
                }  
            }
        }
        return null;
    }
}

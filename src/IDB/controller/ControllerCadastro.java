/*
 * Está classe fará início ao cadastro/login do ADM ou Piloto.
 */
package IDB.controller;

import IDB.model.Piloto;
import IDB.model.Administrador;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */

public class ControllerCadastro {
    LinkedList <Piloto> piloto;
    LinkedList <Administrador> adm;
    
    public ControllerCadastro(){
        piloto = new LinkedList();
        adm = new LinkedList();
    }
    
    /**
     * Método que faz o cadastro do ADM e verifica se há usuário cadastro com
     * o mesmo user.
     * @param nome
     * @param user
     * @param senha
     * @return boolean
     */
    public Object cadastrarADM(String nome, String user, String senha){
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
     */
    public Object cadastrarPiloto(String nome, String user, String senha, String urlImagem){
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
     * @return 
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
     */
    public Object login(String user, String senha, String classe){
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
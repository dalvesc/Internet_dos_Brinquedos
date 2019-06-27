/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketServer;

import IDB.exception.CadastroInvalido;
import IDB.exception.LoginInvalido;
import IDB.model.Administrador;
import IDB.model.Piloto;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Adlla Katarine
 */
public class Controller_Cadastro {
    
    private LinkedList<Model_Piloto> piloto;
    private LinkedList<Model_Administrador> adm;
    private Model_Piloto logadop, pil;
    private Model_Administrador logadoa;

    /**
     * Construtor
     */
    public Controller_Cadastro() {
        piloto = new LinkedList();
        adm = new LinkedList();
        Model_Piloto pilotoAux;
        pilotoAux = new Model_Piloto("Piloto1", "p1", "1", "asd");
        piloto.add(pilotoAux);
        pilotoAux = new Model_Piloto("Piloto2", "p2", "2", "asd");
        piloto.add(pilotoAux);
        pilotoAux = new Model_Piloto("Piloto3", "p3", "3", "asd");
        piloto.add(pilotoAux);
        pilotoAux = new Model_Piloto("Piloto4", "p4", "4", "asd");
        piloto.add(pilotoAux);
    }

    /**
     * Método que retorna o piloto que está logado no momento.
     *
     * @return
     */
    public Model_Piloto getPilotoLogado() {
        return logadop;
    }

    /**
     * Método que retorna uma lista com os pilotos cadastrados.
     *
     * @return
     */
    public LinkedList<Model_Piloto> getPiloto() {
        return piloto;
    }

    /**
     * Método que retorna uma lista com os administradores cadastrados
     *
     * @return
     */
    public LinkedList<Model_Piloto> getAdm() {
        return adm;
    }

    /**
     * Método que faz o cadastro do ADM e verifica se há usuário cadastro com o
     * mesmo user.
     *
     * @param nome
     * @param user
     * @param senha
     * @return boolean
     * @throws IDB.exception.CadastroInvalido
     */
    public Object cadastrarADM(String nome, String user, String senha) throws CadastroInvalido {
        if (!verificaUsuarioExistente(adm, user, "adm")) {
            Model_Administrador ADMAux = new Model_Administrador(nome, user, senha);
            adm.add(ADMAux);
            System.out.println("bbb");
            return ADMAux;
        }
        throw new CadastroInvalido(user);
    }

    /**
     * Método que faz o cadastro do ADM e verifica se há usuário cadastro com o
     * mesmo user.
     *
     * @param nome
     * @param user
     * @param senha
     * @param urlImagem
     * @return boolean
     * @throws IDB.exception.CadastroInvalido
     */
    public Object cadastrarPiloto(String nome, String user, String senha, String urlImagem) throws CadastroInvalido {
        if (!verificaUsuarioExistente(piloto, user, "Piloto")) {
            Model_Piloto pitoloAux = new Model_Piloto(nome, user, senha, urlImagem);
            piloto.add(pitoloAux);
            System.out.println("aaa");
            return pitoloAux;
        }
        throw new CadastroInvalido(user);
    }

    /**
     * Método que verifica se há um ADM ou Piloto já cadastrado com os mesmos
     * dados
     *
     * @param usuario
     * @param user
     * @param classe
     * @return boolean
     */
    public boolean verificaUsuarioExistente(LinkedList usuario, String user, String classe) {
        Iterator iterator = usuario.iterator();

        if (classe.equalsIgnoreCase("Piloto")) {
            Piloto objetoUsuario;
            while (iterator.hasNext()) {
                objetoUsuario = (Piloto) iterator.next();
                if (objetoUsuario.getUsuario().equalsIgnoreCase(user)) {
                    return true;
                }
            }
        } else {
            Administrador objetoUsuario;
            while (iterator.hasNext()) {
                objetoUsuario = (Administrador) iterator.next();
                if (objetoUsuario.getUsuario().equalsIgnoreCase(user)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método que faz o login do usuário. Ele faz uso de outro método para
     * verificar se este usuário já possui cadastro no sistema.
     *
     * @param user
     * @param senha
     * @param classe
     * @return Object
     * @throws IDB.exception.LoginInvalido
     */
    public Object login(String user, String senha, String classe) throws LoginInvalido {
        Object usuario = verificaUsuarioCadastrado(user, senha, classe);
        if (usuario != null) {
            return usuario;
        }
        throw new LoginInvalido();
    }

    /**
     * Método que verifica se um usuário já possui cadastro no sistema.
     *
     * @param user
     * @param senha
     * @param classe
     * @return Object
     */
    public Object verificaUsuarioCadastrado(String user, String senha, String classe) {
        Iterator itr;
        Model_Administrador admin;
        logadop = null;
        logadoa = null;
        if (classe.equalsIgnoreCase("Piloto")) {
            itr = piloto.iterator();
            while (itr.hasNext()) {
                pil = (Model_Piloto) itr.next();
                if (pil.getUsuario().equals(user) && pil.getSenha().equals(senha)) {
                    logadop = pil;
                    return pil;
                }
            }
        } else {
            itr = adm.iterator();
            while (itr.hasNext()) {
                admin = (Model_Administrador) itr.next();
                if (admin.getUsuario().equals(user) && admin.getSenha().equals(senha)) {
                    logadoa = admin;
                    return admin;
                }
            }
        }
        return null;
    }

    /**
     * Método que verifica se um usuário já possui cadastro no sistema.
     *
     * @param user
     * @return booelean
     */
    public boolean verificaUsuarioCadastrado(String user) {
        Iterator itr = piloto.iterator();
        while (itr.hasNext()) {
            pil = (Piloto) itr.next();
            if (pil.getNome().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public Piloto getPil() {
        return pil;
    }
}

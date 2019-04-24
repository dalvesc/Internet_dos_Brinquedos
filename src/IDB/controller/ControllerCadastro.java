/*
 * Está classe dará início ao cadastro/login do ADM ou Piloto.
 */
package IDB.controller;

import IDB.exception.*;
import IDB.model.Piloto;
import IDB.model.Administrador;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class ControllerCadastro {

    private LinkedList<Piloto> piloto;
    private LinkedList<Administrador> adm;
    private Piloto logado, pil;

    /**
     * Construtor
     */
    public ControllerCadastro() {
        piloto = new LinkedList();
        adm = new LinkedList();
    }

    /**
     * Método que retorna o piloto que está logado no momento.
     *
     * @return
     */
    public Piloto getPilotoLogado() {
        return logado;
    }

    /**
     * Método que retorna uma lista com os pilotos cadastrados.
     *
     * @return
     */
    public LinkedList<Piloto> getPiloto() {
        return piloto;
    }

    /**
     * Método que retorna uma lista com os administradores cadastrados
     *
     * @return
     */
    public LinkedList<Administrador> getAdm() {
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
            Administrador ADMAux = new Administrador(nome, user, senha);
            adm.add(ADMAux);
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
            Piloto pitoloAux = new Piloto(nome, user, senha, urlImagem);
            piloto.add(pitoloAux);
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
        Administrador admin;
        Piloto pil;
        if (classe.equalsIgnoreCase("Piloto")) {
            itr = piloto.iterator();
            while (itr.hasNext()) {
                pil = (Piloto) itr.next();
                if (pil.getUsuario().equals(user) && pil.getSenha().equals(senha)) {
                    logado = pil;
                    return pil;
                }
            }
        } else {
            itr = adm.iterator();
            while (itr.hasNext()) {
                admin = (Administrador) itr.next();
                if (admin.getUsuario().equals(user) && admin.getSenha().equals(senha)) {
                    return admin;
                }
            }
        }
        return null;
    }

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

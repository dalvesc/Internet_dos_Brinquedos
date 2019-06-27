/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDBtest.model;

import IDB.model.Administrador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adlla Katarine
 */
public class AdministradorTest {
    private Administrador adm1;
    private Administrador adm2;
    private Administrador adm3;
    
    public AdministradorTest() {
    }
    
    @Before
    public void setUp() {
        this.adm1 = new Administrador("Chandler Bing", "chandler", "euchandler");
        this.adm2 = new Administrador("Phoebe Buffay", "phoebe", "euphoebe");
        this.adm3 = new Administrador("Joey Tribbiani", "joey", "eujoey");
    }
    
    @Test
    public void testAdministrador() {
        assertEquals("Chandler Bing", adm1.getNome());
        assertTrue("chandler".equals(adm1.getUsuario()));
        assertFalse("naochandler".equals(adm1.getSenha()));
        
        assertEquals("Phoebe Buffay", adm2.getNome());
        assertTrue("phoebe".equals(adm2.getUsuario()));
        assertFalse("naophoebe".equals(adm2.getSenha()));
        
        assertEquals("Joey Tribbiani", adm3.getNome());
        assertTrue("joey".equals(adm3.getUsuario()));
        assertFalse("naojoey".equals(adm3.getSenha()));
    }
}

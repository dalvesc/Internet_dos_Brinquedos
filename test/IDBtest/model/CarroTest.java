/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDBtest.model;

import IDB.model.Carro;
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
public class CarroTest {
    private Carro carro1;
    private Carro carro2;
    private Carro carro3;
    
    public CarroTest() {
    }

    @Before
    public void setUp() {
        carro1 = new Carro("Amarelo", "Ferrari");
        carro1.setNumero("55442211");
        carro2 = new Carro("Vermelho", "Haas");
        carro2.setNumero("55338877");
        carro3 = new Carro("Verde", "Red Bull");
        carro3.setNumero("55996633");
    }
    
    @Test
    public void test() {
        assertEquals("Amarelo", carro1.getCor());
        assertTrue("Ferrari".equals(carro1.getEquipe()));
        assertFalse("55442212".equals(carro1.getNumero()));
        
        assertEquals("Vermelho", carro2.getCor());
        assertTrue("Haas".equals(carro2.getEquipe()));
        assertFalse("55338878".equals(carro2.getNumero()));
        
        assertEquals("Verde", carro3.getCor());
        assertTrue("Red Bull".equals(carro3.getEquipe()));
        assertFalse("55996636".equals(carro3.getNumero()));
    }

}

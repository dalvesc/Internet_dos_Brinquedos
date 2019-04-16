/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDB.facade;
import IDB.controller.*;

/**
 *
 * @author danco
 */
public class FacadeTemp {
    private static FacadeTemp facade;
    private final ControllerCorrida controllerCorrida;
    
    private FacadeTemp(){
        controllerCorrida = new ControllerCorrida();
    }
    
    public static synchronized FacadeTemp getInstance(){
        if(facade == null) {
            facade = new FacadeTemp();
        }
        return facade;
    }
}

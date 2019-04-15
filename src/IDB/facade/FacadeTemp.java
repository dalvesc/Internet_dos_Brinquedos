package IDB.facade;
import IDB.controller.*;

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

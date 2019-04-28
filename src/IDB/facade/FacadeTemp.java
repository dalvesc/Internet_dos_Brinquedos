package IDB.facade;

import IDB.controller.*;
import IDB.exception.CarroSelecionado;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class FacadeTemp {

    private static FacadeTemp facade;
    private final ControllerCorrida controllerCorrida;

    private FacadeTemp() throws CarroSelecionado {
        controllerCorrida = new ControllerCorrida();
    }

    public static synchronized FacadeTemp getInstance() throws CarroSelecionado {
        if (facade == null) {
            facade = new FacadeTemp();
        }
        return facade;
    }
}

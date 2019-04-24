package SocketServer;

import Socket.SimSensorDados;
import Socket.SimulacaoSensor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class ServerView {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Server servidor = new Server();
        Socket cliente = null;
        ObjectOutputStream output;
        ObjectInputStream input;
        SimSensorDados dadosSensor = new SimSensorDados(); //Simulação para receber dados do sensor, como se a TAG estivesse sendo lida constantemente.

        try {

            servidor.criarServidor(5020); //Servidor é criado e sua porta é especificada.
            while (true) {
                cliente = servidor.esperarConexao(); //Servidor fica esperando uma conexão com um cliente.
                output = servidor.conexaoOutput(cliente);
                input = servidor.conexaoInput(cliente);

            }

        } catch (IOException ex) {
            Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
        } finally { //finalizando conexões.
            servidor.fecharSocket(cliente);
            servidor.conexaoClose();
        }
    }
}

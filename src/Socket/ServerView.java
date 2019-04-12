/*
 * Descrição da classe.
 */
package Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.lang.Thread;
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
        SimSensorDados dadosSensor = new SimSensorDados();
        
        try {
            servidor.criarServidor(5020);
            cliente = servidor.esperarConexao();
            output = servidor.conexaoOutput(cliente);
            input = servidor.conexaoInput(cliente);
            
            SimulacaoSensor d;
            //Percorre toda a lista
            System.out.println("Enviando todos os dados coletados!");
            while(true){
                Iterator it = dadosSensor.getLeituraDados().iterator();
                while(it.hasNext()) {
                    d = (SimulacaoSensor)it.next();
                    System.out.println(d.toString());
                    output.writeObject(d);
                    output.flush();
                }
           }
            /*
            System.out.println("Tratando mensagem...");
            String msn = input.readUTF();
            System.out.println("Mensagem recebida...");
            output.writeUTF("HELLO WORLD!");*/  
        } catch (IOException ex) {
            Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            servidor.fecharSocket(cliente);
        }
    } 
}

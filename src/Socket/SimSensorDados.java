package Socket;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class SimSensorDados implements Serializable{
    private SimulacaoSensor dados;
    private List leituraDados;
    
    public SimSensorDados(){
        leituraDados = new LinkedList();
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        
        
        dados = new SimulacaoSensor("E22000172211006918905415", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905415", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905415", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905415", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905415", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        
        
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        
        
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "1", "925200", "2019-03-27T10:41:08.153009-0300", "171");
        leituraDados.add(this.dados);
    }

    public SimulacaoSensor getDados() {
        return dados;
    }

    public void setDados(SimulacaoSensor dados) {
        this.dados = dados;
    }

    public List getLeituraDados() {
        return leituraDados;
    }

    public void setLeituraDados(List leituraDados) {
        this.leituraDados = leituraDados;
    }

    @Override
    public String toString() {
        return "SimSensorDados{" + "dados=" + dados + '}';
    }

    


    
    
}

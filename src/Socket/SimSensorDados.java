package Socket;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class SimSensorDados implements Serializable {

    private SimulacaoSensor dados;
    private List leituraDados;

    public SimSensorDados() {
        leituraDados = new LinkedList();
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

    public void loopSim() {
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "2", "925200", "2019-03-27T10:42:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "2", "925200", "2019-03-27T10:42:10.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:42:14.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:42:16.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:42:17.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "4", "925200", "2019-03-27T10:42:25.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "3", "925200", "2019-03-27T10:42:40.153009-0300", "171");
        leituraDados.add(this.dados);

        dados = new SimulacaoSensor("E22000172211006918905414", "209", "2", "925200", "2019-03-27T10:44:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "2", "925200", "2019-03-27T10:44:10.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:44:14.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:44:16.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:44:17.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "4", "925200", "2019-03-27T10:44:25.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "3", "925200", "2019-03-27T10:44:40.153009-0300", "171");
        leituraDados.add(this.dados);

        dados = new SimulacaoSensor("E22000172211006918905414", "209", "2", "925200", "2019-03-27T10:48:08.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "2", "925200", "2019-03-27T10:48:10.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:48:14.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:48:16.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "1", "925200", "2019-03-27T10:48:17.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905416", "209", "4", "925200", "2019-03-27T10:48:25.153009-0300", "171");
        leituraDados.add(this.dados);
        dados = new SimulacaoSensor("E22000172211006918905414", "209", "3", "925200", "2019-03-27T10:48:40.153009-0300", "171");
        leituraDados.add(this.dados);
    }

    @Override
    public String toString() {
        return "SimSensorDados{" + "dados=" + dados + '}';
    }
}

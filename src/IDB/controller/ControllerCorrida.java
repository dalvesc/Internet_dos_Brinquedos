package IDB.controller;

import IDB.exception.*;
import IDB.model.*;
import Socket.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class ControllerCorrida {

    private LinkedList<Piloto> pilotos; //lista dos pilotos escolhidos para a corrida.
    private LinkedList<Carro> carros; //lista dos carros disponíveis para a corrida.
    private float tempoMaxClassif; //tempo máximo que a sessão de classificação pode ter.
    private int voltasClassif; //quantidade máxima de voltas que um piloto pode fazer na sessão de classificação.
    private int voltasCorrida; //quantidade máxima de voltas que um piloto pode fazer na sessão de corrida.
    private float tempoTotalCorrida; //tempo real e final da corrida.

    /**
     * Inicia lista de pilotos vazia. Inicia lista de carros com todos o que
     * estão disponíveis.
     */
    public ControllerCorrida() throws CarroSelecionado {
        pilotos = new LinkedList();
        carros = new LinkedList();
        Carro carroAux;
        Piloto pilotoAux;

        carroAux = new Carro("Azul Escuro", "Mercedes");
        carros.add(carroAux);
        pilotoAux = new Piloto("Piloto1", "p1", "1", "asd");
        pilotos.add(pilotoAux);
        escolherEquipe(pilotoAux, carroAux);
        setCarro(carroAux, "1");

        carroAux = new Carro("Vermelho", "Ferrari");
        carros.add(carroAux);
        pilotoAux = new Piloto("Piloto2", "p2", "2", "asd");
        pilotos.add(pilotoAux);
        escolherEquipe(pilotoAux, carroAux);
        setCarro(carroAux, "2");

        carroAux = new Carro("Azul", "Red Bull");
        carros.add(carroAux);
        pilotoAux = new Piloto("Piloto3", "p3", "3", "asd");
        pilotos.add(pilotoAux);
        escolherEquipe(pilotoAux, carroAux);
        setCarro(carroAux, "3");

        carroAux = new Carro("Preto", "Haas");
        carros.add(carroAux);
        pilotoAux = new Piloto("Piloto4", "p4", "4", "asd");
        pilotos.add(pilotoAux);
        escolherEquipe(pilotoAux, carroAux);
        setCarro(carroAux, "4");
    }

    public LinkedList<Piloto> getPilotos() throws SemPilotos {
        if (pilotos.isEmpty()) {
            throw new SemPilotos();
        }
        return pilotos;
    }

    public LinkedList<Carro> getCarros() {
        return carros;
    }

    public float getTempoMaxClassif() {
        return tempoMaxClassif;
    }

    public void setTempoMaxClassif(float tempoMaxClassif) {
        this.tempoMaxClassif = tempoMaxClassif;
    }

    public int getVoltasCorrida() {
        return voltasCorrida;
    }

    public void setVoltasCorrida(int voltasCorrida) {
        this.voltasCorrida = voltasCorrida;
    }

    public float getTempoTotalCorrida() {
        return tempoTotalCorrida;
    }

    public void setTempoTotalCorrida(float tempoTotalCorrida) {
        this.tempoTotalCorrida = tempoTotalCorrida;
    }

    /**
     * Método que recebe o carro que deve ser de determinado id(identificado
     * pelo RFID).
     *
     * @param carro
     * @param id
     */
    public void setCarro(Carro carro, String id) {
        carro.setNumero(id);
    }

    /**
     * Método que recebe o piloto escolhido para jogar na partida atual.
     *
     * @param piloto
     * @return boolean
     * @throws IDB.exception.CorridaCheia
     */
    public boolean pilotoEscolhido(Piloto piloto) throws CorridaCheia {
        if (pilotos.size() < 4) {
            pilotos.add(piloto);
            return true;
        }
        throw new CorridaCheia();
    }

    /**
     * Método que retorna true caso a quantidade de pilotos já esteja no limite
     *
     * @return
     */
    public boolean pilotoCheio() {
        return pilotos.size() < 4;
    }

    /**
     * Método que retorna o iterator de todos as equipes.
     *
     * @return Iterator
     */
    public Iterator listarEquipes() {
        Iterator iterator = carros.iterator();

        return iterator;
    }

    /**
     * Método que verifica se o carro escolhido pelo piloto está disponível e o
     * veicula ao jogador.
     *
     * @param piloto
     * @param carro
     * @return boolean
     * @throws IDB.exception.CarroSelecionado
     */
    public boolean escolherEquipe(Piloto piloto, Carro carro) throws CarroSelecionado {
        if (carros.contains(carro)) {
            piloto.setCarro(carro);
            piloto.setEquipe(carro.getEquipe());
            piloto.iniciarVoltas();
            carros.remove(carro);
            return true;
        }
        throw new CarroSelecionado(carro);
    }

    /**
     * Método que atualiza a posição do piloto a partir da simulação.
     *
     */
    public void atzPosicao() throws SemCorrida {
        SimSensorDados sim = new SimSensorDados();
        sim.loopSim();
        List posicoes = sim.getLeituraDados();
        Iterator itr = posicoes.iterator();
        while (itr.hasNext()) {
            SimulacaoSensor dados = (SimulacaoSensor) itr.next();
            for (Piloto piloto : pilotos) {
                if (piloto.getCarro().getNumero().equals(dados.getAntennaID())) {
                    String replaceAll = dados.getTimeStamp().substring(dados.getTimeStamp().indexOf("T") + 1,
                            dados.getTimeStamp().indexOf("."));
                    replaceAll = replaceAll.replaceAll(":", "");
                    Volta volta = new Volta(Double.parseDouble(replaceAll));
                    if (piloto.getNumVoltas() == 0) {
                        addVolta(piloto.getCarro().getNumero(), volta);
                    }
                    if (volta.getTempo() - piloto.getTempoVolta() >= 5) {
                        addVolta(piloto.getCarro().getNumero(), volta);
                    }
                }
            }
        }
    }

    /**
     * Método que adiciona mais uma volta do piloto na corrida e o tempo dessa
     * volta.
     *
     * @param codCarro
     * @param volta
     */
    public void addVolta(String codCarro, Volta volta) {
        for (Piloto piloto : pilotos) {
            if (piloto.getCarro().getNumero().compareTo(codCarro) == 0) {
                piloto.novaVolta(volta);
            }
        }
        posicaoSessaoCorrida();
    }

    /**
     * Método que adiciona um Pits à um piloto.
     *
     * @param codCarro
     */
    public void addPits(String codCarro) {
        for (Piloto piloto : pilotos) {
            if (piloto.getCarro().getNumero().compareTo(codCarro) == 0) {
                piloto.setPits();
            }
        }
    }

    /**
     * Método que retorna o tempo da volta mais rápida do piloto desejado.
     *
     * @param piloto
     * @return doubles
     */
    public double retornarVoltaMaisRapida(Piloto piloto) throws SemCorrida{
        return piloto.getVoltaRapida();
    }

    /**
     * Método que atualiza a posição dos pilotos durante a corrida.
     *
     * @return LinkedList
     */
    public LinkedList posicaoSessaoCorrida() {
        Collections.sort(pilotos, Collections.reverseOrder());
        return pilotos;
    }

    /**
     * Método que atualiza a posição dos pilotos ao final da corrida.
     *
     * @return LinkedList
     */
    public LinkedList posicaoSessaoQualif() throws SemCorrida{
        ArrayList pilotosAux = new ArrayList(pilotos.size());

        for (int i = pilotosAux.size() - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                Piloto piloto1 = (Piloto) pilotosAux.get(j + 1);
                Piloto piloto2 = (Piloto) pilotosAux.get(j);
                if (piloto1.getVoltaRapida() < piloto2.getVoltaRapida()) {
                    swap(pilotosAux, j, j + 1);
                }
            }
        }
        for (int k = pilotosAux.size() - 1; k >= 0; k--) {
            pilotos.add((Piloto) pilotosAux.get(k));
        }
        return pilotos;
    }

    /**
     * Método que atualiza a posição de todos os pilotos cadastrados, retornando
     * o piloto em primeiro lugar de tempo mais rápido.
     *
     * @return Piloto
     */
    public Piloto posicaoSessaoRecorde(LinkedList contCadastro) throws SemCorrida {
        ArrayList pilotosAux = new ArrayList(contCadastro.size());

        for (int i = pilotosAux.size() - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                Piloto piloto1 = (Piloto) pilotosAux.get(j + 1);
                Piloto piloto2 = (Piloto) pilotosAux.get(j);
                if (piloto1.getVoltaRapida() < piloto2.getVoltaRapida()) {
                    swap(pilotosAux, j, j + 1);
                }
            }
        }
        for (int k = pilotosAux.size() - 1; k >= 0; k--) {
            contCadastro.add((Piloto) pilotosAux.get(k));
        }
        return (Piloto) contCadastro.getFirst();
    }

    /**
     * Método auxiliar na ordenação da posição dos pilotos na sessão de
     * qualificação.
     *
     * @param pilotosAux
     * @param i
     * @param j
     */
    private void swap(ArrayList pilotosAux, int i, int j) {
        Piloto piloto = (Piloto) pilotosAux.get(i);
        pilotosAux.set(i, pilotosAux.get(j));
        pilotosAux.set(j, piloto);
    }

    /**
     * Método para escolha de tempo e voltas máximas da classificação, decididos
     * pelo ADM.
     *
     * @param tempo
     * @param voltas
     */
    public void escolherConfClassif(float tempo, int voltas) {
        this.tempoMaxClassif = tempo;
        this.voltasClassif = voltas;
    }

    /**
     * Método que monitora a sessão de classificação, para que não ultrapasse o
     * seu tempo máximo ou quantidade máxima de voltas decididos pelo ADM.
     *
     * @return boolean
     */
    public boolean monitorarTerminoClassif() {
        if (this.tempoTotalCorrida >= this.tempoMaxClassif) {
            return true;
        }

        for (Piloto piloto : pilotos) {
            if (getVoltasCorrida() == piloto.getNumVoltas()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para escolha de voltas máximas da corrida, decididos pelo ADM.
     *
     * @param voltas
     */
    public void escolherConfCorrida(int voltas) {
        this.voltasCorrida = voltas;
    }

    /**
     * Método que monitora a sessão de corrida, para que não ultrapasse a
     * quantidade máxima de voltas decididos pelo ADM.
     *
     * @return boolean
     */
    public boolean monitorarTerminoCorrida() {
        for (Piloto piloto : pilotos) {
            if (getVoltasCorrida() == piloto.getNumVoltas()) {
                return true;
            }
        }
        return false;
    }
}

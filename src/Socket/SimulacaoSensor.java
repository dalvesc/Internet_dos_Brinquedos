package Socket;

import java.io.Serializable;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class SimulacaoSensor implements Serializable{
    private String ECP;
    private String RSSI;
    private String antennaID;
    private String frequency;
    private String timeStamp;
    private String phase;
    
    public SimulacaoSensor(){
        
    }
    
    public SimulacaoSensor(String ECP, String RSSI, String antennaID, String frequency, String timeStamp, String phase){
        this.ECP = ECP;
        this.RSSI = RSSI;
        this.antennaID = antennaID;
        this.frequency = frequency;
        this.timeStamp = timeStamp;
        this.phase = phase;
    }

    public String getECP() {
        return ECP;
    }

    public void setECP(String ECP) {
        this.ECP = ECP;
    }

    public String getRSSI() {
        return RSSI;
    }

    public void setRSSI(String RSSI) {
        this.RSSI = RSSI;
    }

    public String getAntennaID() {
        return antennaID;
    }

    public void setAntennaID(String antennaID) {
        this.antennaID = antennaID;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    @Override
    public String toString() {
        return "SimulacaoSensor{" + "ECP=" + ECP + ", RSSI=" + RSSI + ", antennaID=" + antennaID + ", frequency=" + frequency + ", timeStamp=" + timeStamp + ", phase=" + phase + '}';
    }
 
    
}

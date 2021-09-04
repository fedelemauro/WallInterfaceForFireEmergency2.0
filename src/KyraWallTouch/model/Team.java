package KyraWallTouch.model;

import java.util.List;

public class Team
{
    private String id;

    private List <Agente> agenti;
    private List <Veicolo> veicoli;

    public Team() {
    }

    public Team(String id, List<Agente> agenti, List<Veicolo> veicoli) {
        this.id = id;
        this.agenti = agenti;
        this.veicoli = veicoli;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Agente> getAgenti() {
        return agenti;
    }

    public void setAgenti(List<Agente> agenti) {
        this.agenti = agenti;
    }

    public List<Veicolo> getVeicoli() {
        return veicoli;
    }

    public void setVeicoli(List<Veicolo> veicoli) {
        this.veicoli = veicoli;
    }
}



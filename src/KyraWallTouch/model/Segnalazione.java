package KyraWallTouch.model;

import java.util.List;

public class Segnalazione {

    private int id;
    private String descrizione;
    private String latitudine;
    private String longitudine;
    private String citta;
    private String provincia;
    private String via;
    private String numcivico;
    private String cap;
    private String data;
    private String codiceMeteo;
    private List<Team> team;

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

    public Segnalazione(int id, String descrizione, String latitudine, String longitudine, String citta, String provincia, String via, String numcivico, String cap, String data) {
        this.id = id;
        this.descrizione = descrizione;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.citta = citta;
        this.provincia = provincia;
        this.via = via;
        this.numcivico = numcivico;
        this.cap = cap;
        this.data = data;
    }

    public Segnalazione() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodiceMeteo(String codiceMeteo)
        {
            this.codiceMeteo = codiceMeteo;
        }

        public String getCodiceMeteo()
        {
            return codiceMeteo;
        }
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(String latitudine) {
        this.latitudine = latitudine;
    }

    public String getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(String longitudine) {
        this.longitudine = longitudine;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getNumcivico() {
        return numcivico;
    }

    public void setNumcivico(String numcivico) {
        this.numcivico = numcivico;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

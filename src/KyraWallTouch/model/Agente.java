package KyraWallTouch.model;

public class Agente
{

    private String nome;
    private int id;
    private String latitudine;
    private String longitudine;
    private String salute;
    private int eta;

    public Agente() {
    }

    public Agente(String nome, int id, String latitudine, String longitudine, String salute, int eta) {
        this.nome = nome;
        this.id = id;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.salute = salute;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSalute() {
        return salute;
    }

    public void setSalute(String salute) {
        this.salute = salute;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}


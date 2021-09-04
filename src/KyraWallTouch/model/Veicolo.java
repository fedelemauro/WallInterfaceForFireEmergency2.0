package KyraWallTouch.model;

public class Veicolo
{


    private int id;
    private String latitudine;
    private String longitudine;
    private float tank;
    private int firemanNumber;



    public Veicolo() {
    }

    public Veicolo(int id, String latitudine, String longitudine, float tank, int firemanNumber) {
        this.id = id;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.tank = tank;
        this.firemanNumber = firemanNumber;
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

    public float getTank() {
        return tank;
    }

    public void setTank(float tank) {
        this.tank = tank;
    }

    public int getFiremanNumber() {
        return firemanNumber;
    }

    public void setFiremanNumber(int firemanNumber) {
        this.firemanNumber = firemanNumber;
    }
}

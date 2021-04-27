package cabinet;

import java.util.Arrays;

public class Reteta {
    private int idReteta;
    private int idClient;
    private int idMedic;
    private int data; // zzllaaaa
    private String[] medicamente;

    //**
    public Reteta() {
    }
    //*/

    public Reteta(int idReteta, int idClient, int idMedic,
                  int data, String[] medicamente)
    {
        this.idReteta = idReteta;
        this.idClient = idClient;
        this.idMedic = idMedic;
        this.data = data;
        this.medicamente = medicamente;
    }

    public int getIdReteta() {
        return idReteta;
    }

    public void setIdReteta(int idReteta) {
        this.idReteta = idReteta;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String[] getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(String[] medicamente) {
        this.medicamente = medicamente;
    }

    @Override
    public String toString() {
        return "Reteta numarul " + idReteta + ", oferita de medicul cu id-ul" +
                idMedic + " pacientului cu id-ul " + idClient + " la data de " +
                data + ", contine medicamentele " + Arrays.toString(medicamente) + ".\n";
    }
}

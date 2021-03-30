package cabinet;

import java.util.Arrays;
import java.util.Objects;

public class Client {
    private static int nr;
    private int id;
    private String nume;
    private String prenume;
    private char sex; // M - masculin, F - feminin
    private int varsta;
    private String CNP; // 13 cifre - s aa ll zz jj nnn c
    private String[] afectiuni;

    public Client()
    {
    }

    public Client(String nume, String prenume, char sex,
                  int varsta, String CNP, String[] afectiuni)
    {
        nr = nr + 1;
        this.id = nr;
        this.nume = nume;
        this.prenume = prenume;
        this.sex = sex;
        this.varsta = varsta;
        this.CNP = CNP;
        this.afectiuni = afectiuni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume){
        this.nume = nume;
    }

    public String getPrenume() {
        return  prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public char getSex() {
        return  sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String[] getAfectiuni() {
        return afectiuni;
    }

    public void setAfectiuni(String[] afectiuni) {
        this.afectiuni = afectiuni;
    }

    @Override
    public String toString() {
        return "Pacientul cu id-ul " + id + ", pe nume " + nume +  " " +
                prenume + ", sex: " + sex + ", varsta " + varsta + ", CNP: "
                + CNP + ", are afectiunile: " + Arrays.toString(afectiuni) + ". ";
    }

    @Override
    public boolean equals(Object c) {
        if (this == c) return true;
        if (! (c instanceof Client)) return false;
        Client client = (Client) c;
        return getId() == client.getId() && getNume() == client.getNume() &&
                getPrenume() == client.getPrenume() && getSex() == client.getSex() &&
                getVarsta() == client.getVarsta() && getCNP() == client.getCNP() &&
                Arrays.equals(getAfectiuni(), client.getAfectiuni());
    }

    @Override
    public int hashCode() {
        int r = Objects.hash(getNume(), getPrenume(), getCNP(), getSex());
        r = 31 * getId() * getVarsta() * Arrays.hashCode(getAfectiuni());
        return r;
    }
}

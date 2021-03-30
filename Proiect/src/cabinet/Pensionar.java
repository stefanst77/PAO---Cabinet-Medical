package cabinet;

import java.util.Objects;

public class Pensionar extends Client{
    public int idCuponPensie;
    public int pensie;
    public int procentReducere;

     public Pensionar()
     {
     }

    public Pensionar(String nume, String prenume, char sex,
                     int varsta, String CNP, String[] afectiuni,
                     int idCuponPensie, int pensie, int procentReducere)
    {
        super(nume, prenume, sex, varsta, CNP, afectiuni);
        this.idCuponPensie = idCuponPensie;
        this.pensie = pensie;
        this.procentReducere = procentReducere;
    }

    public int getIdCuponPensie() {
        return  idCuponPensie;
    }

    public void setIdCuponPensie(int idCuponPensie) {
        this.idCuponPensie = idCuponPensie;
    }

    public int getPensie() {
        return  pensie;
    }

    public void setPensie(int pensie) {
        this.pensie = pensie;
    }

    public int getProcentReducere() {
        return procentReducere;
    }

    public void setProcentReducere(int procentReducere) {
        this.procentReducere = procentReducere;
    }

    @Override
    public String toString() {
        return super.toString() + ". Pacientul este un pensionar, avand cuponul de pensie " +
                idCuponPensie + ", pensia de " + pensie + " RON si bedeficiaza de o derucere de" +
                procentReducere + "." + ".";
    }

    @Override
    public boolean equals(Object s) {
        if (this == s) return  true;
        if (!(s instanceof Pensionar)) return false;
        if (!super.equals(s)) return false;
        Pensionar pensionar = (Pensionar) s;
        return getIdCuponPensie()  == pensionar.getIdCuponPensie() && getPensie() == pensionar.getPensie() &&
                getProcentReducere() == pensionar.getProcentReducere();
    }

    public int hashCode() {
        int r = 31 * super.hashCode() * getIdCuponPensie() * getPensie() * getProcentReducere();
        return r;
    }
}

package cabinet;

import java.util.Objects;

public class Salariat extends Client{
    private int adeverintaVenit; // 0 daca nu are, > 0, venitul
    private String angajator;

     public Salariat()
     {
     }

    public Salariat(String nume, String prenume, char sex,
                    int varsta, String CNP, String[] afectiuni,
                    int adeverintaVenit, String angajator)
    {
        super(nume, prenume, sex, varsta, CNP, afectiuni);
        this.adeverintaVenit = adeverintaVenit;
        this.angajator = angajator;
    }

    public  int getAdeverintaVenit() {
        return adeverintaVenit;
    }

    public void setAdeverintaVenit(int adeverintaVenit) {
        this.adeverintaVenit = adeverintaVenit;
    }

    public String getAngajator() {
        return  angajator;
    }

    public void setAngajator(String angajator) {
        this.angajator = angajator;
    }

    @Override
    public String toString() {
        if (adeverintaVenit == 0)
            return super.toString() + "Pacientul nu are adeverinta de venit.\n";
        else
            return super.toString() + "Pacientul are adeverinta de venit, cu salariul " +
                    adeverintaVenit + " RON, angajatorul fiind " + angajator;
    }

    @Override
    public boolean equals(Object s) {
        if (this == s) return  true;
        if (!(s instanceof Salariat)) return false;
        if (!super.equals(s)) return false;
        Salariat salariat = (Salariat) s;
        return getAdeverintaVenit() == salariat.getAdeverintaVenit() && getAngajator() == salariat.getAngajator();
    }

    public int hashCode() {
        int r = Objects.hash(getAngajator());
        r = 31 * r * getAdeverintaVenit() * super.hashCode();
        return r;
    }
}

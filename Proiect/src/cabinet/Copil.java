package cabinet;

import java.util.Objects;

public class Copil extends Client{
    private String numeTutore ;
    private String prenumeTutore;
    private String telefonTutore;

     public Copil()
     {
     }

    public Copil(String nume, String prenume, char sex,
                 int varsta, String CNP, String[] afectiuni,
                 String numeTutore, String prenumeTutore,
                 String telefonParinte)
    {
        super(nume, prenume, sex, varsta, CNP, afectiuni);
        this.numeTutore = numeTutore;
        this.prenumeTutore = prenumeTutore;
        this.telefonTutore = telefonParinte;
    }

    public String getNumeTutore() {
        return numeTutore;
    }

    public void setNumeTutore(String numeTutore) {
        this.numeTutore = numeTutore;
    }

    public String getPrenumeTutore() {
        return prenumeTutore;
    }

    public void setPrenumeTutore(String prenumeTutore) {
        this.prenumeTutore = prenumeTutore;
    }

    public String getTelefonTutore() {
        return  telefonTutore;
    }

    public void setTelefonParinte(String telefonParinte) {
        this.telefonTutore = telefonParinte;
    }

    @Override
    public String toString() {
        return super.toString() + "Pacientul este un copil. Tutorele se numeste " +
                numeTutore + " " +  prenumeTutore + ", cu numar de telefon " +
                telefonTutore + ".";
    }

    @Override
    public boolean equals(Object c) {
        if (this == c) return  true;
        if (!(c instanceof Copil)) return false;
        if (!super.equals(c)) return false;
        Copil copil = (Copil) c;
        return getNumeTutore() == copil.getNumeTutore() && getPrenumeTutore() == copil.getPrenumeTutore() &&
                getTelefonTutore() == copil.getTelefonTutore();
    }

    @Override
    public int hashCode() {
        int r = Objects.hash(getNumeTutore(), getPrenumeTutore(), getTelefonTutore());
        r = 31 * r * super.hashCode();
        return r;
    }
}

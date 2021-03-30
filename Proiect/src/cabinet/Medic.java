package cabinet;

import java.util.Arrays;

public class Medic {
    private int id;
    private String nume;
    private String prenume;
    private String specializare;
    private int numarPacienti;
    private String[] pacienti;

    /**
     * public Medic()
     * {
     * }
     //*/

    public Medic(int id, String nume, String prenume, String specializare,
                 int numarPacienti, String[] pacienti)
    {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.specializare = specializare;
        this.numarPacienti = numarPacienti;
        this.pacienti = pacienti;
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

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public int getNumarPacienti() {
        return numarPacienti;
    }

    public void setNumarPacienti(int numarPacienti) {
        this.numarPacienti = numarPacienti;
    }

    public String[] getPacienti() {
        return pacienti;
    }

    public void setPacienti(String[] pacienti) {
        this.pacienti = pacienti;
    }

    @Override
    public String toString() {
        return "Medicul " + nume + " " + prenume + ", specializat in " + specializare +
                ", are " + numarPacienti + " pacienti, " + Arrays.toString(pacienti) + ".\n";
    }
}

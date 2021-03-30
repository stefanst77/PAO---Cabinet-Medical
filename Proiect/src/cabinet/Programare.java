package cabinet;

public class Programare {
    private int id;
    private String numeClient;
    private String prenumeClient;
    private int data; // zzllaaaa
    private int ora; // hhmm
    private int cost;
    private String numeMedic;
    private String prenumeMedic;

    /**
     * public Programare()
     * {
     * }
     //*/

    public Programare(int id, String numeClient, String prenumeClient, int data,
                      int ora, int cost, String numeMedic, String prenumeMedic)
    {
        this.id = id;
        this.numeClient = numeClient;
        this.prenumeClient = prenumeClient;
        this.data = data;
        this.ora = ora;
        this.cost = cost;
        this.numeMedic = numeMedic;
        this.prenumeMedic = prenumeMedic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeClient() {
        return  numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public String getPrenumeClient() {
        return  prenumeClient;
    }

    public void setPrenumeClient(String prenumeClient) {
        this.prenumeClient = prenumeClient;
    }

    public int getData() {
        return  data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNumeMedic() {
        return  numeMedic;
    }

    public void setNumeMedic(String numeMedic) {
        this.numeMedic = numeMedic;
    }

    public String getPrenumeMedic() {
        return  prenumeMedic;
    }

    public void setPrenumeMedic() {
        this.prenumeMedic = prenumeMedic;
    }

    @Override
    public String toString() {
        return "Programarea cu numarul " + id + " facuta de " + numeClient + " " +
                prenumeClient + " " + " pe data de " + data + ", la ora  " + ora +
                " este la medicul " + numeMedic + " " + prenumeMedic + ".\n";
    }
}


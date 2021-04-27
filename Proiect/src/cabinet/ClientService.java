package cabinet;

import cabinet.readwriteservice.WriteService;

import java.util.Arrays;
import java.util.Scanner;

public class ClientService {
    public static void afisMeniu() {
        System.out.println("Meniul pentru pacienti: ");
        System.out.println("1. Afisare lista pacienti; ");
        System.out.println("2. Afisare lista pacientilor copii; ");
        System.out.println("3. Afisare lista pacientilor salariati; ");
        System.out.println("4. Afisare lista pacientilor pensionari; ");
        System.out.println("5. Adaugare pacient; ");
        System.out.println("6. Afisare lista sortata a pacientilor; ");
        System.out.println("7. Editezi datele unei persoane; ");
        System.out.println("8. Daca vrei sa iesi... apasa 8...");
    }

    public static void afisareClienti(Client[] listaClienti)
    {
        System.out.println("Lista pacientilor este: ");
        for (Client client : listaClienti)
            System.out.println(client.toString());
        System.out.println();

        WriteService.writeIstoric("afisareClienti", true);
    }

    public static void afisareCopii(Client[] listaClienti)
    {
        System.out.println("Lista pacientilor este: ");
        for (Client client : listaClienti)
            if (client.getClass().equals(Copil.class))
                System.out.println(client.toString());
        System.out.println();

        WriteService.writeIstoric("afisareCopii", true);
    }

    public static void afisareSalariati(Client[] listaClienti)
    {
        System.out.println("Lista pacientilor este: ");
        for (Client client : listaClienti)
            if (client.getClass().equals(Salariat.class))
                System.out.println(client.toString());
        System.out.println();

        WriteService.writeIstoric("afisareSalariati", true);
    }

    public static void afisarePensionari(Client[] listaClienti)
    {
        System.out.println("Lista pacientilor este: ");
        for (Client client : listaClienti)
            if (client.getClass().equals(Pensionar.class))
                System.out.println(client.toString());
        System.out.println();

        WriteService.writeIstoric("afisarePensionari", true);
    }

    // functia de sortare
    public static void afisareListaClientiSortat(Client[] listaClienti)
    {
        System.out.println("Lista pacientilor sortata dupa id: ");
        for (Client c : listaClienti)
            System.out.println(c.toString());
        SortComparator sortare = new SortComparator();
        Arrays.sort(listaClienti, sortare);
        System.out.println("\nLista clientilor sortata dupa nume si prenume: ");
        for (Client c : listaClienti)
            System.out.println(c.toString());
        System.out.println();

        WriteService.writeIstoric("afisareListaClientiSortat", true);
    }

    public static Client[] adaugaClient(Client[] listaClienti, Client client) {
        Client[] listaClientiNoua = new Client[listaClienti.length + 1];
        for (int i = 0; i < listaClienti.length; i++)
            listaClientiNoua[i] = listaClienti[i];
        listaClientiNoua[listaClienti.length] = client;

        WriteService.writeIstoric("adaugaClient", true);
        return listaClientiNoua;
    }

    public static Client[] afisareAdaugaClient(Client[] listaClienti)
    {
        System.out.println("Adauga pacient: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numele pacientului: ");
        String nume = scanner.nextLine();
        System.out.println("Prenumele pacientului: ");
        String prenume = scanner.nextLine();
        System.out.println("Sexul pacientului (M - mascului / F - feminin: ");
        String sexul = scanner.nextLine();
        char sex = sexul.charAt(0);
        System.out.println("Varsta pacientului: ");
        int varsta = scanner.nextInt();
        System.out.println("CNP-ul pacientului: ");
        String CNP = scanner.next();
        System.out.println("Numarul de afectiuni ale pacientului: ");
        int nrAfectiuni = scanner.nextInt();
        System.out.println("Afectiunile pacientului: ");
        String[] afectiuni = new String[nrAfectiuni];
        for (int i = 0; i < nrAfectiuni; i++) {
            String afectiune = scanner.next();
            afectiuni[i] = afectiune;
        }
        Client client = new Client(nume, prenume, sex, varsta, CNP, afectiuni);
        System.out.println(client.toString());

        listaClienti = ClientService.adaugaClient(listaClienti, client);

        WriteService.writeIstoric("afisareAdaugaClient", true);
        return listaClienti;
    }

    public static Client[] editarePersoana (Client[] listaClienti) {
        System.out.println("Introduceti CNP - ul persoanei careia doriti sa-i schimbati datele: ");
        Scanner scanner = new Scanner (System.in);
        String CNP = scanner.nextLine();
        System.out.println(("Ce doriti sa modificati la pacient?"));
        System.out.println("1. Nume; ");
        System.out.println("2. Prenume; ");
        System.out.println("3. Sexul; ");
        System.out.println("4. Varsta; ");

        System.out.println("5. Afectiunile;");
        int optiune = scanner.nextInt();
        for(Client client : listaClienti){
            if(client.getCNP().equals(CNP)){
                if (optiune == 1)
                {
                    System.out.println("Introduceti noul nume: ");
                    String nume = scanner.nextLine();
                    client.setNume(nume);
                }
                else if (optiune == 2)
                {
                    System.out.println("Introduceti noul prenume: ");
                    String prenume = scanner.nextLine();
                    client.setNume(prenume);
                }
                else if (optiune == 3)
                {
                    System.out.println("Introduceti noul sex: ");
                    String sexul = scanner.nextLine();
                    char sex = sexul.charAt(0);
                    client.setSex(sex);
                }
                else if (optiune == 4)
                {
                    System.out.println("Introduceti noua varsta: ");
                    int varsta = scanner.nextInt();
                    client.setVarsta(varsta);
                }
                else if (optiune == 5)
                {
                    System.out.println("Introduceti afectiunile: ");
                    int nrAfectiuni = client.getAfectiuni().length;
                    String[] afectiuni = new String[nrAfectiuni];
                    for (int i = 0; i < nrAfectiuni; i++) {
                        String afectiune = scanner.nextLine();
                        afectiuni[i] = afectiune;
                    }
                }
                break;
            }
        }

        WriteService.writeIstoric("editarePersoana", true);
        return listaClienti;
    }
}

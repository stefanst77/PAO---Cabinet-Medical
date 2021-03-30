import cabinet.*;

import java.util.Scanner;

public class Main {
    public static void Init(Client[] listaClienti){
        while (true)
        {
            ClientService.afisMeniu();
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nAlegeti o optiune: ");
            int optiune = scanner.nextInt();
            if (optiune == 1)
                ClientService.afisareClienti(listaClienti);
            else if (optiune == 2)
                ClientService.afisareCopii(listaClienti);
            else if (optiune == 3)
                ClientService.afisareSalariati(listaClienti);
            else if (optiune == 4)
                ClientService.afisarePensionari(listaClienti);
            else
                ClientService.afisareAdaugaClient(listaClienti);
        }
    }

    public static void main (String[] args) {

        Client client1 = new Client("Popa", "Crizantem", 'M', 25, "512345678910", new String[] {"tuse", "febra"});
        Client client2 = new Pensionar("Ana", "Maria", 'F', 18, "3109876543212", new String[]{"durere spate", "ceva"}, 105, 500, 7);
        Client client3 = new Copil("Carl", "Stefan", 'M', 25, "515378910", new String[]{"tuse", "febra", "migrene"}, "Cutare", "cumva", "0712345678");
        Client client4 = new Client("Popa", "Alin", 'M', 25, "513278910", new String[]{"tuse", "febra", "ciuma"});
        Client client5 = new Salariat("Popa", "Popica", 'F', 25, "512310", new String[]{"tuse", "febra", "roseata"}, 57, "IBM");
        Client client6 = new Copil("Carl", "Vasile", 'M', 25, "512345678910", new String[]{"tuse", "febra", "greata"}, "Ceva", "altceva", "123456789053");
        Client client7 = new Client("Arthur", "Cosmin", 'M', 25, "512345678910", new String[]{"tuse", "febra", "arsura"});
        Client client8 = new Salariat("Popa", "Alex", 'F', 25, "512345678910", new String[]{"tuse", "febra", "ceva"}, 1123, "Apple");
        Client client9 = new Client("Ferdinand", "Savin", 'M', 25, "512378910", new String[]{"tuse", "febra", "minte"});
        Client client10 = new Pensionar("Ioana", "Crizantema", 'F', 25, "51234578910", new String[]{""}, 23423, 2000, 3);
        Client[] listaClienti = new Client[] {client1, client2, client3, client4, client5, client6, client7, client8, client9, client10};

        Init(listaClienti);
    }
}


import cabinet.*;
import cabinet.exceptions.FileReadingException;
import cabinet.exceptions.FileWritingException;
import cabinet.readwriteservice.ReadService;
import cabinet.readwriteservice.WriteService;
import cabinet.repo.MedicRepo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Object ReadService;

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
            else if (optiune == 5)
                listaClienti = ClientService.afisareAdaugaClient(listaClienti);
            else if (optiune == 6)
                ClientService.afisareListaClientiSortat(listaClienti);
            else if (optiune == 7)
                ClientService.editarePersoana(listaClienti);
            else if (optiune == 8) {
                System.out.println("\n\n\n\n （；´д｀）ゞ");
                WriteService.writeIstoric("\nAm terminat de rulat programul", true);
                break;
            }
            else
                System.out.println("Citeste iar si incearca sa faci ce spun... \n（；´д｀）ゞ");
        }
    }

    public static void main (String[] args) throws FileReadingException , FileWritingException{
        WriteService.writeIstoric("\nAm inceput sa rulez programul\n", true);
        // Client
        System.out.println("(づ￣ 3￣)づ\no(≧∀≦)o\n( ﾉ ﾟｰﾟ)ﾉ");
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
        listaClienti = cabinet.readwriteservice.ReadService.readClient(listaClienti);
        ClientService.afisareListaClientiSortat(listaClienti);
        WriteService.writeClient(listaClienti, false);

        //Medic
        ArrayList<Medic> medicArrayList = new ArrayList<>();
        medicArrayList = cabinet.readwriteservice.ReadService.readMedic(medicArrayList);
        System.out.println("Lista medicilor: ");
        for (Medic medic : medicArrayList) {
            System.out.print(medic);
        }
        WriteService.writeMedic(medicArrayList, false);

        // Programare
        Map<Integer, Programare> programariMap = new HashMap<>();
        programariMap = cabinet.readwriteservice.ReadService.readProgramare(programariMap);
        WriteService.writeProgramare(programariMap, false);

        // Reteta
        ArrayList<Reteta> retetaArrayList = new ArrayList<>();
        retetaArrayList = cabinet.readwriteservice.ReadService.readReteta(retetaArrayList);
        System.out.println("Lista retetelor: ");
        for (Reteta reteta : retetaArrayList) {
            System.out.print(reteta);
        }
        WriteService.writeReteta(retetaArrayList, false);

        Init(listaClienti);

        MedicRepo medicRepo = new MedicRepo();
        medicRepo.createTable();
        //System.out.println(medicRepo.createTable());
    }
}


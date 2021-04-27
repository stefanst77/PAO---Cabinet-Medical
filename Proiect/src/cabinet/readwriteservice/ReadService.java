package cabinet.readwriteservice;

import cabinet.*;
import cabinet.exceptions.FileReadingException;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class ReadService {
    // functie pentru citirea datelor Client
    public static Client[] readClient(Client[] listaClienti) throws FileReadingException {
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/cabinet/files/Client_in.txt"))) {
            String line = buffer.readLine();
            ArrayList<Client> clienti = new ArrayList<>();

            while (line != null) {
                String[] lines = line.split(", ");
                Client client = new Client();
                client.setId(Integer.parseInt(lines[0]));
                client.setNume(lines[1]);
                client.setPrenume(lines[2]);
                client.setSex(lines[3].toCharArray()[0]);
                client.setVarsta(Integer.parseInt(lines[4]));
                client.setCNP(lines[5]);

                String[] afectiuni = new String[lines.length - 6];
                int x = 0;
                for (int j = 6; j < lines.length; j++) {
                    afectiuni[x] = lines[j];
                    x += 1;
                }
                client.setAfectiuni(afectiuni);

                clienti.add(client);
                line = buffer.readLine();
            }
            for (Client client : clienti) {
                listaClienti = ClientService.adaugaClient(listaClienti, client);
            }
            return listaClienti;
        } catch (IOException e) {
            throw new FileReadingException("Client: Eroare in metoda readUsingBufferedReader, cauta si rezolva!", e);
        }
    }

    // functie pentru citirea datelor Medic
    public static ArrayList<Medic> readMedic(ArrayList<Medic> medicArrayList) throws FileReadingException {
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/cabinet/files/Medic_in.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                String[] lines = line.split(", ");
                Medic medic = new Medic();
                medic.setId(Integer.parseInt(lines[0]));
                medic.setNume(lines[1]);
                medic.setPrenume(lines[2]);
                medic.setSpecializare(lines[3]);
                medic.setNumarPacienti(Integer.parseInt(lines[4]));
                String[] pacienti = new String[medic.getNumarPacienti()];
                for (int j = 0; j < medic.getNumarPacienti(); j++)
                    pacienti[j] = lines[5 + j];
                medic.setPacienti(pacienti);

                medicArrayList.add(medic);
                line = buffer.readLine();
            }
            return medicArrayList;
        } catch (IOException e) {
            throw new FileReadingException("Medic: Eroare in metoda readUsingBufferedReader, cauta si rezolva!", e);
        }
    }

    // functie pentru citirea datelor Programare
    public static Map<Integer, Programare> readProgramare(Map<Integer, Programare> programariMap) throws FileReadingException {
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/cabinet/files/Programare_in.txt"))) {
            String line = buffer.readLine();
            Integer k = 0;
            for (Map.Entry<Integer, Programare> pair : programariMap.entrySet())
                k = pair.getKey();
            while (line != null) {
                String[] lines = line.split(", ");
                Programare programare = new Programare();
                programare.setId(Integer.parseInt(lines[0]));
                programare.setNumeClient(lines[1]);
                programare.setPrenumeClient(lines[2]);
                programare.setData(Integer.parseInt(lines[3]));
                programare.setOra(Integer.parseInt(lines[4]));
                programare.setCost(Integer.parseInt(lines[5]));
                programare.setNumeMedic(lines[6]);
                programare.setPrenumeMedic(lines[7]);

                k += 1;
                programariMap.put(k, programare);
                line = buffer.readLine();
            }
            return programariMap;

        } catch (IOException e) {
            throw new FileReadingException("Programare: Eroare in metoda readUsingBufferedReader, cauta si rezolva!", e);
        }
    }

    // functie pentru citirea datelor Client
    public static ArrayList<Reteta> readReteta(ArrayList<Reteta> retetaArrayList) throws FileReadingException {
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/cabinet/files/Reteta_in.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                String[] lines = line.split(", ");
                Reteta reteta = new Reteta();
                reteta.setIdReteta(Integer.parseInt(lines[0]));
                reteta.setIdClient(Integer.parseInt(lines[1]));
                reteta.setIdMedic(Integer.parseInt(lines[2]));
                reteta.setData(Integer.parseInt(lines[3]));
                String[] medicamente = new String[lines.length - 4];
                int x = 0;
                for (int j = 4; j < lines.length; j++) {
                    medicamente[x] = lines[j];
                    x += 1;
                }
                reteta.setMedicamente(medicamente);
                retetaArrayList.add(reteta);
                line = buffer.readLine();
            }
            return retetaArrayList;
        } catch (IOException e) {
            throw new FileReadingException("Reteta: Eroare in metoda readUsingBufferedReader, cauta si rezolva!", e);
        }
    }
}

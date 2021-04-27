package cabinet.readwriteservice;

import cabinet.Client;
import cabinet.Medic;
import cabinet.Programare;
import cabinet.Reteta;
import cabinet.exceptions.FileWritingException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


public class WriteService {
    // functie pentru afisarea datelor Client
    public static void writeClient(Client[] listaClienti, boolean append) throws FileWritingException{
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/Client_out.txt", append))) {
            for (Client client : listaClienti) {
                String text = client.toString() + "\n";
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Client: Eroare in metoda writeUsingBufferedWriter, cauta si rezolva!", e);
        }
    }

    // sunctie pentru afisarea datelor Medic
    public static void writeMedic(ArrayList<Medic> medicArrayList, boolean append) throws  FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/Medic_out.txt", append))) {
            for (Medic medic : medicArrayList) {
                String text = medic.toString() + "\n";
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Medic: Eroare in metoda writeUsingBufferedWriter, cauta si rezolva!", e);
        }
    }

    // functie pentru afisarea datelor Programare
    public static void writeProgramare(Map<Integer, Programare> programareMap, boolean append) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/Programare_out.txt", append))) {
            for (Map.Entry<Integer, Programare> pair : programareMap.entrySet()) {
                String text = "Programarea " + pair.getKey() + " : " + pair.getValue().toString() + "\n";
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Programare: Eroare in metoda writeUsingBufferedWriter, cauta si rezolva!", e);
        }
    }

    // functie pentru afisarea datelor Reteta
    public static void writeReteta(ArrayList<Reteta> retetaArrayList, boolean append) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/Reteta_out.txt", append))) {
            for (Reteta reteta : retetaArrayList) {
                String text = reteta.toString() + "\n";
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Reteta: Eroare in metoda writeUsingBufferedWriter, cauta si rezolva!\", e");
        }
    }

    // functie pentru a nota in fisierul 'History.txt' ca se apeleaza comenzile din etapa 1
    public static void writeIstoric(String text, boolean append) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/History.txt", append))) {
            Date data = new Date();
            long time = data.getTime();
            Timestamp ts = new Timestamp(time);
            String timestamp = ts.toString();
            String mesaj = text + ", " + timestamp + "\n";
            buffer.write(mesaj);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

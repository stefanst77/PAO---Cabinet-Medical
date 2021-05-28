package cabinet;

import cabinet.readwriteservice.WriteService;

import java.util.ArrayList;

public class MedicService {

    public static void afisareMeniu() {
        System.out.println();
    }

    public static void afisareListMedici(ArrayList<Medic> medicArrayList) {
        System.out.println("Lista tuturor Medicilor este :");
        for (Medic medic : medicArrayList) {
            System.out.println(medic.toString());
        }

        //afisez in istoric
        WriteService.writeIstoric("afisareListaMedici", true);

    }
}


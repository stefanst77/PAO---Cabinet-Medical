package cabinet;

import java.util.Comparator;

public class SortComparator implements Comparator<Client> {
    @Override
    public int compare (Client c1, Client c2) {
        if (c1.getNume().compareTo(c2.getNume()) == 0)
            return c1.getPrenume().compareTo(c2.getPrenume());
        return c1.getNume().compareTo(c2.getNume());
    }
}

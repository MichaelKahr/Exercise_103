
import java.util.Comparator;

public class SortByDateTime implements Comparator<Appointment> {

    @Override
    public int compare(Appointment o1, Appointment o2) {
        if (o1.getDate().isBefore(o2.getDate())) {
            return -1;
        } else if (o2.getDate().isBefore(o1.getDate())) {
            return 1;
        }
        return 0;
    }

}

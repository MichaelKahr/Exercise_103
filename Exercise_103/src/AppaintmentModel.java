
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.AbstractListModel;

public class AppaintmentModel extends AbstractListModel {

    private LinkedList<Appointment> appointments = new LinkedList<>();

    public void add(Appointment t) {
        appointments.add(t);
        fireIntervalAdded(this, 0, appointments.size() - 1);
        sort();
    }

    public void remove(Appointment t) {
        appointments.remove(t);
        fireContentsChanged(this, 0, appointments.size() - 1);
    }

    @Override
    public int getSize() {
        return appointments.size();
    }

    @Override
    public Object getElementAt(int index) {
        return appointments.get(index);
    }

    public void sort() {
        Collections.sort(appointments, new SortByDateTime());
        fireContentsChanged(this, 0, appointments.size() - 1);
    }

    public void save(File f) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(appointments);
            fos.close();
            oos.close();
        }
    }

    public void load(File f) throws Exception {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(f);
            in = new ObjectInputStream(fis);
            appointments = (LinkedList<Appointment>) in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

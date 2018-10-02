
import java.io.EOFException;
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

public void safe(File f)throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

        for (Appointment a : appointments) {
            oos.writeObject(a);
        }

        oos.flush();
        oos.close();
    }

    public void load(File f)throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        try{
            Appointment ap;
        while((ap = (Appointment) ois.readObject()) != null){
            appointments.add(ap);
        }
        }catch(EOFException eof){

        }

    }
    
    public void sortName(){
        Collections.sort(appointments);
        fireContentsChanged(this, 0, appointments.size()-1);
    }

}

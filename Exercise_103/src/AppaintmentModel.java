
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.AbstractListModel;

public class AppaintmentModel extends AbstractListModel{

    private LinkedList<Appointment> appointments = new LinkedList<>();
    
    public void add(Appointment t){
        appointments.add(t);
        fireIntervalAdded(this, 0, appointments.size()-1);
    }
    
    public void remove(Appointment t){
        appointments.remove(t);
        fireContentsChanged(this, 0, appointments.size()-1);
    }
    
    @Override
    public int getSize() {
        return appointments.size();
    }

    @Override
    public Object getElementAt(int index) {
        return appointments.get(index);
    }
    public void sort(){
        Collections.sort(appointments, new SortByDateTime());
        fireContentsChanged(this, 0, appointments.size()-1);
    }

}


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class VelocityTableModel extends AbstractTableModel {

    private static final String[] COLNAMES
            = {"Datum", "Uhrzeit", "Kennzeichen", "Gemessen", "Erlaubt", "Übertretung"};
    private ArrayList<Measurement> measurements = new ArrayList();

    public void add(Measurement m) {
        measurements.add(m);
        fireTableRowsInserted(measurements.size() - 1, measurements.size() - 1);
    }

    public void delete(int[] indices) {
        for (int i = indices.length - 1; i >= 0; i--) {
            measurements.remove(indices[i]);
            fireTableRowsDeleted(indices[i], indices[i]);
        }
    }

    public double averageViolation() {
        double x = 0;
        for (Measurement m : measurements) {
            x += m.berechneUebertretung();
        }
        return x / measurements.size();
    }

    public void load(File f) throws Exception {
        measurements.clear();
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(f));
        Object m = null;
        while ((m = ois.readObject()) != null) {
            add((Measurement) m);
        }
    }

    public void save(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(f));
        for (Measurement m : measurements) {
            oos.writeObject(m);
        }
        oos.flush();
    }

    @Override
    public String getColumnName(int column) {
        return COLNAMES[column];
    }

    @Override
    public int getRowCount() {
        return measurements.size();
    }

    @Override
    public int getColumnCount() {
        return COLNAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Measurement m = measurements.get(rowIndex);
        return m;
    }

}

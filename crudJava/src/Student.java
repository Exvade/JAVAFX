import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kobinath
 */
public class Student 
{
    private final StringProperty id;
    private final StringProperty nama;
    private final StringProperty npm;
    private final StringProperty  mk;
     
    public Student()
    {
        id = new SimpleStringProperty(this, "id");
        nama = new SimpleStringProperty(this, "nama");
        npm = new SimpleStringProperty(this, "npm");
        mk = new SimpleStringProperty(this, "mk");
    }

    public StringProperty idProperty() { return id; }
    public String getId() { return id.get(); }
    public void setId(String newId) { id.set(newId); }

    public StringProperty namaProperty() { return nama; }
    public String getNama() { return nama.get(); }
    public void setNama(String newNama) { nama.set(newNama); }

    public StringProperty npmProperty() { return npm; }
    public String getNPM() { return npm.get(); }
    public void setNPM(String newNPM) { npm.set(newNPM); }
    
    public StringProperty mkProperty() { return mk; }
    public String getMK() { return mk.get(); }
    public void setMK(String newMK) { mk.set(newMK); }
}
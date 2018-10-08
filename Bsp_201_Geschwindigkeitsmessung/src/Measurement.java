
import java.io.Serializable;
import java.time.LocalDateTime;


public class Measurement implements Serializable{
    private LocalDateTime datum;
    private String kennzeichen;
    private int erlaubt;
    private double gemessen;

    public Measurement(LocalDateTime datum, String kennzeichen, int erlaubt, double gemessen) {
        this.datum = datum;
        this.kennzeichen = kennzeichen;
        this.erlaubt = erlaubt;
        this.gemessen = gemessen;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public int getErlaubt() {
        return erlaubt;
    }

    public double getGemessen() {
        return gemessen;
    }
    
    public double berechneUebertretung(){
        return ((gemessen - (double) erlaubt) > 0 ? (gemessen - (double) erlaubt) : 0);
    }
    
}

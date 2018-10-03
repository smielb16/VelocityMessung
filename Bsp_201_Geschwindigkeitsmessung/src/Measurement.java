
import java.time.LocalDate;
import java.time.LocalTime;


public class Measurement {
    private LocalDate datum;
    private LocalTime uhrzeit;
    private String kennzeichen;
    private int erlaubt;
    private double gemessen;

    public Measurement(LocalDate datum, LocalTime uhrzeit, String kennzeichen, int erlaubt, double gemessen) {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.kennzeichen = kennzeichen;
        this.erlaubt = erlaubt;
        this.gemessen = gemessen;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public LocalTime getUhrzeit() {
        return uhrzeit;
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
        return gemessen - (double) erlaubt;
    }
    
}

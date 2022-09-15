package training.supportbank;
import java.time.LocalDate;
public class Transaction {
    //elements
    private LocalDate date;
    private String from;
    private String to;
    private String narrative;
    private float amount;

    //constructor
    public Transaction(LocalDate date, String from, String to, String narrative, float amount) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.narrative = narrative;
        this.amount = amount;
    }
    //getters
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getNarrative() {
        return narrative;
    }
    public float getAmount() {
        return amount;
    }
}

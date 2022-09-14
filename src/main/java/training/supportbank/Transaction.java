package training.supportbank;
import java.time.LocalDate;

public class Transaction {
    //elements
    protected LocalDate date;
    protected String from;
    protected String to;
    protected String narrative;
    protected float amount;
    //constructor
    public Transaction(LocalDate date, String from, String to, String narrative, float amount){
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

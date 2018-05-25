package training.supportbank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Transaction {

    private final LocalDate date;
    private final String from;
    private final String to;
    private final String narrative;
    private final float amount;

    public Transaction(String date, String from, String to, String narrative, String amount) {
        this.date = getDate(date);
        this.from = from;
        this.to = to;
        this.narrative = narrative;
        this.amount = getAmount(amount);
    }

    public String getFrom() {return from;}

    public String getTo() {return to;}

    public float getAmount() {return amount;}

    public LocalDate getDate() {
        return date;
    }

    public String getNarrative() {
        return narrative;
    }

    private LocalDate getDate(String date) {
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateObject = LocalDate.parse(date, formatter);
        return dateObject;
    }

    private float getAmount(String amount) {
        float amountFloat = 0;
        try {
            amountFloat = Float.parseFloat(amount);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return amountFloat;
    }

}

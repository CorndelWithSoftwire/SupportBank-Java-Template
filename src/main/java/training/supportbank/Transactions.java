package training.supportbank;

import java.math.BigDecimal;

class Transactions {
    private String Date;
    private String To;
    private String From;
    private String Narrative;
    private BigDecimal Amount;

    //Date,From,To,Narrative,Amount

    public Transactions(String inputDate, String inputFrom, String inputTo, String inputNarrative, BigDecimal inputAmount) {
        Date = inputDate;
        From = inputFrom;
        To = inputTo;
        Narrative = inputNarrative;
        Amount = inputAmount;
    }
    public String toString(){
        return String.format("person:%s owes, %s amount £%s for reason:%s", From, To, Amount, Narrative);
    }

    public String getDate() {
        return Date;
    }

    public String getTo(){return To;}
    public String getFrom(){return From;}
    public String getNarrative(){return Narrative;}
    public BigDecimal getAmount() {
        return Amount;
    }
}

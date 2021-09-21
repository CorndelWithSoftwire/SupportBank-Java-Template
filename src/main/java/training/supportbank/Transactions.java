package training.supportbank;

class Transactions {
    private String Date;
    private String To;
    private String From;
    private String Narrative;
    private double Amount;

    //Date,From,To,Narrative,Amount

    public Transactions(String inputDate, String inputFrom, String inputTo, String inputNarrative, double inputAmount) {
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
}

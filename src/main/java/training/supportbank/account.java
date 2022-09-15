package training.supportbank;

public class account {
    //elements
    private String name;
    private float balance;
    //constructor
    public account (String name, float balance){
        this.name = name;
        this.balance = balance;
    }
    //getters
    public String getName() {return name;}
    public float getBalance() {return balance;}
    //method
    public void AddBal(float amount){this.balance += amount;}
}

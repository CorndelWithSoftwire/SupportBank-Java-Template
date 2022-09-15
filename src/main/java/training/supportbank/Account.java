package training.supportbank;

public class Account {
    //elements
    private String name;
    private float balance;

    //constructor
    public Account(String name, float balance) {
        this.name = name;
        this.balance = balance;
    }
    public String getName() {return name;}
    public float getBalance() {return balance;}
    //method
    public void Addbal(float amount){this.balance += amount}
}

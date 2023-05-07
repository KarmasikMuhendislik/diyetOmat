package entity;

public class Money {
   /* private int id;
    private String banknoteType;
    private int banknoteValue;
    private int banknoteSize;
    private int banknoteTotal;*/
    //Yeterli zaman olması durumunda yukarıdaki işlem gerçeklenecek.
    private int id;
    private int moneyAmount;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMoneyAmount() {
        return moneyAmount;
    }
    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}

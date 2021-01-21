import java.math.BigDecimal;

public class ClientWtihMoney extends FullClient {
    private BigDecimal balance;

    ClientWtihMoney(String name, int id, BigDecimal balance) {
        super(name, id);
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

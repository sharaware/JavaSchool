package model;

import java.math.BigDecimal;

public class ClientWithMoney extends FullClient {
    private BigDecimal balance;

    public ClientWithMoney(String name, int id, BigDecimal balance) {
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

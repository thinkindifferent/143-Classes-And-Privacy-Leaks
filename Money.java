import java.text.NumberFormat;
import java.util.Locale;

public class Money {
    private int dollars;
    private int cents;

    /**
     * No-arg constructor initializes the Money to $0.00.
     */
    public Money() {
        dollars = 0;
        cents = 0;
    }

    /**
     * Constructor that takes in a dollar amount.
     * @param dol
     */
    public Money(int dol) {
        dollars = dol;
        cents = 0;
    }

    /**
     * Constructor that takes in both a dollar and cents amount.
     * @param dol
     * @param cent
     */
    public Money(int dol, int cent) {
        dollars = dol;
        cents = cent;
    }

    /**
     * Copy constructor for Money objects.
     * @param other
     */
    public Money(Money other) {
        this.dollars = other.dollars;
        this.cents = other.cents;
    }

    //Getters and setters for dollars and cents. setMoney first rounds any cents value to the nearest dollar if needed.

    public int getDollars() {
        return this.dollars;
    }

    public int getCents() {
        return this.cents;
    }

    public void setMoney(int dollars, int cents) {
        this.dollars = dollars;
        if (validCents(cents)) {
            this.cents = cents;
        } else {
            fixCents(cents);
        }
    }

    //Returns a double version of the Money value.
    public double getMoney() {
        String moneyString = dollars + "." + cents;
        return Double.parseDouble(moneyString);
    }

    /**
     * Adds a specified amount to Money.
     * @param dollars
     */
    public void add(int dollars) {
        this.dollars += dollars;
    }

    /**
     * Adds a specified amount to Money, both dollars and cents.
     * @param dollars
     * @param cents
     */
    public void add(int dollars, int cents) {
        this.dollars += dollars;

        int tempCents = this.cents;

        if (validCents(tempCents + cents)) {
            this.cents += cents;
        } else {
            fixCents(tempCents + cents);
        }
        
    }

    /**
     * Adds an existing Money object to the current instance.
     * @param other
     */
    public void add(Money other) {
        this.dollars += other.dollars;

        int tempCents = this.cents;

        if (validCents(tempCents + other.cents)) {
            this.cents += other.cents;
        } else {
            fixCents(tempCents + other.cents);
        }
    }

    @Override
    /**
     * Overridden equals method.
     */
    public boolean equals(Object other) {
        if ((other == null) || (other.getClass() != getClass())) {
            return false;
        } else {
            Money that = (Money) other;
            return ((this.dollars == that.dollars) && (this.cents == that.cents));
        }

    }

    @Override
    /**
     * Overridden toString method, returns a $0.00 String for the money amount.
     */
    public String toString() {

        NumberFormat formatMoney = NumberFormat.getCurrencyInstance(Locale.US);
        return formatMoney.format(getMoney());
    }

    //Helper method to check if cents exceeds 99.
    private boolean validCents(int cent) {
        if (cent > 99) {
            return false;
        } else {
            return true;
        }
    }

    //Reduces cents to < 99 and adds the rounded cents to dollars.
    private void fixCents(int cent) {
        if (!validCents(cent)) {
            int remainingCents = cent % 100;
            int dolConvert = cent / 100;

            cents = remainingCents;
            dollars = dollars + dolConvert;
        }
    }
}
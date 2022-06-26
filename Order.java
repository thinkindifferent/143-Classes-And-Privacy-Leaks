public class Order {
    private Money amount;
    private Date orderDate;
    private Date sentDate;
    private String customer;
    private String item;
    
    /**
     * Constructor that takes in a Money object for the order's amount, a Date object
     * for the order date, a String for the customer's name, and a String for the
     * name of the item ordered.
     * @param amount
     * @param orderDate
     * @param customer
     * @param item
     */
    public Order(Money amount, Date orderDate, String customer, String item) {
        this.amount = new Money(amount);
        this.orderDate = new Date(orderDate);
        this.customer = customer;
        this.item = item;
    }
    
    /**
     * Copy constructor for an Order, assumes that everything is valid in the
     * inputted object (or null for sentDate if the order is not fulfilled).
     * @param toCopy
     */
    public Order(Order toCopy) {
        this.amount = toCopy.amount;
        this.orderDate = toCopy.orderDate;
        this.sentDate = toCopy.sentDate;
        this.customer = toCopy.customer;
        this.item = toCopy.item;
    }
    
    //Getters for the instance variables, Money and Date types return a new copied object.

    public Money getAmount() {
        return new Money(amount);
    }
    
    public Date getOrderDate() {
        return new Date(orderDate);
    }
    
    public String getCustomer() {
        return customer;
    }
    
    public String getItem() {
        return item;
    }
    
    //Assumes that the sentDate is already valid.
    public boolean isFulfilled() {
        if (sentDate == null) {
            return false;
        } else {
            return true;
        }
    }
    
    //Setters for the instance variables, Money and Date types are assigned copies of the original.

    public boolean setFulfilled(Date dateSent) {
        if (!(orderDate.isAfter(dateSent))) {
            return false;
        } else {
            sentDate = new Date(dateSent);
            return true;
        }
    }
    
    /**
     * Sets the order date using a Date object if no sent date is present.
     * @param nextDate
     * @return
     */
    public boolean setOrderDate(Date nextDate) {
        if (sentDate != null) {
            return false;
        } else {
            orderDate = new Date(nextDate);
            return true;
        }
    }
    
    /**
     * Sets the order amount if no sent date is present.
     * @param amount
     * @return
     */
    public boolean setAmount(Money amount) {
        if (sentDate != null) {
            return false;
        } else {
            this.amount = new Money(amount);
            return true;
        }
    }
    
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    @Override
    /**
     * Overridden toString method that lists the order's item, amount, order date, 
     * and whether or not it is fulfilled.
     */
    public String toString() {
        String retString = "";
        String paidString = "N/A";
        boolean paid = false;
        
        if (sentDate != null) {
            paidString = sentDate.toString();
            paid = true;
        }
        
        retString = "Item: " + item + "\nAmount: " + amount + "\nOrder Date: " + orderDate + "\nFulfilled: " + paid + "\nFulfilled Date: " + paidString;
        return retString;
    }
    
    @Override
    /**
     * Overridden equals method.
     */
    public boolean equals(Object toCompare) {
        if ((toCompare == null) || !(toCompare instanceof Order)) {
            return false;
        }
        
        Order that = (Order) toCompare;
        
        if (this.customer.equals(that.customer) && this.item.equals(that.item)) {
            return true;
        } else {
            return false;
        }
    }

}

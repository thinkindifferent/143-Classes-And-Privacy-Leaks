public class Driver {
    public static void main(String[] args) {

        //Separate driver created before using JUnit for testing each class.
        
        moneyTests();

        dateTests();

        orderTests();

        System.out.println(new Date(1, 1, 2000));
    }

    public static void moneyTests() {
        Money moneyTest = new Money(68, 42);

        System.out.println("getMoney moneyTest, should be 68.42: " + moneyTest.getMoney());
        moneyTest.add(31, 58);
        System.out.println("add moneyTest, should be 100.0 dollars: " + moneyTest.getMoney());
        System.out.println("toString moneyTest of object moneyTest, should be $100.00: " + moneyTest);

        Money otherMoneyTest = new Money (100, 99);
        System.out.println("object otherMoneyTest: " + otherMoneyTest);
        moneyTest.add(otherMoneyTest);
        System.out.println("adding otherMoneyTest to moneyTest, should be 200.99: " + moneyTest.getMoney());
        System.out.println("moneyTest equals otherMoneyTest: " + moneyTest.equals(otherMoneyTest));

        otherMoneyTest.setMoney(200, 99);
        System.out.println("set otherMoneyTest to $200.99, should be equal to moneyTest: " + otherMoneyTest.equals(moneyTest));
    }

    public static void dateTests() {
        Date dateTest = new Date(9, 31, 2025);
        System.out.println("toString test: " + dateTest);

        Date dateTest2 = new Date(9, 31, 2024);

        System.out.println("isAfter test, should be true: " + dateTest2.isAfter(dateTest));
        System.out.println("equals test, should be false: " + dateTest.equals(dateTest2));
    }

    public static void orderTests() {
        Money moneyForOrder = new Money(6, 99);
        Date dateOfOrder = new Date(10, 27, 2021);
        Date badDate = new Date(10, 27, 2018);
        Date fulfillDate = new Date(10, 30, 2021);
        Order orderTest = new Order(moneyForOrder, dateOfOrder, "Joe", "Burger");

        System.out.println("toString test: " + orderTest);
        System.out.println("orderTest is fulfilled, should be false: " + orderTest.isFulfilled());

        System.out.println("Setting fulfilled date to 10/30/2021: " + orderTest.setFulfilled(fulfillDate));

        System.out.println("isFulfilled test, should be true: " + orderTest.isFulfilled());
        System.out.println("setOrderDate test with bad date 10/27/2018: " + orderTest.setOrderDate(badDate));
        System.out.println("Reprinting order date: " + orderTest.getOrderDate());

        System.out.println("setAmount test, should not change 6.99 and should be false: " + orderTest.setAmount(new Money(20, 75)));

        System.out.println(orderTest);
    }
}

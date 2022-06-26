

/*
 * JUnit tests for Date, Money, and Bill classes
 * @author Lesley Kalmin
 *  CSS143
 */

import static org.junit.Assert.*;

import org.junit.Test;


public class DateMoneyOrderJUnit {

	@Test
	public void ConstructMoneyTest() {
		Money money1 = new Money(10);
		
		assertEquals(10, money1.getDollars());		
	}
	
	@Test
	public void SetMoneyTest()
	{
		Money money1 = new Money();
		
		money1.setMoney(30,50);
        assertEquals(30, money1.getDollars());      
        assertEquals(50, money1.getCents());
	}
	
	@Test
	public void ConstructMoneyCopyTest() {
		Money money1 = new Money();
		money1.setMoney(10,40);		
		
        Money money2 = new Money(money1);
        
        assertEquals(10, money1.getDollars());       
        assertEquals(40, money2.getCents());
	}
	
	@Test
	public void PrintMoneyTest()
	{
		Money money1 = new Money(10);

        money1.setMoney(30,50);
        assertEquals("$30.50", money1.toString());
		
	}

	/**
	 * Start of new JUnit tests
	 */

	 /**
	  * Additional Money class tests
	  */
	 @Test
	 public void AddMoneyTest() {
		Money money1 = new Money(100);
		Money money2 = new Money(300);

		money1.add(money2);
		assertEquals("$400.00", money1.toString());

		money1.add(50);
		assertEquals("$450.00", money1.toString());

		money1.add(49, 99);
		assertEquals("$499.99", money1.toString());
	 }

	 @Test
	 public void MoneyEqualsTest() {
		Money money1 = new Money(100);
		Money money2 = new Money(101, 39);
		Money money3 = new Money(100);

		assertEquals(false, money1.equals(money2));
		assertEquals(true, money1.equals(money3));
	 }

	 /**
	  * Date class tests
	  */
	 @Test
	 public void DateGetterTests() {
		Date sampleDate = new Date (12, 25, 2020);

		assertEquals(12, sampleDate.getMonth());
		assertEquals(25, sampleDate.getDay());
		assertEquals(2020, sampleDate.getYear());
	 }

	 @Test
	 public void DateSetterTests() {
		 Date newDate = new Date(2, 28, 2019);

		 newDate.setMonth(9);
		 assertEquals(9, newDate.getMonth());
		 newDate.setDay(20);
		 assertEquals(20, newDate.getDay());
		 newDate.setYear(2017);
		 assertEquals(2017, newDate.getYear());

		 newDate.setAll(5, 15, 2016);
		 assertEquals("05/15/2016", newDate.toString());
	 }

	 @Test
	 public void DateEqualsToStringTest() {
		 Date theDate = new Date(3, 30, 2021);
		 Date otherDate = new Date(5, 1, 2020);
		 Date equalDate = new Date(3, 30, 2021);
		 Money notADate = new Money(100);

		 assertEquals(false, theDate.equals(otherDate));
		 assertEquals(false, theDate.equals(notADate));
		 assertEquals(true, theDate.equals(equalDate));
		 assertEquals("03/30/2021", theDate.toString());
	 }

	 @Test
	 public void DateIsAfterTest() {
		 Date date1 = new Date(12, 31, 2020);
		 Date date2 = new Date(6, 30, 2024);

		 assertEquals(true, date1.isAfter(date2));
	 }

	 /**
	  * Order class tests
	  */
	 @Test
	 public void OrderGetterTests() {
		 Order order1 = new Order(new Money(12), new Date(7, 4, 2017), "Joe", "Pizza");

		 assertEquals("$12.00", order1.getAmount().toString());
		 assertEquals("07/04/2017", order1.getOrderDate().toString());
		 assertEquals("Joe", order1.getCustomer());
		 assertEquals("Pizza", order1.getItem());
	 }

	 @Test
	 public void OrderSetterTests() {
		 Order test = new Order(new Money(9, 99), new Date(5, 8, 2020), "Bill", "Pasta");

		 test.setAmount(new Money(10, 99));
		 test.setOrderDate(new Date (5, 7, 2020));
		test.setCustomer("Will");
		
		assertEquals("$10.99", test.getAmount().toString());
		assertEquals("05/07/2020", test.getOrderDate().toString());
		assertEquals("Will", test.getCustomer());
	 }

	 @Test
	 public void OrderEqualsToStringTests() {
		 Order anotherOrder = new Order(new Money(12, 99), new Date(4, 10, 2016), "Emily", "Club Sandwich");
		Order equalsTest = new Order(new Money(13), new Date(4, 10, 2016), "Emma", "BLT");

		assertEquals(false, anotherOrder.equals(equalsTest));
		assertEquals("Item: Club Sandwich\nAmount: $12.99\nOrder Date: 04/10/2016\nFulfilled: false\nFulfilled Date: N/A" , anotherOrder.toString());
		 
	 }

	 @Test
	 public void OrderFulfilledTests() {
		 Order yetAnotherOrder = new Order(new Money(18, 50), new Date(10, 31, 2019), "Meredith", "Cappuccino");
		 
		 assertEquals(true, yetAnotherOrder.setFulfilled(new Date(11, 1, 2019)));
		 assertEquals(true, yetAnotherOrder.isFulfilled());

		 Order badOrder = new Order(new Money(20, 99), new Date(12, 31, 2018), "Logan", "Hot Dog");

		 assertEquals(false, badOrder.setFulfilled(new Date(12, 29, 2018)));
		 assertEquals(false, badOrder.isFulfilled());
	 }
}

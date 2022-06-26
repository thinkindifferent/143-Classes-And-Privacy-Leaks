public class Date {
    private int month;
    private int day;
    private int year;

    /**
     * Constructor that takes in a value for month, day, and year.
     * @param month
     * @param day
     * @param year
     */
    public Date(int month, int day, int year) {
        checkDate(month, day, year);
        if (validDate(month, day, year)) {
            this.month = month;
            this.day = day;
            this.year = year;
        }
    }

    /**
     * Copy constructor for Date objects.
     * @param other
     */
    public Date(Date other) {
        this.month = other.month;
        this.day = other.day;
        this.year = other.year;
    }

    //Getters and setters for Dates. Since they're all primitives no need for a copy to be returned.
    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        if (validMonth(month)) {
            this.month = month;
        }
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        if (validDay(day)) {
            this.day = day;
        }
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        if (validYear(year)) {
            this.year = year;
        }
    }

    /**
     * Sets the Date to an entirely new date.
     * @param month
     * @param day
     * @param year
     */
    public void setAll(int month, int day, int year) {
        if (validDate(month, day, year)) {
            this.month = month;
            this.day = day;
            this.year = year;
        }
    }

    /**
     * Checks if compareTo is after the current instance of Date.
     * @param compareTo
     * @return
     */
    public boolean isAfter(Date compareTo) {
        if (compareTo.year > this.year) {
            return true;
        } else if (compareTo.month > this.month) {
            return true;
        } else if (compareTo.day > this.day) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    /**
     * Overridden equals method.
     */
    public boolean equals(Object date) {
        if ((date == null) || (date.getClass() != getClass())) {
            return false;
        } else {
            Date that = (Date) date;
            return ((this.month == that.month) && (this.day == that.day) && (this.year == that.year));
        }
    }

    @Override
    /**
     * Overridden toString method that returns the Date in MM/DD/YYYY format.
     */
    public String toString() {
        return adjust(month) + "/" + adjust(day) + "/" + year;
    }

    //Helper methods to check if an inputted month, day, year, etc., are legal values.
    private boolean validMonth(int m) {
        if ((m < 1) || (m > 12)) {
            return false;
        } else {
            return true;
        }
    }

    
    private boolean validDay(int d) {
        if ((d < 1) || (d > 31)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validYear(int y) {
        if ((y < 2016) || (y > 2026)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validDate(int m, int d, int y) {
        if (validMonth(m) && validDay(d) && validYear(y)) {
            return true;
        } else {
            return false;
        }
    }

    private void checkDate(int m, int d, int y) {
        if (!validDate(m, d, y)) {
            System.out.println("Fatal error: Invalid date.");
            System.out.println("Exiting program...");
            System.exit(0);
        }
    }

    private String adjust(int value) {
        String retString = Integer.toString(value);
        if (value < 10) {
            retString = 0 + retString;
        }
        return retString;
    }
}

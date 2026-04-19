public class Mobile extends Gadget {
    private int credit;

    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight, size); // Sends data to the Gadget class
        this.credit = credit;
    }

    public void addCredit(int amount) {
        if (amount > 0) {
            credit += amount;
        } else {
            System.out.println("Error: Enter a positive amount.");
        }
    }

    public void makeCall(String number, int duration) {
        if (credit >= duration) {
            System.out.println("Calling " + number + " (" + duration + " mins)");
            credit -= duration;
        } else {
            System.out.println("Insufficient credit.");
        }
    }

    @Override
    public void display() {
        super.display(); // Prints the Gadget info
        System.out.println("Credit: " + credit + " minutes");
    }
}
public class Gadget {
    // These are 'private' to ensure Encapsulation
    private String model;
    private double price;
    private int weight;
    private String size;

    /**
     * Constructor: Initialises the attributes with values from parameters.
     */
    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    // Accessor methods (Getters)
    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getSize() {
        return size;
    }

    /**
     * Outputs suitably annotated details about the gadget.
     */
    public void display() {
        System.out.println("--- Gadget Details ---");
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + "g");
        System.out.println("Size: " + size);
    }
}
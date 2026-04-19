public class MP3 extends Gadget {
    private double availableMemory;

    public MP3(String model, double price, int weight, String size, double memory) {
        super(model, price, weight, size);
        this.availableMemory = memory;
    }

    public void downloadMusic(double size) {
        if (availableMemory >= size) {
            availableMemory -= size;
        } else {
            System.out.println("Not enough memory.");
        }
    }

    public void deleteMusic(double size) {
        availableMemory += size;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Available Memory: " + availableMemory + "MB");
    }
}
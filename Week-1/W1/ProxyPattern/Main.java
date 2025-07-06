package ProxyPattern;

interface Image {
    void display();
}
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // Lazy initialization
        } else {
            System.out.println("Using cached image: " + filename);
        }
        realImage.display();
    }
}
public class Main {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("Parrot.png");
        Image img2 = new ProxyImage("Squirrel.png");

        // First display - triggers load
        img1.display();

        // First display for a different image
        img2.display();
    }
}

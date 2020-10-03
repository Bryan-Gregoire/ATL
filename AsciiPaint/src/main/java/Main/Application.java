package Main;

import Paint.AsciPaint;

/**
 *
 * @author Utilisateur
 */
public class Application {

    private AsciPaint paint;

    public Application() {
        this.paint = new AsciPaint();
    }

    public void start(String[] args) {
        
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start(args);
    }
}
package esi.atl.g53735.Controller;

import esi.atl.g53735.Model.Model;
import esi.atl.g53735.View.InterfaceView;
import esi.atl.g53735.View.View;
import java.util.Scanner;

/**
 *
 * @author g53735
 */
public class Application {

    private Model paint;
    private InterfaceView view;
    private Scanner keyboard;

    public Application(Model paint, View interfaceView) {
        this.paint = paint;
        this.view = interfaceView;
        keyboard = new Scanner(System.in);
    }

    public void start() {
        boolean end = false;
        while (!end) {
            checkCommand();

            view.displayShape(this.paint.asAscii());
        }
    }

    public void checkCommand() {
        view.displayMessage("Enter the shape you want to add: ");
        String command = keyboard.nextLine().toLowerCase();
        String[] commands = command.split(" ");
        while (!"show".equals(commands[0]) || !"add".equals(commands[0])
                || !"rectangle".equals(commands[1])
                || !"circle".equals(commands[1])
                || !"square".equals(commands[1])) {
            keyboard.next();
            view.displayMessage("Enter again : ");
            String newCommand = keyboard.nextLine().toLowerCase();
            commands = newCommand.split(" ");
        }   
    }
}

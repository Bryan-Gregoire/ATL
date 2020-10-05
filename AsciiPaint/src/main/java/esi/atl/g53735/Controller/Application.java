package esi.atl.g53735.Controller;

import esi.atl.g53735.Model.AsciiPaint;
import esi.atl.g53735.Model.Model;
import esi.atl.g53735.View.InterfaceView;
import esi.atl.g53735.View.View;
import java.util.Scanner;

/**
 *
 * @author g53735
 */
public class Application {

    private final Model paint;
    private final InterfaceView view;
    private final Scanner keyboard;

    public Application(View interfaceView) {
        this.paint = new AsciiPaint();
        this.view = interfaceView;
        this.keyboard = new Scanner(System.in);
    }

    public void start() {
        view.displayMessage("what shapes do you want to add? "
                + "(Rectangles, squares or circles)");
        view.displayMessage("A command is written as: add "
                + "wantedShape positionOfShape (height width Or Radius) "
                + "colorOfShape");
        String askCommand = keyboard.nextLine().toLowerCase();
        String[] command = askCommand.split(" ");
        boolean end = false;
        while (!end) {
            while (!end && ((!checkIsAdd(command)
                    || !checkIsShape(command)
                    || !checkIsPoint(command)
                    || !checkIsDimension(command)
                    || !checkIsColor(command)))) {
                if (checkIsShow(command)) {
                    end = true;
                } else {
                    command = askCommand();
                }
            }
            if (!checkIsShow(command)) {
                addShape(command);
                askCommand = keyboard.nextLine().toLowerCase();
                command = askCommand.split(" ");
            } else {
                view.displayShape(this.paint.asAscii());
            }
        }
        view.displayMessage("Good bye :)");
    }

    private String[] askCommand() {
        view.displayMessage("Command not correct, try again: ");
        String askCommand = keyboard.nextLine().toLowerCase();
        String[] command = askCommand.split(" ");
        return command;
    }

    private boolean checkIsAdd(String[] command) {
        return "add".equals(command[0]) && command.length > 1;
    }

    private boolean checkIsShow(String[] command) {
        return "show".equals(command[0]);
    }

    private boolean checkIsShape(String[] command) {
        return "rectangle".equals(command[1])
                || "circle".equals(command[1])
                || "square".equals(command[1]);
    }

    private boolean checkIsPoint(String[] command) {
        try {
            Integer.parseInt(command[2]);
            Integer.parseInt(command[3]);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean checkIsDimension(String[] command) {
        switch (command[1]) {
            case "rectangle":
                try {
                Double.parseDouble(command[4]);
                Double.parseDouble(command[5]);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
            case "square":
            case "circle":
                try {
                Double.parseDouble(command[4]);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
            default:
                return false;
        }
    }

    private boolean checkIsColor(String[] command) {
        return command[command.length - 1].length() == 1;
    }

    private void addShape(String[] command) {
        switch (command[1]) {
            case "rectangle":
                this.paint.newRectangle(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]),
                        Double.parseDouble(command[5]),
                        command[6].charAt(0));
                break;
            case "circle":
                this.paint.newCircle(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]),
                        command[5].charAt(0));
                break;
            case "square":
                this.paint.newSquare(Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Double.parseDouble(command[4]),
                        command[5].charAt(0));
                break;
        }
    }
}

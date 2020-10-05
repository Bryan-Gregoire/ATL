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

    private Model paint;
    private InterfaceView view;
    private Scanner keyboard;

    public Application(View interfaceView) {
        this.paint = new AsciiPaint();
        this.view = interfaceView;
        this.keyboard = new Scanner(System.in);
    }

    public void start() {
        view.displayMessage("what shape do you want to add? "
                + "(Rectangle, square or circle)");
        view.displayMessage("A command is written as: add "
                + "wantedShape positionOfShape DimensionOrRadius colorOfShape");
        String askCommand = keyboard.nextLine().toLowerCase();
        String[] command = askCommand.split(" ");
        boolean add = true;
        while (add) {
            if ("show".equals(command[0])) {
                view.displayShape(this.paint.asAscii());
                if (!askYesOrNo()) {
                    add = false;
                }
            } else {
                while (!chechAddOrShowCommand(command)
                        || !checkCorrectShape(command)
                        || !checkCorrectPoint(command)
                        || !checkDimensionShape(command)
                        || !checkColorShape(command)) {
                    command = askCommand();
                    if ("show".equals(command[0])) {
                        view.displayShape(this.paint.asAscii());
                        if (!askYesOrNo()) {
                            add = false;
                        }
                    }
                }
                addShape(command);
            }
        }
    }

    private String[] askCommand() {
        view.displayMessage("Command not correct, try again: ");
        String askCommand = keyboard.nextLine().toLowerCase();
        String[] command = askCommand.split(" ");
        return command;
    }

    private boolean chechAddOrShowCommand(String[] command) {
        return "add".equals(command[0]);
    }

    private boolean checkCorrectShape(String[] command) {
        return "rentangle".equals(command[1])
                || "circle".equals(command[1])
                || "square".equals(command[1]);
    }

    private boolean checkCorrectPoint(String[] command) {
        try {
            Integer.parseInt(command[2]);
            Integer.parseInt(command[3]);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean checkDimensionShape(String[] command) {
        switch (command[1]) {
            case "rectangle":
                try {
                Integer.parseInt(command[4]);
                Integer.parseInt(command[5]);
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

    private boolean checkColorShape(String[] command) {
        return command[command.length - 1].length() < 2
                && command[command.length - 1].length() > 0;
    }

    /**
     * Ask to enter a cardinal direction.
     *
     * @param message The given message.
     * @return the given direction.
     */
    private boolean askYesOrNo() {
        view.displayMessage("Do you want to add a shape(y/yes n/no) ? : ");
        String ask = keyboard.nextLine().toLowerCase();
        while (!"y".equals(ask) && !"yes".equals(ask)
                && !"no".equals(ask) && !"no".equals(ask)) {
            view.displayMessage("Enter y/yes or n/no: ");
            ask = keyboard.nextLine().toLowerCase();
        }
        return ask.toLowerCase().equals("y") || ask.toLowerCase().equals("yes");
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

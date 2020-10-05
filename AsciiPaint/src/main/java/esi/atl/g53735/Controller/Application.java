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
        keyboard = new Scanner(System.in);
    }

    public void start() {
        view.displayMessage("Paint :");
        this.paint.newSquare(1, 2, 5, 'c');
        System.out.println(paint.asAscii());
        view.displayShape(this.paint.asAscii());
        boolean end = false;
        while (!end) {
            checkCommand();
        }
    }

    private void checkCommand() {
        view.displayMessage("what shape do you want to add? "
                + "(Rectangle, square or circle)");
        view.displayMessage("A command is written as: add "
                + "wantedShape positionOfShape DimensionOrRadius");
        String askCommand = keyboard.nextLine().toLowerCase();
        String[] command = askCommand.split(" ");
        boolean add = true;
        while (add) {
            while (!chechAddOrShowCommand(command)
                    || !checkCorrectShape(command)
                    || !checkCorrectPoint(command)
                    || !checkDimensionShape(command)) {
                command = askCommand();
            }

        }
    }

    private boolean chechAddOrShowCommand(String[] command) {
        return "add".equals(command[0]) || "show".equals(command[0]);
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

    private String[] askCommand() {
        keyboard.next();
        view.displayMessage("Command not correct, try again: ");
        String askCommand = keyboard.nextLine().toLowerCase();
        String[] command = askCommand.split(" ");
        return command;
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

//    private boolean checkColorShape(String[] command) {
//        return ;
//    }
}

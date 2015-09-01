import java.awt.Color;

import apcslib.DrawingTool;
import apcslib.SketchPad;

/**
 * DrawHouse draws a house with windows and doors.
 * 
 * @author Joshua Song
 *
 */
public class DrawHouse {

    /* Stores the context to draw objects on the screen. */
    private SketchPad paper;
    private DrawingTool pencil;

    /* Defines the pen width. */
    private static final int penWidth = 5;

    /* Defines the colors to use for the graphic. */
    private static final Color roofColor = Color.green;
    private static final Color wallColor = Color.green;
    private static final Color doorColor = Color.blue;
    private static final Color windowColor = Color.blue;
    private static final Color chimneyColor = Color.red;

    /**
     * Default constructor.
     */
    public DrawHouse() {
        paper = new SketchPad(500, 500);
        pencil = new DrawingTool(paper);
        pencil.setWidth(DrawHouse.penWidth);
    }

    /**
     * Draws the house on to the context.
     */
    public void draw() {
        drawRoof();
        drawWalls();
        drawDoor();
        drawWindows();
        drawChimney();
    }

    /**
     * Draws the roof of the house.
     */
    private void drawRoof() {
        if (pencil.isDown()) {
            pencil.up();
        }
        pencil.setColor(DrawHouse.roofColor);
        pencil.move(0, 150);
        pencil.down();
        pencil.move(200, 60);
        pencil.move(-200, 60);
        pencil.move(0, 150);
        pencil.up();
    }

    /**
     * Draws the walls of the house.
     */
    private void drawWalls() {
        if (pencil.isDown()) {
            pencil.up();
        }
        pencil.setColor(DrawHouse.wallColor);
        pencil.move(0, -45);
        pencil.down();
        pencil.drawRect(360, 210);
        pencil.up();
    }

    /**
     * Draws the door of the house.
     */
    private void drawDoor() {
        if (pencil.isDown()) {
            pencil.up();
        }
        pencil.setColor(DrawHouse.doorColor);
        pencil.move(0, -76.5);
        pencil.down();
        pencil.fillRect(100, 147);
        pencil.up();
    }

    /**
     * Draws both left and right windows of the house.
     */
    private void drawWindows() {
        if (pencil.isDown()) {
            pencil.up();
        }
        pencil.setColor(DrawHouse.windowColor);
        pencil.move(-115, -45);
        pencil.down();
        pencil.drawOval(80, 84);
        pencil.up();
        pencil.move(115, -45);
        pencil.down();
        pencil.drawOval(80, 84);
        pencil.up();
    }

    /**
     * Draws the chimney of the house.
     */
    private void drawChimney() {
        if (pencil.isDown()) {
            pencil.up();
        }
        pencil.setColor(DrawHouse.chimneyColor);
        pencil.move(120, 105);
        pencil.down();
        pencil.fillRect(80, 90);
        pencil.up();
    }
}

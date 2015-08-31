import java.awt.Color;

import apcslib.DrawingTool;
import apcslib.SketchPad;

/**
 * DrawHouse draws a house with windows and doors.
 * @author Joshua Song
 *
 */
public class DrawHouse {
	
	private DrawHouse self = this;
 	private DrawingTool context;
    private SketchPad layer;

    /**
     * Represents a size.
     * @author Joshua Song
     *
     */
    private static class Size {
		public float width;
		public float height;
	}
	
    /**
     * Represents a geometric point.
     * @author Joshua Song
     *
     */
	private static class Point {
		public float x;
		public float y;
	}
	
	/**
	 * Represents a rectangle.
	 * @author Joshua Song
	 *
	 */
	private static class Rect {
		public Size size = new Size();
		public Point origin = new Point();
		
		public static Rect make(float x, float y, float width, float height) {
			Rect rect = new Rect();
			rect.origin.x = x;
			rect.origin.y = y;
			rect.size.width = width;
			rect.size.height = height;
			return rect;
		}
	}
	
	/**
	 * Default constructor.
	 */
	public DrawHouse() {
		layer = new SketchPad(500, 500);
	    context = new DrawingTool(layer);
	}
	
	/**
	 * Draws the house with a default size of 400x300.
	 */
	public void draw() {
		self.drawRect(Rect.make(-200, -150, 400, 300));
	}
	
	/**
	 * Given a rectangle, draw the house.
	 * @param boundingRect
	 */
	private void drawRect(Rect boundingRect) {
		float roofHeight = (float) (0.3 * boundingRect.size.height);
		float roofOffset = (float) (0.05 * boundingRect.size.width);

		float houseHeight = (float) (0.7 * boundingRect.size.height);
		
		float windowWidth = (float) (0.2 * boundingRect.size.width);
		float windowHeight = (float) (0.4 * houseHeight);
		
		float doorWidth = (float) (0.25 * boundingRect.size.width);
		float doorHeight = (float) (0.7 * houseHeight);
		
		float chimneyWidth = (float) (0.2 * boundingRect.size.width);
		
		context.setWidth(4);
		
		
		context.setColor(Color.green);
		
		Rect roofRect = Rect.make(boundingRect.origin.x, boundingRect.origin.y + boundingRect.size.height - roofHeight, boundingRect.size.width, roofHeight);
		self.drawTriangleInRect(roofRect);
		
		Rect houseRect = Rect.make(boundingRect.origin.x + roofOffset, boundingRect.origin.y, boundingRect.size.width - 2 * roofOffset, houseHeight);
		self.drawRectInRect(houseRect);
		
		
		context.setColor(Color.blue);
		
		Rect doorRect = Rect.make(boundingRect.origin.x + (boundingRect.size.width - doorWidth) / 2, boundingRect.origin.y, doorWidth, doorHeight);
		self.fillRectInRect(doorRect);
		
		Rect rightWindowRect = Rect.make(boundingRect.origin.x + (boundingRect.size.width / 2 - doorWidth / 2 - roofOffset - windowWidth) / 2 + roofOffset, boundingRect.origin.y + (houseHeight - windowHeight) / 2, windowWidth, windowHeight);
		self.fillOvalInRect(rightWindowRect);
		
		Rect leftWindowRect = Rect.make(boundingRect.origin.x + boundingRect.size.width - (boundingRect.size.width / 2 - doorWidth / 2 - roofOffset - windowWidth) / 2 - roofOffset - windowWidth, boundingRect.origin.y + (houseHeight - windowHeight) / 2, windowWidth, windowHeight);
		self.fillOvalInRect(leftWindowRect);
		
		
		context.setColor(Color.red);
		
		Rect chimneyRect = Rect.make(boundingRect.origin.x + boundingRect.size.width - 2 * roofOffset - chimneyWidth, boundingRect.origin.y + houseHeight, chimneyWidth, roofHeight);
		self.fillRectInRect(chimneyRect);
	}
	
	/**
	 * Draws the rectangle that is given.
	 * @param rect
	 */
	private void drawRectInRect(Rect rect) {
		boolean wasDown = context.isDown();
		Point center = new Point();
		center.x = rect.origin.x + rect.size.width / 2;
		center.y = rect.origin.y + rect.size.height / 2;
		context.up();
		context.move(center.x, center.y);
		context.down();
		context.drawRect(rect.size.width, rect.size.height);
		if (!wasDown) {
			context.up();
		}
	}
	
	/**
	 * Fills the rectangle that is given.
	 * @param rect
	 */
	private void fillRectInRect(Rect rect) {
		boolean wasDown = context.isDown();
		Point center = new Point();
		center.x = rect.origin.x + rect.size.width / 2;
		center.y = rect.origin.y + rect.size.height / 2;
		context.up();
		context.move(center.x, center.y);
		context.down();
		context.fillRect(rect.size.width, rect.size.height);
		if (!wasDown) {
			context.up();
		}
	}
	
	/**
	 * Fills the triangle that circumscribes the given rectangle.
	 * @param rect
	 */
	private void drawTriangleInRect(Rect rect) {
		boolean wasDown = context.isDown();
		Point topCenter = new Point();
		topCenter.x = rect.origin.x + rect.size.width / 2;
		topCenter.y = rect.origin.y + rect.size.height;
		context.up();
		context.move(topCenter.x, topCenter.y);
		context.down();
		context.move(rect.origin.x + rect.size.width, rect.origin.y);
		context.move(rect.origin.x, rect.origin.y);
		context.move(topCenter.x, topCenter.y);
		if (!wasDown) {
			context.up();
		}
	}
	
	/**
	 * Fills that oval that circumscribes the given rectangle.
	 * @param rect
	 */
	public void fillOvalInRect(Rect rect) {
		boolean wasDown = context.isDown();
		Point center = new Point();
		center.x = rect.origin.x + rect.size.width / 2;
		center.y = rect.origin.y + rect.size.height / 2;
		context.up();
		context.move(center.x, center.y);
		context.down();
		context.fillOval(rect.size.width, rect.size.height);
		if (!wasDown) {
			context.up();
		}
	}
}

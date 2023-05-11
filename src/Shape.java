package src;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/* Class Shape
 *
 * By Rob Nash
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

//the superclass in our inheritance hierarchy
//all "common" features, functions and data should go here
//for example, all shapes in Java2D have a x,y that declares their position
//and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
//note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area (future subclasses must override getArea() to provide something reasonable)
//also, the draw method is empty too, as we don't know what shape to draw here! (again, our subclasses will need to replace this method with one that actually draws things)
class Shape extends Object {
	private int x = 0;
	private int y = 0;
	private final int RADIUS = 20;
	private final int DENSITY = 10;

	//a constructor used to initialize the data members
	public Shape(){}
	public Shape(int a, int b ) {
		x=a;
		y=b;
	}
	
	public double getArea(){ return -1; }



	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

	public void draw( Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		final int x = getX();
		final int y = getY();

		g2d.setColor( Color.GREEN );
		g2d.setPaint( new GradientPaint( x, y, Color.GREEN, x + RADIUS/4, y + RADIUS/4, Color.BLACK, true) );

		int xOffset = 0;
		int yOffset = 0;
		for( int i = 0; i < DENSITY; i++) {
			xOffset = (int) (Math.random()*RADIUS);
			yOffset = (int) (Math.random()*RADIUS);
			g2d.draw( new Ellipse2D.Double( x + xOffset, y + yOffset, x + xOffset+3, y + yOffset+3) );
		}

	}
	
	public int getX() { return x; }
	public int getY() { return y; }
}
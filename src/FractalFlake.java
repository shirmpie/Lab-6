package src;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class FractalFlake extends Shape implements java.awt.Shape {
    private final int limit;
    private final int numBranches;

    public FractalFlake(int x, int y, int limit, int numBranches) {
        super(x, y);
        this.limit = limit;
        this.numBranches = numBranches;
    }

    public int getLimit() {
        return limit;
    }

    public int getNumBranches() {
        return numBranches;
    }

    @Override
    public double getArea() {
        // Fractal flakes do not have a well-defined area, so we return -1
        return -1;
    }

    @Override
    public void draw(Graphics g) {
        // Draw the fractal flake using a recursive algorithm
        drawFractalFlake(g, getX(), getY(), limit, numBranches);
    }

    private void drawFractalFlake(Graphics g, int x, int y, int limit, int numBranches) {
        if (limit == 0) {
            // Base case: draw a single line segment
            g.drawLine(x, y, x, y);
        } else {
            // Recursive case: draw a branching pattern of line segments
            int dx = g.getClipBounds().width / (numBranches + 1);
            int dy = g.getClipBounds().height / (numBranches + 1);
            for (int i = 1; i <= numBranches; i++) {
                int x2 = x + i * dx;
                int y2 = y + i * dy;
                g.drawLine(x, y, x2, y2);
                drawFractalFlake(g, x2, y2, limit - 1, numBranches);
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    @Override
    public boolean contains(double v, double v1) {
        return false;
    }

    @Override
    public boolean contains(Point2D point2D) {
        return false;
    }

    @Override
    public boolean intersects(double v, double v1, double v2, double v3) {
        return false;
    }

    @Override
    public boolean intersects(Rectangle2D rectangle2D) {
        return false;
    }

    @Override
    public boolean contains(double v, double v1, double v2, double v3) {
        return false;
    }

    @Override
    public boolean contains(Rectangle2D rectangle2D) {
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return null;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform, double v) {
        return null;
    }
}


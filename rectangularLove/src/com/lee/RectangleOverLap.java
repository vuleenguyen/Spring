package com.lee;

public class RectangleOverLap {

    public static Rectangle findRectangleOverlap(Rectangle rectangle1 , Rectangle rectangle2) {
        if (rectangle1 == null || rectangle2 == null) {
            throw new IllegalArgumentException("Input Rectangle can't null");
        }

        RangeOverLap rangeOverLapX = findRangeOverLap(rectangle1.getLeftX(), rectangle1.getWidth(), rectangle2.getLeftX(), rectangle2.getWidth());
        RangeOverLap rangeOverLapY = findRangeOverLap(rectangle1.getBottomY(), rectangle1.getHeight(), rectangle2.getBottomY(), rectangle2.getHeight());

        if (rangeOverLapX.getLength() == 0 || rangeOverLapY.getLength() == 0) {
            return Rectangle.NO_RECTANGLE;
        }

        return new Rectangle(rangeOverLapX.getPoint(), rangeOverLapY.getPoint(), rangeOverLapX.getLength(), rangeOverLapY.getLength());
    }

    public static RangeOverLap findRangeOverLap(int point1, int length1, int point2, int length2) {
        int highestStartPoint = Math.max(point1, point2);
        int lowestEndPoint = Math.min(point1 + length1, point2 + length2);

        if (highestStartPoint >= lowestEndPoint) {
            return RangeOverLap.NO_OVERLAP;
        }

        return new RangeOverLap(highestStartPoint, lowestEndPoint - highestStartPoint);
    }
}

class RangeOverLap {

    public static final RangeOverLap NO_OVERLAP = new RangeOverLap();

    private int point;
    private int length;

    public RangeOverLap() {}

    public RangeOverLap(int point, int length) {
        this.point = point;
        this.length = length;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

class Rectangle {
    // "zero" rectangle
    public static final Rectangle NO_RECTANGLE = new Rectangle();

    // coordinates of bottom left corner
    private int leftX;
    private int bottomY;

    // dimensions
    private int width;
    private int height;

    public Rectangle() {}

    public Rectangle(int leftX, int bottomY, int width, int height) {
        this.leftX = leftX;
        this.bottomY = bottomY;
        this.width  = width;
        this.height = height;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getBottomY() {
        return bottomY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) obj;
        return this.getLeftX() == rectangle.getLeftX() && this.getBottomY() == rectangle.getBottomY()
                && this.getWidth() == rectangle.getWidth() && this.getHeight() == rectangle.getHeight();
    }
}





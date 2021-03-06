package nona.starwars.engine.physics;

import nona.starwars.engine.math.Vector2f;

public class AABB {

    private Vector2f min;
    private Vector2f max;

    public AABB(Vector2f min, Vector2f max) {
        this.min = min;
        this.max = max;
    }

    public AABB(float minX, float minY, float maxX, float maxY) {
        this.min = new Vector2f(minX, minY);
        this.max = new Vector2f(maxX, maxY);
    }

    public boolean intersectAABB(AABB other) {
        return intersectRect(other.getMin(), other.getMax());
    }

    public boolean intersectRect(Vector2f min, Vector2f max) {
        return this.min.getX() < max.getX()
                && this.max.getX() > min.getX()
                && this.min.getY() < max.getY()
                && this.max.getY() > min.getY();
    }

    public boolean intersectRect(float minX, float minY, float maxX, float maxY) {
        return intersectRect(new Vector2f(minX, minY), new Vector2f(maxX, maxY));
    }

    public boolean intersectBoundingSphere(BoundingSphere other) {
        Vector2f pos = other.getPos();

        float distance = 0;
        float s;

        if(pos.getX() < min.getX()) {
            s = pos.getX() - min.getX();
            distance += s * s;
        } else if(pos.getX() > max.getX()) {
            s = pos.getX() - max.getX();
            distance += s * s;
        }

        if(pos.getY() < min.getY()) {
            s = pos.getY() - min.getY();
            distance += s * s;
        } else if(pos.getY() > max.getY()) {
            s = pos.getY() - max.getY();
            distance += s * s;
        }

        return distance <= other.getRadius() * other.getRadius();
    }

    public float getDistanceX(AABB other) {
        float distance1 = getMin().getX() - other.getMax().getX();
        float distance2 = other.getMin().getX() - getMax().getX();

        return distance1 > distance2 ? distance1 : distance2;
    }

    public float getDistanceY(AABB other) {
        float distance1 = getMin().getY() - other.getMax().getY();
        float distance2 = other.getMin().getY() - getMax().getY();

        return distance1 > distance2 ? distance1 : distance2;
    }

    public Vector2f getDistance(AABB other) {
        return new Vector2f(getDistanceX(other), getDistanceY(other));
    }

    public float getWidth() {
        return max.getX() - min.getX();
    }

    public float getHeight() {
        return max.getY() - min.getY();
    }

    public Vector2f getCenter() {
        return new Vector2f(min.getX() + getWidth() / 2, min.getY() + getHeight() / 2);
    }

    public Vector2f getMin() {
        return min;
    }

    public void setMin(Vector2f min) {
        this.min = min;
    }

    public Vector2f getMax() {
        return max;
    }

    public void setMax(Vector2f max) {
        this.max = max;
    }

}
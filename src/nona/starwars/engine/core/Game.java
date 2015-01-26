package nona.starwars.engine.core;

public abstract class Game {

    protected CoreEngine engine;

    protected int windowWidth;
    protected int windowHeight;
    protected String windowTitle;

    protected Entity root;

    public abstract void input();
    public abstract void update();
    public abstract void render();

    public CoreEngine getEngine() {
        return engine;
    }

    public void setEngine(CoreEngine engine) {
        this.engine = engine;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public String getWindowTitle() {
        return windowTitle;
    }

    public Entity getRootEntity() {
        return root;
    }

}
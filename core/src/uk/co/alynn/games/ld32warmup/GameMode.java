package uk.co.alynn.games.ld32warmup;

public interface GameMode {
    public GameMode think();
    public void draw();
    public void activate();
    public void deactivate();
}

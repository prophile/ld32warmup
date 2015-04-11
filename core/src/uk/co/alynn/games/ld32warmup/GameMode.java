package uk.co.alynn.games.ld32warmup;

/**
 * Mode of gameplay.
 *
 * @author alynn
 *
 */
public interface GameMode {
    /**
     * Do any logic and processing for a single frame.
     * @return The next game mode—'this' by default, which will continue the current mode.
     */
    public GameMode think();
    /**
     * Render a single frame.
     */
    public void draw();
    /**
     * Indication of becoming active. Use this to create GPU resources, et cetera.
     */
    public void activate();
    /**
     * Indication of becoming inactive. Use this to call .dispose() on GPU resources, et cetera.
     */
    public void deactivate();
    /**
     * Injection of updated screen dimensions. Use this to update viewports.
     *
     * @param w New screen width, in pixels.
     * @param h New screen height, in pixels.
     */
    public void screenDimensions(int w, int h);
}

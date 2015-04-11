package uk.co.alynn.games.ld32warmup;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Mode that displays the loading screen and runs asset loading in the background.
 *
 * @author alynn
 *
 */
final class LoadingScreenMode implements GameMode {
    /**
     * Shape renderer for the Load Cheese.
     */
    private ShapeRenderer m_shapeRenderer;
    /**
     * Virtual viewport.
     */
    private Viewport m_viewport;

    /**
     * Run one frame of loading. If finished, switch into the title screen.
     * @return New game mode.
     */
    @Override
    public GameMode think() {
        if (Overlord.getAssetManager().update(1000 / 30)) {
            //return this;
            return ModeSmorgasbord.TITLES; // TODO: add real main class here
        }
        return this;
    }

    /**
     * Draw the Load Cheese, which indicates how far through loading we are.
     */
    @Override
    public void draw() {
        m_shapeRenderer.begin(ShapeType.Filled);
        float w = 10.0f;
        float h = 10.0f;
        float radius = Math.min(w, h) * 0.4f;
        m_shapeRenderer.arc(w * 0.5f, h * 0.5f, radius, 0.0f, 360.0f * Overlord.getAssetManager().getProgress());
        m_shapeRenderer.end();
    }

    /**
     * Init the cheese renderer and viewport.
     */
    @Override
    public void activate() {
        m_shapeRenderer = new ShapeRenderer();
        m_viewport = new FitViewport(10, 10);
    }

    /**
     * Free up any used resources.
     */
    @Override
    public void deactivate() {
        m_viewport = null;
        m_shapeRenderer.dispose();
        m_shapeRenderer = null;
    }

    /**
     * Inject new screen dimensions, to update the viewport.
     */
    @Override
    public void screenDimensions(int w, int h) {
        m_viewport.update(w, h);
        m_shapeRenderer.setProjectionMatrix(m_viewport.getCamera().combined);
    }
}
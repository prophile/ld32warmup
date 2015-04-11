package uk.co.alynn.games.ld32warmup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Mode which just displays the title screen.
 *
 * @author alynn
 *
 */
public final class TitleMode implements GameMode {
    /**
     * The displayed texture for the logo.
     */
    private Texture m_logoTexture;
    /**
     * The sprite batch for logo display.
     */
    private SpriteBatch m_spriteBatch;
    /**
     * The virtual viewport.
     */
    private Viewport m_viewport;

    /**
     * Do all processing. Currently this is a no-op.
     */
    @Override
    public GameMode think() {
        return this;
    }

    /**
     * Draw the logo onto the screen.
     */
    @Override
    public void draw() {
        m_spriteBatch.begin();
        m_spriteBatch.draw(m_logoTexture, 0, 0);
        m_spriteBatch.end();
    }

    /**
     * Grab the logo from Overlord, and set up viewport and batch.
     */
    @Override
    public void activate() {
        m_spriteBatch = new SpriteBatch();
        m_logoTexture = Overlord.getAssetManager().get("badlogic.jpg", Texture.class);
        m_viewport = new FitViewport(m_logoTexture.getWidth(), m_logoTexture.getHeight());
    }

    /**
     * Dispose of unused resources.
     */
    @Override
    public void deactivate() {
        m_viewport = null;
        m_spriteBatch.dispose();
        m_spriteBatch = null;
    }

    /**
     * Inject updated screen dimensions. Updates the viewport.
     */
    @Override
    public void screenDimensions(int w, int h) {
        m_viewport.update(w, h, true);
        m_spriteBatch.setProjectionMatrix(m_viewport.getCamera().combined);
    }

}

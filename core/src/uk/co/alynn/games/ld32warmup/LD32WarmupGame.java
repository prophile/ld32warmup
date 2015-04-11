package uk.co.alynn.games.ld32warmup;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Main game class.
 *
 * @author alynn
 *
 */
public class LD32WarmupGame extends ApplicationAdapter {
    /**
     * Current game mode.
     */
    private GameMode m_gameMode = ModeSmorgasbord.LOADING_SCREEN;

    /**
     * Start up Overlord and initialise the first game mode (the loading screen mode).
     */
    @Override
    public void create () {
        Overlord.init();
        m_gameMode.activate();
    }

    /**
     * Main thinking method. This is a bit misleading: does both thinking and drawing. This is the LibGDX Way™.
     */
    @Override
    public void render () {
        GameMode nextMode = m_gameMode.think();
        if (nextMode != m_gameMode) {
            m_gameMode.deactivate();
            nextMode.activate();
            nextMode.screenDimensions(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            m_gameMode = nextMode;
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        m_gameMode.draw();

    }

    /**
     * Receive screen resize instruction. Just pass this on to the active game mode.
     */
    @Override
    public void resize(int w, int h) {
        m_gameMode.screenDimensions(w, h);
    }
}

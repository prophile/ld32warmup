package uk.co.alynn.games.ld32warmup;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class LD32WarmupGame extends ApplicationAdapter {
    GameMode m_gameMode = ModeSmorgasbord.LOADING_SCREEN;

    @Override
    public void create () {
        Overlord.init();
        m_gameMode.activate();
    }

    @Override
    public void render () {
        GameMode nextMode = m_gameMode.think();
        if (nextMode != m_gameMode) {
            m_gameMode.deactivate();
            nextMode.activate();
            m_gameMode = nextMode;
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        m_gameMode.draw();
    }
}

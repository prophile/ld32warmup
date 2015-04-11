package uk.co.alynn.games.ld32warmup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

final class LoadingScreenMode implements GameMode {
    private ShapeRenderer m_shapeRenderer;

    @Override
    public GameMode think() {
        if (Overlord.getAssetManager().update(1000 / 30)) {
            return ModeSmorgasbord.TITLES; // TODO: add real main class here
        }
        return this;
    }

    @Override
    public void draw() {
        m_shapeRenderer.begin(ShapeType.Filled);
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        float radius = Math.min(w, h) * 0.4f;
        m_shapeRenderer.arc(w * 0.5f, h * 0.5f, radius, 0.0f, 360.0f * Overlord.getAssetManager().getProgress());
        m_shapeRenderer.end();
    }

    @Override
    public void activate() {
        m_shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void deactivate() {
        m_shapeRenderer.dispose();
        m_shapeRenderer = null;
    }
}
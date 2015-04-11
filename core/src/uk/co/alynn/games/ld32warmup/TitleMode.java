package uk.co.alynn.games.ld32warmup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public final class TitleMode implements GameMode {
    private Texture m_logoTexture;
    private SpriteBatch m_spriteBatch;

    @Override
    public GameMode think() {
        return this;
    }

    @Override
    public void draw() {
        m_spriteBatch.begin();
        m_spriteBatch.draw(m_logoTexture, 0, 0);
        m_spriteBatch.end();
    }

    @Override
    public void activate() {
        m_spriteBatch = new SpriteBatch();
        m_logoTexture = Overlord.getAssetManager().get("badlogic.jpg", Texture.class);
    }

    @Override
    public void deactivate() {
        m_spriteBatch.dispose();
    }

}

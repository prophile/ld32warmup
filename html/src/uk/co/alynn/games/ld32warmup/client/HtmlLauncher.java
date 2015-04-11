package uk.co.alynn.games.ld32warmup.client;

import uk.co.alynn.games.ld32warmup.LD32WarmupGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig () {
        GwtApplicationConfiguration config = new GwtApplicationConfiguration(1024, 640);
        config.antialiasing = true;
        return config;
    }

    @Override
    public ApplicationListener getApplicationListener () {
        return new LD32WarmupGame();
    }
}

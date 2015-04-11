package uk.co.alynn.games.ld32warmup.desktop;

import uk.co.alynn.games.ld32warmup.LD32WarmupGame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1024;
        config.height = 640;

        config.resizable = true;

        config.useHDPI = true;

        config.title = "LD32 Warmup";

        new LwjglApplication(new LD32WarmupGame(), config);
    }
}

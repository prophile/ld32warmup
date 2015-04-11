package uk.co.alynn.games.ld32warmup;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

abstract class Overlord {
    private static AssetManager s_assetManager = null;

    public static void init() {
        if (s_assetManager != null) {
            throw new RuntimeException("Non-null asset manager.");
        }
        s_assetManager = new AssetManager();
        addBGAssets(s_assetManager);
    }

    public static AssetManager getAssetManager() {
        if (s_assetManager == null) {
            throw new RuntimeException("Asset manager not initted");
        }
        return s_assetManager;
    }

    private static void addBGAssets(AssetManager manager) {
        manager.load("badlogic.jpg", Texture.class);
    }
}

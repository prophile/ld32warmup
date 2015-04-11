package uk.co.alynn.games.ld32warmup;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

/**
 * Centralized asset management. Add any assets here that need to be hooked into the asset loading queue.
 *
 * @author alynn
 */
abstract class Overlord {
    /**
     * Singular AssetManager instance. Indirectly accessed, everything checks for null.
     */
    private static AssetManager s_assetManager = null;

    /**
     * Configure the asset manager. This creates it and queues all assets to be loaded, but _DOES NOT_ actually do any loading.
     */
    public static void init() {
        if (s_assetManager != null) {
            throw new RuntimeException("Non-null asset manager.");
        }
        s_assetManager = new AssetManager();
        addBGAssets(s_assetManager);
    }

    /**
     * Accessor for the central asset manager. Checks for init() being called first.
     * @return The central asset manager.
     */
    public static AssetManager getAssetManager() {
        if (s_assetManager == null) {
            throw new RuntimeException("Asset manager not initted");
        }
        return s_assetManager;
    }

    /**
     * Queue up the background textures.
     *
     * @param manager Asset manager into which to queue.
     */
    private static void addBGAssets(AssetManager manager) {
        manager.load("badlogic.jpg", Texture.class);
    }
}

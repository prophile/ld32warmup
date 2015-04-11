package uk.co.alynn.games.ld32warmup;

/**
 * A collection of different GameMode objects.
 * Here to avoid multiple allocations.
 *
 * @author alynn
 *
 */
public abstract class ModeSmorgasbord {
    public static final TitleMode TITLES = new TitleMode();
    public static final LoadingScreenMode LOADING_SCREEN = new LoadingScreenMode();
}

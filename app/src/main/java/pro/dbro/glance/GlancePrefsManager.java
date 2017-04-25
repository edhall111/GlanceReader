package pro.dbro.glance;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;

import pro.dbro.glance.fragments.PreferencesFragment;
import pro.dbro.glance.fragments.WpmDialogFragment;
import pro.dbro.glance.fragments.ScrubDialogFragment;

/**
 * Created by davidbrodsky on 9/21/14.
 */
public class GlancePrefsManager {
    /** SharedPreferences store names */
    private static final String UI_PREFS = "ui_prefs";
    private static final String APP_PREFS = "espritz";

    /** SharedPreferences keys */
    private static final String UI_THEME = "THEME";

    private static final String APP_URI = "uri";
    private static final String APP_TITLE = "title";
    private static final String APP_CHAPTER = "chapter";
    private static final String APP_WORD = "word";
    private static final String APP_WPM = "wpm";
    private static final String APP_SAW_ONBOARDER = "onboarder";
    //add key for scrubber
    private static final String APP_SCRUB = "scrub";
    /** Default SharedPreferences Values */
    public static final int DEFAULT_APP_WPM = 500;

    public static boolean getShouldShowOnboarder(Context context) {
        boolean result = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE)
                .getBoolean(APP_SAW_ONBOARDER, false);

        if (!result)
            context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE).edit().putBoolean(APP_SAW_ONBOARDER, true).apply();

        return !result;
    }

    public static int getTheme(Context context) {
        return context.getSharedPreferences(UI_PREFS, Context.MODE_PRIVATE)
                .getInt(UI_THEME, 1);
    }

    public static void setTheme(Context context, int theme) {
        context.getSharedPreferences(UI_PREFS, Context.MODE_PRIVATE).edit()
                .putInt(UI_THEME, theme)
                .commit();
    }

    public static void saveState(Context context, int chapter, String uri, int wordIdx, String title, int wpm) {
        SharedPreferences.Editor editor = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE).edit();
        editor.putInt(APP_CHAPTER, chapter)
                .putString(APP_URI, uri)
                .putInt(APP_WORD, wordIdx)
                .putString(APP_TITLE, title)
                .putInt(APP_WPM, wpm)
                .apply();
    }

    public static SpritzState getState(Context context) {
        SharedPreferences prefs =  context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return new SpritzState(
                prefs.getInt(APP_CHAPTER, 0),
                prefs.getString(APP_URI, null),
                prefs.getInt(APP_WORD, 0),
                prefs.getString(APP_TITLE, null),
                prefs.getInt(APP_WPM, 500)
                );
    }

    public static void clearState(Context context) {
        context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE).edit().clear().apply();
    }
    public static void setWpm(Context context, int wpm) {
        SharedPreferences.Editor editor = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE).edit();
        editor.putInt(APP_WPM, Math.max(wpm, WpmDialogFragment.MIN_WPM))
                .apply();
    }

    public static int getWpm(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return prefs.getInt(APP_WPM, DEFAULT_APP_WPM);
    }
    //pos stuff///////////////////////////
    public static void setPos(Context context, int pos) {
        SharedPreferences.Editor editor = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE).edit();
        editor.putInt(APP_WPM, Math.max(pos, WpmDialogFragment.MIN_WPM))
                .apply();
    }

    public static int getPos(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        return prefs.getInt(APP_WPM, DEFAULT_APP_WPM);
    }

    public static SharePref getShareMode(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String sharePref = prefs.getString(context.getString(R.string.pref_key_share_mode),
                                                   context.getString(R.string.pref_share_mode_default));

        // Possible to avoid hardcoded relation to order of R.array.pref_share_mode_machine?
        // Note we can't even use index values of that array, as switch statement requires constant
        // invariants
        switch (sharePref) {
            case "never":
                return SharePref.NEVER;
            case "ask":
                return SharePref.ASK;
            case "always":
                return SharePref.ALWAYS;
        }
        throw new RuntimeException("Illegal sharing preference! Got preference: " + sharePref);
    }

    public static enum SharePref {
        ALWAYS, ASK, NEVER
    }

    public static class SpritzState {

        private int mChapter;
        private String mUri;
        private int mWordIdx;
        private String mTitle;
        private int mWpm;

        public SpritzState(int chapter, String uri, int wordIdx, String title, int wpm) {
            mChapter = chapter;
            mUri = uri;
            mWordIdx = wordIdx;
            mTitle = title;
            mWpm = wpm;
        }

        public boolean hasUri() {
            return mUri != null;
        }

        public Uri getUri() {
            return Uri.parse(mUri);
        }

        public boolean hasTitle() {
            return mTitle != null;
        }

        public String getTitle() {
            return mTitle;
        }

        public int getChapter() {
            return mChapter;
        }

        public int getWpm() {
            return (mWpm == 0 ? DEFAULT_APP_WPM : mWpm);
        }

        public int getWordIdx() {
            return mWordIdx;
        }
    }

}

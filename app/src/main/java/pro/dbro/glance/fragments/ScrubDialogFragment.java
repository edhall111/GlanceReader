package pro.dbro.glance.fragments;

/**
 * Created by Ed on 4/25/2017.
 */
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SeekBar;
import android.widget.TextView;

import com.squareup.otto.Bus;

import pro.dbro.glance.AppSpritzer;
import pro.dbro.glance.GlanceApplication;
import pro.dbro.glance.GlancePrefsManager;
import pro.dbro.glance.R;
import pro.dbro.glance.fragments.SpritzFragment;
import pro.dbro.glance.activities.MainActivity;
import pro.dbro.glance.events.ScrubSelectedEvent;
import pro.dbro.glance.lib.Spritzer;
import pro.dbro.glance.lib.SpritzerTextView;


public class ScrubDialogFragment extends DialogFragment {
    public static final float MAX_POS = 100;
    public static final float MIN_POS = 0;

    private View mView;
    //private Animation mCurrentAnimation;
    //private boolean mAnimationRunning;
    private SpritzerTextView mSpritzView;
    private SpritzFragment.SpritzFragmentHandler mHandler;
    private SeekBar mScrubSeek;
    private TextView mScrubLabel;
    private float mPos;
    private Bus mBus;

    public static ScrubDialogFragment newInstance() {
        ScrubDialogFragment f = new ScrubDialogFragment();
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO add get pos to glanceprefsmanager
        mPos = GlancePrefsManager.getPos(getActivity());
        //mAnimationRunning = false;

        GlanceApplication app = (GlanceApplication) getActivity().getApplication();
        this.mBus = app.getBus();
    }

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {

        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog_scrub, null);
        mScrubLabel = (TextView) v.findViewById(R.id.scrubText);
        mScrubSeek = ((SeekBar) v.findViewById(R.id.seekBarScrub));

        mScrubSeek.setProgress((int) ((float)50));
        //mWpmLabel.setText(mWpm + " WPM");

        mScrubSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //mPos = Math.max(MIN_WPM, (int) ((progress / 100.0) * MAX_WPM));
                ///////////////////////////////////////
                mPos = Math.max(MIN_POS, (int)((progress/100.0)*MAX_POS));
                String posStr = mPos + "% of words out of 100%" ;
                mScrubLabel.setText(posStr);
                getDialog().setTitle(posStr);
                //my stuff
//                if (mPos >= WHOAH_THRESHOLD_WPM + 50 && !mAnimationRunning) {
//                    setTrippin(true);
//                } else if (mPos <= WHOAH_THRESHOLD_WPM - 50 && mAnimationRunning) {
//                    setTrippin(false);
//                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getActivity().getString(R.string.scrub))
                .setView(v);
        mView = v;
        return builder.create();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        mBus.post(new ScrubSelectedEvent(mPos));
        //TODO set pos function to change position
        //GlancePrefsManager.setPos(getActivity(), mPos);
        getActivity().getFragmentManager().beginTransaction().remove(this).commit();
    }

}

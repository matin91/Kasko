package com.rocklobstre.kasko.presentation.ui.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mapzen.speakerbox.Speakerbox;
import com.rocklobstre.kasko.App;
import com.rocklobstre.kasko.R;
import com.rocklobstre.kasko.presentation.ui.activities.BucketActivity;
import com.rocklobstre.kasko.presentation.ui.activities.ReminderActivity;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReminderFragment#newInstance()} factory method to
 * create an instance of this fragment.
 */
public class ReminderFragment extends Fragment {

    public static final String TAG = ReminderFragment.class.getName();

    private Speakerbox speakerbox;
    private String mMessage;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment TransactionsFragment.
     */
    public static ReminderFragment newInstance() {
        ReminderFragment fragment = new ReminderFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null){
            mMessage = bundle.getString(ReminderActivity.REMIND_MESSAGE);
        }
        speakerbox = new Speakerbox(getActivity().getApplication());
        speakerbox.setActivity(getActivity());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
            speakerbox.getTextToSpeech().setLanguage(new Locale("en_US"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_reminder_receiver, container, false);
        ButterKnife.bind(this, v);
        Button stopAlarm = (Button) v.findViewById(R.id.btn_alarm_dismiss);
        stopAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(BucketActivity.getIntentForNotification(getActivity()));
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        startSpeakingMessage(mMessage);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        speakerbox.abandonAudioFocus();
        speakerbox.stop();
        super.onDetach();
    }

    public void startSpeakingMessage(final String message) {
        final Runnable onStart = new Runnable() {
            public void run() {
                speakerbox.requestAudioFocus();
            }
        };
        final Runnable onDone = new Runnable() {
            public void run() {
                speakerbox.abandonAudioFocus();
                startSpeakingMessage(message);
            }
        };
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                speakerbox.play(message, onStart, onDone, null);
            }
        }, 3000);
    }

}
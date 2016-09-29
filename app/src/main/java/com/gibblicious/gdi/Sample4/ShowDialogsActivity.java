package com.gibblicious.gdi.Sample4;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class ShowDialogsActivity extends AppCompatActivity {

    private static final String TAG = "ShowDialogsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
    }

    public void onAlertDialogClick(View v) {
        Log.d(TAG, "onAlertDialogClick");
        DialogFragment frag = AlertDialogFragment.newInstance();
        frag.show(getFragmentManager(), "dialog");
    }

    public void onSingleChoiceClick(View v) {
        Log.d(TAG, "onSingleChoiceClick");
    }

    public void onDatePickerClick(View v) {
        Log.d(TAG, "onDatePickerClick");
    }

}

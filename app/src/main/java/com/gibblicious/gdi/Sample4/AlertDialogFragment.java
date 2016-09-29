package com.gibblicious.gdi.Sample4;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;


public class AlertDialogFragment extends DialogFragment {

    private final static String TAG = "AlertDialogFragment";

    static AlertDialogFragment newInstance() {
        return new AlertDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Is this class making you sleepy?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d(TAG, "Thank you for your honesty.");

                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d(TAG, "What a drag.");
                    }
                })
                .setNeutralButton("PERHAPS", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d(TAG, "Let's start with a risk reward exercise...");
                    }
                });

        return builder.create();
    }
}

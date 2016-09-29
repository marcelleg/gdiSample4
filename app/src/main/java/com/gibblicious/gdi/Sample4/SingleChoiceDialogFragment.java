package com.gibblicious.gdi.Sample4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleChoiceDialogFragment extends DialogFragment {

    private final static String TAG = "SingleChoiceDialogFragment";

    String[] choices = { "New Speaker",
            "Let us at the Beer in Fridge",
            "Teach Me How to Write Candy Crush",
            "All of the Above" };

    static SingleChoiceDialogFragment newInstance() {
        return new SingleChoiceDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Suggest an Improvement")
                .setItems(choices, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position of the selected item
                        Log.d(TAG, "You Chose = " + choices[which].toString());
                    }
                });
        return builder.create();
    }

}

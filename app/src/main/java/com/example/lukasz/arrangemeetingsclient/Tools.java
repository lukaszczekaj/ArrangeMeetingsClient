package com.example.lukasz.arrangemeetingsclient;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by lukasz on 05.09.17.
 */

public class Tools {


    public static void exceptionToast(Context context, String message) {
        final Dialog dialog = new Dialog(context); // Context, this, etc.
        dialog.setContentView(R.layout.error_message);
       // TextView txt = dialog.findViewById(R.id.dialog_info);
     //   txt.setText(message);
        dialog.show();
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

    }

}

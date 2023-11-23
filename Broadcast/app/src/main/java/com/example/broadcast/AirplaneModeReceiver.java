package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //this method is called when the Broadcast Receiver receives a broadcast

        if (intent.getAction() != null &&
                intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            boolean isAirPlaneModeOn = intent.getBooleanExtra("state", false);
            String msg = isAirPlaneModeOn ? "Airplane mode is ON" :
                    "Airplane mode is OFF";

            Toast.makeText(context,
                    ""+msg,
                    Toast.LENGTH_LONG).show();
        }

    }
}

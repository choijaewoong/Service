package com.torerov.staggered;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SMSReceiver extends BroadcastReceiver {
    public SMSReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
//        Toast.makeText(context, "Receive SMS", Toast.LENGTH_SHORT).show();
//        abortBroadcast();
        Intent i = new Intent(context, MyService.class);
        context.startService(i);
    }
}

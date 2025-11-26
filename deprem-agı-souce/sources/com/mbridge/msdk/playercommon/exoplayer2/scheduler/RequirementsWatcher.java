package com.mbridge.msdk.playercommon.exoplayer2.scheduler;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

public final class RequirementsWatcher {
    private static final String TAG = "RequirementsWatcher";
    private final Context context;
    private final Listener listener;
    private CapabilityValidatedCallback networkCallback;
    private DeviceStatusChangeReceiver receiver;
    private final Requirements requirements;
    private boolean requirementsWereMet;

    @RequiresApi(api = 21)
    private final class CapabilityValidatedCallback extends ConnectivityManager.NetworkCallback {
        private CapabilityValidatedCallback() {
        }

        public final void onAvailable(Network network) {
            super.onAvailable(network);
            RequirementsWatcher.logd(RequirementsWatcher.this + " NetworkCallback.onAvailable");
            RequirementsWatcher.this.checkRequirements(false);
        }

        public final void onLost(Network network) {
            super.onLost(network);
            RequirementsWatcher.logd(RequirementsWatcher.this + " NetworkCallback.onLost");
            RequirementsWatcher.this.checkRequirements(false);
        }
    }

    private class DeviceStatusChangeReceiver extends BroadcastReceiver {
        private DeviceStatusChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                RequirementsWatcher.logd(RequirementsWatcher.this + " received " + intent.getAction());
                RequirementsWatcher.this.checkRequirements(false);
            }
        }
    }

    public interface Listener {
        void requirementsMet(RequirementsWatcher requirementsWatcher);

        void requirementsNotMet(RequirementsWatcher requirementsWatcher);
    }

    public RequirementsWatcher(Context context2, Listener listener2, Requirements requirements2) {
        this.requirements = requirements2;
        this.listener = listener2;
        this.context = context2.getApplicationContext();
        logd(this + " created");
    }

    /* access modifiers changed from: private */
    public void checkRequirements(boolean z4) {
        boolean checkRequirements = this.requirements.checkRequirements(this.context);
        if (z4 || checkRequirements != this.requirementsWereMet) {
            this.requirementsWereMet = checkRequirements;
            if (checkRequirements) {
                logd("start job");
                this.listener.requirementsMet(this);
                return;
            }
            logd("stop job");
            this.listener.requirementsNotMet(this);
            return;
        }
        logd("requirementsAreMet is still " + checkRequirements);
    }

    /* access modifiers changed from: private */
    public static void logd(String str) {
    }

    @TargetApi(23)
    private void registerNetworkCallbackV23() {
        NetworkRequest build = new NetworkRequest.Builder().addCapability(16).build();
        CapabilityValidatedCallback capabilityValidatedCallback = new CapabilityValidatedCallback();
        this.networkCallback = capabilityValidatedCallback;
        ((ConnectivityManager) this.context.getSystemService("connectivity")).registerNetworkCallback(build, capabilityValidatedCallback);
    }

    private void unregisterNetworkCallback() {
        if (Util.SDK_INT >= 21) {
            ((ConnectivityManager) this.context.getSystemService("connectivity")).unregisterNetworkCallback(this.networkCallback);
            this.networkCallback = null;
        }
    }

    public final Requirements getRequirements() {
        return this.requirements;
    }

    public final void start() {
        Assertions.checkNotNull(Looper.myLooper());
        checkRequirements(true);
        IntentFilter intentFilter = new IntentFilter();
        if (this.requirements.getRequiredNetworkType() != 0) {
            if (Util.SDK_INT >= 23) {
                registerNetworkCallbackV23();
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.requirements.isChargingRequired()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.requirements.isIdleRequired()) {
            if (Util.SDK_INT >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        DeviceStatusChangeReceiver deviceStatusChangeReceiver = new DeviceStatusChangeReceiver();
        this.receiver = deviceStatusChangeReceiver;
        this.context.registerReceiver(deviceStatusChangeReceiver, intentFilter, (String) null, new Handler());
        logd(this + " started");
    }

    public final void stop() {
        this.context.unregisterReceiver(this.receiver);
        this.receiver = null;
        if (this.networkCallback != null) {
            unregisterNetworkCallback();
        }
        logd(this + " stopped");
    }

    public final String toString() {
        return super.toString();
    }
}

package com.finazzi.distquake;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import androidx.core.app.m;
import java.io.IOException;
import u2.U1;

public class PlayerService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    private a f13435a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f13436b;

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("com.finazzi.distquake.stopalarm")) {
                if (PlayerService.this.f13436b != null && PlayerService.this.f13436b.isPlaying()) {
                    PlayerService.this.f13436b.stop();
                }
                PlayerService.this.stopSelf();
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
        stopSelf();
    }

    public void onDestroy() {
        a aVar = this.f13435a;
        if (aVar != null) {
            unregisterReceiver(aVar);
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }

    public int onStartCommand(Intent intent, int i8, int i9) {
        NotificationManager notificationManager;
        super.onStartCommand(intent, i8, i9);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26 && (notificationManager = (NotificationManager) getSystemService("notification")) != null) {
            String string = getString(C2030R.string.channel_permanent_name);
            String string2 = getString(C2030R.string.channel_permanent_description);
            NotificationChannel a8 = U1.a(getString(C2030R.string.channel_permanent), string, 2);
            a8.setDescription(string2);
            a8.enableLights(false);
            a8.enableVibration(false);
            a8.setBypassDnd(false);
            notificationManager.createNotificationChannel(a8);
        }
        Notification b8 = new m.e(this, getString(C2030R.string.channel_permanent)).i(getString(C2030R.string.options_show_icon_text_alert)).w(C2030R.drawable.bullseye).o("permanent").b();
        if (i10 >= 29) {
            startForeground(Process.myPid(), b8, 2);
        } else {
            startForeground(Process.myPid(), b8);
        }
        this.f13435a = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.finazzi.distquake.stopalarm");
        if (i10 >= 33) {
            Intent unused = registerReceiver(this.f13435a, intentFilter, 4);
        } else {
            registerReceiver(this.f13435a, intentFilter);
        }
        if (!(intent == null || intent.getAction() == null)) {
            if (intent.getAction().equals("com.finazzi.distquake.action.PLAY2")) {
                this.f13436b = new MediaPlayer();
                try {
                    this.f13436b.setDataSource(this, Uri.parse("android.resource://com.finazzi.distquake/raw/alarm2"));
                } catch (IOException | IllegalArgumentException | IllegalStateException | SecurityException e8) {
                    if (e8.getMessage() != null) {
                        Log.d("EQN", e8.getMessage());
                    }
                }
                AudioManager audioManager = (AudioManager) getSystemService("audio");
                if (audioManager != null) {
                    if (audioManager.getStreamVolume(4) != 0) {
                        this.f13436b.setAudioStreamType(4);
                        this.f13436b.setVolume(1.0f, 1.0f);
                        this.f13436b.setScreenOnWhilePlaying(true);
                        this.f13436b.setOnPreparedListener(this);
                        this.f13436b.setOnCompletionListener(this);
                        this.f13436b.setLooping(false);
                        this.f13436b.prepareAsync();
                    } else {
                        stopSelf();
                    }
                }
            }
            if (intent.getAction().equals("com.finazzi.distquake.action.PLAY3")) {
                this.f13436b = new MediaPlayer();
                try {
                    this.f13436b.setDataSource(this, Uri.parse("android.resource://com.finazzi.distquake/raw/alarm3"));
                } catch (IOException | IllegalArgumentException | IllegalStateException | SecurityException e9) {
                    if (e9.getMessage() != null) {
                        Log.d("EQN", e9.getMessage());
                    }
                }
                AudioManager audioManager2 = (AudioManager) getSystemService("audio");
                if (audioManager2 != null) {
                    if (audioManager2.getStreamVolume(4) != 0) {
                        this.f13436b.setAudioStreamType(4);
                        this.f13436b.setVolume(1.0f, 1.0f);
                        this.f13436b.setScreenOnWhilePlaying(true);
                        this.f13436b.setOnPreparedListener(this);
                        this.f13436b.setOnCompletionListener(this);
                        this.f13436b.setLooping(false);
                        this.f13436b.prepareAsync();
                    } else {
                        stopSelf();
                    }
                }
            }
            if (intent.getAction().equals("com.finazzi.distquake.action.PLAY4")) {
                this.f13436b = new MediaPlayer();
                try {
                    this.f13436b.setDataSource(this, Uri.parse("android.resource://com.finazzi.distquake/raw/alarm4"));
                } catch (IOException | IllegalArgumentException | IllegalStateException | SecurityException e10) {
                    if (e10.getMessage() != null) {
                        Log.d("EQN", e10.getMessage());
                    }
                }
                AudioManager audioManager3 = (AudioManager) getSystemService("audio");
                if (audioManager3 != null) {
                    if (audioManager3.getStreamVolume(4) != 0) {
                        this.f13436b.setAudioStreamType(4);
                        this.f13436b.setVolume(1.0f, 1.0f);
                        this.f13436b.setScreenOnWhilePlaying(true);
                        this.f13436b.setOnPreparedListener(this);
                        this.f13436b.setOnCompletionListener(this);
                        this.f13436b.setLooping(false);
                        this.f13436b.prepareAsync();
                    } else {
                        stopSelf();
                    }
                }
            }
        }
        return 1;
    }
}

package com.finazzi.distquake;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.C0768d;
import androidx.core.view.C0832r0;
import androidx.fragment.app.C0891s;
import androidx.preference.CheckBoxPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.g;
import java.util.Locale;
import u2.A3;
import u2.B3;
import u2.C3;
import u2.D3;
import u2.E3;
import u2.F3;

public class PreferencesReports extends C0768d {

    public static class MyPreferenceFragment extends PreferenceFragmentCompat {

        /* renamed from: A0  reason: collision with root package name */
        private boolean f13448A0 = false;
        /* access modifiers changed from: private */

        /* renamed from: w0  reason: collision with root package name */
        public TextToSpeech f13449w0;

        /* renamed from: x0  reason: collision with root package name */
        private final int f13450x0 = 1000;

        /* renamed from: y0  reason: collision with root package name */
        private boolean f13451y0 = false;

        /* renamed from: z0  reason: collision with root package name */
        private String f13452z0 = "0";

        class a extends UtteranceProgressListener {
            a() {
            }

            public void onDone(String str) {
                if (MyPreferenceFragment.this.f13449w0 != null) {
                    MyPreferenceFragment.this.f13449w0.stop();
                    MyPreferenceFragment.this.f13449w0.shutdown();
                }
            }

            public void onError(String str) {
                if (MyPreferenceFragment.this.f13449w0 != null) {
                    MyPreferenceFragment.this.f13449w0.stop();
                    MyPreferenceFragment.this.f13449w0.shutdown();
                }
            }

            public void onStart(String str) {
            }
        }

        public static /* synthetic */ boolean K0(Activity activity, Preference preference) {
            AudioManager audioManager;
            if (!(activity == null || (audioManager = (AudioManager) activity.getSystemService("audio")) == null)) {
                audioManager.adjustStreamVolume(3, 0, 1);
            }
            return true;
        }

        public static /* synthetic */ boolean L0(MyPreferenceFragment myPreferenceFragment, Activity activity, Preference preference) {
            if (!myPreferenceFragment.f13451y0 && activity != null) {
                SharedPreferences.Editor edit = g.b(activity).edit();
                edit.putBoolean("eqn_tts_manual", false);
                edit.apply();
                Preference a8 = myPreferenceFragment.v0().a("eqn_tts_manual");
                if (a8 != null) {
                    ((CheckBoxPreference) a8).I0(false);
                }
                Toast makeText = Toast.makeText(activity, myPreferenceFragment.getString(C2030R.string.options_tts_pro), 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
            return true;
        }

        public static /* synthetic */ void M0(MyPreferenceFragment myPreferenceFragment, int i8) {
            if (i8 != -1) {
                myPreferenceFragment.f13449w0.setSpeechRate(1.0f);
                myPreferenceFragment.f13449w0.speak(myPreferenceFragment.getString(C2030R.string.options_tts_test_manual), 0, (Bundle) null, "tts");
                return;
            }
            myPreferenceFragment.getClass();
        }

        public static /* synthetic */ boolean N0(MyPreferenceFragment myPreferenceFragment, Preference preference) {
            NotificationChannel a8;
            NotificationManager notificationManager = (NotificationManager) myPreferenceFragment.getActivity().getSystemService("notification");
            if (notificationManager == null || (a8 = notificationManager.getNotificationChannel(myPreferenceFragment.getString(C2030R.string.channel_reports))) == null) {
                return true;
            }
            Intent intent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.CHANNEL_ID", a8.getId());
            intent.putExtra("android.provider.extra.APP_PACKAGE", myPreferenceFragment.getActivity().getApplication().getPackageName());
            myPreferenceFragment.startActivity(intent);
            return true;
        }

        public static /* synthetic */ boolean O0(MyPreferenceFragment myPreferenceFragment, Preference preference) {
            myPreferenceFragment.getClass();
            try {
                Intent intent = new Intent();
                intent.setAction("android.speech.tts.engine.CHECK_TTS_DATA");
                myPreferenceFragment.startActivityForResult(intent, 1000);
                return true;
            } catch (ActivityNotFoundException unused) {
                Toast makeText = Toast.makeText(myPreferenceFragment.getActivity(), myPreferenceFragment.getString(C2030R.string.robot_no_syntetizer), 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
                return true;
            }
        }

        public static /* synthetic */ void P0(MyPreferenceFragment myPreferenceFragment, int i8) {
            if (i8 != -1) {
                myPreferenceFragment.f13448A0 = false;
                String string = myPreferenceFragment.getString(C2030R.string.current_language);
                if (string.equals("eng")) {
                    int language = myPreferenceFragment.f13449w0.setLanguage(Locale.ENGLISH);
                    if (language == -1 || language == -2) {
                        Toast makeText = Toast.makeText(myPreferenceFragment.getActivity(), myPreferenceFragment.getString(C2030R.string.robot_answer_nolanguage_eng), 1);
                        makeText.setGravity(17, 0, 0);
                        makeText.show();
                    } else {
                        myPreferenceFragment.f13448A0 = true;
                    }
                }
                if (string.equals("ita")) {
                    int language2 = myPreferenceFragment.f13449w0.setLanguage(Locale.ITALIAN);
                    if (language2 == -1 || language2 == -2) {
                        Toast makeText2 = Toast.makeText(myPreferenceFragment.getActivity(), myPreferenceFragment.getString(C2030R.string.robot_answer_nolanguage_ita), 1);
                        makeText2.setGravity(17, 0, 0);
                        makeText2.show();
                    } else {
                        myPreferenceFragment.f13448A0 = true;
                    }
                }
                if (string.equals("es")) {
                    int language3 = myPreferenceFragment.f13449w0.setLanguage(new Locale("es"));
                    if (language3 == -1 || language3 == -2) {
                        Toast makeText3 = Toast.makeText(myPreferenceFragment.getActivity(), myPreferenceFragment.getString(C2030R.string.robot_answer_nolanguage_es), 1);
                        makeText3.setGravity(17, 0, 0);
                        makeText3.show();
                    } else {
                        myPreferenceFragment.f13448A0 = true;
                    }
                }
                if (string.equals("fr")) {
                    int language4 = myPreferenceFragment.f13449w0.setLanguage(new Locale("fr"));
                    if (language4 == -1 || language4 == -2) {
                        Toast makeText4 = Toast.makeText(myPreferenceFragment.getActivity(), myPreferenceFragment.getString(C2030R.string.robot_answer_nolanguage_fr), 1);
                        makeText4.setGravity(17, 0, 0);
                        makeText4.show();
                    } else {
                        myPreferenceFragment.f13448A0 = true;
                    }
                }
                if (string.equals("el")) {
                    int language5 = myPreferenceFragment.f13449w0.setLanguage(new Locale("el"));
                    if (language5 == -1 || language5 == -2) {
                        Toast makeText5 = Toast.makeText(myPreferenceFragment.getActivity(), myPreferenceFragment.getString(C2030R.string.robot_answer_nolanguage_el), 1);
                        makeText5.setGravity(17, 0, 0);
                        makeText5.show();
                    } else {
                        myPreferenceFragment.f13448A0 = true;
                    }
                }
                if (string.equals("tr")) {
                    int language6 = myPreferenceFragment.f13449w0.setLanguage(new Locale("tr"));
                    if (language6 == -1 || language6 == -2) {
                        Toast makeText6 = Toast.makeText(myPreferenceFragment.getActivity(), myPreferenceFragment.getString(C2030R.string.robot_answer_nolanguage_tr), 1);
                        makeText6.setGravity(17, 0, 0);
                        makeText6.show();
                    } else {
                        myPreferenceFragment.f13448A0 = true;
                    }
                }
                if (string.equals("in")) {
                    int language7 = myPreferenceFragment.f13449w0.setLanguage(new Locale("in"));
                    if (language7 == -1 || language7 == -2) {
                        Toast makeText7 = Toast.makeText(myPreferenceFragment.getActivity(), myPreferenceFragment.getString(C2030R.string.robot_answer_nolanguage_in), 1);
                        makeText7.setGravity(17, 0, 0);
                        makeText7.show();
                    } else {
                        myPreferenceFragment.f13448A0 = true;
                    }
                }
                if (string.equals("hr")) {
                    int language8 = myPreferenceFragment.f13449w0.setLanguage(new Locale("hr"));
                    if (language8 == -1 || language8 == -2) {
                        Toast makeText8 = Toast.makeText(myPreferenceFragment.getActivity(), myPreferenceFragment.getString(C2030R.string.robot_answer_nolanguage_hr), 1);
                        makeText8.setGravity(17, 0, 0);
                        makeText8.show();
                    } else {
                        myPreferenceFragment.f13448A0 = true;
                    }
                }
                if (string.equals("ar")) {
                    int language9 = myPreferenceFragment.f13449w0.setLanguage(new Locale("ar"));
                    if (language9 == -1 || language9 == -2) {
                        Toast makeText9 = Toast.makeText(myPreferenceFragment.getActivity(), myPreferenceFragment.getString(C2030R.string.robot_answer_nolanguage_ar), 1);
                        makeText9.setGravity(17, 0, 0);
                        makeText9.show();
                    } else {
                        myPreferenceFragment.f13448A0 = true;
                    }
                }
                if (myPreferenceFragment.f13448A0) {
                    TextToSpeech textToSpeech = new TextToSpeech(myPreferenceFragment.getActivity(), new F3(myPreferenceFragment));
                    myPreferenceFragment.f13449w0 = textToSpeech;
                    textToSpeech.setOnUtteranceProgressListener(new a());
                    return;
                }
                return;
            }
            Toast makeText10 = Toast.makeText(myPreferenceFragment.getActivity(), myPreferenceFragment.getString(C2030R.string.robot_answer_error), 1);
            makeText10.setGravity(17, 0, 0);
            makeText10.show();
        }

        public void A0(Bundle bundle, String str) {
            Preference a8;
            I0(C2030R.xml.preferences_reports, str);
            C0891s activity = getActivity();
            if (activity != null) {
                SharedPreferences sharedPreferences = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
                this.f13452z0 = g.b(activity.getApplicationContext()).getString("eqn_system_of_units", "0");
                this.f13451y0 = sharedPreferences.getBoolean("pro_features", false);
            }
            Preference a9 = v0().a("eqn_notify_channel_change_settings_manual");
            if (a9 != null && Build.VERSION.SDK_INT >= 26) {
                a9.v0(new B3(this));
            }
            Preference a10 = v0().a("eqn_notify_radius_report");
            if (!(a10 == null || activity == null)) {
                if (g.b(activity).getString("eqn_system_of_units", "0").equals("0")) {
                    ((ListPreference) a10).T0(C2030R.array.radius_reports);
                } else {
                    ((ListPreference) a10).T0(C2030R.array.radius_reports_imperial);
                }
            }
            Preference a11 = v0().a("eqn_tts_manual");
            if (a11 != null) {
                a11.v0(new C3(this, activity));
            }
            Preference a12 = v0().a("eqn_tts_test_manual");
            if (a12 != null) {
                a12.v0(new D3(this));
            }
            Preference a13 = v0().a("eqn_tts_volume_manual");
            if (a13 != null) {
                a13.v0(new E3(activity));
            }
            if (Build.VERSION.SDK_INT < 26 && (a8 = v0().a("vibration_and_sound")) != null) {
                a8.B0(false);
            }
        }

        public void onActivityResult(int i8, int i9, Intent intent) {
            super.onActivityResult(i8, i9, intent);
            if (i8 != 1000) {
                return;
            }
            if (i9 == 1) {
                this.f13449w0 = new TextToSpeech(getActivity(), new A3(this));
                return;
            }
            try {
                Intent intent2 = new Intent();
                intent2.setAction("android.speech.tts.engine.INSTALL_TTS_DATA");
                startActivity(intent2);
            } catch (ActivityNotFoundException unused) {
                Toast makeText = Toast.makeText(getActivity(), getString(C2030R.string.robot_no_syntetizer), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        getSupportFragmentManager().o().r(16908290, new MyPreferenceFragment()).j();
    }
}

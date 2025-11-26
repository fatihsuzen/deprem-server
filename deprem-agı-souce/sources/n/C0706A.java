package N;

import I.b;
import K.C0664k;
import K.C0667n;
import T.e;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.ConfigurationCompat;
import com.google.android.gms.common.util.h;
import java.util.Locale;

/* renamed from: N.A  reason: case insensitive filesystem */
public abstract class C0706A {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleArrayMap f2978a = new SimpleArrayMap();

    /* renamed from: b  reason: collision with root package name */
    private static Locale f2979b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return e.a(context).d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(str)) {
                return packageName;
            }
            return str;
        }
    }

    public static String b(Context context, int i5) {
        Resources resources = context.getResources();
        if (i5 == 1) {
            return resources.getString(b.common_google_play_services_install_button);
        }
        if (i5 == 2) {
            return resources.getString(b.common_google_play_services_update_button);
        }
        if (i5 != 3) {
            return resources.getString(17039370);
        }
        return resources.getString(b.common_google_play_services_enable_button);
    }

    public static String c(Context context, int i5) {
        Resources resources = context.getResources();
        String a5 = a(context);
        if (i5 == 1) {
            return resources.getString(b.common_google_play_services_install_text, new Object[]{a5});
        } else if (i5 != 2) {
            if (i5 == 3) {
                return resources.getString(b.common_google_play_services_enable_text, new Object[]{a5});
            } else if (i5 == 5) {
                return g(context, "common_google_play_services_invalid_account_text", a5);
            } else {
                if (i5 == 7) {
                    return g(context, "common_google_play_services_network_error_text", a5);
                }
                if (i5 == 9) {
                    return resources.getString(b.common_google_play_services_unsupported_text, new Object[]{a5});
                } else if (i5 == 20) {
                    return g(context, "common_google_play_services_restricted_profile_text", a5);
                } else {
                    switch (i5) {
                        case 16:
                            return g(context, "common_google_play_services_api_unavailable_text", a5);
                        case 17:
                            return g(context, "common_google_play_services_sign_in_failed_text", a5);
                        case 18:
                            return resources.getString(b.common_google_play_services_updating_text, new Object[]{a5});
                        default:
                            return resources.getString(C0667n.common_google_play_services_unknown_issue, new Object[]{a5});
                    }
                }
            }
        } else if (h.d(context)) {
            return resources.getString(b.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(b.common_google_play_services_update_text, new Object[]{a5});
        }
    }

    public static String d(Context context, int i5) {
        if (i5 == 6 || i5 == 19) {
            return g(context, "common_google_play_services_resolution_required_text", a(context));
        }
        return c(context, i5);
    }

    public static String e(Context context, int i5) {
        String str;
        if (i5 == 6) {
            str = h(context, "common_google_play_services_resolution_required_title");
        } else {
            str = f(context, i5);
        }
        if (str == null) {
            return context.getResources().getString(b.common_google_play_services_notification_ticker);
        }
        return str;
    }

    public static String f(Context context, int i5) {
        Resources resources = context.getResources();
        switch (i5) {
            case 1:
                return resources.getString(b.common_google_play_services_install_title);
            case 2:
                return resources.getString(b.common_google_play_services_update_title);
            case 3:
                return resources.getString(b.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return h(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return h(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return h(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return h(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i5);
                return null;
        }
    }

    private static String g(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String h5 = h(context, str);
        if (h5 == null) {
            h5 = resources.getString(C0667n.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, h5, new Object[]{str2});
    }

    private static String h(Context context, String str) {
        SimpleArrayMap simpleArrayMap = f2978a;
        synchronized (simpleArrayMap) {
            try {
                Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
                if (!locale.equals(f2979b)) {
                    simpleArrayMap.clear();
                    f2979b = locale;
                }
                String str2 = (String) simpleArrayMap.get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources e5 = C0664k.e(context);
                if (e5 == null) {
                    return null;
                }
                int identifier = e5.getIdentifier(str, TypedValues.Custom.S_STRING, "com.google.android.gms");
                if (identifier == 0) {
                    Log.w("GoogleApiAvailability", "Missing resource: " + str);
                    return null;
                }
                String string = e5.getString(identifier);
                if (TextUtils.isEmpty(string)) {
                    Log.w("GoogleApiAvailability", "Got empty resource: " + str);
                    return null;
                }
                simpleArrayMap.put(str, string);
                return string;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

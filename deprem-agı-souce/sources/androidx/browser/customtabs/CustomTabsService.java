package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.a;
import android.support.customtabs.b;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class CustomTabsService extends Service {
    public static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    public static final String CATEGORY_COLOR_SCHEME_CUSTOMIZATION = "androidx.browser.customtabs.category.ColorSchemeCustomization";
    public static final String CATEGORY_NAVBAR_COLOR_CUSTOMIZATION = "androidx.browser.customtabs.category.NavBarColorCustomization";
    public static final String CATEGORY_TRUSTED_WEB_ACTIVITY_IMMERSIVE_MODE = "androidx.browser.trusted.category.ImmersiveMode";
    public static final String CATEGORY_WEB_SHARE_TARGET_V2 = "androidx.browser.trusted.category.WebShareTargetV2";
    public static final int FILE_PURPOSE_TRUSTED_WEB_ACTIVITY_SPLASH_IMAGE = 1;
    public static final String KEY_SUCCESS = "androidx.browser.customtabs.SUCCESS";
    public static final String KEY_URL = "android.support.customtabs.otherurls.URL";
    public static final int RELATION_HANDLE_ALL_URLS = 2;
    public static final int RELATION_USE_AS_ORIGIN = 1;
    public static final int RESULT_FAILURE_DISALLOWED = -1;
    public static final int RESULT_FAILURE_MESSAGING_ERROR = -3;
    public static final int RESULT_FAILURE_REMOTE_ERROR = -2;
    public static final int RESULT_SUCCESS = 0;
    private static final String TAG = "CustomTabsService";
    public static final String TRUSTED_WEB_ACTIVITY_CATEGORY = "androidx.browser.trusted.category.TrustedWebActivities";
    private b.a mBinder = new b.a() {
        @Nullable
        private PendingIntent getSessionIdFromBundle(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(CustomTabsIntent.EXTRA_SESSION_ID);
            bundle.remove(CustomTabsIntent.EXTRA_SESSION_ID);
            return pendingIntent;
        }

        @Nullable
        private Uri getTargetOriginFromBundle(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                return (Uri) Api33Impl.getParcelable(bundle, "target_origin", Uri.class);
            }
            return (Uri) bundle.getParcelable("target_origin");
        }

        private boolean newSessionInternal(@NonNull a aVar, @Nullable PendingIntent pendingIntent) {
            CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(aVar, pendingIntent);
            try {
                a aVar2 = new a(this, customTabsSessionToken);
                synchronized (CustomTabsService.this.mDeathRecipientMap) {
                    aVar.asBinder().linkToDeath(aVar2, 0);
                    CustomTabsService.this.mDeathRecipientMap.put(aVar.asBinder(), aVar2);
                }
                return CustomTabsService.this.newSession(customTabsSessionToken);
            } catch (RemoteException unused) {
                return false;
            }
        }

        public Bundle extraCommand(@NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.extraCommand(str, bundle);
        }

        public boolean isEngagementSignalsApiAvailable(a aVar, @NonNull Bundle bundle) {
            return CustomTabsService.this.isEngagementSignalsApiAvailable(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), bundle);
        }

        public boolean mayLaunchUrl(@Nullable a aVar, @Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list) {
            return CustomTabsService.this.mayLaunchUrl(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), uri, bundle, list);
        }

        public boolean newSession(@NonNull a aVar) {
            return newSessionInternal(aVar, (PendingIntent) null);
        }

        public boolean newSessionWithExtras(@NonNull a aVar, @Nullable Bundle bundle) {
            return newSessionInternal(aVar, getSessionIdFromBundle(bundle));
        }

        public int postMessage(@NonNull a aVar, @NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.postMessage(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), str, bundle);
        }

        public boolean receiveFile(@NonNull a aVar, @NonNull Uri uri, int i5, @Nullable Bundle bundle) {
            return CustomTabsService.this.receiveFile(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), uri, i5, bundle);
        }

        public boolean requestPostMessageChannel(@NonNull a aVar, @NonNull Uri uri) {
            return CustomTabsService.this.requestPostMessageChannel(new CustomTabsSessionToken(aVar, (PendingIntent) null), uri, (Uri) null, new Bundle());
        }

        public boolean requestPostMessageChannelWithExtras(@NonNull a aVar, @NonNull Uri uri, @NonNull Bundle bundle) {
            return CustomTabsService.this.requestPostMessageChannel(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), uri, getTargetOriginFromBundle(bundle), bundle);
        }

        public boolean setEngagementSignalsCallback(@NonNull a aVar, @NonNull IBinder iBinder, @NonNull Bundle bundle) {
            return CustomTabsService.this.setEngagementSignalsCallback(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), EngagementSignalsCallbackRemote.fromBinder(iBinder), bundle);
        }

        public boolean updateVisuals(@NonNull a aVar, @Nullable Bundle bundle) {
            return CustomTabsService.this.updateVisuals(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), bundle);
        }

        public boolean validateRelationship(@NonNull a aVar, int i5, @NonNull Uri uri, @Nullable Bundle bundle) {
            return CustomTabsService.this.validateRelationship(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), i5, uri, bundle);
        }

        public boolean warmup(long j5) {
            return CustomTabsService.this.warmup(j5);
        }
    };
    final SimpleArrayMap<IBinder, IBinder.DeathRecipient> mDeathRecipientMap = new SimpleArrayMap<>();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FilePurpose {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Relation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Result {
    }

    /* access modifiers changed from: protected */
    public boolean cleanUpSession(@NonNull CustomTabsSessionToken customTabsSessionToken) {
        try {
            synchronized (this.mDeathRecipientMap) {
                IBinder callbackBinder = customTabsSessionToken.getCallbackBinder();
                if (callbackBinder == null) {
                    return false;
                }
                callbackBinder.unlinkToDeath(this.mDeathRecipientMap.get(callbackBinder), 0);
                this.mDeathRecipientMap.remove(callbackBinder);
                return true;
            }
        } catch (NoSuchElementException unused) {
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract Bundle extraCommand(@NonNull String str, @Nullable Bundle bundle);

    /* access modifiers changed from: protected */
    public boolean isEngagementSignalsApiAvailable(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Bundle bundle) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean mayLaunchUrl(@NonNull CustomTabsSessionToken customTabsSessionToken, @Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list);

    /* access modifiers changed from: protected */
    public abstract boolean newSession(@NonNull CustomTabsSessionToken customTabsSessionToken);

    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }

    /* access modifiers changed from: protected */
    public abstract int postMessage(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull String str, @Nullable Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract boolean receiveFile(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Uri uri, int i5, @Nullable Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract boolean requestPostMessageChannel(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Uri uri);

    /* access modifiers changed from: protected */
    public boolean requestPostMessageChannel(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Uri uri, @Nullable Uri uri2, @NonNull Bundle bundle) {
        return requestPostMessageChannel(customTabsSessionToken, uri);
    }

    /* access modifiers changed from: protected */
    public boolean setEngagementSignalsCallback(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull EngagementSignalsCallback engagementSignalsCallback, @NonNull Bundle bundle) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean updateVisuals(@NonNull CustomTabsSessionToken customTabsSessionToken, @Nullable Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract boolean validateRelationship(@NonNull CustomTabsSessionToken customTabsSessionToken, int i5, @NonNull Uri uri, @Nullable Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract boolean warmup(long j5);
}

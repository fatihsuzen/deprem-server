package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.a;
import android.support.customtabs.b;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.ArrayList;
import java.util.List;

public class CustomTabsClient {
    private static final String TAG = "CustomTabsClient";
    private final Context mApplicationContext;
    private final b mService;
    private final ComponentName mServiceComponentName;

    CustomTabsClient(b bVar, ComponentName componentName, Context context) {
        this.mService = bVar;
        this.mServiceComponentName = componentName;
        this.mApplicationContext = context;
    }

    public static boolean bindCustomTabsService(@NonNull Context context, @Nullable String str, @NonNull CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    public static boolean bindCustomTabsServicePreservePriority(@NonNull Context context, @Nullable String str, @NonNull CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 1);
    }

    public static boolean connectAndInitialize(@NonNull Context context, @NonNull String str) {
        if (str == null) {
            return false;
        }
        final Context applicationContext = context.getApplicationContext();
        try {
            return bindCustomTabsService(applicationContext, str, new CustomTabsServiceConnection() {
                public final void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull CustomTabsClient customTabsClient) {
                    customTabsClient.warmup(0);
                    applicationContext.unbindService(this);
                }

                public void onServiceDisconnected(ComponentName componentName) {
                }
            });
        } catch (SecurityException unused) {
            return false;
        }
    }

    private a.C0000a createCallbackWrapper(@Nullable final CustomTabsCallback customTabsCallback) {
        return new a.C0000a() {
            private Handler mHandler = new Handler(Looper.getMainLooper());

            public void extraCallback(final String str, final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            customTabsCallback.extraCallback(str, bundle);
                        }
                    });
                }
            }

            public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) throws RemoteException {
                CustomTabsCallback customTabsCallback = customTabsCallback;
                if (customTabsCallback == null) {
                    return null;
                }
                return customTabsCallback.extraCallbackWithResult(str, bundle);
            }

            public void onActivityLayout(int i5, int i6, int i7, int i8, int i9, @NonNull Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    final int i10 = i5;
                    final int i11 = i6;
                    final int i12 = i7;
                    final int i13 = i8;
                    final int i14 = i9;
                    final Bundle bundle2 = bundle;
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            customTabsCallback.onActivityLayout(i10, i11, i12, i13, i14, bundle2);
                        }
                    });
                }
            }

            public void onActivityResized(final int i5, final int i6, @Nullable final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            customTabsCallback.onActivityResized(i5, i6, bundle);
                        }
                    });
                }
            }

            public void onMessageChannelReady(final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            customTabsCallback.onMessageChannelReady(bundle);
                        }
                    });
                }
            }

            public void onMinimized(@NonNull final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            customTabsCallback.onMinimized(bundle);
                        }
                    });
                }
            }

            public void onNavigationEvent(final int i5, final Bundle bundle) {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            customTabsCallback.onNavigationEvent(i5, bundle);
                        }
                    });
                }
            }

            public void onPostMessage(final String str, final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            customTabsCallback.onPostMessage(str, bundle);
                        }
                    });
                }
            }

            public void onRelationshipValidationResult(int i5, Uri uri, boolean z4, @Nullable Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    final int i6 = i5;
                    final Uri uri2 = uri;
                    final boolean z5 = z4;
                    final Bundle bundle2 = bundle;
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            customTabsCallback.onRelationshipValidationResult(i6, uri2, z5, bundle2);
                        }
                    });
                }
            }

            public void onUnminimized(@NonNull final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            customTabsCallback.onUnminimized(bundle);
                        }
                    });
                }
            }

            public void onWarmupCompleted(@NonNull final Bundle bundle) throws RemoteException {
                if (customTabsCallback != null) {
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            customTabsCallback.onWarmupCompleted(bundle);
                        }
                    });
                }
            }
        };
    }

    private static PendingIntent createSessionId(Context context, int i5) {
        return PendingIntent.getActivity(context, i5, new Intent(), AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    }

    @Nullable
    public static String getPackageName(@NonNull Context context, @Nullable List<String> list) {
        return getPackageName(context, list, false);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static CustomTabsSession.PendingSession newPendingSession(@NonNull Context context, @Nullable CustomTabsCallback customTabsCallback, int i5) {
        return new CustomTabsSession.PendingSession(customTabsCallback, createSessionId(context, i5));
    }

    @Nullable
    private CustomTabsSession newSessionInternal(@Nullable CustomTabsCallback customTabsCallback, @Nullable PendingIntent pendingIntent) {
        boolean z4;
        a.C0000a createCallbackWrapper = createCallbackWrapper(customTabsCallback);
        if (pendingIntent != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putParcelable(CustomTabsIntent.EXTRA_SESSION_ID, pendingIntent);
                z4 = this.mService.newSessionWithExtras(createCallbackWrapper, bundle);
            } catch (RemoteException unused) {
                return null;
            }
        } else {
            z4 = this.mService.newSession(createCallbackWrapper);
        }
        if (!z4) {
            return null;
        }
        return new CustomTabsSession(this.mService, createCallbackWrapper, this.mServiceComponentName, pendingIntent);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public CustomTabsSession attachSession(@NonNull CustomTabsSession.PendingSession pendingSession) {
        return newSessionInternal(pendingSession.getCallback(), pendingSession.getId());
    }

    @Nullable
    public Bundle extraCommand(@NonNull String str, @Nullable Bundle bundle) {
        try {
            return this.mService.extraCommand(str, bundle);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Nullable
    public CustomTabsSession newSession(@Nullable CustomTabsCallback customTabsCallback) {
        return newSessionInternal(customTabsCallback, (PendingIntent) null);
    }

    public boolean warmup(long j5) {
        try {
            return this.mService.warmup(j5);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Nullable
    public static String getPackageName(@NonNull Context context, @Nullable List<String> list, boolean z4) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = list == null ? new ArrayList() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z4 && (resolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        for (String next : arrayList) {
            intent2.setPackage(next);
            if (packageManager.resolveService(intent2, 0) != null) {
                return next;
            }
        }
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Log.w(TAG, "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
        return null;
    }

    @Nullable
    public CustomTabsSession newSession(@Nullable CustomTabsCallback customTabsCallback, int i5) {
        return newSessionInternal(customTabsCallback, createSessionId(this.mApplicationContext, i5));
    }
}

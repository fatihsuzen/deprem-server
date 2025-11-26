package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.a;
import android.support.customtabs.b;
import android.support.customtabs.c;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.browser.customtabs.CustomTabsSessionToken;
import java.util.List;
import java.util.concurrent.Executor;

public final class CustomTabsSession {
    private static final String TAG = "CustomTabsSession";
    static final String TARGET_ORIGIN_KEY = "target_origin";
    private final a mCallback;
    private final ComponentName mComponentName;
    @Nullable
    private final PendingIntent mId;
    private final Object mLock = new Object();
    private final b mService;

    static class MockSession extends b.a {
        MockSession() {
        }

        public Bundle extraCommand(String str, Bundle bundle) throws RemoteException {
            return null;
        }

        public boolean isEngagementSignalsApiAvailable(a aVar, Bundle bundle) throws RemoteException {
            return false;
        }

        public boolean mayLaunchUrl(a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException {
            return false;
        }

        public boolean newSession(a aVar) throws RemoteException {
            return false;
        }

        public boolean newSessionWithExtras(a aVar, Bundle bundle) throws RemoteException {
            return false;
        }

        public int postMessage(a aVar, String str, Bundle bundle) throws RemoteException {
            return 0;
        }

        public boolean receiveFile(a aVar, Uri uri, int i5, Bundle bundle) throws RemoteException {
            return false;
        }

        public boolean requestPostMessageChannel(a aVar, Uri uri) throws RemoteException {
            return false;
        }

        public boolean requestPostMessageChannelWithExtras(a aVar, Uri uri, Bundle bundle) throws RemoteException {
            return false;
        }

        public boolean setEngagementSignalsCallback(a aVar, IBinder iBinder, Bundle bundle) throws RemoteException {
            return false;
        }

        public boolean updateVisuals(a aVar, Bundle bundle) throws RemoteException {
            return false;
        }

        public boolean validateRelationship(a aVar, int i5, Uri uri, Bundle bundle) throws RemoteException {
            return false;
        }

        public boolean warmup(long j5) throws RemoteException {
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class PendingSession {
        @Nullable
        private final CustomTabsCallback mCallback;
        @Nullable
        private final PendingIntent mId;

        PendingSession(@Nullable CustomTabsCallback customTabsCallback, @Nullable PendingIntent pendingIntent) {
            this.mCallback = customTabsCallback;
            this.mId = pendingIntent;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public CustomTabsCallback getCallback() {
            return this.mCallback;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public PendingIntent getId() {
            return this.mId;
        }
    }

    CustomTabsSession(b bVar, a aVar, ComponentName componentName, @Nullable PendingIntent pendingIntent) {
        this.mService = bVar;
        this.mCallback = aVar;
        this.mComponentName = componentName;
        this.mId = pendingIntent;
    }

    private void addIdToBundle(Bundle bundle) {
        PendingIntent pendingIntent = this.mId;
        if (pendingIntent != null) {
            bundle.putParcelable(CustomTabsIntent.EXTRA_SESSION_ID, pendingIntent);
        }
    }

    private Bundle createBundleWithId(@Nullable Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        addIdToBundle(bundle2);
        return bundle2;
    }

    private c.a createEngagementSignalsCallbackWrapper(@NonNull final EngagementSignalsCallback engagementSignalsCallback) {
        return new c.a() {
            private final Handler mHandler = new Handler(Looper.getMainLooper());

            public void onGreatestScrollPercentageIncreased(int i5, Bundle bundle) {
                this.mHandler.post(new c(engagementSignalsCallback, i5, bundle));
            }

            public void onSessionEnded(boolean z4, Bundle bundle) {
                this.mHandler.post(new b(engagementSignalsCallback, z4, bundle));
            }

            public void onVerticalScrollEvent(boolean z4, Bundle bundle) {
                this.mHandler.post(new d(engagementSignalsCallback, z4, bundle));
            }
        };
    }

    @VisibleForTesting
    @NonNull
    public static CustomTabsSession createMockSessionForTesting(@NonNull ComponentName componentName) {
        return new CustomTabsSession(new MockSession(), new CustomTabsSessionToken.MockCallback(), componentName, (PendingIntent) null);
    }

    @Nullable
    private Bundle createPostMessageExtraBundle(@Nullable Uri uri) {
        Bundle bundle = new Bundle();
        if (uri != null) {
            bundle.putParcelable(TARGET_ORIGIN_KEY, uri);
        }
        if (this.mId != null) {
            addIdToBundle(bundle);
        }
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public IBinder getBinder() {
        return this.mCallback.asBinder();
    }

    /* access modifiers changed from: package-private */
    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public PendingIntent getId() {
        return this.mId;
    }

    public boolean isEngagementSignalsApiAvailable(@NonNull Bundle bundle) throws RemoteException {
        try {
            return this.mService.isEngagementSignalsApiAvailable(this.mCallback, createBundleWithId(bundle));
        } catch (SecurityException e5) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e5);
        }
    }

    public boolean mayLaunchUrl(@Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list) {
        try {
            return this.mService.mayLaunchUrl(this.mCallback, uri, createBundleWithId(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public int postMessage(@NonNull String str, @Nullable Bundle bundle) {
        int postMessage;
        Bundle createBundleWithId = createBundleWithId(bundle);
        synchronized (this.mLock) {
            try {
                postMessage = this.mService.postMessage(this.mCallback, str, createBundleWithId);
            } catch (RemoteException unused) {
                return -2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return postMessage;
    }

    public boolean receiveFile(@NonNull Uri uri, int i5, @Nullable Bundle bundle) {
        try {
            return this.mService.receiveFile(this.mCallback, uri, i5, createBundleWithId(bundle));
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean requestPostMessageChannel(@NonNull Uri uri) {
        return requestPostMessageChannel(uri, (Uri) null, new Bundle());
    }

    public boolean setActionButton(@NonNull Bitmap bitmap, @NonNull String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
        bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(CustomTabsIntent.EXTRA_ACTION_BUTTON_BUNDLE, bundle);
        addIdToBundle(bundle);
        try {
            return this.mService.updateVisuals(this.mCallback, bundle2);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean setEngagementSignalsCallback(@NonNull EngagementSignalsCallback engagementSignalsCallback, @NonNull Bundle bundle) throws RemoteException {
        try {
            return this.mService.setEngagementSignalsCallback(this.mCallback, createEngagementSignalsCallbackWrapper(engagementSignalsCallback).asBinder(), createBundleWithId(bundle));
        } catch (SecurityException e5) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e5);
        }
    }

    public boolean setSecondaryToolbarSwipeUpGesture(@Nullable PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_SWIPE_UP_GESTURE, pendingIntent);
        addIdToBundle(bundle);
        try {
            return this.mService.updateVisuals(this.mCallback, bundle);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean setSecondaryToolbarViews(@Nullable RemoteViews remoteViews, @Nullable int[] iArr, @Nullable PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CustomTabsIntent.EXTRA_REMOTEVIEWS, remoteViews);
        bundle.putIntArray(CustomTabsIntent.EXTRA_REMOTEVIEWS_VIEW_IDS, iArr);
        bundle.putParcelable(CustomTabsIntent.EXTRA_REMOTEVIEWS_PENDINGINTENT, pendingIntent);
        addIdToBundle(bundle);
        try {
            return this.mService.updateVisuals(this.mCallback, bundle);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Deprecated
    public boolean setToolbarItem(int i5, @NonNull Bitmap bitmap, @NonNull String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(CustomTabsIntent.KEY_ID, i5);
        bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
        bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(CustomTabsIntent.EXTRA_ACTION_BUTTON_BUNDLE, bundle);
        addIdToBundle(bundle2);
        try {
            return this.mService.updateVisuals(this.mCallback, bundle2);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean validateRelationship(int i5, @NonNull Uri uri, @Nullable Bundle bundle) {
        if (i5 >= 1 && i5 <= 2) {
            try {
                return this.mService.validateRelationship(this.mCallback, i5, uri, createBundleWithId(bundle));
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    private c.a createEngagementSignalsCallbackWrapper(@NonNull EngagementSignalsCallback engagementSignalsCallback, @NonNull Executor executor) {
        return new c.a(executor, engagementSignalsCallback) {
            private final Executor mExecutor;
            final /* synthetic */ EngagementSignalsCallback val$callback;
            final /* synthetic */ Executor val$executor;

            {
                this.val$executor = r2;
                this.val$callback = r3;
                this.mExecutor = r2;
            }

            public void onGreatestScrollPercentageIncreased(int i5, Bundle bundle) {
                long clearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    this.mExecutor.execute(new f(this.val$callback, i5, bundle));
                } finally {
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }

            public void onSessionEnded(boolean z4, Bundle bundle) {
                long clearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    this.mExecutor.execute(new g(this.val$callback, z4, bundle));
                } finally {
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }

            public void onVerticalScrollEvent(boolean z4, Bundle bundle) {
                long clearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    this.mExecutor.execute(new e(this.val$callback, z4, bundle));
                } finally {
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
        };
    }

    public boolean requestPostMessageChannel(@NonNull Uri uri, @Nullable Uri uri2, @NonNull Bundle bundle) {
        try {
            Bundle createPostMessageExtraBundle = createPostMessageExtraBundle(uri2);
            if (createPostMessageExtraBundle == null) {
                return this.mService.requestPostMessageChannel(this.mCallback, uri);
            }
            bundle.putAll(createPostMessageExtraBundle);
            return this.mService.requestPostMessageChannelWithExtras(this.mCallback, uri, bundle);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean setEngagementSignalsCallback(@NonNull Executor executor, @NonNull EngagementSignalsCallback engagementSignalsCallback, @NonNull Bundle bundle) throws RemoteException {
        try {
            return this.mService.setEngagementSignalsCallback(this.mCallback, createEngagementSignalsCallbackWrapper(engagementSignalsCallback, executor).asBinder(), createBundleWithId(bundle));
        } catch (SecurityException e5) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e5);
        }
    }
}

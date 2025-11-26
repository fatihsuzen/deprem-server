package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.a;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public class CustomTabsSessionToken {
    private static final String TAG = "CustomTabsSessionToken";
    @Nullable
    private final CustomTabsCallback mCallback;
    @Nullable
    final a mCallbackBinder;
    @Nullable
    private final PendingIntent mSessionId;

    static class MockCallback extends a.C0000a {
        MockCallback() {
        }

        public IBinder asBinder() {
            return this;
        }

        public void extraCallback(String str, Bundle bundle) {
        }

        public Bundle extraCallbackWithResult(String str, Bundle bundle) {
            return null;
        }

        public void onActivityLayout(int i5, int i6, int i7, int i8, int i9, @NonNull Bundle bundle) {
        }

        public void onActivityResized(int i5, int i6, Bundle bundle) {
        }

        public void onMessageChannelReady(Bundle bundle) {
        }

        public void onMinimized(@NonNull Bundle bundle) {
        }

        public void onNavigationEvent(int i5, Bundle bundle) {
        }

        public void onPostMessage(String str, Bundle bundle) {
        }

        public void onRelationshipValidationResult(int i5, Uri uri, boolean z4, Bundle bundle) {
        }

        public void onUnminimized(@NonNull Bundle bundle) {
        }

        public void onWarmupCompleted(Bundle bundle) {
        }
    }

    CustomTabsSessionToken(@Nullable a aVar, @Nullable PendingIntent pendingIntent) {
        AnonymousClass1 r12;
        if (aVar == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.mCallbackBinder = aVar;
        this.mSessionId = pendingIntent;
        if (aVar == null) {
            r12 = null;
        } else {
            r12 = new CustomTabsCallback() {
                public void extraCallback(@NonNull String str, @Nullable Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.mCallbackBinder.extraCallback(str, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                @NonNull
                public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) {
                    try {
                        return CustomTabsSessionToken.this.mCallbackBinder.extraCallbackWithResult(str, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                        return null;
                    }
                }

                public void onActivityLayout(int i5, int i6, int i7, int i8, int i9, @NonNull Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.mCallbackBinder.onActivityLayout(i5, i6, i7, i8, i9, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                public void onActivityResized(int i5, int i6, @NonNull Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.mCallbackBinder.onActivityResized(i5, i6, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                public void onMessageChannelReady(@Nullable Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.mCallbackBinder.onMessageChannelReady(bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                public void onMinimized(@NonNull Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.mCallbackBinder.onMinimized(bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                public void onNavigationEvent(int i5, @Nullable Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.mCallbackBinder.onNavigationEvent(i5, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                public void onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.mCallbackBinder.onPostMessage(str, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                public void onRelationshipValidationResult(int i5, @NonNull Uri uri, boolean z4, @Nullable Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.mCallbackBinder.onRelationshipValidationResult(i5, uri, z4, bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                public void onUnminimized(@NonNull Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.mCallbackBinder.onUnminimized(bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }

                public void onWarmupCompleted(@NonNull Bundle bundle) {
                    try {
                        CustomTabsSessionToken.this.mCallbackBinder.onWarmupCompleted(bundle);
                    } catch (RemoteException unused) {
                        Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    }
                }
            };
        }
        this.mCallback = r12;
    }

    @NonNull
    public static CustomTabsSessionToken createMockSessionTokenForTesting() {
        return new CustomTabsSessionToken(new MockCallback(), (PendingIntent) null);
    }

    private IBinder getCallbackBinderAssertNotNull() {
        a aVar = this.mCallbackBinder;
        if (aVar != null) {
            return aVar.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    @Nullable
    public static CustomTabsSessionToken getSessionTokenFromIntent(@NonNull Intent intent) {
        Bundle extras = intent.getExtras();
        a aVar = null;
        if (extras == null) {
            return null;
        }
        IBinder binder = extras.getBinder(CustomTabsIntent.EXTRA_SESSION);
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(CustomTabsIntent.EXTRA_SESSION_ID);
        if (binder == null && pendingIntent == null) {
            return null;
        }
        if (binder != null) {
            aVar = a.C0000a.asInterface(binder);
        }
        return new CustomTabsSessionToken(aVar, pendingIntent);
    }

    public boolean equals(Object obj) {
        boolean z4;
        if (!(obj instanceof CustomTabsSessionToken)) {
            return false;
        }
        CustomTabsSessionToken customTabsSessionToken = (CustomTabsSessionToken) obj;
        PendingIntent id = customTabsSessionToken.getId();
        PendingIntent pendingIntent = this.mSessionId;
        boolean z5 = true;
        if (pendingIntent == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (id != null) {
            z5 = false;
        }
        if (z4 != z5) {
            return false;
        }
        if (pendingIntent != null) {
            return pendingIntent.equals(id);
        }
        return getCallbackBinderAssertNotNull().equals(customTabsSessionToken.getCallbackBinderAssertNotNull());
    }

    @Nullable
    public CustomTabsCallback getCallback() {
        return this.mCallback;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public IBinder getCallbackBinder() {
        a aVar = this.mCallbackBinder;
        if (aVar == null) {
            return null;
        }
        return aVar.asBinder();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public PendingIntent getId() {
        return this.mSessionId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasCallback() {
        if (this.mCallbackBinder != null) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasId() {
        if (this.mSessionId != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.mSessionId;
        if (pendingIntent != null) {
            return pendingIntent.hashCode();
        }
        return getCallbackBinderAssertNotNull().hashCode();
    }

    public boolean isAssociatedWith(@NonNull CustomTabsSession customTabsSession) {
        return customTabsSession.getBinder().equals(this.mCallbackBinder);
    }
}

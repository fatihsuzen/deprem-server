package com.google.android.material.motion;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.BackEventCompat;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import j$.util.Objects;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialBackOrchestrator {
    @Nullable
    private final BackCallbackDelegate backCallbackDelegate;
    @NonNull
    private final MaterialBackHandler backHandler;
    @NonNull
    private final View view;

    @RequiresApi(33)
    private static class Api33BackCallbackDelegate implements BackCallbackDelegate {
        @Nullable
        private OnBackInvokedCallback onBackInvokedCallback;

        private Api33BackCallbackDelegate() {
        }

        /* access modifiers changed from: package-private */
        public OnBackInvokedCallback createOnBackInvokedCallback(@NonNull MaterialBackHandler materialBackHandler) {
            Objects.requireNonNull(materialBackHandler);
            return new b(materialBackHandler);
        }

        /* access modifiers changed from: package-private */
        public boolean isListeningForBackCallbacks() {
            if (this.onBackInvokedCallback != null) {
                return true;
            }
            return false;
        }

        @DoNotInline
        public void startListeningForBackCallbacks(@NonNull MaterialBackHandler materialBackHandler, @NonNull View view, boolean z4) {
            OnBackInvokedDispatcher a5;
            int i5;
            if (this.onBackInvokedCallback == null && (a5 = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback createOnBackInvokedCallback = createOnBackInvokedCallback(materialBackHandler);
                this.onBackInvokedCallback = createOnBackInvokedCallback;
                if (z4) {
                    i5 = 1000000;
                } else {
                    i5 = 0;
                }
                a5.registerOnBackInvokedCallback(i5, createOnBackInvokedCallback);
            }
        }

        @DoNotInline
        public void stopListeningForBackCallbacks(@NonNull View view) {
            OnBackInvokedDispatcher a5;
            if (this.onBackInvokedCallback != null && (a5 = view.findOnBackInvokedDispatcher()) != null) {
                a5.unregisterOnBackInvokedCallback(this.onBackInvokedCallback);
                this.onBackInvokedCallback = null;
            }
        }
    }

    @RequiresApi(34)
    private static class Api34BackCallbackDelegate extends Api33BackCallbackDelegate {
        private Api34BackCallbackDelegate() {
            super();
        }

        /* access modifiers changed from: package-private */
        public OnBackInvokedCallback createOnBackInvokedCallback(@NonNull final MaterialBackHandler materialBackHandler) {
            return new OnBackAnimationCallback() {
                public void onBackCancelled() {
                    if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        materialBackHandler.cancelBackProgress();
                    }
                }

                public void onBackInvoked() {
                    materialBackHandler.handleBackInvoked();
                }

                public void onBackProgressed(@NonNull BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        materialBackHandler.updateBackProgress(new BackEventCompat(backEvent));
                    }
                }

                public void onBackStarted(@NonNull BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        materialBackHandler.startBackProgress(new BackEventCompat(backEvent));
                    }
                }
            };
        }
    }

    private interface BackCallbackDelegate {
        void startListeningForBackCallbacks(@NonNull MaterialBackHandler materialBackHandler, @NonNull View view, boolean z4);

        void stopListeningForBackCallbacks(@NonNull View view);
    }

    public <T extends View & MaterialBackHandler> MaterialBackOrchestrator(@NonNull T t5) {
        this((MaterialBackHandler) t5, t5);
    }

    @Nullable
    private static BackCallbackDelegate createBackCallbackDelegate() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 34) {
            return new Api34BackCallbackDelegate();
        }
        if (i5 >= 33) {
            return new Api33BackCallbackDelegate();
        }
        return null;
    }

    public boolean shouldListenForBackCallbacks() {
        if (this.backCallbackDelegate != null) {
            return true;
        }
        return false;
    }

    public void startListeningForBackCallbacks() {
        startListeningForBackCallbacks(false);
    }

    public void startListeningForBackCallbacksWithPriorityOverlay() {
        startListeningForBackCallbacks(true);
    }

    public void stopListeningForBackCallbacks() {
        BackCallbackDelegate backCallbackDelegate2 = this.backCallbackDelegate;
        if (backCallbackDelegate2 != null) {
            backCallbackDelegate2.stopListeningForBackCallbacks(this.view);
        }
    }

    public MaterialBackOrchestrator(@NonNull MaterialBackHandler materialBackHandler, @NonNull View view2) {
        this.backCallbackDelegate = createBackCallbackDelegate();
        this.backHandler = materialBackHandler;
        this.view = view2;
    }

    private void startListeningForBackCallbacks(boolean z4) {
        BackCallbackDelegate backCallbackDelegate2 = this.backCallbackDelegate;
        if (backCallbackDelegate2 != null) {
            backCallbackDelegate2.startListeningForBackCallbacks(this.backHandler, this.view, z4);
        }
    }
}

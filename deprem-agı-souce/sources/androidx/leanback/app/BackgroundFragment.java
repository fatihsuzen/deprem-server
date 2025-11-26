package androidx.leanback.app;

import android.app.Fragment;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class BackgroundFragment extends Fragment {
    private BackgroundManager mBackgroundManager;

    /* access modifiers changed from: package-private */
    public BackgroundManager getBackgroundManager() {
        return this.mBackgroundManager;
    }

    public void onDestroy() {
        super.onDestroy();
        BackgroundManager backgroundManager = this.mBackgroundManager;
        if (backgroundManager != null) {
            backgroundManager.detach();
        }
    }

    public void onResume() {
        super.onResume();
        BackgroundManager backgroundManager = this.mBackgroundManager;
        if (backgroundManager != null) {
            backgroundManager.onResume();
        }
    }

    public void onStart() {
        super.onStart();
        BackgroundManager backgroundManager = this.mBackgroundManager;
        if (backgroundManager != null) {
            backgroundManager.onActivityStart();
        }
    }

    public void onStop() {
        BackgroundManager backgroundManager = this.mBackgroundManager;
        if (backgroundManager != null) {
            backgroundManager.onStop();
        }
        super.onStop();
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundManager(BackgroundManager backgroundManager) {
        this.mBackgroundManager = backgroundManager;
    }
}

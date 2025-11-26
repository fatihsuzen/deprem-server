package com.google.android.gms.auth.api.signin.internal;

import H.g;
import L.f;
import android.os.Bundle;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import j$.util.Objects;

final class a implements LoaderManager.LoaderCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignInHubActivity f4843a;

    /* synthetic */ a(SignInHubActivity signInHubActivity, byte[] bArr) {
        Objects.requireNonNull(signInHubActivity);
        this.f4843a = signInHubActivity;
    }

    public final Loader onCreateLoader(int i5, Bundle bundle) {
        return new g(this.f4843a, f.b());
    }

    public final /* bridge */ /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        Void voidR = (Void) obj;
        SignInHubActivity signInHubActivity = this.f4843a;
        signInHubActivity.setResult(signInHubActivity.l(), signInHubActivity.m());
        signInHubActivity.finish();
    }

    public final void onLoaderReset(Loader loader) {
    }
}

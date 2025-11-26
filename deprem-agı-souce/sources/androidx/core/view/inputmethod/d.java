package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.inputmethod.InputConnectionCompat;

public final /* synthetic */ class d implements InputConnectionCompat.OnCommitContentListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f325a;

    public /* synthetic */ d(View view) {
        this.f325a = view;
    }

    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i5, Bundle bundle) {
        return InputConnectionCompat.a(this.f325a, inputContentInfoCompat, i5, bundle);
    }
}

package androidx.window.embedding;

import androidx.window.embedding.ExtensionEmbeddingBackend;
import java.util.List;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionEmbeddingBackend.SplitListenerWrapper f493a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f494b;

    public /* synthetic */ f(ExtensionEmbeddingBackend.SplitListenerWrapper splitListenerWrapper, List list) {
        this.f493a = splitListenerWrapper;
        this.f494b = list;
    }

    public final void run() {
        ExtensionEmbeddingBackend.SplitListenerWrapper.m203accept$lambda1(this.f493a, this.f494b);
    }
}

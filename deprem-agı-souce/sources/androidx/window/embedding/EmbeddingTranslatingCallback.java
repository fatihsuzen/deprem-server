package androidx.window.embedding;

import android.annotation.SuppressLint;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import androidx.window.extensions.embedding.SplitInfo;
import j$.util.function.Consumer$CC;
import java.util.List;
import java.util.function.Consumer;
import kotlin.jvm.internal.t;

@ExperimentalWindowApi
@SuppressLint({"NewApi"})
public final class EmbeddingTranslatingCallback implements Consumer<List<? extends SplitInfo>> {
    private final EmbeddingAdapter adapter;
    private final EmbeddingInterfaceCompat.EmbeddingCallbackInterface callback;

    public EmbeddingTranslatingCallback(EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallbackInterface, EmbeddingAdapter embeddingAdapter) {
        t.e(embeddingCallbackInterface, "callback");
        t.e(embeddingAdapter, "adapter");
        this.callback = embeddingCallbackInterface;
        this.adapter = embeddingAdapter;
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public void accept(List<? extends SplitInfo> list) {
        t.e(list, "splitInfoList");
        this.callback.onSplitInfoChanged(this.adapter.translate(list));
    }
}

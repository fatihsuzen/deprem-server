package androidx.emoji2.text;

import androidx.emoji2.text.FontRequestEmojiCompatConfig;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader f352a;

    public /* synthetic */ f(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader) {
        this.f352a = fontRequestMetadataLoader;
    }

    public final void run() {
        this.f352a.loadInternal();
    }
}

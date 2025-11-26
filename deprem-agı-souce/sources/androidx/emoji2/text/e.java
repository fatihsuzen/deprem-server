package androidx.emoji2.text;

import androidx.emoji2.text.FontRequestEmojiCompatConfig;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader f351a;

    public /* synthetic */ e(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader) {
        this.f351a = fontRequestMetadataLoader;
    }

    public final void run() {
        this.f351a.createMetadata();
    }
}

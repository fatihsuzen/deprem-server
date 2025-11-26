package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmojiCompatInitializer.BackgroundDefaultLoader f348a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback f349b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f350c;

    public /* synthetic */ d(EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.f348a = backgroundDefaultLoader;
        this.f349b = metadataRepoLoaderCallback;
        this.f350c = threadPoolExecutor;
    }

    public final void run() {
        this.f348a.doLoad(this.f349b, this.f350c);
    }
}

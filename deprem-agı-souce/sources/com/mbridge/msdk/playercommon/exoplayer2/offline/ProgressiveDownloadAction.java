package com.mbridge.msdk.playercommon.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class ProgressiveDownloadAction extends DownloadAction {
    public static final DownloadAction.Deserializer DESERIALIZER = new DownloadAction.Deserializer(TYPE, 0) {
        public final ProgressiveDownloadAction readFromStream(int i5, DataInputStream dataInputStream) throws IOException {
            Uri parse = Uri.parse(dataInputStream.readUTF());
            boolean readBoolean = dataInputStream.readBoolean();
            byte[] bArr = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr);
            return new ProgressiveDownloadAction(parse, readBoolean, bArr, dataInputStream.readBoolean() ? dataInputStream.readUTF() : null);
        }
    };
    private static final String TYPE = "progressive";
    private static final int VERSION = 0;
    @Nullable
    public final String customCacheKey;

    public ProgressiveDownloadAction(Uri uri, boolean z4, @Nullable byte[] bArr, @Nullable String str) {
        super(TYPE, 0, uri, z4, bArr);
        this.customCacheKey = str;
    }

    private String getCacheKey() {
        String str = this.customCacheKey;
        if (str != null) {
            return str;
        }
        return CacheUtil.generateKey(this.uri);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        return Util.areEqual(this.customCacheKey, ((ProgressiveDownloadAction) obj).customCacheKey);
    }

    public final int hashCode() {
        int i5;
        int hashCode = super.hashCode() * 31;
        String str = this.customCacheKey;
        if (str != null) {
            i5 = str.hashCode();
        } else {
            i5 = 0;
        }
        return hashCode + i5;
    }

    public final boolean isSameMedia(DownloadAction downloadAction) {
        if (!(downloadAction instanceof ProgressiveDownloadAction) || !getCacheKey().equals(((ProgressiveDownloadAction) downloadAction).getCacheKey())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void writeToStream(DataOutputStream dataOutputStream) throws IOException {
        boolean z4;
        dataOutputStream.writeUTF(this.uri.toString());
        dataOutputStream.writeBoolean(this.isRemoveAction);
        dataOutputStream.writeInt(this.data.length);
        dataOutputStream.write(this.data);
        if (this.customCacheKey != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        dataOutputStream.writeBoolean(z4);
        if (z4) {
            dataOutputStream.writeUTF(this.customCacheKey);
        }
    }

    /* access modifiers changed from: protected */
    public final ProgressiveDownloader createDownloader(DownloaderConstructorHelper downloaderConstructorHelper) {
        return new ProgressiveDownloader(this.uri, this.customCacheKey, downloaderConstructorHelper);
    }
}

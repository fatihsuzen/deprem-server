package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

public final class DefaultDataSource implements DataSource {
    private static final String SCHEME_ASSET = "asset";
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_RAW = "rawresource";
    private static final String SCHEME_RTMP = "rtmp";
    private static final String TAG = "DefaultDataSource";
    private DataSource assetDataSource;
    private final DataSource baseDataSource;
    private DataSource contentDataSource;
    private final Context context;
    private DataSource dataSchemeDataSource;
    private DataSource dataSource;
    private DataSource fileDataSource;
    private final TransferListener<? super DataSource> listener;
    private DataSource rawResourceDataSource;
    private DataSource rtmpDataSource;

    public DefaultDataSource(Context context2, TransferListener<? super DataSource> transferListener, String str, boolean z4) {
        this(context2, transferListener, str, 8000, 8000, z4);
    }

    private DataSource getAssetDataSource() {
        if (this.assetDataSource == null) {
            this.assetDataSource = new AssetDataSource(this.context, this.listener);
        }
        return this.assetDataSource;
    }

    private DataSource getContentDataSource() {
        if (this.contentDataSource == null) {
            this.contentDataSource = new ContentDataSource(this.context, this.listener);
        }
        return this.contentDataSource;
    }

    private DataSource getDataSchemeDataSource() {
        if (this.dataSchemeDataSource == null) {
            this.dataSchemeDataSource = new DataSchemeDataSource();
        }
        return this.dataSchemeDataSource;
    }

    private DataSource getFileDataSource() {
        if (this.fileDataSource == null) {
            this.fileDataSource = new FileDataSource(this.listener);
        }
        return this.fileDataSource;
    }

    private DataSource getRawResourceDataSource() {
        if (this.rawResourceDataSource == null) {
            this.rawResourceDataSource = new RawResourceDataSource(this.context, this.listener);
        }
        return this.rawResourceDataSource;
    }

    private DataSource getRtmpDataSource() {
        if (this.rtmpDataSource == null) {
            try {
                this.rtmpDataSource = (DataSource) Class.forName("com.mbridge.msdk.playercommon.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor((Class[]) null).newInstance((Object[]) null);
            } catch (ClassNotFoundException unused) {
                Log.w(TAG, "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e5) {
                throw new RuntimeException("Error instantiating RTMP extension", e5);
            }
            if (this.rtmpDataSource == null) {
                this.rtmpDataSource = this.baseDataSource;
            }
        }
        return this.rtmpDataSource;
    }

    public final void close() throws IOException {
        DataSource dataSource2 = this.dataSource;
        if (dataSource2 != null) {
            try {
                dataSource2.close();
            } finally {
                this.dataSource = null;
            }
        }
    }

    public final Uri getUri() {
        DataSource dataSource2 = this.dataSource;
        if (dataSource2 == null) {
            return null;
        }
        return dataSource2.getUri();
    }

    public final long open(DataSpec dataSpec) throws IOException {
        boolean z4;
        if (this.dataSource == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        String scheme = dataSpec.uri.getScheme();
        if (Util.isLocalFileUri(dataSpec.uri)) {
            if (dataSpec.uri.getPath().startsWith("/android_asset/")) {
                this.dataSource = getAssetDataSource();
            } else {
                this.dataSource = getFileDataSource();
            }
        } else if (SCHEME_ASSET.equals(scheme)) {
            this.dataSource = getAssetDataSource();
        } else if (SCHEME_CONTENT.equals(scheme)) {
            this.dataSource = getContentDataSource();
        } else if (SCHEME_RTMP.equals(scheme)) {
            this.dataSource = getRtmpDataSource();
        } else if (DataSchemeDataSource.SCHEME_DATA.equals(scheme)) {
            this.dataSource = getDataSchemeDataSource();
        } else if ("rawresource".equals(scheme)) {
            this.dataSource = getRawResourceDataSource();
        } else {
            this.dataSource = this.baseDataSource;
        }
        return this.dataSource.open(dataSpec);
    }

    public final int read(byte[] bArr, int i5, int i6) throws IOException {
        return this.dataSource.read(bArr, i5, i6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultDataSource(android.content.Context r9, com.mbridge.msdk.playercommon.exoplayer2.upstream.TransferListener<? super com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource> r10, java.lang.String r11, int r12, int r13, boolean r14) {
        /*
            r8 = this;
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultHttpDataSource r0 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultHttpDataSource
            r2 = 0
            r7 = 0
            r3 = r10
            r1 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.<init>(r9, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultDataSource.<init>(android.content.Context, com.mbridge.msdk.playercommon.exoplayer2.upstream.TransferListener, java.lang.String, int, int, boolean):void");
    }

    public DefaultDataSource(Context context2, TransferListener<? super DataSource> transferListener, DataSource dataSource2) {
        this.context = context2.getApplicationContext();
        this.listener = transferListener;
        this.baseDataSource = (DataSource) Assertions.checkNotNull(dataSource2);
    }
}

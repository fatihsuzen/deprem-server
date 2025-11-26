package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class RawResourceDataSource implements DataSource {
    public static final String RAW_RESOURCE_SCHEME = "rawresource";
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private InputStream inputStream;
    private final TransferListener<? super RawResourceDataSource> listener;
    private boolean opened;
    private final Resources resources;
    private Uri uri;

    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(String str) {
            super(str);
        }

        public RawResourceDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public RawResourceDataSource(Context context) {
        this(context, (TransferListener<? super RawResourceDataSource>) null);
    }

    public static Uri buildRawResourceUri(int i5) {
        return Uri.parse("rawresource:///" + i5);
    }

    public final void close() throws RawResourceDataSourceException {
        this.uri = null;
        try {
            InputStream inputStream2 = this.inputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            this.inputStream = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.assetFileDescriptor;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    TransferListener<? super RawResourceDataSource> transferListener = this.listener;
                    if (transferListener != null) {
                        transferListener.onTransferEnd(this);
                    }
                }
            } catch (IOException e5) {
                throw new RawResourceDataSourceException(e5);
            } catch (Throwable th) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    TransferListener<? super RawResourceDataSource> transferListener2 = this.listener;
                    if (transferListener2 != null) {
                        transferListener2.onTransferEnd(this);
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            throw new RawResourceDataSourceException(e6);
        } catch (Throwable th2) {
            this.inputStream = null;
            try {
                AssetFileDescriptor assetFileDescriptor3 = this.assetFileDescriptor;
                if (assetFileDescriptor3 != null) {
                    assetFileDescriptor3.close();
                }
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    TransferListener<? super RawResourceDataSource> transferListener3 = this.listener;
                    if (transferListener3 != null) {
                        transferListener3.onTransferEnd(this);
                    }
                }
                throw th2;
            } catch (IOException e7) {
                throw new RawResourceDataSourceException(e7);
            } catch (Throwable th3) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    TransferListener<? super RawResourceDataSource> transferListener4 = this.listener;
                    if (transferListener4 != null) {
                        transferListener4.onTransferEnd(this);
                    }
                }
                throw th3;
            }
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final long open(DataSpec dataSpec) throws RawResourceDataSourceException {
        try {
            Uri uri2 = dataSpec.uri;
            this.uri = uri2;
            if (TextUtils.equals(RAW_RESOURCE_SCHEME, uri2.getScheme())) {
                this.assetFileDescriptor = this.resources.openRawResourceFd(Integer.parseInt(this.uri.getLastPathSegment()));
                FileInputStream fileInputStream = new FileInputStream(this.assetFileDescriptor.getFileDescriptor());
                this.inputStream = fileInputStream;
                fileInputStream.skip(this.assetFileDescriptor.getStartOffset());
                if (this.inputStream.skip(dataSpec.position) >= dataSpec.position) {
                    long j5 = dataSpec.length;
                    long j6 = -1;
                    if (j5 != -1) {
                        this.bytesRemaining = j5;
                    } else {
                        long length = this.assetFileDescriptor.getLength();
                        if (length != -1) {
                            j6 = length - dataSpec.position;
                        }
                        this.bytesRemaining = j6;
                    }
                    this.opened = true;
                    TransferListener<? super RawResourceDataSource> transferListener = this.listener;
                    if (transferListener != null) {
                        transferListener.onTransferStart(this, dataSpec);
                    }
                    return this.bytesRemaining;
                }
                throw new EOFException();
            }
            throw new RawResourceDataSourceException("URI must use scheme rawresource");
        } catch (NumberFormatException unused) {
            throw new RawResourceDataSourceException("Resource identifier must be an integer.");
        } catch (IOException e5) {
            throw new RawResourceDataSourceException(e5);
        }
    }

    public final int read(byte[] bArr, int i5, int i6) throws RawResourceDataSourceException {
        if (i6 == 0) {
            return 0;
        }
        long j5 = this.bytesRemaining;
        if (j5 == 0) {
            return -1;
        }
        if (j5 != -1) {
            try {
                i6 = (int) Math.min(j5, (long) i6);
            } catch (IOException e5) {
                throw new RawResourceDataSourceException(e5);
            }
        }
        int read = this.inputStream.read(bArr, i5, i6);
        if (read != -1) {
            long j6 = this.bytesRemaining;
            if (j6 != -1) {
                this.bytesRemaining = j6 - ((long) read);
            }
            TransferListener<? super RawResourceDataSource> transferListener = this.listener;
            if (transferListener != null) {
                transferListener.onBytesTransferred(this, read);
            }
            return read;
        } else if (this.bytesRemaining == -1) {
            return -1;
        } else {
            throw new RawResourceDataSourceException((IOException) new EOFException());
        }
    }

    public RawResourceDataSource(Context context, TransferListener<? super RawResourceDataSource> transferListener) {
        this.resources = context.getResources();
        this.listener = transferListener;
    }
}

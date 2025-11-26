package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource implements DataSource {
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private FileInputStream inputStream;
    private final TransferListener<? super ContentDataSource> listener;
    private boolean opened;
    private final ContentResolver resolver;
    private Uri uri;

    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context) {
        this(context, (TransferListener<? super ContentDataSource>) null);
    }

    public final void close() throws ContentDataSourceException {
        this.uri = null;
        try {
            FileInputStream fileInputStream = this.inputStream;
            if (fileInputStream != null) {
                fileInputStream.close();
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
                    TransferListener<? super ContentDataSource> transferListener = this.listener;
                    if (transferListener != null) {
                        transferListener.onTransferEnd(this);
                    }
                }
            } catch (IOException e5) {
                throw new ContentDataSourceException(e5);
            } catch (Throwable th) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    TransferListener<? super ContentDataSource> transferListener2 = this.listener;
                    if (transferListener2 != null) {
                        transferListener2.onTransferEnd(this);
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            throw new ContentDataSourceException(e6);
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
                    TransferListener<? super ContentDataSource> transferListener3 = this.listener;
                    if (transferListener3 != null) {
                        transferListener3.onTransferEnd(this);
                    }
                }
                throw th2;
            } catch (IOException e7) {
                throw new ContentDataSourceException(e7);
            } catch (Throwable th3) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    TransferListener<? super ContentDataSource> transferListener4 = this.listener;
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

    public final long open(DataSpec dataSpec) throws ContentDataSourceException {
        try {
            Uri uri2 = dataSpec.uri;
            this.uri = uri2;
            AssetFileDescriptor openAssetFileDescriptor = this.resolver.openAssetFileDescriptor(uri2, CampaignEx.JSON_KEY_AD_R);
            this.assetFileDescriptor = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                this.inputStream = new FileInputStream(this.assetFileDescriptor.getFileDescriptor());
                long startOffset = this.assetFileDescriptor.getStartOffset();
                long skip = this.inputStream.skip(dataSpec.position + startOffset) - startOffset;
                if (skip == dataSpec.position) {
                    long j5 = dataSpec.length;
                    long j6 = -1;
                    if (j5 != -1) {
                        this.bytesRemaining = j5;
                    } else {
                        long length = this.assetFileDescriptor.getLength();
                        if (length == -1) {
                            FileChannel channel = this.inputStream.getChannel();
                            long size = channel.size();
                            if (size != 0) {
                                j6 = size - channel.position();
                            }
                            this.bytesRemaining = j6;
                        } else {
                            this.bytesRemaining = length - skip;
                        }
                    }
                    this.opened = true;
                    TransferListener<? super ContentDataSource> transferListener = this.listener;
                    if (transferListener != null) {
                        transferListener.onTransferStart(this, dataSpec);
                    }
                    return this.bytesRemaining;
                }
                throw new EOFException();
            }
            throw new FileNotFoundException("Could not open file descriptor for: " + this.uri);
        } catch (IOException e5) {
            throw new ContentDataSourceException(e5);
        }
    }

    public final int read(byte[] bArr, int i5, int i6) throws ContentDataSourceException {
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
                throw new ContentDataSourceException(e5);
            }
        }
        int read = this.inputStream.read(bArr, i5, i6);
        if (read != -1) {
            long j6 = this.bytesRemaining;
            if (j6 != -1) {
                this.bytesRemaining = j6 - ((long) read);
            }
            TransferListener<? super ContentDataSource> transferListener = this.listener;
            if (transferListener != null) {
                transferListener.onBytesTransferred(this, read);
            }
            return read;
        } else if (this.bytesRemaining == -1) {
            return -1;
        } else {
            throw new ContentDataSourceException(new EOFException());
        }
    }

    public ContentDataSource(Context context, TransferListener<? super ContentDataSource> transferListener) {
        this.resolver = context.getContentResolver();
        this.listener = transferListener;
    }
}

package com.mbridge.msdk.thrid.okhttp.internal.cache2;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Source;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final Buffer buffer = new Buffer();
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    final Buffer upstreamBuffer = new Buffer();
    long upstreamPos;
    Thread upstreamReader;

    class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                synchronized (Relay.this) {
                    try {
                        Relay relay = Relay.this;
                        int i5 = relay.sourceCount - 1;
                        relay.sourceCount = i5;
                        if (i5 == 0) {
                            RandomAccessFile randomAccessFile2 = relay.file;
                            relay.file = null;
                            randomAccessFile = randomAccessFile2;
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly((Closeable) randomAccessFile);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r0 = r1.this$0;
            r5 = r0.upstream.read(r0.upstreamBuffer, r0.bufferMaxSize);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
            if (r5 != -1) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
            r1.this$0.commit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            r0 = r1.this$0;
            r0.upstreamReader = null;
            r0.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0053, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0054, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0058, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r15 = java.lang.Math.min(r5, r2);
            r1.this$0.upstreamBuffer.copyTo(r22, 0, r15);
            r2 = r15;
            r1.sourcePos += r2;
            r19 = r5;
            r1.fileOperator.write(r7 + com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.FILE_HEADER_SIZE, r1.this$0.upstreamBuffer.clone(), r19);
            r5 = r19;
            r7 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            r0 = r1.this$0;
            r0.buffer.write(r0.upstreamBuffer, r5);
            r8 = r1.this$0.buffer.size();
            r0 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x009c, code lost:
            if (r8 <= r0.bufferMaxSize) goto L_0x00af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x009e, code lost:
            r0 = r0.buffer;
            r0.skip(r0.size() - r1.this$0.bufferMaxSize);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ad, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00af, code lost:
            r8 = r1.this$0;
            r8.upstreamPos += r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b6, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b7, code lost:
            monitor-enter(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r0 = r1.this$0;
            r0.upstreamReader = null;
            r0.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00bf, code lost:
            monitor-exit(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c0, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c8, code lost:
            monitor-enter(r1.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            r3 = r1.this$0;
            r3.upstreamReader = null;
            r3.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d1, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            r5 = r7 - r0.buffer.size();
            r11 = r1.sourcePos;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e1, code lost:
            if (r11 >= r5) goto L_0x00fa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x00e4, code lost:
            r9 = java.lang.Math.min(r2, r7 - r11);
            r1.fileOperator.read(r1.sourcePos + com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.FILE_HEADER_SIZE, r22, r9);
            r1.sourcePos += r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f9, code lost:
            return r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            r9 = java.lang.Math.min(r2, r7 - r11);
            r1.this$0.buffer.copyTo(r22, r1.sourcePos - r5, r9);
            r1.sourcePos += r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0113, code lost:
            return r9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(com.mbridge.msdk.thrid.okio.Buffer r22, long r23) throws java.io.IOException {
            /*
                r21 = this;
                r1 = r21
                r2 = r23
                com.mbridge.msdk.thrid.okhttp.internal.cache2.FileOperator r0 = r1.fileOperator
                if (r0 == 0) goto L_0x0116
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r4 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this
                monitor-enter(r4)
            L_0x000b:
                long r5 = r1.sourcePos     // Catch:{ all -> 0x001f }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x001f }
                long r7 = r0.upstreamPos     // Catch:{ all -> 0x001f }
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                r9 = 32
                if (r5 != 0) goto L_0x00d5
                boolean r5 = r0.complete     // Catch:{ all -> 0x001f }
                r11 = -1
                if (r5 == 0) goto L_0x0022
                monitor-exit(r4)     // Catch:{ all -> 0x001f }
                return r11
            L_0x001f:
                r0 = move-exception
                goto L_0x0114
            L_0x0022:
                java.lang.Thread r5 = r0.upstreamReader     // Catch:{ all -> 0x001f }
                if (r5 == 0) goto L_0x002c
                com.mbridge.msdk.thrid.okio.Timeout r5 = r1.timeout     // Catch:{ all -> 0x001f }
                r5.waitUntilNotified(r0)     // Catch:{ all -> 0x001f }
                goto L_0x000b
            L_0x002c:
                java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x001f }
                r0.upstreamReader = r5     // Catch:{ all -> 0x001f }
                monitor-exit(r4)     // Catch:{ all -> 0x001f }
                r4 = 0
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0058 }
                com.mbridge.msdk.thrid.okio.Source r5 = r0.upstream     // Catch:{ all -> 0x0058 }
                com.mbridge.msdk.thrid.okio.Buffer r6 = r0.upstreamBuffer     // Catch:{ all -> 0x0058 }
                long r13 = r0.bufferMaxSize     // Catch:{ all -> 0x0058 }
                long r5 = r5.read(r6, r13)     // Catch:{ all -> 0x0058 }
                int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r0 != 0) goto L_0x005a
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0058 }
                r0.commit(r7)     // Catch:{ all -> 0x0058 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r2 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this
                monitor-enter(r2)
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0055 }
                r0.upstreamReader = r4     // Catch:{ all -> 0x0055 }
                r0.notifyAll()     // Catch:{ all -> 0x0055 }
                monitor-exit(r2)     // Catch:{ all -> 0x0055 }
                return r11
            L_0x0055:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0055 }
                throw r0
            L_0x0058:
                r0 = move-exception
                goto L_0x00c6
            L_0x005a:
                long r15 = java.lang.Math.min(r5, r2)     // Catch:{ all -> 0x0058 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0058 }
                com.mbridge.msdk.thrid.okio.Buffer r11 = r0.upstreamBuffer     // Catch:{ all -> 0x0058 }
                r13 = 0
                r12 = r22
                r11.copyTo((com.mbridge.msdk.thrid.okio.Buffer) r12, (long) r13, (long) r15)     // Catch:{ all -> 0x0058 }
                r2 = r15
                long r11 = r1.sourcePos     // Catch:{ all -> 0x0058 }
                long r11 = r11 + r2
                r1.sourcePos = r11     // Catch:{ all -> 0x0058 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.FileOperator r15 = r1.fileOperator     // Catch:{ all -> 0x0058 }
                long r16 = r7 + r9
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0058 }
                com.mbridge.msdk.thrid.okio.Buffer r0 = r0.upstreamBuffer     // Catch:{ all -> 0x0058 }
                com.mbridge.msdk.thrid.okio.Buffer r18 = r0.clone()     // Catch:{ all -> 0x0058 }
                r19 = r5
                r15.write(r16, r18, r19)     // Catch:{ all -> 0x0058 }
                r5 = r19
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r7 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0058 }
                monitor-enter(r7)     // Catch:{ all -> 0x0058 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x00ad }
                com.mbridge.msdk.thrid.okio.Buffer r8 = r0.buffer     // Catch:{ all -> 0x00ad }
                com.mbridge.msdk.thrid.okio.Buffer r0 = r0.upstreamBuffer     // Catch:{ all -> 0x00ad }
                r8.write((com.mbridge.msdk.thrid.okio.Buffer) r0, (long) r5)     // Catch:{ all -> 0x00ad }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x00ad }
                com.mbridge.msdk.thrid.okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x00ad }
                long r8 = r0.size()     // Catch:{ all -> 0x00ad }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x00ad }
                long r10 = r0.bufferMaxSize     // Catch:{ all -> 0x00ad }
                int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r8 <= 0) goto L_0x00af
                com.mbridge.msdk.thrid.okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x00ad }
                long r8 = r0.size()     // Catch:{ all -> 0x00ad }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r10 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x00ad }
                long r10 = r10.bufferMaxSize     // Catch:{ all -> 0x00ad }
                long r8 = r8 - r10
                r0.skip(r8)     // Catch:{ all -> 0x00ad }
                goto L_0x00af
            L_0x00ad:
                r0 = move-exception
                goto L_0x00c4
            L_0x00af:
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r8 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x00ad }
                long r9 = r8.upstreamPos     // Catch:{ all -> 0x00ad }
                long r9 = r9 + r5
                r8.upstreamPos = r9     // Catch:{ all -> 0x00ad }
                monitor-exit(r7)     // Catch:{ all -> 0x00ad }
                monitor-enter(r8)
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x00c1 }
                r0.upstreamReader = r4     // Catch:{ all -> 0x00c1 }
                r0.notifyAll()     // Catch:{ all -> 0x00c1 }
                monitor-exit(r8)     // Catch:{ all -> 0x00c1 }
                return r2
            L_0x00c1:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x00c1 }
                throw r0
            L_0x00c4:
                monitor-exit(r7)     // Catch:{ all -> 0x00ad }
                throw r0     // Catch:{ all -> 0x0058 }
            L_0x00c6:
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r2 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this
                monitor-enter(r2)
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r3 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x00d2 }
                r3.upstreamReader = r4     // Catch:{ all -> 0x00d2 }
                r3.notifyAll()     // Catch:{ all -> 0x00d2 }
                monitor-exit(r2)     // Catch:{ all -> 0x00d2 }
                throw r0
            L_0x00d2:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00d2 }
                throw r0
            L_0x00d5:
                com.mbridge.msdk.thrid.okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x001f }
                long r5 = r0.size()     // Catch:{ all -> 0x001f }
                long r5 = r7 - r5
                long r11 = r1.sourcePos     // Catch:{ all -> 0x001f }
                int r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x00fa
                monitor-exit(r4)     // Catch:{ all -> 0x001f }
                long r7 = r7 - r11
                long r2 = java.lang.Math.min(r2, r7)
                com.mbridge.msdk.thrid.okhttp.internal.cache2.FileOperator r5 = r1.fileOperator
                long r6 = r1.sourcePos
                long r6 = r6 + r9
                r8 = r22
                r9 = r2
                r5.read(r6, r8, r9)
                long r2 = r1.sourcePos
                long r2 = r2 + r9
                r1.sourcePos = r2
                return r9
            L_0x00fa:
                long r7 = r7 - r11
                long r9 = java.lang.Math.min(r2, r7)     // Catch:{ all -> 0x001f }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x001f }
                com.mbridge.msdk.thrid.okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x001f }
                long r2 = r1.sourcePos     // Catch:{ all -> 0x001f }
                long r7 = r2 - r5
                r6 = r22
                r5 = r0
                r5.copyTo((com.mbridge.msdk.thrid.okio.Buffer) r6, (long) r7, (long) r9)     // Catch:{ all -> 0x001f }
                long r2 = r1.sourcePos     // Catch:{ all -> 0x001f }
                long r2 = r2 + r9
                r1.sourcePos = r2     // Catch:{ all -> 0x001f }
                monitor-exit(r4)     // Catch:{ all -> 0x001f }
                return r9
            L_0x0114:
                monitor-exit(r4)     // Catch:{ all -> 0x001f }
                throw r0
            L_0x0116:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "closed"
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.RelaySource.read(com.mbridge.msdk.thrid.okio.Buffer, long):long");
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j5, ByteString byteString, long j6) {
        boolean z4;
        this.file = randomAccessFile;
        this.upstream = source;
        if (source == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.complete = z4;
        this.upstreamPos = j5;
        this.metadata = byteString;
        this.bufferMaxSize = j6;
    }

    public static Relay edit(File file2, Source source, ByteString byteString, long j5) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0, byteString, j5);
        randomAccessFile.setLength(0);
        relay.writeHeader(PREFIX_DIRTY, -1, -1);
        return relay;
    }

    public static Relay read(File file2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer2 = new Buffer();
        fileOperator.read(0, buffer2, FILE_HEADER_SIZE);
        ByteString byteString = PREFIX_CLEAN;
        if (buffer2.readByteString((long) byteString.size()).equals(byteString)) {
            long readLong = buffer2.readLong();
            long readLong2 = buffer2.readLong();
            Buffer buffer3 = new Buffer();
            fileOperator.read(FILE_HEADER_SIZE + readLong, buffer3, readLong2);
            return new Relay(randomAccessFile, (Source) null, readLong, buffer3.readByteString(), 0);
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(ByteString byteString, long j5, long j6) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(byteString);
        buffer2.writeLong(j5);
        buffer2.writeLong(j6);
        if (buffer2.size() == FILE_HEADER_SIZE) {
            new FileOperator(this.file.getChannel()).write(0, buffer2, FILE_HEADER_SIZE);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long j5) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(FILE_HEADER_SIZE + j5, buffer2, (long) this.metadata.size());
    }

    /* access modifiers changed from: package-private */
    public void commit(long j5) throws IOException {
        writeMetadata(j5);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j5, (long) this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            try {
                this.complete = true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        Util.closeQuietly((Closeable) this.upstream);
        this.upstream = null;
    }

    /* access modifiers changed from: package-private */
    public boolean isClosed() {
        if (this.file == null) {
            return true;
        }
        return false;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        synchronized (this) {
            try {
                if (this.file == null) {
                    return null;
                }
                this.sourceCount++;
                return new RelaySource();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}

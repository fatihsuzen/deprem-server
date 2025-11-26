package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem;
import com.mbridge.msdk.thrid.okhttp.internal.platform.Platform;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import com.mbridge.msdk.thrid.okio.Okio;
import com.mbridge.msdk.thrid.okio.Sink;
import com.mbridge.msdk.thrid.okio.Source;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class DiskLruCache implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r1 = r5.this$0;
            r1.mostRecentRebuildFailed = true;
            r1.journalWriter = com.mbridge.msdk.thrid.okio.Okio.buffer(com.mbridge.msdk.thrid.okio.Okio.blackhole());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache r0 = com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache r1 = com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0010 }
                boolean r2 = r1.initialized     // Catch:{ all -> 0x0010 }
                r3 = 1
                r2 = r2 ^ r3
                boolean r4 = r1.closed     // Catch:{ all -> 0x0010 }
                r2 = r2 | r4
                if (r2 == 0) goto L_0x0012
                monitor-exit(r0)     // Catch:{ all -> 0x0010 }
                return
            L_0x0010:
                r1 = move-exception
                goto L_0x003d
            L_0x0012:
                r1.trimToSize()     // Catch:{ IOException -> 0x0016 }
                goto L_0x001a
            L_0x0016:
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache r1 = com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0010 }
                r1.mostRecentTrimFailed = r3     // Catch:{ all -> 0x0010 }
            L_0x001a:
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache r1 = com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002d }
                boolean r1 = r1.journalRebuildRequired()     // Catch:{ IOException -> 0x002d }
                if (r1 == 0) goto L_0x003b
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache r1 = com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002d }
                r1.rebuildJournal()     // Catch:{ IOException -> 0x002d }
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache r1 = com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002d }
                r2 = 0
                r1.redundantOpCount = r2     // Catch:{ IOException -> 0x002d }
                goto L_0x003b
            L_0x002d:
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache r1 = com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0010 }
                r1.mostRecentRebuildFailed = r3     // Catch:{ all -> 0x0010 }
                com.mbridge.msdk.thrid.okio.Sink r2 = com.mbridge.msdk.thrid.okio.Okio.blackhole()     // Catch:{ all -> 0x0010 }
                com.mbridge.msdk.thrid.okio.BufferedSink r2 = com.mbridge.msdk.thrid.okio.Okio.buffer((com.mbridge.msdk.thrid.okio.Sink) r2)     // Catch:{ all -> 0x0010 }
                r1.journalWriter = r2     // Catch:{ all -> 0x0010 }
            L_0x003b:
                monitor-exit(r0)     // Catch:{ all -> 0x0010 }
                return
            L_0x003d:
                monitor-exit(r0)     // Catch:{ all -> 0x0010 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.AnonymousClass1.run():void");
        }
    };
    boolean closed;
    final File directory;
    private final Executor executor;
    final FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    BufferedSink journalWriter;
    final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    private long nextSequenceNumber = 0;
    int redundantOpCount;
    private long size = 0;
    final int valueCount;

    public final class Editor {
        private boolean done;
        final Entry entry;
        final boolean[] written;

        Editor(Entry entry2) {
            boolean[] zArr;
            this.entry = entry2;
            if (entry2.readable) {
                zArr = null;
            } else {
                zArr = new boolean[DiskLruCache.this.valueCount];
            }
            this.written = zArr;
        }

        public void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                try {
                    if (!this.done) {
                        if (this.entry.currentEditor == this) {
                            DiskLruCache.this.completeEdit(this, false);
                        }
                        this.done = true;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:7|8)|10|11) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0016 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void abortUnlessCommitted() {
            /*
                r3 = this;
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache r0 = com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r3.done     // Catch:{ all -> 0x0014 }
                if (r1 != 0) goto L_0x0016
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0014 }
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Editor r1 = r1.currentEditor     // Catch:{ all -> 0x0014 }
                if (r1 != r3) goto L_0x0016
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache r1 = com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x0016 }
                r2 = 0
                r1.completeEdit(r3, r2)     // Catch:{ IOException -> 0x0016 }
                goto L_0x0016
            L_0x0014:
                r1 = move-exception
                goto L_0x0018
            L_0x0016:
                monitor-exit(r0)     // Catch:{ all -> 0x0014 }
                return
            L_0x0018:
                monitor-exit(r0)     // Catch:{ all -> 0x0014 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.Editor.abortUnlessCommitted():void");
        }

        public void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                try {
                    if (!this.done) {
                        if (this.entry.currentEditor == this) {
                            DiskLruCache.this.completeEdit(this, true);
                        }
                        this.done = true;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void detach() {
            if (this.entry.currentEditor == this) {
                int i5 = 0;
                while (true) {
                    DiskLruCache diskLruCache = DiskLruCache.this;
                    if (i5 < diskLruCache.valueCount) {
                        try {
                            diskLruCache.fileSystem.delete(this.entry.dirtyFiles[i5]);
                        } catch (IOException unused) {
                        }
                        i5++;
                    } else {
                        this.entry.currentEditor = null;
                        return;
                    }
                }
            }
        }

        public Sink newSink(int i5) {
            synchronized (DiskLruCache.this) {
                try {
                    if (!this.done) {
                        Entry entry2 = this.entry;
                        if (entry2.currentEditor != this) {
                            Sink blackhole = Okio.blackhole();
                            return blackhole;
                        }
                        if (!entry2.readable) {
                            this.written[i5] = true;
                        }
                        AnonymousClass1 r12 = new FaultHidingSink(DiskLruCache.this.fileSystem.sink(entry2.dirtyFiles[i5])) {
                            /* access modifiers changed from: protected */
                            public void onException(IOException iOException) {
                                synchronized (DiskLruCache.this) {
                                    Editor.this.detach();
                                }
                            }
                        };
                        return r12;
                    }
                    throw new IllegalStateException();
                } catch (FileNotFoundException unused) {
                    return Okio.blackhole();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.mbridge.msdk.thrid.okio.Source newSource(int r5) {
            /*
                r4 = this;
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache r0 = com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r4.done     // Catch:{ all -> 0x0021 }
                if (r1 != 0) goto L_0x0027
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x0021 }
                boolean r2 = r1.readable     // Catch:{ all -> 0x0021 }
                r3 = 0
                if (r2 == 0) goto L_0x0025
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Editor r2 = r1.currentEditor     // Catch:{ all -> 0x0021 }
                if (r2 == r4) goto L_0x0013
                goto L_0x0025
            L_0x0013:
                com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache r2 = com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.this     // Catch:{ FileNotFoundException -> 0x0023 }
                com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem r2 = r2.fileSystem     // Catch:{ FileNotFoundException -> 0x0023 }
                java.io.File[] r1 = r1.cleanFiles     // Catch:{ FileNotFoundException -> 0x0023 }
                r5 = r1[r5]     // Catch:{ FileNotFoundException -> 0x0023 }
                com.mbridge.msdk.thrid.okio.Source r5 = r2.source(r5)     // Catch:{ FileNotFoundException -> 0x0023 }
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                return r5
            L_0x0021:
                r5 = move-exception
                goto L_0x002d
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                return r3
            L_0x0025:
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                return r3
            L_0x0027:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0021 }
                r5.<init>()     // Catch:{ all -> 0x0021 }
                throw r5     // Catch:{ all -> 0x0021 }
            L_0x002d:
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.Editor.newSource(int):com.mbridge.msdk.thrid.okio.Source");
        }
    }

    private final class Entry {
        final File[] cleanFiles;
        Editor currentEditor;
        final File[] dirtyFiles;
        final String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;

        Entry(String str) {
            this.key = str;
            int i5 = DiskLruCache.this.valueCount;
            this.lengths = new long[i5];
            this.cleanFiles = new File[i5];
            this.dirtyFiles = new File[i5];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i6 = 0; i6 < DiskLruCache.this.valueCount; i6++) {
                sb.append(i6);
                this.cleanFiles[i6] = new File(DiskLruCache.this.directory, sb.toString());
                sb.append(".tmp");
                this.dirtyFiles[i6] = new File(DiskLruCache.this.directory, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        public void setLengths(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.valueCount) {
                int i5 = 0;
                while (i5 < strArr.length) {
                    try {
                        this.lengths[i5] = Long.parseLong(strArr[i5]);
                        i5++;
                    } catch (NumberFormatException unused) {
                        throw invalidLengths(strArr);
                    }
                }
                return;
            }
            throw invalidLengths(strArr);
        }

        /* access modifiers changed from: package-private */
        public Snapshot snapshot() {
            Source source;
            if (Thread.holdsLock(DiskLruCache.this)) {
                Source[] sourceArr = new Source[DiskLruCache.this.valueCount];
                long[] jArr = (long[]) this.lengths.clone();
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    try {
                        DiskLruCache diskLruCache = DiskLruCache.this;
                        if (i6 >= diskLruCache.valueCount) {
                            return new Snapshot(this.key, this.sequenceNumber, sourceArr, jArr);
                        }
                        sourceArr[i6] = diskLruCache.fileSystem.source(this.cleanFiles[i6]);
                        i6++;
                    } catch (FileNotFoundException unused) {
                        while (true) {
                            DiskLruCache diskLruCache2 = DiskLruCache.this;
                            if (i5 >= diskLruCache2.valueCount || (source = sourceArr[i5]) == null) {
                                try {
                                    diskLruCache2.removeEntry(this);
                                    return null;
                                } catch (IOException unused2) {
                                    return null;
                                }
                            } else {
                                Util.closeQuietly((Closeable) source);
                                i5++;
                            }
                        }
                    }
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public void writeLengths(BufferedSink bufferedSink) throws IOException {
            for (long writeDecimalLong : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }
    }

    public final class Snapshot implements Closeable {
        /* access modifiers changed from: private */
        public final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;

        Snapshot(String str, long j5, Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j5;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        public void close() {
            for (Source closeQuietly : this.sources) {
                Util.closeQuietly((Closeable) closeQuietly);
            }
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public long getLength(int i5) {
            return this.lengths[i5];
        }

        public Source getSource(int i5) {
            return this.sources[i5];
        }

        public String key() {
            return this.key;
        }
    }

    DiskLruCache(FileSystem fileSystem2, File file, int i5, int i6, long j5, Executor executor2) {
        this.fileSystem = fileSystem2;
        this.directory = file;
        this.appVersion = i5;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i6;
        this.maxSize = j5;
        this.executor = executor2;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static DiskLruCache create(FileSystem fileSystem2, File file, int i5, int i6, long j5) {
        if (j5 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i6 > 0) {
            return new DiskLruCache(fileSystem2, file, i5, i6, j5, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer((Sink) new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            /* access modifiers changed from: protected */
            public void onException(IOException iOException) {
                DiskLruCache.this.hasJournalErrors = true;
            }
        });
    }

    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i5 = 0;
            if (next.currentEditor == null) {
                while (i5 < this.valueCount) {
                    this.size += next.lengths[i5];
                    i5++;
                }
            } else {
                next.currentEditor = null;
                while (i5 < this.valueCount) {
                    this.fileSystem.delete(next.cleanFiles[i5]);
                    this.fileSystem.delete(next.dirtyFiles[i5]);
                    i5++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|(1:20)(1:21)|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r9.redundantOpCount = r0 - r9.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        if (r1.exhausted() == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        rebuildJournal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        r9.journalWriter = newJournalWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x007c=Splitter:B:24:0x007c, B:17:0x005f=Splitter:B:17:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readJournal() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem r1 = r9.fileSystem
            java.io.File r2 = r9.journalFile
            com.mbridge.msdk.thrid.okio.Source r1 = r1.source(r2)
            com.mbridge.msdk.thrid.okio.BufferedSource r1 = com.mbridge.msdk.thrid.okio.Okio.buffer((com.mbridge.msdk.thrid.okio.Source) r1)
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r5 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r6 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x007c
            int r7 = r9.appVersion     // Catch:{ all -> 0x005d }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x005d }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            int r4 = r9.valueCount     // Catch:{ all -> 0x005d }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x005d }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ EOFException -> 0x005f }
            r9.readJournalLine(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            r0 = move-exception
            goto L_0x00aa
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry> r2 = r9.lruEntries     // Catch:{ all -> 0x005d }
            int r2 = r2.size()     // Catch:{ all -> 0x005d }
            int r0 = r0 - r2
            r9.redundantOpCount = r0     // Catch:{ all -> 0x005d }
            boolean r0 = r1.exhausted()     // Catch:{ all -> 0x005d }
            if (r0 != 0) goto L_0x0072
            r9.rebuildJournal()     // Catch:{ all -> 0x005d }
            goto L_0x0078
        L_0x0072:
            com.mbridge.msdk.thrid.okio.BufferedSink r0 = r9.newJournalWriter()     // Catch:{ all -> 0x005d }
            r9.journalWriter = r0     // Catch:{ all -> 0x005d }
        L_0x0078:
            com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.io.Closeable) r1)
            return
        L_0x007c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r7.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x005d }
            r7.append(r2)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r3)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r5)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r6)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x005d }
            r4.<init>(r0)     // Catch:{ all -> 0x005d }
            throw r4     // Catch:{ all -> 0x005d }
        L_0x00aa:
            com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.readJournal():void");
    }

    private void readJournalLine(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i5 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i5);
            if (indexOf2 == -1) {
                str2 = str.substring(i5);
                if (indexOf == 6 && str.startsWith(REMOVE)) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i5, indexOf2);
            }
            Entry entry = this.lruEntries.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.lruEntries.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                entry.readable = true;
                entry.currentEditor = null;
                entry.setLengths(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
                entry.currentEditor = new Editor(entry);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(READ)) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public synchronized void close() throws IOException {
        try {
            if (this.initialized) {
                if (!this.closed) {
                    for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                        Editor editor = entry.currentEditor;
                        if (editor != null) {
                            editor.abort();
                        }
                    }
                    trimToSize();
                    this.journalWriter.close();
                    this.journalWriter = null;
                    this.closed = true;
                    return;
                }
            }
            this.closed = true;
        } finally {
            while (true) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void completeEdit(com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry r0 = r10.entry     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Editor r1 = r0.currentEditor     // Catch:{ all -> 0x002a }
            if (r1 != r10) goto L_0x00f8
            r1 = 0
            if (r11 == 0) goto L_0x004a
            boolean r2 = r0.readable     // Catch:{ all -> 0x002a }
            if (r2 != 0) goto L_0x004a
            r2 = r1
        L_0x000f:
            int r3 = r9.valueCount     // Catch:{ all -> 0x002a }
            if (r2 >= r3) goto L_0x004a
            boolean[] r3 = r10.written     // Catch:{ all -> 0x002a }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x002a }
            if (r3 == 0) goto L_0x0030
            com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem r3 = r9.fileSystem     // Catch:{ all -> 0x002a }
            java.io.File[] r4 = r0.dirtyFiles     // Catch:{ all -> 0x002a }
            r4 = r4[r2]     // Catch:{ all -> 0x002a }
            boolean r3 = r3.exists(r4)     // Catch:{ all -> 0x002a }
            if (r3 != 0) goto L_0x002d
            r10.abort()     // Catch:{ all -> 0x002a }
            monitor-exit(r9)
            return
        L_0x002a:
            r10 = move-exception
            goto L_0x00fe
        L_0x002d:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x0030:
            r10.abort()     // Catch:{ all -> 0x002a }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            r11.<init>()     // Catch:{ all -> 0x002a }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x002a }
            r11.append(r2)     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x002a }
            r10.<init>(r11)     // Catch:{ all -> 0x002a }
            throw r10     // Catch:{ all -> 0x002a }
        L_0x004a:
            int r10 = r9.valueCount     // Catch:{ all -> 0x002a }
            if (r1 >= r10) goto L_0x0082
            java.io.File[] r10 = r0.dirtyFiles     // Catch:{ all -> 0x002a }
            r10 = r10[r1]     // Catch:{ all -> 0x002a }
            if (r11 == 0) goto L_0x007a
            com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem r2 = r9.fileSystem     // Catch:{ all -> 0x002a }
            boolean r2 = r2.exists(r10)     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x007f
            java.io.File[] r2 = r0.cleanFiles     // Catch:{ all -> 0x002a }
            r2 = r2[r1]     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem r3 = r9.fileSystem     // Catch:{ all -> 0x002a }
            r3.rename(r10, r2)     // Catch:{ all -> 0x002a }
            long[] r10 = r0.lengths     // Catch:{ all -> 0x002a }
            r3 = r10[r1]     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem r10 = r9.fileSystem     // Catch:{ all -> 0x002a }
            long r5 = r10.size(r2)     // Catch:{ all -> 0x002a }
            long[] r10 = r0.lengths     // Catch:{ all -> 0x002a }
            r10[r1] = r5     // Catch:{ all -> 0x002a }
            long r7 = r9.size     // Catch:{ all -> 0x002a }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.size = r7     // Catch:{ all -> 0x002a }
            goto L_0x007f
        L_0x007a:
            com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem r2 = r9.fileSystem     // Catch:{ all -> 0x002a }
            r2.delete(r10)     // Catch:{ all -> 0x002a }
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x004a
        L_0x0082:
            int r10 = r9.redundantOpCount     // Catch:{ all -> 0x002a }
            r1 = 1
            int r10 = r10 + r1
            r9.redundantOpCount = r10     // Catch:{ all -> 0x002a }
            r10 = 0
            r0.currentEditor = r10     // Catch:{ all -> 0x002a }
            boolean r10 = r0.readable     // Catch:{ all -> 0x002a }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00be
            r0.readable = r1     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.thrid.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            java.lang.String r1 = "CLEAN"
            com.mbridge.msdk.thrid.okio.BufferedSink r10 = r10.writeUtf8(r1)     // Catch:{ all -> 0x002a }
            r10.writeByte(r3)     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.thrid.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            java.lang.String r1 = r0.key     // Catch:{ all -> 0x002a }
            r10.writeUtf8(r1)     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.thrid.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            r0.writeLengths(r10)     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.thrid.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            r10.writeByte(r2)     // Catch:{ all -> 0x002a }
            if (r11 == 0) goto L_0x00dc
            long r10 = r9.nextSequenceNumber     // Catch:{ all -> 0x002a }
            r1 = 1
            long r1 = r1 + r10
            r9.nextSequenceNumber = r1     // Catch:{ all -> 0x002a }
            r0.sequenceNumber = r10     // Catch:{ all -> 0x002a }
            goto L_0x00dc
        L_0x00be:
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry> r10 = r9.lruEntries     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r0.key     // Catch:{ all -> 0x002a }
            r10.remove(r11)     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.thrid.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            java.lang.String r11 = "REMOVE"
            com.mbridge.msdk.thrid.okio.BufferedSink r10 = r10.writeUtf8(r11)     // Catch:{ all -> 0x002a }
            r10.writeByte(r3)     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.thrid.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r0.key     // Catch:{ all -> 0x002a }
            r10.writeUtf8(r11)     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.thrid.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            r10.writeByte(r2)     // Catch:{ all -> 0x002a }
        L_0x00dc:
            com.mbridge.msdk.thrid.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            r10.flush()     // Catch:{ all -> 0x002a }
            long r10 = r9.size     // Catch:{ all -> 0x002a }
            long r0 = r9.maxSize     // Catch:{ all -> 0x002a }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x00ef
            boolean r10 = r9.journalRebuildRequired()     // Catch:{ all -> 0x002a }
            if (r10 == 0) goto L_0x00f6
        L_0x00ef:
            java.util.concurrent.Executor r10 = r9.executor     // Catch:{ all -> 0x002a }
            java.lang.Runnable r11 = r9.cleanupRunnable     // Catch:{ all -> 0x002a }
            r10.execute(r11)     // Catch:{ all -> 0x002a }
        L_0x00f6:
            monitor-exit(r9)
            return
        L_0x00f8:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002a }
            r10.<init>()     // Catch:{ all -> 0x002a }
            throw r10     // Catch:{ all -> 0x002a }
        L_0x00fe:
            monitor-exit(r9)     // Catch:{ all -> 0x002a }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.completeEdit(com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    public void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public Editor edit(String str) throws IOException {
        return edit(str, -1);
    }

    public synchronized void evictAll() throws IOException {
        try {
            initialize();
            for (Entry removeEntry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                removeEntry(removeEntry);
            }
            this.mostRecentTrimFailed = false;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.Snapshot get(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.initialize()     // Catch:{ all -> 0x004d }
            r3.checkNotClosed()     // Catch:{ all -> 0x004d }
            r3.validateKey(r4)     // Catch:{ all -> 0x004d }
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry> r0 = r3.lruEntries     // Catch:{ all -> 0x004d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x004d }
            com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry r0 = (com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x004d }
            r1 = 0
            if (r0 == 0) goto L_0x0051
            boolean r2 = r0.readable     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x001a
            goto L_0x0051
        L_0x001a:
            com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Snapshot r0 = r0.snapshot()     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            int r1 = r3.redundantOpCount     // Catch:{ all -> 0x004d }
            int r1 = r1 + 1
            r3.redundantOpCount = r1     // Catch:{ all -> 0x004d }
            com.mbridge.msdk.thrid.okio.BufferedSink r1 = r3.journalWriter     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "READ"
            com.mbridge.msdk.thrid.okio.BufferedSink r1 = r1.writeUtf8(r2)     // Catch:{ all -> 0x004d }
            r2 = 32
            com.mbridge.msdk.thrid.okio.BufferedSink r1 = r1.writeByte(r2)     // Catch:{ all -> 0x004d }
            com.mbridge.msdk.thrid.okio.BufferedSink r4 = r1.writeUtf8(r4)     // Catch:{ all -> 0x004d }
            r1 = 10
            r4.writeByte(r1)     // Catch:{ all -> 0x004d }
            boolean r4 = r3.journalRebuildRequired()     // Catch:{ all -> 0x004d }
            if (r4 == 0) goto L_0x004f
            java.util.concurrent.Executor r4 = r3.executor     // Catch:{ all -> 0x004d }
            java.lang.Runnable r1 = r3.cleanupRunnable     // Catch:{ all -> 0x004d }
            r4.execute(r1)     // Catch:{ all -> 0x004d }
            goto L_0x004f
        L_0x004d:
            r4 = move-exception
            goto L_0x0053
        L_0x004f:
            monitor-exit(r3)
            return r0
        L_0x0051:
            monitor-exit(r3)
            return r1
        L_0x0053:
            monitor-exit(r3)     // Catch:{ all -> 0x004d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.get(java.lang.String):com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Snapshot");
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void initialize() throws IOException {
        try {
            if (!this.initialized) {
                if (this.fileSystem.exists(this.journalFileBackup)) {
                    if (this.fileSystem.exists(this.journalFile)) {
                        this.fileSystem.delete(this.journalFileBackup);
                    } else {
                        this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                    }
                }
                if (this.fileSystem.exists(this.journalFile)) {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                }
                rebuildJournal();
                this.initialized = true;
            }
        } catch (IOException e5) {
            Platform platform = Platform.get();
            platform.log(5, "DiskLruCache " + this.directory + " is corrupt: " + e5.getMessage() + ", removing", e5);
            delete();
            this.closed = false;
        } catch (Throwable th) {
            this.closed = false;
            throw th;
        }
    }

    public synchronized boolean isClosed() {
        return this.closed;
    }

    /* access modifiers changed from: package-private */
    public boolean journalRebuildRequired() {
        int i5 = this.redundantOpCount;
        if (i5 < 2000 || i5 < this.lruEntries.size()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0071, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00be, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void rebuildJournal() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            com.mbridge.msdk.thrid.okio.BufferedSink r0 = r6.journalWriter     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x000c
            r0.close()     // Catch:{ all -> 0x0009 }
            goto L_0x000c
        L_0x0009:
            r0 = move-exception
            goto L_0x00bf
        L_0x000c:
            com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.journalFileTmp     // Catch:{ all -> 0x0009 }
            com.mbridge.msdk.thrid.okio.Sink r0 = r0.sink(r1)     // Catch:{ all -> 0x0009 }
            com.mbridge.msdk.thrid.okio.BufferedSink r0 = com.mbridge.msdk.thrid.okio.Okio.buffer((com.mbridge.msdk.thrid.okio.Sink) r0)     // Catch:{ all -> 0x0009 }
            java.lang.String r1 = "libcore.io.DiskLruCache"
            com.mbridge.msdk.thrid.okio.BufferedSink r1 = r0.writeUtf8(r1)     // Catch:{ all -> 0x0071 }
            r2 = 10
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "1"
            com.mbridge.msdk.thrid.okio.BufferedSink r1 = r0.writeUtf8(r1)     // Catch:{ all -> 0x0071 }
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            int r1 = r6.appVersion     // Catch:{ all -> 0x0071 }
            long r3 = (long) r1     // Catch:{ all -> 0x0071 }
            com.mbridge.msdk.thrid.okio.BufferedSink r1 = r0.writeDecimalLong(r3)     // Catch:{ all -> 0x0071 }
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            int r1 = r6.valueCount     // Catch:{ all -> 0x0071 }
            long r3 = (long) r1     // Catch:{ all -> 0x0071 }
            com.mbridge.msdk.thrid.okio.BufferedSink r1 = r0.writeDecimalLong(r3)     // Catch:{ all -> 0x0071 }
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            r0.writeByte(r2)     // Catch:{ all -> 0x0071 }
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry> r1 = r6.lruEntries     // Catch:{ all -> 0x0071 }
            java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0071 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0071 }
        L_0x004d:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0071 }
            if (r3 == 0) goto L_0x0088
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0071 }
            com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry r3 = (com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.Entry) r3     // Catch:{ all -> 0x0071 }
            com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Editor r4 = r3.currentEditor     // Catch:{ all -> 0x0071 }
            r5 = 32
            if (r4 == 0) goto L_0x0073
            java.lang.String r4 = "DIRTY"
            com.mbridge.msdk.thrid.okio.BufferedSink r4 = r0.writeUtf8(r4)     // Catch:{ all -> 0x0071 }
            r4.writeByte(r5)     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = r3.key     // Catch:{ all -> 0x0071 }
            r0.writeUtf8(r3)     // Catch:{ all -> 0x0071 }
            r0.writeByte(r2)     // Catch:{ all -> 0x0071 }
            goto L_0x004d
        L_0x0071:
            r1 = move-exception
            goto L_0x00bb
        L_0x0073:
            java.lang.String r4 = "CLEAN"
            com.mbridge.msdk.thrid.okio.BufferedSink r4 = r0.writeUtf8(r4)     // Catch:{ all -> 0x0071 }
            r4.writeByte(r5)     // Catch:{ all -> 0x0071 }
            java.lang.String r4 = r3.key     // Catch:{ all -> 0x0071 }
            r0.writeUtf8(r4)     // Catch:{ all -> 0x0071 }
            r3.writeLengths(r0)     // Catch:{ all -> 0x0071 }
            r0.writeByte(r2)     // Catch:{ all -> 0x0071 }
            goto L_0x004d
        L_0x0088:
            r0.close()     // Catch:{ all -> 0x0009 }
            com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.journalFile     // Catch:{ all -> 0x0009 }
            boolean r0 = r0.exists(r1)     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x009e
            com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.journalFile     // Catch:{ all -> 0x0009 }
            java.io.File r2 = r6.journalFileBackup     // Catch:{ all -> 0x0009 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x0009 }
        L_0x009e:
            com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.journalFileTmp     // Catch:{ all -> 0x0009 }
            java.io.File r2 = r6.journalFile     // Catch:{ all -> 0x0009 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x0009 }
            com.mbridge.msdk.thrid.okhttp.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.journalFileBackup     // Catch:{ all -> 0x0009 }
            r0.delete(r1)     // Catch:{ all -> 0x0009 }
            com.mbridge.msdk.thrid.okio.BufferedSink r0 = r6.newJournalWriter()     // Catch:{ all -> 0x0009 }
            r6.journalWriter = r0     // Catch:{ all -> 0x0009 }
            r0 = 0
            r6.hasJournalErrors = r0     // Catch:{ all -> 0x0009 }
            r6.mostRecentRebuildFailed = r0     // Catch:{ all -> 0x0009 }
            monitor-exit(r6)
            return
        L_0x00bb:
            r0.close()     // Catch:{ all -> 0x0009 }
            throw r1     // Catch:{ all -> 0x0009 }
        L_0x00bf:
            monitor-exit(r6)     // Catch:{ all -> 0x0009 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.rebuildJournal():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r6) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.initialize()     // Catch:{ all -> 0x0028 }
            r5.checkNotClosed()     // Catch:{ all -> 0x0028 }
            r5.validateKey(r6)     // Catch:{ all -> 0x0028 }
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry> r0 = r5.lruEntries     // Catch:{ all -> 0x0028 }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x0028 }
            com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry r6 = (com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.Entry) r6     // Catch:{ all -> 0x0028 }
            r0 = 0
            if (r6 != 0) goto L_0x0017
            monitor-exit(r5)
            return r0
        L_0x0017:
            boolean r6 = r5.removeEntry(r6)     // Catch:{ all -> 0x0028 }
            if (r6 == 0) goto L_0x002a
            long r1 = r5.size     // Catch:{ all -> 0x0028 }
            long r3 = r5.maxSize     // Catch:{ all -> 0x0028 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x002a
            r5.mostRecentTrimFailed = r0     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            r6 = move-exception
            goto L_0x002c
        L_0x002a:
            monitor-exit(r5)
            return r6
        L_0x002c:
            monitor-exit(r5)     // Catch:{ all -> 0x0028 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.remove(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean removeEntry(Entry entry) throws IOException {
        Editor editor = entry.currentEditor;
        if (editor != null) {
            editor.detach();
        }
        for (int i5 = 0; i5 < this.valueCount; i5++) {
            this.fileSystem.delete(entry.cleanFiles[i5]);
            long j5 = this.size;
            long[] jArr = entry.lengths;
            this.size = j5 - jArr[i5];
            jArr[i5] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.writeUtf8(REMOVE).writeByte(32).writeUtf8(entry.key).writeByte(10);
        this.lruEntries.remove(entry.key);
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public synchronized void setMaxSize(long j5) {
        this.maxSize = j5;
        if (this.initialized) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new Iterator<Snapshot>() {
            final Iterator<Entry> delegate;
            Snapshot nextSnapshot;
            Snapshot removeSnapshot;

            {
                this.delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
            }

            public boolean hasNext() {
                if (this.nextSnapshot != null) {
                    return true;
                }
                synchronized (DiskLruCache.this) {
                    try {
                        if (DiskLruCache.this.closed) {
                            return false;
                        }
                        while (this.delegate.hasNext()) {
                            Entry next = this.delegate.next();
                            if (next.readable) {
                                Snapshot snapshot = next.snapshot();
                                if (snapshot != null) {
                                    this.nextSnapshot = snapshot;
                                    return true;
                                }
                            }
                        }
                        return false;
                    } finally {
                    }
                }
            }

            public void remove() {
                Snapshot snapshot = this.removeSnapshot;
                if (snapshot != null) {
                    try {
                        DiskLruCache.this.remove(snapshot.key);
                    } catch (IOException unused) {
                    } finally {
                        this.removeSnapshot = null;
                    }
                } else {
                    throw new IllegalStateException("remove() before next()");
                }
            }

            public Snapshot next() {
                if (hasNext()) {
                    Snapshot snapshot = this.nextSnapshot;
                    this.removeSnapshot = snapshot;
                    this.nextSnapshot = null;
                    return snapshot;
                }
                throw new NoSuchElementException();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            removeEntry(this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.Editor edit(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.initialize()     // Catch:{ all -> 0x0022 }
            r5.checkNotClosed()     // Catch:{ all -> 0x0022 }
            r5.validateKey(r6)     // Catch:{ all -> 0x0022 }
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry> r0 = r5.lruEntries     // Catch:{ all -> 0x0022 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry r0 = (com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0022 }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0026
            if (r0 == 0) goto L_0x0024
            long r3 = r0.sequenceNumber     // Catch:{ all -> 0x0022 }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0026
            goto L_0x0024
        L_0x0022:
            r6 = move-exception
            goto L_0x0077
        L_0x0024:
            monitor-exit(r5)
            return r2
        L_0x0026:
            if (r0 == 0) goto L_0x002e
            com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Editor r7 = r0.currentEditor     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x002e
            monitor-exit(r5)
            return r2
        L_0x002e:
            boolean r7 = r5.mostRecentTrimFailed     // Catch:{ all -> 0x0022 }
            if (r7 != 0) goto L_0x006e
            boolean r7 = r5.mostRecentRebuildFailed     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0037
            goto L_0x006e
        L_0x0037:
            com.mbridge.msdk.thrid.okio.BufferedSink r7 = r5.journalWriter     // Catch:{ all -> 0x0022 }
            java.lang.String r8 = "DIRTY"
            com.mbridge.msdk.thrid.okio.BufferedSink r7 = r7.writeUtf8(r8)     // Catch:{ all -> 0x0022 }
            r8 = 32
            com.mbridge.msdk.thrid.okio.BufferedSink r7 = r7.writeByte(r8)     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.thrid.okio.BufferedSink r7 = r7.writeUtf8(r6)     // Catch:{ all -> 0x0022 }
            r8 = 10
            r7.writeByte(r8)     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.thrid.okio.BufferedSink r7 = r5.journalWriter     // Catch:{ all -> 0x0022 }
            r7.flush()     // Catch:{ all -> 0x0022 }
            boolean r7 = r5.hasJournalErrors     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0059
            monitor-exit(r5)
            return r2
        L_0x0059:
            if (r0 != 0) goto L_0x0065
            com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry r0 = new com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry     // Catch:{ all -> 0x0022 }
            r0.<init>(r6)     // Catch:{ all -> 0x0022 }
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Entry> r7 = r5.lruEntries     // Catch:{ all -> 0x0022 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0022 }
        L_0x0065:
            com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Editor r6 = new com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Editor     // Catch:{ all -> 0x0022 }
            r6.<init>(r0)     // Catch:{ all -> 0x0022 }
            r0.currentEditor = r6     // Catch:{ all -> 0x0022 }
            monitor-exit(r5)
            return r6
        L_0x006e:
            java.util.concurrent.Executor r6 = r5.executor     // Catch:{ all -> 0x0022 }
            java.lang.Runnable r7 = r5.cleanupRunnable     // Catch:{ all -> 0x0022 }
            r6.execute(r7)     // Catch:{ all -> 0x0022 }
            monitor-exit(r5)
            return r2
        L_0x0077:
            monitor-exit(r5)     // Catch:{ all -> 0x0022 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache.edit(java.lang.String, long):com.mbridge.msdk.thrid.okhttp.internal.cache.DiskLruCache$Editor");
    }
}

package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class MultiDexExtractor implements Closeable {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_CRC = "dex.crc.";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_DEX_TIME = "dex.time.";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final String LOCK_FILENAME = "MultiDex.lock";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private final FileLock cacheLock;
    private final File dexDir;
    private final FileChannel lockChannel;
    private final RandomAccessFile lockRaf;
    private final File sourceApk;
    private final long sourceCrc;

    private static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    MultiDexExtractor(File file, File file2) throws IOException {
        Log.i(TAG, "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.sourceApk = file;
        this.dexDir = file2;
        this.sourceCrc = getZipCrc(file);
        File file3 = new File(file2, LOCK_FILENAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.lockRaf = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.lockChannel = channel;
            try {
                Log.i(TAG, "Blocking on lock " + file3.getPath());
                this.cacheLock = channel.lock();
                Log.i(TAG, file3.getPath() + " locked");
            } catch (IOException e5) {
                e = e5;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (RuntimeException e6) {
                e = e6;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (Error e7) {
                e = e7;
                closeQuietly(this.lockChannel);
                throw e;
            }
        } catch (IOException e8) {
            e = e8;
            closeQuietly(this.lockRaf);
            throw e;
        } catch (RuntimeException e9) {
            e = e9;
            closeQuietly(this.lockRaf);
            throw e;
        } catch (Error e10) {
            e = e10;
            closeQuietly(this.lockRaf);
            throw e;
        }
    }

    private void clearDexDir() {
        File[] listFiles = this.dexDir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().equals(MultiDexExtractor.LOCK_FILENAME);
            }
        });
        if (listFiles == null) {
            Log.w(TAG, "Failed to list secondary dex dir content (" + this.dexDir.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i(TAG, "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (!file.delete()) {
                Log.w(TAG, "Failed to delete old file " + file.getPath());
            } else {
                Log.i(TAG, "Deleted old file " + file.getPath());
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e5) {
            Log.w(TAG, "Failed to close resource", e5);
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, EXTRACTED_SUFFIX, file.getParentFile());
        Log.i(TAG, "Extracting " + createTempFile.getPath());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i(TAG, "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    closeQuietly(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            closeQuietly(inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, 4);
    }

    private static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        if (lastModified == -1) {
            return lastModified - 1;
        }
        return lastModified;
    }

    private static long getZipCrc(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        if (zipCrc == -1) {
            return zipCrc - 1;
        }
        return zipCrc;
    }

    private static boolean isModified(Context context, File file, long j5, String str) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        if (multiDexPreferences.getLong(str + "timestamp", -1) != getTimeStamp(file)) {
            return true;
        }
        if (multiDexPreferences.getLong(str + KEY_CRC, -1) != j5) {
            return true;
        }
        return false;
    }

    private List<ExtractedDex> loadExistingExtractions(Context context, String str) throws IOException {
        String str2 = str;
        Log.i(TAG, "loading existing secondary dex files");
        String str3 = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        int i5 = multiDexPreferences.getInt(str2 + KEY_DEX_NUMBER, 1);
        ArrayList arrayList = new ArrayList(i5 + -1);
        int i6 = 2;
        while (i6 <= i5) {
            ExtractedDex extractedDex = new ExtractedDex(this.dexDir, str3 + i6 + EXTRACTED_SUFFIX);
            if (extractedDex.isFile()) {
                extractedDex.crc = getZipCrc(extractedDex);
                long j5 = multiDexPreferences.getLong(str2 + KEY_DEX_CRC + i6, -1);
                long j6 = multiDexPreferences.getLong(str2 + KEY_DEX_TIME + i6, -1);
                long lastModified = extractedDex.lastModified();
                if (j6 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = multiDexPreferences;
                    if (j5 == extractedDex.crc) {
                        arrayList.add(extractedDex);
                        i6++;
                        multiDexPreferences = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str2 + "\"), expected modification time: " + j6 + ", modification time: " + lastModified + ", expected crc: " + j5 + ", file crc: " + extractedDex.crc);
            }
            throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
        }
        return arrayList;
    }

    private List<ExtractedDex> performExtractions() throws IOException {
        ExtractedDex extractedDex;
        boolean z4;
        String str;
        String str2 = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        clearDexDir();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.sourceApk);
        try {
            int i5 = 2;
            ZipEntry entry = zipFile.getEntry(DEX_PREFIX + 2 + DEX_SUFFIX);
            while (entry != null) {
                extractedDex = new ExtractedDex(this.dexDir, str2 + i5 + EXTRACTED_SUFFIX);
                arrayList.add(extractedDex);
                Log.i(TAG, "Extraction is needed for file " + extractedDex);
                int i6 = 0;
                boolean z5 = false;
                while (i6 < 3 && !z5) {
                    int i7 = i6 + 1;
                    extract(zipFile, entry, extractedDex, str2);
                    extractedDex.crc = getZipCrc(extractedDex);
                    z4 = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    if (z4) {
                        str = "succeeded";
                    } else {
                        str = "failed";
                    }
                    sb.append(str);
                    sb.append(" '");
                    sb.append(extractedDex.getAbsolutePath());
                    sb.append("': length ");
                    int i8 = i7;
                    sb.append(extractedDex.length());
                    sb.append(" - crc: ");
                    sb.append(extractedDex.crc);
                    Log.i(TAG, sb.toString());
                    if (!z4) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            Log.w(TAG, "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                        }
                    }
                    z5 = z4;
                    i6 = i8;
                }
                if (z5) {
                    i5++;
                    entry = zipFile.getEntry(DEX_PREFIX + i5 + DEX_SUFFIX);
                } else {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i5 + ")");
                }
            }
            try {
                zipFile.close();
            } catch (IOException e5) {
                Log.w(TAG, "Failed to close resource", e5);
            }
            return arrayList;
        } catch (IOException e6) {
            Log.w(TAG, "Failed to read crc from " + extractedDex.getAbsolutePath(), e6);
            z4 = false;
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                zipFile.close();
            } catch (IOException e7) {
                Log.w(TAG, "Failed to close resource", e7);
            }
            throw th2;
        }
    }

    private static void putStoredApkInfo(Context context, String str, long j5, long j6, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong(str + "timestamp", j5);
        edit.putLong(str + KEY_CRC, j6);
        edit.putInt(str + KEY_DEX_NUMBER, list.size() + 1);
        int i5 = 2;
        for (ExtractedDex next : list) {
            edit.putLong(str + KEY_DEX_CRC + i5, next.crc);
            edit.putLong(str + KEY_DEX_TIME + i5, next.lastModified());
            i5++;
        }
        edit.commit();
    }

    public void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    /* access modifiers changed from: package-private */
    public List<? extends File> load(Context context, String str, boolean z4) throws IOException {
        List<ExtractedDex> list;
        List<ExtractedDex> performExtractions;
        Log.i(TAG, "MultiDexExtractor.load(" + this.sourceApk.getPath() + ", " + z4 + ", " + str + ")");
        if (this.cacheLock.isValid()) {
            if (z4 || isModified(context, this.sourceApk, this.sourceCrc, str)) {
                if (z4) {
                    Log.i(TAG, "Forced extraction must be performed.");
                } else {
                    Log.i(TAG, "Detected that extraction must be performed.");
                }
                performExtractions = performExtractions();
                putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, performExtractions);
            } else {
                try {
                    list = loadExistingExtractions(context, str);
                } catch (IOException e5) {
                    Log.w(TAG, "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e5);
                    performExtractions = performExtractions();
                    putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, performExtractions);
                }
                Log.i(TAG, "load found " + list.size() + " secondary dex files");
                return list;
            }
            list = performExtractions;
            Log.i(TAG, "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
}

package androidx.room.support;

import W2.J;
import android.content.Context;
import android.util.Log;
import androidx.room.DatabaseConfiguration;
import androidx.room.DelegatingOpenHelper;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.util.ProcessLock;
import h3.C2453b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class PrePackagedCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final Context context;
    private final String copyFromAssetPath;
    private final File copyFromFile;
    private final Callable<InputStream> copyFromInputStream;
    private DatabaseConfiguration databaseConfiguration;
    private final int databaseVersion;
    private final SupportSQLiteOpenHelper delegate;
    private boolean verified;

    public PrePackagedCopyOpenHelper(Context context2, String str, File file, Callable<InputStream> callable, int i5, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        t.e(context2, "context");
        t.e(supportSQLiteOpenHelper, "delegate");
        this.context = context2;
        this.copyFromAssetPath = str;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.databaseVersion = i5;
        this.delegate = supportSQLiteOpenHelper;
    }

    private final void copyDatabaseFile(File file, boolean z4) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.copyFromAssetPath != null) {
            readableByteChannel = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
        } else if (this.copyFromFile != null) {
            readableByteChannel = new FileInputStream(this.copyFromFile).getChannel();
        } else {
            Callable<InputStream> callable = this.copyFromInputStream;
            if (callable != null) {
                try {
                    readableByteChannel = Channels.newChannel(callable.call());
                } catch (Exception e5) {
                    throw new IOException("inputStreamCallable exception on call", e5);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.context.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        t.b(channel);
        FileUtil.copy(readableByteChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            t.b(createTempFile);
            dispatchOnOpenPrepackagedDatabase(createTempFile, z4);
            if (!createTempFile.renameTo(file)) {
                throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
            }
            return;
        }
        throw new IOException("Failed to create directories for " + file.getAbsolutePath());
    }

    private final SupportSQLiteOpenHelper createFrameworkOpenHelper(File file) {
        try {
            int readVersion = DBUtil.readVersion(file);
            return new FrameworkSQLiteOpenHelperFactory().create(SupportSQLiteOpenHelper.Configuration.Companion.builder(this.context).name(file.getAbsolutePath()).callback(new PrePackagedCopyOpenHelper$createFrameworkOpenHelper$configuration$1(readVersion, C2729e.c(readVersion, 1))).build());
        } catch (IOException e5) {
            throw new RuntimeException("Malformed database file, unable to read version.", e5);
        }
    }

    private final void dispatchOnOpenPrepackagedDatabase(File file, boolean z4) {
        SupportSQLiteDatabase supportSQLiteDatabase;
        DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
        if (databaseConfiguration2 == null) {
            t.w("databaseConfiguration");
            databaseConfiguration2 = null;
        }
        if (databaseConfiguration2.prepackagedDatabaseCallback != null) {
            SupportSQLiteOpenHelper createFrameworkOpenHelper = createFrameworkOpenHelper(file);
            if (z4) {
                try {
                    supportSQLiteDatabase = createFrameworkOpenHelper.getWritableDatabase();
                } catch (Throwable th) {
                    C2453b.a(createFrameworkOpenHelper, th);
                    throw th;
                }
            } else {
                supportSQLiteDatabase = createFrameworkOpenHelper.getReadableDatabase();
            }
            DatabaseConfiguration databaseConfiguration3 = this.databaseConfiguration;
            if (databaseConfiguration3 == null) {
                t.w("databaseConfiguration");
                databaseConfiguration3 = null;
            }
            RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback = databaseConfiguration3.prepackagedDatabaseCallback;
            t.b(prepackagedDatabaseCallback);
            prepackagedDatabaseCallback.onOpenPrepackagedDatabase(supportSQLiteDatabase);
            J j5 = J.f19942a;
            C2453b.a(createFrameworkOpenHelper, (Throwable) null);
        }
    }

    private final void verifyDatabaseFile(boolean z4) {
        String databaseName = getDatabaseName();
        if (databaseName != null) {
            File databasePath = this.context.getDatabasePath(databaseName);
            DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
            DatabaseConfiguration databaseConfiguration3 = null;
            if (databaseConfiguration2 == null) {
                t.w("databaseConfiguration");
                databaseConfiguration2 = null;
            }
            ProcessLock processLock = new ProcessLock(databaseName, this.context.getFilesDir(), databaseConfiguration2.multiInstanceInvalidation);
            try {
                ProcessLock.lock$default(processLock, false, 1, (Object) null);
                if (!databasePath.exists()) {
                    t.b(databasePath);
                    copyDatabaseFile(databasePath, z4);
                    processLock.unlock();
                    return;
                }
                try {
                    t.b(databasePath);
                    int readVersion = DBUtil.readVersion(databasePath);
                    if (readVersion == this.databaseVersion) {
                        processLock.unlock();
                        return;
                    }
                    DatabaseConfiguration databaseConfiguration4 = this.databaseConfiguration;
                    if (databaseConfiguration4 == null) {
                        t.w("databaseConfiguration");
                    } else {
                        databaseConfiguration3 = databaseConfiguration4;
                    }
                    if (databaseConfiguration3.isMigrationRequired(readVersion, this.databaseVersion)) {
                        processLock.unlock();
                        return;
                    }
                    if (this.context.deleteDatabase(databaseName)) {
                        try {
                            copyDatabaseFile(databasePath, z4);
                            J j5 = J.f19942a;
                        } catch (IOException e5) {
                            Log.w(Room.LOG_TAG, "Unable to copy database file.", e5);
                        }
                    } else {
                        Log.w(Room.LOG_TAG, "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                    }
                    processLock.unlock();
                } catch (IOException e6) {
                    Log.w(Room.LOG_TAG, "Unable to read database version.", e6);
                    processLock.unlock();
                }
            } catch (IOException e7) {
                throw new RuntimeException("Unable to copy database file.", e7);
            } catch (Throwable th) {
                processLock.unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("Required value was null.");
        }
    }

    public synchronized void close() {
        getDelegate().close();
        this.verified = false;
    }

    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(false);
            this.verified = true;
        }
        return getDelegate().getReadableDatabase();
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(true);
            this.verified = true;
        }
        return getDelegate().getWritableDatabase();
    }

    public final void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration2) {
        t.e(databaseConfiguration2, "databaseConfiguration");
        this.databaseConfiguration = databaseConfiguration2;
    }

    public void setWriteAheadLoggingEnabled(boolean z4) {
        getDelegate().setWriteAheadLoggingEnabled(z4);
    }
}

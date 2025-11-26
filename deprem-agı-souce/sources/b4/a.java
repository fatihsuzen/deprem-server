package b4;

import e4.L;
import e4.X;
import e4.Z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20795a = new C0210a();

    /* renamed from: b4.a$a  reason: collision with other inner class name */
    class C0210a implements a {
        C0210a() {
        }

        public X appendingSink(File file) {
            try {
                return L.a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return L.a(file);
            }
        }

        public void delete(File file) {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        public void deleteContents(File file) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i5 = 0;
                while (i5 < length) {
                    File file2 = listFiles[i5];
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (file2.delete()) {
                        i5++;
                    } else {
                        throw new IOException("failed to delete " + file2);
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: " + file);
        }

        public boolean exists(File file) {
            return file.exists();
        }

        public void rename(File file, File file2) {
            delete(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        public X sink(File file) {
            try {
                return L.f(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return L.f(file);
            }
        }

        public long size(File file) {
            return file.length();
        }

        public Z source(File file) {
            return L.k(file);
        }
    }

    X appendingSink(File file);

    void delete(File file);

    void deleteContents(File file);

    boolean exists(File file);

    void rename(File file, File file2);

    X sink(File file);

    long size(File file);

    Z source(File file);
}

package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class m extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f13325a;

    /* renamed from: b  reason: collision with root package name */
    private long f13326b;

    /* renamed from: c  reason: collision with root package name */
    private long f13327c;

    /* renamed from: d  reason: collision with root package name */
    private long f13328d;

    /* renamed from: e  reason: collision with root package name */
    private long f13329e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13330f;

    /* renamed from: g  reason: collision with root package name */
    private int f13331g;

    m(InputStream inputStream) {
        this(inputStream, 4096);
    }

    private void m(long j5) {
        try {
            long j6 = this.f13327c;
            long j7 = this.f13326b;
            if (j6 >= j7 || j7 > this.f13328d) {
                this.f13327c = j7;
                this.f13325a.mark((int) (j5 - j7));
            } else {
                this.f13325a.reset();
                this.f13325a.mark((int) (j5 - this.f13327c));
                n(this.f13327c, this.f13326b);
            }
            this.f13328d = j5;
        } catch (IOException e5) {
            throw new IllegalStateException("Unable to mark: " + e5);
        }
    }

    private void n(long j5, long j6) {
        while (j5 < j6) {
            long skip = this.f13325a.skip(j6 - j5);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j5 += skip;
        }
    }

    public void a(boolean z4) {
        this.f13330f = z4;
    }

    public int available() {
        return this.f13325a.available();
    }

    public void close() {
        this.f13325a.close();
    }

    public void d(long j5) {
        if (this.f13326b > this.f13328d || j5 < this.f13327c) {
            throw new IOException("Cannot reset");
        }
        this.f13325a.reset();
        n(this.f13327c, j5);
        this.f13326b = j5;
    }

    public long l(int i5) {
        long j5 = this.f13326b + ((long) i5);
        if (this.f13328d < j5) {
            m(j5);
        }
        return this.f13326b;
    }

    public void mark(int i5) {
        this.f13329e = l(i5);
    }

    public boolean markSupported() {
        return this.f13325a.markSupported();
    }

    public int read() {
        if (!this.f13330f) {
            long j5 = this.f13328d;
            if (this.f13326b + 1 > j5) {
                m(j5 + ((long) this.f13331g));
            }
        }
        int read = this.f13325a.read();
        if (read != -1) {
            this.f13326b++;
        }
        return read;
    }

    public void reset() {
        d(this.f13329e);
    }

    public long skip(long j5) {
        if (!this.f13330f) {
            long j6 = this.f13326b;
            if (j6 + j5 > this.f13328d) {
                m(j6 + j5 + ((long) this.f13331g));
            }
        }
        long skip = this.f13325a.skip(j5);
        this.f13326b += skip;
        return skip;
    }

    m(InputStream inputStream, int i5) {
        this(inputStream, i5, 1024);
    }

    private m(InputStream inputStream, int i5, int i6) {
        this.f13329e = -1;
        this.f13330f = true;
        this.f13331g = -1;
        this.f13325a = !inputStream.markSupported() ? new BufferedInputStream(inputStream, i5) : inputStream;
        this.f13331g = i6;
    }

    public int read(byte[] bArr) {
        if (!this.f13330f) {
            long j5 = this.f13326b;
            if (((long) bArr.length) + j5 > this.f13328d) {
                m(j5 + ((long) bArr.length) + ((long) this.f13331g));
            }
        }
        int read = this.f13325a.read(bArr);
        if (read != -1) {
            this.f13326b += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i5, int i6) {
        if (!this.f13330f) {
            long j5 = this.f13326b;
            long j6 = (long) i6;
            if (j5 + j6 > this.f13328d) {
                m(j5 + j6 + ((long) this.f13331g));
            }
        }
        int read = this.f13325a.read(bArr, i5, i6);
        if (read != -1) {
            this.f13326b += (long) read;
        }
        return read;
    }
}

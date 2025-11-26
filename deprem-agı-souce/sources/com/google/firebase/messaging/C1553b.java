package com.google.firebase.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* renamed from: com.google.firebase.messaging.b  reason: case insensitive filesystem */
abstract class C1553b {
    private static byte[] a(Queue queue, int i5) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        if (bArr.length == i5) {
            return bArr;
        }
        int length = i5 - bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, i5);
        while (length > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int min = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, copyOf, i5 - length, min);
            length -= min;
        }
        return copyOf;
    }

    public static InputStream b(InputStream inputStream, long j5) {
        return new a(inputStream, j5);
    }

    private static int c(long j5) {
        if (j5 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j5 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j5;
    }

    public static byte[] d(InputStream inputStream) {
        return e(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] e(InputStream inputStream, Queue queue, int i5) {
        int i6;
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i5) * 2));
        while (i5 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i5);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i7 = 0;
            while (i7 < min2) {
                int read = inputStream.read(bArr, i7, min2 - i7);
                if (read == -1) {
                    return a(queue, i5);
                }
                i7 += read;
                i5 += read;
            }
            long j5 = (long) min;
            if (min < 4096) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            min = c(j5 * ((long) i6));
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    /* renamed from: com.google.firebase.messaging.b$a */
    private static final class a extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private long f7384a;

        /* renamed from: b  reason: collision with root package name */
        private long f7385b = -1;

        a(InputStream inputStream, long j5) {
            super(inputStream);
            this.f7384a = j5;
        }

        public int available() {
            return (int) Math.min((long) this.in.available(), this.f7384a);
        }

        public synchronized void mark(int i5) {
            this.in.mark(i5);
            this.f7385b = this.f7384a;
        }

        public int read() {
            if (this.f7384a == 0) {
                return -1;
            }
            int read = this.in.read();
            if (read != -1) {
                this.f7384a--;
            }
            return read;
        }

        public synchronized void reset() {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.f7385b != -1) {
                this.in.reset();
                this.f7384a = this.f7385b;
            } else {
                throw new IOException("Mark not set");
            }
        }

        public long skip(long j5) {
            long skip = this.in.skip(Math.min(j5, this.f7384a));
            this.f7384a -= skip;
            return skip;
        }

        public int read(byte[] bArr, int i5, int i6) {
            long j5 = this.f7384a;
            if (j5 == 0) {
                return -1;
            }
            int read = this.in.read(bArr, i5, (int) Math.min((long) i6, j5));
            if (read != -1) {
                this.f7384a -= (long) read;
            }
            return read;
        }
    }
}

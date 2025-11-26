package j$.util.concurrent;

import j$.util.stream.C;
import j$.util.stream.C0483a;
import j$.util.stream.C0544m0;
import j$.util.stream.IntStream;
import j$.util.stream.Z2;
import j$.util.w0;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ThreadLocalRandom extends Random {

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal f1304d = new ThreadLocal();

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicInteger f1305e = new AtomicInteger();

    /* renamed from: f  reason: collision with root package name */
    public static final v f1306f = new ThreadLocal();

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicLong f1307g = new AtomicLong(f(System.currentTimeMillis()) ^ f(System.nanoTime()));
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("rnd", Long.TYPE), new ObjectStreamField("initialized", Boolean.TYPE)};
    private static final long serialVersionUID = -5851777807851030925L;

    /* renamed from: a  reason: collision with root package name */
    public long f1308a;

    /* renamed from: b  reason: collision with root package name */
    public int f1309b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1310c;

    public /* synthetic */ ThreadLocalRandom(int i5) {
        this();
    }

    public static int e(long j5) {
        long j6 = (j5 ^ (j5 >>> 33)) * -49064778989728563L;
        return (int) (((j6 ^ (j6 >>> 33)) * -4265267296055464877L) >>> 32);
    }

    public static long f(long j5) {
        long j6 = (j5 ^ (j5 >>> 33)) * -49064778989728563L;
        long j7 = (j6 ^ (j6 >>> 33)) * -4265267296055464877L;
        return j7 ^ (j7 >>> 33);
    }

    private ThreadLocalRandom() {
        this.f1310c = true;
    }

    public static final void d() {
        int addAndGet = f1305e.addAndGet(-1640531527);
        if (addAndGet == 0) {
            addAndGet = 1;
        }
        long f5 = f(f1307g.getAndAdd(-4942790177534073029L));
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f1306f.get();
        threadLocalRandom.f1308a = f5;
        threadLocalRandom.f1309b = addAndGet;
    }

    public static ThreadLocalRandom current() {
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f1306f.get();
        if (threadLocalRandom.f1309b == 0) {
            d();
        }
        return threadLocalRandom;
    }

    public final void setSeed(long j5) {
        if (this.f1310c) {
            throw new UnsupportedOperationException();
        }
    }

    public final long g() {
        long j5 = this.f1308a - 7046029254386353131L;
        this.f1308a = j5;
        return j5;
    }

    public final int next(int i5) {
        return nextInt() >>> (32 - i5);
    }

    public final long c(long j5, long j6) {
        long f5 = f(g());
        if (j5 >= j6) {
            return f5;
        }
        long j7 = j6 - j5;
        long j8 = j7 - 1;
        if ((j7 & j8) == 0) {
            return (f5 & j8) + j5;
        }
        if (j7 > 0) {
            while (true) {
                long j9 = f5 >>> 1;
                long j10 = j9 + j8;
                long j11 = j9 % j7;
                if (j10 - j11 >= 0) {
                    return j11 + j5;
                }
                f5 = f(g());
            }
        } else {
            while (true) {
                if (f5 >= j5 && f5 < j6) {
                    return f5;
                }
                f5 = f(g());
            }
        }
    }

    public final int b(int i5, int i6) {
        int e5 = e(g());
        if (i5 >= i6) {
            return e5;
        }
        int i7 = i6 - i5;
        int i8 = i7 - 1;
        if ((i7 & i8) == 0) {
            return (e5 & i8) + i5;
        }
        if (i7 > 0) {
            int i9 = e5 >>> 1;
            while (true) {
                int i10 = i9 + i8;
                int i11 = i9 % i7;
                if (i10 - i11 >= 0) {
                    return i11 + i5;
                }
                i9 = e(g()) >>> 1;
            }
        } else {
            while (true) {
                if (e5 >= i5 && e5 < i6) {
                    return e5;
                }
                e5 = e(g());
            }
        }
    }

    public final double a(double d5, double d6) {
        double nextLong = ((double) (nextLong() >>> 11)) * 1.1102230246251565E-16d;
        if (d5 >= d6) {
            return nextLong;
        }
        double d7 = ((d6 - d5) * nextLong) + d5;
        return d7 >= d6 ? Double.longBitsToDouble(Double.doubleToLongBits(d6) - 1) : d7;
    }

    public final int nextInt() {
        return e(g());
    }

    public final int nextInt(int i5) {
        if (i5 > 0) {
            int e5 = e(g());
            int i6 = i5 - 1;
            if ((i5 & i6) == 0) {
                return e5 & i6;
            }
            while (true) {
                int i7 = e5 >>> 1;
                int i8 = i7 + i6;
                int i9 = i7 % i5;
                if (i8 - i9 >= 0) {
                    return i9;
                }
                e5 = e(g());
            }
        } else {
            throw new IllegalArgumentException("bound must be positive");
        }
    }

    public final int nextInt(int i5, int i6) {
        if (i5 < i6) {
            return b(i5, i6);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public final long nextLong() {
        return f(g());
    }

    public final long nextLong(long j5) {
        if (j5 > 0) {
            long f5 = f(g());
            long j6 = j5 - 1;
            if ((j5 & j6) == 0) {
                return f5 & j6;
            }
            while (true) {
                long j7 = f5 >>> 1;
                long j8 = j7 + j6;
                long j9 = j7 % j5;
                if (j8 - j9 >= 0) {
                    return j9;
                }
                f5 = f(g());
            }
        } else {
            throw new IllegalArgumentException("bound must be positive");
        }
    }

    public final long nextLong(long j5, long j6) {
        if (j5 < j6) {
            return c(j5, j6);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public final double nextDouble() {
        return ((double) (f(g()) >>> 11)) * 1.1102230246251565E-16d;
    }

    public final double nextDouble(double d5) {
        if (d5 > 0.0d) {
            double f5 = ((double) (f(g()) >>> 11)) * 1.1102230246251565E-16d * d5;
            if (f5 < d5) {
                return f5;
            }
            return Double.longBitsToDouble(Double.doubleToLongBits(d5) - 1);
        }
        throw new IllegalArgumentException("bound must be positive");
    }

    public final double nextDouble(double d5, double d6) {
        if (d5 < d6) {
            return a(d5, d6);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    public final boolean nextBoolean() {
        return e(g()) < 0;
    }

    public final float nextFloat() {
        return ((float) (e(g()) >>> 8)) * 5.9604645E-8f;
    }

    public final double nextGaussian() {
        ThreadLocal threadLocal = f1304d;
        Double d5 = (Double) threadLocal.get();
        if (d5 != null) {
            threadLocal.set((Object) null);
            return d5.doubleValue();
        }
        while (true) {
            double nextDouble = (nextDouble() * 2.0d) - 1.0d;
            double nextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d6 = (nextDouble2 * nextDouble2) + (nextDouble * nextDouble);
            if (d6 < 1.0d && d6 != 0.0d) {
                double sqrt = StrictMath.sqrt((StrictMath.log(d6) * -2.0d) / d6);
                f1304d.set(Double.valueOf(nextDouble2 * sqrt));
                return nextDouble * sqrt;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r9v2, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    public final IntStream ints(long j5) {
        if (j5 >= 0) {
            x xVar = new x(0, j5, Integer.MAX_VALUE, 0);
            return IntStream.Wrapper.convert(new C0483a(xVar, Z2.g(xVar), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    public final java.util.stream.IntStream ints() {
        x xVar = new x(0, Long.MAX_VALUE, Integer.MAX_VALUE, 0);
        return IntStream.Wrapper.convert(new C0483a(xVar, Z2.g(xVar), false));
    }

    /* JADX WARNING: type inference failed for: r9v3, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    public final java.util.stream.IntStream ints(long j5, int i5, int i6) {
        if (j5 < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (i5 < i6) {
            x xVar = new x(0, j5, i5, i6);
            return IntStream.Wrapper.convert(new C0483a(xVar, Z2.g(xVar), false));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    /* JADX WARNING: type inference failed for: r8v2, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    public final java.util.stream.IntStream ints(int i5, int i6) {
        if (i5 < i6) {
            x xVar = new x(0, Long.MAX_VALUE, i5, i6);
            return IntStream.Wrapper.convert(new C0483a(xVar, Z2.g(xVar), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    /* JADX WARNING: type inference failed for: r11v2, types: [j$.util.stream.n0, j$.util.stream.a] */
    public final LongStream longs(long j5) {
        if (j5 >= 0) {
            y yVar = new y(0, j5, Long.MAX_VALUE, 0);
            return C0544m0.f(new C0483a(yVar, Z2.g(yVar), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [j$.util.stream.n0, j$.util.stream.a] */
    public final LongStream longs() {
        y yVar = new y(0, Long.MAX_VALUE, Long.MAX_VALUE, 0);
        return C0544m0.f(new C0483a(yVar, Z2.g(yVar), false));
    }

    /* JADX WARNING: type inference failed for: r11v3, types: [j$.util.stream.n0, j$.util.stream.a] */
    public final LongStream longs(long j5, long j6, long j7) {
        if (j5 < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (j6 < j7) {
            y yVar = new y(0, j5, j6, j7);
            return C0544m0.f(new C0483a(yVar, Z2.g(yVar), false));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    /* JADX WARNING: type inference failed for: r11v2, types: [j$.util.stream.n0, j$.util.stream.a] */
    public final LongStream longs(long j5, long j6) {
        if (j5 < j6) {
            y yVar = new y(0, Long.MAX_VALUE, j5, j6);
            return C0544m0.f(new C0483a(yVar, Z2.g(yVar), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    /* JADX WARNING: type inference failed for: r11v2, types: [j$.util.stream.a, j$.util.stream.D] */
    public final DoubleStream doubles(long j5) {
        if (j5 >= 0) {
            w wVar = new w(0, j5, Double.MAX_VALUE, 0.0d);
            return C.f(new C0483a(wVar, Z2.g(wVar), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [j$.util.stream.a, j$.util.stream.D] */
    public final DoubleStream doubles() {
        w wVar = new w(0, Long.MAX_VALUE, Double.MAX_VALUE, 0.0d);
        return C.f(new C0483a(wVar, Z2.g(wVar), false));
    }

    /* JADX WARNING: type inference failed for: r11v3, types: [j$.util.stream.a, j$.util.stream.D] */
    public final DoubleStream doubles(long j5, double d5, double d6) {
        if (j5 < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (d5 < d6) {
            w wVar = new w(0, j5, d5, d6);
            return C.f(new C0483a(wVar, Z2.g(wVar), false));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    /* JADX WARNING: type inference failed for: r11v2, types: [j$.util.stream.a, j$.util.stream.D] */
    public final DoubleStream doubles(double d5, double d6) {
        if (d5 < d6) {
            w wVar = new w(0, Long.MAX_VALUE, d5, d6);
            return C.f(new C0483a(wVar, Z2.g(wVar), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [java.lang.ThreadLocal, j$.util.concurrent.v] */
    static {
        if (((Boolean) AccessController.doPrivileged(new w0(1))).booleanValue()) {
            byte[] seed = SecureRandom.getSeed(8);
            long j5 = ((long) seed[0]) & 255;
            for (int i5 = 1; i5 < 8; i5++) {
                j5 = (j5 << 8) | (((long) seed[i5]) & 255);
            }
            f1307g.set(j5);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("rnd", this.f1308a);
        putFields.put("initialized", true);
        objectOutputStream.writeFields();
    }

    private Object readResolve() {
        return current();
    }
}

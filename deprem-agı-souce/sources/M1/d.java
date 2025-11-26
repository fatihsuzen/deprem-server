package M1;

import java.io.PrintWriter;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f2964a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2965b;

    /* renamed from: c  reason: collision with root package name */
    public final long f2966c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2967d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2968e;

    /* renamed from: f  reason: collision with root package name */
    public final long f2969f;

    /* renamed from: g  reason: collision with root package name */
    public final long f2970g;

    /* renamed from: h  reason: collision with root package name */
    public final long f2971h;

    /* renamed from: i  reason: collision with root package name */
    public final long f2972i;

    /* renamed from: j  reason: collision with root package name */
    public final long f2973j;

    /* renamed from: k  reason: collision with root package name */
    public final int f2974k;

    /* renamed from: l  reason: collision with root package name */
    public final int f2975l;

    /* renamed from: m  reason: collision with root package name */
    public final int f2976m;

    /* renamed from: n  reason: collision with root package name */
    public final long f2977n;

    public d(int i5, int i6, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i7, int i8, int i9, long j13) {
        this.f2964a = i5;
        this.f2965b = i6;
        this.f2966c = j5;
        this.f2967d = j6;
        this.f2968e = j7;
        this.f2969f = j8;
        this.f2970g = j9;
        this.f2971h = j10;
        this.f2972i = j11;
        this.f2973j = j12;
        this.f2974k = i7;
        this.f2975l = i8;
        this.f2976m = i9;
        this.f2977n = j13;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f2964a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f2965b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f2965b) / ((float) this.f2964a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f2966c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f2967d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f2974k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f2968e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f2971h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f2975l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f2969f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f2976m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f2970g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f2972i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f2973j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f2964a + ", size=" + this.f2965b + ", cacheHits=" + this.f2966c + ", cacheMisses=" + this.f2967d + ", downloadCount=" + this.f2974k + ", totalDownloadSize=" + this.f2968e + ", averageDownloadSize=" + this.f2971h + ", totalOriginalBitmapSize=" + this.f2969f + ", totalTransformedBitmapSize=" + this.f2970g + ", averageOriginalBitmapSize=" + this.f2972i + ", averageTransformedBitmapSize=" + this.f2973j + ", originalBitmapCount=" + this.f2975l + ", transformedBitmapCount=" + this.f2976m + ", timeStamp=" + this.f2977n + '}';
    }
}

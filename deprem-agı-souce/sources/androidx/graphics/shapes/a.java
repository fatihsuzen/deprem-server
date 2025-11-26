package androidx.graphics.shapes;

public final /* synthetic */ class a implements FindMinimumFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Cubic f368a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AngleMeasurer f369b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f370c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f371d;

    public /* synthetic */ a(Cubic cubic, AngleMeasurer angleMeasurer, float f5, float f6) {
        this.f368a = cubic;
        this.f369b = angleMeasurer;
        this.f370c = f5;
        this.f371d = f6;
    }

    public final float invoke(float f5) {
        return AngleMeasurer.findCubicCutPoint$lambda$1(this.f368a, this.f369b, this.f370c, this.f371d, f5);
    }
}

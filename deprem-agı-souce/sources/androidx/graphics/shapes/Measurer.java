package androidx.graphics.shapes;

public interface Measurer {
    float findCubicCutPoint(Cubic cubic, float f5);

    float measureCubic(Cubic cubic);
}

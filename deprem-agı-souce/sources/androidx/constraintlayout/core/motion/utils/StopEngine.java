package androidx.constraintlayout.core.motion.utils;

public interface StopEngine {
    String debug(String str, float f5);

    float getInterpolation(float f5);

    float getVelocity();

    float getVelocity(float f5);

    boolean isStopped();
}

package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

public class StopLogic extends MotionInterpolator {
    private StopEngine mEngine;
    private SpringStopEngine mSpringStopEngine;
    private StopLogicEngine mStopLogicEngine;

    public StopLogic() {
        StopLogicEngine stopLogicEngine = new StopLogicEngine();
        this.mStopLogicEngine = stopLogicEngine;
        this.mEngine = stopLogicEngine;
    }

    public void config(float f5, float f6, float f7, float f8, float f9, float f10) {
        StopLogicEngine stopLogicEngine = this.mStopLogicEngine;
        this.mEngine = stopLogicEngine;
        stopLogicEngine.config(f5, f6, f7, f8, f9, f10);
    }

    public String debug(String str, float f5) {
        return this.mEngine.debug(str, f5);
    }

    public float getInterpolation(float f5) {
        return this.mEngine.getInterpolation(f5);
    }

    public float getVelocity(float f5) {
        return this.mEngine.getVelocity(f5);
    }

    public boolean isStopped() {
        return this.mEngine.isStopped();
    }

    public void springConfig(float f5, float f6, float f7, float f8, float f9, float f10, float f11, int i5) {
        if (this.mSpringStopEngine == null) {
            this.mSpringStopEngine = new SpringStopEngine();
        }
        SpringStopEngine springStopEngine = this.mSpringStopEngine;
        this.mEngine = springStopEngine;
        springStopEngine.springConfig(f5, f6, f7, f8, f9, f10, f11, i5);
    }

    public float getVelocity() {
        return this.mEngine.getVelocity();
    }
}

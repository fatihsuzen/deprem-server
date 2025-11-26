package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewOscillator extends KeyCycleOscillator {
    private static final String TAG = "ViewOscillator";

    static class AlphaSet extends ViewOscillator {
        AlphaSet() {
        }

        public void setProperty(View view, float f5) {
            view.setAlpha(get(f5));
        }
    }

    static class CustomSet extends ViewOscillator {
        protected ConstraintAttribute mCustom;
        float[] mValue = new float[1];

        CustomSet() {
        }

        /* access modifiers changed from: protected */
        public void setCustom(Object obj) {
            this.mCustom = (ConstraintAttribute) obj;
        }

        public void setProperty(View view, float f5) {
            this.mValue[0] = get(f5);
            CustomSupport.setInterpolatedValue(this.mCustom, view, this.mValue);
        }
    }

    static class ElevationSet extends ViewOscillator {
        ElevationSet() {
        }

        public void setProperty(View view, float f5) {
            view.setElevation(get(f5));
        }
    }

    public static class PathRotateSet extends ViewOscillator {
        public void setPathRotate(View view, float f5, double d5, double d6) {
            view.setRotation(get(f5) + ((float) Math.toDegrees(Math.atan2(d6, d5))));
        }

        public void setProperty(View view, float f5) {
        }
    }

    static class ProgressSet extends ViewOscillator {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        public void setProperty(View view, float f5) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f5));
            } else if (!this.mNoMethod) {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(get(f5))});
                    } catch (IllegalAccessException e5) {
                        Log.e(ViewOscillator.TAG, "unable to setProgress", e5);
                    } catch (InvocationTargetException e6) {
                        Log.e(ViewOscillator.TAG, "unable to setProgress", e6);
                    }
                }
            }
        }
    }

    static class RotationSet extends ViewOscillator {
        RotationSet() {
        }

        public void setProperty(View view, float f5) {
            view.setRotation(get(f5));
        }
    }

    static class RotationXset extends ViewOscillator {
        RotationXset() {
        }

        public void setProperty(View view, float f5) {
            view.setRotationX(get(f5));
        }
    }

    static class RotationYset extends ViewOscillator {
        RotationYset() {
        }

        public void setProperty(View view, float f5) {
            view.setRotationY(get(f5));
        }
    }

    static class ScaleXset extends ViewOscillator {
        ScaleXset() {
        }

        public void setProperty(View view, float f5) {
            view.setScaleX(get(f5));
        }
    }

    static class ScaleYset extends ViewOscillator {
        ScaleYset() {
        }

        public void setProperty(View view, float f5) {
            view.setScaleY(get(f5));
        }
    }

    static class TranslationXset extends ViewOscillator {
        TranslationXset() {
        }

        public void setProperty(View view, float f5) {
            view.setTranslationX(get(f5));
        }
    }

    static class TranslationYset extends ViewOscillator {
        TranslationYset() {
        }

        public void setProperty(View view, float f5) {
            view.setTranslationY(get(f5));
        }
    }

    static class TranslationZset extends ViewOscillator {
        TranslationZset() {
        }

        public void setProperty(View view, float f5) {
            view.setTranslationZ(get(f5));
        }
    }

    public static ViewOscillator makeSpline(String str) {
        if (str.startsWith("CUSTOM")) {
            return new CustomSet();
        }
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c5 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c5 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c5 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c5 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c5 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c5 = 7;
                    break;
                }
                break;
            case -797520672:
                if (str.equals(Key.WAVE_VARIES_BY)) {
                    c5 = 8;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c5 = 9;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c5 = 10;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c5 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c5 = 12;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c5 = 13;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return new RotationXset();
            case 1:
                return new RotationYset();
            case 2:
                return new TranslationXset();
            case 3:
                return new TranslationYset();
            case 4:
                return new TranslationZset();
            case 5:
                return new ProgressSet();
            case 6:
                return new ScaleXset();
            case 7:
                return new ScaleYset();
            case 8:
                return new AlphaSet();
            case 9:
                return new RotationSet();
            case 10:
                return new ElevationSet();
            case 11:
                return new PathRotateSet();
            case 12:
                return new AlphaSet();
            case 13:
                return new AlphaSet();
            default:
                return null;
        }
    }

    public abstract void setProperty(View view, float f5);
}

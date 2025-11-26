package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import j$.util.Objects;
import java.io.PrintStream;
import java.util.HashMap;

public class DesignTool {
    private static final boolean DEBUG = false;
    private static final boolean DO_NOT_USE = false;
    private static final String TAG = "DesignTool";
    static final HashMap<Pair<Integer, Integer>, String> sAllAttributes;
    static final HashMap<String, String> sAllMargins;
    private String mLastEndState = null;
    private int mLastEndStateId = -1;
    private String mLastStartState = null;
    private int mLastStartStateId = -1;
    private final MotionLayout mMotionLayout;
    private MotionScene mSceneCache;

    static {
        HashMap<Pair<Integer, Integer>, String> hashMap = new HashMap<>();
        sAllAttributes = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        sAllMargins = hashMap2;
        hashMap.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        hashMap.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        hashMap.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        hashMap.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        hashMap.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        hashMap.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        hashMap.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        hashMap.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        hashMap.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        hashMap.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        hashMap.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        hashMap.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        hashMap.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        hashMap2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        hashMap2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        hashMap2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        hashMap2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        hashMap2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        hashMap2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        hashMap2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        hashMap2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        hashMap2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        hashMap2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        hashMap2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        hashMap2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private static void connect(int i5, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i6, int i7) {
        int i8;
        String str = sAllAttributes.get(Pair.create(Integer.valueOf(i6), Integer.valueOf(i7)));
        String str2 = hashMap.get(str);
        if (str2 != null) {
            String str3 = sAllMargins.get(str);
            if (str3 != null) {
                i8 = getPxFromDp(i5, hashMap.get(str3));
            } else {
                i8 = 0;
            }
            int i9 = i8;
            ConstraintSet constraintSet2 = constraintSet;
            constraintSet2.connect(view.getId(), i6, Integer.parseInt(str2), i7, i9);
        }
    }

    private static int getPxFromDp(int i5, String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(100)) == -1) {
            return 0;
        }
        return (int) (((float) (Integer.valueOf(str.substring(0, indexOf)).intValue() * i5)) / 160.0f);
    }

    private static void setAbsolutePositions(int i5, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap) {
        String str = hashMap.get("layout_editor_absoluteX");
        if (str != null) {
            constraintSet.setEditorAbsoluteX(view.getId(), getPxFromDp(i5, str));
        }
        String str2 = hashMap.get("layout_editor_absoluteY");
        if (str2 != null) {
            constraintSet.setEditorAbsoluteY(view.getId(), getPxFromDp(i5, str2));
        }
    }

    private static void setBias(ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i5) {
        String str;
        if (i5 == 1) {
            str = "layout_constraintVertical_bias";
        } else {
            str = "layout_constraintHorizontal_bias";
        }
        String str2 = hashMap.get(str);
        if (str2 == null) {
            return;
        }
        if (i5 == 0) {
            constraintSet.setHorizontalBias(view.getId(), Float.parseFloat(str2));
        } else if (i5 == 1) {
            constraintSet.setVerticalBias(view.getId(), Float.parseFloat(str2));
        }
    }

    private static void setDimensions(int i5, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i6) {
        String str;
        int i7;
        if (i6 == 1) {
            str = "layout_height";
        } else {
            str = "layout_width";
        }
        String str2 = hashMap.get(str);
        if (str2 != null) {
            if (!str2.equalsIgnoreCase("wrap_content")) {
                i7 = getPxFromDp(i5, str2);
            } else {
                i7 = -2;
            }
            if (i6 == 0) {
                constraintSet.constrainWidth(view.getId(), i7);
            } else {
                constraintSet.constrainHeight(view.getId(), i7);
            }
        }
    }

    public int designAccess(int i5, String str, Object obj, float[] fArr, int i6, float[] fArr2, int i7) {
        MotionController motionController;
        View view = (View) obj;
        if (i5 != 0) {
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null || view == null || (motionController = motionLayout.mFrameArrayList.get(view)) == null) {
                return -1;
            }
        } else {
            motionController = null;
        }
        if (i5 == 0) {
            return 1;
        }
        if (i5 == 1) {
            int duration = this.mMotionLayout.mScene.getDuration() / 16;
            motionController.buildPath(fArr2, duration);
            return duration;
        } else if (i5 == 2) {
            int duration2 = this.mMotionLayout.mScene.getDuration() / 16;
            motionController.buildKeyFrames(fArr2, (int[]) null);
            return duration2;
        } else if (i5 != 3) {
            return -1;
        } else {
            this.mMotionLayout.mScene.getDuration();
            return motionController.getAttributeValues(str, fArr2, i7);
        }
    }

    public void disableAutoTransition(boolean z4) {
        this.mMotionLayout.disableAutoTransition(z4);
    }

    public void dumpConstraintSet(String str) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(str);
        PrintStream printStream = System.out;
        printStream.println(" dumping  " + str + " (" + lookUpConstraintId + ")");
        try {
            this.mMotionLayout.mScene.getConstraintSet(lookUpConstraintId).dump(this.mMotionLayout.mScene, new int[0]);
        } catch (Exception e5) {
            Log.e(TAG, "Error while dumping: " + str + " (" + lookUpConstraintId + ")", e5);
        }
    }

    public int getAnimationKeyFrames(Object obj, float[] fArr) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene == null) {
            return -1;
        }
        int duration = motionScene.getDuration() / 16;
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.buildKeyFrames(fArr, (int[]) null);
        return duration;
    }

    public int getAnimationPath(Object obj, float[] fArr, int i5) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return -1;
        }
        MotionController motionController = motionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.buildPath(fArr, i5);
        return i5;
    }

    public void getAnimationRectangles(Object obj, float[] fArr) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene != null) {
            int duration = motionScene.getDuration() / 16;
            MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
            if (motionController != null) {
                motionController.buildRectangles(fArr, duration);
            }
        }
    }

    public String getEndState() {
        int endState = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == endState) {
            return this.mLastEndState;
        }
        String constraintSetNames = this.mMotionLayout.getConstraintSetNames(endState);
        if (constraintSetNames != null) {
            this.mLastEndState = constraintSetNames;
            this.mLastEndStateId = endState;
        }
        return constraintSetNames;
    }

    public int getKeyFrameInfo(Object obj, int i5, int[] iArr) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFrameInfo(i5, iArr);
    }

    public float getKeyFramePosition(Object obj, int i5, float f5, float f6) {
        MotionController motionController;
        if ((obj instanceof View) && (motionController = this.mMotionLayout.mFrameArrayList.get((View) obj)) != null) {
            return motionController.getKeyFrameParameter(i5, f5, f6);
        }
        return 0.0f;
    }

    public int getKeyFramePositions(Object obj, int[] iArr, float[] fArr) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFramePositions(iArr, fArr);
    }

    public Object getKeyframe(int i5, int i6, int i7) {
        MotionLayout motionLayout = this.mMotionLayout;
        MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getKeyFrame(motionLayout.getContext(), i5, i6, i7);
    }

    public Object getKeyframeAtLocation(Object obj, float f5, float f6) {
        MotionController motionController;
        View view = (View) obj;
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return -1;
        }
        if (view == null || (motionController = motionLayout.mFrameArrayList.get(view)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        return motionController.getPositionKeyframe(viewGroup.getWidth(), viewGroup.getHeight(), f5, f6);
    }

    public Boolean getPositionKeyframe(Object obj, Object obj2, float f5, float f6, String[] strArr, float[] fArr) {
        if (!(obj instanceof KeyPositionBase)) {
            return Boolean.FALSE;
        }
        View view = (View) obj2;
        this.mMotionLayout.mFrameArrayList.get(view).positionKeyframe(view, (KeyPositionBase) obj, f5, f6, strArr, fArr);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return Boolean.TRUE;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getStartState() {
        int startState = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == startState) {
            return this.mLastStartState;
        }
        String constraintSetNames = this.mMotionLayout.getConstraintSetNames(startState);
        if (constraintSetNames != null) {
            this.mLastStartState = constraintSetNames;
            this.mLastStartStateId = startState;
        }
        return this.mMotionLayout.getConstraintSetNames(startState);
    }

    public String getState() {
        if (!(this.mLastStartState == null || this.mLastEndState == null)) {
            float progress = getProgress();
            if (progress <= 0.01f) {
                return this.mLastStartState;
            }
            if (progress >= 0.99f) {
                return this.mLastEndState;
            }
        }
        return this.mLastStartState;
    }

    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        if (this.mLastStartState == null || this.mLastEndState == null) {
            return false;
        }
        return true;
    }

    public void setAttributes(int i5, String str, Object obj, Object obj2) {
        HashMap hashMap;
        View view = (View) obj;
        if (obj2 instanceof HashMap) {
            hashMap = (HashMap) obj2;
        } else {
            hashMap = new HashMap();
        }
        HashMap hashMap2 = hashMap;
        int lookUpConstraintId = this.mMotionLayout.lookUpConstraintId(str);
        ConstraintSet constraintSet = this.mMotionLayout.mScene.getConstraintSet(lookUpConstraintId);
        if (constraintSet != null) {
            constraintSet.clear(view.getId());
            setDimensions(i5, constraintSet, view, hashMap2, 0);
            setDimensions(i5, constraintSet, view, hashMap2, 1);
            int i6 = i5;
            connect(i6, constraintSet, view, hashMap2, 6, 6);
            connect(i6, constraintSet, view, hashMap2, 6, 7);
            connect(i6, constraintSet, view, hashMap2, 7, 7);
            connect(i6, constraintSet, view, hashMap2, 7, 6);
            connect(i6, constraintSet, view, hashMap2, 1, 1);
            connect(i6, constraintSet, view, hashMap2, 1, 2);
            connect(i6, constraintSet, view, hashMap2, 2, 2);
            connect(i6, constraintSet, view, hashMap2, 2, 1);
            connect(i6, constraintSet, view, hashMap2, 3, 3);
            connect(i6, constraintSet, view, hashMap2, 3, 4);
            connect(i6, constraintSet, view, hashMap2, 4, 3);
            connect(i6, constraintSet, view, hashMap2, 4, 4);
            connect(i6, constraintSet, view, hashMap2, 5, 5);
            setBias(constraintSet, view, hashMap2, 0);
            setBias(constraintSet, view, hashMap2, 1);
            setAbsolutePositions(i6, constraintSet, view, hashMap2);
            this.mMotionLayout.updateState(lookUpConstraintId, constraintSet);
            this.mMotionLayout.requestLayout();
        }
    }

    public void setKeyFrame(Object obj, int i5, String str, Object obj2) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene != null) {
            motionScene.setKeyframe((View) obj, i5, str, obj2);
            MotionLayout motionLayout = this.mMotionLayout;
            motionLayout.mTransitionGoalPosition = ((float) i5) / 100.0f;
            motionLayout.mTransitionLastPosition = 0.0f;
            motionLayout.rebuildScene();
            this.mMotionLayout.evaluate(true);
        }
    }

    public boolean setKeyFramePosition(Object obj, int i5, int i6, float f5, float f6) {
        if (!(obj instanceof View)) {
            return false;
        }
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene != null) {
            MotionController motionController = motionLayout.mFrameArrayList.get(obj);
            MotionLayout motionLayout2 = this.mMotionLayout;
            int i7 = (int) (motionLayout2.mTransitionPosition * 100.0f);
            if (motionController != null) {
                View view = (View) obj;
                if (motionLayout2.mScene.hasKeyFramePosition(view, i7)) {
                    float keyFrameParameter = motionController.getKeyFrameParameter(2, f5, f6);
                    float keyFrameParameter2 = motionController.getKeyFrameParameter(5, f5, f6);
                    this.mMotionLayout.mScene.setKeyframe(view, i7, "motion:percentX", Float.valueOf(keyFrameParameter));
                    this.mMotionLayout.mScene.setKeyframe(view, i7, "motion:percentY", Float.valueOf(keyFrameParameter2));
                    this.mMotionLayout.rebuildScene();
                    this.mMotionLayout.evaluate(true);
                    this.mMotionLayout.invalidate();
                    return true;
                }
            }
        }
        return false;
    }

    public void setKeyframe(Object obj, String str, Object obj2) {
        if (obj instanceof Key) {
            ((Key) obj).setValue(str, obj2);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
        }
    }

    public void setState(String str) {
        if (str == null) {
            str = "motion_base";
        }
        if (!Objects.equals(this.mLastStartState, str)) {
            this.mLastStartState = str;
            this.mLastEndState = null;
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null) {
                motionLayout.mScene = this.mSceneCache;
            }
            int lookUpConstraintId = motionLayout.lookUpConstraintId(str);
            this.mLastStartStateId = lookUpConstraintId;
            if (lookUpConstraintId != 0) {
                if (lookUpConstraintId == this.mMotionLayout.getStartState()) {
                    this.mMotionLayout.setProgress(0.0f);
                } else if (lookUpConstraintId == this.mMotionLayout.getEndState()) {
                    this.mMotionLayout.setProgress(1.0f);
                } else {
                    this.mMotionLayout.transitionToState(lookUpConstraintId);
                    this.mMotionLayout.setProgress(1.0f);
                }
            }
            this.mMotionLayout.requestLayout();
        }
    }

    public void setToolPosition(float f5) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        motionLayout.setProgress(f5);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setTransition(String str, String str2) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(str);
        int lookUpConstraintId2 = this.mMotionLayout.lookUpConstraintId(str2);
        this.mMotionLayout.setTransition(lookUpConstraintId, lookUpConstraintId2);
        this.mLastStartStateId = lookUpConstraintId;
        this.mLastEndStateId = lookUpConstraintId2;
        this.mLastStartState = str;
        this.mLastEndState = str2;
    }

    public void setViewDebug(Object obj, int i5) {
        MotionController motionController;
        if ((obj instanceof View) && (motionController = this.mMotionLayout.mFrameArrayList.get(obj)) != null) {
            motionController.setDrawPath(i5);
            this.mMotionLayout.invalidate();
        }
    }

    public Object getKeyframe(Object obj, int i5, int i6) {
        if (this.mMotionLayout.mScene == null) {
            return null;
        }
        int id = ((View) obj).getId();
        MotionLayout motionLayout = this.mMotionLayout;
        return motionLayout.mScene.getKeyFrame(motionLayout.getContext(), i5, id, i6);
    }
}

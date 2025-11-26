package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ViewTransitionController {
    ArrayList<ViewTransition.Animate> mAnimations;
    /* access modifiers changed from: private */
    public final MotionLayout mMotionLayout;
    private HashSet<View> mRelatedViews;
    ArrayList<ViewTransition.Animate> mRemoveList = new ArrayList<>();
    private String mTAG = "ViewTransitionController";
    private ArrayList<ViewTransition> mViewTransitions = new ArrayList<>();

    public ViewTransitionController(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private void listenForSharedVariable(ViewTransition viewTransition, boolean z4) {
        final int sharedValueID = viewTransition.getSharedValueID();
        final int sharedValue = viewTransition.getSharedValue();
        final ViewTransition viewTransition2 = viewTransition;
        final boolean z5 = z4;
        ConstraintLayout.getSharedValues().addListener(viewTransition.getSharedValueID(), new SharedValues.SharedValuesListener() {
            public void onNewValue(int i5, int i6, int i7) {
                int sharedValueCurrent = viewTransition2.getSharedValueCurrent();
                viewTransition2.setSharedValueCurrent(i6);
                if (sharedValueID == i5 && sharedValueCurrent != i6) {
                    if (z5) {
                        if (sharedValue == i6) {
                            int childCount = ViewTransitionController.this.mMotionLayout.getChildCount();
                            for (int i8 = 0; i8 < childCount; i8++) {
                                View childAt = ViewTransitionController.this.mMotionLayout.getChildAt(i8);
                                if (viewTransition2.matchesView(childAt)) {
                                    int currentState = ViewTransitionController.this.mMotionLayout.getCurrentState();
                                    ConstraintSet constraintSet = ViewTransitionController.this.mMotionLayout.getConstraintSet(currentState);
                                    ViewTransition viewTransition = viewTransition2;
                                    ViewTransitionController viewTransitionController = ViewTransitionController.this;
                                    viewTransition.applyTransition(viewTransitionController, viewTransitionController.mMotionLayout, currentState, constraintSet, childAt);
                                }
                            }
                        }
                    } else if (sharedValue != i6) {
                        int childCount2 = ViewTransitionController.this.mMotionLayout.getChildCount();
                        for (int i9 = 0; i9 < childCount2; i9++) {
                            View childAt2 = ViewTransitionController.this.mMotionLayout.getChildAt(i9);
                            if (viewTransition2.matchesView(childAt2)) {
                                int currentState2 = ViewTransitionController.this.mMotionLayout.getCurrentState();
                                ConstraintSet constraintSet2 = ViewTransitionController.this.mMotionLayout.getConstraintSet(currentState2);
                                ViewTransition viewTransition2 = viewTransition2;
                                ViewTransitionController viewTransitionController2 = ViewTransitionController.this;
                                viewTransition2.applyTransition(viewTransitionController2, viewTransitionController2.mMotionLayout, currentState2, constraintSet2, childAt2);
                            }
                        }
                    }
                }
            }
        });
    }

    private void viewTransition(ViewTransition viewTransition, View... viewArr) {
        int currentState = this.mMotionLayout.getCurrentState();
        if (viewTransition.mViewTransitionMode == 2) {
            viewTransition.applyTransition(this, this.mMotionLayout, currentState, (ConstraintSet) null, viewArr);
        } else if (currentState == -1) {
            String str = this.mTAG;
            Log.w(str, "No support for ViewTransition within transition yet. Currently: " + this.mMotionLayout.toString());
        } else {
            ConstraintSet constraintSet = this.mMotionLayout.getConstraintSet(currentState);
            if (constraintSet != null) {
                ViewTransition viewTransition2 = viewTransition;
                viewTransition2.applyTransition(this, this.mMotionLayout, currentState, constraintSet, viewArr);
            }
        }
    }

    public void add(ViewTransition viewTransition) {
        this.mViewTransitions.add(viewTransition);
        this.mRelatedViews = null;
        if (viewTransition.getStateTransition() == 4) {
            listenForSharedVariable(viewTransition, true);
        } else if (viewTransition.getStateTransition() == 5) {
            listenForSharedVariable(viewTransition, false);
        }
    }

    /* access modifiers changed from: package-private */
    public void addAnimation(ViewTransition.Animate animate) {
        if (this.mAnimations == null) {
            this.mAnimations = new ArrayList<>();
        }
        this.mAnimations.add(animate);
    }

    /* access modifiers changed from: package-private */
    public void animate() {
        ArrayList<ViewTransition.Animate> arrayList = this.mAnimations;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                ViewTransition.Animate animate = arrayList.get(i5);
                i5++;
                animate.mutate();
            }
            this.mAnimations.removeAll(this.mRemoveList);
            this.mRemoveList.clear();
            if (this.mAnimations.isEmpty()) {
                this.mAnimations = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean applyViewTransition(int i5, MotionController motionController) {
        ArrayList<ViewTransition> arrayList = this.mViewTransitions;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            ViewTransition viewTransition = arrayList.get(i6);
            i6++;
            ViewTransition viewTransition2 = viewTransition;
            if (viewTransition2.getId() == i5) {
                viewTransition2.mKeyFrames.addAllFrames(motionController);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void enableViewTransition(int i5, boolean z4) {
        ArrayList<ViewTransition> arrayList = this.mViewTransitions;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            ViewTransition viewTransition = arrayList.get(i6);
            i6++;
            ViewTransition viewTransition2 = viewTransition;
            if (viewTransition2.getId() == i5) {
                viewTransition2.setEnabled(z4);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void invalidate() {
        this.mMotionLayout.invalidate();
    }

    /* access modifiers changed from: package-private */
    public boolean isViewTransitionEnabled(int i5) {
        ArrayList<ViewTransition> arrayList = this.mViewTransitions;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            ViewTransition viewTransition = arrayList.get(i6);
            i6++;
            ViewTransition viewTransition2 = viewTransition;
            if (viewTransition2.getId() == i5) {
                return viewTransition2.isEnabled();
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void remove(int i5) {
        ViewTransition viewTransition;
        ArrayList<ViewTransition> arrayList = this.mViewTransitions;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                viewTransition = null;
                break;
            }
            ViewTransition viewTransition2 = arrayList.get(i6);
            i6++;
            viewTransition = viewTransition2;
            if (viewTransition.getId() == i5) {
                break;
            }
        }
        if (viewTransition != null) {
            this.mRelatedViews = null;
            this.mViewTransitions.remove(viewTransition);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeAnimation(ViewTransition.Animate animate) {
        this.mRemoveList.add(animate);
    }

    /* access modifiers changed from: package-private */
    public void touchEvent(MotionEvent motionEvent) {
        ViewTransitionController viewTransitionController = this;
        int currentState = viewTransitionController.mMotionLayout.getCurrentState();
        if (currentState != -1) {
            if (viewTransitionController.mRelatedViews == null) {
                viewTransitionController.mRelatedViews = new HashSet<>();
                ArrayList<ViewTransition> arrayList = viewTransitionController.mViewTransitions;
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    ViewTransition viewTransition = arrayList.get(i5);
                    i5++;
                    ViewTransition viewTransition2 = viewTransition;
                    int childCount = viewTransitionController.mMotionLayout.getChildCount();
                    for (int i6 = 0; i6 < childCount; i6++) {
                        View childAt = viewTransitionController.mMotionLayout.getChildAt(i6);
                        if (viewTransition2.matchesView(childAt)) {
                            childAt.getId();
                            viewTransitionController.mRelatedViews.add(childAt);
                        }
                    }
                }
            }
            float x4 = motionEvent.getX();
            float y4 = motionEvent.getY();
            Rect rect = new Rect();
            int action = motionEvent.getAction();
            ArrayList<ViewTransition.Animate> arrayList2 = viewTransitionController.mAnimations;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                ArrayList<ViewTransition.Animate> arrayList3 = viewTransitionController.mAnimations;
                int size2 = arrayList3.size();
                int i7 = 0;
                while (i7 < size2) {
                    ViewTransition.Animate animate = arrayList3.get(i7);
                    i7++;
                    animate.reactTo(action, x4, y4);
                }
            }
            if (action == 0 || action == 1) {
                ConstraintSet constraintSet = viewTransitionController.mMotionLayout.getConstraintSet(currentState);
                ArrayList<ViewTransition> arrayList4 = viewTransitionController.mViewTransitions;
                int size3 = arrayList4.size();
                int i8 = 0;
                while (i8 < size3) {
                    int i9 = i8 + 1;
                    ViewTransition viewTransition3 = arrayList4.get(i8);
                    if (viewTransition3.supports(action)) {
                        Iterator<View> it = viewTransitionController.mRelatedViews.iterator();
                        while (it.hasNext()) {
                            View next = it.next();
                            if (viewTransition3.matchesView(next)) {
                                next.getHitRect(rect);
                                if (rect.contains((int) x4, (int) y4)) {
                                    View view = next;
                                    viewTransition3.applyTransition(viewTransitionController, viewTransitionController.mMotionLayout, currentState, constraintSet, view);
                                }
                                viewTransitionController = this;
                            }
                        }
                    }
                    viewTransitionController = this;
                    i8 = i9;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void viewTransition(int i5, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList<ViewTransition> arrayList2 = this.mViewTransitions;
        int size = arrayList2.size();
        ViewTransition viewTransition = null;
        int i6 = 0;
        while (i6 < size) {
            ViewTransition viewTransition2 = arrayList2.get(i6);
            i6++;
            ViewTransition viewTransition3 = viewTransition2;
            if (viewTransition3.getId() == i5) {
                for (View view : viewArr) {
                    if (viewTransition3.checkTags(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    viewTransition(viewTransition3, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                viewTransition = viewTransition3;
            }
        }
        if (viewTransition == null) {
            Log.e(this.mTAG, " Could not find ViewTransition");
        }
    }
}

package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10  reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = r0
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass10.<clinit>():void");
        }
    }

    private static class AnimationInfo extends SpecialEffectsInfo {
        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim = false;

        AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z4) {
            super(operation, cancellationSignal);
            this.mIsPop = z4;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            boolean z4;
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            Fragment fragment = getOperation().getFragment();
            if (getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                z4 = true;
            } else {
                z4 = false;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, fragment, z4, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    private static class SpecialEffectsInfo {
        @NonNull
        private final SpecialEffectsController.Operation mOperation;
        @NonNull
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        /* access modifiers changed from: package-private */
        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public CancellationSignal getSignal() {
            return this.mSignal;
        }

        /* access modifiers changed from: package-private */
        public boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            if (from == finalState) {
                return true;
            }
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (from == state || finalState == state) {
                return false;
            }
            return true;
        }
    }

    DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z4, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        final AnimationInfo animationInfo;
        final View view;
        final SpecialEffectsController.Operation operation;
        final boolean z5;
        final ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        boolean z6 = false;
        for (AnimationInfo next : list) {
            if (next.isVisibilityUnchanged()) {
                next.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = next.getAnimation(context);
                if (animation == null) {
                    next.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        final SpecialEffectsController.Operation operation2 = next.getOperation();
                        Fragment fragment = operation2.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation2))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            next.completeSpecialEffect();
                        } else {
                            if (operation2.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            List<SpecialEffectsController.Operation> list3 = list2;
                            if (z5) {
                                list3.remove(operation2);
                            }
                            View view2 = fragment.mView;
                            container.startViewTransition(view2);
                            final AnimationInfo animationInfo2 = next;
                            final ViewGroup viewGroup = container;
                            final View view3 = view2;
                            AnonymousClass2 r12 = new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    viewGroup.endViewTransition(view3);
                                    if (z5) {
                                        operation2.getFinalState().applyState(view3);
                                    }
                                    animationInfo2.completeSpecialEffect();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v(FragmentManager.TAG, "Animator from operation " + operation2 + " has ended.");
                                    }
                                }
                            };
                            View view4 = view3;
                            container = viewGroup;
                            animator.addListener(r12);
                            animator.setTarget(view4);
                            animator.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animator from operation " + operation2 + " has started.");
                            }
                            animationInfo2.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() {
                                public void onCancel() {
                                    animator.end();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v(FragmentManager.TAG, "Animator from operation " + operation2 + " has been canceled.");
                                    }
                                }
                            });
                            z6 = true;
                        }
                    }
                }
            }
            Map<SpecialEffectsController.Operation, Boolean> map2 = map;
        }
        int size = arrayList.size();
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            AnimationInfo animationInfo3 = (AnimationInfo) obj;
            SpecialEffectsController.Operation operation3 = animationInfo3.getOperation();
            Fragment fragment2 = operation3.getFragment();
            if (z4) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo3.completeSpecialEffect();
            } else if (z6) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo3.completeSpecialEffect();
            } else {
                View view5 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo3.getAnimation(context))).animation);
                if (operation3.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view5.startAnimation(animation2);
                    animationInfo3.completeSpecialEffect();
                    operation = operation3;
                    animationInfo = animationInfo3;
                    view = view5;
                } else {
                    container.startViewTransition(view5);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view5);
                    operation = operation3;
                    animationInfo = animationInfo3;
                    view = view5;
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            container.post(new Runnable() {
                                public void run() {
                                    AnonymousClass4 r02 = AnonymousClass4.this;
                                    container.endViewTransition(view);
                                    animationInfo.completeSpecialEffect();
                                }
                            });
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has ended.");
                            }
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has reached onAnimationStart.");
                            }
                        }
                    });
                    view.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has started.");
                    }
                }
                CancellationSignal signal = animationInfo.getSignal();
                AnimationInfo animationInfo4 = animationInfo;
                final SpecialEffectsController.Operation operation4 = operation;
                final View view6 = view;
                final AnimationInfo animationInfo5 = animationInfo4;
                signal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
                    public void onCancel() {
                        view6.clearAnimation();
                        container.endViewTransition(view6);
                        animationInfo5.completeSpecialEffect();
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Animation from operation " + operation4 + " has been cancelled.");
                        }
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v29, resolved type: android.view.View} */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x032f, code lost:
        r4 = (android.view.View) r5.get(r6.get(r0));
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> startTransitions(@androidx.annotation.NonNull java.util.List<androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo> r30, @androidx.annotation.NonNull java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r31, boolean r32, @androidx.annotation.Nullable androidx.fragment.app.SpecialEffectsController.Operation r33, @androidx.annotation.Nullable androidx.fragment.app.SpecialEffectsController.Operation r34) {
        /*
            r29 = this;
            r1 = r29
            r4 = r32
            r3 = r33
            r2 = r34
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.Iterator r0 = r30.iterator()
            r8 = 0
        L_0x0012:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0062
            java.lang.Object r5 = r0.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r5 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r5
            boolean r9 = r5.isVisibilityUnchanged()
            if (r9 == 0) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            androidx.fragment.app.FragmentTransitionImpl r9 = r5.getHandlingImpl()
            if (r8 != 0) goto L_0x002d
            r8 = r9
            goto L_0x0012
        L_0x002d:
            if (r9 == 0) goto L_0x0012
            if (r8 != r9) goto L_0x0032
            goto L_0x0012
        L_0x0032:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Mixing framework transitions and AndroidX transitions is not allowed. Fragment "
            r2.append(r3)
            androidx.fragment.app.SpecialEffectsController$Operation r3 = r5.getOperation()
            androidx.fragment.app.Fragment r3 = r3.getFragment()
            r2.append(r3)
            java.lang.String r3 = " returned Transition "
            r2.append(r3)
            java.lang.Object r3 = r5.getTransition()
            r2.append(r3)
            java.lang.String r3 = " which uses a different Transition  type than other Fragments."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0062:
            if (r8 != 0) goto L_0x0084
            java.util.Iterator r0 = r30.iterator()
        L_0x0068:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0081
            java.lang.Object r2 = r0.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r2 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r2
            androidx.fragment.app.SpecialEffectsController$Operation r3 = r2.getOperation()
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r6.put(r3, r4)
            r2.completeSpecialEffect()
            goto L_0x0068
        L_0x0081:
            r4 = r6
            goto L_0x0582
        L_0x0084:
            android.view.View r9 = new android.view.View
            android.view.ViewGroup r0 = r1.getContainer()
            android.content.Context r0 = r0.getContext()
            r9.<init>(r0)
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            androidx.collection.ArrayMap r12 = new androidx.collection.ArrayMap
            r12.<init>()
            java.util.Iterator r16 = r30.iterator()
            r0 = 0
            r14 = 0
            r17 = 0
        L_0x00ad:
            boolean r5 = r16.hasNext()
            r18 = 2
            java.lang.String r7 = "FragmentManager"
            r19 = r14
            if (r5 == 0) goto L_0x0391
            java.lang.Object r5 = r16.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r5 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r5
            boolean r20 = r5.hasSharedElementTransition()
            if (r20 == 0) goto L_0x037d
            if (r3 == 0) goto L_0x037d
            if (r2 == 0) goto L_0x037d
            java.lang.Object r0 = r5.getSharedElementTransition()
            java.lang.Object r0 = r8.cloneTransition(r0)
            java.lang.Object r0 = r8.wrapTransitionInSet(r0)
            androidx.fragment.app.Fragment r5 = r2.getFragment()
            java.util.ArrayList r5 = r5.getSharedElementSourceNames()
            androidx.fragment.app.Fragment r20 = r3.getFragment()
            java.util.ArrayList r13 = r20.getSharedElementSourceNames()
            androidx.fragment.app.Fragment r20 = r3.getFragment()
            r22 = 1
            java.util.ArrayList r14 = r20.getSharedElementTargetNames()
            r20 = r0
            r23 = r6
            r0 = 0
        L_0x00f4:
            int r6 = r14.size()
            if (r0 >= r6) goto L_0x0115
            java.lang.Object r6 = r14.get(r0)
            int r6 = r5.indexOf(r6)
            r24 = r14
            r14 = -1
            if (r6 == r14) goto L_0x0110
            java.lang.Object r14 = r13.get(r0)
            java.lang.String r14 = (java.lang.String) r14
            r5.set(r6, r14)
        L_0x0110:
            int r0 = r0 + 1
            r14 = r24
            goto L_0x00f4
        L_0x0115:
            androidx.fragment.app.Fragment r0 = r2.getFragment()
            java.util.ArrayList r6 = r0.getSharedElementTargetNames()
            if (r4 != 0) goto L_0x0130
            androidx.fragment.app.Fragment r0 = r3.getFragment()
            androidx.core.app.SharedElementCallback r0 = r0.getExitTransitionCallback()
            androidx.fragment.app.Fragment r13 = r2.getFragment()
            androidx.core.app.SharedElementCallback r13 = r13.getEnterTransitionCallback()
            goto L_0x0140
        L_0x0130:
            androidx.fragment.app.Fragment r0 = r3.getFragment()
            androidx.core.app.SharedElementCallback r0 = r0.getEnterTransitionCallback()
            androidx.fragment.app.Fragment r13 = r2.getFragment()
            androidx.core.app.SharedElementCallback r13 = r13.getExitTransitionCallback()
        L_0x0140:
            int r14 = r5.size()
            r24 = r9
            r9 = 0
        L_0x0147:
            if (r9 >= r14) goto L_0x0165
            java.lang.Object r25 = r5.get(r9)
            r26 = r14
            r14 = r25
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r25 = r6.get(r9)
            r27 = r9
            r9 = r25
            java.lang.String r9 = (java.lang.String) r9
            r12.put(r14, r9)
            int r9 = r27 + 1
            r14 = r26
            goto L_0x0147
        L_0x0165:
            boolean r9 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r18)
            if (r9 == 0) goto L_0x01d1
            java.lang.String r9 = ">>> entering view names <<<"
            android.util.Log.v(r7, r9)
            int r9 = r6.size()
            r25 = r10
            r14 = 0
        L_0x0177:
            java.lang.String r10 = "Name: "
            if (r14 >= r9) goto L_0x01a0
            java.lang.Object r26 = r6.get(r14)
            int r14 = r14 + 1
            r27 = r9
            r9 = r26
            java.lang.String r9 = (java.lang.String) r9
            r26 = r14
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r10)
            r14.append(r9)
            java.lang.String r9 = r14.toString()
            android.util.Log.v(r7, r9)
            r14 = r26
            r9 = r27
            goto L_0x0177
        L_0x01a0:
            java.lang.String r9 = ">>> exiting view names <<<"
            android.util.Log.v(r7, r9)
            int r9 = r5.size()
            r14 = 0
        L_0x01aa:
            if (r14 >= r9) goto L_0x01d3
            java.lang.Object r26 = r5.get(r14)
            int r14 = r14 + 1
            r27 = r9
            r9 = r26
            java.lang.String r9 = (java.lang.String) r9
            r26 = r14
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r10)
            r14.append(r9)
            java.lang.String r9 = r14.toString()
            android.util.Log.v(r7, r9)
            r14 = r26
            r9 = r27
            goto L_0x01aa
        L_0x01d1:
            r25 = r10
        L_0x01d3:
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
            r9.<init>()
            androidx.fragment.app.Fragment r10 = r3.getFragment()
            android.view.View r10 = r10.mView
            r1.findNamedViews(r9, r10)
            r9.retainAll(r5)
            if (r0 == 0) goto L_0x023d
            boolean r10 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r18)
            if (r10 == 0) goto L_0x0200
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r14 = "Executing exit callback for operation "
            r10.append(r14)
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            android.util.Log.v(r7, r10)
        L_0x0200:
            r0.onMapSharedElements(r5, r9)
            int r0 = r5.size()
            int r0 = r0 + -1
        L_0x0209:
            if (r0 < 0) goto L_0x023b
            java.lang.Object r10 = r5.get(r0)
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r14 = r9.get(r10)
            android.view.View r14 = (android.view.View) r14
            if (r14 != 0) goto L_0x021f
            r12.remove(r10)
            r26 = r0
            goto L_0x0238
        L_0x021f:
            r26 = r0
            java.lang.String r0 = androidx.core.view.ViewCompat.getTransitionName(r14)
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L_0x0238
            java.lang.Object r0 = r12.remove(r10)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r10 = androidx.core.view.ViewCompat.getTransitionName(r14)
            r12.put(r10, r0)
        L_0x0238:
            int r0 = r26 + -1
            goto L_0x0209
        L_0x023b:
            r0 = r5
            goto L_0x0245
        L_0x023d:
            java.util.Set r0 = r9.keySet()
            r12.retainAll(r0)
            goto L_0x023b
        L_0x0245:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
            androidx.fragment.app.Fragment r10 = r2.getFragment()
            android.view.View r10 = r10.mView
            r1.findNamedViews(r5, r10)
            r5.retainAll(r6)
            java.util.Collection r10 = r12.values()
            r5.retainAll(r10)
            if (r13 == 0) goto L_0x02b6
            boolean r10 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r18)
            if (r10 == 0) goto L_0x0279
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r14 = "Executing enter callback for operation "
            r10.append(r14)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            android.util.Log.v(r7, r10)
        L_0x0279:
            r13.onMapSharedElements(r6, r5)
            int r7 = r6.size()
            int r7 = r7 + -1
        L_0x0282:
            if (r7 < 0) goto L_0x02b9
            java.lang.Object r10 = r6.get(r7)
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r13 = r5.get(r10)
            android.view.View r13 = (android.view.View) r13
            if (r13 != 0) goto L_0x029c
            java.lang.String r10 = androidx.fragment.app.FragmentTransition.findKeyForValue(r12, r10)
            if (r10 == 0) goto L_0x02b3
            r12.remove(r10)
            goto L_0x02b3
        L_0x029c:
            java.lang.String r14 = androidx.core.view.ViewCompat.getTransitionName(r13)
            boolean r14 = r10.equals(r14)
            if (r14 != 0) goto L_0x02b3
            java.lang.String r10 = androidx.fragment.app.FragmentTransition.findKeyForValue(r12, r10)
            if (r10 == 0) goto L_0x02b3
            java.lang.String r13 = androidx.core.view.ViewCompat.getTransitionName(r13)
            r12.put(r10, r13)
        L_0x02b3:
            int r7 = r7 + -1
            goto L_0x0282
        L_0x02b6:
            androidx.fragment.app.FragmentTransition.retainValues(r12, r5)
        L_0x02b9:
            java.util.Set r7 = r12.keySet()
            r1.retainMatchingViews(r9, r7)
            java.util.Collection r7 = r12.values()
            r1.retainMatchingViews(r5, r7)
            boolean r7 = r12.isEmpty()
            if (r7 == 0) goto L_0x02e3
            r11.clear()
            r15.clear()
            r7 = r11
            r20 = r12
            r9 = r15
            r14 = r19
            r11 = r23
            r5 = r24
            r6 = r25
            r0 = 0
            r4 = 0
            goto L_0x0386
        L_0x02e3:
            androidx.fragment.app.Fragment r7 = r2.getFragment()
            androidx.fragment.app.Fragment r10 = r3.getFragment()
            r13 = r22
            androidx.fragment.app.FragmentTransition.callSharedElementStartEnd(r7, r10, r4, r9, r13)
            android.view.ViewGroup r7 = r1.getContainer()
            r10 = r0
            androidx.fragment.app.DefaultSpecialEffectsController$6 r0 = new androidx.fragment.app.DefaultSpecialEffectsController$6
            r14 = r10
            r10 = r20
            r0.<init>(r2, r3, r4, r5)
            androidx.core.view.OneShotPreDrawListener.add(r7, r0)
            java.util.Collection r0 = r9.values()
            r11.addAll(r0)
            boolean r0 = r14.isEmpty()
            if (r0 != 0) goto L_0x0321
            r0 = 0
            java.lang.Object r4 = r14.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r9.get(r4)
            r14 = r4
            android.view.View r14 = (android.view.View) r14
            r8.setEpicenter((java.lang.Object) r10, (android.view.View) r14)
            r19 = r14
            goto L_0x0322
        L_0x0321:
            r0 = 0
        L_0x0322:
            java.util.Collection r4 = r5.values()
            r15.addAll(r4)
            boolean r4 = r6.isEmpty()
            if (r4 != 0) goto L_0x0350
            java.lang.Object r4 = r6.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r5.get(r4)
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x0350
            android.view.ViewGroup r5 = r1.getContainer()
            androidx.fragment.app.DefaultSpecialEffectsController$7 r6 = new androidx.fragment.app.DefaultSpecialEffectsController$7
            r7 = r25
            r6.<init>(r8, r4, r7)
            androidx.core.view.OneShotPreDrawListener.add(r5, r6)
            r17 = r13
        L_0x034d:
            r4 = r24
            goto L_0x0353
        L_0x0350:
            r7 = r25
            goto L_0x034d
        L_0x0353:
            r8.setSharedElementTargets(r10, r4, r11)
            r13 = r12
            r12 = 0
            r5 = r13
            r13 = 0
            r20 = r10
            r10 = 0
            r6 = r11
            r11 = 0
            r14 = r20
            r9 = r7
            r7 = r6
            r6 = r9
            r9 = r20
            r20 = r5
            r5 = r4
            r4 = r0
            r8.scheduleRemoveTargets(r9, r10, r11, r12, r13, r14, r15)
            r10 = r9
            r9 = r15
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r11 = r23
            r11.put(r3, r0)
            r11.put(r2, r0)
            r0 = r10
        L_0x037a:
            r14 = r19
            goto L_0x0386
        L_0x037d:
            r5 = r9
            r7 = r11
            r20 = r12
            r9 = r15
            r4 = 0
            r11 = r6
            r6 = r10
            goto L_0x037a
        L_0x0386:
            r4 = r32
            r10 = r6
            r15 = r9
            r6 = r11
            r12 = r20
            r9 = r5
            r11 = r7
            goto L_0x00ad
        L_0x0391:
            r4 = r11
            r11 = r6
            r6 = r10
            r10 = r4
            r5 = r9
            r20 = r12
            r9 = r15
            r4 = 0
            r13 = 1
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Iterator r16 = r30.iterator()
            r14 = 0
            r15 = 0
        L_0x03a6:
            boolean r21 = r16.hasNext()
            if (r21 == 0) goto L_0x04da
            java.lang.Object r21 = r16.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r21 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r21
            boolean r22 = r21.isVisibilityUnchanged()
            if (r22 == 0) goto L_0x03c7
            androidx.fragment.app.SpecialEffectsController$Operation r13 = r21.getOperation()
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r11.put(r13, r4)
            r21.completeSpecialEffect()
            r4 = 0
            r13 = 1
            goto L_0x03a6
        L_0x03c7:
            java.lang.Object r4 = r21.getTransition()
            java.lang.Object r4 = r8.cloneTransition(r4)
            androidx.fragment.app.SpecialEffectsController$Operation r13 = r21.getOperation()
            if (r0 == 0) goto L_0x03dc
            if (r13 == r3) goto L_0x03d9
            if (r13 != r2) goto L_0x03dc
        L_0x03d9:
            r24 = 1
            goto L_0x03de
        L_0x03dc:
            r24 = 0
        L_0x03de:
            if (r4 != 0) goto L_0x03fd
            if (r24 != 0) goto L_0x03ea
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r11.put(r13, r4)
            r21.completeSpecialEffect()
        L_0x03ea:
            r24 = r5
            r22 = r7
            r28 = r10
            r4 = r11
            r7 = r12
            r5 = r19
            r11 = 0
            r25 = 1
            r10 = r31
            r19 = r9
            goto L_0x04c5
        L_0x03fd:
            r25 = r11
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r32 = r12
            androidx.fragment.app.Fragment r12 = r13.getFragment()
            android.view.View r12 = r12.mView
            r1.captureTransitioningViews(r11, r12)
            if (r24 == 0) goto L_0x041a
            if (r13 != r3) goto L_0x0417
            r11.removeAll(r10)
            goto L_0x041a
        L_0x0417:
            r11.removeAll(r9)
        L_0x041a:
            boolean r12 = r11.isEmpty()
            if (r12 == 0) goto L_0x043a
            r8.addTarget(r4, r5)
            r24 = r5
            r22 = r7
            r28 = r10
            r12 = r13
            r2 = r14
            r3 = r15
            r5 = r19
            r10 = r31
            r7 = r32
            r19 = r9
            r9 = r4
            r4 = r25
            r25 = 1
            goto L_0x0498
        L_0x043a:
            r8.addTargets(r4, r11)
            r12 = r14
            r14 = 0
            r24 = r15
            r15 = 0
            r26 = r12
            r12 = 0
            r27 = r13
            r13 = 0
            r28 = r10
            r10 = r4
            r22 = r7
            r3 = r24
            r2 = r26
            r7 = r32
            r24 = r5
            r5 = r19
            r19 = r9
            r9 = r4
            r4 = r25
            r25 = 1
            r8.scheduleRemoveTargets(r9, r10, r11, r12, r13, r14, r15)
            androidx.fragment.app.SpecialEffectsController$Operation$State r10 = r27.getFinalState()
            androidx.fragment.app.SpecialEffectsController$Operation$State r12 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE
            if (r10 != r12) goto L_0x0494
            r10 = r31
            r12 = r27
            r10.remove(r12)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>(r11)
            androidx.fragment.app.Fragment r14 = r12.getFragment()
            android.view.View r14 = r14.mView
            r13.remove(r14)
            androidx.fragment.app.Fragment r14 = r12.getFragment()
            android.view.View r14 = r14.mView
            r8.scheduleHideFragmentView(r9, r14, r13)
            android.view.ViewGroup r13 = r1.getContainer()
            androidx.fragment.app.DefaultSpecialEffectsController$8 r14 = new androidx.fragment.app.DefaultSpecialEffectsController$8
            r14.<init>(r11)
            androidx.core.view.OneShotPreDrawListener.add(r13, r14)
            goto L_0x0498
        L_0x0494:
            r10 = r31
            r12 = r27
        L_0x0498:
            androidx.fragment.app.SpecialEffectsController$Operation$State r13 = r12.getFinalState()
            androidx.fragment.app.SpecialEffectsController$Operation$State r14 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r13 != r14) goto L_0x04a9
            r7.addAll(r11)
            if (r17 == 0) goto L_0x04ac
            r8.setEpicenter((java.lang.Object) r9, (android.graphics.Rect) r6)
            goto L_0x04ac
        L_0x04a9:
            r8.setEpicenter((java.lang.Object) r9, (android.view.View) r5)
        L_0x04ac:
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            r4.put(r12, r11)
            boolean r11 = r21.isOverlapAllowed()
            if (r11 == 0) goto L_0x04bf
            r11 = 0
            java.lang.Object r2 = r8.mergeTransitionsTogether(r2, r9, r11)
        L_0x04bc:
            r14 = r2
            r15 = r3
            goto L_0x04c5
        L_0x04bf:
            r11 = 0
            java.lang.Object r3 = r8.mergeTransitionsTogether(r3, r9, r11)
            goto L_0x04bc
        L_0x04c5:
            r3 = r33
            r2 = r34
            r11 = r4
            r12 = r7
            r9 = r19
            r7 = r22
            r13 = r25
            r10 = r28
            r4 = 0
            r19 = r5
            r5 = r24
            goto L_0x03a6
        L_0x04da:
            r22 = r7
            r19 = r9
            r28 = r10
            r4 = r11
            r7 = r12
            r25 = r13
            r2 = r14
            r3 = r15
            java.lang.Object r2 = r8.mergeTransitionsInSequence(r2, r3, r0)
            if (r2 != 0) goto L_0x04ee
            goto L_0x0582
        L_0x04ee:
            java.util.Iterator r3 = r30.iterator()
        L_0x04f2:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0576
            java.lang.Object r5 = r3.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r5 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r5
            boolean r6 = r5.isVisibilityUnchanged()
            if (r6 == 0) goto L_0x0505
            goto L_0x04f2
        L_0x0505:
            java.lang.Object r6 = r5.getTransition()
            androidx.fragment.app.SpecialEffectsController$Operation r9 = r5.getOperation()
            r10 = r33
            r11 = r34
            if (r0 == 0) goto L_0x051a
            if (r9 == r10) goto L_0x0517
            if (r9 != r11) goto L_0x051a
        L_0x0517:
            r13 = r25
            goto L_0x051b
        L_0x051a:
            r13 = 0
        L_0x051b:
            if (r6 != 0) goto L_0x0523
            if (r13 == 0) goto L_0x0520
            goto L_0x0523
        L_0x0520:
            r12 = r22
            goto L_0x0572
        L_0x0523:
            android.view.ViewGroup r6 = r1.getContainer()
            boolean r6 = androidx.core.view.ViewCompat.isLaidOut(r6)
            if (r6 != 0) goto L_0x055c
            boolean r6 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r18)
            if (r6 == 0) goto L_0x0556
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r12 = "SpecialEffectsController: Container "
            r6.append(r12)
            android.view.ViewGroup r12 = r1.getContainer()
            r6.append(r12)
            java.lang.String r12 = " has not been laid out. Completing operation "
            r6.append(r12)
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r12 = r22
            android.util.Log.v(r12, r6)
            goto L_0x0558
        L_0x0556:
            r12 = r22
        L_0x0558:
            r5.completeSpecialEffect()
            goto L_0x0572
        L_0x055c:
            r12 = r22
            androidx.fragment.app.SpecialEffectsController$Operation r6 = r5.getOperation()
            androidx.fragment.app.Fragment r6 = r6.getFragment()
            androidx.core.os.CancellationSignal r13 = r5.getSignal()
            androidx.fragment.app.DefaultSpecialEffectsController$9 r14 = new androidx.fragment.app.DefaultSpecialEffectsController$9
            r14.<init>(r5, r9)
            r8.setListenerForTransitionEnd(r6, r2, r13, r14)
        L_0x0572:
            r22 = r12
            goto L_0x04f2
        L_0x0576:
            r12 = r22
            android.view.ViewGroup r3 = r1.getContainer()
            boolean r3 = androidx.core.view.ViewCompat.isLaidOut(r3)
            if (r3 != 0) goto L_0x0583
        L_0x0582:
            return r4
        L_0x0583:
            r3 = 4
            androidx.fragment.app.FragmentTransition.setViewVisibility(r7, r3)
            r11 = r19
            java.util.ArrayList r3 = r8.prepareSetNameOverridesReordered(r11)
            boolean r5 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r18)
            if (r5 == 0) goto L_0x0602
            java.lang.String r5 = ">>>>> Beginning transition <<<<<"
            android.util.Log.v(r12, r5)
            java.lang.String r5 = ">>>>> SharedElementFirstOutViews <<<<<"
            android.util.Log.v(r12, r5)
            int r5 = r28.size()
            r13 = 0
        L_0x05a2:
            java.lang.String r6 = " Name: "
            java.lang.String r9 = "View: "
            if (r13 >= r5) goto L_0x05cf
            r10 = r28
            java.lang.Object r14 = r10.get(r13)
            int r13 = r13 + 1
            android.view.View r14 = (android.view.View) r14
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r9)
            r15.append(r14)
            r15.append(r6)
            java.lang.String r6 = androidx.core.view.ViewCompat.getTransitionName(r14)
            r15.append(r6)
            java.lang.String r6 = r15.toString()
            android.util.Log.v(r12, r6)
            goto L_0x05a2
        L_0x05cf:
            r10 = r28
            java.lang.String r5 = ">>>>> SharedElementLastInViews <<<<<"
            android.util.Log.v(r12, r5)
            int r5 = r11.size()
            r13 = 0
        L_0x05db:
            if (r13 >= r5) goto L_0x0604
            java.lang.Object r14 = r11.get(r13)
            int r13 = r13 + 1
            android.view.View r14 = (android.view.View) r14
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r9)
            r15.append(r14)
            r15.append(r6)
            java.lang.String r14 = androidx.core.view.ViewCompat.getTransitionName(r14)
            r15.append(r14)
            java.lang.String r14 = r15.toString()
            android.util.Log.v(r12, r14)
            goto L_0x05db
        L_0x0602:
            r10 = r28
        L_0x0604:
            android.view.ViewGroup r5 = r1.getContainer()
            r8.beginDelayedTransition(r5, r2)
            android.view.ViewGroup r9 = r1.getContainer()
            r12 = r3
            r13 = r20
            r8.setNameOverridesReordered(r9, r10, r11, r12, r13)
            r2 = 0
            androidx.fragment.app.FragmentTransition.setViewVisibility(r7, r2)
            r8.swapSharedElementTargets(r0, r10, r11)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.startTransitions(java.util.List, java.util.List, boolean, androidx.fragment.app.SpecialEffectsController$Operation, androidx.fragment.app.SpecialEffectsController$Operation):java.util.Map");
    }

    private void syncAnimations(@NonNull List<SpecialEffectsController.Operation> list) {
        Fragment fragment = list.get(list.size() - 1).getFragment();
        for (SpecialEffectsController.Operation next : list) {
            next.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            next.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            next.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            next.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    /* access modifiers changed from: package-private */
    public void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    /* access modifiers changed from: package-private */
    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!ViewGroupCompat.isTransitionGroup(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = viewGroup.getChildAt(i5);
                    if (childAt.getVisibility() == 0) {
                        captureTransitioningViews(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1, types: [int] */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r11v5 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeOperations(@androidx.annotation.NonNull java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r14, boolean r15) {
        /*
            r13 = this;
            java.util.Iterator r0 = r14.iterator()
            r1 = 0
            r6 = r1
            r7 = r6
        L_0x0007:
            boolean r1 = r0.hasNext()
            r8 = 2
            r9 = 1
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.SpecialEffectsController$Operation r1 = (androidx.fragment.app.SpecialEffectsController.Operation) r1
            androidx.fragment.app.Fragment r2 = r1.getFragment()
            android.view.View r2 = r2.mView
            androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.from((android.view.View) r2)
            int[] r3 = androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State
            androidx.fragment.app.SpecialEffectsController$Operation$State r4 = r1.getFinalState()
            int r4 = r4.ordinal()
            r3 = r3[r4]
            if (r3 == r9) goto L_0x003c
            if (r3 == r8) goto L_0x003c
            r4 = 3
            if (r3 == r4) goto L_0x003c
            r4 = 4
            if (r3 == r4) goto L_0x0036
            goto L_0x0007
        L_0x0036:
            androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r2 == r3) goto L_0x0007
            r7 = r1
            goto L_0x0007
        L_0x003c:
            androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r2 != r3) goto L_0x0007
            if (r6 != 0) goto L_0x0007
            r6 = r1
            goto L_0x0007
        L_0x0044:
            boolean r0 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r8)
            java.lang.String r1 = " to "
            java.lang.String r10 = "FragmentManager"
            if (r0 == 0) goto L_0x0068
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Executing operations from "
            r0.append(r2)
            r0.append(r6)
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r10, r0)
        L_0x0068:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r14)
            r13.syncAnimations(r14)
            java.util.Iterator r14 = r14.iterator()
        L_0x007e:
            boolean r2 = r14.hasNext()
            r11 = 0
            if (r2 == 0) goto L_0x00bd
            java.lang.Object r2 = r14.next()
            androidx.fragment.app.SpecialEffectsController$Operation r2 = (androidx.fragment.app.SpecialEffectsController.Operation) r2
            androidx.core.os.CancellationSignal r5 = new androidx.core.os.CancellationSignal
            r5.<init>()
            r2.markStartedSpecialEffect(r5)
            androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo r12 = new androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo
            r12.<init>(r2, r5, r15)
            r0.add(r12)
            androidx.core.os.CancellationSignal r5 = new androidx.core.os.CancellationSignal
            r5.<init>()
            r2.markStartedSpecialEffect(r5)
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r12 = new androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo
            if (r15 == 0) goto L_0x00ab
            if (r2 != r6) goto L_0x00ae
        L_0x00a9:
            r11 = r9
            goto L_0x00ae
        L_0x00ab:
            if (r2 != r7) goto L_0x00ae
            goto L_0x00a9
        L_0x00ae:
            r12.<init>(r2, r5, r15, r11)
            r3.add(r12)
            androidx.fragment.app.DefaultSpecialEffectsController$1 r5 = new androidx.fragment.app.DefaultSpecialEffectsController$1
            r5.<init>(r4, r2)
            r2.addCompletionListener(r5)
            goto L_0x007e
        L_0x00bd:
            r2 = r13
            r5 = r15
            java.util.Map r14 = r2.startTransitions(r3, r4, r5, r6, r7)
            java.lang.Boolean r15 = java.lang.Boolean.TRUE
            boolean r15 = r14.containsValue(r15)
            r13.startAnimations(r0, r4, r15, r14)
            int r14 = r4.size()
        L_0x00d0:
            if (r11 >= r14) goto L_0x00de
            java.lang.Object r15 = r4.get(r11)
            int r11 = r11 + 1
            androidx.fragment.app.SpecialEffectsController$Operation r15 = (androidx.fragment.app.SpecialEffectsController.Operation) r15
            r13.applyContainerChanges(r15)
            goto L_0x00d0
        L_0x00de:
            r4.clear()
            boolean r14 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r8)
            if (r14 == 0) goto L_0x0101
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Completed executing operations from "
            r14.append(r15)
            r14.append(r6)
            r14.append(r1)
            r14.append(r7)
            java.lang.String r14 = r14.toString()
            android.util.Log.v(r10, r14)
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.executeOperations(java.util.List, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = viewGroup.getChildAt(i5);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName((View) it.next().getValue()))) {
                it.remove();
            }
        }
    }

    private static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        @Nullable
        private final Object mSharedElementTransition;
        @Nullable
        private final Object mTransition;

        TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z4, boolean z5) {
            super(operation, cancellationSignal);
            Object obj;
            Object obj2;
            boolean z6;
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z4) {
                    obj2 = operation.getFragment().getReenterTransition();
                } else {
                    obj2 = operation.getFragment().getEnterTransition();
                }
                this.mTransition = obj2;
                if (z4) {
                    z6 = operation.getFragment().getAllowReturnTransitionOverlap();
                } else {
                    z6 = operation.getFragment().getAllowEnterTransitionOverlap();
                }
                this.mOverlapAllowed = z6;
            } else {
                if (z4) {
                    obj = operation.getFragment().getReturnTransition();
                } else {
                    obj = operation.getFragment().getExitTransition();
                }
                this.mTransition = obj;
                this.mOverlapAllowed = true;
            }
            if (!z5) {
                this.mSharedElementTransition = null;
            } else if (z4) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            if (this.mSharedElementTransition != null) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}

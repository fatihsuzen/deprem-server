package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    public static /* synthetic */ void a(Runnable runnable, Transition transition, Runnable runnable2) {
        if (runnable == null) {
            transition.cancel();
            runnable2.run();
            return;
        }
        runnable.run();
    }

    private static boolean hasSimpleTarget(Transition transition) {
        if (!FragmentTransitionImpl.isNullOrEmpty(transition.getTargetIds()) || !FragmentTransitionImpl.isNullOrEmpty(transition.getTargetNames()) || !FragmentTransitionImpl.isNullOrEmpty(transition.getTargetTypes())) {
            return true;
        }
        return false;
    }

    public void addTarget(@NonNull Object obj, @NonNull View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public void addTargets(@NonNull Object obj, @NonNull ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i5 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i5 < transitionCount) {
                    addTargets(transitionSet.getTransitionAt(i5), arrayList);
                    i5++;
                }
            } else if (!hasSimpleTarget(transition) && FragmentTransitionImpl.isNullOrEmpty(transition.getTargets())) {
                int size = arrayList.size();
                while (i5 < size) {
                    transition.addTarget(arrayList.get(i5));
                    i5++;
                }
            }
        }
    }

    public void animateToEnd(@NonNull Object obj) {
        ((TransitionSeekController) obj).animateToEnd();
    }

    public void animateToStart(@NonNull Object obj, @NonNull Runnable runnable) {
        ((TransitionSeekController) obj).animateToStart(runnable);
    }

    public void beginDelayedTransition(@NonNull ViewGroup viewGroup, @Nullable Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public boolean canHandle(@NonNull Object obj) {
        return obj instanceof Transition;
    }

    @Nullable
    public Object cloneTransition(@Nullable Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Nullable
    public Object controlDelayedTransition(@NonNull ViewGroup viewGroup, @NonNull Object obj) {
        return TransitionManager.controlDelayedTransition(viewGroup, (Transition) obj);
    }

    public boolean isSeekingSupported() {
        return true;
    }

    @Nullable
    public Object mergeTransitionsInSequence(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            if (transition2 != null) {
                transition = transition2;
            } else {
                transition = null;
            }
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    @NonNull
    public Object mergeTransitionsTogether(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    public void removeTarget(@NonNull Object obj, @NonNull View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    public void replaceTargets(@NonNull Object obj, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList2) {
        int i5;
        Transition transition = (Transition) obj;
        int i6 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i6 < transitionCount) {
                replaceTargets(transitionSet.getTransitionAt(i6), arrayList, arrayList2);
                i6++;
            }
        } else if (!hasSimpleTarget(transition)) {
            List<View> targets = transition.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i5 = 0;
                } else {
                    i5 = arrayList2.size();
                }
                while (i6 < i5) {
                    transition.addTarget(arrayList2.get(i6));
                    i6++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    transition.removeTarget(arrayList.get(size));
                }
            }
        }
    }

    public void scheduleHideFragmentView(@NonNull Object obj, @NonNull final View view, @NonNull final ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new Transition.TransitionListener() {
            public void onTransitionCancel(@NonNull Transition transition) {
            }

            public /* synthetic */ void onTransitionEnd(Transition transition, boolean z4) {
                e.a(this, transition, z4);
            }

            public void onTransitionPause(@NonNull Transition transition) {
            }

            public void onTransitionResume(@NonNull Transition transition) {
            }

            public /* synthetic */ void onTransitionStart(Transition transition, boolean z4) {
                e.b(this, transition, z4);
            }

            public void onTransitionEnd(@NonNull Transition transition) {
                transition.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((View) arrayList.get(i5)).setVisibility(0);
                }
            }

            public void onTransitionStart(@NonNull Transition transition) {
                transition.removeListener(this);
                transition.addListener(this);
            }
        });
    }

    public void scheduleRemoveTargets(@NonNull Object obj, @Nullable Object obj2, @Nullable ArrayList<View> arrayList, @Nullable Object obj3, @Nullable ArrayList<View> arrayList2, @Nullable Object obj4, @Nullable ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).addListener(new TransitionListenerAdapter() {
            public void onTransitionEnd(@NonNull Transition transition) {
                transition.removeListener(this);
            }

            public void onTransitionStart(@NonNull Transition transition) {
                Object obj = obj5;
                if (obj != null) {
                    FragmentTransitionSupport.this.replaceTargets(obj, arrayList4, (ArrayList<View>) null);
                }
                Object obj2 = obj6;
                if (obj2 != null) {
                    FragmentTransitionSupport.this.replaceTargets(obj2, arrayList5, (ArrayList<View>) null);
                }
                Object obj3 = obj7;
                if (obj3 != null) {
                    FragmentTransitionSupport.this.replaceTargets(obj3, arrayList6, (ArrayList<View>) null);
                }
            }
        });
    }

    public void setCurrentPlayTime(@NonNull Object obj, float f5) {
        TransitionSeekController transitionSeekController = (TransitionSeekController) obj;
        if (transitionSeekController.isReady()) {
            long durationMillis = (long) (f5 * ((float) transitionSeekController.getDurationMillis()));
            if (durationMillis == 0) {
                durationMillis = 1;
            }
            if (durationMillis == transitionSeekController.getDurationMillis()) {
                durationMillis = transitionSeekController.getDurationMillis() - 1;
            }
            transitionSeekController.setCurrentPlayTimeMillis(durationMillis);
        }
    }

    public void setEpicenter(@NonNull Object obj, @Nullable View view) {
        if (view != null) {
            final Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() {
                public Rect onGetEpicenter(@NonNull Transition transition) {
                    return rect;
                }
            });
        }
    }

    public void setListenerForTransitionEnd(@NonNull Fragment fragment, @NonNull Object obj, @NonNull CancellationSignal cancellationSignal, @NonNull Runnable runnable) {
        setListenerForTransitionEnd(fragment, obj, cancellationSignal, (Runnable) null, runnable);
    }

    public void setSharedElementTargets(@NonNull Object obj, @NonNull View view, @NonNull ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            FragmentTransitionImpl.bfsAddViewChildren(targets, arrayList.get(i5));
        }
        targets.add(view);
        arrayList.add(view);
        addTargets(transitionSet, arrayList);
    }

    public void swapSharedElementTargets(@Nullable Object obj, @Nullable ArrayList<View> arrayList, @Nullable ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            replaceTargets(transitionSet, arrayList, arrayList2);
        }
    }

    @Nullable
    public Object wrapTransitionInSet(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public boolean isSeekingSupported(@NonNull Object obj) {
        boolean isSeekingSupported = ((Transition) obj).isSeekingSupported();
        if (!isSeekingSupported) {
            Log.v(FragmentManager.TAG, "Predictive back not available for AndroidX Transition " + obj + ". Please enable seeking support for the designated transition by overriding isSeekingSupported().");
        }
        return isSeekingSupported;
    }

    public void setListenerForTransitionEnd(@NonNull Fragment fragment, @NonNull Object obj, @NonNull CancellationSignal cancellationSignal, @Nullable Runnable runnable, @NonNull final Runnable runnable2) {
        Transition transition = (Transition) obj;
        cancellationSignal.setOnCancelListener(new a(runnable, transition, runnable2));
        transition.addListener(new Transition.TransitionListener() {
            public void onTransitionCancel(@NonNull Transition transition) {
            }

            public /* synthetic */ void onTransitionEnd(Transition transition, boolean z4) {
                e.a(this, transition, z4);
            }

            public void onTransitionPause(@NonNull Transition transition) {
            }

            public void onTransitionResume(@NonNull Transition transition) {
            }

            public void onTransitionStart(@NonNull Transition transition) {
            }

            public void onTransitionEnd(@NonNull Transition transition) {
                runnable2.run();
            }

            public /* synthetic */ void onTransitionStart(Transition transition, boolean z4) {
                e.b(this, transition, z4);
            }
        });
    }

    public void setEpicenter(@NonNull Object obj, @NonNull final Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() {
                public Rect onGetEpicenter(@NonNull Transition transition) {
                    Rect rect = rect;
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}

package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.CarouselStrategy;
import com.google.android.material.carousel.KeylineState;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    /* renamed from: com.google.android.material.carousel.KeylineStateList$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType;

        static {
            int[] iArr = new int[CarouselStrategy.StrategyType.values().length];
            $SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType = iArr;
            try {
                iArr[CarouselStrategy.StrategyType.CONTAINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private KeylineStateList(@NonNull KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = DesugarCollections.unmodifiableList(list);
        this.endStateSteps = DesugarCollections.unmodifiableList(list2);
        float f5 = list.get(list.size() - 1).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f5;
        float f6 = keylineState.getLastKeyline().loc - list2.get(list2.size() - 1).getLastKeyline().loc;
        this.endShiftRange = f6;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f5, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f6, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f5, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f5, fArr);
        if (stateStepsRange[0] >= 0.5f) {
            return list.get((int) stateStepsRange[2]);
        }
        return list.get((int) stateStepsRange[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f5) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f5 == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int i5 = 0; i5 < keylineState.getKeylines().size(); i5++) {
            if (!keylineState.getKeylines().get(i5).isAnchor) {
                return i5;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f5) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f5 == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (!keylineState.getKeylines().get(size).isAnchor) {
                return size;
            }
        }
        return -1;
    }

    static KeylineStateList from(Carousel carousel, KeylineState keylineState, float f5, float f6, float f7, CarouselStrategy.StrategyType strategyType) {
        return new KeylineStateList(keylineState, getStateStepsStart(carousel, keylineState, f5, f6, strategyType), getStateStepsEnd(carousel, keylineState, f5, f7, strategyType));
    }

    private static float[] getStateStepInterpolationPoints(float f5, List<KeylineState> list, boolean z4) {
        float f6;
        float f7;
        int size = list.size();
        float[] fArr = new float[size];
        for (int i5 = 1; i5 < size; i5++) {
            int i6 = i5 - 1;
            KeylineState keylineState = list.get(i6);
            KeylineState keylineState2 = list.get(i5);
            if (z4) {
                f6 = keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
            } else {
                f6 = keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc;
            }
            float f8 = f6 / f5;
            if (i5 == size - 1) {
                f7 = 1.0f;
            } else {
                f7 = fArr[i6] + f8;
            }
            fArr[i5] = f7;
        }
        return fArr;
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState, float f5, float f6, CarouselStrategy.StrategyType strategyType) {
        int containerHeight;
        int i5;
        KeylineState keylineState2 = keylineState;
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState2);
        int findLastNonAnchorKeylineIndex = findLastNonAnchorKeylineIndex(keylineState2);
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        } else {
            containerHeight = carousel.getContainerHeight();
        }
        int i6 = containerHeight;
        if (isLastFocalItemVisibleAtRightOfContainer(carousel, keylineState) || findLastNonAnchorKeylineIndex == -1) {
            int i7 = i6;
            if (f6 > 0.0f) {
                arrayList.add(shiftKeylineStateForPadding(keylineState2, f6, i7, false, f5, strategyType));
            }
        } else {
            int lastFocalKeylineIndex = findLastNonAnchorKeylineIndex - keylineState2.getLastFocalKeylineIndex();
            float f7 = keylineState2.getFirstKeyline().locOffset - (keylineState2.getFirstKeyline().maskedItemSize / 2.0f);
            if (lastFocalKeylineIndex > 0 || keylineState2.getLastFocalKeyline().cutoff <= 0.0f) {
                float f8 = 0.0f;
                int i8 = 0;
                while (i8 < lastFocalKeylineIndex) {
                    KeylineState keylineState3 = (KeylineState) arrayList.get(arrayList.size() - 1);
                    int i9 = findLastNonAnchorKeylineIndex - i8;
                    float f9 = f8 + keylineState2.getKeylines().get(i9).cutoff;
                    int i10 = i9 + 1;
                    if (i10 < keylineState2.getKeylines().size()) {
                        i5 = findLastIndexBeforeFirstFocalKeylineWithMask(keylineState3, keylineState2.getKeylines().get(i10).mask) + 1;
                    } else {
                        i5 = 0;
                    }
                    int i11 = i6;
                    KeylineState keylineState4 = keylineState3;
                    int i12 = i5;
                    KeylineState keylineState5 = keylineState4;
                    KeylineState moveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState5, findLastNonAnchorKeylineIndex, i12, f7 - f9, keylineState2.getFirstFocalKeylineIndex() + i8 + 1, keylineState2.getLastFocalKeylineIndex() + i8 + 1, i11);
                    if (i8 == lastFocalKeylineIndex - 1 && f6 > 0.0f) {
                        int i13 = i11;
                        moveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(moveKeylineAndCreateKeylineState, f6, i13, false, f5, strategyType);
                        i11 = i13;
                    }
                    arrayList.add(moveKeylineAndCreateKeylineState);
                    i8++;
                    i6 = i11;
                    f8 = f9;
                }
            } else {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState2, (f7 - keylineState2.getLastFocalKeyline().cutoff) - f6, i6));
                return arrayList;
            }
        }
        return arrayList;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f5, float[] fArr) {
        int size = list.size();
        float f6 = fArr[0];
        int i5 = 1;
        while (i5 < size) {
            float f7 = fArr[i5];
            if (f5 <= f7) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f6, f7, f5), (float) (i5 - 1), (float) i5};
            }
            i5++;
            f6 = f7;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> getStateStepsStart(Carousel carousel, KeylineState keylineState, float f5, float f6, CarouselStrategy.StrategyType strategyType) {
        int containerHeight;
        KeylineState keylineState2 = keylineState;
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState2);
        int findFirstNonAnchorKeylineIndex = findFirstNonAnchorKeylineIndex(keylineState2);
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        } else {
            containerHeight = carousel.getContainerHeight();
        }
        int i5 = containerHeight;
        if (!isFirstFocalItemAtLeftOfContainer(keylineState2) && findFirstNonAnchorKeylineIndex != -1) {
            int firstFocalKeylineIndex = keylineState2.getFirstFocalKeylineIndex() - findFirstNonAnchorKeylineIndex;
            float f7 = keylineState2.getFirstKeyline().locOffset - (keylineState2.getFirstKeyline().maskedItemSize / 2.0f);
            if (firstFocalKeylineIndex > 0 || keylineState2.getFirstFocalKeyline().cutoff <= 0.0f) {
                float f8 = 0.0f;
                for (int i6 = 0; i6 < firstFocalKeylineIndex; i6++) {
                    KeylineState keylineState3 = (KeylineState) arrayList.get(arrayList.size() - 1);
                    int i7 = findFirstNonAnchorKeylineIndex + i6;
                    int size = keylineState2.getKeylines().size() - 1;
                    f8 += keylineState2.getKeylines().get(i7).cutoff;
                    int i8 = i7 - 1;
                    if (i8 >= 0) {
                        size = findFirstIndexAfterLastFocalKeylineWithMask(keylineState3, keylineState2.getKeylines().get(i8).mask) - 1;
                    }
                    int i9 = i5;
                    KeylineState moveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState3, findFirstNonAnchorKeylineIndex, size, f7 + f8, (keylineState2.getFirstFocalKeylineIndex() - i6) - 1, (keylineState2.getLastFocalKeylineIndex() - i6) - 1, i9);
                    i5 = i9;
                    if (i6 == firstFocalKeylineIndex - 1 && f6 > 0.0f) {
                        moveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(moveKeylineAndCreateKeylineState, f6, i5, true, f5, strategyType);
                    }
                    arrayList.add(moveKeylineAndCreateKeylineState);
                }
            } else {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState2, f7 + keylineState2.getFirstFocalKeyline().cutoff + f6, i5));
                return arrayList;
            }
        } else if (f6 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState2, f6, i5, true, f5, strategyType));
        }
        return arrayList;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        if (keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) < 0.0f || keylineState.getFirstFocalKeyline() != keylineState.getFirstNonAnchorKeyline()) {
            return false;
        }
        return true;
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        if (keylineState.getLastFocalKeyline().locOffset + (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) > ((float) containerHeight) || keylineState.getLastFocalKeyline() != keylineState.getLastNonAnchorKeyline()) {
            return false;
        }
        return true;
    }

    private static KeylineState lerp(List<KeylineState> list, float f5, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f5, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i5, int i6, float f5, int i7, int i8, int i9) {
        boolean z4;
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i6, (KeylineState.Keyline) arrayList.remove(i5));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i9);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i10);
            float f6 = keyline.maskedItemSize;
            float f7 = f5 + (f6 / 2.0f);
            if (i10 < i7 || i10 > i8) {
                z4 = false;
            } else {
                z4 = true;
            }
            builder.addKeyline(f7, keyline.mask, f6, z4, keyline.isAnchor, keyline.cutoff);
            f5 += keyline.maskedItemSize;
        }
        return builder.build();
    }

    @NonNull
    private static KeylineState shiftKeylineStateForPadding(@NonNull KeylineState keylineState, float f5, int i5, boolean z4, float f6, CarouselStrategy.StrategyType strategyType) {
        if (AnonymousClass1.$SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType[strategyType.ordinal()] != 1) {
            return shiftKeylineStateForPaddingUncontained(keylineState, f5, i5, z4);
        }
        return shiftKeylineStateForPaddingContained(keylineState, f5, i5, z4, f6);
    }

    private static KeylineState shiftKeylineStateForPaddingContained(KeylineState keylineState, float f5, int i5, boolean z4, float f6) {
        float f7;
        boolean z5;
        float f8;
        float f9;
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i5);
        float numberOfNonAnchorKeylines = f5 / ((float) keylineState.getNumberOfNonAnchorKeylines());
        if (z4) {
            f7 = f5;
        } else {
            f7 = 0.0f;
        }
        float f10 = f7;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i6);
            if (keyline.isAnchor) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
                float f11 = f6;
            } else {
                if (i6 < keylineState.getFirstFocalKeylineIndex() || i6 > keylineState.getLastFocalKeylineIndex()) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                float f12 = keyline.maskedItemSize - numberOfNonAnchorKeylines;
                float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(f12, keylineState.getItemSize(), f6);
                float f13 = (f12 / 2.0f) + f10;
                float abs = Math.abs(f13 - keyline.locOffset);
                float f14 = keyline.cutoff;
                if (z4) {
                    f8 = abs;
                } else {
                    f8 = 0.0f;
                }
                if (z4) {
                    f9 = 0.0f;
                } else {
                    f9 = abs;
                }
                builder.addKeyline(f13, childMaskPercentage, f12, z5, false, f14, f8, f9);
                f10 += f12;
            }
        }
        return builder.build();
    }

    @NonNull
    private static KeylineState shiftKeylineStateForPaddingUncontained(@NonNull KeylineState keylineState, float f5, int i5, boolean z4) {
        int i6;
        float f6;
        float f7;
        float f8;
        boolean z5;
        float f9;
        int i7 = i5;
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i7);
        boolean z6 = true;
        if (z4) {
            i6 = 0;
        } else {
            i6 = arrayList.size() - 1;
        }
        int i8 = 0;
        while (i8 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i8);
            if (!keyline.isAnchor || i8 != i6) {
                float f10 = keyline.locOffset;
                if (z4) {
                    f6 = f10 + f5;
                } else {
                    f6 = f10 - f5;
                }
                if (z4) {
                    f7 = f5;
                } else {
                    f7 = 0.0f;
                }
                if (z4) {
                    f8 = 0.0f;
                } else {
                    f8 = f5;
                }
                if (i8 < keylineState.getFirstFocalKeylineIndex() || i8 > keylineState.getLastFocalKeylineIndex()) {
                    z5 = false;
                } else {
                    z5 = z6;
                }
                float f11 = f6;
                float f12 = keyline.mask;
                float f13 = keyline.maskedItemSize;
                boolean z7 = keyline.isAnchor;
                if (z4) {
                    f9 = Math.max(0.0f, ((f13 / 2.0f) + f11) - ((float) i7));
                } else {
                    f9 = Math.min(0.0f, f11 - (f13 / 2.0f));
                }
                builder.addKeyline(f11, f12, f13, z5, z7, Math.abs(f9), f7, f8);
            } else {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            }
            i8++;
            z6 = true;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState keylineState, float f5, int i5) {
        return moveKeylineAndCreateKeylineState(keylineState, 0, 0, f5, keylineState.getFirstFocalKeylineIndex(), keylineState.getLastFocalKeylineIndex(), i5);
    }

    /* access modifiers changed from: package-private */
    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    /* access modifiers changed from: package-private */
    public KeylineState getEndState() {
        List<KeylineState> list = this.endStateSteps;
        return list.get(list.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public Map<Integer, KeylineState> getKeylineStateForPositionMap(int i5, int i6, int i7, boolean z4) {
        int i8;
        int i9;
        int i10;
        float itemSize = this.defaultState.getItemSize();
        HashMap hashMap = new HashMap();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = -1;
            if (i11 >= i5) {
                break;
            }
            if (z4) {
                i10 = (i5 - i11) - 1;
            } else {
                i10 = i11;
            }
            float f5 = ((float) i10) * itemSize;
            if (!z4) {
                i13 = 1;
            }
            if (f5 * ((float) i13) > ((float) i7) - this.endShiftRange || i11 >= i5 - this.endStateSteps.size()) {
                Integer valueOf = Integer.valueOf(i10);
                List<KeylineState> list = this.endStateSteps;
                hashMap.put(valueOf, list.get(MathUtils.clamp(i12, 0, list.size() - 1)));
                i12++;
            }
            i11++;
        }
        int i14 = 0;
        for (int i15 = i5 - 1; i15 >= 0; i15--) {
            if (z4) {
                i8 = (i5 - i15) - 1;
            } else {
                i8 = i15;
            }
            float f6 = ((float) i8) * itemSize;
            if (z4) {
                i9 = -1;
            } else {
                i9 = 1;
            }
            if (f6 * ((float) i9) < ((float) i6) + this.startShiftRange || i15 < this.startStateSteps.size()) {
                Integer valueOf2 = Integer.valueOf(i8);
                List<KeylineState> list2 = this.startStateSteps;
                hashMap.put(valueOf2, list2.get(MathUtils.clamp(i14, 0, list2.size() - 1)));
                i14++;
            }
        }
        return hashMap;
    }

    @NonNull
    public KeylineState getShiftedState(float f5, float f6, float f7) {
        return getShiftedState(f5, f6, f7, false);
    }

    /* access modifiers changed from: package-private */
    public KeylineState getStartState() {
        List<KeylineState> list = this.startStateSteps;
        return list.get(list.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public KeylineState getShiftedState(float f5, float f6, float f7, boolean z4) {
        float[] fArr;
        List<KeylineState> list;
        float f8;
        float f9 = this.startShiftRange + f6;
        float f10 = f7 - this.endShiftRange;
        float f11 = getStartState().getFirstFocalKeyline().leftOrTopPaddingShift;
        float f12 = getEndState().getFirstFocalKeyline().rightOrBottomPaddingShift;
        if (this.startShiftRange == f11) {
            f9 += f11;
        }
        if (this.endShiftRange == f12) {
            f10 -= f12;
        }
        if (f5 < f9) {
            f8 = AnimationUtils.lerp(1.0f, 0.0f, f6, f9, f5);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else if (f5 <= f10) {
            return this.defaultState;
        } else {
            f8 = AnimationUtils.lerp(0.0f, 1.0f, f10, f7, f5);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        if (z4) {
            return closestStateStepFromInterpolation(list, f8, fArr);
        }
        return lerp(list, f8, fArr);
    }
}

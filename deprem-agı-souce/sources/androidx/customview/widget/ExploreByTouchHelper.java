package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() {
        public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    };
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() {
        public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i5) {
            return sparseArrayCompat.valueAt(i5);
        }

        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    };
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    private final View mHost;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect = new int[2];
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();

    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i5) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i5));
        }

        public AccessibilityNodeInfoCompat findFocus(int i5) {
            int i6;
            if (i5 == 2) {
                i6 = ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId;
            } else {
                i6 = ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            }
            if (i6 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i6);
        }

        public boolean performAction(int i5, int i6, Bundle bundle) {
            return ExploreByTouchHelper.this.performAction(i5, i6, bundle);
        }
    }

    public ExploreByTouchHelper(@NonNull View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int i5) {
        if (this.mAccessibilityFocusedVirtualViewId != i5) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(i5, 65536);
        return true;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i5 = this.mKeyboardFocusedVirtualViewId;
        if (i5 == Integer.MIN_VALUE || !onPerformActionForVirtualView(i5, 16, (Bundle) null)) {
            return false;
        }
        return true;
    }

    private AccessibilityEvent createEvent(int i5, int i6) {
        if (i5 != -1) {
            return createEventForChild(i5, i6);
        }
        return createEventForHost(i6);
    }

    private AccessibilityEvent createEventForChild(int i5, int i6) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i6);
        AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i5);
        obtain.getText().add(obtainAccessibilityNodeInfo.getText());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.getContentDescription());
        obtain.setScrollable(obtainAccessibilityNodeInfo.isScrollable());
        obtain.setPassword(obtainAccessibilityNodeInfo.isPassword());
        obtain.setEnabled(obtainAccessibilityNodeInfo.isEnabled());
        obtain.setChecked(obtainAccessibilityNodeInfo.isChecked());
        onPopulateEventForVirtualView(i5, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(obtainAccessibilityNodeInfo.getClassName());
            AccessibilityRecordCompat.setSource(obtain, this.mHost, i5);
            obtain.setPackageName(this.mHost.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private AccessibilityEvent createEventForHost(int i5) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i5);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForChild(int i5) {
        boolean z4;
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName(DEFAULT_CLASS_NAME);
        Rect rect = INVALID_PARENT_BOUNDS;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        obtain.setParent(this.mHost);
        onPopulateNodeForVirtualView(i5, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.mTempParentRect);
        if (!this.mTempParentRect.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((actions & 128) == 0) {
                obtain.setPackageName(this.mHost.getContext().getPackageName());
                obtain.setSource(this.mHost, i5);
                if (this.mAccessibilityFocusedVirtualViewId == i5) {
                    obtain.setAccessibilityFocused(true);
                    obtain.addAction(128);
                } else {
                    obtain.setAccessibilityFocused(false);
                    obtain.addAction(64);
                }
                if (this.mKeyboardFocusedVirtualViewId == i5) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    obtain.addAction(2);
                } else if (obtain.isFocusable()) {
                    obtain.addAction(1);
                }
                obtain.setFocused(z4);
                this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                obtain.getBoundsInScreen(this.mTempScreenRect);
                if (this.mTempScreenRect.equals(rect)) {
                    obtain.getBoundsInParent(this.mTempScreenRect);
                    if (obtain.mParentVirtualDescendantId != -1) {
                        AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                        for (int i6 = obtain.mParentVirtualDescendantId; i6 != -1; i6 = obtain2.mParentVirtualDescendantId) {
                            obtain2.setParent(this.mHost, -1);
                            obtain2.setBoundsInParent(INVALID_PARENT_BOUNDS);
                            onPopulateNodeForVirtualView(i6, obtain2);
                            obtain2.getBoundsInParent(this.mTempParentRect);
                            Rect rect2 = this.mTempScreenRect;
                            Rect rect3 = this.mTempParentRect;
                            rect2.offset(rect3.left, rect3.top);
                        }
                        obtain2.recycle();
                    }
                    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                }
                if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                    this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                        obtain.setBoundsInScreen(this.mTempScreenRect);
                        if (isVisibleToUser(this.mTempScreenRect)) {
                            obtain.setVisibleToUser(true);
                        }
                    }
                }
                return obtain;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, obtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (obtain.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                obtain.addChild(this.mHost, ((Integer) arrayList.get(i5)).intValue());
            }
            return obtain;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            sparseArrayCompat.put(((Integer) arrayList.get(i5)).intValue(), createNodeForChild(((Integer) arrayList.get(i5)).intValue()));
        }
        return sparseArrayCompat;
    }

    private void getBoundsInParent(int i5, Rect rect) {
        obtainAccessibilityNodeInfo(i5).getBoundsInParent(rect);
    }

    private static Rect guessPreviouslyFocusedRect(@NonNull View view, int i5, @NonNull Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i5 == 17) {
            rect.set(width, 0, width, height);
            return rect;
        } else if (i5 == 33) {
            rect.set(0, height, width, height);
            return rect;
        } else if (i5 == 66) {
            rect.set(-1, 0, -1, height);
            return rect;
        } else if (i5 == 130) {
            rect.set(0, -1, width, -1);
            return rect;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            return true;
        }
        return false;
    }

    private static int keyToDirection(int i5) {
        if (i5 == 19) {
            return 33;
        }
        if (i5 == 21) {
            return 17;
        }
        if (i5 != 22) {
            return TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        }
        return 66;
    }

    private boolean moveFocus(int i5, @Nullable Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = getAllNodes();
        int i6 = this.mKeyboardFocusedVirtualViewId;
        int i7 = Integer.MIN_VALUE;
        if (i6 == Integer.MIN_VALUE) {
            accessibilityNodeInfoCompat = null;
        } else {
            accessibilityNodeInfoCompat = allNodes.get(i6);
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat;
        boolean z4 = true;
        if (i5 == 1 || i5 == 2) {
            int i8 = i5;
            if (ViewCompat.getLayoutDirection(this.mHost) != 1) {
                z4 = false;
            }
            accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat3, i8, z4, false);
        } else if (i5 == 17 || i5 == 33 || i5 == 66 || i5 == 130) {
            Rect rect2 = new Rect();
            int i9 = this.mKeyboardFocusedVirtualViewId;
            if (i9 != Integer.MIN_VALUE) {
                getBoundsInParent(i9, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i5, rect2);
            }
            accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat3, rect2, i5);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (accessibilityNodeInfoCompat2 != null) {
            i7 = allNodes.keyAt(allNodes.indexOfValue(accessibilityNodeInfoCompat2));
        }
        return requestKeyboardFocusForVirtualView(i7);
    }

    private boolean performActionForChild(int i5, int i6, Bundle bundle) {
        if (i6 == 1) {
            return requestKeyboardFocusForVirtualView(i5);
        }
        if (i6 == 2) {
            return clearKeyboardFocusForVirtualView(i5);
        }
        if (i6 == 64) {
            return requestAccessibilityFocus(i5);
        }
        if (i6 != 128) {
            return onPerformActionForVirtualView(i5, i6, bundle);
        }
        return clearAccessibilityFocus(i5);
    }

    private boolean performActionForHost(int i5, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.mHost, i5, bundle);
    }

    private boolean requestAccessibilityFocus(int i5) {
        int i6;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i6 = this.mAccessibilityFocusedVirtualViewId) == i5) {
            return false;
        }
        if (i6 != Integer.MIN_VALUE) {
            clearAccessibilityFocus(i6);
        }
        this.mAccessibilityFocusedVirtualViewId = i5;
        this.mHost.invalidate();
        sendEventForVirtualView(i5, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int i5) {
        int i6 = this.mHoveredVirtualViewId;
        if (i6 != i5) {
            this.mHoveredVirtualViewId = i5;
            sendEventForVirtualView(i5, 128);
            sendEventForVirtualView(i6, 256);
        }
    }

    public final boolean clearKeyboardFocusForVirtualView(int i5) {
        if (this.mKeyboardFocusedVirtualViewId != i5) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i5, false);
        sendEventForVirtualView(i5, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                updateHoveredVirtualView(virtualViewAt);
                if (virtualViewAt != Integer.MIN_VALUE) {
                    return true;
                }
            } else if (action != 10 || this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
                return false;
            } else {
                updateHoveredVirtualView(Integer.MIN_VALUE);
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        int i5 = 0;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                int keyToDirection = keyToDirection(keyCode);
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z4 = false;
                                while (i5 < repeatCount && moveFocus(keyToDirection, (Rect) null)) {
                                    i5++;
                                    z4 = true;
                                }
                                return z4;
                            }
                            break;
                        case 23:
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    clickKeyboardFocusedVirtualView();
                    return true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                return moveFocus(2, (Rect) null);
            } else {
                if (keyEvent.hasModifiers(1)) {
                    return moveFocus(1, (Rect) null);
                }
            }
        }
        return false;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    /* access modifiers changed from: protected */
    public abstract int getVirtualViewAt(float f5, float f6);

    /* access modifiers changed from: protected */
    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i5) {
        invalidateVirtualView(i5, 0);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i5) {
        if (i5 == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i5);
    }

    public final void onFocusChanged(boolean z4, int i5, @Nullable Rect rect) {
        int i6 = this.mKeyboardFocusedVirtualViewId;
        if (i6 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i6);
        }
        if (z4) {
            moveFocus(i5, rect);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    /* access modifiers changed from: protected */
    public abstract boolean onPerformActionForVirtualView(int i5, int i6, @Nullable Bundle bundle);

    /* access modifiers changed from: protected */
    public void onPopulateEventForHost(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateEventForVirtualView(int i5, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    /* access modifiers changed from: protected */
    public abstract void onPopulateNodeForVirtualView(int i5, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    /* access modifiers changed from: protected */
    public void onVirtualViewKeyboardFocusChanged(int i5, boolean z4) {
    }

    /* access modifiers changed from: package-private */
    public boolean performAction(int i5, int i6, Bundle bundle) {
        if (i5 != -1) {
            return performActionForChild(i5, i6, bundle);
        }
        return performActionForHost(i6, bundle);
    }

    public final boolean requestKeyboardFocusForVirtualView(int i5) {
        int i6;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i6 = this.mKeyboardFocusedVirtualViewId) == i5) {
            return false;
        }
        if (i6 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i6);
        }
        if (i5 == Integer.MIN_VALUE) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = i5;
        onVirtualViewKeyboardFocusChanged(i5, true);
        sendEventForVirtualView(i5, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i5, int i6) {
        ViewParent parent;
        if (i5 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.mHost, createEvent(i5, i6));
    }

    public final void invalidateVirtualView(int i5, int i6) {
        ViewParent parent;
        if (i5 != Integer.MIN_VALUE && this.mManager.isEnabled() && (parent = this.mHost.getParent()) != null) {
            AccessibilityEvent createEvent = createEvent(i5, 2048);
            AccessibilityEventCompat.setContentChangeTypes(createEvent, i6);
            parent.requestSendAccessibilityEvent(this.mHost, createEvent);
        }
    }
}

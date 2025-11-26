package androidx.leanback.widget;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.GuidedActionAutofillSupport;
import androidx.leanback.widget.GuidedActionsStylist;
import androidx.leanback.widget.ImeKeyMonitor;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class GuidedActionAdapter extends RecyclerView.Adapter {
    static final boolean DEBUG = false;
    static final boolean DEBUG_EDIT = false;
    static final String TAG = "GuidedActionAdapter";
    static final String TAG_EDIT = "EditableAction";
    private final ActionAutofillListener mActionAutofillListener;
    private final ActionEditListener mActionEditListener;
    private final ActionOnFocusListener mActionOnFocusListener;
    private final ActionOnKeyListener mActionOnKeyListener;
    final List<GuidedAction> mActions;
    private ClickListener mClickListener;
    DiffCallback<GuidedAction> mDiffCallback;
    GuidedActionAdapterGroup mGroup;
    private final boolean mIsSubAdapter;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            if (view != null && view.getWindowToken() != null && GuidedActionAdapter.this.mRecyclerView.isAttachedToWindow()) {
                GuidedActionsStylist.ViewHolder viewHolder = (GuidedActionsStylist.ViewHolder) GuidedActionAdapter.this.mRecyclerView.getChildViewHolder(view);
                GuidedAction action = viewHolder.getAction();
                if (action.hasTextEditable()) {
                    GuidedActionAdapter guidedActionAdapter = GuidedActionAdapter.this;
                    guidedActionAdapter.mGroup.openIme(guidedActionAdapter, viewHolder);
                } else if (action.hasEditableActivatorView()) {
                    GuidedActionAdapter.this.performOnActionClick(viewHolder);
                } else {
                    GuidedActionAdapter.this.handleCheckedActions(viewHolder);
                    if (action.isEnabled() && !action.infoOnly()) {
                        GuidedActionAdapter.this.performOnActionClick(viewHolder);
                    }
                }
            }
        }
    };
    final RecyclerView mRecyclerView;
    final GuidedActionsStylist mStylist;

    private class ActionAutofillListener implements GuidedActionAutofillSupport.OnAutofillListener {
        ActionAutofillListener() {
        }

        public void onAutofill(View view) {
            GuidedActionAdapter guidedActionAdapter = GuidedActionAdapter.this;
            guidedActionAdapter.mGroup.fillAndGoNext(guidedActionAdapter, (EditText) view);
        }
    }

    private class ActionEditListener implements TextView.OnEditorActionListener, ImeKeyMonitor.ImeKeyListener {
        ActionEditListener() {
        }

        public boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
            if (i5 == 5 || i5 == 6) {
                GuidedActionAdapter guidedActionAdapter = GuidedActionAdapter.this;
                guidedActionAdapter.mGroup.fillAndGoNext(guidedActionAdapter, textView);
                return true;
            } else if (i5 != 1) {
                return false;
            } else {
                GuidedActionAdapter guidedActionAdapter2 = GuidedActionAdapter.this;
                guidedActionAdapter2.mGroup.fillAndStay(guidedActionAdapter2, textView);
                return true;
            }
        }

        public boolean onKeyPreIme(EditText editText, int i5, KeyEvent keyEvent) {
            if (i5 == 4 && keyEvent.getAction() == 1) {
                GuidedActionAdapter guidedActionAdapter = GuidedActionAdapter.this;
                guidedActionAdapter.mGroup.fillAndStay(guidedActionAdapter, editText);
                return true;
            } else if (i5 != 66 || keyEvent.getAction() != 1) {
                return false;
            } else {
                GuidedActionAdapter guidedActionAdapter2 = GuidedActionAdapter.this;
                guidedActionAdapter2.mGroup.fillAndGoNext(guidedActionAdapter2, editText);
                return true;
            }
        }
    }

    private class ActionOnFocusListener implements View.OnFocusChangeListener {
        private FocusListener mFocusListener;
        private View mSelectedView;

        ActionOnFocusListener(FocusListener focusListener) {
            this.mFocusListener = focusListener;
        }

        public void onFocusChange(View view, boolean z4) {
            if (GuidedActionAdapter.this.mRecyclerView.isAttachedToWindow()) {
                GuidedActionsStylist.ViewHolder viewHolder = (GuidedActionsStylist.ViewHolder) GuidedActionAdapter.this.mRecyclerView.getChildViewHolder(view);
                if (z4) {
                    this.mSelectedView = view;
                    FocusListener focusListener = this.mFocusListener;
                    if (focusListener != null) {
                        focusListener.onGuidedActionFocused(viewHolder.getAction());
                    }
                } else if (this.mSelectedView == view) {
                    GuidedActionAdapter.this.mStylist.onAnimateItemPressedCancelled(viewHolder);
                    this.mSelectedView = null;
                }
                GuidedActionAdapter.this.mStylist.onAnimateItemFocused(viewHolder, z4);
            }
        }

        public void setFocusListener(FocusListener focusListener) {
            this.mFocusListener = focusListener;
        }

        public void unFocus() {
            if (this.mSelectedView != null && GuidedActionAdapter.this.mRecyclerView.isAttachedToWindow()) {
                RecyclerView.ViewHolder childViewHolder = GuidedActionAdapter.this.mRecyclerView.getChildViewHolder(this.mSelectedView);
                if (childViewHolder != null) {
                    GuidedActionAdapter.this.mStylist.onAnimateItemFocused((GuidedActionsStylist.ViewHolder) childViewHolder, false);
                    return;
                }
                Log.w(GuidedActionAdapter.TAG, "RecyclerView returned null view holder", new Throwable());
            }
        }
    }

    private class ActionOnKeyListener implements View.OnKeyListener {
        private boolean mKeyPressed = false;

        ActionOnKeyListener() {
        }

        public boolean onKey(View view, int i5, KeyEvent keyEvent) {
            if (view == null || keyEvent == null || !GuidedActionAdapter.this.mRecyclerView.isAttachedToWindow()) {
                return false;
            }
            if (i5 == 23 || i5 == 66 || i5 == 160 || i5 == 99 || i5 == 100) {
                GuidedActionsStylist.ViewHolder viewHolder = (GuidedActionsStylist.ViewHolder) GuidedActionAdapter.this.mRecyclerView.getChildViewHolder(view);
                GuidedAction action = viewHolder.getAction();
                if (!action.isEnabled() || action.infoOnly()) {
                    keyEvent.getAction();
                    return true;
                }
                int action2 = keyEvent.getAction();
                if (action2 != 0) {
                    if (action2 == 1 && this.mKeyPressed) {
                        this.mKeyPressed = false;
                        GuidedActionAdapter.this.mStylist.onAnimateItemPressed(viewHolder, false);
                        return false;
                    }
                } else if (!this.mKeyPressed) {
                    this.mKeyPressed = true;
                    GuidedActionAdapter.this.mStylist.onAnimateItemPressed(viewHolder, true);
                }
            }
            return false;
        }
    }

    public interface ClickListener {
        void onGuidedActionClicked(GuidedAction guidedAction);
    }

    public interface EditListener {
        void onGuidedActionEditCanceled(GuidedAction guidedAction);

        long onGuidedActionEditedAndProceed(GuidedAction guidedAction);

        void onImeClose();

        void onImeOpen();
    }

    public interface FocusListener {
        void onGuidedActionFocused(GuidedAction guidedAction);
    }

    public GuidedActionAdapter(List<GuidedAction> list, ClickListener clickListener, FocusListener focusListener, GuidedActionsStylist guidedActionsStylist, boolean z4) {
        ArrayList arrayList;
        VerticalGridView verticalGridView;
        if (list == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(list);
        }
        this.mActions = arrayList;
        this.mClickListener = clickListener;
        this.mStylist = guidedActionsStylist;
        this.mActionOnKeyListener = new ActionOnKeyListener();
        this.mActionOnFocusListener = new ActionOnFocusListener(focusListener);
        this.mActionEditListener = new ActionEditListener();
        this.mActionAutofillListener = new ActionAutofillListener();
        this.mIsSubAdapter = z4;
        if (!z4) {
            this.mDiffCallback = GuidedActionDiffCallback.getInstance();
        }
        if (z4) {
            verticalGridView = guidedActionsStylist.getSubActionsGridView();
        } else {
            verticalGridView = guidedActionsStylist.getActionsGridView();
        }
        this.mRecyclerView = verticalGridView;
    }

    private void setupListeners(EditText editText) {
        if (editText != null) {
            editText.setPrivateImeOptions("escapeNorth");
            editText.setOnEditorActionListener(this.mActionEditListener);
            if (editText instanceof ImeKeyMonitor) {
                ((ImeKeyMonitor) editText).setImeKeyListener(this.mActionEditListener);
            }
            if (editText instanceof GuidedActionAutofillSupport) {
                ((GuidedActionAutofillSupport) editText).setOnAutofillListener(this.mActionAutofillListener);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.leanback.widget.GuidedActionsStylist.ViewHolder findSubChildViewHolder(android.view.View r4) {
        /*
            r3 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r3.mRecyclerView
            boolean r0 = r0.isAttachedToWindow()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            android.view.ViewParent r0 = r4.getParent()
        L_0x000e:
            androidx.recyclerview.widget.RecyclerView r2 = r3.mRecyclerView
            if (r0 == r2) goto L_0x001c
            if (r0 == 0) goto L_0x001c
            r4 = r0
            android.view.View r4 = (android.view.View) r4
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x000e
        L_0x001c:
            if (r0 == 0) goto L_0x0025
            androidx.recyclerview.widget.RecyclerView$ViewHolder r4 = r2.getChildViewHolder(r4)
            androidx.leanback.widget.GuidedActionsStylist$ViewHolder r4 = (androidx.leanback.widget.GuidedActionsStylist.ViewHolder) r4
            return r4
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GuidedActionAdapter.findSubChildViewHolder(android.view.View):androidx.leanback.widget.GuidedActionsStylist$ViewHolder");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public List<GuidedAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public int getCount() {
        return this.mActions.size();
    }

    public GuidedActionsStylist getGuidedActionsStylist() {
        return this.mStylist;
    }

    public GuidedAction getItem(int i5) {
        return this.mActions.get(i5);
    }

    public int getItemCount() {
        return this.mActions.size();
    }

    public int getItemViewType(int i5) {
        return this.mStylist.getItemViewType(this.mActions.get(i5));
    }

    public void handleCheckedActions(GuidedActionsStylist.ViewHolder viewHolder) {
        GuidedAction action = viewHolder.getAction();
        int checkSetId = action.getCheckSetId();
        if (this.mRecyclerView.isAttachedToWindow() && checkSetId != 0) {
            if (checkSetId != -1) {
                int size = this.mActions.size();
                for (int i5 = 0; i5 < size; i5++) {
                    GuidedAction guidedAction = this.mActions.get(i5);
                    if (guidedAction != action && guidedAction.getCheckSetId() == checkSetId && guidedAction.isChecked()) {
                        guidedAction.setChecked(false);
                        GuidedActionsStylist.ViewHolder viewHolder2 = (GuidedActionsStylist.ViewHolder) this.mRecyclerView.findViewHolderForPosition(i5);
                        if (viewHolder2 != null) {
                            this.mStylist.onAnimateItemChecked(viewHolder2, false);
                        }
                    }
                }
            }
            if (!action.isChecked()) {
                action.setChecked(true);
                this.mStylist.onAnimateItemChecked(viewHolder, true);
            } else if (checkSetId == -1) {
                action.setChecked(false);
                this.mStylist.onAnimateItemChecked(viewHolder, false);
            }
        }
    }

    public int indexOf(GuidedAction guidedAction) {
        return this.mActions.indexOf(guidedAction);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        if (i5 < this.mActions.size()) {
            this.mStylist.onBindViewHolder((GuidedActionsStylist.ViewHolder) viewHolder, this.mActions.get(i5));
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        GuidedActionsStylist.ViewHolder onCreateViewHolder = this.mStylist.onCreateViewHolder(viewGroup, i5);
        View view = onCreateViewHolder.itemView;
        view.setOnKeyListener(this.mActionOnKeyListener);
        view.setOnClickListener(this.mOnClickListener);
        view.setOnFocusChangeListener(this.mActionOnFocusListener);
        setupListeners(onCreateViewHolder.getEditableTitleView());
        setupListeners(onCreateViewHolder.getEditableDescriptionView());
        return onCreateViewHolder;
    }

    public void performOnActionClick(GuidedActionsStylist.ViewHolder viewHolder) {
        ClickListener clickListener = this.mClickListener;
        if (clickListener != null) {
            clickListener.onGuidedActionClicked(viewHolder.getAction());
        }
    }

    public void setActions(List<GuidedAction> list) {
        if (!this.mIsSubAdapter) {
            this.mStylist.collapseAction(false);
        }
        this.mActionOnFocusListener.unFocus();
        if (this.mDiffCallback != null) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mActions);
            this.mActions.clear();
            this.mActions.addAll(list);
            DiffUtil.calculateDiff(new DiffUtil.Callback() {
                public boolean areContentsTheSame(int i5, int i6) {
                    return GuidedActionAdapter.this.mDiffCallback.areContentsTheSame((GuidedAction) arrayList.get(i5), GuidedActionAdapter.this.mActions.get(i6));
                }

                public boolean areItemsTheSame(int i5, int i6) {
                    return GuidedActionAdapter.this.mDiffCallback.areItemsTheSame((GuidedAction) arrayList.get(i5), GuidedActionAdapter.this.mActions.get(i6));
                }

                public Object getChangePayload(int i5, int i6) {
                    return GuidedActionAdapter.this.mDiffCallback.getChangePayload((GuidedAction) arrayList.get(i5), GuidedActionAdapter.this.mActions.get(i6));
                }

                public int getNewListSize() {
                    return GuidedActionAdapter.this.mActions.size();
                }

                public int getOldListSize() {
                    return arrayList.size();
                }
            }).dispatchUpdatesTo((RecyclerView.Adapter) this);
            return;
        }
        this.mActions.clear();
        this.mActions.addAll(list);
        notifyDataSetChanged();
    }

    public void setClickListener(ClickListener clickListener) {
        this.mClickListener = clickListener;
    }

    public void setDiffCallback(DiffCallback<GuidedAction> diffCallback) {
        this.mDiffCallback = diffCallback;
    }

    public void setFocusListener(FocusListener focusListener) {
        this.mActionOnFocusListener.setFocusListener(focusListener);
    }
}

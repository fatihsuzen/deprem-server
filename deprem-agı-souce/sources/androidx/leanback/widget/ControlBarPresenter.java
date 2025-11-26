package androidx.leanback.widget;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.R;
import androidx.leanback.widget.ControlBar;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Presenter;

class ControlBarPresenter extends Presenter {
    static final int MAX_CONTROLS = 7;
    private static int sChildMarginDefault;
    private static int sControlIconWidth;
    boolean mDefaultFocusToMiddle = true;
    private int mLayoutResourceId;
    OnControlClickedListener mOnControlClickedListener;
    OnControlSelectedListener mOnControlSelectedListener;

    static class BoundData {
        ObjectAdapter adapter;
        Presenter presenter;

        BoundData() {
        }
    }

    interface OnControlClickedListener {
        void onControlClicked(Presenter.ViewHolder viewHolder, Object obj, BoundData boundData);
    }

    interface OnControlSelectedListener {
        void onControlSelected(Presenter.ViewHolder viewHolder, Object obj, BoundData boundData);
    }

    class ViewHolder extends Presenter.ViewHolder {
        ObjectAdapter mAdapter;
        ControlBar mControlBar;
        View mControlsContainer;
        BoundData mData;
        ObjectAdapter.DataObserver mDataObserver;
        Presenter mPresenter;
        SparseArray<Presenter.ViewHolder> mViewHolders = new SparseArray<>();

        ViewHolder(View view) {
            super(view);
            this.mControlsContainer = view.findViewById(R.id.controls_container);
            ControlBar controlBar = (ControlBar) view.findViewById(R.id.control_bar);
            this.mControlBar = controlBar;
            if (controlBar != null) {
                controlBar.setDefaultFocusToMiddle(ControlBarPresenter.this.mDefaultFocusToMiddle);
                this.mControlBar.setOnChildFocusedListener(new ControlBar.OnChildFocusedListener(ControlBarPresenter.this) {
                    public void onChildFocusedListener(View view, View view2) {
                        if (ControlBarPresenter.this.mOnControlSelectedListener != null) {
                            for (int i5 = 0; i5 < ViewHolder.this.mViewHolders.size(); i5++) {
                                if (ViewHolder.this.mViewHolders.get(i5).view == view) {
                                    ViewHolder viewHolder = ViewHolder.this;
                                    ControlBarPresenter.this.mOnControlSelectedListener.onControlSelected(viewHolder.mViewHolders.get(i5), ViewHolder.this.getDisplayedAdapter().get(i5), ViewHolder.this.mData);
                                    return;
                                }
                            }
                        }
                    }
                });
                this.mDataObserver = new ObjectAdapter.DataObserver(ControlBarPresenter.this) {
                    public void onChanged() {
                        ViewHolder viewHolder = ViewHolder.this;
                        if (viewHolder.mAdapter == viewHolder.getDisplayedAdapter()) {
                            ViewHolder viewHolder2 = ViewHolder.this;
                            viewHolder2.showControls(viewHolder2.mPresenter);
                        }
                    }

                    public void onItemRangeChanged(int i5, int i6) {
                        ViewHolder viewHolder = ViewHolder.this;
                        if (viewHolder.mAdapter == viewHolder.getDisplayedAdapter()) {
                            for (int i7 = 0; i7 < i6; i7++) {
                                ViewHolder viewHolder2 = ViewHolder.this;
                                viewHolder2.bindControlToAction(i5 + i7, viewHolder2.mPresenter);
                            }
                        }
                    }
                };
                return;
            }
            throw new IllegalStateException("Couldn't find control_bar");
        }

        /* access modifiers changed from: package-private */
        public void bindControlToAction(int i5, Presenter presenter) {
            bindControlToAction(i5, getDisplayedAdapter(), presenter);
        }

        /* access modifiers changed from: package-private */
        public int getChildMarginFromCenter(Context context, int i5) {
            return ControlBarPresenter.this.getChildMarginDefault(context) + ControlBarPresenter.this.getControlIconWidth(context);
        }

        /* access modifiers changed from: package-private */
        public ObjectAdapter getDisplayedAdapter() {
            return this.mAdapter;
        }

        /* access modifiers changed from: package-private */
        public void showControls(Presenter presenter) {
            int i5;
            ObjectAdapter displayedAdapter = getDisplayedAdapter();
            int i6 = 0;
            if (displayedAdapter == null) {
                i5 = 0;
            } else {
                i5 = displayedAdapter.size();
            }
            View focusedChild = this.mControlBar.getFocusedChild();
            if (focusedChild != null && i5 > 0 && this.mControlBar.indexOfChild(focusedChild) >= i5) {
                this.mControlBar.getChildAt(displayedAdapter.size() - 1).requestFocus();
            }
            for (int childCount = this.mControlBar.getChildCount() - 1; childCount >= i5; childCount--) {
                this.mControlBar.removeViewAt(childCount);
            }
            while (i6 < i5 && i6 < 7) {
                bindControlToAction(i6, displayedAdapter, presenter);
                i6++;
            }
            ControlBar controlBar = this.mControlBar;
            controlBar.setChildMarginFromCenter(getChildMarginFromCenter(controlBar.getContext(), i5));
        }

        private void bindControlToAction(final int i5, ObjectAdapter objectAdapter, Presenter presenter) {
            final Presenter.ViewHolder viewHolder = this.mViewHolders.get(i5);
            Object obj = objectAdapter.get(i5);
            if (viewHolder == null) {
                viewHolder = presenter.onCreateViewHolder(this.mControlBar);
                this.mViewHolders.put(i5, viewHolder);
                presenter.setOnClickListener(viewHolder, new View.OnClickListener() {
                    public void onClick(View view) {
                        Object obj = ViewHolder.this.getDisplayedAdapter().get(i5);
                        ViewHolder viewHolder = ViewHolder.this;
                        OnControlClickedListener onControlClickedListener = ControlBarPresenter.this.mOnControlClickedListener;
                        if (onControlClickedListener != null) {
                            onControlClickedListener.onControlClicked(viewHolder, obj, viewHolder.mData);
                        }
                    }
                });
            }
            if (viewHolder.view.getParent() == null) {
                this.mControlBar.addView(viewHolder.view);
            }
            presenter.onBindViewHolder(viewHolder, obj);
        }
    }

    public ControlBarPresenter(int i5) {
        this.mLayoutResourceId = i5;
    }

    /* access modifiers changed from: package-private */
    public int getChildMarginDefault(Context context) {
        if (sChildMarginDefault == 0) {
            sChildMarginDefault = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_controls_child_margin_default);
        }
        return sChildMarginDefault;
    }

    /* access modifiers changed from: package-private */
    public int getControlIconWidth(Context context) {
        if (sControlIconWidth == 0) {
            sControlIconWidth = context.getResources().getDimensionPixelSize(R.dimen.lb_control_icon_width);
        }
        return sControlIconWidth;
    }

    public int getLayoutResourceId() {
        return this.mLayoutResourceId;
    }

    public OnControlSelectedListener getOnItemControlListener() {
        return this.mOnControlSelectedListener;
    }

    public OnControlClickedListener getOnItemViewClickedListener() {
        return this.mOnControlClickedListener;
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        BoundData boundData = (BoundData) obj;
        ObjectAdapter objectAdapter = viewHolder2.mAdapter;
        ObjectAdapter objectAdapter2 = boundData.adapter;
        if (objectAdapter != objectAdapter2) {
            viewHolder2.mAdapter = objectAdapter2;
            if (objectAdapter2 != null) {
                objectAdapter2.registerObserver(viewHolder2.mDataObserver);
            }
        }
        Presenter presenter = boundData.presenter;
        viewHolder2.mPresenter = presenter;
        viewHolder2.mData = boundData;
        viewHolder2.showControls(presenter);
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutResourceId(), viewGroup, false));
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ObjectAdapter objectAdapter = viewHolder2.mAdapter;
        if (objectAdapter != null) {
            objectAdapter.unregisterObserver(viewHolder2.mDataObserver);
            viewHolder2.mAdapter = null;
        }
        viewHolder2.mData = null;
    }

    public void setBackgroundColor(ViewHolder viewHolder, int i5) {
        viewHolder.mControlsContainer.setBackgroundColor(i5);
    }

    /* access modifiers changed from: package-private */
    public void setDefaultFocusToMiddle(boolean z4) {
        this.mDefaultFocusToMiddle = z4;
    }

    public void setOnControlClickedListener(OnControlClickedListener onControlClickedListener) {
        this.mOnControlClickedListener = onControlClickedListener;
    }

    public void setOnControlSelectedListener(OnControlSelectedListener onControlSelectedListener) {
        this.mOnControlSelectedListener = onControlSelectedListener;
    }
}

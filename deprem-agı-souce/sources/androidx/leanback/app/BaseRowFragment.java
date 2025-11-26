package androidx.leanback.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;

@Deprecated
abstract class BaseRowFragment extends Fragment {
    private static final String CURRENT_SELECTED_POSITION = "currentSelectedPosition";
    private ObjectAdapter mAdapter;
    final ItemBridgeAdapter mBridgeAdapter = new ItemBridgeAdapter();
    LateSelectionObserver mLateSelectionObserver = new LateSelectionObserver();
    private boolean mPendingTransitionPrepare;
    private PresenterSelector mPresenterSelector;
    private final OnChildViewHolderSelectedListener mRowSelectedListener = new OnChildViewHolderSelectedListener() {
        public void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i5, int i6) {
            BaseRowFragment baseRowFragment = BaseRowFragment.this;
            if (!baseRowFragment.mLateSelectionObserver.mIsLateSelection) {
                baseRowFragment.mSelectedPosition = i5;
                baseRowFragment.onRowSelected(recyclerView, viewHolder, i5, i6);
            }
        }
    };
    int mSelectedPosition = -1;
    VerticalGridView mVerticalGridView;

    final class LateSelectionObserver extends RecyclerView.AdapterDataObserver {
        boolean mIsLateSelection = false;

        LateSelectionObserver() {
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            if (this.mIsLateSelection) {
                this.mIsLateSelection = false;
                BaseRowFragment.this.mBridgeAdapter.unregisterAdapterDataObserver(this);
            }
        }

        public void onChanged() {
            performLateSelection();
        }

        public void onItemRangeInserted(int i5, int i6) {
            performLateSelection();
        }

        /* access modifiers changed from: package-private */
        public void performLateSelection() {
            clear();
            BaseRowFragment baseRowFragment = BaseRowFragment.this;
            VerticalGridView verticalGridView = baseRowFragment.mVerticalGridView;
            if (verticalGridView != null) {
                verticalGridView.setSelectedPosition(baseRowFragment.mSelectedPosition);
            }
        }

        /* access modifiers changed from: package-private */
        public void startLateSelection() {
            this.mIsLateSelection = true;
            BaseRowFragment.this.mBridgeAdapter.registerAdapterDataObserver(this);
        }
    }

    BaseRowFragment() {
    }

    /* access modifiers changed from: package-private */
    public VerticalGridView findGridViewFromRoot(View view) {
        return (VerticalGridView) view;
    }

    public final ObjectAdapter getAdapter() {
        return this.mAdapter;
    }

    public final ItemBridgeAdapter getBridgeAdapter() {
        return this.mBridgeAdapter;
    }

    /* access modifiers changed from: package-private */
    public Object getItem(Row row, int i5) {
        if (row instanceof ListRow) {
            return ((ListRow) row).getAdapter().get(i5);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract int getLayoutResourceId();

    public final PresenterSelector getPresenterSelector() {
        return this.mPresenterSelector;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public final VerticalGridView getVerticalGridView() {
        return this.mVerticalGridView;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutResourceId(), viewGroup, false);
        this.mVerticalGridView = findGridViewFromRoot(inflate);
        if (this.mPendingTransitionPrepare) {
            this.mPendingTransitionPrepare = false;
            onTransitionPrepare();
        }
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mLateSelectionObserver.clear();
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView != null) {
            verticalGridView.swapAdapter((RecyclerView.Adapter) null, true);
            this.mVerticalGridView = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void onRowSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i5, int i6) {
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(CURRENT_SELECTED_POSITION, this.mSelectedPosition);
    }

    public void onTransitionEnd() {
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView != null) {
            verticalGridView.setLayoutFrozen(false);
            this.mVerticalGridView.setAnimateChildLayout(true);
            this.mVerticalGridView.setPruneChild(true);
            this.mVerticalGridView.setFocusSearchDisabled(false);
            this.mVerticalGridView.setScrollEnabled(true);
        }
    }

    public boolean onTransitionPrepare() {
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView != null) {
            verticalGridView.setAnimateChildLayout(false);
            this.mVerticalGridView.setScrollEnabled(false);
            return true;
        }
        this.mPendingTransitionPrepare = true;
        return false;
    }

    public void onTransitionStart() {
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView != null) {
            verticalGridView.setPruneChild(false);
            this.mVerticalGridView.setLayoutFrozen(true);
            this.mVerticalGridView.setFocusSearchDisabled(true);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        if (bundle != null) {
            this.mSelectedPosition = bundle.getInt(CURRENT_SELECTED_POSITION, -1);
        }
        setAdapterAndSelection();
        this.mVerticalGridView.setOnChildViewHolderSelectedListener(this.mRowSelectedListener);
    }

    public final void setAdapter(ObjectAdapter objectAdapter) {
        if (this.mAdapter != objectAdapter) {
            this.mAdapter = objectAdapter;
            updateAdapter();
        }
    }

    /* access modifiers changed from: package-private */
    public void setAdapterAndSelection() {
        if (this.mAdapter != null) {
            RecyclerView.Adapter adapter = this.mVerticalGridView.getAdapter();
            ItemBridgeAdapter itemBridgeAdapter = this.mBridgeAdapter;
            if (adapter != itemBridgeAdapter) {
                this.mVerticalGridView.setAdapter(itemBridgeAdapter);
            }
            if (this.mBridgeAdapter.getItemCount() != 0 || this.mSelectedPosition < 0) {
                int i5 = this.mSelectedPosition;
                if (i5 >= 0) {
                    this.mVerticalGridView.setSelectedPosition(i5);
                    return;
                }
                return;
            }
            this.mLateSelectionObserver.startLateSelection();
        }
    }

    public void setAlignment(int i5) {
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView != null) {
            verticalGridView.setItemAlignmentOffset(0);
            this.mVerticalGridView.setItemAlignmentOffsetPercent(-1.0f);
            this.mVerticalGridView.setWindowAlignmentOffset(i5);
            this.mVerticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
            this.mVerticalGridView.setWindowAlignment(0);
        }
    }

    public final void setPresenterSelector(PresenterSelector presenterSelector) {
        if (this.mPresenterSelector != presenterSelector) {
            this.mPresenterSelector = presenterSelector;
            updateAdapter();
        }
    }

    public void setSelectedPosition(int i5) {
        setSelectedPosition(i5, true);
    }

    /* access modifiers changed from: package-private */
    public void updateAdapter() {
        this.mBridgeAdapter.setAdapter(this.mAdapter);
        this.mBridgeAdapter.setPresenter(this.mPresenterSelector);
        if (this.mVerticalGridView != null) {
            setAdapterAndSelection();
        }
    }

    public void setSelectedPosition(int i5, boolean z4) {
        if (this.mSelectedPosition != i5) {
            this.mSelectedPosition = i5;
            VerticalGridView verticalGridView = this.mVerticalGridView;
            if (verticalGridView != null && !this.mLateSelectionObserver.mIsLateSelection) {
                if (z4) {
                    verticalGridView.setSelectedPositionSmooth(i5);
                } else {
                    verticalGridView.setSelectedPosition(i5);
                }
            }
        }
    }
}

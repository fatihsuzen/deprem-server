package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class DetailsOverviewRow extends Row {
    private ObjectAdapter mActionsAdapter = new ArrayObjectAdapter(this.mDefaultActionPresenter);
    private PresenterSelector mDefaultActionPresenter = new ActionPresenterSelector();
    private Drawable mImageDrawable;
    private boolean mImageScaleUpAllowed = true;
    private Object mItem;
    private ArrayList<WeakReference<Listener>> mListeners;

    public static class Listener {
        public void onActionsAdapterChanged(DetailsOverviewRow detailsOverviewRow) {
        }

        public void onImageDrawableChanged(DetailsOverviewRow detailsOverviewRow) {
        }

        public void onItemChanged(DetailsOverviewRow detailsOverviewRow) {
        }
    }

    public DetailsOverviewRow(Object obj) {
        super((HeaderItem) null);
        this.mItem = obj;
        verify();
    }

    private ArrayObjectAdapter getArrayObjectAdapter() {
        return (ArrayObjectAdapter) this.mActionsAdapter;
    }

    private void verify() {
        if (this.mItem == null) {
            throw new IllegalArgumentException("Object cannot be null");
        }
    }

    @Deprecated
    public final void addAction(Action action) {
        getArrayObjectAdapter().add(action);
    }

    /* access modifiers changed from: package-private */
    public final void addListener(Listener listener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        } else {
            int i5 = 0;
            while (i5 < this.mListeners.size()) {
                Listener listener2 = (Listener) this.mListeners.get(i5).get();
                if (listener2 == null) {
                    this.mListeners.remove(i5);
                } else if (listener2 != listener) {
                    i5++;
                } else {
                    return;
                }
            }
        }
        this.mListeners.add(new WeakReference(listener));
    }

    public Action getActionForKeyCode(int i5) {
        ObjectAdapter actionsAdapter = getActionsAdapter();
        if (actionsAdapter == null) {
            return null;
        }
        for (int i6 = 0; i6 < actionsAdapter.size(); i6++) {
            Action action = (Action) actionsAdapter.get(i6);
            if (action.respondsToKeyCode(i5)) {
                return action;
            }
        }
        return null;
    }

    @Deprecated
    public final List<Action> getActions() {
        return getArrayObjectAdapter().unmodifiableList();
    }

    public final ObjectAdapter getActionsAdapter() {
        return this.mActionsAdapter;
    }

    public final Drawable getImageDrawable() {
        return this.mImageDrawable;
    }

    public final Object getItem() {
        return this.mItem;
    }

    public boolean isImageScaleUpAllowed() {
        return this.mImageScaleUpAllowed;
    }

    /* access modifiers changed from: package-private */
    public final void notifyActionsAdapterChanged() {
        if (this.mListeners != null) {
            int i5 = 0;
            while (i5 < this.mListeners.size()) {
                Listener listener = (Listener) this.mListeners.get(i5).get();
                if (listener == null) {
                    this.mListeners.remove(i5);
                } else {
                    listener.onActionsAdapterChanged(this);
                    i5++;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void notifyImageDrawableChanged() {
        if (this.mListeners != null) {
            int i5 = 0;
            while (i5 < this.mListeners.size()) {
                Listener listener = (Listener) this.mListeners.get(i5).get();
                if (listener == null) {
                    this.mListeners.remove(i5);
                } else {
                    listener.onImageDrawableChanged(this);
                    i5++;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void notifyItemChanged() {
        if (this.mListeners != null) {
            int i5 = 0;
            while (i5 < this.mListeners.size()) {
                Listener listener = (Listener) this.mListeners.get(i5).get();
                if (listener == null) {
                    this.mListeners.remove(i5);
                } else {
                    listener.onItemChanged(this);
                    i5++;
                }
            }
        }
    }

    @Deprecated
    public final boolean removeAction(Action action) {
        return getArrayObjectAdapter().remove(action);
    }

    /* access modifiers changed from: package-private */
    public final void removeListener(Listener listener) {
        if (this.mListeners != null) {
            int i5 = 0;
            while (i5 < this.mListeners.size()) {
                Listener listener2 = (Listener) this.mListeners.get(i5).get();
                if (listener2 == null) {
                    this.mListeners.remove(i5);
                } else if (listener2 == listener) {
                    this.mListeners.remove(i5);
                    return;
                } else {
                    i5++;
                }
            }
        }
    }

    public final void setActionsAdapter(ObjectAdapter objectAdapter) {
        if (objectAdapter != this.mActionsAdapter) {
            this.mActionsAdapter = objectAdapter;
            if (objectAdapter.getPresenterSelector() == null) {
                this.mActionsAdapter.setPresenterSelector(this.mDefaultActionPresenter);
            }
            notifyActionsAdapterChanged();
        }
    }

    public final void setImageBitmap(Context context, Bitmap bitmap) {
        this.mImageDrawable = new BitmapDrawable(context.getResources(), bitmap);
        notifyImageDrawableChanged();
    }

    public final void setImageDrawable(Drawable drawable) {
        if (this.mImageDrawable != drawable) {
            this.mImageDrawable = drawable;
            notifyImageDrawableChanged();
        }
    }

    public void setImageScaleUpAllowed(boolean z4) {
        if (z4 != this.mImageScaleUpAllowed) {
            this.mImageScaleUpAllowed = z4;
            notifyImageDrawableChanged();
        }
    }

    public final void setItem(Object obj) {
        if (obj != this.mItem) {
            this.mItem = obj;
            notifyItemChanged();
        }
    }

    @Deprecated
    public final void addAction(int i5, Action action) {
        getArrayObjectAdapter().add(i5, action);
    }
}

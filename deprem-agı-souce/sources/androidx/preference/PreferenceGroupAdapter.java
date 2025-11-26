package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PreferenceGroupAdapter extends RecyclerView.Adapter<PreferenceViewHolder> implements Preference.OnPreferenceChangeInternalListener, PreferenceGroup.PreferencePositionCallback {
    private final Handler mHandler;
    private final PreferenceGroup mPreferenceGroup;
    private final List<PreferenceResourceDescriptor> mPreferenceResourceDescriptors;
    private List<Preference> mPreferences;
    private final Runnable mSyncRunnable = new Runnable() {
        public void run() {
            PreferenceGroupAdapter.this.updatePreferences();
        }
    };
    private List<Preference> mVisiblePreferences;

    private static class PreferenceResourceDescriptor {
        String mClassName;
        int mLayoutResId;
        int mWidgetLayoutResId;

        PreferenceResourceDescriptor(@NonNull Preference preference) {
            this.mClassName = preference.getClass().getName();
            this.mLayoutResId = preference.getLayoutResource();
            this.mWidgetLayoutResId = preference.getWidgetLayoutResource();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PreferenceResourceDescriptor)) {
                return false;
            }
            PreferenceResourceDescriptor preferenceResourceDescriptor = (PreferenceResourceDescriptor) obj;
            if (this.mLayoutResId == preferenceResourceDescriptor.mLayoutResId && this.mWidgetLayoutResId == preferenceResourceDescriptor.mWidgetLayoutResId && TextUtils.equals(this.mClassName, preferenceResourceDescriptor.mClassName)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.mLayoutResId) * 31) + this.mWidgetLayoutResId) * 31) + this.mClassName.hashCode();
        }
    }

    public PreferenceGroupAdapter(@NonNull PreferenceGroup preferenceGroup) {
        this.mPreferenceGroup = preferenceGroup;
        this.mHandler = new Handler(Looper.getMainLooper());
        preferenceGroup.setOnPreferenceChangeInternalListener(this);
        this.mPreferences = new ArrayList();
        this.mVisiblePreferences = new ArrayList();
        this.mPreferenceResourceDescriptors = new ArrayList();
        if (preferenceGroup instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup).shouldUseGeneratedIds());
        } else {
            setHasStableIds(true);
        }
        updatePreferences();
    }

    private ExpandButton createExpandButton(final PreferenceGroup preferenceGroup, List<Preference> list) {
        ExpandButton expandButton = new ExpandButton(preferenceGroup.getContext(), list, preferenceGroup.getId());
        expandButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(@NonNull Preference preference) {
                preferenceGroup.setInitialExpandedChildrenCount(Integer.MAX_VALUE);
                PreferenceGroupAdapter.this.onPreferenceHierarchyChange(preference);
                PreferenceGroup.OnExpandButtonClickListener onExpandButtonClickListener = preferenceGroup.getOnExpandButtonClickListener();
                if (onExpandButtonClickListener == null) {
                    return true;
                }
                onExpandButtonClickListener.onExpandButtonClick();
                return true;
            }
        });
        return expandButton;
    }

    private List<Preference> createVisiblePreferencesList(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        int i5 = 0;
        for (int i6 = 0; i6 < preferenceCount; i6++) {
            Preference preference = preferenceGroup.getPreference(i6);
            if (preference.isVisible()) {
                if (!isGroupExpandable(preferenceGroup) || i5 < preferenceGroup.getInitialExpandedChildrenCount()) {
                    arrayList.add(preference);
                } else {
                    arrayList2.add(preference);
                }
                if (!(preference instanceof PreferenceGroup)) {
                    i5++;
                } else {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                    if (!preferenceGroup2.isOnSameScreenAsChildren()) {
                        continue;
                    } else if (!isGroupExpandable(preferenceGroup) || !isGroupExpandable(preferenceGroup2)) {
                        for (Preference next : createVisiblePreferencesList(preferenceGroup2)) {
                            if (!isGroupExpandable(preferenceGroup) || i5 < preferenceGroup.getInitialExpandedChildrenCount()) {
                                arrayList.add(next);
                            } else {
                                arrayList2.add(next);
                            }
                            i5++;
                        }
                    } else {
                        throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                    }
                }
            }
        }
        if (isGroupExpandable(preferenceGroup) && i5 > preferenceGroup.getInitialExpandedChildrenCount()) {
            arrayList.add(createExpandButton(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    private void flattenPreferenceGroup(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.sortPreferences();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i5 = 0; i5 < preferenceCount; i5++) {
            Preference preference = preferenceGroup.getPreference(i5);
            list.add(preference);
            PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(preference);
            if (!this.mPreferenceResourceDescriptors.contains(preferenceResourceDescriptor)) {
                this.mPreferenceResourceDescriptors.add(preferenceResourceDescriptor);
            }
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                if (preferenceGroup2.isOnSameScreenAsChildren()) {
                    flattenPreferenceGroup(list, preferenceGroup2);
                }
            }
            preference.setOnPreferenceChangeInternalListener(this);
        }
    }

    private boolean isGroupExpandable(PreferenceGroup preferenceGroup) {
        if (preferenceGroup.getInitialExpandedChildrenCount() != Integer.MAX_VALUE) {
            return true;
        }
        return false;
    }

    @Nullable
    public Preference getItem(int i5) {
        if (i5 < 0 || i5 >= getItemCount()) {
            return null;
        }
        return this.mVisiblePreferences.get(i5);
    }

    public int getItemCount() {
        return this.mVisiblePreferences.size();
    }

    public long getItemId(int i5) {
        if (!hasStableIds()) {
            return -1;
        }
        return getItem(i5).getId();
    }

    public int getItemViewType(int i5) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(getItem(i5));
        int indexOf = this.mPreferenceResourceDescriptors.indexOf(preferenceResourceDescriptor);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.mPreferenceResourceDescriptors.size();
        this.mPreferenceResourceDescriptors.add(preferenceResourceDescriptor);
        return size;
    }

    public int getPreferenceAdapterPosition(@NonNull String str) {
        int size = this.mVisiblePreferences.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (TextUtils.equals(str, this.mVisiblePreferences.get(i5).getKey())) {
                return i5;
            }
        }
        return -1;
    }

    public void onPreferenceChange(@NonNull Preference preference) {
        int indexOf = this.mVisiblePreferences.indexOf(preference);
        if (indexOf != -1) {
            notifyItemChanged(indexOf, preference);
        }
    }

    public void onPreferenceHierarchyChange(@NonNull Preference preference) {
        this.mHandler.removeCallbacks(this.mSyncRunnable);
        this.mHandler.post(this.mSyncRunnable);
    }

    public void onPreferenceVisibilityChange(@NonNull Preference preference) {
        onPreferenceHierarchyChange(preference);
    }

    /* access modifiers changed from: package-private */
    public void updatePreferences() {
        for (Preference onPreferenceChangeInternalListener : this.mPreferences) {
            onPreferenceChangeInternalListener.setOnPreferenceChangeInternalListener((Preference.OnPreferenceChangeInternalListener) null);
        }
        ArrayList arrayList = new ArrayList(this.mPreferences.size());
        this.mPreferences = arrayList;
        flattenPreferenceGroup(arrayList, this.mPreferenceGroup);
        final List<Preference> list = this.mVisiblePreferences;
        final List<Preference> createVisiblePreferencesList = createVisiblePreferencesList(this.mPreferenceGroup);
        this.mVisiblePreferences = createVisiblePreferencesList;
        PreferenceManager preferenceManager = this.mPreferenceGroup.getPreferenceManager();
        if (preferenceManager == null || preferenceManager.getPreferenceComparisonCallback() == null) {
            notifyDataSetChanged();
        } else {
            final PreferenceManager.PreferenceComparisonCallback preferenceComparisonCallback = preferenceManager.getPreferenceComparisonCallback();
            DiffUtil.calculateDiff(new DiffUtil.Callback() {
                public boolean areContentsTheSame(int i5, int i6) {
                    return preferenceComparisonCallback.arePreferenceContentsTheSame((Preference) list.get(i5), (Preference) createVisiblePreferencesList.get(i6));
                }

                public boolean areItemsTheSame(int i5, int i6) {
                    return preferenceComparisonCallback.arePreferenceItemsTheSame((Preference) list.get(i5), (Preference) createVisiblePreferencesList.get(i6));
                }

                public int getNewListSize() {
                    return createVisiblePreferencesList.size();
                }

                public int getOldListSize() {
                    return list.size();
                }
            }).dispatchUpdatesTo((RecyclerView.Adapter) this);
        }
        for (Preference clearWasDetached : this.mPreferences) {
            clearWasDetached.clearWasDetached();
        }
    }

    public void onBindViewHolder(@NonNull PreferenceViewHolder preferenceViewHolder, int i5) {
        Preference item = getItem(i5);
        preferenceViewHolder.resetState();
        item.onBindViewHolder(preferenceViewHolder);
    }

    @NonNull
    public PreferenceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i5) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = this.mPreferenceResourceDescriptors.get(i5);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.BackgroundStyle);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = AppCompatResources.getDrawable(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(preferenceResourceDescriptor.mLayoutResId, viewGroup, false);
        if (inflate.getBackground() == null) {
            ViewCompat.setBackground(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            int i6 = preferenceResourceDescriptor.mWidgetLayoutResId;
            if (i6 != 0) {
                from.inflate(i6, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolder(inflate);
    }

    public int getPreferenceAdapterPosition(@NonNull Preference preference) {
        int size = this.mVisiblePreferences.size();
        for (int i5 = 0; i5 < size; i5++) {
            Preference preference2 = this.mVisiblePreferences.get(i5);
            if (preference2 != null && preference2.equals(preference)) {
                return i5;
            }
        }
        return -1;
    }
}

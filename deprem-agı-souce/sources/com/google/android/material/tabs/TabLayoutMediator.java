package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

public final class TabLayoutMediator {
    @Nullable
    private RecyclerView.Adapter<?> adapter;
    private boolean attached;
    private final boolean autoRefresh;
    @Nullable
    private TabLayoutOnPageChangeCallback onPageChangeCallback;
    @Nullable
    private TabLayout.OnTabSelectedListener onTabSelectedListener;
    @Nullable
    private RecyclerView.AdapterDataObserver pagerAdapterObserver;
    private final boolean smoothScroll;
    private final TabConfigurationStrategy tabConfigurationStrategy;
    @NonNull
    private final TabLayout tabLayout;
    @NonNull
    private final ViewPager2 viewPager;

    private class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
        PagerAdapterObserver() {
        }

        public void onChanged() {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeChanged(int i5, int i6) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeInserted(int i5, int i6) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeMoved(int i5, int i6, int i7) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeRemoved(int i5, int i6) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeChanged(int i5, int i6, @Nullable Object obj) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }
    }

    public interface TabConfigurationStrategy {
        void onConfigureTab(@NonNull TabLayout.Tab tab, int i5);
    }

    private static class TabLayoutOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private int previousScrollState;
        private int scrollState;
        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        TabLayoutOnPageChangeCallback(TabLayout tabLayout) {
            this.tabLayoutRef = new WeakReference<>(tabLayout);
            reset();
        }

        public void onPageScrollStateChanged(int i5) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i5;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                tabLayout.updateViewPagerScrollState(this.scrollState);
            }
        }

        public void onPageScrolled(int i5, float f5, int i6) {
            boolean z4;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                int i7 = this.scrollState;
                boolean z5 = true;
                if (i7 != 2 || this.previousScrollState == 1) {
                    z4 = true;
                } else {
                    z4 = true;
                    z5 = false;
                }
                if (i7 == 2 && this.previousScrollState == 0) {
                    z4 = false;
                }
                tabLayout.setScrollPosition(i5, f5, z5, z4, false);
            }
        }

        public void onPageSelected(int i5) {
            boolean z4;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i5 && i5 < tabLayout.getTabCount()) {
                int i6 = this.scrollState;
                if (i6 == 0 || (i6 == 2 && this.previousScrollState == 0)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i5), z4);
            }
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    private static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
        private final boolean smoothScroll;
        private final ViewPager2 viewPager;

        ViewPagerOnTabSelectedListener(ViewPager2 viewPager2, boolean z4) {
            this.viewPager = viewPager2;
            this.smoothScroll = z4;
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabSelected(@NonNull TabLayout.Tab tab) {
            this.viewPager.setCurrentItem(tab.getPosition(), this.smoothScroll);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout2, @NonNull ViewPager2 viewPager2, @NonNull TabConfigurationStrategy tabConfigurationStrategy2) {
        this(tabLayout2, viewPager2, true, tabConfigurationStrategy2);
    }

    public void attach() {
        if (!this.attached) {
            RecyclerView.Adapter<?> adapter2 = this.viewPager.getAdapter();
            this.adapter = adapter2;
            if (adapter2 != null) {
                this.attached = true;
                TabLayoutOnPageChangeCallback tabLayoutOnPageChangeCallback = new TabLayoutOnPageChangeCallback(this.tabLayout);
                this.onPageChangeCallback = tabLayoutOnPageChangeCallback;
                this.viewPager.registerOnPageChangeCallback(tabLayoutOnPageChangeCallback);
                ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(this.viewPager, this.smoothScroll);
                this.onTabSelectedListener = viewPagerOnTabSelectedListener;
                this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) viewPagerOnTabSelectedListener);
                if (this.autoRefresh) {
                    PagerAdapterObserver pagerAdapterObserver2 = new PagerAdapterObserver();
                    this.pagerAdapterObserver = pagerAdapterObserver2;
                    this.adapter.registerAdapterDataObserver(pagerAdapterObserver2);
                }
                populateTabsFromPagerAdapter();
                this.tabLayout.setScrollPosition(this.viewPager.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void detach() {
        RecyclerView.Adapter<?> adapter2;
        if (this.attached) {
            if (this.autoRefresh && (adapter2 = this.adapter) != null) {
                adapter2.unregisterAdapterDataObserver(this.pagerAdapterObserver);
                this.pagerAdapterObserver = null;
            }
            this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
            this.viewPager.unregisterOnPageChangeCallback(this.onPageChangeCallback);
            this.onTabSelectedListener = null;
            this.onPageChangeCallback = null;
            this.adapter = null;
            this.attached = false;
        }
    }

    public boolean isAttached() {
        return this.attached;
    }

    /* access modifiers changed from: package-private */
    public void populateTabsFromPagerAdapter() {
        int min;
        this.tabLayout.removeAllTabs();
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 != null) {
            int itemCount = adapter2.getItemCount();
            for (int i5 = 0; i5 < itemCount; i5++) {
                TabLayout.Tab newTab = this.tabLayout.newTab();
                this.tabConfigurationStrategy.onConfigureTab(newTab, i5);
                this.tabLayout.addTab(newTab, false);
            }
            if (itemCount > 0 && (min = Math.min(this.viewPager.getCurrentItem(), this.tabLayout.getTabCount() - 1)) != this.tabLayout.getSelectedTabPosition()) {
                TabLayout tabLayout2 = this.tabLayout;
                tabLayout2.selectTab(tabLayout2.getTabAt(min));
            }
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout2, @NonNull ViewPager2 viewPager2, boolean z4, @NonNull TabConfigurationStrategy tabConfigurationStrategy2) {
        this(tabLayout2, viewPager2, z4, true, tabConfigurationStrategy2);
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout2, @NonNull ViewPager2 viewPager2, boolean z4, boolean z5, @NonNull TabConfigurationStrategy tabConfigurationStrategy2) {
        this.tabLayout = tabLayout2;
        this.viewPager = viewPager2;
        this.autoRefresh = z4;
        this.smoothScroll = z5;
        this.tabConfigurationStrategy = tabConfigurationStrategy2;
    }
}

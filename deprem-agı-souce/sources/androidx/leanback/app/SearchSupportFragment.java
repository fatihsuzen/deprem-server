package androidx.leanback.app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.SpeechRecognizer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.CompletionInfo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.leanback.R;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.SearchBar;
import androidx.leanback.widget.SearchOrbView;
import androidx.leanback.widget.SpeechRecognitionCallback;
import androidx.leanback.widget.VerticalGridView;
import java.util.ArrayList;
import java.util.List;

public class SearchSupportFragment extends Fragment {
    private static final String ARG_PREFIX = "androidx.leanback.app.SearchSupportFragment";
    private static final String ARG_QUERY;
    private static final String ARG_TITLE;
    static final int AUDIO_PERMISSION_REQUEST_CODE = 0;
    static final boolean DEBUG = false;
    private static final String EXTRA_LEANBACK_BADGE_PRESENT = "LEANBACK_BADGE_PRESENT";
    static final int QUERY_COMPLETE = 2;
    static final int RESULTS_CHANGED = 1;
    static final long SPEECH_RECOGNITION_DELAY_MS = 300;
    static final String TAG = "SearchSupportFragment";
    final ObjectAdapter.DataObserver mAdapterObserver = new ObjectAdapter.DataObserver() {
        public void onChanged() {
            SearchSupportFragment searchSupportFragment = SearchSupportFragment.this;
            searchSupportFragment.mHandler.removeCallbacks(searchSupportFragment.mResultsChangedCallback);
            SearchSupportFragment searchSupportFragment2 = SearchSupportFragment.this;
            searchSupportFragment2.mHandler.post(searchSupportFragment2.mResultsChangedCallback);
        }
    };
    boolean mAutoStartRecognition = true;
    private Drawable mBadgeDrawable;
    private ExternalQuery mExternalQuery;
    final Handler mHandler = new Handler();
    private boolean mIsPaused;
    private OnItemViewClickedListener mOnItemViewClickedListener;
    OnItemViewSelectedListener mOnItemViewSelectedListener;
    String mPendingQuery = null;
    private boolean mPendingStartRecognitionWhenPaused;
    private SearchBar.SearchBarPermissionListener mPermissionListener = new SearchBar.SearchBarPermissionListener() {
        public void requestAudioPermission() {
            SearchSupportFragment.this.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 0);
        }
    };
    SearchResultProvider mProvider;
    ObjectAdapter mResultAdapter;
    final Runnable mResultsChangedCallback = new Runnable() {
        public void run() {
            RowsSupportFragment rowsSupportFragment = SearchSupportFragment.this.mRowsSupportFragment;
            if (rowsSupportFragment != null) {
                ObjectAdapter adapter = rowsSupportFragment.getAdapter();
                SearchSupportFragment searchSupportFragment = SearchSupportFragment.this;
                if (!(adapter == searchSupportFragment.mResultAdapter || (searchSupportFragment.mRowsSupportFragment.getAdapter() == null && SearchSupportFragment.this.mResultAdapter.size() == 0))) {
                    SearchSupportFragment searchSupportFragment2 = SearchSupportFragment.this;
                    searchSupportFragment2.mRowsSupportFragment.setAdapter(searchSupportFragment2.mResultAdapter);
                    SearchSupportFragment.this.mRowsSupportFragment.setSelectedPosition(0);
                }
            }
            SearchSupportFragment.this.updateSearchBarVisibility();
            SearchSupportFragment searchSupportFragment3 = SearchSupportFragment.this;
            int i5 = searchSupportFragment3.mStatus | 1;
            searchSupportFragment3.mStatus = i5;
            if ((i5 & 2) != 0) {
                searchSupportFragment3.updateFocus();
            }
        }
    };
    RowsSupportFragment mRowsSupportFragment;
    SearchBar mSearchBar;
    private final Runnable mSetSearchResultProvider = new Runnable() {
        public void run() {
            boolean z4;
            ObjectAdapter objectAdapter;
            SearchSupportFragment searchSupportFragment = SearchSupportFragment.this;
            if (searchSupportFragment.mRowsSupportFragment != null) {
                ObjectAdapter resultsAdapter = searchSupportFragment.mProvider.getResultsAdapter();
                SearchSupportFragment searchSupportFragment2 = SearchSupportFragment.this;
                ObjectAdapter objectAdapter2 = searchSupportFragment2.mResultAdapter;
                if (resultsAdapter != objectAdapter2) {
                    if (objectAdapter2 == null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    searchSupportFragment2.releaseAdapter();
                    SearchSupportFragment searchSupportFragment3 = SearchSupportFragment.this;
                    searchSupportFragment3.mResultAdapter = resultsAdapter;
                    if (resultsAdapter != null) {
                        resultsAdapter.registerObserver(searchSupportFragment3.mAdapterObserver);
                    }
                    if (!z4 || !((objectAdapter = SearchSupportFragment.this.mResultAdapter) == null || objectAdapter.size() == 0)) {
                        SearchSupportFragment searchSupportFragment4 = SearchSupportFragment.this;
                        searchSupportFragment4.mRowsSupportFragment.setAdapter(searchSupportFragment4.mResultAdapter);
                    }
                    SearchSupportFragment.this.executePendingQuery();
                }
                SearchSupportFragment searchSupportFragment5 = SearchSupportFragment.this;
                if (searchSupportFragment5.mAutoStartRecognition) {
                    searchSupportFragment5.mHandler.removeCallbacks(searchSupportFragment5.mStartRecognitionRunnable);
                    SearchSupportFragment searchSupportFragment6 = SearchSupportFragment.this;
                    searchSupportFragment6.mHandler.postDelayed(searchSupportFragment6.mStartRecognitionRunnable, SearchSupportFragment.SPEECH_RECOGNITION_DELAY_MS);
                    return;
                }
                searchSupportFragment5.updateFocus();
            }
        }
    };
    private SpeechRecognitionCallback mSpeechRecognitionCallback;
    private SpeechRecognizer mSpeechRecognizer;
    boolean mSpeechRecognizerEnabled;
    final Runnable mStartRecognitionRunnable = new Runnable() {
        public void run() {
            SearchSupportFragment searchSupportFragment = SearchSupportFragment.this;
            searchSupportFragment.mAutoStartRecognition = false;
            searchSupportFragment.mSearchBar.startRecognition();
        }
    };
    int mStatus;
    private String mTitle;

    static class ExternalQuery {
        String mQuery;
        boolean mSubmit;

        ExternalQuery(String str, boolean z4) {
            this.mQuery = str;
            this.mSubmit = z4;
        }
    }

    public interface SearchResultProvider {
        ObjectAdapter getResultsAdapter();

        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    static {
        String canonicalName = SearchSupportFragment.class.getCanonicalName();
        ARG_QUERY = canonicalName + ".query";
        ARG_TITLE = canonicalName + ".title";
    }

    private void applyExternalQuery() {
        SearchBar searchBar;
        ExternalQuery externalQuery = this.mExternalQuery;
        if (externalQuery != null && (searchBar = this.mSearchBar) != null) {
            searchBar.setSearchQuery(externalQuery.mQuery);
            ExternalQuery externalQuery2 = this.mExternalQuery;
            if (externalQuery2.mSubmit) {
                submitQuery(externalQuery2.mQuery);
            }
            this.mExternalQuery = null;
        }
    }

    public static Bundle createArgs(Bundle bundle, String str) {
        return createArgs(bundle, str, (String) null);
    }

    private void focusOnResults() {
        RowsSupportFragment rowsSupportFragment = this.mRowsSupportFragment;
        if (rowsSupportFragment != null && rowsSupportFragment.getVerticalGridView() != null && this.mResultAdapter.size() != 0 && this.mRowsSupportFragment.getVerticalGridView().requestFocus()) {
            this.mStatus &= -2;
        }
    }

    public static SearchSupportFragment newInstance(String str) {
        SearchSupportFragment searchSupportFragment = new SearchSupportFragment();
        searchSupportFragment.setArguments(createArgs((Bundle) null, str));
        return searchSupportFragment;
    }

    private void onSetSearchResultProvider() {
        this.mHandler.removeCallbacks(this.mSetSearchResultProvider);
        this.mHandler.post(this.mSetSearchResultProvider);
    }

    private void readArguments(Bundle bundle) {
        if (bundle != null) {
            String str = ARG_QUERY;
            if (bundle.containsKey(str)) {
                setSearchQuery(bundle.getString(str));
            }
            String str2 = ARG_TITLE;
            if (bundle.containsKey(str2)) {
                setTitle(bundle.getString(str2));
            }
        }
    }

    private void releaseRecognizer() {
        if (this.mSpeechRecognizer != null) {
            this.mSearchBar.setSpeechRecognizer((SpeechRecognizer) null);
            this.mSpeechRecognizer.destroy();
            this.mSpeechRecognizer = null;
        }
    }

    public void displayCompletions(List<String> list) {
        this.mSearchBar.displayCompletions(list);
    }

    /* access modifiers changed from: package-private */
    public void executePendingQuery() {
        String str = this.mPendingQuery;
        if (str != null && this.mResultAdapter != null) {
            this.mPendingQuery = null;
            retrieveResults(str);
        }
    }

    public Drawable getBadgeDrawable() {
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            return searchBar.getBadgeDrawable();
        }
        return null;
    }

    public Intent getRecognizerIntent() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        boolean z4 = true;
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        SearchBar searchBar = this.mSearchBar;
        if (!(searchBar == null || searchBar.getHint() == null)) {
            intent.putExtra("android.speech.extra.PROMPT", this.mSearchBar.getHint());
        }
        if (this.mBadgeDrawable == null) {
            z4 = false;
        }
        intent.putExtra(EXTRA_LEANBACK_BADGE_PRESENT, z4);
        return intent;
    }

    public RowsSupportFragment getRowsSupportFragment() {
        return this.mRowsSupportFragment;
    }

    public String getTitle() {
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            return searchBar.getTitle();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean isSpeechRecognizerAvailable() {
        return SpeechRecognizer.isRecognitionAvailable(getContext());
    }

    public void onCreate(Bundle bundle) {
        boolean z4;
        if (this.mAutoStartRecognition) {
            if (bundle == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.mAutoStartRecognition = z4;
        }
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lb_search_fragment, viewGroup, false);
        BrowseFrameLayout browseFrameLayout = (BrowseFrameLayout) inflate.findViewById(R.id.lb_search_frame);
        SearchBar searchBar = (SearchBar) browseFrameLayout.findViewById(R.id.lb_search_bar);
        this.mSearchBar = searchBar;
        searchBar.setSearchBarListener(new SearchBar.SearchBarListener() {
            public void onKeyboardDismiss(String str) {
                SearchSupportFragment.this.queryComplete();
            }

            public void onSearchQueryChange(String str) {
                SearchSupportFragment searchSupportFragment = SearchSupportFragment.this;
                if (searchSupportFragment.mProvider != null) {
                    searchSupportFragment.retrieveResults(str);
                } else {
                    searchSupportFragment.mPendingQuery = str;
                }
            }

            public void onSearchQuerySubmit(String str) {
                SearchSupportFragment.this.submitQuery(str);
            }
        });
        this.mSearchBar.setSpeechRecognitionCallback(this.mSpeechRecognitionCallback);
        this.mSearchBar.setPermissionListener(this.mPermissionListener);
        applyExternalQuery();
        readArguments(getArguments());
        Drawable drawable = this.mBadgeDrawable;
        if (drawable != null) {
            setBadgeDrawable(drawable);
        }
        String str = this.mTitle;
        if (str != null) {
            setTitle(str);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i5 = R.id.lb_results_frame;
        if (childFragmentManager.findFragmentById(i5) == null) {
            this.mRowsSupportFragment = new RowsSupportFragment();
            getChildFragmentManager().beginTransaction().replace(i5, this.mRowsSupportFragment).commit();
        } else {
            this.mRowsSupportFragment = (RowsSupportFragment) getChildFragmentManager().findFragmentById(i5);
        }
        this.mRowsSupportFragment.setOnItemViewSelectedListener(new OnItemViewSelectedListener() {
            public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
                SearchSupportFragment.this.updateSearchBarVisibility();
                OnItemViewSelectedListener onItemViewSelectedListener = SearchSupportFragment.this.mOnItemViewSelectedListener;
                if (onItemViewSelectedListener != null) {
                    onItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row);
                }
            }
        });
        this.mRowsSupportFragment.setOnItemViewClickedListener(this.mOnItemViewClickedListener);
        this.mRowsSupportFragment.setExpand(true);
        if (this.mProvider != null) {
            onSetSearchResultProvider();
        }
        browseFrameLayout.setOnFocusSearchListener(new BrowseFrameLayout.OnFocusSearchListener() {
            public View onFocusSearch(View view, int i5) {
                ObjectAdapter objectAdapter;
                RowsSupportFragment rowsSupportFragment = SearchSupportFragment.this.mRowsSupportFragment;
                if (rowsSupportFragment == null || rowsSupportFragment.getView() == null || !SearchSupportFragment.this.mRowsSupportFragment.getView().hasFocus()) {
                    if (!SearchSupportFragment.this.mSearchBar.hasFocus() || i5 != 130 || SearchSupportFragment.this.mRowsSupportFragment.getView() == null || (objectAdapter = SearchSupportFragment.this.mResultAdapter) == null || objectAdapter.size() <= 0) {
                        return null;
                    }
                    return SearchSupportFragment.this.mRowsSupportFragment.getView();
                } else if (i5 != 33) {
                    return null;
                } else {
                    SearchSupportFragment searchSupportFragment = SearchSupportFragment.this;
                    if (searchSupportFragment.mSpeechRecognizerEnabled) {
                        return searchSupportFragment.mSearchBar.findViewById(R.id.lb_search_bar_speech_orb);
                    }
                    return searchSupportFragment.mSearchBar;
                }
            }
        });
        if (!isSpeechRecognizerAvailable()) {
            if (this.mSearchBar.hasFocus()) {
                this.mSearchBar.findViewById(R.id.lb_search_text_editor).requestFocus();
            }
            this.mSearchBar.findViewById(R.id.lb_search_bar_speech_orb).setFocusable(false);
            return inflate;
        }
        this.mSpeechRecognizerEnabled = true;
        return inflate;
    }

    public void onDestroy() {
        releaseAdapter();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.mSearchBar = null;
        this.mRowsSupportFragment = null;
        super.onDestroyView();
    }

    public void onPause() {
        releaseRecognizer();
        this.mIsPaused = true;
        super.onPause();
    }

    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        if (i5 == 0 && strArr.length > 0 && strArr[0].equals("android.permission.RECORD_AUDIO") && iArr[0] == 0) {
            startRecognition();
        }
    }

    public void onResume() {
        super.onResume();
        this.mIsPaused = false;
        if (this.mSpeechRecognitionCallback == null && this.mSpeechRecognizer == null && this.mSpeechRecognizerEnabled) {
            SpeechRecognizer createSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(getContext());
            this.mSpeechRecognizer = createSpeechRecognizer;
            this.mSearchBar.setSpeechRecognizer(createSpeechRecognizer);
        }
        if (this.mPendingStartRecognitionWhenPaused) {
            this.mPendingStartRecognitionWhenPaused = false;
            this.mSearchBar.startRecognition();
            return;
        }
        this.mSearchBar.stopRecognition();
    }

    public void onStart() {
        super.onStart();
        VerticalGridView verticalGridView = this.mRowsSupportFragment.getVerticalGridView();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.lb_search_browse_rows_align_top);
        verticalGridView.setItemAlignmentOffset(0);
        verticalGridView.setItemAlignmentOffsetPercent(-1.0f);
        verticalGridView.setWindowAlignmentOffset(dimensionPixelSize);
        verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
        verticalGridView.setWindowAlignment(0);
    }

    /* access modifiers changed from: package-private */
    public void queryComplete() {
        this.mStatus |= 2;
        focusOnResults();
    }

    /* access modifiers changed from: package-private */
    public void releaseAdapter() {
        ObjectAdapter objectAdapter = this.mResultAdapter;
        if (objectAdapter != null) {
            objectAdapter.unregisterObserver(this.mAdapterObserver);
            this.mResultAdapter = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void retrieveResults(String str) {
        if (this.mProvider.onQueryTextChange(str)) {
            this.mStatus &= -3;
        }
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.mBadgeDrawable = drawable;
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            searchBar.setBadgeDrawable(drawable);
        }
    }

    public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        if (onItemViewClickedListener != this.mOnItemViewClickedListener) {
            this.mOnItemViewClickedListener = onItemViewClickedListener;
            RowsSupportFragment rowsSupportFragment = this.mRowsSupportFragment;
            if (rowsSupportFragment != null) {
                rowsSupportFragment.setOnItemViewClickedListener(onItemViewClickedListener);
            }
        }
    }

    public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.mOnItemViewSelectedListener = onItemViewSelectedListener;
    }

    public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            searchBar.setSearchAffordanceColors(colors);
        }
    }

    public void setSearchAffordanceColorsInListening(SearchOrbView.Colors colors) {
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            searchBar.setSearchAffordanceColorsInListening(colors);
        }
    }

    public void setSearchQuery(String str, boolean z4) {
        if (str != null) {
            this.mExternalQuery = new ExternalQuery(str, z4);
            applyExternalQuery();
            if (this.mAutoStartRecognition) {
                this.mAutoStartRecognition = false;
                this.mHandler.removeCallbacks(this.mStartRecognitionRunnable);
            }
        }
    }

    public void setSearchResultProvider(SearchResultProvider searchResultProvider) {
        if (this.mProvider != searchResultProvider) {
            this.mProvider = searchResultProvider;
            onSetSearchResultProvider();
        }
    }

    @Deprecated
    public void setSpeechRecognitionCallback(SpeechRecognitionCallback speechRecognitionCallback) {
        this.mSpeechRecognitionCallback = speechRecognitionCallback;
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            searchBar.setSpeechRecognitionCallback(speechRecognitionCallback);
        }
        if (speechRecognitionCallback != null) {
            releaseRecognizer();
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            searchBar.setTitle(str);
        }
    }

    public void startRecognition() {
        if (this.mIsPaused) {
            this.mPendingStartRecognitionWhenPaused = true;
        } else {
            this.mSearchBar.startRecognition();
        }
    }

    /* access modifiers changed from: package-private */
    public void submitQuery(String str) {
        queryComplete();
        SearchResultProvider searchResultProvider = this.mProvider;
        if (searchResultProvider != null) {
            searchResultProvider.onQueryTextSubmit(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateFocus() {
        RowsSupportFragment rowsSupportFragment;
        ObjectAdapter objectAdapter = this.mResultAdapter;
        if (objectAdapter == null || objectAdapter.size() <= 0 || (rowsSupportFragment = this.mRowsSupportFragment) == null || rowsSupportFragment.getAdapter() != this.mResultAdapter) {
            this.mSearchBar.requestFocus();
        } else {
            focusOnResults();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateSearchBarVisibility() {
        int i5;
        int i6;
        ObjectAdapter objectAdapter;
        RowsSupportFragment rowsSupportFragment = this.mRowsSupportFragment;
        if (rowsSupportFragment != null) {
            i5 = rowsSupportFragment.getSelectedPosition();
        } else {
            i5 = -1;
        }
        SearchBar searchBar = this.mSearchBar;
        if (i5 <= 0 || (objectAdapter = this.mResultAdapter) == null || objectAdapter.size() == 0) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        searchBar.setVisibility(i6);
    }

    public static Bundle createArgs(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(ARG_QUERY, str);
        bundle.putString(ARG_TITLE, str2);
        return bundle;
    }

    public void displayCompletions(CompletionInfo[] completionInfoArr) {
        this.mSearchBar.displayCompletions(completionInfoArr);
    }

    public void setSearchQuery(Intent intent, boolean z4) {
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
            setSearchQuery(stringArrayListExtra.get(0), z4);
        }
    }

    private void setSearchQuery(String str) {
        this.mSearchBar.setSearchQuery(str);
    }
}

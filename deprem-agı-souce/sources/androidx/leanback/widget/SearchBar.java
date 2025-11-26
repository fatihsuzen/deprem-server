package androidx.leanback.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.leanback.R;
import androidx.leanback.widget.SearchEditText;
import androidx.leanback.widget.SearchOrbView;
import java.util.ArrayList;
import java.util.List;

public class SearchBar extends RelativeLayout {
    static final boolean DEBUG = false;
    static final int DEFAULT_PRIORITY = 1;
    static final float DEFAULT_RATE = 1.0f;
    static final int DO_NOT_LOOP = 0;
    static final float FULL_LEFT_VOLUME = 1.0f;
    static final float FULL_RIGHT_VOLUME = 1.0f;
    static final String TAG = "SearchBar";
    boolean mAutoStartRecognition;
    private int mBackgroundAlpha;
    private int mBackgroundSpeechAlpha;
    private Drawable mBadgeDrawable;
    private ImageView mBadgeView;
    private Drawable mBarBackground;
    private int mBarHeight;
    private final Context mContext;
    final Handler mHandler;
    private String mHint;
    private final InputMethodManager mInputMethodManager;
    private boolean mListening;
    private SearchBarPermissionListener mPermissionListener;
    boolean mRecognizing;
    SearchBarListener mSearchBarListener;
    String mSearchQuery;
    SearchEditText mSearchTextEditor;
    SparseIntArray mSoundMap;
    SoundPool mSoundPool;
    SpeechOrbView mSpeechOrbView;
    private SpeechRecognitionCallback mSpeechRecognitionCallback;
    private SpeechRecognizer mSpeechRecognizer;
    private final int mTextColor;
    private final int mTextColorSpeechMode;
    private final int mTextHintColor;
    private final int mTextHintColorSpeechMode;
    private String mTitle;

    public interface SearchBarListener {
        void onKeyboardDismiss(String str);

        void onSearchQueryChange(String str);

        void onSearchQuerySubmit(String str);
    }

    public interface SearchBarPermissionListener {
        void requestAudioPermission();
    }

    public SearchBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean isVoiceMode() {
        return this.mSpeechOrbView.isFocused();
    }

    private void loadSounds(Context context) {
        int[] iArr = {R.raw.lb_voice_failure, R.raw.lb_voice_open, R.raw.lb_voice_no_input, R.raw.lb_voice_success};
        for (int i5 = 0; i5 < 4; i5++) {
            int i6 = iArr[i5];
            this.mSoundMap.put(i6, this.mSoundPool.load(context, i6, 1));
        }
    }

    private void play(final int i5) {
        this.mHandler.post(new Runnable() {
            public void run() {
                SearchBar.this.mSoundPool.play(SearchBar.this.mSoundMap.get(i5), 1.0f, 1.0f, 1, 0, 1.0f);
            }
        });
    }

    private void updateHint() {
        String string = getResources().getString(R.string.lb_search_bar_hint);
        if (!TextUtils.isEmpty(this.mTitle)) {
            if (isVoiceMode()) {
                string = getResources().getString(R.string.lb_search_bar_hint_with_title_speech, new Object[]{this.mTitle});
            } else {
                string = getResources().getString(R.string.lb_search_bar_hint_with_title, new Object[]{this.mTitle});
            }
        } else if (isVoiceMode()) {
            string = getResources().getString(R.string.lb_search_bar_hint_speech);
        }
        this.mHint = string;
        SearchEditText searchEditText = this.mSearchTextEditor;
        if (searchEditText != null) {
            searchEditText.setHint(string);
        }
    }

    public void displayCompletions(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String completionInfo : list) {
                arrayList.add(new CompletionInfo((long) arrayList.size(), arrayList.size(), completionInfo));
            }
        }
        displayCompletions((CompletionInfo[]) arrayList.toArray(new CompletionInfo[arrayList.size()]));
    }

    public Drawable getBadgeDrawable() {
        return this.mBadgeDrawable;
    }

    public CharSequence getHint() {
        return this.mHint;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* access modifiers changed from: package-private */
    public void hideNativeKeyboard() {
        this.mInputMethodManager.hideSoftInputFromWindow(this.mSearchTextEditor.getWindowToken(), 0);
    }

    public boolean isRecognizing() {
        return this.mRecognizing;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mSoundPool = new SoundPool(2, 1, 0);
        loadSounds(this.mContext);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        stopRecognition();
        this.mSoundPool.release();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mBarBackground = ((RelativeLayout) findViewById(R.id.lb_search_bar_items)).getBackground();
        this.mSearchTextEditor = (SearchEditText) findViewById(R.id.lb_search_text_editor);
        ImageView imageView = (ImageView) findViewById(R.id.lb_search_bar_badge);
        this.mBadgeView = imageView;
        Drawable drawable = this.mBadgeDrawable;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        this.mSearchTextEditor.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z4) {
                if (z4) {
                    SearchBar.this.showNativeKeyboard();
                } else {
                    SearchBar.this.hideNativeKeyboard();
                }
                SearchBar.this.updateUi(z4);
            }
        });
        final AnonymousClass2 r02 = new Runnable() {
            public void run() {
                SearchBar searchBar = SearchBar.this;
                searchBar.setSearchQueryInternal(searchBar.mSearchTextEditor.getText().toString());
            }
        };
        this.mSearchTextEditor.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            }

            public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                SearchBar searchBar = SearchBar.this;
                if (!searchBar.mRecognizing) {
                    searchBar.mHandler.removeCallbacks(r02);
                    SearchBar.this.mHandler.post(r02);
                }
            }
        });
        this.mSearchTextEditor.setOnKeyboardDismissListener(new SearchEditText.OnKeyboardDismissListener() {
            public void onKeyboardDismiss() {
                SearchBar searchBar = SearchBar.this;
                SearchBarListener searchBarListener = searchBar.mSearchBarListener;
                if (searchBarListener != null) {
                    searchBarListener.onKeyboardDismiss(searchBar.mSearchQuery);
                }
            }
        });
        this.mSearchTextEditor.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
                if (3 == i5 || i5 == 0) {
                    SearchBar searchBar = SearchBar.this;
                    if (searchBar.mSearchBarListener != null) {
                        searchBar.hideNativeKeyboard();
                        SearchBar.this.mHandler.postDelayed(new Runnable() {
                            public void run() {
                                SearchBar.this.submitQuery();
                            }
                        }, 500);
                        return true;
                    }
                }
                if (1 == i5) {
                    SearchBar searchBar2 = SearchBar.this;
                    if (searchBar2.mSearchBarListener != null) {
                        searchBar2.hideNativeKeyboard();
                        SearchBar.this.mHandler.postDelayed(new Runnable() {
                            public void run() {
                                SearchBar searchBar = SearchBar.this;
                                searchBar.mSearchBarListener.onKeyboardDismiss(searchBar.mSearchQuery);
                            }
                        }, 500);
                        return true;
                    }
                }
                if (2 != i5) {
                    return false;
                }
                SearchBar.this.hideNativeKeyboard();
                SearchBar.this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        SearchBar searchBar = SearchBar.this;
                        searchBar.mAutoStartRecognition = true;
                        searchBar.mSpeechOrbView.requestFocus();
                    }
                }, 500);
                return true;
            }
        });
        this.mSearchTextEditor.setPrivateImeOptions("escapeNorth,voiceDismiss");
        SpeechOrbView speechOrbView = (SpeechOrbView) findViewById(R.id.lb_search_bar_speech_orb);
        this.mSpeechOrbView = speechOrbView;
        speechOrbView.setOnOrbClickedListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchBar.this.toggleRecognition();
            }
        });
        this.mSpeechOrbView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z4) {
                if (z4) {
                    SearchBar.this.hideNativeKeyboard();
                    SearchBar searchBar = SearchBar.this;
                    if (searchBar.mAutoStartRecognition) {
                        searchBar.startRecognition();
                        SearchBar.this.mAutoStartRecognition = false;
                    }
                } else {
                    SearchBar.this.stopRecognition();
                }
                SearchBar.this.updateUi(z4);
            }
        });
        updateUi(hasFocus());
        updateHint();
    }

    /* access modifiers changed from: package-private */
    public void playSearchFailure() {
        play(R.raw.lb_voice_failure);
    }

    /* access modifiers changed from: package-private */
    public void playSearchOpen() {
        play(R.raw.lb_voice_open);
    }

    /* access modifiers changed from: package-private */
    public void playSearchSuccess() {
        play(R.raw.lb_voice_success);
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.mBadgeDrawable = drawable;
        ImageView imageView = this.mBadgeView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            if (drawable != null) {
                this.mBadgeView.setVisibility(0);
            } else {
                this.mBadgeView.setVisibility(8);
            }
        }
    }

    public void setNextFocusDownId(int i5) {
        this.mSpeechOrbView.setNextFocusDownId(i5);
        this.mSearchTextEditor.setNextFocusDownId(i5);
    }

    public void setPermissionListener(SearchBarPermissionListener searchBarPermissionListener) {
        this.mPermissionListener = searchBarPermissionListener;
    }

    public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
        SpeechOrbView speechOrbView = this.mSpeechOrbView;
        if (speechOrbView != null) {
            speechOrbView.setNotListeningOrbColors(colors);
        }
    }

    public void setSearchAffordanceColorsInListening(SearchOrbView.Colors colors) {
        SpeechOrbView speechOrbView = this.mSpeechOrbView;
        if (speechOrbView != null) {
            speechOrbView.setListeningOrbColors(colors);
        }
    }

    public void setSearchBarListener(SearchBarListener searchBarListener) {
        this.mSearchBarListener = searchBarListener;
    }

    public void setSearchQuery(String str) {
        stopRecognition();
        this.mSearchTextEditor.setText(str);
        setSearchQueryInternal(str);
    }

    /* access modifiers changed from: package-private */
    public void setSearchQueryInternal(String str) {
        if (!TextUtils.equals(this.mSearchQuery, str)) {
            this.mSearchQuery = str;
            SearchBarListener searchBarListener = this.mSearchBarListener;
            if (searchBarListener != null) {
                searchBarListener.onSearchQueryChange(str);
            }
        }
    }

    @Deprecated
    public void setSpeechRecognitionCallback(SpeechRecognitionCallback speechRecognitionCallback) {
        this.mSpeechRecognitionCallback = speechRecognitionCallback;
        if (speechRecognitionCallback != null && this.mSpeechRecognizer != null) {
            throw new IllegalStateException("Can't have speech recognizer and request");
        }
    }

    public void setSpeechRecognizer(SpeechRecognizer speechRecognizer) {
        stopRecognition();
        SpeechRecognizer speechRecognizer2 = this.mSpeechRecognizer;
        if (speechRecognizer2 != null) {
            speechRecognizer2.setRecognitionListener((RecognitionListener) null);
            if (this.mListening) {
                this.mSpeechRecognizer.cancel();
                this.mListening = false;
            }
        }
        this.mSpeechRecognizer = speechRecognizer;
        if (this.mSpeechRecognitionCallback != null && speechRecognizer != null) {
            throw new IllegalStateException("Can't have speech recognizer and request");
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        updateHint();
    }

    /* access modifiers changed from: package-private */
    public void showNativeKeyboard() {
        this.mHandler.post(new Runnable() {
            public void run() {
                SearchBar.this.mSearchTextEditor.requestFocusFromTouch();
                SearchBar.this.mSearchTextEditor.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, (float) SearchBar.this.mSearchTextEditor.getWidth(), (float) SearchBar.this.mSearchTextEditor.getHeight(), 0));
                SearchBar.this.mSearchTextEditor.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, (float) SearchBar.this.mSearchTextEditor.getWidth(), (float) SearchBar.this.mSearchTextEditor.getHeight(), 0));
            }
        });
    }

    public void startRecognition() {
        if (!this.mRecognizing) {
            if (!hasFocus()) {
                requestFocus();
            }
            if (this.mSpeechRecognitionCallback != null) {
                this.mSearchTextEditor.setText("");
                this.mSearchTextEditor.setHint("");
                this.mSpeechRecognitionCallback.recognizeSpeech();
                this.mRecognizing = true;
            } else if (this.mSpeechRecognizer != null) {
                if (getContext().checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                    SearchBarPermissionListener searchBarPermissionListener = this.mPermissionListener;
                    if (searchBarPermissionListener != null) {
                        searchBarPermissionListener.requestAudioPermission();
                        return;
                    }
                    throw new IllegalStateException("android.permission.RECORD_AUDIO required for search");
                }
                this.mRecognizing = true;
                this.mSearchTextEditor.setText("");
                Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
                intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
                intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
                this.mSpeechRecognizer.setRecognitionListener(new RecognitionListener() {
                    public void onBeginningOfSpeech() {
                    }

                    public void onBufferReceived(byte[] bArr) {
                    }

                    public void onEndOfSpeech() {
                    }

                    public void onError(int i5) {
                        switch (i5) {
                            case 1:
                                Log.w(SearchBar.TAG, "recognizer network timeout");
                                break;
                            case 2:
                                Log.w(SearchBar.TAG, "recognizer network error");
                                break;
                            case 3:
                                Log.w(SearchBar.TAG, "recognizer audio error");
                                break;
                            case 4:
                                Log.w(SearchBar.TAG, "recognizer server error");
                                break;
                            case 5:
                                Log.w(SearchBar.TAG, "recognizer client error");
                                break;
                            case 6:
                                Log.w(SearchBar.TAG, "recognizer speech timeout");
                                break;
                            case 7:
                                Log.w(SearchBar.TAG, "recognizer no match");
                                break;
                            case 8:
                                Log.w(SearchBar.TAG, "recognizer busy");
                                break;
                            case 9:
                                Log.w(SearchBar.TAG, "recognizer insufficient permissions");
                                break;
                            default:
                                Log.d(SearchBar.TAG, "recognizer other error");
                                break;
                        }
                        SearchBar.this.stopRecognition();
                        SearchBar.this.playSearchFailure();
                    }

                    public void onEvent(int i5, Bundle bundle) {
                    }

                    public void onPartialResults(Bundle bundle) {
                        String str;
                        ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
                        if (stringArrayList != null && stringArrayList.size() != 0) {
                            String str2 = stringArrayList.get(0);
                            if (stringArrayList.size() > 1) {
                                str = stringArrayList.get(1);
                            } else {
                                str = null;
                            }
                            SearchBar.this.mSearchTextEditor.updateRecognizedText(str2, str);
                        }
                    }

                    public void onReadyForSpeech(Bundle bundle) {
                        SearchBar.this.mSpeechOrbView.showListening();
                        SearchBar.this.playSearchOpen();
                    }

                    public void onResults(Bundle bundle) {
                        ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
                        if (stringArrayList != null) {
                            SearchBar.this.mSearchQuery = stringArrayList.get(0);
                            SearchBar searchBar = SearchBar.this;
                            searchBar.mSearchTextEditor.setText(searchBar.mSearchQuery);
                            SearchBar.this.submitQuery();
                        }
                        SearchBar.this.stopRecognition();
                        SearchBar.this.playSearchSuccess();
                    }

                    public void onRmsChanged(float f5) {
                        int i5;
                        if (f5 < 0.0f) {
                            i5 = 0;
                        } else {
                            i5 = (int) (f5 * 10.0f);
                        }
                        SearchBar.this.mSpeechOrbView.setSoundLevel(i5);
                    }
                });
                this.mListening = true;
                this.mSpeechRecognizer.startListening(intent);
            }
        }
    }

    public void stopRecognition() {
        if (this.mRecognizing) {
            this.mSearchTextEditor.setText(this.mSearchQuery);
            this.mSearchTextEditor.setHint(this.mHint);
            this.mRecognizing = false;
            if (this.mSpeechRecognitionCallback == null && this.mSpeechRecognizer != null) {
                this.mSpeechOrbView.showNotListening();
                if (this.mListening) {
                    this.mSpeechRecognizer.cancel();
                    this.mListening = false;
                }
                this.mSpeechRecognizer.setRecognitionListener((RecognitionListener) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void submitQuery() {
        SearchBarListener searchBarListener;
        if (!TextUtils.isEmpty(this.mSearchQuery) && (searchBarListener = this.mSearchBarListener) != null) {
            searchBarListener.onSearchQuerySubmit(this.mSearchQuery);
        }
    }

    /* access modifiers changed from: package-private */
    public void toggleRecognition() {
        if (this.mRecognizing) {
            stopRecognition();
        } else {
            startRecognition();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateUi(boolean z4) {
        if (z4) {
            this.mBarBackground.setAlpha(this.mBackgroundSpeechAlpha);
            if (isVoiceMode()) {
                this.mSearchTextEditor.setTextColor(this.mTextHintColorSpeechMode);
                this.mSearchTextEditor.setHintTextColor(this.mTextHintColorSpeechMode);
            } else {
                this.mSearchTextEditor.setTextColor(this.mTextColorSpeechMode);
                this.mSearchTextEditor.setHintTextColor(this.mTextHintColorSpeechMode);
            }
        } else {
            this.mBarBackground.setAlpha(this.mBackgroundAlpha);
            this.mSearchTextEditor.setTextColor(this.mTextColor);
            this.mSearchTextEditor.setHintTextColor(this.mTextHintColor);
        }
        updateHint();
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchBar(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mHandler = new Handler();
        this.mAutoStartRecognition = false;
        this.mSoundMap = new SparseIntArray();
        this.mRecognizing = false;
        this.mContext = context;
        Resources resources = getResources();
        LayoutInflater.from(getContext()).inflate(R.layout.lb_search_bar, this, true);
        this.mBarHeight = getResources().getDimensionPixelSize(R.dimen.lb_search_bar_height);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBarHeight);
        layoutParams.addRule(10, -1);
        setLayoutParams(layoutParams);
        setBackgroundColor(0);
        setClipChildren(false);
        this.mSearchQuery = "";
        this.mInputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        this.mTextColorSpeechMode = resources.getColor(R.color.lb_search_bar_text_speech_mode);
        this.mTextColor = resources.getColor(R.color.lb_search_bar_text);
        this.mBackgroundSpeechAlpha = resources.getInteger(R.integer.lb_search_bar_speech_mode_background_alpha);
        this.mBackgroundAlpha = resources.getInteger(R.integer.lb_search_bar_text_mode_background_alpha);
        this.mTextHintColorSpeechMode = resources.getColor(R.color.lb_search_bar_hint_speech_mode);
        this.mTextHintColor = resources.getColor(R.color.lb_search_bar_hint);
    }

    public void displayCompletions(CompletionInfo[] completionInfoArr) {
        this.mInputMethodManager.displayCompletions(this.mSearchTextEditor, completionInfoArr);
    }
}

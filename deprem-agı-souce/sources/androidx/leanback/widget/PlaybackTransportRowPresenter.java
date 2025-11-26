package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.leanback.R;
import androidx.leanback.widget.ControlBarPresenter;
import androidx.leanback.widget.PlaybackControlsPresenter;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PlaybackSeekDataProvider;
import androidx.leanback.widget.PlaybackSeekUi;
import androidx.leanback.widget.PlaybackTransportRowView;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.SeekBar;
import java.util.Arrays;

public class PlaybackTransportRowPresenter extends PlaybackRowPresenter {
    float mDefaultSeekIncrement = 0.01f;
    Presenter mDescriptionPresenter;
    OnActionClickedListener mOnActionClickedListener;
    private final ControlBarPresenter.OnControlClickedListener mOnControlClickedListener;
    private final ControlBarPresenter.OnControlSelectedListener mOnControlSelectedListener;
    ControlBarPresenter mPlaybackControlsPresenter;
    int mProgressColor = 0;
    boolean mProgressColorSet;
    ControlBarPresenter mSecondaryControlsPresenter;
    int mSecondaryProgressColor = 0;
    boolean mSecondaryProgressColorSet;

    static class BoundData extends PlaybackControlsPresenter.BoundData {
        ViewHolder mRowViewHolder;

        BoundData() {
        }
    }

    public class ViewHolder extends PlaybackRowPresenter.ViewHolder implements PlaybackSeekUi {
        BoundData mControlsBoundData = new BoundData();
        final ViewGroup mControlsDock;
        ControlBarPresenter.ViewHolder mControlsVh;
        final TextView mCurrentTime;
        long mCurrentTimeInMs = Long.MIN_VALUE;
        final ViewGroup mDescriptionDock;
        final Presenter.ViewHolder mDescriptionViewHolder;
        final ImageView mImageView;
        boolean mInSeek;
        final PlaybackControlsRow.OnPlaybackProgressCallback mListener = new PlaybackControlsRow.OnPlaybackProgressCallback() {
            public void onBufferedPositionChanged(PlaybackControlsRow playbackControlsRow, long j5) {
                ViewHolder.this.setBufferedPosition(j5);
            }

            public void onCurrentPositionChanged(PlaybackControlsRow playbackControlsRow, long j5) {
                ViewHolder.this.setCurrentPosition(j5);
            }

            public void onDurationChanged(PlaybackControlsRow playbackControlsRow, long j5) {
                ViewHolder.this.setTotalTime(j5);
            }
        };
        PlaybackControlsRow.PlayPauseAction mPlayPauseAction;
        long[] mPositions;
        int mPositionsLength;
        final SeekBar mProgressBar;
        BoundData mSecondaryBoundData = new BoundData();
        final ViewGroup mSecondaryControlsDock;
        ControlBarPresenter.ViewHolder mSecondaryControlsVh;
        long mSecondaryProgressInMs;
        PlaybackSeekUi.Client mSeekClient;
        PlaybackSeekDataProvider mSeekDataProvider;
        Object mSelectedItem;
        Presenter.ViewHolder mSelectedViewHolder;
        final StringBuilder mTempBuilder = new StringBuilder();
        int mThumbHeroIndex = -1;
        PlaybackSeekDataProvider.ResultCallback mThumbResult = new PlaybackSeekDataProvider.ResultCallback() {
            public void onThumbnailLoaded(Bitmap bitmap, int i5) {
                ViewHolder viewHolder = ViewHolder.this;
                int childCount = i5 - (viewHolder.mThumbHeroIndex - (viewHolder.mThumbsBar.getChildCount() / 2));
                if (childCount >= 0 && childCount < ViewHolder.this.mThumbsBar.getChildCount()) {
                    ViewHolder.this.mThumbsBar.setThumbBitmap(childCount, bitmap);
                }
            }
        };
        final ThumbsBar mThumbsBar;
        final TextView mTotalTime;
        long mTotalTimeInMs = Long.MIN_VALUE;

        public ViewHolder(View view, Presenter presenter) {
            super(view);
            Presenter.ViewHolder viewHolder;
            this.mImageView = (ImageView) view.findViewById(R.id.image);
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.description_dock);
            this.mDescriptionDock = viewGroup;
            this.mCurrentTime = (TextView) view.findViewById(R.id.current_time);
            this.mTotalTime = (TextView) view.findViewById(R.id.total_time);
            SeekBar seekBar = (SeekBar) view.findViewById(R.id.playback_progress);
            this.mProgressBar = seekBar;
            seekBar.setOnClickListener(new View.OnClickListener(PlaybackTransportRowPresenter.this) {
                public void onClick(View view) {
                    ViewHolder viewHolder = ViewHolder.this;
                    PlaybackTransportRowPresenter.this.onProgressBarClicked(viewHolder);
                }
            });
            seekBar.setOnKeyListener(new View.OnKeyListener(PlaybackTransportRowPresenter.this) {
                public boolean onKey(View view, int i5, KeyEvent keyEvent) {
                    if (i5 != 4) {
                        if (i5 != 66) {
                            if (i5 != 69) {
                                if (i5 != 81) {
                                    if (i5 != 111) {
                                        if (i5 != 89) {
                                            if (i5 != 90) {
                                                switch (i5) {
                                                    case 19:
                                                    case 20:
                                                        return ViewHolder.this.mInSeek;
                                                    case 21:
                                                        break;
                                                    case 22:
                                                        break;
                                                    case 23:
                                                        break;
                                                    default:
                                                        return false;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (keyEvent.getAction() == 0) {
                                    ViewHolder.this.onForward();
                                }
                                return true;
                            }
                            if (keyEvent.getAction() == 0) {
                                ViewHolder.this.onBackward();
                            }
                            return true;
                        }
                        if (!ViewHolder.this.mInSeek) {
                            return false;
                        }
                        if (keyEvent.getAction() == 1) {
                            ViewHolder.this.stopSeek(false);
                        }
                        return true;
                    }
                    if (!ViewHolder.this.mInSeek) {
                        return false;
                    }
                    if (keyEvent.getAction() == 1) {
                        ViewHolder viewHolder = ViewHolder.this;
                        viewHolder.stopSeek(!viewHolder.mProgressBar.isAccessibilityFocused());
                    }
                    return true;
                }
            });
            seekBar.setAccessibilitySeekListener(new SeekBar.AccessibilitySeekListener(PlaybackTransportRowPresenter.this) {
                public boolean onAccessibilitySeekBackward() {
                    return ViewHolder.this.onBackward();
                }

                public boolean onAccessibilitySeekForward() {
                    return ViewHolder.this.onForward();
                }
            });
            seekBar.setMax(Integer.MAX_VALUE);
            this.mControlsDock = (ViewGroup) view.findViewById(R.id.controls_dock);
            this.mSecondaryControlsDock = (ViewGroup) view.findViewById(R.id.secondary_controls_dock);
            if (presenter == null) {
                viewHolder = null;
            } else {
                viewHolder = presenter.onCreateViewHolder(viewGroup);
            }
            this.mDescriptionViewHolder = viewHolder;
            if (viewHolder != null) {
                viewGroup.addView(viewHolder.view);
            }
            this.mThumbsBar = (ThumbsBar) view.findViewById(R.id.thumbs_row);
        }

        /* access modifiers changed from: package-private */
        public void dispatchItemSelection() {
            if (isSelected()) {
                if (this.mSelectedViewHolder == null) {
                    if (getOnItemViewSelectedListener() != null) {
                        getOnItemViewSelectedListener().onItemSelected((Presenter.ViewHolder) null, (Object) null, this, getRow());
                    }
                } else if (getOnItemViewSelectedListener() != null) {
                    getOnItemViewSelectedListener().onItemSelected(this.mSelectedViewHolder, this.mSelectedItem, this, getRow());
                }
            }
        }

        public final TextView getCurrentPositionView() {
            return this.mCurrentTime;
        }

        public final Presenter.ViewHolder getDescriptionViewHolder() {
            return this.mDescriptionViewHolder;
        }

        public final TextView getDurationView() {
            return this.mTotalTime;
        }

        /* access modifiers changed from: package-private */
        public Presenter getPresenter(boolean z4) {
            ObjectAdapter objectAdapter;
            if (z4) {
                objectAdapter = ((PlaybackControlsRow) getRow()).getPrimaryActionsAdapter();
            } else {
                objectAdapter = ((PlaybackControlsRow) getRow()).getSecondaryActionsAdapter();
            }
            Object obj = null;
            if (objectAdapter == null) {
                return null;
            }
            if (objectAdapter.getPresenterSelector() instanceof ControlButtonPresenterSelector) {
                return ((ControlButtonPresenterSelector) objectAdapter.getPresenterSelector()).getSecondaryPresenter();
            }
            if (objectAdapter.size() > 0) {
                obj = objectAdapter.get(0);
            }
            return objectAdapter.getPresenter(obj);
        }

        /* access modifiers changed from: package-private */
        public boolean onBackward() {
            if (!startSeek()) {
                return false;
            }
            updateProgressInSeek(false);
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean onForward() {
            if (!startSeek()) {
                return false;
            }
            updateProgressInSeek(true);
            return true;
        }

        /* access modifiers changed from: protected */
        public void onSetCurrentPositionLabel(long j5) {
            if (this.mCurrentTime != null) {
                PlaybackTransportRowPresenter.formatTime(j5, this.mTempBuilder);
                this.mCurrentTime.setText(this.mTempBuilder.toString());
            }
        }

        /* access modifiers changed from: protected */
        public void onSetDurationLabel(long j5) {
            if (this.mTotalTime != null) {
                PlaybackTransportRowPresenter.formatTime(j5, this.mTempBuilder);
                this.mTotalTime.setText(this.mTempBuilder.toString());
            }
        }

        /* access modifiers changed from: package-private */
        public void setBufferedPosition(long j5) {
            this.mSecondaryProgressInMs = j5;
            this.mProgressBar.setSecondaryProgress((int) ((((double) j5) / ((double) this.mTotalTimeInMs)) * 2.147483647E9d));
        }

        /* access modifiers changed from: package-private */
        public void setCurrentPosition(long j5) {
            int i5;
            if (j5 != this.mCurrentTimeInMs) {
                this.mCurrentTimeInMs = j5;
                onSetCurrentPositionLabel(j5);
            }
            if (!this.mInSeek) {
                long j6 = this.mTotalTimeInMs;
                if (j6 > 0) {
                    i5 = (int) ((((double) this.mCurrentTimeInMs) / ((double) j6)) * 2.147483647E9d);
                } else {
                    i5 = 0;
                }
                this.mProgressBar.setProgress(i5);
            }
        }

        public void setPlaybackSeekUiClient(PlaybackSeekUi.Client client) {
            this.mSeekClient = client;
        }

        /* access modifiers changed from: package-private */
        public void setTotalTime(long j5) {
            if (this.mTotalTimeInMs != j5) {
                this.mTotalTimeInMs = j5;
                onSetDurationLabel(j5);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean startSeek() {
            long[] jArr;
            if (this.mInSeek) {
                return true;
            }
            PlaybackSeekUi.Client client = this.mSeekClient;
            if (client == null || !client.isSeekEnabled() || this.mTotalTimeInMs <= 0) {
                return false;
            }
            this.mInSeek = true;
            this.mSeekClient.onSeekStarted();
            PlaybackSeekDataProvider playbackSeekDataProvider = this.mSeekClient.getPlaybackSeekDataProvider();
            this.mSeekDataProvider = playbackSeekDataProvider;
            if (playbackSeekDataProvider != null) {
                jArr = playbackSeekDataProvider.getSeekPositions();
            } else {
                jArr = null;
            }
            this.mPositions = jArr;
            if (jArr != null) {
                int binarySearch = Arrays.binarySearch(jArr, this.mTotalTimeInMs);
                if (binarySearch >= 0) {
                    this.mPositionsLength = binarySearch + 1;
                } else {
                    this.mPositionsLength = -1 - binarySearch;
                }
            } else {
                this.mPositionsLength = 0;
            }
            this.mControlsVh.view.setVisibility(8);
            this.mSecondaryControlsVh.view.setVisibility(4);
            this.mDescriptionViewHolder.view.setVisibility(4);
            this.mThumbsBar.setVisibility(0);
            return true;
        }

        /* access modifiers changed from: package-private */
        public void stopSeek(boolean z4) {
            if (this.mInSeek) {
                this.mInSeek = false;
                this.mSeekClient.onSeekFinished(z4);
                PlaybackSeekDataProvider playbackSeekDataProvider = this.mSeekDataProvider;
                if (playbackSeekDataProvider != null) {
                    playbackSeekDataProvider.reset();
                }
                this.mThumbHeroIndex = -1;
                this.mThumbsBar.clearThumbBitmaps();
                this.mSeekDataProvider = null;
                this.mPositions = null;
                this.mPositionsLength = 0;
                this.mControlsVh.view.setVisibility(0);
                this.mSecondaryControlsVh.view.setVisibility(0);
                this.mDescriptionViewHolder.view.setVisibility(0);
                this.mThumbsBar.setVisibility(4);
            }
        }

        /* access modifiers changed from: package-private */
        public void updateProgressInSeek(boolean z4) {
            long j5;
            long j6 = this.mCurrentTimeInMs;
            int i5 = this.mPositionsLength;
            long j7 = 0;
            if (i5 > 0) {
                int i6 = 0;
                int binarySearch = Arrays.binarySearch(this.mPositions, 0, i5, j6);
                if (z4) {
                    if (binarySearch < 0) {
                        int i7 = -1 - binarySearch;
                        if (i7 <= this.mPositionsLength - 1) {
                            j5 = this.mPositions[i7];
                            i6 = i7;
                        } else {
                            j5 = this.mTotalTimeInMs;
                            if (i7 > 0) {
                                i6 = -2 - binarySearch;
                            }
                        }
                        j7 = j5;
                    } else if (binarySearch < this.mPositionsLength - 1) {
                        i6 = binarySearch + 1;
                        j7 = this.mPositions[i6];
                    } else {
                        j7 = this.mTotalTimeInMs;
                        i6 = binarySearch;
                    }
                } else if (binarySearch >= 0) {
                    if (binarySearch > 0) {
                        i6 = binarySearch - 1;
                        j7 = this.mPositions[i6];
                    }
                } else if (-1 - binarySearch > 0) {
                    i6 = -2 - binarySearch;
                    j7 = this.mPositions[i6];
                }
                updateThumbsInSeek(i6, z4);
            } else {
                long defaultSeekIncrement = (long) (((float) this.mTotalTimeInMs) * PlaybackTransportRowPresenter.this.getDefaultSeekIncrement());
                if (!z4) {
                    defaultSeekIncrement = -defaultSeekIncrement;
                }
                long j8 = j6 + defaultSeekIncrement;
                long j9 = this.mTotalTimeInMs;
                if (j8 > j9) {
                    j7 = j9;
                } else if (j8 >= 0) {
                    j7 = j8;
                }
            }
            this.mProgressBar.setProgress((int) ((((double) j7) / ((double) this.mTotalTimeInMs)) * 2.147483647E9d));
            this.mSeekClient.onSeekPositionChanged(j7);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0085 A[LOOP:2: B:27:0x0085->B:28:0x0087, LOOP_START, PHI: r7 
          PHI: (r7v1 int) = (r7v0 int), (r7v2 int) binds: [B:26:0x0083, B:28:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0091 A[LOOP:3: B:29:0x0091->B:30:0x0093, LOOP_START, PHI: r5 
          PHI: (r5v5 int) = (r5v3 int), (r5v6 int) binds: [B:26:0x0083, B:30:0x0093] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a5 A[LOOP:4: B:31:0x009d->B:33:0x00a5, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b2 A[LOOP:5: B:35:0x00b0->B:36:0x00b2, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00ad A[EDGE_INSN: B:43:0x00ad->B:34:0x00ad ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void updateThumbsInSeek(int r12, boolean r13) {
            /*
                r11 = this;
                int r0 = r11.mThumbHeroIndex
                if (r0 != r12) goto L_0x0006
                goto L_0x00ba
            L_0x0006:
                androidx.leanback.widget.ThumbsBar r0 = r11.mThumbsBar
                int r0 = r0.getChildCount()
                if (r0 < 0) goto L_0x00bb
                r1 = r0 & 1
                if (r1 == 0) goto L_0x00bb
                int r1 = r0 / 2
                int r2 = r12 - r1
                r3 = 0
                int r2 = java.lang.Math.max(r2, r3)
                int r4 = r12 + r1
                int r5 = r11.mPositionsLength
                r6 = 1
                int r5 = r5 - r6
                int r4 = java.lang.Math.min(r4, r5)
                int r5 = r11.mThumbHeroIndex
                if (r5 >= 0) goto L_0x002c
                r7 = r2
            L_0x002a:
                r5 = r4
                goto L_0x0081
            L_0x002c:
                if (r12 <= r5) goto L_0x0030
                r13 = r6
                goto L_0x0031
            L_0x0030:
                r13 = r3
            L_0x0031:
                int r5 = r5 - r1
                int r5 = java.lang.Math.max(r5, r3)
                int r7 = r11.mThumbHeroIndex
                int r7 = r7 + r1
                int r8 = r11.mPositionsLength
                int r8 = r8 - r6
                int r7 = java.lang.Math.min(r7, r8)
                if (r13 == 0) goto L_0x0062
                int r7 = r7 + r6
                int r5 = java.lang.Math.max(r7, r2)
                r7 = r2
            L_0x0048:
                int r8 = r5 + -1
                if (r7 > r8) goto L_0x0060
                androidx.leanback.widget.ThumbsBar r8 = r11.mThumbsBar
                int r9 = r7 - r12
                int r9 = r9 + r1
                int r10 = r11.mThumbHeroIndex
                int r10 = r7 - r10
                int r10 = r10 + r1
                android.graphics.Bitmap r10 = r8.getThumbBitmap(r10)
                r8.setThumbBitmap(r9, r10)
                int r7 = r7 + 1
                goto L_0x0048
            L_0x0060:
                r7 = r5
                goto L_0x002a
            L_0x0062:
                int r5 = r5 - r6
                int r5 = java.lang.Math.min(r5, r4)
                r7 = r4
            L_0x0068:
                int r8 = r5 + 1
                if (r7 < r8) goto L_0x0080
                androidx.leanback.widget.ThumbsBar r8 = r11.mThumbsBar
                int r9 = r7 - r12
                int r9 = r9 + r1
                int r10 = r11.mThumbHeroIndex
                int r10 = r7 - r10
                int r10 = r10 + r1
                android.graphics.Bitmap r10 = r8.getThumbBitmap(r10)
                r8.setThumbBitmap(r9, r10)
                int r7 = r7 + -1
                goto L_0x0068
            L_0x0080:
                r7 = r2
            L_0x0081:
                r11.mThumbHeroIndex = r12
                if (r13 == 0) goto L_0x0091
            L_0x0085:
                if (r7 > r5) goto L_0x009d
                androidx.leanback.widget.PlaybackSeekDataProvider r12 = r11.mSeekDataProvider
                androidx.leanback.widget.PlaybackSeekDataProvider$ResultCallback r13 = r11.mThumbResult
                r12.getThumbnail(r7, r13)
                int r7 = r7 + 1
                goto L_0x0085
            L_0x0091:
                if (r5 < r7) goto L_0x009d
                androidx.leanback.widget.PlaybackSeekDataProvider r12 = r11.mSeekDataProvider
                androidx.leanback.widget.PlaybackSeekDataProvider$ResultCallback r13 = r11.mThumbResult
                r12.getThumbnail(r5, r13)
                int r5 = r5 + -1
                goto L_0x0091
            L_0x009d:
                int r12 = r11.mThumbHeroIndex
                int r13 = r1 - r12
                int r13 = r13 + r2
                r5 = 0
                if (r3 >= r13) goto L_0x00ad
                androidx.leanback.widget.ThumbsBar r12 = r11.mThumbsBar
                r12.setThumbBitmap(r3, r5)
                int r3 = r3 + 1
                goto L_0x009d
            L_0x00ad:
                int r1 = r1 + r4
                int r1 = r1 - r12
                int r1 = r1 + r6
            L_0x00b0:
                if (r1 >= r0) goto L_0x00ba
                androidx.leanback.widget.ThumbsBar r12 = r11.mThumbsBar
                r12.setThumbBitmap(r1, r5)
                int r1 = r1 + 1
                goto L_0x00b0
            L_0x00ba:
                return
            L_0x00bb:
                java.lang.RuntimeException r12 = new java.lang.RuntimeException
                r12.<init>()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.PlaybackTransportRowPresenter.ViewHolder.updateThumbsInSeek(int, boolean):void");
        }
    }

    public PlaybackTransportRowPresenter() {
        AnonymousClass1 r12 = new ControlBarPresenter.OnControlSelectedListener() {
            public void onControlSelected(Presenter.ViewHolder viewHolder, Object obj, ControlBarPresenter.BoundData boundData) {
                ViewHolder viewHolder2 = ((BoundData) boundData).mRowViewHolder;
                if (viewHolder2.mSelectedViewHolder != viewHolder || viewHolder2.mSelectedItem != obj) {
                    viewHolder2.mSelectedViewHolder = viewHolder;
                    viewHolder2.mSelectedItem = obj;
                    viewHolder2.dispatchItemSelection();
                }
            }
        };
        this.mOnControlSelectedListener = r12;
        AnonymousClass2 r22 = new ControlBarPresenter.OnControlClickedListener() {
            public void onControlClicked(Presenter.ViewHolder viewHolder, Object obj, ControlBarPresenter.BoundData boundData) {
                ViewHolder viewHolder2 = ((BoundData) boundData).mRowViewHolder;
                if (viewHolder2.getOnItemViewClickedListener() != null) {
                    viewHolder2.getOnItemViewClickedListener().onItemClicked(viewHolder, obj, viewHolder2, viewHolder2.getRow());
                }
                OnActionClickedListener onActionClickedListener = PlaybackTransportRowPresenter.this.mOnActionClickedListener;
                if (onActionClickedListener != null && (obj instanceof Action)) {
                    onActionClickedListener.onActionClicked((Action) obj);
                }
            }
        };
        this.mOnControlClickedListener = r22;
        setHeaderPresenter((RowHeaderPresenter) null);
        setSelectEffectEnabled(false);
        int i5 = R.layout.lb_control_bar;
        ControlBarPresenter controlBarPresenter = new ControlBarPresenter(i5);
        this.mPlaybackControlsPresenter = controlBarPresenter;
        controlBarPresenter.setDefaultFocusToMiddle(false);
        ControlBarPresenter controlBarPresenter2 = new ControlBarPresenter(i5);
        this.mSecondaryControlsPresenter = controlBarPresenter2;
        controlBarPresenter2.setDefaultFocusToMiddle(false);
        this.mPlaybackControlsPresenter.setOnControlSelectedListener(r12);
        this.mSecondaryControlsPresenter.setOnControlSelectedListener(r12);
        this.mPlaybackControlsPresenter.setOnControlClickedListener(r22);
        this.mSecondaryControlsPresenter.setOnControlClickedListener(r22);
    }

    static void formatTime(long j5, StringBuilder sb) {
        sb.setLength(0);
        if (j5 < 0) {
            sb.append("--");
            return;
        }
        long j6 = j5 / 1000;
        long j7 = j6 / 60;
        long j8 = j7 / 60;
        long j9 = j6 - (j7 * 60);
        long j10 = j7 - (60 * j8);
        if (j8 > 0) {
            sb.append(j8);
            sb.append(':');
            if (j10 < 10) {
                sb.append('0');
            }
        }
        sb.append(j10);
        sb.append(':');
        if (j9 < 10) {
            sb.append('0');
        }
        sb.append(j9);
    }

    private static int getDefaultProgressColor(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.playbackProgressPrimaryColor, typedValue, true)) {
            return context.getResources().getColor(typedValue.resourceId);
        }
        return context.getResources().getColor(R.color.lb_playback_progress_color_no_theme);
    }

    private static int getDefaultSecondaryProgressColor(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.playbackProgressSecondaryColor, typedValue, true)) {
            return context.getResources().getColor(typedValue.resourceId);
        }
        return context.getResources().getColor(R.color.lb_playback_progress_secondary_color_no_theme);
    }

    private void initRow(final ViewHolder viewHolder) {
        int i5;
        int i6;
        viewHolder.mControlsVh = (ControlBarPresenter.ViewHolder) this.mPlaybackControlsPresenter.onCreateViewHolder(viewHolder.mControlsDock);
        SeekBar seekBar = viewHolder.mProgressBar;
        if (this.mProgressColorSet) {
            i5 = this.mProgressColor;
        } else {
            i5 = getDefaultProgressColor(viewHolder.mControlsDock.getContext());
        }
        seekBar.setProgressColor(i5);
        SeekBar seekBar2 = viewHolder.mProgressBar;
        if (this.mSecondaryProgressColorSet) {
            i6 = this.mSecondaryProgressColor;
        } else {
            i6 = getDefaultSecondaryProgressColor(viewHolder.mControlsDock.getContext());
        }
        seekBar2.setSecondaryProgressColor(i6);
        viewHolder.mControlsDock.addView(viewHolder.mControlsVh.view);
        ControlBarPresenter.ViewHolder viewHolder2 = (ControlBarPresenter.ViewHolder) this.mSecondaryControlsPresenter.onCreateViewHolder(viewHolder.mSecondaryControlsDock);
        viewHolder.mSecondaryControlsVh = viewHolder2;
        viewHolder.mSecondaryControlsDock.addView(viewHolder2.view);
        ((PlaybackTransportRowView) viewHolder.view.findViewById(R.id.transport_row)).setOnUnhandledKeyListener(new PlaybackTransportRowView.OnUnhandledKeyListener() {
            public boolean onUnhandledKey(KeyEvent keyEvent) {
                if (viewHolder.getOnKeyListener() != null) {
                    return viewHolder.getOnKeyListener().onKey(viewHolder.view, keyEvent.getKeyCode(), keyEvent);
                }
                return false;
            }
        });
    }

    /* access modifiers changed from: protected */
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lb_playback_transport_controls_row, viewGroup, false), this.mDescriptionPresenter);
        initRow(viewHolder);
        return viewHolder;
    }

    public float getDefaultSeekIncrement() {
        return this.mDefaultSeekIncrement;
    }

    public OnActionClickedListener getOnActionClickedListener() {
        return this.mOnActionClickedListener;
    }

    @ColorInt
    public int getProgressColor() {
        return this.mProgressColor;
    }

    @ColorInt
    public int getSecondaryProgressColor() {
        return this.mSecondaryProgressColor;
    }

    /* access modifiers changed from: protected */
    public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        PlaybackControlsRow playbackControlsRow = (PlaybackControlsRow) viewHolder2.getRow();
        if (playbackControlsRow.getItem() == null) {
            viewHolder2.mDescriptionDock.setVisibility(8);
        } else {
            viewHolder2.mDescriptionDock.setVisibility(0);
            Presenter.ViewHolder viewHolder3 = viewHolder2.mDescriptionViewHolder;
            if (viewHolder3 != null) {
                this.mDescriptionPresenter.onBindViewHolder(viewHolder3, playbackControlsRow.getItem());
            }
        }
        if (playbackControlsRow.getImageDrawable() == null) {
            viewHolder2.mImageView.setVisibility(8);
        } else {
            viewHolder2.mImageView.setVisibility(0);
        }
        viewHolder2.mImageView.setImageDrawable(playbackControlsRow.getImageDrawable());
        viewHolder2.mControlsBoundData.adapter = playbackControlsRow.getPrimaryActionsAdapter();
        viewHolder2.mControlsBoundData.presenter = viewHolder2.getPresenter(true);
        BoundData boundData = viewHolder2.mControlsBoundData;
        boundData.mRowViewHolder = viewHolder2;
        this.mPlaybackControlsPresenter.onBindViewHolder(viewHolder2.mControlsVh, boundData);
        viewHolder2.mSecondaryBoundData.adapter = playbackControlsRow.getSecondaryActionsAdapter();
        viewHolder2.mSecondaryBoundData.presenter = viewHolder2.getPresenter(false);
        BoundData boundData2 = viewHolder2.mSecondaryBoundData;
        boundData2.mRowViewHolder = viewHolder2;
        this.mSecondaryControlsPresenter.onBindViewHolder(viewHolder2.mSecondaryControlsVh, boundData2);
        viewHolder2.setTotalTime(playbackControlsRow.getDuration());
        viewHolder2.setCurrentPosition(playbackControlsRow.getCurrentPosition());
        viewHolder2.setBufferedPosition(playbackControlsRow.getBufferedPosition());
        playbackControlsRow.setOnPlaybackProgressChangedListener(viewHolder2.mListener);
    }

    /* access modifiers changed from: protected */
    public void onProgressBarClicked(ViewHolder viewHolder) {
        if (viewHolder != null) {
            if (viewHolder.mPlayPauseAction == null) {
                viewHolder.mPlayPauseAction = new PlaybackControlsRow.PlayPauseAction(viewHolder.view.getContext());
            }
            if (viewHolder.getOnItemViewClickedListener() != null) {
                viewHolder.getOnItemViewClickedListener().onItemClicked(viewHolder, viewHolder.mPlayPauseAction, viewHolder, viewHolder.getRow());
            }
            OnActionClickedListener onActionClickedListener = this.mOnActionClickedListener;
            if (onActionClickedListener != null) {
                onActionClickedListener.onActionClicked(viewHolder.mPlayPauseAction);
            }
        }
    }

    public void onReappear(RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (viewHolder2.view.hasFocus()) {
            viewHolder2.mProgressBar.requestFocus();
        }
    }

    /* access modifiers changed from: protected */
    public void onRowViewAttachedToWindow(RowPresenter.ViewHolder viewHolder) {
        super.onRowViewAttachedToWindow(viewHolder);
        Presenter presenter = this.mDescriptionPresenter;
        if (presenter != null) {
            presenter.onViewAttachedToWindow(((ViewHolder) viewHolder).mDescriptionViewHolder);
        }
    }

    /* access modifiers changed from: protected */
    public void onRowViewDetachedFromWindow(RowPresenter.ViewHolder viewHolder) {
        super.onRowViewDetachedFromWindow(viewHolder);
        Presenter presenter = this.mDescriptionPresenter;
        if (presenter != null) {
            presenter.onViewDetachedFromWindow(((ViewHolder) viewHolder).mDescriptionViewHolder);
        }
    }

    /* access modifiers changed from: protected */
    public void onRowViewSelected(RowPresenter.ViewHolder viewHolder, boolean z4) {
        super.onRowViewSelected(viewHolder, z4);
        if (z4) {
            ((ViewHolder) viewHolder).dispatchItemSelection();
        }
    }

    /* access modifiers changed from: protected */
    public void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        PlaybackControlsRow playbackControlsRow = (PlaybackControlsRow) viewHolder2.getRow();
        Presenter.ViewHolder viewHolder3 = viewHolder2.mDescriptionViewHolder;
        if (viewHolder3 != null) {
            this.mDescriptionPresenter.onUnbindViewHolder(viewHolder3);
        }
        this.mPlaybackControlsPresenter.onUnbindViewHolder(viewHolder2.mControlsVh);
        this.mSecondaryControlsPresenter.onUnbindViewHolder(viewHolder2.mSecondaryControlsVh);
        playbackControlsRow.setOnPlaybackProgressChangedListener((PlaybackControlsRow.OnPlaybackProgressCallback) null);
        super.onUnbindRowViewHolder(viewHolder);
    }

    public void setDefaultSeekIncrement(float f5) {
        this.mDefaultSeekIncrement = f5;
    }

    public void setDescriptionPresenter(Presenter presenter) {
        this.mDescriptionPresenter = presenter;
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.mOnActionClickedListener = onActionClickedListener;
    }

    public void setProgressColor(@ColorInt int i5) {
        this.mProgressColor = i5;
        this.mProgressColorSet = true;
    }

    public void setSecondaryProgressColor(@ColorInt int i5) {
        this.mSecondaryProgressColor = i5;
        this.mSecondaryProgressColorSet = true;
    }
}

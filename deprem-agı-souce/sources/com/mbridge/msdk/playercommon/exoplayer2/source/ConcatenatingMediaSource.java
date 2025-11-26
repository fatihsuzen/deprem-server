package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.ShuffleOrder;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatingMediaSource extends CompositeMediaSource<MediaSourceHolder> implements PlayerMessage.Target {
    private static final int MSG_ADD = 0;
    private static final int MSG_ADD_MULTIPLE = 1;
    private static final int MSG_CLEAR = 4;
    private static final int MSG_MOVE = 3;
    private static final int MSG_NOTIFY_LISTENER = 5;
    private static final int MSG_ON_COMPLETION = 6;
    private static final int MSG_REMOVE = 2;
    private final boolean isAtomic;
    private boolean listenerNotificationScheduled;
    private final Map<MediaPeriod, MediaSourceHolder> mediaSourceByMediaPeriod;
    private final List<MediaSourceHolder> mediaSourceHolders;
    private final List<MediaSourceHolder> mediaSourcesPublic;
    private final List<EventDispatcher> pendingOnCompletionActions;
    private int periodCount;
    private ExoPlayer player;
    private final MediaSourceHolder query;
    private ShuffleOrder shuffleOrder;
    private final Timeline.Window window;
    private int windowCount;

    private static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
        private final HashMap<Object, Integer> childIndexByUid = new HashMap<>();
        private final int[] firstPeriodInChildIndices;
        private final int[] firstWindowInChildIndices;
        private final int periodCount;
        private final Timeline[] timelines;
        private final Object[] uids;
        private final int windowCount;

        public ConcatenatedTimeline(Collection<MediaSourceHolder> collection, int i5, int i6, ShuffleOrder shuffleOrder, boolean z4) {
            super(z4, shuffleOrder);
            this.windowCount = i5;
            this.periodCount = i6;
            int size = collection.size();
            this.firstPeriodInChildIndices = new int[size];
            this.firstWindowInChildIndices = new int[size];
            this.timelines = new Timeline[size];
            this.uids = new Object[size];
            int i7 = 0;
            for (MediaSourceHolder next : collection) {
                this.timelines[i7] = next.timeline;
                this.firstPeriodInChildIndices[i7] = next.firstPeriodIndexInChild;
                this.firstWindowInChildIndices[i7] = next.firstWindowIndexInChild;
                Object[] objArr = this.uids;
                Object obj = next.uid;
                objArr[i7] = obj;
                this.childIndexByUid.put(obj, Integer.valueOf(i7));
                i7++;
            }
        }

        /* access modifiers changed from: protected */
        public final int getChildIndexByChildUid(Object obj) {
            Integer num = this.childIndexByUid.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        /* access modifiers changed from: protected */
        public final int getChildIndexByPeriodIndex(int i5) {
            return Util.binarySearchFloor(this.firstPeriodInChildIndices, i5 + 1, false, false);
        }

        /* access modifiers changed from: protected */
        public final int getChildIndexByWindowIndex(int i5) {
            return Util.binarySearchFloor(this.firstWindowInChildIndices, i5 + 1, false, false);
        }

        /* access modifiers changed from: protected */
        public final Object getChildUidByChildIndex(int i5) {
            return this.uids[i5];
        }

        /* access modifiers changed from: protected */
        public final int getFirstPeriodIndexByChildIndex(int i5) {
            return this.firstPeriodInChildIndices[i5];
        }

        /* access modifiers changed from: protected */
        public final int getFirstWindowIndexByChildIndex(int i5) {
            return this.firstWindowInChildIndices[i5];
        }

        public final int getPeriodCount() {
            return this.periodCount;
        }

        /* access modifiers changed from: protected */
        public final Timeline getTimelineByChildIndex(int i5) {
            return this.timelines[i5];
        }

        public final int getWindowCount() {
            return this.windowCount;
        }
    }

    private static final class DeferredTimeline extends ForwardingTimeline {
        private static final Object DUMMY_ID = new Object();
        private static final DummyTimeline dummyTimeline = new DummyTimeline();
        private static final Timeline.Period period = new Timeline.Period();
        private final Object replacedId;

        public DeferredTimeline() {
            this(dummyTimeline, (Object) null);
        }

        public final DeferredTimeline cloneWithNewTimeline(Timeline timeline) {
            Object obj;
            if (this.replacedId != null || timeline.getPeriodCount() <= 0) {
                obj = this.replacedId;
            } else {
                obj = timeline.getPeriod(0, period, true).uid;
            }
            return new DeferredTimeline(timeline, obj);
        }

        public final int getIndexOfPeriod(Object obj) {
            Timeline timeline = this.timeline;
            if (DUMMY_ID.equals(obj)) {
                obj = this.replacedId;
            }
            return timeline.getIndexOfPeriod(obj);
        }

        public final Timeline.Period getPeriod(int i5, Timeline.Period period2, boolean z4) {
            this.timeline.getPeriod(i5, period2, z4);
            if (Util.areEqual(period2.uid, this.replacedId)) {
                period2.uid = DUMMY_ID;
            }
            return period2;
        }

        public final Timeline getTimeline() {
            return this.timeline;
        }

        private DeferredTimeline(Timeline timeline, Object obj) {
            super(timeline);
            this.replacedId = obj;
        }
    }

    private static final class DummyTimeline extends Timeline {
        private DummyTimeline() {
        }

        public final int getIndexOfPeriod(Object obj) {
            return obj == null ? 0 : -1;
        }

        public final Timeline.Period getPeriod(int i5, Timeline.Period period, boolean z4) {
            return period.set((Object) null, (Object) null, 0, C.TIME_UNSET, 0);
        }

        public final int getPeriodCount() {
            return 1;
        }

        public final Timeline.Window getWindow(int i5, Timeline.Window window, boolean z4, long j5) {
            long j6 = 0;
            if (j5 > 0) {
                j6 = C.TIME_UNSET;
            }
            return window.set((Object) null, C.TIME_UNSET, C.TIME_UNSET, false, true, j6, C.TIME_UNSET, 0, 0, 0);
        }

        public final int getWindowCount() {
            return 1;
        }
    }

    private static final class EventDispatcher {
        public final Handler eventHandler;
        public final Runnable runnable;

        public EventDispatcher(Runnable runnable2) {
            Looper looper;
            this.runnable = runnable2;
            if (Looper.myLooper() != null) {
                looper = Looper.myLooper();
            } else {
                looper = Looper.getMainLooper();
            }
            this.eventHandler = new Handler(looper);
        }

        public final void dispatchEvent() {
            this.eventHandler.post(this.runnable);
        }
    }

    static final class MediaSourceHolder implements Comparable<MediaSourceHolder> {
        public List<DeferredMediaPeriod> activeMediaPeriods = new ArrayList();
        public int childIndex;
        public int firstPeriodIndexInChild;
        public int firstWindowIndexInChild;
        public boolean isPrepared;
        public boolean isRemoved;
        public final MediaSource mediaSource;
        public DeferredTimeline timeline = new DeferredTimeline();
        public final Object uid = new Object();

        public MediaSourceHolder(MediaSource mediaSource2) {
            this.mediaSource = mediaSource2;
        }

        public final void reset(int i5, int i6, int i7) {
            this.childIndex = i5;
            this.firstWindowIndexInChild = i6;
            this.firstPeriodIndexInChild = i7;
            this.isPrepared = false;
            this.isRemoved = false;
            this.activeMediaPeriods.clear();
        }

        public final int compareTo(@NonNull MediaSourceHolder mediaSourceHolder) {
            return this.firstPeriodIndexInChild - mediaSourceHolder.firstPeriodIndexInChild;
        }
    }

    private static final class MessageData<T> {
        @Nullable
        public final EventDispatcher actionOnCompletion;
        public final T customData;
        public final int index;

        public MessageData(int i5, T t5, @Nullable Runnable runnable) {
            EventDispatcher eventDispatcher;
            this.index = i5;
            if (runnable != null) {
                eventDispatcher = new EventDispatcher(runnable);
            } else {
                eventDispatcher = null;
            }
            this.actionOnCompletion = eventDispatcher;
            this.customData = t5;
        }
    }

    public ConcatenatingMediaSource() {
        this(false, (ShuffleOrder) new ShuffleOrder.DefaultShuffleOrder(0));
    }

    private void addMediaSourceInternal(int i5, MediaSourceHolder mediaSourceHolder) {
        if (i5 > 0) {
            MediaSourceHolder mediaSourceHolder2 = this.mediaSourceHolders.get(i5 - 1);
            mediaSourceHolder.reset(i5, mediaSourceHolder2.firstWindowIndexInChild + mediaSourceHolder2.timeline.getWindowCount(), mediaSourceHolder2.firstPeriodIndexInChild + mediaSourceHolder2.timeline.getPeriodCount());
        } else {
            mediaSourceHolder.reset(i5, 0, 0);
        }
        correctOffsets(i5, 1, mediaSourceHolder.timeline.getWindowCount(), mediaSourceHolder.timeline.getPeriodCount());
        this.mediaSourceHolders.add(i5, mediaSourceHolder);
        prepareChildSource(mediaSourceHolder, mediaSourceHolder.mediaSource);
    }

    private void addMediaSourcesInternal(int i5, Collection<MediaSourceHolder> collection) {
        for (MediaSourceHolder addMediaSourceInternal : collection) {
            addMediaSourceInternal(i5, addMediaSourceInternal);
            i5++;
        }
    }

    private void clearInternal() {
        for (int size = this.mediaSourceHolders.size() - 1; size >= 0; size--) {
            removeMediaSourceInternal(size);
        }
    }

    private void correctOffsets(int i5, int i6, int i7, int i8) {
        this.windowCount += i7;
        this.periodCount += i8;
        while (i5 < this.mediaSourceHolders.size()) {
            this.mediaSourceHolders.get(i5).childIndex += i6;
            this.mediaSourceHolders.get(i5).firstWindowIndexInChild += i7;
            this.mediaSourceHolders.get(i5).firstPeriodIndexInChild += i8;
            i5++;
        }
    }

    private int findMediaSourceHolderByPeriodIndex(int i5) {
        MediaSourceHolder mediaSourceHolder = this.query;
        mediaSourceHolder.firstPeriodIndexInChild = i5;
        int binarySearch = Collections.binarySearch(this.mediaSourceHolders, mediaSourceHolder);
        if (binarySearch < 0) {
            return (-binarySearch) - 2;
        }
        while (binarySearch < this.mediaSourceHolders.size() - 1) {
            int i6 = binarySearch + 1;
            if (this.mediaSourceHolders.get(i6).firstPeriodIndexInChild != i5) {
                break;
            }
            binarySearch = i6;
        }
        return binarySearch;
    }

    private void moveMediaSourceInternal(int i5, int i6) {
        int min = Math.min(i5, i6);
        int max = Math.max(i5, i6);
        int i7 = this.mediaSourceHolders.get(min).firstWindowIndexInChild;
        int i8 = this.mediaSourceHolders.get(min).firstPeriodIndexInChild;
        List<MediaSourceHolder> list = this.mediaSourceHolders;
        list.add(i6, list.remove(i5));
        while (min <= max) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(min);
            mediaSourceHolder.firstWindowIndexInChild = i7;
            mediaSourceHolder.firstPeriodIndexInChild = i8;
            i7 += mediaSourceHolder.timeline.getWindowCount();
            i8 += mediaSourceHolder.timeline.getPeriodCount();
            min++;
        }
    }

    private void notifyListener() {
        List list;
        this.listenerNotificationScheduled = false;
        if (this.pendingOnCompletionActions.isEmpty()) {
            list = Collections.EMPTY_LIST;
        } else {
            list = new ArrayList(this.pendingOnCompletionActions);
        }
        this.pendingOnCompletionActions.clear();
        refreshSourceInfo(new ConcatenatedTimeline(this.mediaSourceHolders, this.windowCount, this.periodCount, this.shuffleOrder, this.isAtomic), (Object) null);
        if (!list.isEmpty()) {
            this.player.createMessage(this).setType(6).setPayload(list).send();
        }
    }

    private void removeMediaSourceInternal(int i5) {
        MediaSourceHolder remove = this.mediaSourceHolders.remove(i5);
        DeferredTimeline deferredTimeline = remove.timeline;
        correctOffsets(i5, -1, -deferredTimeline.getWindowCount(), -deferredTimeline.getPeriodCount());
        remove.isRemoved = true;
        if (remove.activeMediaPeriods.isEmpty()) {
            releaseChildSource(remove);
        }
    }

    private void scheduleListenerNotification(@Nullable EventDispatcher eventDispatcher) {
        if (!this.listenerNotificationScheduled) {
            this.player.createMessage(this).setType(5).send();
            this.listenerNotificationScheduled = true;
        }
        if (eventDispatcher != null) {
            this.pendingOnCompletionActions.add(eventDispatcher);
        }
    }

    private void updateMediaSourceInternal(MediaSourceHolder mediaSourceHolder, Timeline timeline) {
        if (mediaSourceHolder != null) {
            DeferredTimeline deferredTimeline = mediaSourceHolder.timeline;
            if (deferredTimeline.getTimeline() != timeline) {
                int windowCount2 = timeline.getWindowCount() - deferredTimeline.getWindowCount();
                int periodCount2 = timeline.getPeriodCount() - deferredTimeline.getPeriodCount();
                if (!(windowCount2 == 0 && periodCount2 == 0)) {
                    correctOffsets(mediaSourceHolder.childIndex + 1, 0, windowCount2, periodCount2);
                }
                mediaSourceHolder.timeline = deferredTimeline.cloneWithNewTimeline(timeline);
                if (!mediaSourceHolder.isPrepared && !timeline.isEmpty()) {
                    timeline.getWindow(0, this.window);
                    long positionInFirstPeriodUs = this.window.getPositionInFirstPeriodUs() + this.window.getDefaultPositionUs();
                    for (int i5 = 0; i5 < mediaSourceHolder.activeMediaPeriods.size(); i5++) {
                        DeferredMediaPeriod deferredMediaPeriod = mediaSourceHolder.activeMediaPeriods.get(i5);
                        deferredMediaPeriod.setDefaultPreparePositionUs(positionInFirstPeriodUs);
                        deferredMediaPeriod.createPeriod();
                    }
                    mediaSourceHolder.isPrepared = true;
                }
                scheduleListenerNotification((EventDispatcher) null);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public final synchronized void addMediaSource(MediaSource mediaSource) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource, (Runnable) null);
    }

    public final synchronized void addMediaSources(Collection<MediaSource> collection) {
        addMediaSources(this.mediaSourcesPublic.size(), collection, (Runnable) null);
    }

    public final synchronized void clear() {
        clear((Runnable) null);
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(findMediaSourceHolderByPeriodIndex(mediaPeriodId.periodIndex));
        DeferredMediaPeriod deferredMediaPeriod = new DeferredMediaPeriod(mediaSourceHolder.mediaSource, mediaPeriodId.copyWithPeriodIndex(mediaPeriodId.periodIndex - mediaSourceHolder.firstPeriodIndexInChild), allocator);
        this.mediaSourceByMediaPeriod.put(deferredMediaPeriod, mediaSourceHolder);
        mediaSourceHolder.activeMediaPeriods.add(deferredMediaPeriod);
        if (mediaSourceHolder.isPrepared) {
            deferredMediaPeriod.createPeriod();
        }
        return deferredMediaPeriod;
    }

    public final synchronized MediaSource getMediaSource(int i5) {
        return this.mediaSourcesPublic.get(i5).mediaSource;
    }

    public final synchronized int getSize() {
        return this.mediaSourcesPublic.size();
    }

    public final void handleMessage(int i5, Object obj) throws ExoPlaybackException {
        switch (i5) {
            case 0:
                MessageData messageData = (MessageData) obj;
                this.shuffleOrder = this.shuffleOrder.cloneAndInsert(messageData.index, 1);
                addMediaSourceInternal(messageData.index, (MediaSourceHolder) messageData.customData);
                scheduleListenerNotification(messageData.actionOnCompletion);
                return;
            case 1:
                MessageData messageData2 = (MessageData) obj;
                this.shuffleOrder = this.shuffleOrder.cloneAndInsert(messageData2.index, ((Collection) messageData2.customData).size());
                addMediaSourcesInternal(messageData2.index, (Collection) messageData2.customData);
                scheduleListenerNotification(messageData2.actionOnCompletion);
                return;
            case 2:
                MessageData messageData3 = (MessageData) obj;
                this.shuffleOrder = this.shuffleOrder.cloneAndRemove(messageData3.index);
                removeMediaSourceInternal(messageData3.index);
                scheduleListenerNotification(messageData3.actionOnCompletion);
                return;
            case 3:
                MessageData messageData4 = (MessageData) obj;
                ShuffleOrder cloneAndRemove = this.shuffleOrder.cloneAndRemove(messageData4.index);
                this.shuffleOrder = cloneAndRemove;
                this.shuffleOrder = cloneAndRemove.cloneAndInsert(((Integer) messageData4.customData).intValue(), 1);
                moveMediaSourceInternal(messageData4.index, ((Integer) messageData4.customData).intValue());
                scheduleListenerNotification(messageData4.actionOnCompletion);
                return;
            case 4:
                clearInternal();
                scheduleListenerNotification((EventDispatcher) obj);
                return;
            case 5:
                notifyListener();
                return;
            case 6:
                List list = (List) obj;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    ((EventDispatcher) list.get(i6)).dispatchEvent();
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    public final synchronized void moveMediaSource(int i5, int i6) {
        moveMediaSource(i5, i6, (Runnable) null);
    }

    public final synchronized void prepareSourceInternal(ExoPlayer exoPlayer, boolean z4) {
        try {
            super.prepareSourceInternal(exoPlayer, z4);
            this.player = exoPlayer;
            if (this.mediaSourcesPublic.isEmpty()) {
                notifyListener();
            } else {
                this.shuffleOrder = this.shuffleOrder.cloneAndInsert(0, this.mediaSourcesPublic.size());
                addMediaSourcesInternal(0, this.mediaSourcesPublic);
                scheduleListenerNotification((EventDispatcher) null);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        MediaSourceHolder remove = this.mediaSourceByMediaPeriod.remove(mediaPeriod);
        ((DeferredMediaPeriod) mediaPeriod).releasePeriod();
        remove.activeMediaPeriods.remove(mediaPeriod);
        if (remove.activeMediaPeriods.isEmpty() && remove.isRemoved) {
            releaseChildSource(remove);
        }
    }

    public final void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.mediaSourceHolders.clear();
        this.player = null;
        this.shuffleOrder = this.shuffleOrder.cloneAndClear();
        this.windowCount = 0;
        this.periodCount = 0;
    }

    public final synchronized void removeMediaSource(int i5) {
        removeMediaSource(i5, (Runnable) null);
    }

    public ConcatenatingMediaSource(boolean z4) {
        this(z4, (ShuffleOrder) new ShuffleOrder.DefaultShuffleOrder(0));
    }

    /* access modifiers changed from: protected */
    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i5 = 0; i5 < mediaSourceHolder.activeMediaPeriods.size(); i5++) {
            if (mediaSourceHolder.activeMediaPeriods.get(i5).id.windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodIndex(mediaPeriodId.periodIndex + mediaSourceHolder.firstPeriodIndexInChild);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getWindowIndexForChildWindowIndex(MediaSourceHolder mediaSourceHolder, int i5) {
        return i5 + mediaSourceHolder.firstWindowIndexInChild;
    }

    /* access modifiers changed from: protected */
    public final void onChildSourceInfoRefreshed(MediaSourceHolder mediaSourceHolder, MediaSource mediaSource, Timeline timeline, @Nullable Object obj) {
        updateMediaSourceInternal(mediaSourceHolder, timeline);
    }

    public ConcatenatingMediaSource(boolean z4, ShuffleOrder shuffleOrder2) {
        this(z4, shuffleOrder2, new MediaSource[0]);
    }

    public final synchronized void addMediaSource(MediaSource mediaSource, @Nullable Runnable runnable) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource, runnable);
    }

    public final synchronized void addMediaSources(Collection<MediaSource> collection, @Nullable Runnable runnable) {
        addMediaSources(this.mediaSourcesPublic.size(), collection, runnable);
    }

    public final synchronized void clear(@Nullable Runnable runnable) {
        try {
            this.mediaSourcesPublic.clear();
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.createMessage(this).setType(4).setPayload(runnable != null ? new EventDispatcher(runnable) : null).send();
            } else if (runnable != null) {
                runnable.run();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void moveMediaSource(int r3, int r4, @androidx.annotation.Nullable java.lang.Runnable r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != r4) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            java.util.List<com.mbridge.msdk.playercommon.exoplayer2.source.ConcatenatingMediaSource$MediaSourceHolder> r0 = r2.mediaSourcesPublic     // Catch:{ all -> 0x002c }
            java.lang.Object r1 = r0.remove(r3)     // Catch:{ all -> 0x002c }
            r0.add(r4, r1)     // Catch:{ all -> 0x002c }
            com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer r0 = r2.player     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x002e
            com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage r0 = r0.createMessage(r2)     // Catch:{ all -> 0x002c }
            r1 = 3
            com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage r0 = r0.setType(r1)     // Catch:{ all -> 0x002c }
            com.mbridge.msdk.playercommon.exoplayer2.source.ConcatenatingMediaSource$MessageData r1 = new com.mbridge.msdk.playercommon.exoplayer2.source.ConcatenatingMediaSource$MessageData     // Catch:{ all -> 0x002c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x002c }
            r1.<init>(r3, r4, r5)     // Catch:{ all -> 0x002c }
            com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage r3 = r0.setPayload(r1)     // Catch:{ all -> 0x002c }
            r3.send()     // Catch:{ all -> 0x002c }
            goto L_0x0033
        L_0x002c:
            r3 = move-exception
            goto L_0x0035
        L_0x002e:
            if (r5 == 0) goto L_0x0033
            r5.run()     // Catch:{ all -> 0x002c }
        L_0x0033:
            monitor-exit(r2)
            return
        L_0x0035:
            monitor-exit(r2)     // Catch:{ all -> 0x002c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.ConcatenatingMediaSource.moveMediaSource(int, int, java.lang.Runnable):void");
    }

    public final synchronized void removeMediaSource(int i5, @Nullable Runnable runnable) {
        try {
            this.mediaSourcesPublic.remove(i5);
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.createMessage(this).setType(2).setPayload(new MessageData(i5, null, runnable)).send();
            } else if (runnable != null) {
                runnable.run();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public ConcatenatingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    public ConcatenatingMediaSource(boolean z4, MediaSource... mediaSourceArr) {
        this(z4, new ShuffleOrder.DefaultShuffleOrder(0), mediaSourceArr);
    }

    public final synchronized void addMediaSource(int i5, MediaSource mediaSource) {
        addMediaSource(i5, mediaSource, (Runnable) null);
    }

    public final synchronized void addMediaSources(int i5, Collection<MediaSource> collection) {
        addMediaSources(i5, collection, (Runnable) null);
    }

    public ConcatenatingMediaSource(boolean z4, ShuffleOrder shuffleOrder2, MediaSource... mediaSourceArr) {
        for (MediaSource checkNotNull : mediaSourceArr) {
            Assertions.checkNotNull(checkNotNull);
        }
        this.shuffleOrder = shuffleOrder2.getLength() > 0 ? shuffleOrder2.cloneAndClear() : shuffleOrder2;
        this.mediaSourceByMediaPeriod = new IdentityHashMap();
        this.mediaSourcesPublic = new ArrayList();
        this.mediaSourceHolders = new ArrayList();
        this.pendingOnCompletionActions = new ArrayList();
        this.query = new MediaSourceHolder((MediaSource) null);
        this.isAtomic = z4;
        this.window = new Timeline.Window();
        addMediaSources(Arrays.asList(mediaSourceArr));
    }

    public final synchronized void addMediaSource(int i5, MediaSource mediaSource, @Nullable Runnable runnable) {
        try {
            Assertions.checkNotNull(mediaSource);
            MediaSourceHolder mediaSourceHolder = new MediaSourceHolder(mediaSource);
            this.mediaSourcesPublic.add(i5, mediaSourceHolder);
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.createMessage(this).setType(0).setPayload(new MessageData(i5, mediaSourceHolder, runnable)).send();
            } else if (runnable != null) {
                runnable.run();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final synchronized void addMediaSources(int i5, Collection<MediaSource> collection, @Nullable Runnable runnable) {
        try {
            for (MediaSource checkNotNull : collection) {
                Assertions.checkNotNull(checkNotNull);
            }
            ArrayList arrayList = new ArrayList(collection.size());
            for (MediaSource mediaSourceHolder : collection) {
                arrayList.add(new MediaSourceHolder(mediaSourceHolder));
            }
            this.mediaSourcesPublic.addAll(i5, arrayList);
            if (this.player != null && !collection.isEmpty()) {
                this.player.createMessage(this).setType(1).setPayload(new MessageData(i5, arrayList, runnable)).send();
            } else if (runnable != null) {
                runnable.run();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }
}

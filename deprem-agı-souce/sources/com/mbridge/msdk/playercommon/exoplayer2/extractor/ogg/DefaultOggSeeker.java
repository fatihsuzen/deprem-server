package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.EOFException;
import java.io.IOException;

final class DefaultOggSeeker implements OggSeeker {
    private static final int DEFAULT_OFFSET = 30000;
    public static final int MATCH_BYTE_RANGE = 100000;
    public static final int MATCH_RANGE = 72000;
    private static final int STATE_IDLE = 3;
    private static final int STATE_READ_LAST_PAGE = 1;
    private static final int STATE_SEEK = 2;
    private static final int STATE_SEEK_TO_END = 0;
    private long end;
    private long endGranule;
    private final long endPosition;
    private final OggPageHeader pageHeader = new OggPageHeader();
    private long positionBeforeSeekToEnd;
    private long start;
    private long startGranule;
    /* access modifiers changed from: private */
    public final long startPosition;
    private int state;
    /* access modifiers changed from: private */
    public final StreamReader streamReader;
    private long targetGranule;
    /* access modifiers changed from: private */
    public long totalGranules;

    private class OggSeekMap implements SeekMap {
        private OggSeekMap() {
        }

        public long getDurationUs() {
            return DefaultOggSeeker.this.streamReader.convertGranuleToTime(DefaultOggSeeker.this.totalGranules);
        }

        public SeekMap.SeekPoints getSeekPoints(long j5) {
            if (j5 == 0) {
                return new SeekMap.SeekPoints(new SeekPoint(0, DefaultOggSeeker.this.startPosition));
            }
            long convertTimeToGranule = DefaultOggSeeker.this.streamReader.convertTimeToGranule(j5);
            DefaultOggSeeker defaultOggSeeker = DefaultOggSeeker.this;
            return new SeekMap.SeekPoints(new SeekPoint(j5, defaultOggSeeker.getEstimatedPosition(defaultOggSeeker.startPosition, convertTimeToGranule, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)));
        }

        public boolean isSeekable() {
            return true;
        }
    }

    public DefaultOggSeeker(long j5, long j6, StreamReader streamReader2, int i5, long j7) {
        boolean z4;
        if (j5 < 0 || j6 <= j5) {
            z4 = false;
        } else {
            z4 = true;
        }
        Assertions.checkArgument(z4);
        this.streamReader = streamReader2;
        this.startPosition = j5;
        this.endPosition = j6;
        if (((long) i5) == j6 - j5) {
            this.totalGranules = j7;
            this.state = 3;
            return;
        }
        this.state = 0;
    }

    /* access modifiers changed from: private */
    public long getEstimatedPosition(long j5, long j6, long j7) {
        long j8 = this.endPosition;
        long j9 = this.startPosition;
        long j10 = j5 + (((j6 * (j8 - j9)) / this.totalGranules) - j7);
        if (j10 >= j9) {
            j9 = j10;
        }
        if (j9 >= j8) {
            return j8 - 1;
        }
        return j9;
    }

    public final long getNextSeekPosition(long j5, ExtractorInput extractorInput) throws IOException, InterruptedException {
        long j6 = 2;
        if (this.start == this.end) {
            return -(this.startGranule + 2);
        }
        long position = extractorInput.getPosition();
        if (!skipToNextPage(extractorInput, this.end)) {
            long j7 = this.start;
            if (j7 != position) {
                return j7;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.pageHeader.populate(extractorInput, false);
        extractorInput.resetPeekPosition();
        OggPageHeader oggPageHeader = this.pageHeader;
        long j8 = oggPageHeader.granulePosition;
        long j9 = j5 - j8;
        int i5 = oggPageHeader.headerSize + oggPageHeader.bodySize;
        int i6 = (j9 > 0 ? 1 : (j9 == 0 ? 0 : -1));
        if (i6 < 0 || j9 > 72000) {
            if (i6 < 0) {
                this.end = position;
                this.endGranule = j8;
            } else {
                long j10 = (long) i5;
                long position2 = extractorInput.getPosition() + j10;
                this.start = position2;
                this.startGranule = this.pageHeader.granulePosition;
                if ((this.end - position2) + j10 < 100000) {
                    extractorInput.skipFully(i5);
                    return -(this.startGranule + 2);
                }
            }
            long j11 = this.end;
            long j12 = this.start;
            if (j11 - j12 < 100000) {
                this.end = j12;
                return j12;
            }
            long j13 = (long) i5;
            if (i6 > 0) {
                j6 = 1;
            }
            long position3 = extractorInput.getPosition();
            long j14 = this.end;
            long j15 = this.start;
            return Math.min(Math.max((position3 - (j13 * j6)) + ((j9 * (j14 - j15)) / (this.endGranule - this.startGranule)), j15), this.end - 1);
        }
        extractorInput.skipFully(i5);
        return -(this.pageHeader.granulePosition + 2);
    }

    public final long read(ExtractorInput extractorInput) throws IOException, InterruptedException {
        ExtractorInput extractorInput2;
        DefaultOggSeeker defaultOggSeeker;
        DefaultOggSeeker defaultOggSeeker2;
        int i5 = this.state;
        if (i5 == 0) {
            defaultOggSeeker = this;
            extractorInput2 = extractorInput;
            long position = extractorInput2.getPosition();
            defaultOggSeeker.positionBeforeSeekToEnd = position;
            defaultOggSeeker.state = 1;
            long j5 = defaultOggSeeker.endPosition - 65307;
            if (j5 > position) {
                return j5;
            }
        } else if (i5 == 1) {
            defaultOggSeeker = this;
            extractorInput2 = extractorInput;
        } else if (i5 == 2) {
            long j6 = this.targetGranule;
            long j7 = 0;
            if (j6 == 0) {
                defaultOggSeeker2 = this;
            } else {
                long nextSeekPosition = getNextSeekPosition(j6, extractorInput);
                if (nextSeekPosition >= 0) {
                    return nextSeekPosition;
                }
                defaultOggSeeker2 = this;
                j7 = defaultOggSeeker2.skipToPageOfGranule(extractorInput, this.targetGranule, -(nextSeekPosition + 2));
            }
            defaultOggSeeker2.state = 3;
            return -(j7 + 2);
        } else if (i5 == 3) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
        defaultOggSeeker.totalGranules = readGranuleOfLastPage(extractorInput2);
        defaultOggSeeker.state = 3;
        return defaultOggSeeker.positionBeforeSeekToEnd;
    }

    /* access modifiers changed from: package-private */
    public final long readGranuleOfLastPage(ExtractorInput extractorInput) throws IOException, InterruptedException {
        skipToNextPage(extractorInput);
        this.pageHeader.reset();
        while ((this.pageHeader.type & 4) != 4 && extractorInput.getPosition() < this.endPosition) {
            this.pageHeader.populate(extractorInput, false);
            OggPageHeader oggPageHeader = this.pageHeader;
            extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
        }
        return this.pageHeader.granulePosition;
    }

    public final void resetSeeking() {
        this.start = this.startPosition;
        this.end = this.endPosition;
        this.startGranule = 0;
        this.endGranule = this.totalGranules;
    }

    /* access modifiers changed from: package-private */
    public final void skipToNextPage(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (!skipToNextPage(extractorInput, this.endPosition)) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: package-private */
    public final long skipToPageOfGranule(ExtractorInput extractorInput, long j5, long j6) throws IOException, InterruptedException {
        this.pageHeader.populate(extractorInput, false);
        while (true) {
            OggPageHeader oggPageHeader = this.pageHeader;
            if (oggPageHeader.granulePosition < j5) {
                extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
                OggPageHeader oggPageHeader2 = this.pageHeader;
                long j7 = oggPageHeader2.granulePosition;
                oggPageHeader2.populate(extractorInput, false);
                j6 = j7;
            } else {
                extractorInput.resetPeekPosition();
                return j6;
            }
        }
    }

    public final long startSeek(long j5) {
        boolean z4;
        int i5 = this.state;
        if (i5 == 3 || i5 == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        long j6 = 0;
        if (j5 != 0) {
            j6 = this.streamReader.convertTimeToGranule(j5);
        }
        this.targetGranule = j6;
        this.state = 2;
        resetSeeking();
        return this.targetGranule;
    }

    public final OggSeekMap createSeekMap() {
        if (this.totalGranules != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final boolean skipToNextPage(ExtractorInput extractorInput, long j5) throws IOException, InterruptedException {
        int i5;
        long min = Math.min(j5 + 3, this.endPosition);
        int i6 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i7 = 0;
            if (extractorInput.getPosition() + ((long) i6) <= min || (i6 = (int) (min - extractorInput.getPosition())) >= 4) {
                extractorInput.peekFully(bArr, 0, i6, false);
                while (true) {
                    i5 = i6 - 3;
                    if (i7 >= i5) {
                        break;
                    } else if (bArr[i7] == 79 && bArr[i7 + 1] == 103 && bArr[i7 + 2] == 103 && bArr[i7 + 3] == 83) {
                        extractorInput.skipFully(i7);
                        return true;
                    } else {
                        i7++;
                    }
                }
            } else {
                return false;
            }
            extractorInput.skipFully(i5);
        }
    }
}

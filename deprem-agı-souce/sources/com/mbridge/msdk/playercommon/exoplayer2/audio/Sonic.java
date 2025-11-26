package com.mbridge.msdk.playercommon.exoplayer2.audio;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class Sonic {
    private static final int AMDF_FREQUENCY = 4000;
    private static final int MAXIMUM_PITCH = 400;
    private static final int MINIMUM_PITCH = 65;
    private final int channelCount;
    private final short[] downSampleBuffer;
    private short[] inputBuffer;
    private int inputFrameCount;
    private final int inputSampleRateHz;
    private int maxDiff;
    private final int maxPeriod;
    private final int maxRequiredFrameCount;
    private int minDiff;
    private final int minPeriod;
    private int newRatePosition;
    private int oldRatePosition;
    private short[] outputBuffer;
    private int outputFrameCount;
    private final float pitch;
    private short[] pitchBuffer;
    private int pitchFrameCount;
    private int prevMinDiff;
    private int prevPeriod;
    private final float rate;
    private int remainingInputToCopyFrameCount;
    private final float speed;

    public Sonic(int i5, int i6, float f5, float f6, int i7) {
        this.inputSampleRateHz = i5;
        this.channelCount = i6;
        this.speed = f5;
        this.pitch = f6;
        this.rate = ((float) i5) / ((float) i7);
        this.minPeriod = i5 / MAXIMUM_PITCH;
        int i8 = i5 / 65;
        this.maxPeriod = i8;
        int i9 = i8 * 2;
        this.maxRequiredFrameCount = i9;
        this.downSampleBuffer = new short[i9];
        this.inputBuffer = new short[(i9 * i6)];
        this.outputBuffer = new short[(i9 * i6)];
        this.pitchBuffer = new short[(i9 * i6)];
    }

    private void adjustRate(float f5, int i5) {
        int i6;
        int i7;
        if (this.outputFrameCount != i5) {
            int i8 = this.inputSampleRateHz;
            int i9 = (int) (((float) i8) / f5);
            while (true) {
                if (i9 <= 16384 && i8 <= 16384) {
                    break;
                }
                i9 /= 2;
                i8 /= 2;
            }
            moveNewSamplesToPitchBuffer(i5);
            int i10 = 0;
            while (true) {
                int i11 = this.pitchFrameCount;
                boolean z4 = true;
                if (i10 < i11 - 1) {
                    while (true) {
                        i6 = this.oldRatePosition;
                        int i12 = (i6 + 1) * i9;
                        i7 = this.newRatePosition;
                        if (i12 <= i7 * i8) {
                            break;
                        }
                        this.outputBuffer = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, 1);
                        int i13 = 0;
                        while (true) {
                            int i14 = this.channelCount;
                            if (i13 >= i14) {
                                break;
                            }
                            this.outputBuffer[(this.outputFrameCount * i14) + i13] = interpolate(this.pitchBuffer, (i14 * i10) + i13, i8, i9);
                            i13++;
                        }
                        this.newRatePosition++;
                        this.outputFrameCount++;
                    }
                    int i15 = i6 + 1;
                    this.oldRatePosition = i15;
                    if (i15 == i8) {
                        this.oldRatePosition = 0;
                        if (i7 != i9) {
                            z4 = false;
                        }
                        Assertions.checkState(z4);
                        this.newRatePosition = 0;
                    }
                    i10++;
                } else {
                    removePitchFrames(i11 - 1);
                    return;
                }
            }
        }
    }

    private void changeSpeed(float f5) {
        int insertPitchPeriod;
        int i5 = this.inputFrameCount;
        if (i5 >= this.maxRequiredFrameCount) {
            int i6 = 0;
            do {
                if (this.remainingInputToCopyFrameCount > 0) {
                    insertPitchPeriod = copyInputToOutput(i6);
                } else {
                    int findPitchPeriod = findPitchPeriod(this.inputBuffer, i6);
                    if (((double) f5) > 1.0d) {
                        insertPitchPeriod = findPitchPeriod + skipPitchPeriod(this.inputBuffer, i6, f5, findPitchPeriod);
                    } else {
                        insertPitchPeriod = insertPitchPeriod(this.inputBuffer, i6, f5, findPitchPeriod);
                    }
                }
                i6 += insertPitchPeriod;
            } while (this.maxRequiredFrameCount + i6 <= i5);
            removeProcessedInputFrames(i6);
        }
    }

    private int copyInputToOutput(int i5) {
        int min = Math.min(this.maxRequiredFrameCount, this.remainingInputToCopyFrameCount);
        copyToOutput(this.inputBuffer, i5, min);
        this.remainingInputToCopyFrameCount -= min;
        return min;
    }

    private void copyToOutput(short[] sArr, int i5, int i6) {
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i6);
        this.outputBuffer = ensureSpaceForAdditionalFrames;
        int i7 = this.channelCount;
        System.arraycopy(sArr, i5 * i7, ensureSpaceForAdditionalFrames, this.outputFrameCount * i7, i7 * i6);
        this.outputFrameCount += i6;
    }

    private void downSampleInput(short[] sArr, int i5, int i6) {
        int i7 = this.maxRequiredFrameCount / i6;
        int i8 = this.channelCount;
        int i9 = i6 * i8;
        int i10 = i5 * i8;
        for (int i11 = 0; i11 < i7; i11++) {
            int i12 = 0;
            for (int i13 = 0; i13 < i9; i13++) {
                i12 += sArr[(i11 * i9) + i10 + i13];
            }
            this.downSampleBuffer[i11] = (short) (i12 / i9);
        }
    }

    private short[] ensureSpaceForAdditionalFrames(short[] sArr, int i5, int i6) {
        int length = sArr.length;
        int i7 = this.channelCount;
        int i8 = length / i7;
        if (i5 + i6 <= i8) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i8 * 3) / 2) + i6) * i7);
    }

    private int findPitchPeriod(short[] sArr, int i5) {
        int i6;
        int i7;
        int i8;
        int i9 = this.inputSampleRateHz;
        if (i9 > AMDF_FREQUENCY) {
            i6 = i9 / AMDF_FREQUENCY;
        } else {
            i6 = 1;
        }
        if (this.channelCount == 1 && i6 == 1) {
            i7 = findPitchPeriodInRange(sArr, i5, this.minPeriod, this.maxPeriod);
        } else {
            downSampleInput(sArr, i5, i6);
            int findPitchPeriodInRange = findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / i6, this.maxPeriod / i6);
            if (i6 != 1) {
                int i10 = findPitchPeriodInRange * i6;
                int i11 = i6 * 4;
                int i12 = i10 - i11;
                int i13 = i10 + i11;
                int i14 = this.minPeriod;
                if (i12 < i14) {
                    i12 = i14;
                }
                int i15 = this.maxPeriod;
                if (i13 > i15) {
                    i13 = i15;
                }
                if (this.channelCount == 1) {
                    i7 = findPitchPeriodInRange(sArr, i5, i12, i13);
                } else {
                    downSampleInput(sArr, i5, 1);
                    i7 = findPitchPeriodInRange(this.downSampleBuffer, 0, i12, i13);
                }
            } else {
                i7 = findPitchPeriodInRange;
            }
        }
        if (previousPeriodBetter(this.minDiff, this.maxDiff)) {
            i8 = this.prevPeriod;
        } else {
            i8 = i7;
        }
        this.prevMinDiff = this.minDiff;
        this.prevPeriod = i7;
        return i8;
    }

    private int findPitchPeriodInRange(short[] sArr, int i5, int i6, int i7) {
        int i8 = i5 * this.channelCount;
        int i9 = 255;
        int i10 = 1;
        int i11 = 0;
        int i12 = 0;
        while (i6 <= i7) {
            int i13 = 0;
            for (int i14 = 0; i14 < i6; i14++) {
                i13 += Math.abs(sArr[i8 + i14] - sArr[(i8 + i6) + i14]);
            }
            if (i13 * i11 < i10 * i6) {
                i11 = i6;
                i10 = i13;
            }
            if (i13 * i9 > i12 * i6) {
                i9 = i6;
                i12 = i13;
            }
            i6++;
        }
        this.minDiff = i10 / i11;
        this.maxDiff = i12 / i9;
        return i11;
    }

    private int insertPitchPeriod(short[] sArr, int i5, float f5, int i6) {
        int i7;
        if (f5 < 0.5f) {
            i7 = (int) ((((float) i6) * f5) / (1.0f - f5));
        } else {
            this.remainingInputToCopyFrameCount = (int) ((((float) i6) * ((2.0f * f5) - 1.0f)) / (1.0f - f5));
            i7 = i6;
        }
        int i8 = i6 + i7;
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i8);
        this.outputBuffer = ensureSpaceForAdditionalFrames;
        int i9 = this.channelCount;
        System.arraycopy(sArr, i5 * i9, ensureSpaceForAdditionalFrames, this.outputFrameCount * i9, i9 * i6);
        overlapAdd(i7, this.channelCount, this.outputBuffer, this.outputFrameCount + i6, sArr, i5 + i6, sArr, i5);
        this.outputFrameCount += i8;
        return i7;
    }

    private short interpolate(short[] sArr, int i5, int i6, int i7) {
        short s5 = sArr[i5];
        short s6 = sArr[i5 + this.channelCount];
        int i8 = this.newRatePosition * i6;
        int i9 = this.oldRatePosition;
        int i10 = i9 * i7;
        int i11 = (i9 + 1) * i7;
        int i12 = i11 - i8;
        int i13 = i11 - i10;
        return (short) (((s5 * i12) + ((i13 - i12) * s6)) / i13);
    }

    private void moveNewSamplesToPitchBuffer(int i5) {
        int i6 = this.outputFrameCount - i5;
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.pitchBuffer, this.pitchFrameCount, i6);
        this.pitchBuffer = ensureSpaceForAdditionalFrames;
        short[] sArr = this.outputBuffer;
        int i7 = this.channelCount;
        System.arraycopy(sArr, i5 * i7, ensureSpaceForAdditionalFrames, this.pitchFrameCount * i7, i7 * i6);
        this.outputFrameCount = i5;
        this.pitchFrameCount += i6;
    }

    private static void overlapAdd(int i5, int i6, short[] sArr, int i7, short[] sArr2, int i8, short[] sArr3, int i9) {
        for (int i10 = 0; i10 < i6; i10++) {
            int i11 = (i7 * i6) + i10;
            int i12 = (i9 * i6) + i10;
            int i13 = (i8 * i6) + i10;
            for (int i14 = 0; i14 < i5; i14++) {
                sArr[i11] = (short) (((sArr2[i13] * (i5 - i14)) + (sArr3[i12] * i14)) / i5);
                i11 += i6;
                i13 += i6;
                i12 += i6;
            }
        }
    }

    private boolean previousPeriodBetter(int i5, int i6) {
        if (i5 == 0 || this.prevPeriod == 0 || i6 > i5 * 3 || i5 * 2 <= this.prevMinDiff * 3) {
            return false;
        }
        return true;
    }

    private void processStreamInput() {
        int i5 = this.outputFrameCount;
        float f5 = this.speed;
        float f6 = this.pitch;
        float f7 = f5 / f6;
        float f8 = this.rate * f6;
        double d5 = (double) f7;
        if (d5 > 1.00001d || d5 < 0.99999d) {
            changeSpeed(f7);
        } else {
            copyToOutput(this.inputBuffer, 0, this.inputFrameCount);
            this.inputFrameCount = 0;
        }
        if (f8 != 1.0f) {
            adjustRate(f8, i5);
        }
    }

    private void removePitchFrames(int i5) {
        if (i5 != 0) {
            short[] sArr = this.pitchBuffer;
            int i6 = this.channelCount;
            System.arraycopy(sArr, i5 * i6, sArr, 0, (this.pitchFrameCount - i5) * i6);
            this.pitchFrameCount -= i5;
        }
    }

    private void removeProcessedInputFrames(int i5) {
        int i6 = this.inputFrameCount - i5;
        short[] sArr = this.inputBuffer;
        int i7 = this.channelCount;
        System.arraycopy(sArr, i5 * i7, sArr, 0, i7 * i6);
        this.inputFrameCount = i6;
    }

    private int skipPitchPeriod(short[] sArr, int i5, float f5, int i6) {
        int i7;
        if (f5 >= 2.0f) {
            i7 = (int) (((float) i6) / (f5 - 1.0f));
        } else {
            this.remainingInputToCopyFrameCount = (int) ((((float) i6) * (2.0f - f5)) / (f5 - 1.0f));
            i7 = i6;
        }
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.outputBuffer, this.outputFrameCount, i7);
        this.outputBuffer = ensureSpaceForAdditionalFrames;
        overlapAdd(i7, this.channelCount, ensureSpaceForAdditionalFrames, this.outputFrameCount, sArr, i5, sArr, i5 + i6);
        this.outputFrameCount += i7;
        return i7;
    }

    public final void flush() {
        this.inputFrameCount = 0;
        this.outputFrameCount = 0;
        this.pitchFrameCount = 0;
        this.oldRatePosition = 0;
        this.newRatePosition = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.prevPeriod = 0;
        this.prevMinDiff = 0;
        this.minDiff = 0;
        this.maxDiff = 0;
    }

    public final int getFramesAvailable() {
        return this.outputFrameCount;
    }

    public final void getOutput(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.channelCount, this.outputFrameCount);
        shortBuffer.put(this.outputBuffer, 0, this.channelCount * min);
        int i5 = this.outputFrameCount - min;
        this.outputFrameCount = i5;
        short[] sArr = this.outputBuffer;
        int i6 = this.channelCount;
        System.arraycopy(sArr, min * i6, sArr, 0, i5 * i6);
    }

    public final void queueEndOfStream() {
        int i5;
        int i6 = this.inputFrameCount;
        float f5 = this.speed;
        float f6 = this.pitch;
        int i7 = this.outputFrameCount + ((int) ((((((float) i6) / (f5 / f6)) + ((float) this.pitchFrameCount)) / (this.rate * f6)) + 0.5f));
        this.inputBuffer = ensureSpaceForAdditionalFrames(this.inputBuffer, i6, (this.maxRequiredFrameCount * 2) + i6);
        int i8 = 0;
        while (true) {
            i5 = this.maxRequiredFrameCount;
            int i9 = this.channelCount;
            if (i8 >= i5 * 2 * i9) {
                break;
            }
            this.inputBuffer[(i9 * i6) + i8] = 0;
            i8++;
        }
        this.inputFrameCount += i5 * 2;
        processStreamInput();
        if (this.outputFrameCount > i7) {
            this.outputFrameCount = i7;
        }
        this.inputFrameCount = 0;
        this.remainingInputToCopyFrameCount = 0;
        this.pitchFrameCount = 0;
    }

    public final void queueInput(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i5 = this.channelCount;
        int i6 = remaining / i5;
        short[] ensureSpaceForAdditionalFrames = ensureSpaceForAdditionalFrames(this.inputBuffer, this.inputFrameCount, i6);
        this.inputBuffer = ensureSpaceForAdditionalFrames;
        shortBuffer.get(ensureSpaceForAdditionalFrames, this.inputFrameCount * this.channelCount, ((i5 * i6) * 2) / 2);
        this.inputFrameCount += i6;
        processStreamInput();
    }
}

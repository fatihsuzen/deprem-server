package com.mbridge.msdk.foundation.same.e;

public abstract class a implements Runnable {
    public static long id;
    public C0087a mListener;
    public b mState = b.READY;

    /* renamed from: com.mbridge.msdk.foundation.same.e.a$a  reason: collision with other inner class name */
    public interface C0087a {
        void a(b bVar);
    }

    public enum b {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    public a() {
        id++;
    }

    private void setState(b bVar) {
        this.mState = bVar;
        C0087a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    public final void cancel() {
        b bVar = this.mState;
        b bVar2 = b.CANCEL;
        if (bVar != bVar2) {
            setState(bVar2);
            cancelTask();
        }
    }

    public abstract void cancelTask();

    public final long getId() {
        return id;
    }

    public b getState() {
        return this.mState;
    }

    public abstract void pauseTask(boolean z4);

    public final void run() {
        try {
            if (this.mState == b.READY) {
                setState(b.RUNNING);
                runTask();
                setState(b.FINISH);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract void runTask();

    public void setOnStateChangeListener(C0087a aVar) {
        this.mListener = aVar;
    }

    public final void setPause(boolean z4) {
        b bVar = this.mState;
        b bVar2 = b.PAUSE;
        if (bVar != bVar2 && bVar != b.CANCEL && bVar != b.FINISH) {
            if (z4) {
                setState(bVar2);
            } else {
                setState(b.RUNNING);
            }
            pauseTask(z4);
        }
    }
}

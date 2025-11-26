package y;

import C.C0634a;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.zip.Adler32;
import r.p;
import v.C1892a;
import z.C1952d;

/* renamed from: y.d  reason: case insensitive filesystem */
public class C1933d implements x {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17009a;

    /* renamed from: b  reason: collision with root package name */
    private final C1952d f17010b;

    /* renamed from: c  reason: collision with root package name */
    private final C1935f f17011c;

    public C1933d(Context context, C1952d dVar, C1935f fVar) {
        this.f17009a = context;
        this.f17010b = dVar;
        this.f17011c = fVar;
    }

    private boolean d(JobScheduler jobScheduler, int i5, int i6) {
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JobInfo next = it.next();
            int i7 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == i5) {
                if (i7 >= i6) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(p pVar, int i5, boolean z4) {
        ComponentName componentName = new ComponentName(this.f17009a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f17009a.getSystemService("jobscheduler");
        int c5 = c(pVar);
        if (z4 || !d(jobScheduler, c5, i5)) {
            long r5 = this.f17010b.r(pVar);
            int i6 = i5;
            JobInfo.Builder c6 = this.f17011c.c(new JobInfo.Builder(c5, componentName), pVar.d(), r5, i6);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i6);
            persistableBundle.putString("backendName", pVar.b());
            persistableBundle.putInt("priority", C0634a.a(pVar.d()));
            if (pVar.c() != null) {
                persistableBundle.putString("extras", Base64.encodeToString(pVar.c(), 0));
            }
            c6.setExtras(persistableBundle);
            C1892a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", pVar, Integer.valueOf(c5), Long.valueOf(this.f17011c.g(pVar.d(), r5, i6)), Long.valueOf(r5), Integer.valueOf(i6));
            jobScheduler.schedule(c6.build());
            return;
        }
        C1892a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
    }

    public void b(p pVar, int i5) {
        a(pVar, i5, false);
    }

    /* access modifiers changed from: package-private */
    public int c(p pVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f17009a.getPackageName().getBytes(Charset.forName(C.UTF8_NAME)));
        adler32.update(pVar.b().getBytes(Charset.forName(C.UTF8_NAME)));
        adler32.update(ByteBuffer.allocate(4).putInt(C0634a.a(pVar.d())).array());
        if (pVar.c() != null) {
            adler32.update(pVar.c());
        }
        return (int) adler32.getValue();
    }
}

package com.uptodown.tv.ui.activity;

import android.os.Bundle;
import android.speech.SpeechRecognizer;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import v2.C2802b;

public final class TvSearchActivity extends C2802b {

    /* renamed from: b  reason: collision with root package name */
    private SpeechRecognizer f21186b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.tv_search_activity);
        if (SpeechRecognizer.isRecognitionAvailable(this)) {
            this.f21186b = SpeechRecognizer.createSpeechRecognizer(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (this.f21186b != null && SpeechRecognizer.isRecognitionAvailable(this)) {
            SpeechRecognizer speechRecognizer = this.f21186b;
            t.b(speechRecognizer);
            speechRecognizer.stopListening();
            SpeechRecognizer speechRecognizer2 = this.f21186b;
            t.b(speechRecognizer2);
            speechRecognizer2.cancel();
            SpeechRecognizer speechRecognizer3 = this.f21186b;
            t.b(speechRecognizer3);
            speechRecognizer3.destroy();
        }
        this.f21186b = null;
        super.onPause();
    }
}

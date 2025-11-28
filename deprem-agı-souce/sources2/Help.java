package com.finazzi.distquake;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0832r0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import u2.C1903z1;

public class Help extends C0768d {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.help);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        boolean z7 = getSharedPreferences(MainActivity.class.getSimpleName(), 0).getBoolean("pro_features", false);
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        if (!z7) {
            toolbar.setLogo(2131230872);
        } else {
            toolbar.setLogo(2131230875);
        }
        ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new C1903z1(this));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        TextView textView = (TextView) findViewById(C2030R.id.textView2);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(C2030R.raw.hazard), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append(10);
                    } else {
                        textView.setText(Html.fromHtml(sb.toString()));
                        bufferedReader.close();
                        return;
                    }
                } catch (NullPointerException e8) {
                    if (e8.getMessage() != null) {
                        Log.d("EQN", e8.getMessage());
                        return;
                    }
                    return;
                }
            }
        } catch (IOException e9) {
            if (e9.getMessage() != null) {
                Log.d("EQN", e9.getMessage());
            }
        }
    }
}

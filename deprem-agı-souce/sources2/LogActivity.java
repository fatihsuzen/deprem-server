package com.finazzi.distquake;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.C0832r0;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import u2.J1;

public class LogActivity extends ListActivity {

    /* renamed from: a  reason: collision with root package name */
    private List f13253a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f13254b;

    private class b extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private LayoutInflater f13255a;

        /* renamed from: b  reason: collision with root package name */
        private List f13256b;

        /* access modifiers changed from: package-private */
        public void a(c cVar) {
            this.f13256b.add(cVar);
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.f13256b.size();
        }

        public Object getItem(int i8) {
            return this.f13256b.get(i8);
        }

        public long getItemId(int i8) {
            return (long) i8;
        }

        public View getView(int i8, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = LogActivity.this.getLayoutInflater();
            this.f13255a = layoutInflater;
            View inflate = layoutInflater.inflate(C2030R.layout.log_entry, viewGroup, false);
            int count = (LogActivity.this.f13254b.getCount() - i8) - 1;
            TextView textView = (TextView) inflate.findViewById(C2030R.id.textView1);
            textView.setText(((c) this.f13256b.get(count)).f13260c);
            if (((c) this.f13256b.get(count)).f13258a == 1) {
                textView.setTypeface(Typeface.DEFAULT_BOLD);
            }
            ((TextView) inflate.findViewById(C2030R.id.textView2)).setText(((c) this.f13256b.get(count)).f13259b);
            return inflate;
        }

        private b(Activity activity, List list) {
            this.f13255a = LayoutInflater.from(activity);
            this.f13256b = list;
        }
    }

    private static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f13258a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f13259b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f13260c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f13261d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public String f13262e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public String f13263f;

        private c() {
        }

        /* access modifiers changed from: package-private */
        public void g(String str) {
            this.f13259b = str;
        }

        /* access modifiers changed from: package-private */
        public void h(String str) {
            this.f13261d = str;
        }

        /* access modifiers changed from: package-private */
        public void i(String str) {
            this.f13262e = str;
        }

        /* access modifiers changed from: package-private */
        public void j(String str) {
            this.f13260c = str;
        }

        /* access modifiers changed from: package-private */
        public void k(int i8) {
            this.f13258a = i8;
        }

        /* access modifiers changed from: package-private */
        public void l(String str) {
            this.f13263f = str;
        }
    }

    public static /* synthetic */ void a(LogActivity logActivity, View view) {
        logActivity.c();
        logActivity.f13253a.clear();
        ((BaseAdapter) logActivity.getListAdapter()).notifyDataSetChanged();
    }

    private void c() {
        String str = getApplicationInfo().dataDir;
        if (!new File(str + "/files/log3.txt").delete()) {
            Log.d("EQN", "Cannot delete");
        }
        File[] listFiles = new File(str + "/files/").listFiles();
        int length = listFiles.length;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            File file = listFiles[i10];
            if (file.getAbsolutePath().contains("wave")) {
                i9++;
                if (file.delete()) {
                    i8++;
                }
            }
        }
        Toast makeText = Toast.makeText(this, String.format(getString(C2030R.string.log_deleted), new Object[]{Integer.toString(i8), Integer.toString(i9)}), 1);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2030R.layout.log);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        this.f13253a = new ArrayList();
        b bVar = new b(this, this.f13253a);
        this.f13254b = bVar;
        setListAdapter(bVar);
        ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new J1(this));
    }

    /* access modifiers changed from: protected */
    public void onListItemClick(ListView listView, View view, int i8, long j8) {
        super.onListItemClick(listView, view, i8, j8);
        c cVar = (c) this.f13253a.get((this.f13254b.getCount() - i8) - 1);
        if (cVar.f13258a == 1) {
            String d8 = cVar.f13261d;
            String e8 = cVar.f13262e;
            String f8 = cVar.f13263f;
            if (!f8.isEmpty()) {
                String str = getApplicationInfo().dataDir + "/files/" + f8;
                File file = new File(str);
                if (file.exists()) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(str));
                        int round = (int) Math.round(((double) file.length()) / 8.0d);
                        double[] dArr = new double[round];
                        int i9 = 0;
                        while (i9 < round) {
                            try {
                                dArr[i9] = dataInputStream.readDouble();
                                i9++;
                            } catch (IOException e9) {
                                IOException iOException = e9;
                                if (iOException.getMessage() != null) {
                                    Log.d("EQN", iOException.getMessage());
                                    return;
                                }
                                return;
                            }
                        }
                        Intent intent = new Intent().setClass(this, ChartWaveActivity.class);
                        intent.putExtra("com.finazzi.distquake.measure_vector", dArr);
                        intent.putExtra("com.finazzi.distquake.time_firstMeasure", d8);
                        intent.putExtra("com.finazzi.distquake.time_lastMeasure", e8);
                        startActivity(intent);
                    } catch (IOException e10) {
                        IOException iOException2 = e10;
                        if (iOException2.getMessage() != null) {
                            Log.d("EQN", iOException2.getMessage());
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f13253a.clear();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(openFileInput("log3.txt"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("\f");
                    c cVar = new c();
                    if (split.length == 3) {
                        cVar.k(Integer.parseInt(split[0]));
                        cVar.g(split[1]);
                        cVar.j(split[2]);
                    }
                    if (split.length == 6) {
                        cVar.k(Integer.parseInt(split[0]));
                        cVar.g(split[1]);
                        cVar.j(split[2]);
                        cVar.h(split[3]);
                        cVar.i(split[4]);
                        cVar.l(split[5]);
                    }
                    ((b) getListAdapter()).a(cVar);
                } catch (IOException e8) {
                    if (e8.getMessage() != null) {
                        Log.d("EQN", e8.getMessage());
                    }
                }
            }
            inputStreamReader.close();
        } catch (IOException e9) {
            if (e9.getMessage() != null) {
                Log.d("EQN", e9.getMessage());
            }
        }
    }
}

package com.example.abimanyu.androidbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class webViewActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        // FulScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ButterKnife.bind(this);


        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        // Dibawah ini agar laman yang dimuat dapat di zoom
        webView.getSettings().supportZoom();
        webView.getSettings().getBuiltInZoomControls();
        webView.getSettings().getDisplayZoomControls();

        // agar laman yang dimuat dapat di scrool
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://himamisi.darmajaya.ac.id/");

    }

    //ini code agar ketika kita klik back, dia kembali kehalaman sebelumnya, jika tidak diberi kode ini dia akan kembali kehalaman awal
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        }

        super.onBackPressed();
    }

    @OnClick(R.id.webView)
    public void onViewClicked() {
    }
}

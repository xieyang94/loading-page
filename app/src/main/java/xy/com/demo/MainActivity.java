package xy.com.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import xy.com.loading_page.LoadingPage;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    private LoadingPage loadingPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);

        loadingPage = (LoadingPage) findViewById(R.id.loading);

        webView.loadUrl("https://www.baidu.com");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                loadingPage.onGone();
            }
        });
    }

    public void onClick(View view) {
        finish();
    }
}

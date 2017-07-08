package siddharth.com.fzrev.ActivityClasses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import siddharth.com.fzrev.Data.Data;
import siddharth.com.fzrev.GsonData.PortfolioSmall;
import siddharth.com.fzrev.R;

public class WebViewOfPosts extends Activity {

    private WebView webView;

    Data data = new Data();

    PortfolioSmall portfolioSmall = new PortfolioSmall();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_of_posts);

        webView = (WebView)findViewById(R.id.postsWebView);
        String postLink = getIntent().getStringExtra("link");
        webView.loadUrl(postLink);
        webView.getSettings().getJavaScriptEnabled();
        webView.getSettings().setBuiltInZoomControls(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}

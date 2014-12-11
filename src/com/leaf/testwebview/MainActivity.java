package com.leaf.testwebview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener{ 
	private WebView mWebView;
	
	private LinearLayout ll_cpu;
	private LinearLayout ll_video;
	private LinearLayout ll_borad;
	private ImageView image_cpu;
	private ImageView image_video;
	private ImageView image_borad;


	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mWebView = (WebView) findViewById(R.id.webview);
		WebSettings ws = mWebView.getSettings();
		ws.setUseWideViewPort(true);
		// 设置可以支持缩放
		mWebView.getSettings().setSupportZoom(true);
		// 设置出现缩放工具
		mWebView.getSettings().setBuiltInZoomControls(true);
		// 让网页自适应屏幕宽度
		mWebView.getSettings().setUseWideViewPort(true);
		mWebView.getSettings().setLoadWithOverviewMode(true);
		// 启用缓存
		mWebView.getSettings().setAppCacheEnabled(true);

		mWebView.getSettings().setDisplayZoomControls(false);
		initView();

	}


	private void setSelected(){
		ll_cpu.setSelected(false);
		ll_video.setSelected(false);
		ll_borad.setSelected(false);
		image_cpu.setSelected(false);
		image_video.setSelected(false) ;
		image_borad.setSelected(false);
	}
	
	private void initView(){
		ll_cpu = (LinearLayout)findViewById(R.id.ll_cpu);
		ll_video = (LinearLayout)findViewById(R.id.ll_video);
		ll_borad = (LinearLayout)findViewById(R.id.ll_board);

		image_cpu = (ImageView)findViewById(R.id.image_cpu);
		image_video = (ImageView)findViewById(R.id.image_video);
		image_borad = (ImageView)findViewById(R.id.image_board);

		ll_cpu.setOnClickListener(this);
		ll_video.setOnClickListener(this);
		ll_borad.setOnClickListener(this);

		mWebView.loadUrl("file:///android_asset/cpu_bg.png");
		ll_cpu.setSelected(true);
		image_cpu.setSelected(true);

	}

    @Override
    public void onClick(View v) {
        setSelected();

        switch (v.getId()) {
            case R.id.ll_cpu:
                mWebView.loadUrl("file:///android_asset/cpu_bg.png");
                ll_cpu.setSelected(true);
                image_cpu.setSelected(true);
                break;
            case R.id.ll_video:
                mWebView.loadUrl("file:///android_asset/video_bg.png");
                ll_video.setSelected(true);
                image_video.setSelected(true);
                break;
			case R.id.ll_board:
				mWebView.loadUrl("file:///android_asset/board_bg.png");
				ll_borad.setSelected(true);
				image_borad.setSelected(true);
				break;
        }
    }
}

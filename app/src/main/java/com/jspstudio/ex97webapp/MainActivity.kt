package com.jspstudio.ex97webapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    val wv: WebView by lazy { findViewById(R.id.wv) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 웹뷰가 적용할 필수 속성들
        // 1. JavaScript를 사용할 수 있도록 설정 (필수)
        wv.settings.javaScriptEnabled= true

        // 2. 가급적 필수 속성
        // 2-1 예전에는 새로운 웹문서가 열릴 때 기존 웹뷰가 아니라 새로운 웹뷰에서 열림. 그래서 현재 웹뷰에서 페이지를 전환하도록 설정
        wv.webViewClient= WebViewClient()

        // 2-2 alert(), confirm() 같은 팝업 다이얼로그 기능을 사용 가능하도록
        wv.webChromeClient = WebChromeClient()

        // 웹뷰가 보여줄 웹문서(.html) 로드하기
        wv.loadUrl("file:///android_asset/index.html")
        wv.loadUrl("http://naver.com")


    }

    // 디바이스의 '뒤로가기' 버튼을 클릭했을 때 반응하는 콜백메소드
    override fun onBackPressed() {
        // 웹뷰가 이전 페이지가 있다면 이전으로 이동
        if (wv.canGoBack()) wv.goBack()
        else super.onBackPressed()
    }

}
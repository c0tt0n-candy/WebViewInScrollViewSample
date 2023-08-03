package com.example.webviewinscrollviewsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.webviewinscrollviewsample.CollectionFragment.Companion.ARG_OBJECT

class CollectionObjectFragment : Fragment() {
    private lateinit var webView1: WebView
    private lateinit var webView2: WebView
    private lateinit var webView3: WebView
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_collection_object, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        webView1 = view.findViewById(R.id.webView1)
        webView1.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl("https://developers.google.com/")
        }

        webView2 = view.findViewById(R.id.webView2)
        webView2.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl("https://about.google/")
        }

        webView3 = view.findViewById(R.id.webView3)
        webView3.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl("https://www.google.com/logos/doodles/2023/2023-womens-world-cup-aug-02-6753651837110065-2xa.gif")
        }

        button = view.findViewById(R.id.button)
        button.setOnClickListener {
            Toast.makeText(
                context,
                "Button ${arguments?.getInt(ARG_OBJECT)} tapped!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onResume() {
        super.onResume()
        webView1.onResume()
        webView2.onResume()
        webView3.onResume()
    }
}

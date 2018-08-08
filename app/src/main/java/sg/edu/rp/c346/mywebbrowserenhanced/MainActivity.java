package sg.edu.rp.c346.mywebbrowserenhanced;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLoad;
    WebView wvMyPage;
    EditText etURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoad = findViewById(R.id.buttonLoad);
        wvMyPage = findViewById(R.id.webViewMyPage);
        etURL = findViewById(R.id.editTextURL);
        wvMyPage.setWebViewClient(new WebViewClient());

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etURL.length() != 0){
                    String url = etURL.getText().toString();
                    wvMyPage.loadUrl(url);
                    wvMyPage.getSettings().setJavaScriptEnabled(true);
                    wvMyPage.getSettings().setAllowFileAccess(false);
                    wvMyPage.getSettings().setBuiltInZoomControls(true);
                } else {
                    Toast.makeText(MainActivity.this, "Please ensure all info are filled up!" , Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

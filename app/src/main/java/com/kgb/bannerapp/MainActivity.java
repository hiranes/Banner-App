package com.kgb.bannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    ImageView ivb1,ivb2;
    Button btnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivb1 = findViewById(R.id.ivBanner1);
        ivb2 = findViewById(R.id.ivBanner2);
        btnLoad = findViewById(R.id.btnLoad);
        final Context context = this;

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateHomeBanners(context);
            }
        });
    }

    public void updateHomeBanners(final Context ctxAct) {
        //Load first banner
        final Activity actMain = (Activity) ctxAct;

        if (1 == 1) {


            final WebView m_webview = actMain.findViewById(R.id.webview);

            m_webview.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView webView, String url) {
                    super.onPageFinished(webView, url);

                    CreateBitmapFromHTML obj = new CreateBitmapFromHTML(ctxAct, webView, new CreateBitmapFromHTML.AsyncResponse() {
                        @Override
                        public void onFinished(Bitmap output) {

                            if (output == null) {
                                return;
                            }

                            ImageView ivProgress = findViewById(R.id.ivBanner2);
                            if (ivProgress != null) {
                                ivProgress.setImageBitmap(output);
                                //ivProgress.setBackgroundColor(Color.parseColor(dataArray[2]));
                            }

                            String path = ctxAct.getFilesDir().getPath();
                            OutputStream fOut = null;
                            File file = new File(path, "ban_ai.jpg"); // the File to save , append increasing numeric counter to prevent files from getting overwritten.
                            try {
                                fOut = new FileOutputStream(file);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            try {
                                output.compress(Bitmap.CompressFormat.JPEG, 100, fOut); // saving the Bitmap to a file compressed as a JPEG with 85% compression rate

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            finally {
                                try {
                                    fOut.flush(); // Not really required
                                    fOut.close(); // do not forget to close the stream

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    });
                    obj.execute("");

                }
            });


            WebSettings settings = m_webview.getSettings();
            settings.setBuiltInZoomControls(true);
            settings.setUseWideViewPort(false);
            settings.setJavaScriptEnabled(true);
            settings.setSupportMultipleWindows(false);

            settings.setLoadsImagesAutomatically(true);
            settings.setLightTouchEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setTextZoom(100);


            String RESULTDATA = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"><title>highest income generating ro</title><style>body {background-image: radial-gradient(#41b0f4, #80cbf9);}.top {text-align: center;}h1 {font-size: 15px;}.column {float: right;}.left,.right {width: 25%;text-align: center;margin-top: 10px;}.middle {margin-top: 10px; width: 50%;text-align: center;}.row {padding-top: 10px;}.row:after {content: \"\";display: table; clear: both;}.well {margin-top: 20px;font-size: 80%; margin-bottom: 0px; }h3 {font-size: 70%;font-style: italic;color: #001e4c;margin-bottom: 0px;font-weight: bold;}h1,h2 {color: #001e4c;font-weight: normal;}@font-face {font-family: \"advert\";src: url(\"AdvertisingScriptBoldTrial.ttf\");}@font-face {font-family: \"Lato-Light\";src: url(\"Lato-Light.ttf\");}@font-face {font-family: \"algerian\";src: url(\"Algerian_Condensed_LET_Plain1.ttf\");}</style></head><body><section><div class=\"top\"><h1 style=\"font-family: Lato-Light; font-size: 100%;FONT-WEIGHT:BOLD; margin-top: 10px; margin-bottom: 1px;\">KGBNET - Internet banking</h1><img src=\"4.png\" alt=\"underline\" width=\"40%\"></div><div class=\"row\"><div class=\"column right\"><img src=\"box1.png\" width=\"75px\" height=auto style=\"margin-right: 70px;\"></div><div class=\"column middle\" style=\"text-align:center;\"><h2 style=\"font-family: algerian; font-size: 80%;  margin-top: 10px;\">WE ARE PROUD TO INTRODUCE</h2><h2 style=\"margin-top:-10px; font-family: algerian; font-size: 100%; \">OUR NEW PRODUCT!</h2><h2 class=\"well\" style=\"font-family: advert; margin-top: 10px;\">Utilize its full potential</h2></div><div class=\"column left\"><img class=\"second\" src=\"new2.png\" width=\"60px\" style=\"margin-left: 0px;\"></div></div><div class=\"top\"><h3 style=\"font-family: Lato-Light; margin-bottom: 1x;\">\" Discipline is the bridge between goals and accomplishment \"</h3><img src=\"4.png\" alt=\"underline\" width=\"70%\"></div></section></body></html>";
            if (!RESULTDATA.equals(null)) {
                m_webview.loadDataWithBaseURL("file:///android_asset/", RESULTDATA, "text/html", "utf-8", null);
            }

        }

        if (1==1) {



            final WebView m_webviewtop = actMain.findViewById(R.id.webviewtop);

            m_webviewtop.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView webView, String url) {
                    super.onPageFinished(webView, url);

                    CreateBitmapFromHTML obj = new CreateBitmapFromHTML(ctxAct, webView, new CreateBitmapFromHTML.AsyncResponse() {
                        @Override
                        public void onFinished(Bitmap output) {

                            if (output == null) {
                                return;
                            }

                            ImageView ivBannerhome = actMain.findViewById(R.id.ivBanner1);
                            if (ivBannerhome != null) {
                                ivBannerhome.setImageBitmap(output);
                                //ivBannerhome.setBackgroundColor(Color.parseColor(dataArray[0]));
                            }

                            String path = ctxAct.getFilesDir().getPath();
                            OutputStream fOut = null;
                            File file = new File(path, "ban_global.jpg"); // the File to save , append increasing numeric counter to prevent files from getting overwritten.
                            try {
                                fOut = new FileOutputStream(file);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            try {
                                output.compress(Bitmap.CompressFormat.JPEG, 100, fOut); // saving the Bitmap to a file compressed as a JPEG with 85% compression rate

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                fOut.flush(); // Not really required
                                fOut.close(); // do not forget to close the stream

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    obj.execute("");

                }
            });


            WebSettings settingstop = m_webviewtop.getSettings();
            settingstop.setBuiltInZoomControls(true);
            settingstop.setUseWideViewPort(false);
            settingstop.setJavaScriptEnabled(true);
            settingstop.setSupportMultipleWindows(false);

            settingstop.setLoadsImagesAutomatically(true);
            settingstop.setLightTouchEnabled(true);
            settingstop.setDomStorageEnabled(true);
            settingstop.setLoadWithOverviewMode(true);
            settingstop.setTextZoom(100);

            String RESULTDATATOP = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"><title>highest income generating ro</title><style>body {background-image: radial-gradient(#41b0f4, #80cbf9);}.top {text-align: center;}h1 {font-size: 15px;}.column {float: right;}.left,.right {width: 25%;text-align: center;margin-top: 10px;}.middle {margin-top: 10px; width: 50%;text-align: center;}.row {padding-top: 10px;}.row:after {content: \"\";display: table; clear: both;}.well {margin-top: 20px;font-size: 80%; margin-bottom: 0px; }h3 {font-size: 70%;font-style: italic;color: #001e4c;margin-bottom: 0px;font-weight: bold;}h1,h2 {color: #001e4c;font-weight: normal;}@font-face {font-family: \"advert\";src: url(\"AdvertisingScriptBoldTrial.ttf\");}@font-face {font-family: \"Lato-Light\";src: url(\"Lato-Light.ttf\");}@font-face {font-family: \"algerian\";src: url(\"Algerian_Condensed_LET_Plain1.ttf\");}</style></head><body><section><div class=\"top\"><h1 style=\"font-family: Lato-Light; font-size: 100%;FONT-WEIGHT:BOLD; margin-top: 10px; margin-bottom: 1px;\">KGBNET - Internet banking</h1><img src=\"4.png\" alt=\"underline\" width=\"40%\"></div><div class=\"row\"><div class=\"column right\"><img src=\"box1.png\" width=\"75px\" height=auto style=\"margin-right: 70px;\"></div><div class=\"column middle\" style=\"text-align:center;\"><h2 style=\"font-family: algerian; font-size: 80%;  margin-top: 10px;\">WE ARE PROUD TO INTRODUCE</h2><h2 style=\"margin-top:-10px; font-family: algerian; font-size: 100%; \">OUR NEW PRODUCT!</h2><h2 class=\"well\" style=\"font-family: advert; margin-top: 10px;\">Utilize its full potential</h2></div><div class=\"column left\"><img class=\"second\" src=\"new2.png\" width=\"60px\" style=\"margin-left: 0px;\"></div></div><div class=\"top\"><h3 style=\"font-family: Lato-Light; margin-bottom: 1x;\">\" Discipline is the bridge between goals and accomplishment \"</h3><img src=\"4.png\" alt=\"underline\" width=\"70%\"></div></section></body></html>";
            if (!RESULTDATATOP.equals(null)) {
                m_webviewtop.loadDataWithBaseURL("file:///android_asset/", RESULTDATATOP, "text/html", "utf-8", null);
            }
        }
    }
}

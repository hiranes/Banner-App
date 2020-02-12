package com.kgb.bannerapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.AsyncTask;
import android.webkit.WebView;

import androidx.annotation.NonNull;

import static java.lang.Thread.sleep;

public class CreateBitmapFromHTML extends AsyncTask<String, Void, Bitmap> {


    public interface AsyncResponse{
        void onFinished(Bitmap output);
    }

    private AsyncResponse instance = null;
    private Context context;
    private WebView webView;

    public CreateBitmapFromHTML(Context ctx, WebView webView, AsyncResponse response){
        this.instance = response;
        this.context = ctx;
        this.webView = webView;
        SharedPreferences SharedPrefObj;
        SharedPrefObj = ctx.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }
    @Override
   protected Bitmap doInBackground(String... html) {
        Bitmap bm = null;

        bm =  CreateImageFromHTML();

        return bm;
    }

    private Bitmap CreateImageFromHTML() {
        Bitmap bitmap = null;
        try {

            sleep(500);
            int w = this.webView.getWidth();
            int h = this.webView.getHeight();
            bitmap = Bitmap.createBitmap(this.webView.getWidth(), h, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(Color.WHITE);

            this.webView.draw(canvas);
            return bitmap;
        } catch (Exception e) {
            return bitmap;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        instance.onFinished(bitmap);
    }
}
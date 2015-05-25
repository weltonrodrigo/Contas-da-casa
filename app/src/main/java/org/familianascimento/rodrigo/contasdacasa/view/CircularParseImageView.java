package org.familianascimento.rodrigo.contasdacasa.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Log;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.pkmmte.view.CircularImageView;

/**
 * {Contas da Casa}
 * Created by weltonnascimento on 24/05/15.
 */
public class CircularParseImageView extends CircularImageView {

    private final String LOG_TAG = "CircularParseImageView";
    ParseFile mParseFile;

    public CircularParseImageView(Context context) {
        super(context);
    }

    public CircularParseImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularParseImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void getDataInBackground(ParseFile parseFile){

        if(parseFile == null){
            Log.w(LOG_TAG, "Null parsefile");
            return;
        }

        mParseFile = parseFile;

        String url;
        try {
            url = mParseFile.getUrl();
        } catch (Exception e) {
            e.printStackTrace();
            url = null;
        }

        if (url != null) {
            Log.v(LOG_TAG, "Queuing getdatainbackground " + url);
        }

        mParseFile.getDataInBackground(new GetDataCallback() {
            @Override
            public void done(byte[] data, ParseException e) {
                if (e == null) {
                    Log.v(LOG_TAG, "Got image data " + mParseFile.getUrl());
                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                    if (bitmap != null && CircularParseImageView.this != null) {
                        CircularParseImageView.this.setImageBitmap(bitmap);
                    }
                }
            }
        });
    }
}

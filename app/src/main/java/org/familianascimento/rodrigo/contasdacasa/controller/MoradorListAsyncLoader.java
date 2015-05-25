package org.familianascimento.rodrigo.contasdacasa.controller;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * {Contas da Casa}
 * Created by weltonnascimento on 21/05/15.
 */
public class MoradorListAsyncLoader<T extends ParseObject> extends AsyncTaskLoader<List<T>> {

    private final ParseQuery mParseQuery;
    private final String LOG_TAG = "MoradorListAsyncLoader";

    public MoradorListAsyncLoader(Context c, Class type) {
        super(c);

        mParseQuery = ParseQuery.getQuery(type);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        //TODO: Must implement some sort of content observation to avoid requery everything.
        forceLoad();
    }

    @Override
    public List<T> loadInBackground() {

        Log.v(LOG_TAG, "loadInBackground");
        List<T> objectList;

        try {
            objectList = mParseQuery.find();
        } catch (ParseException e) {
            e.printStackTrace();
            objectList = new ArrayList<T>();
        }

        try {
            ParseObject.pinAll(objectList);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return objectList;
    }
}
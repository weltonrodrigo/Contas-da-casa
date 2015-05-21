package org.familianascimento.rodrigo.contasdacasa.control;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.orm.SugarRecord;

import java.util.List;

/**
 * {Contas-da-casa}
 * Created by weltonnascimento on 20/05/15.
 */
public class ListAsyncTaskLoader<T extends SugarRecord> extends AsyncTaskLoader<List<T>> {

    private Class mType;

    public ListAsyncTaskLoader(Context c, Class type) {
        super(c);
        mType = type;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<T> loadInBackground() {
        List<T> moradorList = T.listAll(mType);
        return moradorList;
    }
}

package org.familianascimento.rodrigo.contasdacasa;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;

import org.familianascimento.rodrigo.contasdacasa.controller.MoradorAdapter;
import org.familianascimento.rodrigo.contasdacasa.controller.MoradorListAsyncLoader;
import org.familianascimento.rodrigo.contasdacasa.model.Morador;

import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MoradorListFragment extends ListFragment
        implements LoaderManager.LoaderCallbacks<List<Morador>>{

    private final int LOADER_ID = 0;
    private MoradorAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoaderManager loaderManager = getLoaderManager();

        loaderManager.initLoader(LOADER_ID, null, this);
    }

    @Override
    public Loader<List<Morador>> onCreateLoader(int id, Bundle args) {
        return new MoradorListAsyncLoader<>(getActivity(), Morador.class);
    }

    @Override
    public void onLoadFinished(Loader<List<Morador>> loader, List<Morador> data) {

        if (data.isEmpty()){
            setEmptyText("Nenhum morador encontrado");
        }else {
            setListShown(true);
        }

        if( mAdapter == null) {
            mAdapter = new MoradorAdapter(getActivity(), R.layout.morador_list_item);
            mAdapter.addAll(data);
            setListAdapter(mAdapter);
        }else {
            mAdapter.clear();
            mAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Morador>> loader) {
        mAdapter.clear();
    }
}

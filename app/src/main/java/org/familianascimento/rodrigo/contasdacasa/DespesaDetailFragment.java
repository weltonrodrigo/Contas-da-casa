package org.familianascimento.rodrigo.contasdacasa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * A fragment representing a single Despesa detail screen.
 * This fragment is either contained in a {@link DespesaListActivity}
 * in two-pane mode (on tablets) or a {@link DespesaDetailActivity}
 * on handsets.
 */
public class DespesaDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private ParseObject mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DespesaDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: É preciso usar um Loader pra fazer a query em background.
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            ParseQuery parseQuery = ParseQuery.getQuery("Despesa");

            try {
                mItem = parseQuery.get(getArguments().getString(ARG_ITEM_ID));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_despesa_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.despesa_detail)).setText(mItem.getString("nome"));
        }

        return rootView;
    }
}

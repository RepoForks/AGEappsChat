package es.age.apps.ageAppsChat.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import es.age.apps.ageAppsChat.Adapters.CallsAdapter;
import es.age.apps.ageAppsChat.DummyContent;
import es.age.apps.ageAppsChat.R;

/**
 * Created by Adrián García Espinosa on 3/4/16.
 */

/**
 * A simple {@link Fragment} subclass.
 */
public class CallsFragment extends Fragment {


    View view;
    RecyclerView recyclerView;
    CallsAdapter adapter;
    DummyContent dummyContent = new DummyContent();

    public CallsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_recycler, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        adapter = new CallsAdapter(view.getContext(), dummyContent.getDummyItems());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        menuInflater.inflate(R.menu.calls, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}

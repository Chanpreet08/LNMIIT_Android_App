package lnmiit.android.app.fragment;


import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lnmiit.android.app.R;
import lnmiit.android.app.adapter.FacultyAdapter;
import lnmiit.android.app.adapter.PlacementAdapter;
import lnmiit.android.app.model.ContactDetails;
import lnmiit.android.app.model.ContactDetails;


public class ContactFragment extends Fragment {
    private RecyclerView recyclerView;
    private PlacementAdapter adapter;
    private List<ContactDetails> contactList;
    private String imageUrl[], contact_name[], contact_title[], contact_email[], contact_phone[];
    private Context applicationContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        imageUrl = getResources().getStringArray(R.array.cont_url);
        contact_name = getResources().getStringArray(R.array.cont_name);
        contact_title = getResources().getStringArray(R.array.cont_title);
        contact_email = getResources().getStringArray(R.array.cont_email);
        contact_phone = getResources().getStringArray(R.array.cont_number);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        contactList = new ArrayList<>();
        adapter = new PlacementAdapter(getContext(), contactList);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
        } else {
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        loadContactDetails();

        return view;
    }

    /**
     * this method is used to  store the faculty
     * details in an arraylist
     */
    private void loadContactDetails() {
        ContactDetails a = null;
        for (int i = 0; i < imageUrl.length; i++) {
            contactList.add(new ContactDetails(contact_name[i], contact_title[i], imageUrl[i], contact_email[i], contact_phone[i]));
        }
        adapter.notifyDataSetChanged();
    }

    public Context getApplicationContext() {

        return applicationContext;
    }
}


package com.myportfolio;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.muddzdev.styleabletoastlibrary.StyleableToast;
import com.myportfolio.adpater.ProjectAdapter;

import java.util.ArrayList;

public class ProjectFragment extends Fragment {
    private View view;
    private StyleableToast styleableToast;
    private Context projectContext;
    AdView mAdView;
    AdRequest mAdRequest;

    public ProjectFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        projectContext = this.getActivity().getApplicationContext();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       // ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Projects");

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_project, container, false);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
            parent.removeView(view);
            }
        }

        ListView listView = (ListView) view.findViewById(R.id.projects_list_view);

        ArrayList<Object> plist = new ArrayList<>();

        plist.add(new ProjectItem("Go Park"));
        plist.add(new ProjectItem("Spider Smasher"));
        plist.add(new ProjectItem("Portfolio Android App"));
        plist.add(new ProjectItem("Replicated Reliable Banking System in Python"));
        plist.add(new ProjectItem("Analysis and Data Mining of Large Crime data sets"));
        plist.add(new ProjectItem("Middlify Editor"));

        listView.setAdapter(new ProjectAdapter(getContext(),plist));

        mAdView = (AdView)view.findViewById(R.id.adView4);
        mAdRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();

        mAdView.loadAd(mAdRequest);

        return view;
    }

    public void onResume(){
        super.onResume();

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && projectContext!=null) {
            styleableToast = new StyleableToast
                        .Builder(projectContext)
                        .text("Project")
                        .textColor(Color.WHITE)
                        .icon(R.drawable.projects_icon)
                        .duration(Toast.LENGTH_SHORT)
                        .backgroundColor(Color.parseColor("#FF5722"))
                        .build();
            styleableToast.show();

            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Projects");
        }
    }
}

package com.myportfolio;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.muddzdev.styleabletoastlibrary.StyleableToast;
import com.myportfolio.adpater.SkillAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class SkillFragment extends Fragment {

    private StyleableToast styleableToast;
    private Context mContext;
    AdView mAdView;
    AdRequest mAdRequest;

    private ArrayList<String> mArrayList,j2eeArrayList,webTArrayList,dbORMArrayList,hostArrayList,ideArrayList;
    private View view;
    ListView languageListView,j2eeListView,webTechListview,dataORMListview,hostPlatListview,iDEListview;

    //String arrays all skills
    String[] language = { "Java", "R Language", "C", "C++"};
    String[] j2EE = {"Java 1.6-1.8","JDBC","Spring", "Spring MVC", "Spring Boot", "JSP, Servlet"};
    String[] webTechTools = {"HTML", "CSS", "JavaScript","PHP"};
    String[] dbORM = {"MySQL", "Hibernate", "AndroidORM", "ORMLite", "FireBase"};
    String[] hostingPlatform = {"AWS", "Digital Ocean", "Cloudinary", "Google Cloud"};
    String[] iDE = {"NetBeans", "Eclipse", "Android Studio", "RStudio", "Brackets" , "Spring Tool Suite"};



    public SkillFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getActivity().getApplicationContext();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


         //((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Skills");





        if (view == null){
            view = inflater.inflate(R.layout.skill_fragment, container, false);

        }
        else {
            ViewGroup parent  = (ViewGroup)view.getParent();
            if (parent != null) {
            parent.removeView(view);
            }

        }

        ListView listView = (ListView) view.findViewById(R.id.list_view);

        ArrayList<Object> list = new ArrayList<>();
        list.add(new String("Language"));
        list.add(new SkillItem("Java",R.drawable.rating90));
        list.add(new SkillItem("C",R.drawable.rating60));
        list.add(new SkillItem("C++",R.drawable.rating70));
        list.add(new SkillItem("R",R.drawable.rating40));

        list.add(new String("Java and J2EE Technologies"));
        list.add(new SkillItem("Java 1.6-1.8",R.drawable.rating90));
        list.add(new SkillItem("JDBC",R.drawable.rating60));
        list.add(new SkillItem("Spring",R.drawable.rating70));
        list.add(new SkillItem("Spring Boot",R.drawable.rating80));

        list.add(new String("Database and ORM"));
        list.add(new SkillItem("MySQL",R.drawable.rating90));
        list.add(new SkillItem("Hibernate",R.drawable.rating60));
        list.add(new SkillItem("AndroidORM",R.drawable.rating70));
        list.add(new SkillItem("FireBase",R.drawable.rating80));

        list.add(new String("Hosting Platform"));
        list.add(new SkillItem("Digital Ocean",R.drawable.rating90));
        list.add(new SkillItem("Cloudinary",R.drawable.rating60));
        list.add(new SkillItem("Google Cloud",R.drawable.rating70));

        list.add(new String("IDEs"));
        list.add(new SkillItem("Android Studio",R.drawable.rating90));
        list.add(new SkillItem("Eclipse",R.drawable.rating90));
        list.add(new SkillItem("Spring Tool Suite",R.drawable.rating80));
        list.add(new SkillItem("RStudio",R.drawable.rating60));
        list.add(new SkillItem("Brackets",R.drawable.rating70));
        list.add(new SkillItem("NetBeans",R.drawable.rating60));


        listView.setAdapter(new SkillAdapter(getContext(),list));

        mAdView = (AdView)view.findViewById(R.id.adView3);
        mAdRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();

        mAdView.loadAd(mAdRequest);
        // Inflate the layout for this fragment
        return view;
    }

    public void onResume(){
        super.onResume();


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && mContext!=null) {
            styleableToast = new StyleableToast
                        .Builder(mContext)
                        .text("Skill")
                        .textColor(Color.WHITE)
                        .icon(R.drawable.skills_icon)
                        .duration(Toast.LENGTH_SHORT)
                        .cornerRadius(5)
                        .backgroundColor(Color.parseColor("#23ad33"))
                        .build();
        styleableToast.show();

            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Skills");
        }
    }

}

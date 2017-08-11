package com.myportfolio;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Arrays;

public class SkillFragment extends Fragment {

    private ArrayList<String> mArrayList,j2eeArrayList,webTArrayList,dbORMArrayList,hostArrayList,ideArrayList;
    private View view;

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


         view = inflater.inflate(R.layout.skill_fragment, container, false);


        ListView listView = (ListView) view.findViewById(R.id.languageListview);
        ListView j2eeListView = (ListView) view.findViewById(R.id.j2EEListview);

        mArrayList = new ArrayList<>(Arrays.asList(language));
        j2eeArrayList = new ArrayList<>(Arrays.asList(j2EE));

        //Array Adapter for Language
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.skill_list,
                R.id.skill_list_item,
                mArrayList
        );

        listView.setAdapter(adapter);

        //Array Adapter for J2EE
        ArrayAdapter<String> adapterJ2EE = new ArrayAdapter<>(
                getContext(),
                R.layout.skill_list,
                R.id.skill_list_item,
                j2eeArrayList
        );

        j2eeListView.setAdapter(adapterJ2EE);

        // Inflate the layout for this fragment
        return view;
    }

}

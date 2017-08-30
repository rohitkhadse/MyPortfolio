package com.myportfolio;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.myportfolio.adpater.SkillAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class SkillFragment extends Fragment {

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (view == null){
            view = inflater.inflate(R.layout.skill_fragment, container, false);
        }
        else {
            ViewGroup parent  = (ViewGroup)view.getParent();
            parent.removeView(view);
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


        listView.setAdapter(new SkillAdapter(getContext(),list));
        // Inflate the layout for this fragment
        return view;
    }

}

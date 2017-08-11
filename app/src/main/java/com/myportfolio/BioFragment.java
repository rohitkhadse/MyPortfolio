package com.myportfolio;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by User on 8/4/17.
 */

public class BioFragment extends Fragment {

    CircleImageView circleImageView;
    private TextView aboutTextView;

    public BioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.bio_fragment, container, false);
        // Inflate the layout for this fragment
        aboutTextView =  (TextView) view.findViewById(R.id.aboutTextView);
        String htmlText = "I am an ORACLE Certified Java Developer with 3 years of experience \n" +
                          "in development of the web and mobile applications in Java,Spring, \n" +
                          "Spring MVC, Spring boot Hibernate. Android, MySQL, HTML5 and JavaScript.\n" +
                          "Currently, works as Software/Mobile Developer Intern in the startup.</p>";
        aboutTextView.setText(Html.fromHtml(htmlText));

        return view;

    }



}

package com.myportfolio;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.muddzdev.styleabletoastlibrary.StyleableToast;
import com.uncopt.android.widget.text.justify.JustifiedTextView;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by User on 8/4/17.
 */

public class BioFragment extends Fragment {

    CircleImageView circleImageView;
    private TextView aboutTextView;
    private StyleableToast bioToast;
    private Context bioContext;
    AdView mAdView;
    AdRequest mAdRequest;

    public BioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bioContext = this.getActivity().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       // ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Bio");



        bioToast = new StyleableToast
                        .Builder(bioContext)
                        .text("Bio")
                        .textColor(Color.WHITE)
                        .icon(R.drawable.bio_icon)
                        .duration(Toast.LENGTH_SHORT)
                        .backgroundColor(Color.parseColor("#607D8B"))
                        .build();

        final View view = inflater.inflate(R.layout.bio_fragment, container, false);
        // Inflate the layout for this fragment
        /*aboutTextView =  (TextView) view.findViewById(R.id.aboutTextView);
        String htmlText = "I am an ORACLE Certified Java Developer with 3 years of experience" +
                          "in development of the web and mobile applications in Java,Spring," +
                          "Spring MVC, Spring boot Hibernate. Android, MySQL, HTML5 and JavaScript." +
                          "Currently, works as Software/Mobile Developer Intern in the startup.</p>";
        aboutTextView.setText(Html.fromHtml(htmlText));*/

        JustifiedTextView myMsg = (JustifiedTextView)view.findViewById(R.id.t1);
        myMsg.setText("ORACLE Certified Java Developer with 3 years of Professional experience in " +
                "development of the web and mobile applications.Worked as a Software and Mobile " +
                "Developer intern for a startup while pursuing Masters in Science in Computer Science" +
                " from Lamar University, Texas. In Depth knowledge of technologies including Java, " +
                "Spring MVC, Spring Boot, Hibernate. Android, REST,JAX-RS,MySQL, HTML5 and JavaScript, API Integration.");

        mAdView = (AdView)view.findViewById(R.id.adView2);
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
        if (isVisibleToUser) {
            if (bioToast != null) {
                bioToast.show();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Bio");
            }
        }
    }

}

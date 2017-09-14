package com.myportfolio;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class ContactFragment extends Fragment implements View.OnClickListener {
    ImageView gitHub,linkedIn,googlePlay;
    private StyleableToast styleableToast;
    private Context contactContext;

    public ContactFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactContext = this.getActivity().getApplicationContext();
    }

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         final View view = inflater.inflate(R.layout.fragment_contact, container, false);

         linkedIn = (ImageView)view.findViewById(R.id.linkedin_imageview);
         linkedIn.setOnClickListener(this);

         gitHub = (ImageView)view.findViewById(R.id.github_imageview);
         gitHub.setOnClickListener(this);

         googlePlay = (ImageView)view.findViewById(R.id.playstore_imageview);
         googlePlay.setOnClickListener(this);



         return view;
        }

        @Override
        public void onClick(View v) {
            Intent intent;
	            switch(v.getId()){
	            case R.id.linkedin_imageview:
	                intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("https://www.linkedin.com/in/rohitkhadse/"));
                    startActivity(intent);
                    break;

	            case R.id.github_imageview:
	                intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("https://github.com/rohitkhadse"));
                    startActivity(intent);
                    break;

                case R.id.playstore_imageview:
	                intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Rohit%20Khadse&hl=en"));
                    startActivity(intent);
                    break;

	            }
        }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && contactContext!=null) {
            styleableToast = new StyleableToast
                        .Builder(contactContext)
                        .text("Contact")
                        .textColor(Color.WHITE)
                        .icon(R.drawable.contact_icon)
                        .duration(Toast.LENGTH_SHORT)
                        .cornerRadius(10)
                        .backgroundColor(Color.parseColor("#5C6BC0"))
                        .build();
             styleableToast.show();

            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Contact");
        }
    }
}

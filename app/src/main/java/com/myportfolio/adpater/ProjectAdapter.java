package com.myportfolio.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myportfolio.ProjectItem;
import com.myportfolio.R;

import java.util.ArrayList;

/**
 * Created by User on 8/30/17.
 */

public class ProjectAdapter extends BaseAdapter {

    ArrayList<Object> list;
    private static final int PROJECT_ITEM = 0;
    private LayoutInflater inflater;

    public ProjectAdapter(Context context, ArrayList<Object> list){
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemViewType(int position) {
        return PROJECT_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 1;                       ///will return total number of views
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.project_listview_item,null);
        }

        if (getItemViewType(i) == PROJECT_ITEM) {
            TextView projectName = (TextView) view.findViewById(R.id.projectsNameItem);
            //TextView projectDetail = (TextView) view.findViewById(R.id.projectDetailItem);

            projectName.setText(((ProjectItem) list.get(i)).getPname());
            //projectDetail.setText(((ProjectItem) list.get(i)).getPdetail());
        }

        return view;
    }

}

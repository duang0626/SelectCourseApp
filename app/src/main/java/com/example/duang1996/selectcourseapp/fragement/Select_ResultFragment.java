package com.example.duang1996.selectcourseapp.fragement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duang1996.selectcourseapp.PersonDetailActivity;
import com.example.duang1996.selectcourseapp.R;


public class Select_ResultFragment extends Fragment implements  View.OnClickListener {
    private TextView title;
    private ImageView person;
    private View mView;

    private TextView general_com;
    private TextView general_elec;
    private TextView major_com;
    private TextView major_elec;

    public static Select_ResultFragment newInstance(String param1) {
        Select_ResultFragment fragment = new Select_ResultFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_select_result, container, false);

        /*
         *初始化控件
         */
        initViews();

        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        resetTextViewState();
        switch (v.getId()) {
            case R.id.general_compulsory:
                setTextViewState(general_com, getLocalColor(R.color.course_type_non), getLocalColor(R.color.white));
                Toast.makeText(getContext(), "你选择了公必", Toast.LENGTH_SHORT).show();
                break;
            case R.id.general_elective:
                setTextViewState(general_elec, getLocalColor(R.color.course_type_non), getLocalColor(R.color.white));
                Toast.makeText(getContext(), "你选择了公选", Toast.LENGTH_SHORT).show();
                break;
            case R.id.major_compulsory:
                setTextViewState(major_com, getLocalColor(R.color.course_type_non), getLocalColor(R.color.white));
                Toast.makeText(getContext(), "你选择了专必", Toast.LENGTH_SHORT).show();
                break;
            case R.id.major_elective:
                setTextViewState(major_elec, getLocalColor(R.color.course_type_non), getLocalColor(R.color.white));
                Toast.makeText(getContext(), "你选择了专选", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initViews() {
        title = mView.findViewById(R.id.tab3).findViewById(R.id.title);
        title.setText("已选课程");

        person = mView.findViewById(R.id.tab3).findViewById(R.id.person);
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonDetailActivity.class);
                startActivity(intent);
            }
        });

        general_com = mView.findViewById(R.id.general_compulsory);
        general_elec = mView.findViewById(R.id.general_elective);
        major_com = mView.findViewById(R.id.major_compulsory);
        major_elec = mView.findViewById(R.id.major_elective);

        general_com.setOnClickListener(this);
        general_elec.setOnClickListener(this);
        major_com.setOnClickListener(this);
        major_elec.setOnClickListener(this);

        setTextViewState(general_com, getLocalColor(R.color.course_type_non), getLocalColor(R.color.white));
    }

    private void resetTextViewState() {
        setTextViewState(general_com, getLocalColor(R.color.white),getLocalColor(R.color.course_type_non));
        setTextViewState(general_elec, getLocalColor(R.color.white), getLocalColor(R.color.course_type_non));
        setTextViewState(major_com, getLocalColor(R.color.white), getLocalColor(R.color.course_type_non));
        setTextViewState(major_elec, getLocalColor(R.color.white), getLocalColor(R.color.course_type_non));

    }

    private void setTextViewState(TextView textView, int backColor, int textColor) {
        textView.setBackgroundColor(backColor);
        textView.setTextColor(textColor);
    }
    private int getLocalColor(int id) {
        return ContextCompat.getColor(getActivity(), id);
    }
}
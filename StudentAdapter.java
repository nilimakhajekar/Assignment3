package com.example.kanchan.myapplication.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.kanchan.myapplication.Database.StudentTable;
import com.example.kanchan.myapplication.Interface.OnButtonClickedListener;
import com.example.kanchan.myapplication.R;
import com.example.kanchan.myapplication.StudentList;
import com.example.kanchan.myapplication.StudentModel;
import com.example.kanchan.myapplication.databinding.StudentListItemBinding;


import java.util.List;

/**
 * Created by kanchan on 01/04/2017.
 */
public class StudentAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<StudentModel> list;
    StudentListItemBinding binding;
    StudentTable studentTable;
    Context context;
    OnButtonClickedListener onButtonClickedListener;

    public StudentAdapter(Context context, List<StudentModel> list) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
        this.studentTable = studentTable;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public StudentModel getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        binding = DataBindingUtil.inflate(inflater, R.layout.student_list_item, viewGroup, false);
        final StudentModel studentModel = list.get(i);

       // binding.setSudentModel(studentModel);
        binding.setStudentModel(studentModel);

        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClickedListener.onClick(view, i);
            }
        });

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClickedListener.onClick(view, i);
            }
        });
        return binding.getRoot();
    }

    public void setOnButtonClickedListener(OnButtonClickedListener onButtonClickedListener) {
        this.onButtonClickedListener = onButtonClickedListener;
    }
}

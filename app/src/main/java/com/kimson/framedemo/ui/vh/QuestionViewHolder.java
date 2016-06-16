package com.kimson.framedemo.ui.vh;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kimson.framedemo.R;
import com.kimson.framedemo.model.Question;
import com.kimson.library.bind.Bind;
import com.kimson.library.bind.ViewById;
import com.kimson.library.widget.Toaster;

/**
 * Created by zhujianheng on 6/2/16.
 */
public class QuestionViewHolder extends ViewHolder {

    @ViewById(R.id.question)
    private TextView question;
    @ViewById(R.id.question_content)
    private TextView question_content;

    @ViewById(R.id.list_item)
    private LinearLayout listItem;

    public QuestionViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(final Question data) {
        question.setText(data.getTitle());
        question_content.setText(data.getContent());
        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toaster.showShort((Activity) itemView.getContext(), data.getContent());
            }
        });
    }

}

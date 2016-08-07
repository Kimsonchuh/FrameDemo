package com.kimson.framedemo.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.kimson.framedemo.R;
import com.kimson.framedemo.model.Question;
import com.kimson.framedemo.model.Result;
import com.kimson.framedemo.ui.base.ListActivity;
import com.kimson.framedemo.ui.vh.QuestionViewHolder;
import com.kimson.library.bind.ViewById;
import com.kimson.library.widget.DividerItemDecoration;
import com.kimson.library.widget.Toaster;

import java.util.ArrayList;

/**
 * Created by zhujianheng on 6/18/16.
 */
public class NewComActivity extends ListActivity <QuestionViewHolder, Question, Result<ArrayList<Question>>> {
    public static final String TAG = NewComActivity.class.getSimpleName();

    @ViewById(R.id.toolbar)
    private Toolbar toolbar;
    @ViewById(R.id.collapsing_toolbar)
    private CollapsingToolbarLayout collapsingToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_comp);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitle("NewCom");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getRecyclerView().addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        initLoader();
    }

    @Override
    public void onRefresh() {
        forceLoad();
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_question_list_item, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        holder.bind(getItemsSource().get(position));
    }


    @Override
    public void onLoadStart() {
    }

    @Override
    public Result<ArrayList<Question>> onLoadInBackground() throws Exception {
        Log.e(TAG, ">>>onLoadInBackground");
//        return QuestionLogic.getQuestionList();
        return getQuestion();
    }

    private Result<ArrayList<Question>> getQuestion () {
        Result<ArrayList<Question>> result = new Result<>();
        ArrayList<Question> questions = new ArrayList<>();
        for (int i = 0; i < 15; i ++) {
            Question question = new Question();
            question.setTitle("question" + i);
            question.setContent("haha" + i);
            questions.add(question);
        }
        result.setStatus("success");
        result.setData(questions);
        return result;
    }


    @Override
    public void onLoadComplete(Result<ArrayList<Question>> data) {
        Log.e(TAG, ">>>onLoadComplete");
        if (data != null) {
            if (data.isSuccess()) {
                if (!mIsLoadingMore) {
                    getItemsSource().clear();
                    Toaster.showShort(this, "You have received " + data.getData().size() + " new items");
                }
                getItemsSource().addAll(data.getData());
            }
        }
        getAdapter().notifyDataSetChanged();
        onRefreshComplete();
    }

    @Override
    public void onLoadError(Exception e) {
        Log.e(TAG, ">>>onLoadError");
        Toaster.showShort(this, "网络异常");
    }


}

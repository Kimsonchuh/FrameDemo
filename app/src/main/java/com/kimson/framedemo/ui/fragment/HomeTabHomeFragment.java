package com.kimson.framedemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimson.framedemo.R;
import com.kimson.framedemo.logic.QuestionLogic;
import com.kimson.framedemo.model.Question;
import com.kimson.framedemo.model.Result;
import com.kimson.framedemo.ui.base.BaseFragment;
import com.kimson.framedemo.ui.base.ListFragment;
import com.kimson.framedemo.ui.vh.QuestionViewHolder;
import com.kimson.library.widget.DividerItemDecoration;
import com.kimson.library.widget.Toaster;

import java.util.ArrayList;

/**
 * Created by zhujianheng on 6/3/16.
 */
public class HomeTabHomeFragment extends ListFragment<QuestionViewHolder, Question, Result<ArrayList<Question>>> {
    public static final String TAG = HomeTabHomeFragment.class.getSimpleName();

    public static HomeTabHomeFragment newInstance() {
        HomeTabHomeFragment fragment = new HomeTabHomeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, ">>>onCreateView");
        View view = inflater.inflate(R.layout.fragment_home_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.e(TAG, ">>>onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        getRecyclerView().addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        getPullToRefreshLayout().setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        initLoader();
    }

    @Override
    public void onRefresh() {
        Log.e(TAG, ">>>onRefresh");
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
        Log.e(TAG, ">>>onLoadComplete；isLoadMore:" + mIsLoadingMore);
        if (data != null) {
            if (data.isSuccess()) {
                if (!mIsLoadingMore) {
                    getItemsSource().clear();
                    Toaster.showShort(getActivity(), "You have received " + data.getData().size() + " new items");
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
    }
}

package com.example.abgsuy.duoihinhbatchu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Abgsuy on 03/05/2017.
 */

public class FragmentPlay extends Fragment implements View.OnClickListener {

    private ObjectGames mObject;
    private String mPlayerAnswer="";

    private Button mBtnNext;
    private ImageView mImgQuestion;
    private TextView mTvMessage;
    private ImageView mImgSoundOn, mImgSoundOff, mImgOpen, mImgReload, mImgSuggest;
    private int mIndext = 0;
    private LinearLayout mLlChoose,mLlAnswer;
    private LayoutInflater mLayoutInflater;
    private LinearLayout rowView;
    private int row ;
    private boolean turnOn = true;
    private TextView mTvLife, mTvScore, mTvSuggest;
    private MediaPlayer mPlayerTrue, mPlayerFalse;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        findViews(view);
        initGame();
    }

    private void findViews(View view) {
        mBtnNext = (Button) view.findViewById(R.id.btn_next);
        mTvMessage = (TextView) view.findViewById(R.id.tv_message);
        mImgSoundOn = (ImageView) view.findViewById(R.id.iv_sound_on);
        mImgSoundOff = (ImageView) view.findViewById(R.id.iv_sound_off);
        mImgReload = (ImageView) view.findViewById(R.id.reload);
        mImgOpen = (ImageView) view.findViewById(R.id.iv_open);
        mImgQuestion = (ImageView) view.findViewById(R.id.iv_question);
        mLlChoose = (LinearLayout) getActivity().findViewById(R.id.ll_row_choose);
        mLayoutInflater = LayoutInflater.from(getContext());
        mLlAnswer = (LinearLayout) getActivity().findViewById(R.id.ll_row_answer);
        mTvLife = (TextView) view.findViewById(R.id.tv_life);
        mTvScore = (TextView) view.findViewById(R.id.tv_score);
        mImgSuggest = (ImageView) view.findViewById(R.id.iv_suggest);
        mTvSuggest = (TextView) view.findViewById(R.id.tv_suggest);
    }

    private void initGame() {
        setClick();
        mObject = ((GameApp)getContext().getApplicationContext()).getObjects();
        mImgQuestion.setImageResource(mObject.getIdImage());
        setPlayer();
        initAnswer();
        initChooseAnswer();
    }

    private void setPlayer() {
        mPlayerTrue = MediaPlayer.create(getContext(), R.raw.right_4);
        mPlayerFalse = MediaPlayer.create(getContext(), R.raw.over);
    }

    private void setClick() {
        mImgSoundOn.setOnClickListener(this);
        mImgSoundOff.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
        mImgOpen.setOnClickListener(this);
        mImgReload.setOnClickListener(this);
        mImgSuggest.setOnClickListener(this);
    }

    private void initChooseAnswer() {
        for (int i = 0; i < 2; i++) {
            rowView = (LinearLayout) mLayoutInflater.inflate(R.layout.ll_choose, mLlChoose, false);
            mLlChoose.addView(rowView);
            for (int j = 0; j < 8; j++) {
                if (i * 8 + j >= mObject.getChooseAnswer().length()) {
                    break;
                }
                TextView tvContent = (TextView) mLayoutInflater.inflate(R.layout.item_choose, rowView, false);
                rowView.addView(tvContent);
                int indexChar = i * 8 + j;
                char contentChar = mObject.getChooseAnswer().charAt(indexChar);
                tvContent.setText(contentChar + "");
                tvContent.setId(i * 8 + j+16);
                tvContent.setOnClickListener(this);
            }
        }
    }

    private void initAnswer() {
         row = (int) Math.ceil((float) mObject.getTrueAnswer().length() / 8);
        for (int i = 0; i < row; i++) {
            LinearLayout rowView = (LinearLayout) mLayoutInflater.inflate(R.layout.ll_answer, mLlAnswer, false);
            mLlAnswer.addView(rowView);
            for (int j = 0; j < 8; j++) {
                if (i * 8 + j >= mObject.getTrueAnswer().length()) {
                    break;
                }
                TextView tvContent = (TextView) mLayoutInflater.inflate(R.layout.item_answer, rowView, false);
                rowView.addView(tvContent);
                tvContent.setText("");
                tvContent.setId(i * 8 + j);
                tvContent.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_next){
            restart();
        }
        if(16<=v.getId() && v.getId()<32) {
            playerChoose(v.getId());
        }
        if (v.getId() == R.id.iv_sound_on){
            mImgSoundOn.setVisibility(View.INVISIBLE);
            mImgSoundOff.setVisibility(View.VISIBLE);
            turnOn = false;
        }
        if (v.getId() == R.id.iv_sound_off){
            mImgSoundOn.setVisibility(View.VISIBLE);
            mImgSoundOff.setVisibility(View.INVISIBLE);
            turnOn = true;
        }
        if (v.getId() == R.id.iv_open){
            showSuggess();
        }
        if (v.getId() == R.id.reload){
            reload();
        }
        if (v.getId() == R.id.iv_suggest){
            suggest();
        }
    }

    private void suggest() {
        ((GameApp)getContext().getApplicationContext()).setSuggest();
        int suggest = ((GameApp)getContext().getApplicationContext()).getSuggest();
        if (suggest >= 0){
            mTvSuggest.setText(suggest+"");
            final AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
            builder1.setMessage("Đáp án: " + mObject.getTrueAnswer());
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
        else {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
            builder1.setMessage("Bạn đã sử dụng hết sự trợ giúp!");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
            mImgSuggest.setClickable(false);
        }
    }

    private void reload() {
        mPlayerAnswer = "";
        mLlAnswer.removeAllViews();
        mLlChoose.removeAllViews();
        initAnswer();
        initChooseAnswer();
        mIndext = 0;
    }

    private void showSuggess() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
        builder1.setMessage("Chữ cái đầu tiên là: " + mObject.getTrueAnswer().charAt(0));
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void restart() {
        ((GameApp)getContext().getApplicationContext()).remove();
        mPlayerTrue.release();
        mPlayerAnswer = "";
        mTvMessage.setText("");
        mLlAnswer.removeAllViews();
        mLlChoose.removeAllViews();
        mImgQuestion.clearFocus();
        mBtnNext.setVisibility(View.INVISIBLE);
        mIndext = 0;
        initGame();
    }



    private void playerChoose(int id) {
        TextView tv = (TextView) getActivity().findViewById(id);
        if(mIndext >= 0 && mIndext < mObject.getTrueAnswer().length()){
            TextView tvAnswer = (TextView)getActivity().findViewById(mIndext);
            if(tvAnswer.getText()==""){
                addChooseToAnswer(tv, tvAnswer);
                if(mIndext < mObject.getTrueAnswer().length()-1){
                    mIndext++;
                }
                else {
                    checkChooseAnswer();
                }

            }
        }
    }
    private void addChooseToAnswer(TextView tv, TextView tvAnswer) {
        tvAnswer.setText(tv.getText());
        mPlayerAnswer = mPlayerAnswer + tvAnswer.getText();
        tv.setVisibility(View.INVISIBLE);
        tvAnswer.setBackground(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.tile_hover));
    }

    private void checkChooseAnswer() {
        for(int i = 0; i < mObject.getTrueAnswer().length(); i++){
            TextView tv2 = (TextView)getActivity().findViewById(i);
            if(mPlayerAnswer.equals(mObject.getTrueAnswer())){
                tv2.setTextColor(ContextCompat.getColor(getContext().getApplicationContext(), R.color.trueColor));
                tv2.setBackground(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.tile_true));
                mTvMessage.setText(((GameApp)getContext().getApplicationContext()).getMessage("correct"));
                mImgReload.setClickable(false);
                mImgOpen.setClickable(false);
                if(turnOn == true){
                    mPlayerTrue.start();
                    mPlayerTrue.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mBtnNext.setVisibility(View.VISIBLE);
                        }
                    });
                }
                else
                    mBtnNext.setVisibility(View.VISIBLE);
            }
            else {
                mImgReload.setClickable(false);
                mImgOpen.setClickable(false);

                if (turnOn == true){
                    mPlayerFalse.start();
                    mPlayerFalse.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            if(((GameApp) getContext().getApplicationContext()).getLife() != -1){
                                mBtnNext.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
                else
                    mBtnNext.setVisibility(View.VISIBLE);
                tv2.setTextColor(ContextCompat.getColor(getContext().getApplicationContext(), R.color.falseColor));
                tv2.setBackground(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.tile_false));
                mTvMessage.setText(((GameApp)getContext().getApplicationContext()).getMessage("wrong"));
            }
        }
        if(mPlayerAnswer.equals(mObject.getTrueAnswer())){
            ((GameApp) getContext().getApplicationContext()).setCheck(true);
            ((GameApp)getContext().getApplicationContext()).setScore();
            mTvScore.setText(((GameApp)getContext().getApplicationContext()).getScore()+"");
        }
        else {
            ((GameApp) getContext().getApplicationContext()).setCheck(false);
            ((GameApp)getContext().getApplicationContext()).setLife();
            if (((GameApp) getContext().getApplicationContext()).getLife() != -1)
                mTvLife.setText(((GameApp) getContext().getApplicationContext()).getLife()+"");
            if(((GameApp) getContext().getApplicationContext()).getLife() == -1){
                showDialog();
            }
        }
    }

    private void showDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
        builder1.setMessage("Bạn đã hết lượt chơi! " + "\n" + "Điểm: " + ((GameApp)getContext().getApplicationContext()).getScore());
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        FragmentOpen mFragmentOpen = new FragmentOpen();
                        FragmentManager manager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.setCustomAnimations(R.anim.first_in,R.anim.first_out,
                                R.anim.sec_in,R.anim.sec_out);
                        transaction.replace(R.id.fr_layout,mFragmentOpen,mFragmentOpen.getClass().getName());
                        transaction.addToBackStack("k");
                        transaction.commit();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}

package com.example.myapplication;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ui.activity.FirstActivity;

/**
 * 此页面是为了验证ViewGroup布局变化时的动画效果
 */
public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "TestActivity";
    private com.example.myapplication.databinding.ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.myapplication.databinding.ActivityTestBinding.inflate(getLayoutInflater());
        initView();
    }


    private void initView() {
        binding.btnAdd.setOnClickListener(this);
        binding.btnAnimator.setOnClickListener(this);
        binding.btnFirstActivity.setOnClickListener(this);
        binding.btnLaunchSelf.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                addView();
                break;
            case R.id.btn_animator:
                performAnimation();
                break;
            case R.id.btn_launch_self:
                launchSelf();
                break;
            case R.id.btn_first_activity:
                launchFirstActivity();
                break;
            default:
        }
    }

    private void addView() {
        LayoutTransition layoutTransition = binding.linearLayout.getLayoutTransition();
        //通过翻转动画取代默认的动画效果
        Animator animatorIn = ObjectAnimator.ofFloat(null, "rotationY", 90f, 0f)
                .setDuration(layoutTransition.getDuration(LayoutTransition.APPEARING));
        layoutTransition.setAnimator(LayoutTransition.APPEARING, animatorIn);
        Animator animatorOut = ObjectAnimator.ofFloat(null, "rotationY", 90f, 0f)
                .setDuration(layoutTransition.getDuration(LayoutTransition.DISAPPEARING));
        Animator animatorAlphaOut = ObjectAnimator.ofFloat(null, "alpha", 1.0f, 0.0f)
                .setDuration(layoutTransition.getDuration(LayoutTransition.DISAPPEARING));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animatorOut, animatorAlphaOut);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, animatorSet);

        final Button button = new Button(this);
        button.setText("i am a new Button");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.linearLayout.removeView(button);
            }
        });

        binding.linearLayout.addView(button, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    private void performAnimation() {
        if (binding.linearLayout.getVisibility() == View.VISIBLE) {
//            Animation animationOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
//            Animation animationOut = AnimationUtils.makeOutAnimation(this, true);
            Animation animationOut = AnimationUtils.loadAnimation(this, R.anim.slide_out_child_bottom);
            binding.linearLayout.setAnimation(animationOut);
            animationOut.start();
            binding. linearLayout.setVisibility(View.INVISIBLE);
        } else {
//            Animation animationIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
//            Animation animationIn = AnimationUtils.makeInAnimation(this, true);
            Animation animationIn = AnimationUtils.makeInChildBottomAnimation(this);
            binding. linearLayout.startAnimation(animationIn);
            binding. linearLayout.setVisibility(View.VISIBLE);
        }
    }

    private void launchFirstActivity() {
        Intent intent = new Intent(this, FirstActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    private void launchSelf() {
        Intent intent = new Intent(this, TestActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }
}

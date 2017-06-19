package xy.com.loading_page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * author  :   xieyang
 * e-mail  :   1192171830@qq.com
 * time    :   2017/6/19
 * desc    :
 * version :   1.0
 */

public class LoadingPage extends LinearLayout {

    //整个页面
    private View loadingView;

    //加载进度圈
    private ProgressBar LoadingBar;

    //提示文字
    private TextView loadingText;


    public LoadingPage(Context context) {
        super(context);
        initView(context);
    }

    public LoadingPage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadingPage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(final Context context) {
        loadingView = LayoutInflater.from(context).inflate(R.layout.loading_page, this, true);
        LoadingBar = (ProgressBar) loadingView.findViewById(R.id.loadingBar);
        loadingText = (TextView) loadingView.findViewById(R.id.loadingText);
    }

    /**
     * 整个界面出现
     */
    public void onVisible() {
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(loadingView, "scaleX",0f,1f);
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(loadingView, "scaleY",0f,1f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(300);
        set.playTogether(objectAnimatorX, objectAnimatorY);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                loadingView.setVisibility(View.VISIBLE);
            }
        });
        set.start();
    }

    /**
     * 整个界面隐藏
     */
    public void onGone() {
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(loadingView, "scaleX",1f,0f);
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(loadingView, "scaleY",1f,0f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(3000);
        set.playTogether(objectAnimatorX, objectAnimatorY);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                loadingView.setVisibility(View.GONE);
            }
        });
        set.start();
    }

    /**
     * 设置提示问题
     */
    public void onLoadingTextChange(String loadingStr) {
        loadingText.setText("" + loadingStr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(true, loadingView.getLeft(), loadingView.getTop(), loadingView.getRight(), loadingView.getBottom());
    }
}

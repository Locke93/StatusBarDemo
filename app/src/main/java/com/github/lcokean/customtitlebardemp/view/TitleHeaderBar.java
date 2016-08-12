package com.github.lcokean.customtitlebardemp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.lcokean.customtitlebardemp.R;


public class TitleHeaderBar extends RelativeLayout {

    private RelativeLayout mRootViewContainer;
    private TextView mCenterTitleTextView;
    private ImageView mLeftReturnImageView;
    private ImageView mRightMoreActionView;
    private RelativeLayout mLeftViewContainer;
    private RelativeLayout mRightViewContainer;
    private RelativeLayout mCenterViewContainer;
    private View mBottomLine;

    public TitleHeaderBar(Context context) {
        this(context, null);
    }

    public TitleHeaderBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleHeaderBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(getHeaderViewLayoutId(), this);
        mRootViewContainer = (RelativeLayout) findViewById(R.id.ly_title_bar_root);
        mLeftViewContainer = (RelativeLayout) findViewById(R.id.ly_title_bar_left);
        mCenterViewContainer = (RelativeLayout) findViewById(R.id.ly_title_bar_center);
        mRightViewContainer = (RelativeLayout) findViewById(R.id.ly_title_bar_right);
        mLeftReturnImageView = (ImageView) findViewById(R.id.iv_title_bar_left);
        mCenterTitleTextView = (TextView) findViewById(R.id.tv_title_bar_title);
        mRightMoreActionView = (ImageView) findViewById(R.id.iv_title_bar_right);
        mBottomLine = findViewById(R.id.view_title_bar_bottom_line);
    }

    protected int getHeaderViewLayoutId() {
        return R.layout.base_header_bar_title;
    }

    public ImageView getLeftImageView() {
        return mLeftReturnImageView;
    }

    public ImageView getRightImageView() {
        return mRightMoreActionView;
    }

    public TextView getTitleTextView() {
        return mCenterTitleTextView;
    }

    public void setTitle(String title) {
        mCenterTitleTextView.setText(title);
    }

    public void setTitle(int resId) {
        mCenterTitleTextView.setText(resId);
    }

    private LayoutParams makeLayoutParams(View view) {
        ViewGroup.LayoutParams lpOld = view.getLayoutParams();
        LayoutParams lp = null;
        if (lpOld == null) {
            lp = new LayoutParams(-2, -1);
        } else {
            lp = new LayoutParams(lpOld.width, lpOld.height);
        }
        return lp;
    }

    public void setBackgroundColor(int color) {
        mRootViewContainer.setBackgroundColor(color);
    }

    /**
     * set customized view to root view
     *
     * @param view the view to be added to left side
     */
    public void setCustomizedRootView(View view) {
        mLeftReturnImageView.setVisibility(GONE);
        mCenterTitleTextView.setVisibility(GONE);
        mRightMoreActionView.setVisibility(GONE);
        LayoutParams lp = makeLayoutParams(view);
        lp.addRule(CENTER_IN_PARENT);
        mRootViewContainer.addView(view, lp);
    }

    /**
     * set customized view to root view
     *
     * @param layoutId the xml layout file id
     */
    public void setCustomizedRootView(int layoutId) {
        View view = inflate(getContext(), layoutId, null);
        setCustomizedRootView(view);
    }

    /**
     * set customized view to left side
     *
     * @param view the view to be added to left side
     */
    public void setCustomizedLeftView(View view) {
        mLeftReturnImageView.setVisibility(GONE);
        LayoutParams lp = makeLayoutParams(view);
        lp.addRule(CENTER_VERTICAL);
        lp.addRule(ALIGN_PARENT_LEFT);
        getLeftViewContainer().addView(view, lp);
    }

    /**
     * set customized view to left side
     *
     * @param layoutId the xml layout file id
     */
    public void setCustomizedLeftView(int layoutId) {
        View view = inflate(getContext(), layoutId, null);
        setCustomizedLeftView(view);
    }

    /**
     * set customized view to center
     *
     * @param view the view to be added to center
     */
    public void setCustomizedCenterView(View view) {
        mCenterTitleTextView.setVisibility(GONE);
        LayoutParams lp = makeLayoutParams(view);
        lp.addRule(CENTER_IN_PARENT);
        getCenterViewContainer().addView(view, lp);
    }

    /**
     * set customized view to center
     *
     * @param layoutId the xml layout file id
     */
    public void setCustomizedCenterView(int layoutId) {
        View view = inflate(getContext(), layoutId, null);
        setCustomizedCenterView(view);
    }

    /**
     * set customized view to right side
     *
     * @param view the view to be added to right side
     */
    public void setCustomizedRightView(View view) {
        mRightMoreActionView.setVisibility(GONE);
        LayoutParams lp = makeLayoutParams(view);
        lp.addRule(CENTER_VERTICAL);
        lp.addRule(ALIGN_PARENT_RIGHT);
        getRightViewContainer().addView(view, lp);
    }

    /**
     * set customized view to right side
     *
     * @param layoutId the xml layout file id
     */
    public void setCustomizedRightView(int layoutId) {
        View view = inflate(getContext(), layoutId, null);
        setCustomizedRightView(view);
    }

    public void setBottomLineVisibie(boolean visibie) {
        mBottomLine.setVisibility(visibie ? VISIBLE : GONE);
    }

    public RelativeLayout getLeftViewContainer() {
        return mLeftViewContainer;
    }

    public RelativeLayout getCenterViewContainer() {
        return mCenterViewContainer;
    }

    public RelativeLayout getRightViewContainer() {
        return mRightViewContainer;
    }

    public void setLeftOnClickListener(OnClickListener l) {
        mLeftViewContainer.setOnClickListener(l);
    }

    public void setCenterOnClickListener(OnClickListener l) {
        mCenterViewContainer.setOnClickListener(l);
    }

    public void setRightOnClickListener(OnClickListener l) {
        mRightViewContainer.setOnClickListener(l);
    }

}
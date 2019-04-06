package com.android.basi.percentageprogressbar;


import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class PercentageProgressBar extends View {

    /**
     * Draw Text progress
     */
    private Paint mProgressPaint;
    /**
     * Draw  progress
     */
    private Paint mCirclePaint;
    /**
     * Draw  secondary progress
     */
    private Paint mSecondaryCirclePaint;

    /**
     * Thickness of the progress
     */
    private float mTextThickness;
    /**
     * Thickness of the progress
     */
    private float mProgressBarThickness;

    /**
     * Rect for drawing circle
     */
    private RectF mCircleRect;
    /**
     * Circle Color
     */

    private int mCirclePaintColor;
    /**
     * Secondary Circle Color
     */

    private int mSecondaryCirclePaintColor;
    /**
     * Text Color
     */

    private int mTextPaintColor;

    /**
     * Actual size of the complete circle.
     **/
    private int mSize;
    /**
     * Starting Angle to start the progress Animation.
     */

    private int progress = 0;
    private int max;
    private float mStartAngle = -90;

    private String preText = "";
    private String postText = "";

    public PercentageProgressBar(Context context) {
        super(context);
        init(null, 0);
    }

    public PercentageProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public PercentageProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyle) {
        mProgressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mSecondaryCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCircleRect = new RectF();

        Resources resources = getResources();

        if (attrs != null) {
            final TypedArray a = getContext().obtainStyledAttributes(
                    attrs, R.styleable.PercentageProgressBar, defStyle, 0);
            try {


                float tempSize = a.getDimensionPixelSize(R.styleable.PercentageProgressBar_ppb_text_size,
                        resources.getDimensionPixelSize(R.dimen.default_text_size));

                mTextThickness = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                        tempSize, getResources().getDisplayMetrics());

                mProgressBarThickness = a.getDimensionPixelSize(R.styleable.PercentageProgressBar_ppb_thickness,
                        30);

                mCirclePaintColor = a.getColor(R.styleable.PercentageProgressBar_ppb_progress_color,
                        Color.BLACK);

                mSecondaryCirclePaintColor = a.getColor(R.styleable.PercentageProgressBar_ppb_secondary_progress_color,
                        Color.LTGRAY);

                mTextPaintColor = a.getColor(R.styleable.PercentageProgressBar_ppb_text_color,
                        Color.BLACK);

                setMax(a.getInt(R.styleable.PercentageProgressBar_ppb_progress_max, 100));
                setProgress(a.getInt(R.styleable.PercentageProgressBar_ppb_progress, 0));

                setPreText(a.getString(R.styleable.PercentageProgressBar_ppb_progress_pre_text));
                setPostText(a.getString(R.styleable.PercentageProgressBar_ppb_progress_post_text));

//                setmTextPaintColor(mCirclePaintColor);
            } finally {

                a.recycle();
            }

            setPaint();
        }
    }

    /**
     * Set the two paint object with
     * supplied color for drawing.
     */
    private void setPaint() {

        mProgressPaint.setColor(mTextPaintColor);
        mProgressPaint.setStyle(Paint.Style.STROKE);
        mProgressPaint.setTextSize(mTextThickness);
        mProgressPaint.setStrokeCap(Paint.Cap.BUTT);

        mCirclePaint.setColor(mCirclePaintColor);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setStrokeWidth(mProgressBarThickness);
        mCirclePaint.setStrokeCap(Paint.Cap.BUTT);


        mSecondaryCirclePaint.setColor(mSecondaryCirclePaintColor);
        mSecondaryCirclePaint.setStyle(Paint.Style.STROKE);
        mSecondaryCirclePaint.setStrokeWidth(mProgressBarThickness);
        mSecondaryCirclePaint.setStrokeCap(Paint.Cap.BUTT);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float angle = (360) * getProgress() / getMax();
        canvas.drawArc(mCircleRect, mStartAngle,
                360, false, mSecondaryCirclePaint);

        canvas.drawArc(mCircleRect, mStartAngle,
                angle, false, mCirclePaint);


        String text = getDrawText();
        if (!TextUtils.isEmpty(text)) {
            float textHeight = mProgressPaint.descent() + mProgressPaint.ascent();
            canvas.drawText(text, (getWidth() - mProgressPaint.measureText(text)) / 2.0f,
                    (getWidth() - textHeight) / 2.0f, mProgressPaint);
        }

//        canvas.drawCircle((mCircleRect.right - mCircleRect.left) / 2, (mCircleRect.bottom - mCircleRect.top) / 2,
//                (mCircleRect.right - mCircleRect.left) / 2, mSecondaryCirclePaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        final int height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        final int width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        final int min = Math.min(width, height);
        setMeasuredDimension(min, min);

        updateRectAngleBounds();
    }

    /**
     * Set two rectangle bounds for drawing two circles.
     */
    private void updateRectAngleBounds() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();

        mCircleRect.set(paddingLeft + mProgressBarThickness, paddingTop + mProgressBarThickness,
                mSize - paddingLeft - mProgressBarThickness,
                mSize - paddingTop - mProgressBarThickness);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mSize = (w < h) ? w : h;
        updateRectAngleBounds();
    }

    public String getDrawText() {
        return getPreText() + " " + getProgress() + " " + getPostText();
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        if (this.progress > getMax()) {
            this.progress = getMax();
        }
        invalidate();
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        if (max > 0) {
            this.max = max;
            invalidate();
        }
    }

    public String getPreText() {
        return preText;
    }

    public void setPreText(String preText) {
        if (preText != null) {
            this.preText = preText;
            invalidate();
        }

    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        if (postText != null) {
            this.postText = postText;
            invalidate();
        }
    }


    public int getmTextPaintColor() {
        return mTextPaintColor;
    }

    public void setmTextPaintColor(int mTextPaintColor) {
        this.mTextPaintColor = mTextPaintColor;
        invalidate();
    }
}

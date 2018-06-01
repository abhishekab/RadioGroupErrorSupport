package com.ab.radiogroupes;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.RadioGroup;

public class RadioGroupErrorSupport extends RadioGroup {
    private String errorText;
    private float errorTextSize = 12;
    private int errorTextColor =  Color.RED;
    private TextPaint errorPaint;
    private StaticLayout mStaticLayoutErrorText;
    public RadioGroupErrorSupport(Context context) {
        this(context, null);
    }

    public RadioGroupErrorSupport(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        errorPaint = getPaint();

    }

    private TextPaint getPaint(){
        TextPaint paint = new TextPaint();
        paint.setTextSize(errorTextSize * getResources().getDisplayMetrics().density);
        paint.setColor(errorTextColor);
        return paint;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setError(String errorText) {
        this.errorText = errorText;
        requestLayout();
    }

    public float getErrorTextSize() {
        return errorTextSize;
    }

    public void setErrorTextSize(float errorTextSize) {
        this.errorTextSize = errorTextSize;
        errorPaint = getPaint();
        requestLayout();
    }

    public int getErrorTextColor() {
        return errorTextColor;

    }

    public void setErrorTextColor(int errorTextColor) {
        this.errorTextColor = errorTextColor;
        errorPaint = getPaint();
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Let RadioGroup call onMeasure
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(errorText != null && !errorText.isEmpty()){
            mStaticLayoutErrorText = new StaticLayout(errorText, errorPaint,
                    getMeasuredWidth() - getPaddingRight() - getPaddingLeft(), Layout.Alignment.ALIGN_NORMAL, 1,1, true  );
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + mStaticLayoutErrorText.getHeight());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(errorText != null && !errorText.isEmpty()){
            canvas.save();
            canvas.translate(getPaddingLeft(), getMeasuredHeight() - mStaticLayoutErrorText.getHeight() - getPaddingBottom());
            mStaticLayoutErrorText.draw(canvas);
            canvas.restore();
        }
    }
}

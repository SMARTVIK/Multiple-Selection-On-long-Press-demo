package com.timehop.stickyheadersrecyclerview.sample;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class CustomTypefaceSpan extends MetricAffectingSpan {
    private final Typeface typeface;

    public CustomTypefaceSpan(final Typeface typeface) {
        this.typeface = typeface;
    }

    @Override
    public void updateDrawState(final TextPaint drawState) {
        apply(drawState);
    }

    @Override
    public void updateMeasureState(final TextPaint paint) {
        apply(paint);
    }

    private void apply(final Paint paint) {
        final Typeface oldTypeface = paint.getTypeface();
        final int oldStyle = oldTypeface != null ? oldTypeface.getStyle() : 0;
        int fakeStyle = 0;
        if (typeface != null) {

            fakeStyle = oldStyle & ~typeface.getStyle(); //crash is occuring here
        }

        if ((fakeStyle & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }

        if ((fakeStyle & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }

        paint.setTypeface(typeface);
    }
}
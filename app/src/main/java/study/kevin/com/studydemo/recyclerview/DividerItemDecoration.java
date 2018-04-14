package study.kevin.com.studydemo.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by kevin on 2018/4/14.
 *  自定义RecyclerView的分割线
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private Drawable mDivider;
    private int mOrientation;

    public DividerItemDecoration(Context context, int orientation) {
        TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }

    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invaild orientation");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOrientation == HORIZONTAL_LIST) {
            drawHorizontalDeviderLine(c, parent);
        } else if (mOrientation == VERTICAL_LIST) {
            drawVerticalDeviderLine(c, parent);
        }
    }

    private void drawHorizontalDeviderLine(Canvas c, RecyclerView parent) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight()- parent.getPaddingBottom();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) parent.getLayoutParams();
            int left = child.getRight() + params.rightMargin;
            int right = left + mDivider.getIntrinsicWidth();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }

    }

    private void drawVerticalDeviderLine(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth()-parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) parent.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }


    /**
     * 设置item的padding属性
     *
     * @param outRect
     * @param itemPosition
     * @param parent
     */
    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        super.getItemOffsets(outRect, itemPosition, parent);
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
}

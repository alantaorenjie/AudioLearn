package com.trj.audio.audiolearn.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.trj.audio.audiolearn.R;

/**
 * @author TRJ
 * @date 2018/11/9
 * Description:
 */
public class ImageSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private SurfaceHolder mHolder;
    private Canvas mCanvas;
    private int mBitmapResourceIds = R.drawable.withdraw_toturial_1;
    private Bitmap mBitmap;

    public ImageSurfaceView(Context context) {
        this(context, null);
    }

    public ImageSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mHolder = getHolder();
        mHolder.addCallback(this);

        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);//保持屏幕常亮
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mHolder = holder;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    /**
     * 制图方法
     */
    private void drawImage() {
        // 锁定画布
        mCanvas = mHolder.lockCanvas();

        mCanvas.drawColor(Color.WHITE);

        mBitmap = BitmapFactory.decodeResource(getResources(), mBitmapResourceIds);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        Rect mSrcRect, mDestRect;
        mSrcRect = new Rect(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
        mDestRect = new Rect(0, 0, getWidth(), getHeight());
        mCanvas.drawBitmap(mBitmap, mSrcRect, mDestRect, paint);
        // 解锁 Canvas，并渲染当前的图像
        mHolder.unlockCanvasAndPost(mCanvas);
        if (mBitmap != null) {
            // 收回图片
            mBitmap.recycle();
        }
    }

    @Override
    public void run() {
        drawImage();
    }
}

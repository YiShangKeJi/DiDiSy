package com.ys.didisy.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.view.View;
import android.view.View.MeasureSpec;

import java.io.IOException;

public class BitmapUtil {

	/** view转Bitmap **/
	public static Bitmap convertViewToBitmap(View view, int bitmapWidth,
			int bitmapHeight) {
		Bitmap bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight,
				Config.ARGB_8888);
		view.draw(new Canvas(bitmap));
		return bitmap;
	}

	// 将控件转换为bitmap
	public static Bitmap convertViewToBitMap(View view) {
		// 打开图像缓存
		view.setDrawingCacheEnabled(true);
		// 必须调用measure和layout方法才能成功保存可视组件的截图到png图像文件
		// 测量View大小
		view.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
				MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
		// 发送位置和尺寸到View及其所有的子View
		view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
		// 获得可视组件的截图
		Bitmap bitmap = view.getDrawingCache();
		return bitmap;
	}

	public static Bitmap getBitmapFromView(View view) {
		Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(),
				view.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(returnedBitmap);
		Drawable bgDrawable = view.getBackground();
		if (bgDrawable != null)
			bgDrawable.draw(canvas);
		else
			canvas.drawColor(Color.WHITE);
		view.draw(canvas);
		return returnedBitmap;
	}

	// 获取屏幕截图的bitmap对象的代码如下
	public Bitmap getScreenPic(View view) {
		View rootView = view.getRootView();
		rootView.setDrawingCacheEnabled(true);
		rootView.buildDrawingCache();
		// 不明白为什么这里返回一个空，有帖子说不能在oncreat方法中调用
		// 测量View大小
		rootView.measure(
				MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
				MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
		// 发送位置和尺寸到View及其所有的子View
		rootView.layout(0, 0, rootView.getMeasuredWidth(),
				rootView.getMeasuredHeight());
		// 解决措施，调用上面的measure和layout方法之后，返回值就不再为空
		// 如果想要创建的是固定长度和宽度的呢？
		Bitmap bitmap = rootView.getDrawingCache();
		rootView.destroyDrawingCache();
		return bitmap;

	}

	/** Drawable → Bitmap **/
	public static Bitmap drawableToBitmap(Drawable drawable) {
		Bitmap bitmap = Bitmap
				.createBitmap(
						drawable.getIntrinsicWidth(),
						drawable.getIntrinsicHeight(),
						drawable.getOpacity() != PixelFormat.OPAQUE ? Config.ARGB_8888
								: Config.RGB_565);
		Canvas canvas = new Canvas(bitmap);
		// canvas.setBitmap(bitmap);
		drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
				drawable.getIntrinsicHeight());
		drawable.draw(canvas);
		return bitmap;

	}

	// 获取图片缩略图
	public static Bitmap getScaleBitmap(Activity context, String path) {
		Bitmap tempBitmap = BitmapFactory.decodeFile(path);
		// 获取图片旋转角度
		int degree = readPictureDegree(path);
		// 如果不等于0,则说明图片发生旋转
		if (degree != 0) {
			// 将图片以同样度数反向旋转
			tempBitmap = rotaingImageView(degree, tempBitmap);
		}

		// 返回图片缩略图
		int width = (context.getWindowManager().getDefaultDisplay().getWidth() - 40) / 3;
		return ThumbnailUtils.extractThumbnail(tempBitmap, width, width);
	}

	/**
	 * 获取图片旋转的角度
	 */
	public static int readPictureDegree(String path) {
		int degree = 0;
		try {
			ExifInterface exifInterface = new ExifInterface(path);
			int orientation = exifInterface.getAttributeInt(
					ExifInterface.TAG_ORIENTATION,
					ExifInterface.ORIENTATION_NORMAL);
			switch (orientation) {
			case ExifInterface.ORIENTATION_ROTATE_90:
				degree = 90;
				break;
			case ExifInterface.ORIENTATION_ROTATE_180:
				degree = 180;
				break;
			case ExifInterface.ORIENTATION_ROTATE_270:
				degree = 270;
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return degree;
	}

	/**
	 * 旋转图片
	 */
	public static Bitmap rotaingImageView(int angle, Bitmap bitmap) {
		// 旋转图片 动作
		Matrix matrix = new Matrix();
		matrix.postRotate(angle);
		System.out.println("angle2=" + angle);
		// 创建新的图片
		Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
				bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		bitmap.recycle();
		return resizedBitmap;
	}

	/**
	 * 转换图片成圆形
	 * 
	 * @param bitmap
	 *            传入Bitmap对象
	 * @param 
	 * @return
	 */
	public static Bitmap toRoundBitmap(Bitmap bitmapRoot, Bitmap bitmap) {
		int rootWidth = bitmapRoot.getWidth();
		int rootHeight = bitmapRoot.getHeight();

		int width = bitmap.getWidth();
		int height = bitmap.getHeight();

		float roundPx, roundPy, radius;
		float rootLeft, rootTop, rootRight, rootBottm, rootDstLeft, rootDstTop, rootDstRight, rootDstBottom;
		float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
		// if (rootWidth <= rootHeight) {
		rootLeft = 0;
		rootRight = rootWidth;
		rootTop = 0;
		rootBottm = rootHeight;
		roundPx = rootWidth / 2;
		roundPy = rootHeight * 108 / 278;
		radius = rootWidth / 2 - rootWidth / 11;
		left = rootWidth / 11;
		top = rootWidth / 11;
		right = rootWidth - rootWidth / 11;
		bottom = roundPy + radius;

		// } else {
		// roundPx = rootHeight / 2;
		// roundPy = rootWidth * 108 / 278;
		// radius = rootHeight / 2 - rootHeight / 11;
		// float clip = (width - height) / 2;
		// left = clip;
		// right = width - clip;
		// top = 0;
		// bottom = height;
		// width = height;
		// dst_left = 0;
		// dst_top = 0;
		// dst_right = height;
		// dst_bottom = height;
		// }

		Bitmap output = Bitmap.createBitmap(rootWidth, rootHeight,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect src = new Rect((int) rootLeft, (int) rootTop, (int) rootRight,
				(int) rootBottm);
		final Rect dst = new Rect((int) left, (int) top,
				(int) right, (int) bottom);
		paint.setAntiAlias(true);// 设置画笔无锯齿
		canvas.drawARGB(0, 0, 0, 0); // 填充整个Canvas
		paint.setColor(color);
		// 以下有两种方法画圆,drawRounRect和drawCircle
		// canvas.drawRoundRect(rectF, roundPx, roundPx, paint);//
		// 画圆角矩形，第一个参数为图形显示区域，第二个参数和第三个参数分别是水平圆角半径和垂直圆角半径。
		canvas.drawCircle(roundPx, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));// 设置两张图片相交时的模式,参考http://trylovecatch.iteye.com/blog/1189452
		canvas.drawBitmap(bitmap, dst, dst, paint); // 以Mode.SRC_IN模式合并bitmap和已经draw了的Circle
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
		canvas.drawBitmap(bitmapRoot, src, src, paint);
		return output;
	}
	
	/**
	 * 转换图片成圆形
	 * 
	 * @param bitmap
	 *            传入Bitmap对象
	 * @param
	 * @return
	 */
	public static Bitmap toRoundBitmap2(Bitmap bitmapRoot, Bitmap bitmap) {
		int rootWidth = bitmapRoot.getWidth();
		int rootHeight = bitmapRoot.getHeight();

		int width = bitmap.getWidth();
		int height = bitmap.getHeight();

		float roundPx, roundPy, radius;
		float rootLeft, rootTop, rootRight, rootBottm, rootDstLeft, rootDstTop, rootDstRight, rootDstBottom;
		float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
		// if (rootWidth <= rootHeight) {
		rootLeft = 0;
		rootRight = rootWidth;
		rootTop = 0;
		rootBottm = rootHeight;
		roundPx = rootWidth / 2;
		roundPy = rootHeight * 108 / 278;
		radius = rootWidth / 2 - rootWidth / 11;
		left = rootWidth / 11;
		top = rootWidth / 11;
		right = rootWidth - rootWidth / 11;
		bottom = roundPy + radius;

		// } else {
		// roundPx = rootHeight / 2;
		// roundPy = rootWidth * 108 / 278;
		// radius = rootHeight / 2 - rootHeight / 11;
		// float clip = (width - height) / 2;
		// left = clip;
		// right = width - clip;
		// top = 0;
		// bottom = height;
		// width = height;
		// dst_left = 0;
		// dst_top = 0;
		// dst_right = height;
		// dst_bottom = height;
		// }

		Bitmap output = Bitmap.createBitmap(rootWidth, rootHeight,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect src = new Rect((int) rootLeft, (int) rootTop, (int) rootRight,
				(int) rootBottm);
		final Rect dst = new Rect((int) left, (int) top,
				(int) right, (int) bottom);
		final Rect dst2 = new Rect(0, 0,
				bitmap.getWidth(), bitmap.getHeight());
		paint.setAntiAlias(true);// 设置画笔无锯齿
		canvas.drawARGB(0, 0, 0, 0); // 填充整个Canvas
		paint.setColor(color);
		// 以下有两种方法画圆,drawRounRect和drawCircle
		// canvas.drawRoundRect(rectF, roundPx, roundPx, paint);//
		// 画圆角矩形，第一个参数为图形显示区域，第二个参数和第三个参数分别是水平圆角半径和垂直圆角半径。
		canvas.drawCircle(roundPx, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));// 设置两张图片相交时的模式,参考http://trylovecatch.iteye.com/blog/1189452
		canvas.drawBitmap(bitmap, dst2, dst, paint); // 以Mode.SRC_IN模式合并bitmap和已经draw了的Circle
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
		canvas.drawBitmap(bitmapRoot, src, src, paint);
		return output;
	}


}

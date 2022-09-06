package com.j2k.designkeyboard.keyboardview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import com.j2k.designkeyboard.R
import java.util.ArrayList

@SuppressLint("CustomViewStyleable")
class KeyboardView(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    // keyboard properties
//    private val mBackgroundColor

    // key properties
    private val mKeyTextSize: Int
    private val mKeyTextColor: Int
    private val mKeyBackground: Drawable

    init {
        context.obtainStyledAttributes(attrs, R.styleable.mKeyboardView).apply {

            mKeyTextSize = getDimensionPixelSize(R.styleable.mKeyboardView_keyTextSize, 18)
            mKeyTextColor = getColor(R.styleable.mKeyboardView_keyTextColor, 0)
            mKeyBackground = getDrawable(R.styleable.mKeyboardView_KeyBackground)!!

            recycle()
        }
    }

    private val viewPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {  }
    private val keyPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {  }
    private val keyTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = mKeyTextColor
        textSize = mKeyTextSize.toFloat()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.apply {
            TODO("implement drawing keyboard")
        }
    }
}

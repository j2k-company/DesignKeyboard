package com.j2k.designkeyboard

import android.annotation.SuppressLint
import android.inputmethodservice.InputMethodService
import android.text.TextUtils
import android.view.View
import com.hijamoya.keyboardview.Keyboard
import com.hijamoya.keyboardview.KeyboardView

class MyInputMethodService : InputMethodService(), KeyboardView.OnKeyboardActionListener {
    @SuppressLint("InflateParams")
    override fun onCreateInputView(): View {
        return layoutInflater.inflate(R.layout.keyboard_view, null).apply {
            if(this is KeyboardView) {
                setOnKeyboardActionListener(this@MyInputMethodService)
                keyboard = Keyboard(this@MyInputMethodService, R.xml.cyrillic_kb)
            }
        }
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        val ic = currentInputConnection ?: return
        when (primaryCode) {
            Keyboard.KEYCODE_DELETE -> {
                val selectedText = ic.getSelectedText(0)
                if (TextUtils.isEmpty(selectedText)) {
                    ic.deleteSurroundingText(1, 0)
                } else {
                    ic.commitText("", 1)
                }
            }
            else -> {
                ic.commitText(primaryCode.toChar().toString(), 1)
            }
        }
    }

    override fun onPress(p0: Int) { }

    override fun onRelease(p0: Int) { }

    override fun onText(p0: CharSequence?) { }

    override fun swipeLeft() { }

    override fun swipeRight() { }

    override fun swipeDown() { }

    override fun swipeUp() { }
}
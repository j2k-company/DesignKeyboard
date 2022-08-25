package com.j2k.designkeyboard

import android.annotation.SuppressLint
import android.inputmethodservice.InputMethodService
import android.text.TextUtils
import android.view.View
import com.hijamoya.keyboardview.Keyboard
import com.hijamoya.keyboardview.KeyboardView

class MyInputMethodService : InputMethodService(), KeyboardView.OnKeyboardActionListener {
    lateinit var keyboardView: KeyboardView
    lateinit var keyboard: Keyboard
    var isUpperCase = false

    @SuppressLint("InflateParams")
    override fun onCreateInputView(): View {
        keyboard = Keyboard(this, R.xml.cyrillic_kb)
        keyboardView = layoutInflater.inflate(R.layout.keyboard_view, null) as KeyboardView

        return keyboardView.apply {
            keyboard = this@MyInputMethodService.keyboard
            setOnKeyboardActionListener(this@MyInputMethodService)
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
            Keyboard.KEYCODE_SHIFT -> {
                isUpperCase = !isUpperCase
                keyboard.isShifted = isUpperCase
                keyboardView.invalidateAllKeys()
            }
            else -> {
                var symbol = primaryCode.toChar()
                if(isUpperCase) symbol = symbol.uppercaseChar()

                ic.commitText(symbol.toString(), 1)
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
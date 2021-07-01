/*
 * Copyright (c) 2009-2021 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jme3.swt.inputs;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;

import com.jme3.input.KeyInput;

/**
 * Mapping from SWT key code to JME3 key code
 * 
 * @author Arthur Daussy
 */
public final class SWTKeyMap {

	public static final int INVALID_CODE = -1;

	private static final Map<Integer, Integer> SWT_TO_JME_KEY_MAP = new HashMap<>();

	static {
		reg(SWT.ALT, KeyInput.KEY_LMENU);
		reg(SWT.SHIFT, KeyInput.KEY_LSHIFT);
		reg(SWT.CONTROL, KeyInput.KEY_LCONTROL);

		/* Non-Numeric Keypad Keys */
		reg(SWT.ARROW_UP, KeyInput.KEY_UP);
		reg(SWT.ARROW_DOWN, KeyInput.KEY_DOWN);
		reg(SWT.ARROW_LEFT, KeyInput.KEY_LEFT);
		reg(SWT.ARROW_RIGHT, KeyInput.KEY_RIGHT);
		reg(SWT.PAGE_UP, KeyInput.KEY_PRIOR);
		reg(SWT.PAGE_DOWN, KeyInput.KEY_NEXT);
		reg(SWT.HOME, KeyInput.KEY_HOME);
		reg(SWT.END, KeyInput.KEY_END);
		reg(SWT.INSERT, KeyInput.KEY_INSERT);

		/* Virtual and Ascii Keys */
		reg(SWT.BS, KeyEvent.VK_BACK_SLASH);
		reg(SWT.CR, KeyInput.KEY_RETURN);
		reg(SWT.DEL, KeyInput.KEY_DELETE);
		reg(SWT.ESC, KeyInput.KEY_ESCAPE);

		// "LF");
		reg(SWT.TAB, KeyInput.KEY_TAB);

		/* Functions Keys */
		reg(SWT.F1, KeyInput.KEY_F1);
		reg(SWT.F2, KeyInput.KEY_F2);
		reg(SWT.F3, KeyInput.KEY_F3);
		reg(SWT.F4, KeyInput.KEY_F4);
		reg(SWT.F5, KeyInput.KEY_F5);
		reg(SWT.F6, KeyInput.KEY_F6);
		reg(SWT.F7, KeyInput.KEY_F7);
		reg(SWT.F8, KeyInput.KEY_F8);
		reg(SWT.F9, KeyInput.KEY_F9);
		reg(SWT.F10, KeyInput.KEY_F10);
		reg(SWT.F11, KeyInput.KEY_F11);
		reg(SWT.F12, KeyInput.KEY_F12);
		reg(SWT.F13, KeyInput.KEY_F13);
		reg(SWT.F14, KeyInput.KEY_F14);
		reg(SWT.F15, KeyInput.KEY_F15);

		/* Numeric Keypad Keys */
		reg(SWT.KEYPAD_ADD, KeyInput.KEY_NUMPADENTER); // ?
		reg(SWT.KEYPAD_SUBTRACT, KeyInput.KEY_ADD);
		reg(SWT.KEYPAD_MULTIPLY, KeyInput.KEY_MULTIPLY);
		reg(SWT.KEYPAD_DIVIDE, KeyInput.KEY_DIVIDE);
		reg(SWT.KEYPAD_DECIMAL, KeyInput.KEY_NUMPADCOMMA);
		reg(SWT.KEYPAD_CR, KeyInput.KEY_NUMPADENTER);
		reg(SWT.KEYPAD_0, KeyInput.KEY_NUMPAD0);
		reg(SWT.KEYPAD_1, KeyInput.KEY_NUMPAD1);
		reg(SWT.KEYPAD_2, KeyInput.KEY_NUMPAD2);
		reg(SWT.KEYPAD_3, KeyInput.KEY_NUMPAD3);
		reg(SWT.KEYPAD_4, KeyInput.KEY_NUMPAD4);
		reg(SWT.KEYPAD_5, KeyInput.KEY_NUMPAD5);
		reg(SWT.KEYPAD_6, KeyInput.KEY_NUMPAD6);
		reg(SWT.KEYPAD_7, KeyInput.KEY_NUMPAD7);
		reg(SWT.KEYPAD_8, KeyInput.KEY_NUMPAD8);
		reg(SWT.KEYPAD_9, KeyInput.KEY_NUMPAD9);
		reg(SWT.KEYPAD_EQUAL, KeyInput.KEY_NUMPADEQUALS);

		/* Other keys */
		reg(SWT.CAPS_LOCK, KeyInput.KEY_CAPITAL);
		reg(SWT.NUM_LOCK, KeyInput.KEY_NUMLOCK);
		reg(SWT.SCROLL_LOCK, KeyInput.KEY_SCROLL);
		reg(SWT.PAUSE, KeyInput.KEY_PAUSE);
		reg(SWT.BREAK, KeyInput.KEY_PAUSE); // Not sure
		reg(SWT.PRINT_SCREEN, KeyInput.KEY_PRTSCR);

		reg('a', KeyInput.KEY_A);
		reg('b', KeyInput.KEY_B);
		reg('c', KeyInput.KEY_C);
		reg('d', KeyInput.KEY_D);
		reg('e', KeyInput.KEY_E);
		reg('f', KeyInput.KEY_F);
		reg('g', KeyInput.KEY_G);
		reg('h', KeyInput.KEY_H);
		reg('i', KeyInput.KEY_I);
		reg('j', KeyInput.KEY_J);
		reg('k', KeyInput.KEY_K);
		reg('l', KeyInput.KEY_L);
		reg('m', KeyInput.KEY_M);
		reg('n', KeyInput.KEY_N);
		reg('o', KeyInput.KEY_O);
		reg('p', KeyInput.KEY_P);
		reg('q', KeyInput.KEY_Q);
		reg('r', KeyInput.KEY_R);
		reg('s', KeyInput.KEY_S);
		reg('t', KeyInput.KEY_T);
		reg('u', KeyInput.KEY_U);
		reg('v', KeyInput.KEY_V);
		reg('w', KeyInput.KEY_W);
		reg('x', KeyInput.KEY_X);
		reg('y', KeyInput.KEY_Y);

	}

	private static void reg(final int swtKey, final int jmeKey) {
		SWT_TO_JME_KEY_MAP.put(swtKey, jmeKey);
	}

	public static int toJME3(int keyCode) {
		Integer match = SWT_TO_JME_KEY_MAP.get(Integer.valueOf(keyCode));

		if (match == null) {
			return INVALID_CODE;
		} else {
			return match.intValue();
		}
	}

}

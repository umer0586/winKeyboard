
#define WINVER 0x0500
#include <windows.h>
#include "winkeyboard_Keyboard.h"

JNIEXPORT void JNICALL Java_winkeyboard_Keyboard_KeyPress(JNIEnv *jniEnv, jobject jobj, jint code)
{
    INPUT input;
	input.type = INPUT_KEYBOARD;
	input.ki.time = 0;
	input.ki.dwExtraInfo = 0;
	input.ki.wScan = code ;
	input.ki.dwFlags = KEYEVENTF_SCANCODE; // 0 for key press

	SendInput(1, &input, sizeof(INPUT));

}
JNIEXPORT void JNICALL Java_winkeyboard_Keyboard_KeyRelease(JNIEnv *jniEnv, jobject jobj, jint code)
{
    
	INPUT input;
	input.type = INPUT_KEYBOARD;
	input.ki.time = 0;
	input.ki.dwExtraInfo = 0;
        input.ki.wScan = code ;

	input.ki.dwFlags = KEYEVENTF_KEYUP | KEYEVENTF_SCANCODE;
	SendInput(1, &input, sizeof(INPUT));

}

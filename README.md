# winKeyboard
A tiny Java helper for Windows for emulating keyboard via scan codes.

In java application if you send keystrokes to the game using <strong>java.awt.Robot</strong>, then games which uses DirectInput API for reading the keyboard input (scancodes) may have no effect.

Here is a simple java helper for Windows which allow java applications to send keystrokes to the game/application by generating keyboard scan code

<pre>
Keyboard keyboard = new Keyboard();
keyboard.winKeyPress(ScanCode.DIK_UP);
//Thread.sleep(1000);
keyboard.winKeyRelease(ScanCode.DIK_UP);
</pre>

To send combination (e.g LEFT_SHIFT+A )
<pre>
 kb.winPressCombination(ScanCode.DIK_LSHIFT,ScanCode.DIK_A);
 kb.winReleaseCombination(ScanCode.DIK_LSHIFT,ScanCode.DIK_A);
</pre>

LEFT_CTRL+LEFT_SHIFT+A
<pre>
 kb.winPressCombination(ScanCode.DIK_LCONTROL,ScanCode.DIK_LSHIFT,ScanCode.DIK_A);
 kb.winReleaseCombination(ScanCode.DIK_LCONTROL,ScanCode.DIK_LSHIFT,ScanCode.DIK_A);
</pre>


Download : <a href="https://drive.google.com/open?id=1AAR0YtvxChKn-7qirngXRfwt9yRwgoUt">keyboard.jar</a>

<div>
<h4>Important</h4>
make sure you place SCGen32.dll and SCGen64.dll in java library path other wise java.lang.UnsatisfiedLinkError will be thrown
</div>

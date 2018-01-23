# winKeyboad
A tiny Java native library for Windows for emulating keyboard via scan codes.

In java application if you send keystrokes to the game using <strong>java.awt.Robot</strong>, then games which uses DirectInput API for reading the keyboard input may have no effect.

Here is a simple java helper for Windows which allow java applications to send keystrokes to the game (or any application having focus) by generating keyboard scan code

<pre>
Keyboard keyboard = new Keyboard();
keyboard.winKeyPress(ScanCode.DIK_UP);
//Thread.sleep(1000);
keyboard.winKeyRelease(ScanCode.DIK_UP);
</pre>

Download : <a href="https://drive.google.com/open?id=1VWFFR-aqLgJzIdrGsAKr6uVim0bM6rZv">winkeyboard_1.0.0.jar</a>

<div>
<h4>Important</h4>
make sure you place SCGen32.dll and SCGen64.dll in java library path other wise java.lang.UnsatisfiedLinkError will be thrown
</div>

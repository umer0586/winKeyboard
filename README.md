# winKeyboard (JNI)
A tiny Java helper for Windows for emulating keyboard via scan codes.

In java application if you send keystrokes to the game using <strong>java.awt.Robot</strong>, then games which uses DirectInput API for reading the keyboard input (scancodes) may have no effect.

Here is a simple java helper for Windows which allow java applications to send keystrokes to the game/application by generating keyboard scan code

```java
Keyboard keyboard = new Keyboard();
keyboard.winKeyPress(ScanCode.DIK_UP);
//Thread.sleep(1000);
keyboard.winKeyRelease(ScanCode.DIK_UP);
```

To send combination (e.g LEFT_SHIFT+A )
```java
 kb.winPressCombination(ScanCode.DIK_LSHIFT,ScanCode.DIK_A);
 kb.winReleaseCombination(ScanCode.DIK_LSHIFT,ScanCode.DIK_A);
 ```

LEFT_CTRL+LEFT_SHIFT+A
```java
 kb.winPressCombination(ScanCode.DIK_LCONTROL,ScanCode.DIK_LSHIFT,ScanCode.DIK_A);
 kb.winReleaseCombination(ScanCode.DIK_LCONTROL,ScanCode.DIK_LSHIFT,ScanCode.DIK_A);
```



<div>
<h4>Important</h4>
make sure you place SCGen32.dll and SCGen64.dll in java library path other wise java.lang.UnsatisfiedLinkError will be thrown
</div>

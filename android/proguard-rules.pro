# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFile and proguardFiles directives.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging enable it when using an obfuscator.
#-keepattributes SourceFile,LineNumberTable

# For native libraries:
-keepclasseswithmembername class * {
    native <methods>;
}

# For gson:
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.gson.** { *; }
-keep class com.google.gson.reflect.TypeToken.** { *; }
-keep class com.google.gson.stream.** { *; }

# For LibGDX:
-dontwarn com.badlogic.gdx.backends.android.**
-dontwarn com.badlogic.gdx.utils.**
-dontwarn com.badlogic.gdx.physics.box2d.**
-dontwarn com.badlogic.gdx.scenes.scene2d.ui.**
-dontwarn com.badlogic.gdx.graphics.g3d.**
-dontwarn com.badlogic.gdx.graphics.profiling.**

# For metal slug game:
-keep class com.metal.slug.** { *; }
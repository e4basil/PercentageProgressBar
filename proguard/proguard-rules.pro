# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
-dump class_files.txt
-printseeds seeds.txt
-printusage unused.txt
-printmapping mapping.txt
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-allowaccessmodification
-keepattributes *Annotation*
#-renamesourcefileattribute SourceFile
# this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable
-keepattributes LocalVariableTable, LocalVariableTypeTable


# remove all logcat
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
}

# keep All Class
-keep public class * extends android.app.Activity
-keep public class * extends android.app.AppCompatActivity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgent
-keep public class * extends android.preference.Preference
-keep public class * extends android.support.v4.app.Fragment
-keep public class * extends android.support.v4.app.DialogFragment
#-keep public class * extends com.actionbarsherlock.app.SherlockListFragment
#-keep public class * extends com.actionbarsherlock.app.SherlockFragment
#-keep public class * extends com.actionbarsherlock.app.SherlockFragmentActivity
-keep public class * extends android.app.Fragment
-keep public class com.android.vending.licensing.ILicensingService

# custom view
-keep public class * extends android.view.View {
 public <init>(android.content.Context);
 public <init>(android.content.Context, android.util.AttributeSet);
 public <init>(android.content.Context, android.util.AttributeSet, int);
 public void set*(...);
 public void get*(...);
}

# sqlite
-keep class org.sqlite.** { *; }
-keep class org.sqlite.database.** { *; }


# support design
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }

# support v4
-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep public class * extends android.support.v4.view.ActionProvider {
    public <init>(android.content.Context);
}

# support v7
-keep public class android.support.v7.widget.** { *; }
-keep public class android.support.v7.internal.widget.** { *; }
-keep public class android.support.v7.internal.view.menu.** { *; }

-keep class android.support.v7.widget.RoundRectDrawable { *; }

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:

-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}

-dontwarn com.android.org.conscrypt.SSLParametersImpl
-dontwarn dalvik.system.CloseGuard
-dontwarn kotlin.internal.**
-dontwarn kotlin.reflect.jvm.internal.ReflectionFactoryImpl
-dontwarn org.apache.harmony.xnet.provdier.jsse.SSLParametersImpl
-dontwarn org.conscrypt.**
-dontwarn sun.misc.Unsafe
-dontwarn sun.security.ssl.SSLContext.Impl

# enable at last stage only
# Get rid of package names, makes file smaller
-repackageclasses

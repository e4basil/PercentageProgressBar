################### progaurd-crashlytics ##################################

#-keepattributes *Annotation*
#
#-keepattributes SourceFile,LineNumberTable
#
#-keep public class * extends java.lang.Exception
#
#-keepresourcexmlelements manifest/application/meta-data@name=io.fabric.ApiKey
#
#-printmapping mapping.txt

-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**

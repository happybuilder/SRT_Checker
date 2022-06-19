@if "%1"=="" goto show_demo
"C:\Program Files\Java\jdk-11.0.15\bin\java.exe" -classpath out\production\SRT_Checker -Dfile.encoding=UTF8 SRT_Checker %1 %2 %3
@goto end1
:show_demo
@echo Example: java "c:\video\hello.srt"
:end
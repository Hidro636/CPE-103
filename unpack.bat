@echo off
for /R %f in (.\*.pack) do @"%cd%\bin\unpack200" -r -v -l "" "%f" "%~pf%~nf.jar"
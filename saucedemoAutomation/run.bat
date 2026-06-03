@echo off

echo Running SauceDemo Automation Tests...
echo.

cd /d "%~dp0"

mvnw.cmd clean test

echo.
echo Execution Finished
pause
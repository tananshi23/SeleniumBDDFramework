@echo off
REM DatePicker Automation Framework - Test Execution Commands
REM Navigate to project directory and run tests

cd /d "C:\Users\ADMIN\OneDrive\Desktop\Test Framework\Automation Framework Allure\SeleniumBDDFramework"

REM Menu for test execution options
:menu
cls
echo ============================================================
echo     DatePicker Automation Framework - Test Execution
echo ============================================================
echo.
echo 1. Run All DatePicker Tests (@smoke tag)
echo 2. Run Regression Tests (@Regression tag)
echo 3. Run All Tests (No tag filter)
echo 4. Clean and Compile Project
echo 5. Generate Allure Report
echo 6. Run with Detailed Logging
echo 7. Exit
echo.
echo ============================================================
set /p choice="Select option (1-7): "

if "%choice%"=="1" goto run_smoke
if "%choice%"=="2" goto run_regression
if "%choice%"=="3" goto run_all
if "%choice%"=="4" goto clean_compile
if "%choice%"=="5" goto allure_report
if "%choice%"=="6" goto detailed_logging
if "%choice%"=="7" goto exit_menu

echo Invalid choice. Please try again.
pause
goto menu

:run_smoke
echo.
echo Running All DatePicker Tests with @smoke tag...
echo.
mvn test -Dcucumber.filter.tags="@smoke"
pause
goto menu

:run_regression
echo.
echo Running Regression Tests with @Regression tag...
echo.
mvn test -Dcucumber.filter.tags="@Regression"
pause
goto menu

:run_all
echo.
echo Running All Tests...
echo.
mvn test
pause
goto menu

:clean_compile
echo.
echo Cleaning and Compiling Project...
echo.
mvn clean install -DskipTests
pause
goto menu

:allure_report
echo.
echo Generating Allure Report...
echo.
mvn allure:serve
pause
goto menu

:detailed_logging
echo.
echo Running Tests with Detailed Logging...
echo.
mvn test -X -Dcucumber.filter.tags="@smoke"
pause
goto menu

:exit_menu
echo.
echo Exiting...
echo.
exit /b


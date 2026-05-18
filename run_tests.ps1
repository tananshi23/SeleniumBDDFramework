# DatePicker Automation Framework - Test Execution Script (PowerShell)
# Run this script: .\run_tests.ps1

param(
    [ValidateSet("smoke", "regression", "all", "compile", "report")]
    [string]$TestType = "smoke",
    [bool]$ShowMenu = $true
)

$ProjectRoot = "C:\Users\ADMIN\OneDrive\Desktop\Test Framework\Automation Framework Allure\SeleniumBDDFramework"

# Function to display menu
function Show-Menu {
    Clear-Host
    Write-Host "============================================================" -ForegroundColor Cyan
    Write-Host "     DatePicker Automation Framework - Test Execution" -ForegroundColor Yellow
    Write-Host "============================================================" -ForegroundColor Cyan
    Write-Host ""
    Write-Host "1. Run All DatePicker Tests (@smoke tag)" -ForegroundColor Green
    Write-Host "2. Run Regression Tests (@Regression tag)" -ForegroundColor Green
    Write-Host "3. Run All Tests (No tag filter)" -ForegroundColor Green
    Write-Host "4. Clean and Compile Project" -ForegroundColor Green
    Write-Host "5. Generate Allure Report" -ForegroundColor Green
    Write-Host "6. Run with Detailed Logging" -ForegroundColor Green
    Write-Host "7. Exit" -ForegroundColor Red
    Write-Host ""
    Write-Host "============================================================" -ForegroundColor Cyan
}

# Function to change to project directory
function Set-ProjectDirectory {
    Set-Location $ProjectRoot
    Write-Host "✓ Changed to project directory: $ProjectRoot" -ForegroundColor Green
}

# Function to run smoke tests
function Run-SmokeTests {
    Write-Host ""
    Write-Host "Running All DatePicker Tests with @smoke tag..." -ForegroundColor Yellow
    Write-Host ""
    Set-ProjectDirectory
    mvn test -Dcucumber.filter.tags="@smoke"
    Write-Host ""
    Write-Host "✓ Smoke tests completed" -ForegroundColor Green
}

# Function to run regression tests
function Run-RegressionTests {
    Write-Host ""
    Write-Host "Running Regression Tests with @Regression tag..." -ForegroundColor Yellow
    Write-Host ""
    Set-ProjectDirectory
    mvn test -Dcucumber.filter.tags="@Regression"
    Write-Host ""
    Write-Host "✓ Regression tests completed" -ForegroundColor Green
}

# Function to run all tests
function Run-AllTests {
    Write-Host ""
    Write-Host "Running All Tests..." -ForegroundColor Yellow
    Write-Host ""
    Set-ProjectDirectory
    mvn test
    Write-Host ""
    Write-Host "✓ All tests completed" -ForegroundColor Green
}

# Function to clean and compile
function Clean-AndCompile {
    Write-Host ""
    Write-Host "Cleaning and Compiling Project..." -ForegroundColor Yellow
    Write-Host ""
    Set-ProjectDirectory
    mvn clean install -DskipTests
    Write-Host ""
    Write-Host "✓ Project cleaned and compiled" -ForegroundColor Green
}

# Function to generate Allure report
function Generate-AllureReport {
    Write-Host ""
    Write-Host "Generating Allure Report..." -ForegroundColor Yellow
    Write-Host ""
    Set-ProjectDirectory
    mvn allure:serve
    Write-Host ""
    Write-Host "✓ Allure report generated and opened" -ForegroundColor Green
}

# Function to run with detailed logging
function Run-DetailedLogging {
    Write-Host ""
    Write-Host "Running Tests with Detailed Logging..." -ForegroundColor Yellow
    Write-Host ""
    Set-ProjectDirectory
    mvn test -X -Dcucumber.filter.tags="@smoke"
    Write-Host ""
    Write-Host "✓ Tests completed with detailed logging" -ForegroundColor Green
}

# Main execution
if ($ShowMenu) {
    while ($true) {
        Show-Menu
        $choice = Read-Host "Select option (1-7)"

        switch ($choice) {
            "1" { Run-SmokeTests; Read-Host "Press Enter to continue..." }
            "2" { Run-RegressionTests; Read-Host "Press Enter to continue..." }
            "3" { Run-AllTests; Read-Host "Press Enter to continue..." }
            "4" { Clean-AndCompile; Read-Host "Press Enter to continue..." }
            "5" { Generate-AllureReport; Read-Host "Press Enter to continue..." }
            "6" { Run-DetailedLogging; Read-Host "Press Enter to continue..." }
            "7" {
                Write-Host ""
                Write-Host "Exiting..." -ForegroundColor Yellow
                Write-Host ""
                exit 0
            }
            default {
                Write-Host "Invalid choice. Please try again." -ForegroundColor Red
                Read-Host "Press Enter to continue..."
            }
        }
    }
} else {
    # Direct execution based on parameter
    Set-ProjectDirectory
    switch ($TestType) {
        "smoke" { Run-SmokeTests }
        "regression" { Run-RegressionTests }
        "all" { Run-AllTests }
        "compile" { Clean-AndCompile }
        "report" { Generate-AllureReport }
    }
}


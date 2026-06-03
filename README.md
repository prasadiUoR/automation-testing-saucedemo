# SauceDemo Automation Testing Project

## 📌 Project Overview

This project is an **end-to-end UI automation testing framework** for the SauceDemo e-commerce application:
👉 https://www.saucedemo.com/

It is built using **Selenium WebDriver** with **Java**, **TestNG**, and **Maven**, following the **Page Object Model (POM)** design pattern.

The framework validates core user journeys such as login, product selection, cart operations, and checkout flow.

The project will include a range of features such as Data-Driven Tests, Cross-Browser Tests, Negative Tests, Logging Functionality and Report Generation using Extent Reports. 

---

## 🎯Key Features
- [x]  Functional UI Test Automation 
- [x]  Page Object Model (POM) Design Pattern
- [x] Data-Driven Testing Support
- [x] Cross-Browser Testing Capability
- [x] Negative Test Scenarios
- [x] Logging with Log4j
- [x] HTML Reporting with Extent Reports
- [x] Screenshot capture for failed tests
- [x] Maven-based build system

## 🚀 Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Log4j
- Extent Report
- Git / GitHub

## 📁 Repository Structure

```
saucedemoAutomation/
│
├── src/
│   ├── test/java/
│   │   ├── pageObjects/
│   │   ├── testCases/
│   │   └── utilities/
│
├── testng.xml
├── pom.xml
├── README.md
├── logs/
├── testData/
├── screenshots/
├── reports/
└── run.bat

```

## ⚙️ Getting Started

1.Clone the project
```
git clone https://github.com/Prasadiuor/SaucedemoAutomation
```
2.Go to the project directory
```
cd saucedemoAutomation
```
3.Install Dependencies
```
mvn clean install
```
4.Run tests
```
mvn test
```
5.Run TestNG suite
```
mvn test -DsuiteXmlFile=testng.xml
```
6.Run using batch file (Windows only)
```
Run run.bat file
```
## Project Results
- Test Execution Screenshot
- Extent Report Screenshot
- Extent Report Screenshot - Failure Scenario
## Future Enhancements
- CI/CD integration (GitHub Actions / Jenkins)
- Parallel execution support
- Dockerized test execution
- Allure reporting upgrade

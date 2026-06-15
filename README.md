# ✈️ Flight Booking Automation Framework (BlazeDemo)

An end-to-end Selenium + TestNG automation framework built for [BlazeDemo](https://blazedemo.com), a sample flight booking application. This project demonstrates a production-style test automation setup with cross-browser testing, parallel execution, centralized configuration, and automated HTML reporting.

---

## 🚀 Key Features

- **Page Object Model (POM)** — Home, Reserve, Purchase, and Confirmation pages separated into dedicated classes for maintainability
- **Cross Browser Testing** — Runs on Chrome, Firefox, and Edge via `testng.xml` parameters
- **Parallel Execution** — Multiple browsers run simultaneously using `ThreadLocal<WebDriver>` for thread safety
- **Centralized Configuration** — All URLs, credentials, and test data managed through `config.properties` (zero hardcoding)
- **Log4j2 Logging** — Structured, leveled logs (INFO/WARN/ERROR) written to console and file across every class
- **ExtentReports** — Auto-generated HTML reports with pass/fail status, timestamps, and screenshots on failure
- **TestNG Listeners** — Automated report generation and failure screenshot capture, with zero manual code in test classes
- **Maven CLI Execution** — Fully runnable from the command line, ready for CI/CD pipelines (Jenkins, GitHub Actions)

---

## 🛠️ Tech Stack

| Tool | Purpose |
|------|---------|
| Java | Programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test execution & assertions |
| Maven | Build & dependency management |
| WebDriverManager | Automatic driver binary management |
| Log4j2 | Logging framework |
| ExtentReports | HTML test reporting |

---

## 📂 Project Structure

```
Project3_FlightBooking/
│
├── src/main/java/
│   ├── com.base          → BaseTest.java (driver setup, ThreadLocal, cross-browser)
│   ├── com.pages          → HomePage, ReservePage, PurchasePage, ConfirmationPage
│   └── com.utilities       → ConfigReader, ExtentReportManager, TestListener
│
├── src/test/java/
│   └── com.tests          → FlightBookingTest.java
│
├── src/main/resources/
│   ├── config.properties  → URLs, test data, timeouts
│   └── log4j2.xml          → logging configuration
│
├── testng.xml             → cross-browser + parallel execution config
└── pom.xml                 → dependencies & build configuration
```

---

## ▶️ How to Run

### Prerequisites
- Java JDK 11+
- Maven installed and added to PATH
- Chrome and/or Firefox installed

### Run via Command Line

```bash
mvn clean test
```

This will:
1. Compile the project
2. Execute `testng.xml` (Chrome + Firefox in parallel)
3. Generate an HTML report in `/reports`
4. Capture screenshots on any failure in `/screenshots`

### Run via Eclipse

Right-click `testng.xml` → **Run As → TestNG Suite**

---

## ✅ Test Scenario Covered

**End-to-End Flight Booking Flow:**
1. Search for a flight (departure → destination city)
2. Select an available flight from the results
3. Enter passenger details and payment information
4. Complete the purchase
5. Verify booking confirmation and retrieve booking ID

---

## 📊 Sample Report

After execution, an ExtentReports HTML file is generated in `/reports`, showing test status, system info, and execution timeline for each browser run.

---

## 📌 Notes

This project is part of a growing portfolio of Selenium automation frameworks, each demonstrating progressively advanced concepts (Excel-driven data, custom utilities, logging, cross-browser execution, and CI-ready Maven builds).
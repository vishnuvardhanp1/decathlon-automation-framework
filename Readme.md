# Decathlon Automation Framework

## Overview

This project is an end-to-end UI Automation Framework developed for the Decathlon website using Selenium WebDriver with the BDD Cucumber framework. The framework follows the Page Object Model (POM) design pattern and is designed to be scalable, reusable, and maintainable.

---

# Technology Stack

* Java
* Selenium WebDriver
* Cucumber (BDD)
* TestNG
* Maven
* Page Object Model (POM)
* Selenium Grid
* Allure Reports
* Log4j2 Logging
* Git & GitHub

---

# Framework Features

* Page Object Model (POM)
* BDD using Cucumber
* Reusable Utility Classes
* Explicit Waits
* Cross Browser Execution
* Parallel Execution
* Selenium Grid Support
* Allure Reporting
* Log4j2 Logging
* Screenshot Capture on Failure
* Maven Project Structure
* Git Version Control

---

# Test Scenarios Automated

* Product Search
* Brand Filter Validation
* Price Filter Validation
* Product Details Validation
* Add to Cart
* Cart Count Validation

---

# Project Structure

```text
src
│
├── main
│   └── java
│       ├── base
│       ├── pageObjects
│       └── data.properties
│
├── test
│   ├── java
│   │   ├── cucumberOptions
│   │   ├── hooks
│   │   └── stepDefinitions
│   │
│   └── resources
│       ├── features
│       ├── log4j2.xml
│       └── selenium-server.jar
```

---

# Reporting

* Allure Reports
* Screenshot Capture on Failure

Generate Allure Report

```bash
allure serve allure-results
```

---

# Logging

Log4j2 is used for execution logging, debugging, and tracking test execution.

---

# Parallel Execution

The framework supports parallel execution using TestNG.

Example `testng.xml`

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="Decathlon Parallel Suite"
       parallel="classes"
       thread-count="3">

    <test name="BDD Runner">

        <classes>
            <class name="cucumberOptions.TestRunner"/>
        </classes>

    </test>

</suite>
```

---

# Selenium Grid Execution

### Start Selenium Grid (Standalone)

```bash
java -jar selenium-server.jar standalone
```

### Or Start Hub

```bash
java -jar selenium-server.jar hub
```

### Register Node

```bash
java -jar selenium-server.jar node --hub http://localhost:4444
```

### Execute Tests

```bash
mvn test -DsuiteXmlFile=testng.xml
```

or

```bash
mvn clean test
```

---

# Running the Framework

### Run from Eclipse

* Right-click **TestRunner.java**
* Select **Run As → TestNG Test**

### Run using Maven

```bash
mvn clean test
```

---

# Author

**Vishnu Vardhan**

# Selenium 4.35 Learning & Implementation 🚀

This repository contains my hands-on learning journey with **Selenium 4.x Web Automation**.
I’ll be implementing each concept from \[TheTestingAcademy - Selenium 4.x Notes by Pramod] and documenting my progress step by step.

---

## 📘 Topics Covered

Based on the notes, this repo will include implementations for:

1. **Getting Started with Selenium**

    * Setting up Java, Maven & IntelliJ/Eclipse
    * Running the first Selenium script
    * WebDriver architecture & browser drivers

2. **Locators & Web Elements**

    * `findElement` vs `findElements`
    * XPath (Absolute, Relative, Functions, Axes)
    * CSS Selectors
    * Handling forms, text fields, checkboxes, radio buttons

3. **Selenium Waits ⏳**

    * Implicit Wait
    * Explicit Wait (ExpectedConditions)
    * Fluent Wait

4. **Advanced User Interactions**

    * Actions class (keyboard & mouse events)
    * Handling Alerts, Windows, and iFrames
    * File Upload & Download automation

5. **Working with Web Data**

    * Web Tables (Static & Dynamic)
    * SVG & Shadow DOM handling

6. **Test Automation Frameworks**

    * TestNG integration
    * Allure Reporting
    * Page Object Model (POM) & Page Factory

7. **Data-Driven Testing**

    * Apache POI for Excel integration
    * Property Reader utility

8. **Selenium Grid & Parallel Execution**

    * Grid setup & usage
    * Running tests on Docker & BrowserStack

9. **Miscellaneous**

    * JavaScript Executor
    * Handling Dynamic Elements
    * Logging with Log4j
    * Jenkins CI/CD basics

---

## 🛠 Tech Stack

* **Java 11+**
* **Maven**
* **Selenium 4.x**
* **TestNG**
* **Allure Reports**
* **Apache POI**
* **Log4j**
* **Jenkins** (for CI/CD)

---

## 📂 Repository Structure

```
selenium-4x-learning/
│── src/
│   ├── main/java/   # Utility & Framework Code
│   └── test/java/   # Test Cases
│
│── pom.xml          # Maven dependencies
│── README.md        # This file
```

---

## 🚀 How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/selenium-4x-learning.git
   cd selenium-4x-learning
   ```

2. Install dependencies:

   ```bash
   mvn clean install
   ```

3. Run tests:

   ```bash
   mvn test
   ```

4. Generate Allure Report:

   ```bash
   allure serve target/allure-results
   ```

---

## 📌 Progress Tracker

* [ ] Run first Selenium script
* [ ] Implement all Locators
* [ ] Add Waits (Implicit/Explicit/Fluent)
* [ ] Automate VWO login (Valid/Invalid)
* [ ] Handle Alerts, Windows, iFrames
* [ ] Build POM Framework
* [ ] Add Apache POI for Data-Driven Testing
* [ ] Setup Selenium Grid & Docker
* [ ] Integrate with Jenkins

---

## ✨ Author

👤 **Pramod Dutta**

* [LinkedIn](https://www.linkedin.com/in/pramoddutta)
* [TheTestingAcademy](https://thetestingacademy.com)
* [Blog](https://scrolltest.com)

---

👉 This repository is purely for **learning & practice purposes**.

---
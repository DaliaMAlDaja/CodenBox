 CodenBox Automation Test Suite

A professional end-to-end **Selenium WebDriver** test automation suite using **Java** and **TestNG**, targeting the UI elements and interactive components of [CodenBox Automation Lab Practice Page](https://codenboxautomationlab.com/practice/).

## 📌 Project Overview

This project is designed to demonstrate the automation of common web testing scenarios including:
- Radio buttons and checkboxes
- Dynamic and static dropdowns
- Browser tab/window handling
- Alerts and pop-ups
- Web tables and iframes
- Mouse hover interactions
- Screenshots and file downloads

All tests are written following best practices in automation, ensuring:
- Readability and maintainability
- Randomized element selection for robustness
- Assertion of expected behaviors
- Modular test structure using TestNG

---

## 🛠 Technologies Used

| Technology | Description |
|------------|-------------|
| Java       | Programming language |
| Selenium WebDriver | UI automation |
| TestNG     | Test framework for prioritization and reporting |
| Apache Commons IO | File operations (screenshots) |
| Maven / JUnit (optional) | Dependency management / optional integration |

---

## ✅ Features and Test Cases

| Test Method                    | Description |
|-------------------------------|-------------|
| `RadioButton()`               | Selects a random radio button and verifies selection |
| `DynamicDropdown()`           | Tests autocomplete dropdown with keyboard navigation |
| `StaticDropdown()`            | Selects option from static dropdown using index |
| `Checkbox()`                  | Randomly selects two checkboxes and verifies them |
| `SwitchWindow()`              | Opens a new browser window and switches context |
| `OpenTab()`                   | Opens a new browser tab and verifies title |
| `SwitchToAlert()`             | Handles simple and confirmation alerts |
| `WebTable()`                  | Prints cell data from web table |
| `PrintTableRows()`           | Logs entire rows from web table |
| `HideAndShowTextbox()`       | Verifies textbox visibility toggle |
| `MouseHover()`                | Performs hover and clicks sub-options |
| `IframeTest()`                | Switches to iframe and interacts with menu |
| `DownloadApkFileAndScreenshot()` | Captures screenshot and verifies image creation |

---

## 🔧 Setup and Execution

### Prerequisites

- JDK 8 or higher
- Maven installed (optional)
- Chrome browser
- ChromeDriver (ensure path is correctly set)

### Run the Tests

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/CodenBoxAutomationTest.git
   cd CodenBoxAutomationTest
Add dependencies (if using Maven):

Selenium

TestNG

Apache Commons IO

Execute tests via TestNG XML or your IDE.

📁 Project Structure
bash
نسخ
تحرير
CodenBoxAutomationTest/
│
├── src/
│   └── test/
│       └── java/
│           └── CodenBoxAutomationTest/
│               └── AppTest.java      # Main Test Class
│
├── screenshots/                     # Captured screenshots saved here
├── pom.xml                          # Maven configuration file (if used)
└── README.md
📷 Screenshots
Each time DownloadApkFileAndScreenshot() is executed, a screenshot is saved to /src/test/ScreenShot/ with a timestamped filename.



🤝 Contribution
Contributions are welcome!

🎯 Happy Testing! 

✍️ Author
Dalia Al Daja 
📧 daliamohammad49@gmail.com
🌐 https://www.linkedin.com/in/dalia-aldaja



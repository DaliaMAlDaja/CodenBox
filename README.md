# 🔧 Selenium Web Automation with Java – CodenBoxAutomationTest

This is an automated testing project built using **Selenium WebDriver** with **Java** and **TestNG**, targeting the demo site:  
👉 [CodenBox Automation Lab Practice Page](https://codenboxautomationlab.com/practice/)

## 📌 Project Overview

This test suite covers a wide range of web automation techniques and Selenium functionalities including:

- ✅ Radio buttons
- ✅ Dynamic and static dropdowns
- ✅ Checkbox interactions
- ✅ Window and tab switching
- ✅ JavaScript alerts
- ✅ Web tables (rows and cells)
- ✅ Element visibility (hide/show)
- ✅ Mouse hover actions
- ✅ iFrame interactions
- ✅ Download simulation & screenshots
- ❌ (Optional) Booking calendar

All test methods are designed to be modular and executed using **TestNG**, with randomization added to simulate real-user behavior where applicable.

---

## 🧪 Technologies Used

| Tool            | Purpose                         |
|-----------------|---------------------------------|
| Java            | Programming language            |
| Selenium WebDriver | Web automation framework       |
| TestNG          | Test execution & assertions     |
| Apache Commons IO | File operations (screenshots) |
| ChromeDriver    | Browser driver                  |

---

## 🚀 Getting Started

### Prerequisites

Ensure the following are installed on your machine:

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Chrome Browser](https://www.google.com/chrome/)
- [TestNG plugin](https://testng.org/doc/eclipse.html) (if using Eclipse)
- ChromeDriver compatible with your browser version (placed in system PATH or configured)

---

### 🔧 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/CodenBoxAutomationTest.git
   cd CodenBoxAutomationTest
Open the project in your preferred IDE (Eclipse, IntelliJ, etc.)

Ensure dependencies are set (add TestNG if using manually).

Run the test class AppTest.java as a TestNG Test.

📸 Screenshots
Test DownloadApkFileandScreenShot() saves screenshots with timestamp format to:

swift
نسخ
تحرير
/src/test/ScreenShot/
Example screenshot filename:

نسخ
تحرير
Tue_Jun_03_2025_10_30_45_GMT+03_00.png
📂 Project Structure
pgsql
نسخ
تحرير
CodenBoxAutomationTest/
│
├── src/
│   └── test/
│       └── java/
│           └── CodenBoxAutomationTest/
│               └── AppTest.java       # Main test class
│
├── pom.xml (if using Maven)
├── README.md
└── .gitignore
📌 Test Coverage Summary
Test Method	Description
RadioButton()	Selects a random radio button
DynamicDropdown()	Handles autocomplete dropdown
StaticDropdown()	Selects value from a static dropdown
Checkbox()	Selects two random checkboxes
SwitchWindow()	Switches between windows
OpenTap()	Opens a new tab and switches back
SwitchToAlert()	Handles alerts and confirm boxes
webTable()	Prints all cell data
thecrows()	Prints all table rows
HideandShow()	Hides/shows input box and validates
MouseHover()	Performs hover and clicks options
Calendar()	(Disabled) Reads calendar popup
Iframe()	Switches into iframe and clicks menu
DownloadApkFileandScreenShot()	Clicks download & captures screenshot

🤝 Contribution
Contributions are welcome!
Feel free to fork the repository and submit a pull request.


🎯 Happy Testing! 

✍️ Author
Dalia Al Daja 
📧 daliamohammad49@gmail.com
🌐 https://www.linkedin.com/in/dalia-aldaja



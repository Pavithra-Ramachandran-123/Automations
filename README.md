# Flipkart Automation Project

This project automates the process of searching for a product, purchasing it, and completing payment on Flipkart using Selenium and TestNG. It's designed to save time and simplify testing the functionality of the Flipkart website.

## Project Features
- Open the Flipkart website.
- Search for a specific product using the product name.
- Add the product to the cart and proceed to buy.
- Log in using a phone number.
- Select an address and proceed with payment using a credit/debit card.

## Prerequisites
Before running the project, ensure you have the following installed:
- Java Development Kit (JDK) 8 or higher
- Gradle
- Google Chrome browser (compatible with the ChromeDriver version)
- Visual Studio Code or any other IDE (optional)
- TestNG plugin for your IDE

## Setup Instructions
1. Clone the repository to your local machine: git clone https://github.com/Pavithra-Ramachandran-123/Flipkart_automation.git
2. Navigate to the project directory.
3. Install all dependencies using Gradle: run "gradle build" from terminal

## How to Run
1. Open the project in your IDE or terminal.
2. Update the `testng.xml` file with the following parameters:
   - `productName`: The name of the product you want to search for.
   - `phoneNum`: Your Flipkart account phone number.
3. Run the `TestCases` class or the `testng.xml` file.
4. The tests will execute in the following order:
   - Open the Flipkart website.
   - Search for the specified product.
   - Click on "Buy Now."
   - Log in using your phone number.
   - Add an address and proceed with payment.

## Project Structure
- **TestCases.java**: Contains the Selenium test cases for automation.
- **build.gradle**: Gradle configuration file for managing dependencies.

## Key Libraries Used
- **Selenium WebDriver**: For browser automation.
- **TestNG**: For structuring and executing test cases.
- **WebDriverManager**: For managing the ChromeDriver setup.

## Author
Pavithra Ramachandran


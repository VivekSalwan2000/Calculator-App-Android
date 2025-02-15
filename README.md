# Calculator-App-Android

A simple and efficient Android calculator application designed to perform essential arithmetic operations with additional features like memory storage, decimal support, and negative number handling. The app is optimized for both portrait and landscape orientations, ensuring an intuitive and user-friendly experience across devices.

## Features

### Basic Operations
- **Arithmetic Calculations**: Supports addition, subtraction, multiplication, and division.
- **Chained Operations**: Allows performing multiple operations sequentially with real-time results.
- **Clear and Delete Functions**:
  - **AC Key**: Resets the calculator display to `0`.
  - **Del Key**: Deletes the last entered digit or operator.
- **Error Handling**: Displays `0.0` when encountering invalid operations like division by zero.

### Additional Enhancements
- **Decimal Support**: Enables floating-point calculations using the decimal (`.`) key.
- **Negative Number Handling**: Supports negative numbers (e.g., `4 - 6 = -2`).
- **Memory Feature**:
  - **S Key**: Saves the current displayed value into memory.
  - **R Key**: Recalls the stored value for future calculations.

### Responsive User Interface
- **Adaptive Layouts**: Distinct UI designs for portrait and landscape orientations.
- **Easy-to-Use Interface**: Clear button labels and an intuitive layout for seamless interaction.

## Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/calculator-app.git
   cd calculator-app
   ```

2. **Open in Android Studio**
   - Open **Android Studio**.
   - Click **File > Open...** and select the project folder.
   - Allow the project to synchronize and install dependencies.

3. **Build the APK**
   - Navigate to **Build > Build APK(s)**.
   - Locate the generated APK in `build/outputs/apk/debug` for testing.

## Usage

1. **Running the Application**
   - Install the APK on an Android device or emulator (API level 23 or higher).
   - Open the Calculator App and start performing calculations.

2. **Performing Calculations**
   - **Basic Calculation Example**:  
     `2 + 3 = 5`
   - **Chained Operations Example**:  
     `2 + 3 × 2 = 10` (following standard operator precedence).
   - **Memory Feature**:  
     - Press `S` to save a value.
     - Press `R` to recall the stored value.

3. **Error Handling**
   - Invalid operations (e.g., division by zero) reset the display to `0.0`.

## Technical Details

- **Target API Level**: Android API 23 (Marshmallow) and above.
- **Programming Language**: Java.
- **UI Design**:
  - Uses separate XML layout files for portrait and landscape modes.
  - Optimized for various screen sizes and orientations.
- **Core Functionalities**:
  - Proper input validation and operator handling.
  - Memory storage and retrieval feature.
  - Robust error handling.

## Project Structure

```
CalculatorApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/example/calculatorapp/
│   │   │   │       └── MainActivity.java       # Main activity handling calculator logic
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml         # Portrait mode layout
│   │   │   │   │   └── activity_main_land.xml    # Landscape mode layout
│   │   │   │   └── values/
│   │   │   │       └── strings.xml               # Application strings and constants
│   │   │   └── AndroidManifest.xml               # App manifest and configuration
├── build.gradle                                    # Gradle build file
└── README.md                                       # Project documentation
```

## Acknowledgements

This Calculator App was developed to explore Android UI design, memory management, and fundamental arithmetic operations in mobile applications.

## License

This project is licensed under the MIT License - see the LICENSE file for details.


# Resolving Gradle Build Issues

## Problem
The project cannot compile APKs due to missing Gradle wrapper files. When trying to execute gradle commands, the error "no se ha encontrado o cargado la clase principal org.gradle.wrapper.GradleWrapperMain" occurs.

## Solution Steps

### 1. Install Gradle
Since the system doesn't have Gradle installed, you'll need to install it:

**For Ubuntu/Debian systems:**
```bash
# Download Gradle
wget https://services.gradle.org/distributions/gradle-7.0-bin.zip

# Extract to a directory (e.g., /opt/gradle)
sudo unzip -d /opt/gradle gradle-7.0-bin.zip

# Set environment variables
echo 'export GRADLE_HOME=/opt/gradle/gradle-7.0' >> ~/.bashrc
echo 'export PATH=$PATH:$GRADLE_HOME/bin' >> ~/.bashrc
source ~/.bashrc
```

**Or install via package manager:**
```bash
sudo apt update
sudo apt install gradle
```

### 2. Generate Gradle Wrapper Files
Once Gradle is installed, run the following command in the project root directory:

```bash
gradle wrapper
```

This will create the necessary wrapper files in the `gradle/wrapper/` directory.

### 3. Verify Gradle Configuration
After setting up the wrapper, verify the configuration by running:

```bash
./gradlew --version
```

### 4. Build APK
Once Gradle is working, you can build the APK:

```bash
# For debug build
./gradlew android:assembleDebug

# For release build
./gradlew android:assembleRelease
```

## Alternative Approach (No Gradle Installation)
If you cannot install Gradle due to system constraints, you can:

1. Download Gradle distribution manually from https://gradle.org/releases/
2. Extract it to a local directory
3. Modify the `gradlew` script to point to the local Gradle installation
4. Add the Gradle bin directory to your PATH

## Troubleshooting
- **Error: "Could not find or load main class"**: This indicates missing or corrupted Gradle wrapper JAR files. Ensure the `gradle-wrapper.jar` file exists in the `gradle/wrapper/` directory.
- **Permission denied**: Make sure the `gradlew` script has execute permissions:
  ```bash
  chmod +x gradlew
  ```

## Required Files
Ensure these files exist in your project:
- `gradlew` (executable script)
- `gradle/wrapper/gradle-wrapper.properties`
- `gradle/wrapper/gradle-wrapper.jar`
- `build.gradle` (configuration file)

## Notes
The project is configured for:
- Gradle 7.0
- Java 21 toolchain
- Android SDK 33
- LibGDX 1.12.0 framework
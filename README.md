# Android TV Launcher App with PIN Protection

This is a custom Android TV launcher application developed using **Jetpack Compose**. It displays a grid of installed apps, restricts access to specific apps via a **PIN screen**, and includes smooth focus navigation using D-Pad keys.

##  Features

-  TV-Friendly UI with smooth D-Pad navigation
-  PIN Screen to restrict access
-  Yellow Outline: Approved Apps
-  Red Outline: Blocked (Non-Approved) Apps
-  Non-installed apps show appropriate toast messages
-  Exit button leads to the Android TV home screen
-  Back navigation blocked from PIN screen

##  App Structure

- `MainScreen`: Displays all apps as cards
- `AppItemCard`: UI for individual apps with focus animations
- `PinScreen`: Secure PIN entry screen
- `AppUtils`: Logic to launch apps and handle access control
- `SampleData`: List of all apps and approved/blocked apps

##  Behavior

- **Blocked Apps (Red)**: Cannot be opened. Show "Access Denied".
- **Approved Apps (Yellow)**: Can be opened if installed.
- **If App Not Installed**: Shows "App Not Found" toast.
- **Back Button**: Disabled on PIN screen to enforce PIN entry.
- **Correct PIN Entry**: Exits the app and returns to Android TV home.

> Note: Some apps like YouTube or Netflix may not be installed in the emulator and will show a "Not Found" message.

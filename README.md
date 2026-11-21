# NEXUS STICKMAN TRIBE

Android Studio reconstruction workspace for the supplied *Stickman Tribe* APK.

## Current status
This commit is the **native Android project foundation**, not a finished 1:1 game port. The original game logic, original art/audio, exact progression and online protocol have not yet been reconstructed. Do not describe this build as feature-complete.

## Target
- Android 9+ (minSdk 23, targetSdk 28)
- ARMv7 / armeabi-v7a compatible
- Landscape orientation
- Remote / D-pad navigation
- Offline and online mode entry points

## Build
Open this repository in Android Studio (Giraffe or newer), allow Gradle sync, then build the `app` module.

## Project layout
- `app/src/main/java/com/nexus/stickman/MainActivity.java`: mode selection and TV navigation
- `app/src/main/java/com/nexus/stickman/game/GameActivity.java`: gameplay host placeholder
- `app/src/main/java/com/nexus/stickman/game/GameSurface.java`: render loop foundation
- `app/src/main/java/com/nexus/stickman/net/OnlineConfig.java`: backend configuration placeholder

## 1:1 reconstruction requirements
A faithful port requires inspection and lawful reuse of the original SWF/AS3 source, assets, game data and backend protocol. This repository intentionally does not fabricate those details. Add extracted/authorized assets under `app/src/main/assets/original/` after verifying their licensing and provenance.

## Online mode
Online mode is currently a clearly marked integration point. Configure a backend you control and implement authentication, player profile, cloud save and leaderboard APIs before enabling it. The original game's server is not assumed to be available.

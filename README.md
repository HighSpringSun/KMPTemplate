# KMPTemplate

[English](#english) | [中文](#中文)

## English

Kotlin Multiplatform starter that shares a Compose Multiplatform UI across Android, iOS, Desktop (JVM), and Web (Wasm + JS). Use it as a base for experimenting with Kotlin/Wasm, bridging into native APIs per target, or shipping production apps that reuse most of the UI layer.

### Features
- Compose Multiplatform shared UI hosted in `composeApp`
- Platform-specific entry points for Android (`composeApp`), iOS (`iosApp`), Desktop, and Web
- Dual Web targets: modern Wasm (default) and legacy JS fallback
- Single Gradle build with configuration cache enabled out of the box

### Targets
| Platform | Module / Task | Notes |
| --- | --- | --- |
| Android | `:composeApp:assembleDebug` | Creates a debug APK under `composeApp/build/outputs/apk` |
| Desktop (JVM) | `:composeApp:run` | Boots a Compose desktop window for development |
| Web (Wasm) | `:composeApp:wasmJsBrowserDevelopmentRun` | Fast dev server for modern browsers |
| Web (JS) | `:composeApp:jsBrowserDevelopmentRun` | Compatibility build for older browsers |
| iOS | `iosApp/iosApp.xcodeproj` | Open in Xcode and run on simulator or device |

### Modules
- `composeApp`: Kotlin Multiplatform + Compose module that hosts shared UI, navigation, DI graph, persistence, and networking logic.
- `iosApp`: SwiftUI entry point that embeds the shared Compose framework for Apple targets.
- `gradle`: Version catalog (`libs.versions.toml`) and wrapper configuration that centralize dependency versions and plugin coordinates.

### Libraries & Tooling
- **UI & UX**: Compose Multiplatform (runtime/foundation/material3/components), AndroidX Lifecycle Compose, Cupertino widget set, Kizitonwose Calendar, Navigation Compose.
- **State & Data**: Room (runtime + compiler via KSP), SQLite bundled driver, Jetpack DataStore (core + preferences + Okio), Okio utilities.
- **Networking & Serialization**: Ktor client core with Content Negotiation, Auth, Logging, Resources, platform engines (OkHttp, Darwin, Java), Kotlinx Serialization JSON.
- **Dependency Injection & Logging**: Kodein DI (core + Compose integration) and Kermit logger, Sonner notifications.
- **Media & IO**: Coil 3 (Compose + Ktor network stack) and FileKit dialogs for file pickers.
- **Tooling**: Compose Hot Reload, SKIE (Swift/Compose interop, annotations), SwiftKLib bridge, Kotlinx Coroutines Swing for desktop, Room schema export.

### Project Structure
```
.
├─ composeApp/          # Shared Kotlin + Compose Multiplatform sources
│  └─ src/
│     ├─ commonMain/    # Code reused by all targets
│     ├─ androidMain/   # Android-specific implementations
│     ├─ iosMain/       # iOS-specific implementations
│     ├─ jvmMain/       # Desktop (JVM) hooks
│     ├─ jsMain/        # Legacy web target
│     ├─ wasmJsMain/    # Modern web target
│     └─ webMain/       # Additional web-specific code
├─ iosApp/              # SwiftUI host app + Xcode project
└─ gradle/              # Version catalog and wrapper files
```

### Requirements
- JDK 17+ (matching the Gradle wrapper configuration)
- Android Studio Giraffe or newer with Kotlin Multiplatform plugin
- Xcode 15+ for iOS builds
- Node.js 18+ recommended for running the Web dev server

### Getting Started
1. Clone the repository and open it in Android Studio or IntelliJ IDEA with the Kotlin Multiplatform plugin enabled.
2. Let Gradle sync; the Kotlin Multiplatform wizard will download Compose artifacts automatically.
3. Pick the target you want to run and use the matching command or IDE run configuration below.

#### Android
- macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```
Install the generated APK (`composeApp/build/outputs/apk/debug`) on an emulator or device.

#### Desktop (JVM)
- macOS/Linux
  ```shell
  ./gradlew :composeApp:run
  ```
- Windows
  ```shell
  .\gradlew.bat :composeApp:run
  ```
This launches a resizable Compose window backed by the shared UI.

#### Web
**Wasm target (recommended):**
- macOS/Linux
  ```shell
  ./gradlew :composeApp:wasmJsBrowserDevelopmentRun
  ```
- Windows
  ```shell
  .\gradlew.bat :composeApp:wasmJsBrowserDevelopmentRun
  ```

**JS target (legacy browsers):**
- macOS/Linux
  ```shell
  ./gradlew :composeApp:jsBrowserDevelopmentRun
  ```
- Windows
  ```shell
  .\gradlew.bat :composeApp:jsBrowserDevelopmentRun
  ```

#### iOS
1. Run `./gradlew :composeApp:syncFramework` (or the Windows variant) if you add new shared APIs that need to surface in Swift.
2. Open `iosApp/iosApp.xcodeproj` in Xcode, pick a simulator or device, and press Run.

### Troubleshooting
- **Gradle configuration cache warnings**: run `./gradlew --stop` and `./gradlew clean` to regenerate caches.
- **Missing native toolchains**: confirm Xcode command line tools (`xcode-select --install`) and Android SDK components are installed.
- **Web dev server fails to bind**: stop previous Gradle runs (`./gradlew --stop`) or change the port via `webpack.config.d/watch.js`.

### Resources
- [Kotlin Multiplatform Docs](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform)
- [Kotlin/Wasm](https://kotl.in/wasm)
- [YouTrack Issue Tracker](https://youtrack.jetbrains.com/newIssue?project=CMP)

## 中文

Kotlin Multiplatform 模板项目，通过 Compose Multiplatform 在 Android、iOS、Desktop (JVM) 与 Web（Wasm + JS）之间共享 UI。适合用于试验 Kotlin/Wasm、调用各平台原生 API，或在生产环境中复用 UI 层。

### 功能
- 共享 UI 代码位于 `composeApp`
- 针对 Android（`composeApp`）、iOS（`iosApp`）、Desktop 与 Web 的入口应用
- 同时提供 Wasm（推荐）与 JS（兼容模式）两个 Web 目标
- 单一 Gradle 构建，默认启用 configuration cache

### 目标平台
| 平台 | 模块 / 任务 | 说明 |
| --- | --- | --- |
| Android | `:composeApp:assembleDebug` | 生成的调试 APK 位于 `composeApp/build/outputs/apk` |
| Desktop (JVM) | `:composeApp:run` | 启动 Compose 桌面窗口用于开发 |
| Web (Wasm) | `:composeApp:wasmJsBrowserDevelopmentRun` | 面向现代浏览器的快速开发服务器 |
| Web (JS) | `:composeApp:jsBrowserDevelopmentRun` | 用于旧版浏览器的兼容构建 |
| iOS | `iosApp/iosApp.xcodeproj` | 在 Xcode 中打开并运行到模拟器或真机 |

### 模块
- `composeApp`：Kotlin Multiplatform + Compose 主模块，包含共享 UI、导航、依赖注入、数据持久化与网络逻辑。
- `iosApp`：SwiftUI 宿主应用，加载共享 Compose 框架以运行在苹果平台。
- `gradle`：集中管理依赖与插件版本的版本目录（`libs.versions.toml`）与 Gradle Wrapper 配置。

### 依赖与工具
- **UI & 体验**：Compose Multiplatform（runtime/foundation/material3/components）、AndroidX Lifecycle Compose、Cupertino 组件、Kizitonwose Calendar、Navigation Compose。
- **状态与数据**：Room（runtime + KSP 编译器）、SQLite bundled、Jetpack DataStore（core + preferences + Okio）、Okio 实用库。
- **网络与序列化**：Ktor Client 核心 + Content Negotiation/Auth/Logging/Resources、平台引擎（OkHttp、Darwin、Java）、Kotlinx Serialization JSON。
- **依赖注入与日志**：Kodein DI（核心 + Compose 集成）、Kermit 日志库、Sonner 通知组件。
- **媒体与 IO**：Coil 3（Compose + Ktor 网络栈）、FileKit 对话框用于文件选择。
- **构建工具**：Compose Hot Reload、SKIE（Swift/Compose 互操作）、SwiftKLib 桥接、Kotlinx Coroutines Swing、Room schema 导出。

### 项目结构
```
.
├─ composeApp/          # Kotlin + Compose Multiplatform 共享代码
│  └─ src/
│     ├─ commonMain/    # 所有平台共享代码
│     ├─ androidMain/   # Android 专用实现
│     ├─ iosMain/       # iOS 专用实现
│     ├─ jvmMain/       # Desktop (JVM) 钩子
│     ├─ jsMain/        # 旧版 Web 目标
│     ├─ wasmJsMain/    # 现代 Web 目标
│     └─ webMain/       # 其他 Web 相关代码
├─ iosApp/              # SwiftUI 宿主应用与 Xcode 工程
└─ gradle/              # 版本目录与 wrapper
```

### 环境要求
- JDK 17+（与 Gradle wrapper 配置保持一致）
- Android Studio Giraffe 及以上版本，并启用 Kotlin Multiplatform 插件
- Xcode 15+ 用于 iOS 构建
- 推荐 Node.js 18+ 以运行 Web 开发服务器

### 快速开始
1. 克隆仓库，并在 Android Studio 或 IntelliJ IDEA（启用 Kotlin Multiplatform 插件）中打开。
2. 等待 Gradle 同步，向导会自动下载 Compose 依赖。
3. 根据目标平台选择对应命令或 IDE 运行配置。

#### Android
- macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```
将生成的 APK（`composeApp/build/outputs/apk/debug`）安装到模拟器或真机。

#### Desktop (JVM)
- macOS/Linux
  ```shell
  ./gradlew :composeApp:run
  ```
- Windows
  ```shell
  .\gradlew.bat :composeApp:run
  ```
命令会启动可调整大小的 Compose 桌面窗口。

#### Web
**Wasm（推荐）**
- macOS/Linux
  ```shell
  ./gradlew :composeApp:wasmJsBrowserDevelopmentRun
  ```
- Windows
  ```shell
  .\gradlew.bat :composeApp:wasmJsBrowserDevelopmentRun
  ```

**JS（兼容旧浏览器）**
- macOS/Linux
  ```shell
  ./gradlew :composeApp:jsBrowserDevelopmentRun
  ```
- Windows
  ```shell
  .\gradlew.bat :composeApp:jsBrowserDevelopmentRun
  ```

#### iOS
1. 如果新增共享 API 需要暴露给 Swift，可先运行 `./gradlew :composeApp:syncFramework`（Windows 使用 `.\gradlew.bat`）。
2. 打开 `iosApp/iosApp.xcodeproj`，选择模拟器或设备并点击 Run。

### 常见问题
- **Gradle 配置缓存告警**：执行 `./gradlew --stop` 与 `./gradlew clean` 重新生成缓存。
- **缺少原生工具链**：确认已安装 Xcode Command Line Tools（`xcode-select --install`）与 Android SDK 组件。
- **Web 开发服务器端口占用**：使用 `./gradlew --stop` 终止旧进程，或在 `webpack.config.d/watch.js` 中调整端口。

### 参考资料
- [Kotlin Multiplatform 文档](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform)
- [Kotlin/Wasm](https://kotl.in/wasm)
- [YouTrack 问题反馈](https://youtrack.jetbrains.com/newIssue?project=CMP)

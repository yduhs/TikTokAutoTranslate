# TikTok Auto Translate LSP（起始工程）

## 已知目标环境
- TikTokModCloud 截图版本：45.5.3（versionCode 2024505030）
- 包名：`com.zhiliaoapp.musically`
- LSPosed：2.2.0（API 102）
- Android：14 / arm64-v8a
- 目标翻译语言：简体中文

## 当前状态（请务必阅读）
这是**可在线编译的起始工程**，不是已完成的自动翻译模块。当前 Hook 只在 TikTok 进程加载时写入 LSPosed 日志，尚未拦截评论、标题、简介或字幕，也不会调用翻译服务。原因是要实现可靠翻译，需要针对 TikTok 45.5.3 的实际 UI/数据路径定位 Hook 点；盲目替换所有 TextView 文本可能导致界面错乱、重复翻译或卡顿。

## GitHub Actions 在线编译
1. 在手机浏览器打开 GitHub 并新建一个空仓库。
2. 将此 ZIP 解压后上传项目中的所有文件和文件夹（不是把 ZIP 本身上传到仓库）。
3. 打开仓库的 **Actions** 标签页，允许 Actions 运行。
4. 选择 `Build TikTok Auto Translate LSP`，点击 **Run workflow**。
5. 运行完成后打开该次 workflow，下载 Artifacts 中的 `TikTokAutoTranslate-debug`。
6. 解压 Artifact 得到 APK，安装后在 LSPosed 的「模块」中启用，并在作用域中勾选 TikTok，重启 TikTok 进程。

## 技术说明
- 使用标准 Xposed API 编译依赖；`xposedminversion=93`，适用于常见 LSPosed API 93+ 环境。
- 构建产物为 debug APK，尚未经过设备实测。
- 要完成自动翻译，后续需要实现目标控件/数据源 Hook、翻译提供方、缓存、设置页和错误处理。
- 请勿向不可信的第三方翻译服务发送私人消息或敏感文本。

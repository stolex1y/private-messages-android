package modules

object AppModuleConfig : BaseModuleConfig() {
    override val moduleName: String = "app"
    override val moduleNamespace = "receiver"
    override val versionCode = 1
    override val versionName = "1.0.0"
}

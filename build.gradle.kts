plugins {
    kotlin("jvm") version "1.9.0"
    application
}

val pluginName = "YourPluginName"
val pluginVersion = "1.0-SNAPSHOT"

group = "me.zemf4you"
version = pluginVersion

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    val koinVersion = "3.4.3"
    val paperVersion = "1.20.1-R0.1-SNAPSHOT"

    compileOnly("io.papermc.paper:paper-api:$paperVersion")
    compileOnly("io.insert-koin:koin-core:$koinVersion")
}

kotlin {
    jvmToolchain(17)
}

tasks.register("generatePluginYml", Copy::class) {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    from("plugin-template.yml")
    into("$buildDir/generated-resources")
    rename("plugin-template.yml", "plugin.yml")
    expand("name" to pluginName, "version" to pluginVersion)
}

tasks.jar {
    dependsOn("generatePluginYml")
    from("$buildDir/generated-resources") {
        include("plugin.yml")
    }
    from("src/main/resources") {
        include("**/*")
    }
}

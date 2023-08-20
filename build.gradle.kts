plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "me.zemf4you"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    val koinVersion = "3.4.3"
    val bukkitVersion = "1.20"
    val paperVersion = "$bukkitVersion-R0.1-SNAPSHOT"
    val mockBukkitVersion = "3.9.0"
    val mockkVersion = "1.13.7"
    val logbackVersion = "1.4.11"

    compileOnly("io.papermc.paper:paper-api:$paperVersion")
    implementation("io.insert-koin:koin-core:$koinVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    // Testing
    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("io.insert-koin:koin-core:$koinVersion")
    testImplementation("com.github.seeseemelk:MockBukkit-v$bukkitVersion:$mockBukkitVersion")
}

val generatedResources = "$buildDir/generated-resources"
val mainResources = "src/main/resources"

sourceSets {
    test {
        resources.srcDirs(mainResources, generatedResources)
    }
}

tasks.register("generatePluginYml", Copy::class) {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    outputs.upToDateWhen { false }
    from("plugin-template.yml")
    into(generatedResources)
    rename("plugin-template.yml", "plugin.yml")
    expand("name" to project.name, "version" to version)
}

tasks.processTestResources {
    dependsOn("generatePluginYml")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    dependsOn("generatePluginYml")
    from(generatedResources) {
        include("plugin.yml")
    }
    from(mainResources) {
        include("**/*")
    }
}

plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "1.9.23"
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
    val minecraftVersion = "1.20"
    val paperVersion = "$minecraftVersion-R0.1-SNAPSHOT"
    val mockBukkitVersion = "3.9.0"
    val mockkVersion = "1.13.7"
    val logbackVersion = "1.4.11"
    val kamlVersion = "0.55.0"

    compileOnly("io.papermc.paper:paper-api:$paperVersion")
    implementation("io.insert-koin:koin-core:$koinVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("com.charleskorn.kaml:kaml:$kamlVersion")

    // Testing
    testImplementation(kotlin("test"))
    testImplementation("io.insert-koin:koin-test:$koinVersion") {
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-test-junit")
    }
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("com.github.seeseemelk:MockBukkit-v$minecraftVersion:$mockBukkitVersion")
}

val generatedResources = "$buildDir/generated-resources"
val mainResources = "src/main/resources"
val testResources = "src/test/resources"

sourceSets {
    main {
        resources.srcDirs(mainResources, generatedResources)
    }
    test {
        resources.srcDirs(testResources, generatedResources)
    }
}

tasks.processTestResources {
    dependsOn("generatePluginYml")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.processResources {
    dependsOn("generatePluginYml")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.register("generatePluginYml", Copy::class) {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    outputs.upToDateWhen { false }
    from("plugin-template.yml")
    into(generatedResources)
    rename("plugin-template.yml", "plugin.yml")
    expand("name" to project.name, "version" to version)
}

tasks.build {
    dependsOn(tasks.jar.name)
}

tasks.test {
    useJUnitPlatform()
}

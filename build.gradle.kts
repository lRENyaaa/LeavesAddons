plugins {
    id("java")
    id("io.github.goooler.shadow") version "8.1.7"
}

group = "io.github.lumine1909"
version = "1.1"
description = "Plugin side features for Leaves server."

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://repo.codemc.org/repository/maven-public/")
}

dependencies {
    compileOnly("org.leavesmc.leaves:leaves-api:1.21-R0.1-SNAPSHOT")
    compileOnly("org.leavesmc.leaves:leaves-server:1.21-R0.1-SNAPSHOT")
    compileOnly("fr.xephi:authme:5.6.1-SNAPSHOT")
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
        val props = mapOf(
            "name" to project.name,
            "version" to project.version,
            "description" to project.description,
            "apiVersion" to "1.21"
        )
        inputs.properties(props)
        filesMatching("plugin.yml") {
            expand(props)
        }
    }
}

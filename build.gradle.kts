buildscript {
    repositories {
        gradlePluginPortal()
    }
}

plugins {
    checkstyle
}

project.extra["GithubUrl"] = "https://github.com/noahgill409/olm-data"

apply<BootstrapPlugin>()

subprojects {
    group = "com.example"

    project.extra["PluginProvider"] = "noahgill409"
    project.extra["ProjectSupportUrl"] = "noahgill409@gmail.com"
    project.extra["PluginLicense"] = "3-Clause BSD License"

    repositories {
        jcenter {
            content {
                excludeGroupByRegex("com\\.openosrs.*")
            }
        }

        exclusiveContent {
            forRepository {
                mavenLocal()
            }
            filter {
                includeGroupByRegex("com\\.openosrs.*")
            }
        }
    }

    apply<JavaPlugin>()

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks {
        withType<JavaCompile> {
            options.encoding = "UTF-8"
        }

        withType<AbstractArchiveTask> {
            isPreserveFileTimestamps = false
            isReproducibleFileOrder = true
            dirMode = 493
            fileMode = 420
        }
    }
}

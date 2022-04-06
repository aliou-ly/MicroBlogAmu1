plugins {
    groovy
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.codehaus.groovy:groovy-all:3.0.5")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    // https://mvnrepository.com/artifact/org.json/json
    //implementation ("org.json:json:20220320")
    //implementation("com.github.cliftonlabs:json-simple:3.1.0")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
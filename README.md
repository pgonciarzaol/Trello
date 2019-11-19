# Trello automated tests

To run these tests please install Java JDK 8.22
Change system variables to use installed Java JDK
Install newest IntelliJ IDEA
Clone repository
Open cloned project with Intellij IDEA
If you are running Windows you need to download geckodriver for Windows. Geckodriver for linux is already in the folder
Enable auto-import for Maven repositories
In the project go to features/0001.feature
Right-click this file and click run feature 0001...
If you encounter error: Exception in thread "main" cucumber.runtime.CucumberException: Unrecognized plugin: org.jetbrains.plugins.cucumber.java.run.CucumberJvm4SMFormatter, than change Program arguments in Run/Debug configurations from  --plugin org.jetbrains.plugins.cucumber.java.run.CucumberJvm4SMFormatter to  --plugin org.jetbrains.plugins.cucumber.java.run.CucumberJvmSMFormatter
and rerun.
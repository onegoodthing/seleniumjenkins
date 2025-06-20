# seleniumjenkins

This is the is the sample repository for selenium Jenkins intergration

## CI Pipeline

The project uses a simple Jenkins pipeline defined in the `Jenkinsfile`.
The stages run in the following order:

```
[Build] -> [Test] -> [Deploy]
```

* **Build** – installs dependencies or compiles the project.
* **Test** – runs the automated test suite.
* **Deploy** – performs deployment steps (here it simply echoes a message).

### Triggering the Pipeline

1. Set up a Jenkins pipeline job that points to this repository.
2. Configure the job to build on changes (e.g. GitHub webhook or polling).
3. Pushing commits to the repository will automatically start the pipeline. You can also trigger it manually from Jenkins.


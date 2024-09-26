### 1) Reusing Workflows in GitHub Actions

**Reusing workflows** allows you to create modular, reusable workflows that can be referenced in multiple repositories or workflows within the same repository. This promotes DRY (Don't Repeat Yourself) principles by avoiding duplication of workflow code.

#### How to Reuse Workflows

1. **Create a Reusable Workflow:**

   You define a reusable workflow in a YAML file under the `.github/workflows` directory. Here's an example of a reusable workflow that checks out code and runs tests:

   ```yaml
   # .github/workflows/reusable-workflow.yml
   name: Reusable Test Workflow

   on:
     workflow_call:  # This makes the workflow reusable
       inputs:
         branch:
           required: true
           type: string

   jobs:
     test:
       runs-on: ubuntu-latest
       steps:
       - name: Checkout code
         uses: actions/checkout@v2

       - name: Set up Java
         uses: actions/setup-java@v2
         with:
           java-version: '11'

       - name: Run tests
         run: ./gradlew test
   ```

   - `on: workflow_call`: This event allows the workflow to be reusable.
   - `inputs`: Defines input parameters that can be passed when calling this workflow.

2. **Call the Reusable Workflow:**

   You can call the reusable workflow from another workflow using the `uses` keyword.

   ```yaml
   # .github/workflows/call-reusable-workflow.yml
   name: Call Reusable Workflow

   on:
     push:
       branches:
         - main

   jobs:
     call-workflow:
       uses: ./.github/workflows/reusable-workflow.yml
       with:
         branch: 'main'
   ```

   - `uses`: Specifies the path to the reusable workflow.
   - `with`: Passes inputs to the reusable workflow.

### 2) Sequential Multi-Job Workflows in GitHub Actions

A **sequential multi-job workflow** is a workflow where multiple jobs run one after another, with dependencies between them. This is useful when you want to ensure that certain steps are completed before others start.

#### How to Create a Sequential Multi-Job Workflow

1. **Define Multiple Jobs:**

   Here's an example where three jobs (build, test, and deploy) run sequentially:

   ```yaml
   # .github/workflows/sequential-multi-job.yml
   name: Sequential Multi-Job Workflow

   on:
     push:
       branches:
         - main

   jobs:
     build:
       runs-on: ubuntu-latest
       steps:
       - name: Checkout code
         uses: actions/checkout@v2

       - name: Build the project
         run: ./gradlew build

     test:
       runs-on: ubuntu-latest
       needs: build  # This job depends on the build job
       steps:
       - name: Checkout code
         uses: actions/checkout@v2

       - name: Run tests
         run: ./gradlew test

     deploy:
       runs-on: ubuntu-latest
       needs: test  # This job depends on the test job
       steps:
       - name: Checkout code
         uses: actions/checkout@v2

       - name: Deploy to production
         run: ./gradlew deploy
   ```

   - **Jobs:**
     - `build`: Builds the project.
     - `test`: Runs tests and depends on the `build` job (`needs: build`).
     - `deploy`: Deploys the project and depends on the `test` job (`needs: test`).

2. **Execution Order:**

   In this setup, GitHub Actions ensures that the `test` job only runs after the `build` job is completed successfully. Similarly, the `deploy` job only runs after the `test` job completes successfully.

### Summary

- **Reusing Workflows** allows you to create modular workflows that can be called from other workflows, reducing duplication and making maintenance easier.
- **Sequential Multi-Job Workflows** let you define jobs that run in a specific order, ensuring that dependencies are met before proceeding to the next step.
### Git Merge

Git merge integrates changes from one branch into another by creating a new merge commit. This is useful for combining work from different branches and preserving the commit history of each branch.

#### Example Workflow for Git Merge

1. **Create a New Branch and Make Changes**

   Assume we start with a `master` branch containing some initial commits:

   ```bash
   git checkout master
   echo "Initial commit" > file.txt
   git add file.txt
   git commit -m "Initial commit"
   ```

   Create a new branch `feature-branch` and make some changes:

   ```bash
   git checkout -b feature-branch
   echo "Feature work" > feature.txt
   git add feature.txt
   git commit -m "Add feature work"
   ```

   Now, the `feature-branch` has diverged from `master` with its own commit history.

2. **Merge Changes into `master`**

   To integrate changes from `feature-branch` back into `master`:

   ```bash
   git checkout master
   git merge feature-branch
   ```

   Git creates a new merge commit that combines the changes from `feature-branch` into `master`.

#### Example Visualization of Git Merge

Before merging (`git log --oneline --graph --all`):

```
*   b523d3f (HEAD -> master) Merge branch 'feature-branch'
|\  
| * 7a9b5e2 (feature-branch) Add feature work
* | 8457b7d Initial commit
```

After merging (`git log --oneline --graph --all`):

```
*   b523d3f (HEAD -> master) Merge branch 'feature-branch'
|\  
| * 7a9b5e2 (feature-branch) Add feature work
* | 8457b7d Initial commit
```

### Git Rebase

Git rebase rewrites commit history by moving or combining commits from one branch onto another base branch. It provides a cleaner, linear history but should be used with caution, especially when changes have been shared or pushed to a remote repository.

#### Example Workflow for Git Rebase

1. **Create a New Branch and Make Changes**

   Starting from the same initial setup as before:

   ```bash
   git checkout -b feature-branch
   echo "Feature work" > feature.txt
   git add feature.txt
   git commit -m "Add feature work"
   ```

   The `feature-branch` now has one commit ahead of `master`.

2. **Rebase `feature-branch` onto `master`**

   To rebase `feature-branch` onto `master`:

   ```bash
   git checkout feature-branch
   git rebase master
   ```

   Git replays the commits from `feature-branch` on top of `master`.

3. **Resolve Conflicts (if any)**

   If there are conflicts during the rebase process, Git will pause and prompt you to resolve them:

   ```bash
   # Resolve conflicts in files
   git add <resolved_files>
   git rebase --continue
   ```

4. **Complete the Rebase**

   Once conflicts are resolved, Git applies the commits from `feature-branch` onto `master`:

   ```bash
   git checkout master
   git merge feature-branch
   ```

#### Example Visualization of Git Rebase

Before rebasing (`git log --oneline --graph --all`):

```
* 7a9b5e2 (HEAD -> feature-branch) Add feature work
* 8457b7d (master) Initial commit
```

After rebasing (`git log --oneline --graph --all`):

```
* 12ab3cd (HEAD -> feature-branch) Add feature work
* 8457b7d (master) Initial commit
```

### Comparison and Use Cases

- **Merge**:
  - Preserves the history of both branches.
  - Creates a merge commit, resulting in a non-linear history.
  - Suitable for integrating feature branches into the mainline development.
  
- **Rebase**:
  - Rewrites commit history by applying changes from one branch onto another.
  - Maintains a cleaner, linear history without merge commits.
  - Useful for keeping feature branches up-to-date with `master` or main development branches before merging.

### Summary

- **Merge**: Integrates changes by creating a merge commit, preserving the history of both branches.
- **Rebase**: Rewrites commit history by moving or combining commits from one branch onto another, resulting in a linear history.

Choosing between merge and rebase depends on the project's workflow, collaboration style, and the desired structure of the commit history. Both operations have their advantages and use cases, so understanding when and how to use each helps in managing Git branches and history effectively.
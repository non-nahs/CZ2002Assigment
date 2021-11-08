# CZ2002Assigment
Group Assignment for CZ2002

1. Before you start, download VS Code and install the Java extension
2. Learn how to use Git on VS Code through this tutorial: https://www.youtube.com/watch?v=RGOj5yH7evk
3. Create a branch to work on, try not to work on main (minimise possibility of breaking the code)
4. Make sure there is a commit message before committing your code and update the group whenever you are done editing

# IMPORTANT!! ENSURE YOU HAVE THE CORRECT BUILD PATH
Easiest way to correct the build path:
1. Open the project in eclipse after cloning
2. Go to file->open projects from file system and navigate to your local repository and click finish. There should be quite a few errors at first
3. Right click on the project name and select "build path"-> "configure build path"
4. Ensure that the JRE System Library is selected, click "Apply and close"
5. The files should be reconfigured to the correct build path in both Eclipse and VS Code. Use either one at your preference to edit

## Using git commands in terminal/command prompt for VS Code

1. Go to terminal->New Terminal if there is no open terminal in your VS Code
2. Alternatively, you can run all commands in your Terminal/command prompt
2. Ensure the correct local folder is open on the explorer tab(on the left, should be the first icon on top).
3. Reinitiate git by running "git init"
4. 1, Clone respository by running "git clone [insert URL, use HTTPs for our project]
4. 2, Alternatively, run "git checkout [branch name]" if you have already an existing version to update to the latest one
4. Create new branch with "git checkout -b [new branch name]" *note: you can switch to any branch name with "git checkout [branch name]" as well. USE This only if you know the commands to set the branch up and merge back to main, else just work on main.
5. Edit changes as necessary
6. Add files to be updated to git, in this case, just run "git add src", the changes will be automatically detected by git
7. To check what will be committed, run "git status", the files that have been modified and to be committed will be displayed
8. Push your changes to git by running "git push"

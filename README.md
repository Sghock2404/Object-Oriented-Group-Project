# ADS
Team ADS

# ADS General
-----
Here's an outline of how we're going to add progress to this `development` branch. We're going to add changes here because normally people save the master branch for "deployment-ready" code - so we'll treat it as our final product :)

My goal is that this README helps you both out with understanding our project structure - if something doesn't work let me know and I'll make changes to this text. (I'm learning this as well, lol)

Setup
-----
### Cloning the repository
First let's `git clone` this repository into whatever local directory you'd like:

  $ cd 'your_desired_directory'
  $ git clone https://git.txstate.edu/CS3354/ADS.git
  
### Checking out a 'development' branch
Now we're going to `cd` into the new directory and `git checkout` a `development` branch so that we don't make changes to `master` - our final product:
  
  $ cd ADS
  $ git checkout development
  
When we 'check out a branch', what we're doing is choosing a new instance of our `master` repo that has a purpose.

### Updating repository with new changes
We're going to be developing on the same branch for now to avoid confusion as we learn team-oriented git development. When we make commits and add changes, we'll need a way for other people to receive these changes. We'll do that with the following command:

  $ git fetch -all
  
This `fetch -all` command will obtain ALL changes made to all branches for our project repository. It might be a good idea to use this command every time you start work on the assignment or if we announce big changes in team chat.

Context of branches: I read in an article that usually, separate branches are places where developers in a team will work on features, debugging, etc.. Say for example we're developing a social media website/app for dogs, if we planned on implementing an `explore page`, what we could do is create a new branch called `explore_page`, and add work towards that feature in that branch. Whenever the work for that feature is ready to be deployed, that's when the `explore_page` branch is merged with the master one.

Progress and work
-----

Here I'll put some information about who's doing what tasks for the project.

### Tasks
* Rating Summary
* Data

### Adding and committing changes
As you do work and finish implementing something, `add` and `commit` those changes so that everyone can later fetch those changes and apply it to our work.

  $ git add .
  $ git commit -m 'Implement bananaFarm()'
  
Eventually, when we finish the assignment, I'll merge the `development` branch into the master branch and that will be what we submit for the assignment.

## Other 

In the future if y'all want to continue working on projects together for this class,  we can start learning and applying other github features like 'Pull Requests' and 'Issues' just so that we can get even more familiar with Github/git. 

Thing might get messy - let's do our best to work things out.

Feel free to add anything onto this README if you have other resources/articles/ideas to share.
  







  


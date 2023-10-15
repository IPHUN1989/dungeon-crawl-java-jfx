![GitHub repo size](https://img.shields.io/github/repo-size/IPHUN1989/dungeon-crawl-java-jfx)
![GitHub language count](https://img.shields.io/github/languages/count/IPHUN1989/dungeon-crawl-java-jfx)
![Static Badge](https://img.shields.io/badge/total%20number%20of%20tracked%20files-40-blue)
![GitHub contributors](https://img.shields.io/github/contributors/IPHUN1989/dungeon-crawl-java-jfx)
![GitHub commit activity (branch)](https://img.shields.io/github/commit-activity/t/IPHUN1989/dungeon-crawl-java-jfx?label=total%20commits)
![GitHub last commit (branch)](https://img.shields.io/github/last-commit/IPHUN1989/dungeon-crawl-java-jfx/development)
![GitHub pull requests](https://img.shields.io/github/issues-pr/IPHUN1989/dungeon-crawl-java-jfx)


# Dungeon Crawl

## Story

[Roguelikes](https://en.wikipedia.org/wiki/Roguelike) are one of the oldest
types of video games. The earliest ones were made in the 70s, and they were inspired
a lot by tabletop RPGs. Roguelikes usually have the following features in common.

- They are tile-based.
- The game is divided into turns, that is, you take one action, then the other
  entities (monsters, allies, and so on, controlled by the CPU) take one.
- The task is usually to explore a labyrinth and retrieve some treasure from its
  bottom.
- They feature permadeath: if you die, it's game over, you need to start from the
  beginning again.
- They rely heavily on procedural generation: Levels, monster placement, items, and so on
  are randomized, so the game does not get boring.

# Prerequisites

- <img src="https://upload.wikimedia.org/wikipedia/commons/5/52/Apache_Maven_logo.svg" alt="drawing" width="30" align="center"/> *Maven 3.6.3*
- <img src="https://raw.githubusercontent.com/yurijserrano/Github-Profile-Readme-Logos/042e36c55d4d757621dedc4f03108213fbb57ec4/programming%20languages/java.svg" alt="drawing" width="30" align="center"/> *Java 17.0.7*
- <img src="https://raw.githubusercontent.com/yurijserrano/Github-Profile-Readme-Logos/042e36c55d4d757621dedc4f03108213fbb57ec4/others/git.svg" alt="drawing" width="30" align="center"/> *Git 2.30.2*

# Usage

**Clone with the following command line:**

```bash
# Clone this repository
git clone: https://github.com/IPHUN1989/dungeon-crawl-java-jfx.git

```

## Installation

- **Run the following command lines**

```bash
# Navigate to the local folder
cd {local_folder_of_cloned_project}

# Build the project to a jar file
mvn clean install

# Navigate to target folder
cd target/

# Run the applicaiton
java -jar dungeon-crawl-1.0-SNAPSHOT.jar

```

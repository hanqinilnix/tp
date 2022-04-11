---
layout: page
title: Mark Biju's Project Portfolio Page
---

### Project: UniGenda

UniGenda is a **desktop app for managing contacts and schedules**, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you are a university student having a hard time organising your timetable, or commonly find difficulty scheduling a suitable time to meet up with your project group mates or friends, UniGenda is the app just for you!

With features such as the ability to import your friends' schedules, find friends who are free at a certain date and time, and find common timings to meet with your project teammates, UniGenda makes your university life easier by helping you **keep track of not only your own, but also your friends' schedules!**

Given below are my contributions to the project.

* **New Feature**: Added the ability to view contacts by tag
    * What it does: Allows the user to be able to view all contacts that share a particular tag(inputted by the user)
    * Justification: This feature is necessary for the user to be able to see people that share a particular tag. It would be a useful feature as users would want to know which contacts have a particular tag attached to them(as they may be part of a similar group)

* **New Feature**: Added the ability to view free common timings that people are free based on a date and tag input by the user
    * What it does: Shows the user which timings those who share a particular tag are free on a particular day, based on a tag and date input by the user
    * Justification: A user would want to know when their contacts from the saame group of friends(hence taking those with the same tag) would be free on a particular day to organise a meetup.
    * How hard it was to implement: It was significantly difficult to ensure that this command was bug-free. The implementation of this command was revised several times to ensure that it worked as intended. This was due to many edge cases that needed to be handled in the implementation of this command.
    

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=markbiju&breakdown=true)

* **Project management**:
    * Ensured that issues for each milestone were closed and updated as milestones passed.

* **Documentation**:
    * User Guide
      * Added and edited documentation for the 'viewGroup' and 'findCommonTiming' features
    * Developer guide:
      * Added implementation details for viewGroup and findCommonTiming
      * Added sequence diagrams for viewGroup and findCommonTiming

* **Community**:
    * PRs reviewed (with non-trivial review comments):
      * [#70] (https://github.com/AY2122S2-CS2103T-W09-1/tp/pull/70)
      * [#59] (https://github.com/AY2122S2-CS2103T-W09-1/tp/pull/59)
      * [#58] (https://github.com/AY2122S2-CS2103T-W09-1/tp/pull/58)

* **Tools**:
    * Used PlantUML to create sequence diagrams for two features implemented, viewGroup and findCommonTiming

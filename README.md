# Notes Application
## Introduction

Notes-app is a work in progress. Through the past couple of weeks this application has had extra features added, validation, testing and Utilities to improve the overall functionality and structure. Notes-App is a note kepper application that will allow users to create, read, update, delete, archive search save and load multiple notes and store them in the program. A skeleton menu will appear to the user giving a list of numbered options to choose from, asking for input from the user. When the user selects one of these options the user will be asked to input the properties of the note such as: Note Title, Note Priority, Note Category, isNoteArchived, Note Contents, Note Status and Note Date. Once the user has correctly inpputted all fields following the validation provide the notes will be added to the system. From there the user can continue to add various notes and use the other options on hand.
<br/><br/>
A Sub-Menu was also added for the option <em>List All Notes.</em> When pressed the sub-menu displays further options for the user to choose from. This is where the user can list all notes or just the specific notes stored in the system by the user that have been <em>archived or active.</em>
<br/><br/>
## Features
- Using CRUD to create, read, update and delete notes that are stored in the program
- A skeleton menu has been added and a more advance menu will be added at a later date
- A utility package containg a Scanner class is user to read user input rather than import java Scanner 
- Throw and catches are used to catch an error and return a message without allowing the program to completely crash
- A Kotlin-Logger is added to the program to allow for logger information to be log onto the screen.
- JUnit testing of all features in v2.0.
- Persistence such as XML and JSON have been added to load and save files
- Search Notes by Title functionality added
- Sub-Menu added for the option - list all notes that can list all notes, - all archived notes and - list all active notes.

## Application
![Completed Notes App](https://user-images.githubusercontent.com/78036222/161263064-077c183c-3cbf-426b-a76e-7717034568d5.jpg)
<br/><br/>
<br/><br/>
![Sub-Menu](https://user-images.githubusercontent.com/78036222/161263214-c6fe5c87-32c1-48c8-a265-554bf7dbd6a0.jpg)

## Additional Features added
1. There new additional fields added: <strong>noteContents</strong>, <strong>noteStatus</strong>, <strong>noteDate</strong>
2. Three new listing and counting methods added: 

    - listNotesBySelectedCategory
    - listNotesBySelectedStatus
    - listNotesBySelectedDate

3. New Persistence added, [YAML](https://www.redhat.com/en/topics/automation/what-is-yaml)
4. Utility Class NoteUtilities added for Validation purposes for functions in the program

[🇩🇪 Deutsch](README.md) | 🇬🇧 English | [🇳🇱 Nederlands](README.nl.md)

# Personalverwaltung

A small Java application for managing employee data.

## About this project

This project was created during my internship at **Bruckmann Steuerungstechnik GmbH**. The assignment was to develop an employee management system in Java. This repository contains the result.

## Features

- Add new employees (IDs are assigned automatically)
- Edit employee data
- Delete employees
- Select a department from a dropdown menu
- Record attendance status via a yes/no prompt
- Save data permanently in a text file and load it again at startup
- Clear, formatted overview of all employees in the console

## Project structure

| Class         | Purpose                                                              |
|---------------|----------------------------------------------------------------------|
| `Mitarbeiter` | Defines the employee object with all fields and column names         |
| `Verwaltung`  | Handles adding, editing, searching and deleting employees            |
| `Speicher`    | Saves the employee list to a text file and loads it again            |
| `Abteilung`   | Contains the list of departments for the dropdown menu               |
| `TestMain`    | Starts the program with the selection menu (JOptionPane)             |
| `Ausgabe`     | Displays the data in a Swing table (work in progress)                |

## Technologies

- Java
- JOptionPane for the user interface
- IntelliJ IDEA
- Git and GitHub

## Getting started

1. Clone the repository:
   ```
   git clone https://github.com/AnjaBoin/Personalverwaltung.git
   ```
2. Open the project in IntelliJ IDEA.
3. Run `TestMain`.

Employee data is stored in `Daten/outputMitarbeiter.txt`.

## Author

**Anja Boin**
Internship at Bruckmann Steuerungstechnik GmbH
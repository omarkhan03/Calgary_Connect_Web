We had problems setting up the projects correctly. So we basically have a project inside a project.

So the /server is our actual server.

If you want to run this project, first clone the repository:

This can be done by using the following CLI command: (You have to have "git" installed)
```
git clone https://github.com/VladT7/yychacks.git
```

2. Check if you have node installed with the command:
``` node -v ```

3. Have "nodejs" installed if you haven't, then use your Terminal to direct to the /server directory, where the "package.json" is located,
then you will first install all the packages by running
``` npm i ``` or ``` npm install ```
This will install all the dependencies we need for this project. You only need to this for the first time.

4. Now, you should be able to run the project with
``` npm run dev ```

Type "localhost:5000" in your browser to view the website.

The server is basically just serving all the static files (.html) located inside our static folder.

The meat of the project is inside the mappage.js where we get all the data from an open API and create a list of events and map.
We used Leaflet Map for drawing the map and the pins.

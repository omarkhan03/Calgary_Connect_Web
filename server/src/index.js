const express = require("express")
const path = require("path")
const formatedData = require("./data")



const app = express()
const PORT = 3000

app.get("/data", (req, res) => {
    res.send(formatedData)
})

app.use('/', express.static(path.join(__dirname, '../static')))

app.listen(PORT, () => {
    console.log(`Listening on port: ${PORT}`)
})
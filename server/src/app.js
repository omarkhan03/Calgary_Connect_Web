const express = require('express');
const path = require('path')
const mongoose = require('mongoose');

const Location = require('../models/locations');
const formatedData = require("./data")


mongoose.connect('mongodb://localhost:27017/yycconnects')
    .then(() => {
        console.log('Connection Open!!!');
    })
    .catch(() => {
        console.log('Error!!!');
    })



const db = mongoose.connection;


const app = express();


app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'))

// app.get('/', (req,res)=>{
    // res.render('home')
// })

app.use('/', express.static(path.join(__dirname, '../static')))


app.get('/sites', async (req, res) => {
    const sites = await Location.find({});
    res.render('sites/index', { sites })
});
app.get('/sites/new', (req, res) => {
    res.render('sites/new');
})

app.post('/sites', async (req, res) => {
    const site = new Location(req.body.site);
    await site.save();
    res.redirect(`/sites/${site._id}`)
})

app.get('/sites/:id', async (req, res,) => {
    const site = await Location.findById(req.params.id)
    res.render('sites/show', { site });
});

app.get('/sites/:id/edit', async (req, res) => {
    const site = await Location.findById(req.params.id)
    res.render('sites/edit', { site });
})

app.put('/sites/:id', async (req, res) => {
    const { id } = req.params;
    const site = await Location.findByIdAndUpdate(id, { ...req.body.site });
    res.redirect(`/sites/${site._id}`)
});

app.delete('/sites/:id', async (req, res) => {
    const { id } = req.params;
    await Location.findByIdAndDelete(id);
    res.redirect('/sites');
})

app.get("/data", (req, res) => {
    res.send(formatedData)
})

app.use('/events', express.static(path.join(__dirname, '../static/events.html')))

app.use('/food', express.static(path.join(__dirname, '../static/food.html')))

app.use('/mappage', express.static(path.join(__dirname, '../static/mappage.html')))


const axios = require("axios");

const options = {
  method: 'GET',
  url: 'https://google-maps-geocoding.p.rapidapi.com/geocode/json',
  params: {latlng: '40.714224,-73.96145', language: 'en'},
  headers: {
    'X-RapidAPI-Key': '9d4b5f864amshaf0d8d49acd5c6ep15b0e3jsn19f524833588',
    'X-RapidAPI-Host': 'google-maps-geocoding.p.rapidapi.com'
  }
};

axios.request(options).then(function (response) {
	console.log(response.data);
}).catch(function (error) {
	console.error(error);
});

app.listen(3000,()=> {
    console.log('serving on port 3000')
})
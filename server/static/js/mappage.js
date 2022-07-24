// const Marker = require('ol-marker-feature')
// const Popup = require("ol-popup")

// const marker = new Marker([51.128986, -114.14366]);
// marker.set('info', 'HELOOOOOOOOOO.')
// marker.setMap(map);

// const popup = new Popup({offset: [0, -32]});
// map.addOverlay(popup);

// marker.on('click', function() {
//   popup.show(marker.getLocation(), marker.get('info'));
// });

var map = L.map('map').setView([51.128986, -114.14366], 15);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 20,
    attribution: '© OpenStreetMap'
}).addTo(map);

// var marker = L.marker([51.128986, -114.14366]).addTo(map);

var inRange = [];
var titles= [];
var currPos;
var currMarker;
var circle;

// Getting Current User Location
const currLocation = window.navigator.geolocation.getCurrentPosition((pos) => {
const {latitude, longitude} = pos.coords

circle = L.circle([latitude, longitude], {
    color: 'red',
    fillColor: '#f03',
    fillOpacity: 0.5,
    radius: 3000
}).addTo(map);

    currPos = new L.LatLng(latitude, longitude);
    // map = L.map('map').setView([latitude, longitude], 15);
})

// Getting all the events
fetch("http://localhost:3000/data").then(response => response.json()).
then(data =>  data.formatedData.forEach((event) => {
    var marker = L.marker([event.Events.Lat.Lat, event.Events.Long.Long]).addTo(map);
    // marker.bindPopup(`${event.Events.Title.Title}`).openPopup()
    marker.bindPopup(`${event.Events.Lat.Lat},${event.Events.Long.Long}`)

    eventPos = new L.LatLng(event.Events.Lat.Lat, event.Events.Long.Long)
    // console.log(eventPos.distanceTo(currPos))
    // console.log(event.Events.Title.Adress)

    if (!titles.includes(event.Events.Adress.Adress) && eventPos.distanceTo(currPos) <= 3000 ) {
        titles.push(event.Events.Adress.Adress)
        inRange.push(event);
    }
}))

console.log(inRange)


var map = L.map('map').setView([51.128986, -114.14366], 15);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 20,
    attribution: '© OpenStreetMap'
}).addTo(map);

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
    radius: 2000
}).addTo(map);

    currPos = new L.LatLng(latitude, longitude);
    map.setView([latitude, longitude], 14);
})

// Getting all the events

const eventCards = document.querySelector("aside.event-cards")
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

})).then( () => {
   inRange.forEach((event) => {

    const eventcard = document.createElement("div");
    eventcard.className = "event-card"

    // const event_img = document.createElement("img");
    // eventcard.appendChild(event_img)

    const event_title = document.createElement("h4")
    event_title.innerText = "Title: "
    const event_title_text = document.createElement("span")
    event_title_text.innerText= `${event.Events.Title.Title}`
    event_title.appendChild(event_title_text)
    eventcard.appendChild(event_title)

    const event_type = document.createElement("h4")
    event_type.innerText = "Type: "
    const event_type_text = document.createElement("span")
    if (event.Events.Event_type.Event_type)
        event_type_text.innerText = `${event.Events.Event_type.Event_type}`
    else
        event_type_text.innerText = `${event.Events.Title.Title}`
    event_type.appendChild(event_type_text)
    eventcard.appendChild(event_type)

    const event_date = document.createElement("h4")
    event_date.innerText = "Date: "
    const event_date_text = document.createElement("span")
    event_date_text.innerText = event.Events.Dates.Dates
    event_date.appendChild(event_date_text)
    eventcard.appendChild(event_date)

    const event_address = document.createElement("h4")
    const event_address_text = document.createElement("span")
    event_address.innerText = "Address: "
    event_address_text.innerText = event.Events.Adress.Adress
    event_address.appendChild(event_address_text)
    eventcard.appendChild(event_address)

    // const event_detail = document.createElement("a")
    // event_detail.href = `${event.Events.More_info.More_info}`
    // eventcard.appendChild(event_detail)

    eventcard.addEventListener("click", () => {
        window.open(event.Events.More_info.More_info, '_blank')
    })

    eventCards.appendChild(eventcard)
 })})





// (async () => {

// const events = await fetch("http://localhost:3000/data");
// // console.log(events.json())

// events.map(
//     (event) => {
//         const eventcard = document.createElement("div");
//         eventcard.className = "eventcard"

//         const event_img = document.createElement("img");

//         const event_title = document.createElement("h4")
//         event_title.innerText = `Title: ${event.Title}`

//         const event_type = document.createElement("h4")
//         event_type.innterText = `Type: ${event.Event_type}`

//         const event_date = document.createElement("h4")
//         event_date.innerText = `Date: ${event.Dates}`

//         const event_address = document.createElement("h4")
//         event_address.innerText = `Address: ${event.Address}`

//         const event_detail = document.createElement("a")
//         event_detail.href = `${event.More_info}`
//     }
// )

// })();

fetch("http://localhost:3000/data").then(response => response.json()).
then(data =>  
        data.formatedData.map(
    (event) => {
        const eventcard = document.createElement("div");
        eventcard.className = "eventcard"

        const event_img = document.createElement("img");

        const event_title = document.createElement("h4")
        event_title.innerText = `Title: ${event.Title}`

        const event_type = document.createElement("h4")
        event_type.innterText = `Type: ${event.Event_type}`

        const event_date = document.createElement("h4")
        event_date.innerText = `Date: ${event.Dates}`

        const event_address = document.createElement("h4")
        event_address.innerText = `Address: ${event.Address}`

        const event_detail = document.createElement("a")
        event_detail.href = `${event.More_info}`
    }
    ))
fetch("http://localhost:3000/data").then(response => response.json()).
then(data =>  
        data.formatedData.map(
    (event) => {
        const eventcard = document.createElement("div");
        eventcard.className = "eventcard"

        const event_img = document.createElement("img");
        eventcard.appendChild(event_img)

        const event_title = document.createElement("h4")
        event_title.innerText = `Title: ${event.Events.Title.Title}`
        eventcard.appendChild(event_title)

        const event_type = document.createElement("h4")
        event_type.innterText = `Type: ${event.Events.Event_type.Event_type}`
        eventcard.appendChild(event_type)

        const event_date = document.createElement("h4")
        event_date.innerText = `Date: ${event.Events.Dates.Dates}`
        eventcard.appendChild(event_date)

        const event_address = document.createElement("h4")
        event_address.innerText = `Address: ${event.Events.Adress.Adress}`
        eventcard.appendChild(event_address)

        const event_detail = document.createElement("a")
        event_detail.href = `${event.Events.More_info.More_info}`
        eventcard.appendChild(event_detail)

        const body = document.querySelector("body")
        body.appendChild(eventcard)
    }
    ))
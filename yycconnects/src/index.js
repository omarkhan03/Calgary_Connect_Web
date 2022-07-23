import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import axios from "axios";

const url =  "https://data.calgary.ca/resource/n625-9k5x.json"
const root = ReactDOM.createRoot(document.getElementById('root'));

const formatedData =[]
  axios.get(url)
.then((response) => {
  for (let i in response.data){
    const formatingData = {};
    if(!formatingData ["Events"]){
      formatingData ["Events"] = {}
    }
    if(!formatingData["Events"]["Title"]){
      formatingData["Events"]["Title"] = {Title:response.data[i].title}
    }
    if(!formatingData["Events"]["Adress"]){
      formatingData["Events"]["Adress"] = {Adress:response.data[i].address}
    }
    if(!formatingData["Events"]["Host"]){
      formatingData["Events"]["Host"] = {Host:response.data[i].host_organization}
    }
    if(!formatingData["Events"]["Event_type"]){
      formatingData["Events"]["Event_type"] = {Event_type:response.data[i].event_type}
    }
    if(!formatingData["Events"]["Dates"]){
      formatingData["Events"]["Dates"] = {Dates:response.data[i].all_dates}
    }
    if(!formatingData["Events"]["More_info"]){
      formatingData["Events"]["More_info"] = {More_info:response.data[i].more_info_url}
    }
    

    
    // console.log(response.data[i]);
    // console.log(formatingData)
    formatedData.push(formatingData)
    console.log(formatedData);

  }
  root.render(
    
  );
})
.catch((err) => {
console.log("Error"); 
});

  
  



// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
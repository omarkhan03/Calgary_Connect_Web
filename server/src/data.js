const axios = require("axios")
const url =  "https://data.calgary.ca/resource/n625-9k5x.json"

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
    // if(!formatingData["Events"]["Host"]){
    //   formatingData["Events"]["Host"] = {Host:response.data[i].host_organization}
    // }
    if(!formatingData["Events"]["Event_type"]){
      formatingData["Events"]["Event_type"] = {Event_type:response.data[i].event_type}
    }
    if(!formatingData["Events"]["Dates"]){
      formatingData["Events"]["Dates"] = {Dates:response.data[i].next_date_times}
    }
    if(!formatingData["Events"]["More_info"]){
      formatingData["Events"]["More_info"] = {More_info:response.data[i].more_info_url}
    }



    if (!formatingData["Events"]["Lat_Long"]){
      formatingData["Events"]["Lat"] = {Lat:response.data[i].latitude}
      formatingData["Events"]["Long"] = {Long:response.data[i].longitude}
    } 


    // console.log(response.data);
    console.log(formatingData)
    formatedData.push(formatingData)
    // console.log(formatedData);

  }

})  

module.exports = {formatedData : formatedData};
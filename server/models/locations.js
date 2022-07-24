const mongoose = require('mongoose');

const Schema = mongoose.Schema;

const LocationSchema = new Schema( {
    name: String,
    address: String,
    time: String,
    description: String


});

module.exports = mongoose.model('Location', LocationSchema)
let request = require('request')

let city = "Moskva"
let apiKey = "072a8103601effd90e9a0769f7280d6e"
let url = `http://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&appid=${apiKey}`
let testUrl = "http://api.openweathermap.org/data/2.5/weather?q=Moskva&units=metric&appid=072a8103601effd90e9a0769f7280d6e"
request(url, function(err, response, body){
    if(err){
        console.log("error: " + err)
    }
    else{
        let weather = JSON.parse(body)
        console.log(weather)

    }
})
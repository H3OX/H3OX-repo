let request = require('request')

let city = "Moskva"
let apiKey = "072a8103601effd90e9a0769f7280d6e"
let url = `http://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&appid=${apiKey}`

request(url, function(err, response, body){
    if(err) { console.log("error: " + err) }
    else {
        let weather = JSON.parse(body)
        let forecast = `City: ${weather.name} 
Temperature: ${Math.round(weather.main.temp)}°C
Pressure: ${weather.main.pressure} PSI
Humidity: ${weather.main.humidity}%
Wind speed: ${weather.wind.speed} Km/h
Sea level: ${weather.main.sea_level}m`
        console.log(forecast)
    }
})
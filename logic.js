const Telegraf = require('telegraf')
const request = require('request')
const token = '561442379:AAEvgdqOeUkybVNa199Q1XJSoh-I2IXR2Xs'
const bot = new Telegraf(token)
let city = 'Moscow,RU'
const apiKey = "072a8103601effd90e9a0769f7280d6e"
const url = `http://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&appid=${apiKey}`
bot.start(ctx => {return ctx.reply("Hello! This bot shows you current weather in Moscow.")})

console.log(url)
console.log("Bot started")

request(url, (err, res, body) => {
    if (err) console.log('Request error!')
    else {
        let weather = JSON.parse(body)
        bot.hears("weather", ctx => {
            return ctx.reply(`Current weather is:
        City: ${city}.
        Temperature: ${weather.main.temp} °C,
        Pressure: ${weather.main.pressure} PSI,
        Humidity: ${weather.main.humidity} %,
        Wind speed: ${weather.wind.speed} km/h`)
        })
    }
})
bot.startPolling()

/*const url = `https://api.openweathermap.org/data/2.5/forecast?q=${city}&units=metric&appid=${apiKey}`
for(let i=0; i<w.list.length; i++){
    console.log(w.list[i].main.temp)
}
*/


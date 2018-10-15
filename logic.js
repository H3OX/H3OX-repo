const Telegraf = require('telegraf')
const request = require('request')
const token = '561442379:AAEvgdqOeUkybVNa199Q1XJSoh-I2IXR2Xs'
const bot = new Telegraf(token)
const coordx = 55.753960
const coordy = 37.620393
const apikey = '7da57778334a1b3fe7e5990a67e0d167'
const url = `https://api.darksky.net/forecast/${apikey}/${coordx},${coordy}`
const inlineWeatherButton = [["Get weather!"]]
console.log(url)

bot.start(ctx => {
    return ctx.reply("Updated API shows more weather info")
})

request(url, (err, res, body) => {
    if(err) console.log(err)
    else {
        let d = JSON.parse(body)
        bot.on('text', ctx => {
            return ctx.reply(`
            Here is your weather:
        Timezone: ${d.timezone}
        ${d.currently.summary}
        Temperature: ${Math.round((72 - d.currently.temperature) / 2)} °C
        Humidity: ${d.currently.humidity * 100} %
        Pressure: ${d.currently.pressure} PSI
        Cloud cover: ${d.currently.cloudCover * 100} %
        UV index: ${d.currently.uvIndex} UVI
        Visibility: ${d.currently.visibility}
        Ozone: ${d.currently.ozone} DU
        `)
        })
    }
})

bot.startPolling()







const axios = require("axios")
const NetcatServer = require('netcat/server')

const nc = new NetcatServer()


const DATA_URL = "https://goquotes-api.herokuapp.com/api/v1/random?count=3"
const WAIT_INTERVAL = 2000;

// const interval = setInterval(() => {
//     axios.get(DATA_URL).then((response) => {
//         console.log(response.data.quotes)
//     })
// }, WAIT_INTERVAL)

// process.on("SIGINT", () => {
//     clearInterval(interval)
//     process.exit()
// })

nc.port(3000).serve("./diaf.txt").listen()

